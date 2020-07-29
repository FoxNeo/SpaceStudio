package de.spaceStudio.server.controller;

import com.google.gson.Gson;
import de.spaceStudio.server.model.FightState;
import de.spaceStudio.server.handler.MultiPlayerGame;
import de.spaceStudio.server.handler.SinglePlayerGame;
import de.spaceStudio.server.model.*;
import de.spaceStudio.server.repository.*;
import de.spaceStudio.server.utils.Global;
import de.spaceStudio.server.utils.JSONFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * <h1>Game Controller</h1>
 * The GameController class implements the single player and
 * multi player endpoints to create game sessions in server
 *
 * @author Miguel Caceres
 * Created: 7.7.2020
 * @version 1.0
 */
@RestController
public class GameControllerImpl implements GameController {

    @Autowired
    private WeaponController weaponController;

    /**
     * PlayerRepository Data
     */
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private WeaponRepository weaponRepository;

    @Autowired
    private StopAbstractRepository stopAbstractRepository;

    @Autowired
    private ActorStateRepository actorStateRepository;


    @Autowired
    private AIRepository aiRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private  SectionController sectionController;
    /**
     * Logger object
     */
    private static final Logger LOG = LoggerFactory.getLogger(GameControllerImpl.class);

    @Autowired
    ShipRepository shipRepository;

    @Autowired
    SectionRepository sectionRepository;
    private Optional<List<Weapon>> weaponList;

    /**
     * Init single game session in Server
     *
     * @param playerName
     * @param singlePlayerGame
     * @return HTTP Status
     */
    @Override
    @RequestMapping(value = "/game/start/single-player/{playerName}", method = RequestMethod.POST)
    @ResponseBody
    public String initSinglePlayerGame(@PathVariable("playerName") String playerName, @RequestBody SinglePlayerGame singlePlayerGame) {
        if (Global.userLogged.contains(playerName)) {
            LOG.info("Accepting request for player: " + playerName);
            Global.SinglePlayerGameSessions.put(playerName, singlePlayerGame);
            return HttpStatus.ACCEPTED.toString();
        } else {
            return HttpStatus.NOT_ACCEPTABLE.toString();
        }
    }

    /**
     * Remove single player sessions from Server
     *
     * @param playerName
     * @return HTTP status Accepted if success otherwise HTTP status Not Accepted
     */
    @Override
    @RequestMapping(value = "/game/destroy/single-player/{playerName}", method = RequestMethod.GET)
    @ResponseBody
    public String destroySinglePlayerGameSession(@PathVariable("playerName") String playerName) {
        if (Global.userLogged.contains(playerName) && (Global.SinglePlayerGameSessions.containsKey(playerName))) {
            Global.SinglePlayerGameSessions.remove(playerName);
            return HttpStatus.ACCEPTED.toString();
        } else {
            return HttpStatus.NOT_EXTENDED.toString();
        }
    }

    /**
     * Remove multi player sessions from Server
     *
     * @param sessionID
     * @return HTTP status Accepted if success otherwise HTTP status Not Accepted
     */
    @Override
    @RequestMapping(value = "/game/destroy/multiplayer/{sessionID}", method = RequestMethod.GET)
    @ResponseBody
    public String destroyMultiPlayerGameSession(@PathVariable("sessionID") String sessionID) {
        if (Global.MultiPlayerGameSessions.containsKey(sessionID)) {
            Global.MultiPlayerGameSessions.remove(sessionID);
            return HttpStatus.ACCEPTED.toString();
        } else {
            return HttpStatus.NOT_EXTENDED.toString();
        }
    }

    /**
     * Show all active single player game sessions
     *
     * @return JSON
     */
    @Override
    @RequestMapping(value = "/game/sessions/single-player", method = RequestMethod.GET)
    @ResponseBody
    public String getAllSinglePlayerSessions() {
        Gson gson = new Gson();
        String jsonString = gson.toJson(Global.SinglePlayerGameSessions);
        LOG.info(jsonString);
        return jsonString;
    }

