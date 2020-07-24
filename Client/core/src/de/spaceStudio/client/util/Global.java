package de.spaceStudio.client.util;

import de.spaceStudio.server.handler.SinglePlayerGame;
import de.spaceStudio.server.model.*;

import java.util.*;

/**
 * This class contains global variables, they can be access in the whole project
 *
 * @author Miguel Caceres
 * created on 6.17.2020
 */
public  class Global {


    public static final String WEAPONS = "weapons" ;
    public static final String SECTIONS = "sections";
    public static final String CREWMEMBERS = "crewMembers";
    /**
     * boolean value for single player disable lobby
     */
    public static boolean IS_SINGLE_PLAYER = false;

    /**
     * @return true if level easy
     */
    public static boolean ISEASY = false;
    /**
     * Hardcoded server URL
     */
    public static final String SERVER_URL = "http://localhost:8080";

    /**
     * Server player endpoint
     */
    public static final String PLAYER_ENDPOINT = "/player";

    /**
     * Server logged player endpoint
     */
    public static final String PLAYER_LOGGED_ENDPOINT = "/player/logged-players";

    /**
     * Server logged player endpoint
     */
    public static final String NAME_VALIDATION = "/shipname";
    /**
     * ENd point Combat
     */
    public static final String MAKE_SHOT_VALIDATION = "/fire";
    /**
     * ENd point Combat
     */
    public static final String SHOT_VALIDATION_VALIDATION = "/shotvalidation";

    /**
     * ENd point Combat
     */
    public static final String ASK_FOR_SHIP = "/ship";
    /**
     * Server logged player endpoint
     */
    public static final String AI_CREATION_ENDPOINT = "/AI";
    /**
     * Server logged player endpoint
     */
    public static final String AIS_CREATION_ENDPOINT = "/AIs";
    /**
     * Server login endpoint
     */
    public static final String PLAYER_LOGIN_ENDPOINT = "/player/login";

    /**
     * Server logout endpoint
     */
    public static final String PLAYER_LOGOUT_ENDPOINT = "/player/logout";

    /**
     * Ship Cretion
     */
    public static final String SHIP_ENDPOINT = "/ship";
    /**
     * Ship Cretion
     */
    public static final String SHIPS_CREATION_ENDPOINT = "/shipstoadd";
    /**
     * Crew Cretion
     */
    public static final String CREWMEMBER_CREATION_ENDPOINT = "/crewMember";
    /**
     * Crew Cretion
     */
    public static final String WEAPON_CREATION_ENDPOINT = "/weapon";

    /**
     * Planet Cretion
     */
    public static final String PLANET_CREATION_ENDPOINT = "/planet";
    /**
     * Planet Cretion
     */
    public static final String PLANETS_CREATION_ENDPOINT = "/listplanet";
    /**
     * Planet Cretion
     */
    public static final String STATIONS_CREATION_ENDPOINT = "/liststation";
    /**
     * Planet Cretion
     */
    public static final String RESSOURCES_SHOP_CREATION_ENDPOINT = "/listressourcen";
    /**
     * Planet Cretion
     */
    public static final String RESSOURCE_SHOP_CREATION_ENDPOINT = "/shopressource";
    /**
     * Planet Cretion
     */
    public static final String STATION_CREATION_ENDPOINT = "/station";

    /**
     * Universe Cretion
     */
    public static final String UNIVERSE_CREATION_ENDPOINT = "/universe";
    /**
     * Section Cretion
     */
    public static final String SECTION_CREATION_ENDPOINT = "/section";
    /**
     * Section Cretion
     */
    public static final String SECTIONS_CREATION_ENDPOINT = "/sectiontoadd";
    /**
     * Section Cretion
     */
    public static final String CREWMEMBERS_CREATION_ENDPOINT = "/crewmemberstoadd";
    /**
     * Planet Cretion
     */
    public static final String RESSOURCE_SHIP_CREATION_ENDPOINT = "/shipressource";
    /**
     * Planet Cretion
     */
    public static final String WEAPONS_SHIP_CREATION_ENDPOINT = "/listweapons";
    /**
     * Player load game endpoint
     */
    public static final String PLAYER_CONTINUE_ENDPOINT = "/game/load/";

    /**
     * Player save game endpoint
     */
    public static final String PLAYER_SAVE_GAME = "/game/save/";
    /**
     * Player save game endpoint
     */
    public static final String SHIP_RESSORUCE_ENDPOINT = "/shipressource";
    /**
     * Player save game endpoint
     */
    public static final String GET_RESSOURCE_BY_SHIP = "/shipressourcebyship";
    /**
     * Player save game endpoint
     */
    public static final String GET_RESSOURCE_BY_STOP = "/getshopressourcebystop";
    /**
     * Player save game endpoint
     */
    public static final String BUY_RESSOURCE = "/buyitem";
    /**
     * Global player, this data will be downloaded from server at login
     */
    public static Player currentPlayer;
    /**
     * Global player, this data will be downloaded from server at login
     */
    public static Actor currentGegner;
    /**
     * Global player, this data will be downloaded from server at login
     */
    public static Ship currentShipGegner;
    /**
     * Global player, this data will be downloaded from server at login
     */
    public static Ship currentShipPlayer;
    /**
     * Global player, this data will be downloaded from server at login
     */
    public static StopAbstract currentStop;
    /**
     * Global player, this data will be downloaded from server at login
     */
    public static Universe currentUniverse;
    /**
     * Current Ressourcen Player
     */
    public static ShipRessource currentshipressourcen;
    /**
     * Global player, this data will be downloaded from server at login
     */
    public static Weapon currentWeapon;
    /**
     * Server logged player endpoint
     */
    public static final String MAKEJUMP_CREATION_ENDPOINT = "/makejump";
    /**
     * Server logged player endpoint
     */
    public static final String PLAYER_CLEAN_ENDPOINT = "/cleanuser";

    /**
     * Gets all Users
     */
    public static List<String> playersOnline = new ArrayList<>();

    /**
     * Default is onlineGame false
     */
    public static boolean isOnlineGame = false;



    public static SinglePlayerGame singlePlayerGame;

    /**
     * Ship Variables
     */
    public static Ship ship0= Ship.shipBluider().hp(300).shipForm(ShipForm.SHIP1).name("ship0").power(10).shield(1).buildShip();
    public static Ship ship1= Ship.shipBluider().hp(100).shipForm(ShipForm.SHIP2).name("ship1").power(100).shield(1).buildShip();
    public static Ship ship2= Ship.shipBluider().hp(200).shipForm(ShipForm.SHIP3).name("ship2").power(50).shield(2).buildShip();
    public static Ship ship3= Ship.shipBluider().hp(300).shipForm(ShipForm.SHIP4).name("ship3").power(200).shield(1).buildShip();


    /**
     * CrewMember Variables
     */
    public static CrewMember crewMember0= CrewMember.crewMemberBuilder().health(100)
            .img("Robot").role(Role.FIGHTER).buildCrewMember();
    public static CrewMember crewMember1= CrewMember.crewMemberBuilder().health(200).
            img("Human").role(Role.TECHNICIAN).buildCrewMember();
    public static CrewMember crewMember2= CrewMember.crewMemberBuilder().health(300).
            img("Batman").role(Role.FIGHTER).buildCrewMember();

    public static List<CrewMember> crewMemberList=new ArrayList<CrewMember>(){{
        add(crewMember0);
        add(crewMember1);
        add(crewMember2);
    }};
    public static boolean allReady = false;  // FIXME change to true when all Player will jump
    public static int currentStopNumber = 0;
    public static HashMap<Integer, List<Section>> combatSections = new HashMap<>();
    public static HashMap<Integer, List<Weapon>> combatWeapons = new HashMap<>();
    public static HashMap<Integer, List<CrewMember>> combatCrew = new HashMap<>();

    public static void updateVariableCrewMembersPlayer(){
        crewMember0=crewMemberList.get(0);
        crewMember1=crewMemberList.get(1);
        crewMember2=crewMemberList.get(2);
    }
    /**
     * Sections Variables
     */

     private static Map<Integer, List<Pair>> getPos() {

         var res = new HashMap<Integer, List<Pair>>();



            List<Pair> pairs = new ArrayList<>();
            pairs.add(new Pair(124f, 90f));
            pairs.add(new Pair(0f, 293f));  // Fehlt
            pairs.add(new Pair(647f, 307f)); // Fehlt
            pairs.add(new Pair(320f, 210f));
            pairs.add(new Pair(646f, 461f)); // Fehlt
            pairs.add(new Pair(336f, 240f));

            res.put(0, pairs);

            return res;
     }

    public static Section section1=Section
            .sectionBuilder()
            .img("Section1")
            .oxygen(100)
            .powerCurrent(100)
            .sectionTyp(SectionTyp.DRIVE)
            .usable(true)
            .connectingTo(null)
            .powerRequired(10)
            .pos(getPos().get(0).get(0).getLeft(), getPos().get(0).get(0).getRight())
            .buildSection();
    public static Section section2= Section
            .sectionBuilder()
            .sectionTyp(SectionTyp.WEAPONS)
            .img("Section2")
            .oxygen(100).
            powerCurrent(100)
            .usable(true)
            .connectingTo(null)
            .powerRequired(10)
            .pos(getPos().get(0).get(1).getLeft(), getPos().get(0).get(1).getRight())
            .buildSection();
    public static Section section3= Section
            .sectionBuilder()
            .img("Section3")
            .sectionTyp(SectionTyp.NORMAL)
            .oxygen(100)
            .powerCurrent(100)
            .usable(true)
            .connectingTo(null)
            .pos(getPos().get(0).get(2).getLeft(), getPos().get(0).get(2).getRight())
            .powerRequired(10)
            .buildSection();
    public static Section section4= Section
            .sectionBuilder()
            .sectionTyp(SectionTyp.NORMAL)
            .img("Section4").oxygen(100).
            powerCurrent(100)
            .usable(true)
            .connectingTo(null)
            .pos(getPos().get(0).get(3).getLeft(), getPos().get(0).get(3).getRight())
            .powerRequired(10)
            .buildSection();
    public static Section section5= Section
            .sectionBuilder()
            .sectionTyp(SectionTyp.NORMAL)
            .img("Section5")
            .oxygen(100)
            .powerCurrent(100)
            .usable(true)
            .connectingTo(null)
            .powerRequired(10)
            .pos(getPos().get(0).get(4).getLeft(), getPos().get(0).get(4).getRight())
            .buildSection();
    public static Section section6 = Section
            .sectionBuilder()
            .sectionTyp(SectionTyp.NORMAL)
            .img("Section6")
            .oxygen(100).
                    powerCurrent(100)
            .usable(true)
            .connectingTo(null)
            .powerRequired(10)
            .pos(getPos().get(0).get(5).getLeft(), getPos().get(0).get(5).getRight())
            .buildSection();