    @Override
    @RequestMapping(value = "/game/multiplayer/synchronize/{gameSession}", method = RequestMethod.GET)
    @ResponseBody
    public String synchroMultiPlayer(@PathVariable("gameSession") String gameSession) {
        LOG.info("Ready up");
        MultiPlayerGame multiPlayerGame = Global.MultiPlayerGameSessions.get(gameSession);
        if (multiPlayerGame.getPlayerOne() != null && multiPlayerGame.getPlayerTwo() != null) {
            LOG.info("true");
            return "true";
        }
        return "false";
    }

    /**
     * Show all active multiplayer game sessions
     *
     * @return JSON
     */
    @Override
    @RequestMapping(value = "/game/sessions/multiplayer", method = RequestMethod.GET)
    @ResponseBody
    public String getAllMultiPlayerSessions() {
        Gson gson = new Gson();
        String jsonString = gson.toJson(Global.MultiPlayerGameSessions);
        LOG.info(jsonString);
        return jsonString;
    }


    /**
     * @return
     */
    @Override
    @RequestMapping(value = "/game/start/multiplayer", method = RequestMethod.POST)
    @ResponseBody
    public String initMultiPlayer(@RequestBody Player player) {
        if (Global.userLogged.contains(player.getName())) {
            LOG.info("Creating multiplayer room...");
            MultiPlayerGame mult = new MultiPlayerGame();
            Global.usersMultiPlayer.add(player.getName());
            if (Global.MultiPlayerGameSessions.isEmpty()) {
                mult.setPlayerOne(player);
                Global.MultiPlayerGameSessions.put(UUID.randomUUID().toString(), mult);
            }
            return HttpStatus.ACCEPTED.toString();
            /*
            int counter = 0;

            for (Map.Entry<String, MultiPlayerGame> findMap : Global.MultiPlayerGameSessions.entrySet()) {
                if (!findMap.getValue().getPlayerOne().equals(mult.getPlayerOne()) || !findMap.getValue().getPlayerTwo().equals(mult.getPlayerTwo())) {
                    if (counter < 1) {
                        Global.MultiPlayerGameSessions.put(UUID.randomUUID().toString(), mult);
                        counter++;
                    }
                }
            }
            if (counter == 1) {
                return HttpStatus.ACCEPTED.toString();
            }
            */
        }
        return HttpStatus.NOT_ACCEPTABLE.toString();
    }

    /**
     * This method is used to get the session room to join other players
     *
     * @return String This returns the UUID to find current session
     */
    @Override
    @RequestMapping(value = "/game/multiplayer/room", method = RequestMethod.GET)
    @ResponseBody
    public String checkMultiPlayerRoom() {
        if (!Global.MultiPlayerGameSessions.isEmpty()) {
            Map.Entry<String, MultiPlayerGame> entry = Global.MultiPlayerGameSessions.entrySet().iterator().next();
            return entry.getKey();
        } else {
            return "";
        }
    }

    /**
     * @param gameSession
     * @param player
     * @return
     */
    @Override
    @RequestMapping(value = "/game/multiplayer/{sessionID}", method = RequestMethod.POST)
    @ResponseBody
    public String joinMultiplayerSession(@PathVariable("sessionID") String gameSession, @RequestBody Player player) {
        if (gameSession != null || !gameSession.isEmpty()) {
            MultiPlayerGame mult = Global.MultiPlayerGameSessions.get(gameSession);
            if (mult != null && !mult.getPlayerOne().getName().equals(player.getName())) {
                mult.setPlayerTwo(player);
                Global.MultiPlayerGameSessions.replace(gameSession, mult);
                LOG.info("Player 2 success join room");
            }
            return HttpStatus.ACCEPTED.toString();
        }
        return "";
    }

    @Override
    public String destroyMultiPlayerSession() {
        return null;
    }