    public  static List<Section> sectionsPlayerList = new ArrayList<Section>() {{
        add(section1);
        add(section2);
        add(section3);
        add(section4);
        add(section5);
        add(section6);
    }};
    public static void updateVariableSectionShipPlayer(){
        section1= sectionsPlayerList.get(0);
        section2= sectionsPlayerList.get(1);
        section3= sectionsPlayerList.get(2);
        section4= sectionsPlayerList.get(3);
        section5= sectionsPlayerList.get(4);
        section6= sectionsPlayerList.get(5);
    }
    /*
     * Gegner
     * */
    public static AI ai1 = AI.builderAI().name("gegner1").buildAI();
    public static AI ai2 = AI.builderAI().name("gegner2").buildAI();

    public static AI ai3 = AI.builderAI().name("gegner3").buildAI();
    public static AI ai4 = AI.builderAI().name("gegner4").buildAI();
    public static AI ai5 = AI.builderAI().name("gegner5").buildAI();
    public static AI ai6 = AI.builderAI().name("gegner6").buildAI();



    public static List<AI> aisU2=new ArrayList<AI>(){{
        add(ai1);
        add(ai2);
        add(ai3);
        add(ai4);
        add(ai5);
        add(ai6);
    }};
    public static void updateVariableaiu2(){
        ai1=aisU2.get(0);
        ai2=aisU2.get(1);
        ai3=aisU2.get(2);
        ai4=aisU2.get(3);
        ai5=aisU2.get(4);
        ai6=aisU2.get(5);
    }

    private static long rocketCoolDown = 4000l;
    private static long lasserCoolDown = 4000l;
    /*
     * Weapon
     * */
    public static Weapon weapon1Player = Weapon.WeaponBuilder().damage(10).hitRate(100).img("Image1").name("Rocket Left").coolDown(rocketCoolDown).build();

    public static Weapon weapon2Player = Weapon.WeaponBuilder().damage(30).hitRate(300).img("Image1").name("Lasser Right").coolDown(lasserCoolDown).build();
    public static List<Weapon> weaponListPlayer = new ArrayList<Weapon>(){{
        add(weapon1Player);
        add(weapon2Player);
    }};
    public static void updateweaponPlayerVariabel(){
        weapon1Player= weaponListPlayer.get(0);
        weapon2Player= weaponListPlayer.get(1);
    }
    public static void actualiziertweaponListPlayer(){
        List<Weapon> newWeaponListPlayer = new ArrayList<Weapon>(){{
            add(weapon1Player);
            add(weapon2Player);
        }};
        weaponListPlayer=newWeaponListPlayer;
    }
    public static void actualizierungSectionInWeapons(){
        weapon1Player.setSection(section2);
        weapon2Player.setSection(section2);
        actualiziertweaponListPlayer();
    }

    /*
     * Weapon Gegner1
     * */
    public static Weapon weapon1Gegner1 = Weapon.WeaponBuilder().damage(10).hitRate(100).img("Image1").name("Rocket Left").coolDown(rocketCoolDown).build();

    public static Weapon weapon2Gegner1 = Weapon.WeaponBuilder().damage(10).hitRate(100).img("Image1").name("Rocket Left").coolDown(rocketCoolDown).build();
    public static List<Weapon> weaponListGegner1 = new ArrayList<Weapon>(){{
        add(weapon1Gegner1);
        add(weapon2Gegner1);
    }};
    public static void updateweaponGegner1Variabel(){
        weapon1Gegner1= weaponListGegner1.get(0);
        weapon2Gegner1= weaponListGegner1.get(1);
    }
    public static void actualiziertweaponListGegner1(){
        List<Weapon> newweaponListGegner1 = new ArrayList<Weapon>(){{
            add(weapon1Gegner1);
            add(weapon2Gegner1);
        }};
        weaponListGegner1=newweaponListGegner1;
    }
    /*
    * Weapons Gegner2
    * */
    public static Weapon weapon1Gegner2 = Weapon.WeaponBuilder().damage(10).hitRate(100).img("Image1").name("Rocket Left").coolDown(rocketCoolDown).build();

    public static Weapon weapon2Gegner2 = Weapon.WeaponBuilder().damage(10).hitRate(100).img("Image1").name("Rocket Left").coolDown(rocketCoolDown).build();
    public static List<Weapon> weaponListGegner2 = new ArrayList<Weapon>(){{
        add(weapon1Gegner2);
        add(weapon2Gegner2);
    }};
    public static void updateweaponGegner2Variabel(){
        weapon1Gegner2= weaponListGegner2.get(0);
        weapon2Gegner2= weaponListGegner2.get(1);
    }
    public static void actualiziertweaponListGegner2(){
        List<Weapon> newweaponListGegner2 = new ArrayList<Weapon>(){{
            add(weapon1Gegner2);
            add(weapon2Gegner2);
        }};
        weaponListGegner2=newweaponListGegner2;
    }
    /*
     * Weapons Gegner3
     * */
    public static Weapon weapon1Gegner3 = Weapon.WeaponBuilder().damage(10).hitRate(100).img("Image1").name("Rocket Left").coolDown(rocketCoolDown).build();