    /**
     * Saves single game in Server
     *
     * @param playerName
     * @param singlePlayerGame
     * @return HTTP ACCEPTED Status if success, otherwise HTTP NOT ACCEPTED status
     */
    @Override
    @RequestMapping(value = "/game/save/{playerName}", method = RequestMethod.POST)
    @ResponseBody
    public String saveGame(@PathVariable("playerName") String playerName, @RequestBody SinglePlayerGame singlePlayerGame) {
        if (Global.userLogged.contains(playerName) && Global.SinglePlayerGameSessions.get(playerName) != null) {
            LOG.info("Accepting save request for player: " + playerName);
            SinglePlayerGame sg = singlePlayerGame;//Global.SinglePlayerGameSessions.get(playerName);
            Optional<Player> fetchPlayer = playerRepository.findByName(playerName);
            if (fetchPlayer != null && fetchPlayer.isPresent()) {
                Player playerToUpdate = fetchPlayer.get();
                // Overwriting JSON file
                if (playerToUpdate.getSavedGame() != null) {
                    JSONFile.cleanJSONSinglePlayerGame(playerToUpdate.getSavedGame());
                    LOG.info("Overwriting save file");
                }
                String storeGamePath = JSONFile.exportJSON(sg);
                playerToUpdate.setSavedGame(storeGamePath);
                playerRepository.save(playerToUpdate);
                LOG.info("Success stored: " + storeGamePath);
            }
            return HttpStatus.ACCEPTED.toString();
        } else {
            return HttpStatus.NOT_ACCEPTABLE.toString();
        }

    }

    /**
     * Load the single player game
     * Extern JSON will loaded
     *
     * @param playerName
     * @return SinglePlayer object
     */
    @Override
    @RequestMapping(value = "/game/load/{playerName}", method = RequestMethod.GET)
    @ResponseBody
    public SinglePlayerGame loadGame(@PathVariable("playerName") String playerName) {
        if (Global.userLogged.contains(playerName)) {
            Optional<Player> fetchPlayer = playerRepository.findByName(playerName);
            if (fetchPlayer.isPresent()) {
                Player loadPlayerData = fetchPlayer.get();
                SinglePlayerGame sg = JSONFile.importJSONSinglePlayerGame(loadPlayerData.getSavedGame());
                Global.SinglePlayerGameSessions.put(loadPlayerData.getName(), sg);
                LOG.info("Game successful loaded: " + loadPlayerData.getName());
                return sg;
            }
        }
        return null;
    }

    /**
     * Gets the player's game current status
     *
     * @param playerName
     * @return SinglePlayerGame as JSON
     */
    @Override
    @RequestMapping(value = "/game/get/single-player/{playerName}", method = RequestMethod.GET)
    @ResponseBody
    public SinglePlayerGame getSinglePlayerGame(@PathVariable("playerName") String playerName) {
        LOG.info("getting single player data for player " + playerName);
        return Global.SinglePlayerGameSessions.get(playerName);
    }


    /**
     * This function is temporal in use to logout user from game
     *
     * @return
     */
    @Override
    @RequestMapping(value = "/game/multiplayer/unjoin", method = RequestMethod.POST)
    public void unjoinMultiPlayerUser(@RequestBody Player player) {
        Global.usersMultiPlayer.remove(player.getName());
    }

    /**
     * Player wants to end Round
     * @param pPlayer who wants to end his round
     * @return the Ship of the Player who has ended the Round
     */
    @Override
    public Ship endFightRound(Player pPlayer, String session) {


        // TODO add Online
        Optional<Player> player = playerRepository.findById(pPlayer.getId());
        if (player.isPresent()  && player.get().getState().getFightState().equals(FightState.WAITING_FOR_TURN)) {

                Optional<Ship> ship = shipRepository.findByOwner(pPlayer);
                if (ship.isPresent()) {

                    // TODO if is online
                    actorFight(ship.get(), session);
                    actorChangePower(ship.get());

                    List<Section> sectionsOfPlayer = sectionController.sectionsByShip(ship.get().getId());
                    List<Weapon> playerOfWeapons = new ArrayList<>();
                    for (Section s :
                            sectionsOfPlayer) {
                        playerOfWeapons.addAll(weaponRepository.findBySection(s).orElse(new ArrayList<>()));
                    }

                    lowerWarmUpTime(playerOfWeapons);
                    return shipRepository.findById(ship.get().getId()).get();
                }

        }
        return shipRepository.findByOwner(pPlayer).get();

    }