    public static Weapon weapon2Gegner3 = Weapon.WeaponBuilder().damage(10).hitRate(100).img("Image1").name("Rocket Left").coolDown(rocketCoolDown).build();
    public static List<Weapon> weaponListGegner3 = new ArrayList<Weapon>(){{
        add(weapon1Gegner3);
        add(weapon2Gegner3);
    }};
    public static void updateweaponGegner3Variabel(){
        weapon1Gegner3= weaponListGegner3.get(0);
        weapon2Gegner3= weaponListGegner3.get(1);
    }
    public static void actualiziertweaponListGegner3(){
        List<Weapon> newweaponListGegner3 = new ArrayList<Weapon>(){{
            add(weapon1Gegner3);
            add(weapon2Gegner3);
        }};
        weaponListGegner3=newweaponListGegner3;
    }
    /*
     * Weapons Gegner4
     * */
    public static Weapon weapon1Gegner4 = Weapon.WeaponBuilder().damage(10).hitRate(100).img("Image1").name("Rocket Left").coolDown(rocketCoolDown).build();

    public static Weapon weapon2Gegner4 = Weapon.WeaponBuilder().damage(10).hitRate(100).img("Image1").name("Rocket Left").coolDown(rocketCoolDown).build();
    public static List<Weapon> weaponListGegner4 = new ArrayList<Weapon>(){{
        add(weapon1Gegner4);
        add(weapon2Gegner4);
    }};
    public static void updateweaponGegner4Variabel(){
        weapon1Gegner4= weaponListGegner4.get(0);
        weapon2Gegner4= weaponListGegner4.get(1);
    }
    public static void actualiziertweaponListGegner4(){
        List<Weapon> newweaponListGegner4 = new ArrayList<Weapon>(){{
            add(weapon1Gegner4);
            add(weapon2Gegner4);
        }};
        weaponListGegner4=newweaponListGegner4;
    }
    /*
     * Weapons Gegner3
     * */
    public static Weapon weapon1Gegner5 = Weapon.WeaponBuilder().damage(10).hitRate(100).img("Image1").name("Rocket Left").coolDown(rocketCoolDown).build();

    public static Weapon weapon2Gegner5 = Weapon.WeaponBuilder().damage(10).hitRate(100).img("Image1").name("Rocket Left").coolDown(rocketCoolDown).build();
    public static List<Weapon> weaponListGegner5 = new ArrayList<Weapon>(){{
        add(weapon1Gegner5);
        add(weapon2Gegner5);
    }};
    public static void updateweaponGegner5Variabel(){
        weapon1Gegner5= weaponListGegner5.get(0);
        weapon2Gegner5= weaponListGegner5.get(1);
    }
    public static void actualiziertweaponListGegner5(){

        List<Weapon> newweaponListGegner5 = new ArrayList<Weapon>(){{
            add(weapon1Gegner5);
            add(weapon2Gegner5);
        }};
        weaponListGegner5=newweaponListGegner5;
    }
    /*
     * Weapons Gegner6
     * */
    public static Weapon weapon1Gegner6 = Weapon.WeaponBuilder().damage(50).hitRate(100).img("Image1").name("Rocket Left").coolDown(rocketCoolDown).build();

    public static Weapon weapon2Gegner6 = Weapon.WeaponBuilder().damage(50).hitRate(100).img("Image1").name("Rocket Left").coolDown(rocketCoolDown).build();
    public static List<Weapon> weaponListGegner6 = new ArrayList<Weapon>(){{
        add(weapon1Gegner6);
        add(weapon2Gegner6);
    }};
    public static void updateweaponGegner6Variabel(){
        weapon1Gegner6= weaponListGegner6.get(0);
        weapon2Gegner6= weaponListGegner6.get(1);
    }
    public static void actualiziertweaponListGegner6(){
        List<Weapon> newweaponListGegner6 = new ArrayList<Weapon>(){{
            add(weapon1Gegner6);
            add(weapon2Gegner6);
        }};
        weaponListGegner6=newweaponListGegner6;
    }

    /*Weapon Universe2*/