    private void roundStateNext() {
    }

    /**
     * If the Weapon Section is dammaged. Divert Energy to the Weapon Section
     * @param ship where the Actor is chaning Power
     */
    private void actorChangePower(Ship ship) {
        Optional<List<Section>> sections = sectionRepository.findAllByShip(ship);
        if (sections.isPresent()) {
            for (Section s :
                    sections.get()) {
                if (s.getSectionTyp().equals(SectionTyp.WEAPONS)) {
                    if (s.getPowerCurrent() * 2 <= s.getPowerRequired()) {
                        increasePower(s, (int) (s.getPowerRequired() * 0.2));  // Increase by 20%
                    }
                }
            }
        }
    }

    @Override
    public Section increasePower(Section pSection, int amount) {

        Optional<Section> section = sectionRepository.findById(pSection.getId());
        if (section.isPresent()) {
            Optional<List<Section>> sections = sectionRepository.findAllByShip(section.get().getShip());
            Ship ship = section.get().getShip();
            if (sections.isPresent() && sumCurrentPower(ship) + amount > sumRequiredPower(ship)) {
                sections.get().remove(section.get());
                Optional<Section> removePowerSection = Optional.ofNullable(sections.get().get(0));
                removePowerSection.ifPresent(value -> value.setPowerCurrent(value.getPowerCurrent() - amount));
            }

            section.get().setPowerCurrent(section.get().getPowerCurrent() + amount);
            sectionRepository.save(section.get());


        return section.get();
        } else return pSection;
    }

    @Override
    @GetMapping(value = "/game/canFight/{session}")
    public FightState canFight(@RequestBody Actor pActor , @PathVariable String session) {
        boolean canFight = isCanFight(pActor, session);

        return (canFight ?  FightState.PLAYING : FightState.WAITING_FOR_TURN);
    }

    @Override
    public String startFight(Actor pActor, String session) {
        boolean canFight = isCanFight(pActor, session);
        Optional<Actor> actor = actorRepository.findById(pActor.getId());

        if (canFight && actor.isPresent()) {
            actor.get().getState().setFightState(FightState.PLAYING);
            actorStateRepository.save(actor.get().getState());
            return HttpStatus.ACCEPTED.toString();
        } else {
            return HttpStatus.BAD_REQUEST.toString();
        }

    }

    @Override
    public FightState getFightState(Actor pActor) {
       Optional<Actor> actor = actorRepository.findById(pActor.getId());
        return actor.map(value -> value.getState().getFightState()).orElse(null);
    }

    @Override
    public FightState setFightState(Actor pActor) {
        Optional<Actor> actor = actorRepository.findById(pActor.getId());
        if (actor.isPresent() && !pActor.getState().getFightState().equals(actor.get().getState().getFightState())) {
            if (actor.get().getState().getFightState().equals(FightState.WAITING_FOR_TURN)) {
                actor.get().getState().setFightState(FightState.PLAYING);
            } else {
                actor.get().getState().setFightState(FightState.WAITING_FOR_TURN);
            }
            // FIXME set the other to to the oppsite State
            actorStateRepository.save(actor.get().getState());
            return actor.get().getState().getFightState();
        } else throw new IllegalStateException(String.format("The state (%s) is identical with the Server", pActor.getState().getFightState()));
    }

    public void lowerWarmUpTime(List<Weapon> weapons) {
       for (Weapon w :
               weapons) {
           if (w.getWarmUp() != 0) {
               w.setWarmUp(w.getWarmUp() - 1);
           } else {
               if (w.getWarmUp() == 0 && w.getCurrentBullets() != w.getMagazineSize()) {
                   w.setWarmUp(w.getWarmUpTime());
               }
           }
           weaponRepository.save(w);
       }
   }


    /**
     * Can the Actor Fight
     * @param pActor who wants to fight
     * @param session of pActor
     * @return if the actor can Fight
     */
    private boolean isCanFight(Actor pActor, String session) {
        Optional<Actor> actor = actorRepository.findById(pActor.getId());
        MultiPlayerGame game = Global.MultiPlayerGameSessions.get(session);

        boolean canFight = false;
        boolean someOneFighting = false;

        if (actor.isPresent()) {

            // Break  and return false if a actor from the game is Playing
            for (Actor a :
                    game.players) {
                if (a.getState().getFightState().equals(FightState.PLAYING)) {
                    someOneFighting = true;
                    break;
                }
            }
        }
        canFight = !someOneFighting;
        return canFight;
    }


    /**
     * Sum the current Energy of the Ship
     * @param s is the Ship
     * @return current energy required
     */
    @Override
    public int sumCurrentPower(Ship s) {
        Optional<List<Section>> sections = sectionRepository.findAllByShip(s);
        return sections.map(sectionList -> sectionList.stream()
                .mapToInt(Section::getPowerCurrent)
                .sum()).orElse(0);
    }

    /**
     * Sum the required Power for the Ship
     * @param s is the Ship
     * @return the sum of the required Power
     */
    @Override
    public int sumRequiredPower(Ship s) {
        Optional<List<Section>> sections = sectionRepository.findAllByShip(s);
        return sections.map(sectionList -> sectionList.stream()
                .mapToInt(Section::getPowerRequired)
                .sum()).orElse(0);
    }


    @Override
    @GetMapping(value = "/game/fight/{session}")
    public Optional<Ship> actorFight(@RequestBody Ship playerShip, @PathVariable String session) {

        // Get the AI Ship, Section and Weapons
        AI ai =  aiRepository.findById(Global.SinglePlayerGameSessions.get(session).getAi().getId()).get();
        Optional<Ship> ship = shipRepository.findById(playerShip.getId());
        Optional<Ship> aiShip = shipRepository.findByOwner(ai);
        if (ship.isPresent() && aiShip.isPresent()  && ai.getState().getFightState().equals(FightState.WAITING_FOR_TURN)) {  // AI and Player are Waiting
        Optional<List<Section>> aiSection = sectionRepository.findAllByShip(aiShip.get());

        // Player Ship from DB
            Optional<List<Section>> sectionList = sectionRepository.findAllByShip(ship.get());
            if (sectionList.isPresent() && aiSection.isPresent()) {
                // Figure out which Sections to attack
                List<Section> xs = new ArrayList<>();
                for (Section s :
                        sectionList.get ()) {
                    if (s.isUsable())
                        xs.add(s);
                }

                ai.getState().setFightState(FightState.PLAYING);


                // Attack a random section of the ones working
                int random = (int) (Math.random() * xs.size());
                Section attackSection = xs.get(random);

                // Add all AI Weapons to attackWeapons
                List<Weapon> attackWeapons = new ArrayList<>();
                for (Section s :
                        aiSection.get()) {
                    weaponList = weaponRepository.findBySection(s);
                    weaponList.ifPresent(attackWeapons::addAll);
                }

                // Select Target for all Weapons
                attackWeapons.forEach(w -> w.setObjectiv(attackSection));

                // Test if it is possible to fire the each Weapon
                List<Boolean> shots;
                // Shot at the Player as long as it is possible to fire
                do {
                    shots = weaponController.shotValidation(attackWeapons);
                    List<Weapon> weaponsWhichCanFire = new ArrayList<>();
                    // Fire each Weapon which can Shot
                    for (int i = 0; i < shots.size(); i++) {
                        if (shots.get(i)) {
                            weaponsWhichCanFire.add(attackWeapons.get(i)); // Get Value then index i
                        }
                        // Fire
                        weaponController.fire(weaponsWhichCanFire); // fire saves the dammaged Sections
                    }
                }
                while (shots.contains(true));
                ai.getState().setFightState(FightState.WAITING_FOR_TURN);
                aiRepository.save(ai);
            }
        } else {
            LOG.error("Could not exceute AI Fight");
        }
        return shipRepository.findById(playerShip.getId());
    }

}