    public static List<Weapon> weaponListUniverse2 = new ArrayList<Weapon>(){{
        add(weapon1Player);
        add(weapon2Player);
        add(weapon1Gegner1);
        add(weapon2Gegner1);
        add(weapon1Gegner2);
        add(weapon2Gegner2);
        add(weapon1Gegner3);
        add(weapon2Gegner3);
        add(weapon1Gegner4);
        add(weapon2Gegner4);
        add(weapon1Gegner5);
        add(weapon2Gegner5);
        add(weapon1Gegner6);
        add(weapon2Gegner6);
    }};
    public static void updateweaponVariabelUniverse2(){
        weapon1Player= weaponListUniverse2.get(0);
        weapon2Player= weaponListUniverse2.get(1);
        weapon1Gegner1=weaponListUniverse2.get(2);
        weapon2Gegner2=weaponListUniverse2.get(3);
        weapon1Gegner2=weaponListUniverse2.get(4);
        weapon2Gegner2=weaponListUniverse2.get(5);
        weapon1Gegner3=weaponListUniverse2.get(6);
        weapon2Gegner3=weaponListUniverse2.get(7);
        weapon1Gegner4=weaponListUniverse2.get(8);
        weapon2Gegner4=weaponListUniverse2.get(9);
        weapon1Gegner5=weaponListUniverse2.get(10);
        weapon2Gegner5=weaponListUniverse2.get(11);
        weapon1Gegner6=weaponListUniverse2.get(12);
        weapon2Gegner6=weaponListUniverse2.get(13);
    }
    public static void aktualizierenweaponListUniverse2(){
        weapon1Player.setSection(section2);
        weapon2Player.setSection(section2);
        weapon1Gegner1.setSection(section3Gegner);
        weapon2Gegner1.setSection(section3Gegner);
        weapon1Gegner2.setSection(section3Gegner2);
        weapon2Gegner2.setSection(section3Gegner2);
        weapon1Gegner3.setSection(section3Gegner3);
        weapon2Gegner3.setSection(section3Gegner3);
        weapon1Gegner4.setSection(section3Gegner4);
        weapon2Gegner4.setSection(section3Gegner4);
        weapon1Gegner5.setSection(section3Gegner5);
        weapon2Gegner5.setSection(section3Gegner5);
        weapon1Gegner6.setSection(section3Gegner6);
        weapon2Gegner6.setSection(section3Gegner6);
        List<Weapon> newweaponListUniverse2 = new ArrayList<Weapon>(){{
            add(weapon1Player);
            add(weapon2Player);
            add(weapon1Gegner1);
            add(weapon2Gegner1);
            add(weapon1Gegner2);
            add(weapon2Gegner2);
            add(weapon1Gegner3);
            add(weapon2Gegner3);
            add(weapon1Gegner4);
            add(weapon2Gegner4);
            add(weapon1Gegner5);
            add(weapon2Gegner5);
            add(weapon1Gegner6);
            add(weapon2Gegner6);
        }};
        weaponListUniverse2=newweaponListUniverse2;
    }
    /*
    Gegner Ship
     */
    public static Ship shipGegner1 = Ship.shipBluider().hp(100).
            power(100).shield(1).
            name("Shipgegner1").owner(ai1).
            buildShip();

    public static Ship shipGegner2 = Ship.shipBluider().hp(100).
            power(100).shield(1).
            name("Shipgegner2").owner(ai2).
            buildShip();
    public static Ship shipGegner3 = Ship.shipBluider().hp(100).
            power(100).shield(1).
            name("Shipgegner3").owner(ai3).
            buildShip();
    public static Ship shipGegner4 = Ship.shipBluider().hp(100).
            power(100).shield(1).
            name("Shipgegner4").owner(ai4).
            buildShip();

    public static Ship shipGegner5 = Ship.shipBluider().hp(100).
            power(100).shield(1).
            name("Shipgegner5").owner(ai5).
            buildShip();
    public static Ship shipGegner6 = Ship.shipBluider().hp(100).
            power(1000).shield(5).
            name("Shipgegner6").owner(ai6).
            buildShip();
    /*
    public static List<Ship> shipsgegneru1 =new ArrayList<Ship>(){{
        add(shipGegner1);
        add(shipGegner2);
        add(shipGegner3);

    }};
    public static void updateShipsVariabelgegneru1(){
        shipGegner1=shipsgegneru1.get(0);
        shipGegner2=shipsgegneru1.get(1);
        shipGegner3=shipsgegneru1.get(2);
    }
    public static void updateShipsListgegneru1(){
        List<Ship> shipsgegneru1new =new ArrayList<Ship>(){{
            add(shipGegner1);
            add(shipGegner2);
            add(shipGegner3);
        }};
        shipsgegneru1=shipsgegneru1new;
    }*/
    //**Weapons Universe **//

    // Ship Universe 2
    public static List<Ship> shipsgegneru2 =new ArrayList<Ship>(){{
        add(shipGegner1);
        add(shipGegner2);
        add(shipGegner3);
        add(shipGegner4);
        add(shipGegner5);
        add(shipGegner6);

    }};

    public static void updateShipsVariabelgegneru2(){
        shipGegner1=shipsgegneru2.get(0);
        shipGegner2=shipsgegneru2.get(1);
        shipGegner3=shipsgegneru2.get(2);
        shipGegner4=shipsgegneru2.get(3);
        shipGegner5=shipsgegneru2.get(4);
        shipGegner6=shipsgegneru2.get(5);
    }
    public static void updateShipsListgegneru2(){
        List<Ship> shipsgegneru2new =new ArrayList<Ship>(){{
            add(shipGegner1);
            add(shipGegner2);
            add(shipGegner3);
            add(shipGegner4);
            add(shipGegner5);
            add(shipGegner6);
        }};
        shipsgegneru2=shipsgegneru2new;
    }
    //Sections Gegner

    public static Section section1Gegner = Section
            .sectionBuilder()
            .sectionTyp(SectionTyp.NORMAL)
            .img("Section1Gegner1")
            .oxygen(100)
            .powerCurrent(100)
            .usable(true)
            .connectingTo(null)
            .powerRequired(10)
            .buildSection();
    public static Section section2Gegner = Section
            .sectionBuilder()
            .sectionTyp(SectionTyp.DRIVE)
            .img("Section2Gegner1")
            .oxygen(100)
            .powerCurrent(100)
            .usable(true)
            .connectingTo(null)
            .powerRequired(10)
            .buildSection();
    public static Section section3Gegner = Section
            .sectionBuilder()
            .sectionTyp(SectionTyp.WEAPONS)
            .img("Section3Gegner1")
            .oxygen(100)
            .powerCurrent(100)
            .usable(true)
            .connectingTo(null)
            .powerRequired(10)
            .buildSection();

    public static List<Section> sectionsgegner1 =new ArrayList<Section>(){{
        add(section1Gegner);
        add(section2Gegner);
        add(section3Gegner);
    }};
    public static void updateVariblesSectionsGegner1(){
        section1Gegner=sectionsgegner1.get(0);
        section2Gegner=sectionsgegner1.get(1);
        section3Gegner=sectionsgegner1.get(2);
    }

    public static Section section1Gegner2 = Section
            .sectionBuilder()
            .sectionTyp(SectionTyp.NORMAL)
            .img("Section1Gegner2")
            .oxygen(100)
            .powerCurrent(100)
            .usable(true)
            .connectingTo(null)
            .powerRequired(10)
            .buildSection();
    public static Section section2Gegner2 = Section
            .sectionBuilder()
            .sectionTyp(SectionTyp.DRIVE)
            .img("Section2Gegner2")
            .oxygen(100)
            .powerCurrent(100)
            .usable(true)
            .connectingTo(null)
            .powerRequired(10)
            .buildSection();
    public static Section section3Gegner2 = Section
            .sectionBuilder()
            .sectionTyp(SectionTyp.WEAPONS)
            .img("Section3Gegner2")
            .oxygen(100)
            .powerCurrent(100)
            .usable(true)
            .connectingTo(null)
            .powerRequired(10)
            .buildSection();
    public static Section section4Gegner2 = Section
            .sectionBuilder()
            .sectionTyp(SectionTyp.O2)
            .img("Section4Gegner2")
            .oxygen(100)
            .powerCurrent(100)
            .usable(true)
            .connectingTo(null)
            .powerRequired(10)
            .buildSection();
    public static List<Section> sectionsgegner2 =new ArrayList<Section>(){{
        add(section1Gegner2);
        add(section2Gegner2);
        add(section3Gegner2);
        add(section4Gegner2);
    }};
    public static void updateVariblesSectionsGegner2(){
        section1Gegner2=sectionsgegner2.get(0);
        section2Gegner2=sectionsgegner2.get(1);
        section3Gegner2=sectionsgegner2.get(2);
        section4Gegner2=sectionsgegner2.get(3);
    }

    public static Section section1Gegner3 = Section
            .sectionBuilder()
            .sectionTyp(SectionTyp.NORMAL)
            .img("Section1Gegner3")
            .oxygen(100)
            .powerCurrent(100)
            .usable(true)
            .connectingTo(null)
            .powerRequired(10)
            .buildSection();
    public static Section section2Gegner3 = Section
            .sectionBuilder()
            .sectionTyp(SectionTyp.DRIVE)
            .img("Section2Gegner3")
            .oxygen(100)
            .powerCurrent(100)
            .usable(true)
            .connectingTo(null)
            .powerRequired(10)
            .buildSection();
    public static Section section3Gegner3 = Section
            .sectionBuilder()
            .sectionTyp(SectionTyp.WEAPONS)
            .img("Section3Gegner3")
            .oxygen(100)
            .powerCurrent(100)
            .usable(true)
            .connectingTo(null)
            .powerRequired(10)
            .buildSection();
    public static Section section4Gegner3 = Section
            .sectionBuilder()
            .sectionTyp(SectionTyp.O2)
            .img("Section4Gegner3")
            .oxygen(100)
            .powerCurrent(100)
            .usable(true)
            .connectingTo(null)
            .powerRequired(10)
            .buildSection();
    public static Section section5Gegner3 = Section
            .sectionBuilder()
            .sectionTyp(SectionTyp.HEALT)
            .img("Section5Gegner3")
            .oxygen(100)
            .powerCurrent(100)
            .usable(true)
            .connectingTo(null)
            .powerRequired(10)
            .buildSection();

    public static List<Section> sectionsgegner3 =new ArrayList<Section>(){{
        add(section1Gegner3);
        add(section2Gegner3);
        add(section3Gegner3);
        add(section4Gegner3);
        add(section5Gegner3);
    }};
    public static void updateVariblesSectionsGegner3(){
        section1Gegner3=sectionsgegner3.get(0);
        section2Gegner3=sectionsgegner3.get(1);
        section3Gegner3=sectionsgegner3.get(2);
        section4Gegner3=sectionsgegner3.get(3);
        section5Gegner3=sectionsgegner3.get(4);
    }

    public static Section section1Gegner4 = Section
            .sectionBuilder()
            .sectionTyp(SectionTyp.NORMAL)
            .img("Section1Gegner4")
            .oxygen(100)
            .powerCurrent(100)
            .usable(true)
            .connectingTo(null)
            .powerRequired(10)
            .buildSection();
    public static Section section2Gegner4 = Section
            .sectionBuilder()
            .sectionTyp(SectionTyp.DRIVE)
            .img("Section2Gegner4")
            .oxygen(100)
            .powerCurrent(100)
            .usable(true)
            .connectingTo(null)
            .powerRequired(10)
            .buildSection();
    public static Section section3Gegner4 = Section
            .sectionBuilder()
            .sectionTyp(SectionTyp.WEAPONS)
            .img("Section3Gegner4")
            .oxygen(100)
            .powerCurrent(100)
            .usable(true)
            .connectingTo(null)
            .powerRequired(10)
            .buildSection();

    public static List<Section> sectionsgegner4 =new ArrayList<Section>(){{
        add(section1Gegner4);
        add(section2Gegner4);
        add(section3Gegner4);
    }};
    public static void updateVariblesSectionsGegner4(){
        section1Gegner4=sectionsgegner4.get(0);
        section2Gegner4=sectionsgegner4.get(1);
        section3Gegner4=sectionsgegner4.get(2);
    }

    public static Section section1Gegner5 = Section
            .sectionBuilder()
            .sectionTyp(SectionTyp.NORMAL)
            .img("Section1Gegner5")
            .oxygen(100)
            .powerCurrent(100)
            .usable(true)
            .connectingTo(null)
            .powerRequired(10)
            .buildSection();
    public static Section section2Gegner5 = Section
            .sectionBuilder()
            .sectionTyp(SectionTyp.DRIVE)
            .img("Section2Gegner5")
            .oxygen(100)
            .powerCurrent(100)
            .usable(true)
            .connectingTo(null)
            .powerRequired(10)
            .buildSection();
    public static Section section3Gegner5 = Section
            .sectionBuilder()
            .sectionTyp(SectionTyp.WEAPONS)
            .img("Section3Gegner5")
            .oxygen(100)
            .powerCurrent(100)
            .usable(true)
            .connectingTo(null)
            .powerRequired(10)
            .buildSection();

    public static List<Section> sectionsgegner5 =new ArrayList<Section>(){{
        add(section1Gegner5);
        add(section2Gegner5);
        add(section3Gegner5);
    }};
    public static void updateVariblesSectionsGegner5(){
        section1Gegner5=sectionsgegner5.get(0);
        section2Gegner5=sectionsgegner5.get(1);
        section3Gegner5=sectionsgegner5.get(2);
    }

    public static Section section1Gegner6 = Section
            .sectionBuilder()
            .sectionTyp(SectionTyp.NORMAL)
            .img("Section1Gegner6")
            .oxygen(100)
            .powerCurrent(100)
            .usable(true)
            .connectingTo(null)
            .powerRequired(10)
            .buildSection();
    public static Section section2Gegner6 = Section
            .sectionBuilder()
            .sectionTyp(SectionTyp.DRIVE)
            .img("Section2Gegner6")
            .oxygen(100)
            .powerCurrent(100)
            .usable(true)
            .connectingTo(null)
            .powerRequired(10)
            .buildSection();
    public static Section section3Gegner6 = Section
            .sectionBuilder()
            .sectionTyp(SectionTyp.WEAPONS)
            .img("Section3Gegner6")
            .oxygen(100)
            .powerCurrent(100)
            .usable(true)
            .connectingTo(null)
            .powerRequired(10)
            .buildSection();

    public static List<Section> sectionsgegner6 =new ArrayList<Section>(){{
        add(section1Gegner6);
        add(section2Gegner6);
        add(section3Gegner6);
    }};
    public static void updateVariblesSectionsGegner6(){
        section1Gegner6=sectionsgegner6.get(0);
        section2Gegner6=sectionsgegner6.get(1);
        section3Gegner6=sectionsgegner6.get(2);
    }

    /**
     * planete Univerise 1
     */
    public static Planet planet1 = Planet.builder().name("p1").img("null").build();
    public static Planet planet2 = Planet.builder().name("p2").img("null").build();
    public static Planet planet3 = Planet.builder().name("p3").img("null").build();
    public static Planet planet4 = Planet.builder().name("p4").img("null").build();
    public static Planet planet5 = Planet.builder().name("p5").img("null").build();
    public static Planet planet6 = Planet.builder().name("p6").img("null").build();
    public static Planet planet7 = Planet.builder().name("p7").img("null").build();
    public static Planet planet8 = Planet.builder().name("p8").img("null").build();
    public static Planet planet9 = Planet.builder().name("p9").img("null").build();
    public static Planet planet10 = Planet.builder().name("p10").img("null").build();
    public static List<Planet> planetListU1 =new ArrayList<Planet>(){{
        add(planet1);
        add(planet2);
        add(planet3);
        add(planet4);
        add(planet5);
    }};
    public static void updateVariblesPlanetsU1(){
        planet1= planetListU1.get(0);
        planet2= planetListU1.get(1);
        planet3= planetListU1.get(2);
        planet4= planetListU1.get(3);
        planet5= planetListU1.get(4);
    }
    public static List<Planet> planetListU2 =new ArrayList<Planet>(){{
        add(planet1);
        add(planet2);
        add(planet3);
        add(planet4);
        add(planet5);
        add(planet6);
        add(planet7);
        add(planet8);
        add(planet9);
        add(planet10);
    }};
    public static void updateVariblesPlanetsU2(){
        planet1= planetListU2.get(0);
        planet2= planetListU2.get(1);
        planet3= planetListU2.get(2);
        planet4= planetListU2.get(3);
        planet5= planetListU2.get(4);
        planet6= planetListU2.get(5);
        planet7= planetListU2.get(6);
        planet8= planetListU2.get(7);
        planet9= planetListU2.get(8);
        planet10= planetListU2.get(9);
    }
    /**
     *  Station
     */
    public static Station station1 = Station.stationBuilder().name("station1").energyPrice(0).buildStation();
    public static Station station2 = Station.stationBuilder().name("station2").energyPrice(1).buildStation();
    public static Station station3 = Station.stationBuilder().name("station3").energyPrice(0).buildStation();
    public static Station station4 = Station.stationBuilder().name("station4").energyPrice(1).buildStation();
    public static List<Station> stationListU1 =new ArrayList<Station>(){{
        add(station1);
        add(station2);
    }};
    public static void updateVariblesStationsU1(){
        station1= stationListU1.get(0);
        station2= stationListU1.get(1);
    }
    public static List<Station> stationListU2 =new ArrayList<Station>(){{
        add(station1);
        add(station2);
        add(station3);
        add(station4);
    }};
    public static void updateVariblesStationsU2(){
        station1= stationListU2.get(0);
        station2= stationListU2.get(1);
        station3= stationListU2.get(2);
        station4= stationListU2.get(3);
    }

    public static ShopRessource shopRessource1 = ShopRessource.shopRessourceBuilder().name(RessourceName.ENERGIE).prive(10).amount(100).build();
    public static ShopRessource shopRessource2 = ShopRessource.shopRessourceBuilder().name(RessourceName.ENERGIE).prive(10).amount(100).build();
    public static ShopRessource shopRessource3 = ShopRessource.shopRessourceBuilder().name(RessourceName.GOLD).prive(0).amount(100).build();
    public static List<ShopRessource> shopRessourceList =new ArrayList<ShopRessource>(){{
        add(shopRessource1);
        add(shopRessource2);
        add(shopRessource3);
    }};
    public static void updateVariblesshopRessource(){
        shopRessource1= shopRessourceList.get(0);
        shopRessource2= shopRessourceList.get(1);
        shopRessource3= shopRessourceList.get(2);
    }
    public static ShipRessource shipRessource = ShipRessource.builderShipRessource().amount(100).name(RessourceName.GOLD).build();

    /*
     * Universe Univerise 1
     */
    public static Universe universe1 = Universe.universeBuilder().name("Easy").build();
    public static Universe universe2 = Universe.universeBuilder().name("Normal").build();

    public static List<Ship> shipsP1=new ArrayList<Ship>();
    public static List<Ship> shipsP2=new ArrayList<Ship>();
    public static List<Ship> shipsP3=new ArrayList<Ship>();
    public static List<Ship> shipsP4=new ArrayList<Ship>();
    public static List<Ship> shipsP5=new ArrayList<Ship>();
    public static List<Ship> shipsP6=new ArrayList<Ship>();


}


/*Weapon Universe1*/
    /*public static List<Weapon> weaponListUniverse1 = new ArrayList<Weapon>(){{
        add(weapon1Player);
        add(weapon2Player);
        add(weapon1Gegner1);
        add(weapon2Gegner1);
        add(weapon1Gegner2);
        add(weapon2Gegner2);
        add(weapon1Gegner3);
        add(weapon2Gegner3);
    }};
    public static void updateweaponVariabelUniverse1(){
        weapon1Player= weaponListUniverse1.get(0);
        weapon2Player= weaponListUniverse1.get(1);
        weapon1Gegner1=weaponListUniverse1.get(2);
        weapon2Gegner1=weaponListUniverse1.get(3);
        weapon1Gegner2=weaponListUniverse1.get(4);
        weapon2Gegner2=weaponListUniverse1.get(5);
        weapon1Gegner3=weaponListUniverse1.get(6);
        weapon2Gegner3=weaponListUniverse1.get(7);
    }
    public static void aktualizierenweaponListUniverse1(){
        List<Weapon> newweaponListUniverse1 = new ArrayList<Weapon>(){{
            add(weapon1Player);
            add(weapon2Player);
            add(weapon1Gegner1);
            add(weapon2Gegner1);
            add(weapon1Gegner2);
            add(weapon2Gegner2);
            add(weapon1Gegner3);
            add(weapon2Gegner3);
        }};
        weaponListUniverse1=newweaponListUniverse1;
    }*/

    /*public static List<AI> aisU1=new ArrayList<AI>(){{
        add(ai1);
        add(ai2);
        add(ai3);
    }};
    public static void updateVariableaiu1(){
        ai1=aisU1.get(0);
        ai2=aisU1.get(1);
        ai3=aisU1.get(2);
    }
    */