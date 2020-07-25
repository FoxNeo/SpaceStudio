package de.spaceStudio.server.controller;

import com.google.gson.Gson;
import de.spaceStudio.server.model.Section;
import de.spaceStudio.server.model.SectionTyp;
import de.spaceStudio.server.model.Ship;
import de.spaceStudio.server.model.Weapon;
import de.spaceStudio.server.repository.SectionRepository;
import de.spaceStudio.server.repository.ShipRepository;
import de.spaceStudio.server.repository.StopAbstractRepository;
import de.spaceStudio.server.repository.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
public class WeaponControllerImpl implements WeaponController {
    @Autowired
    WeaponRepository weaponRepository;
    @Autowired
    SectionRepository sectionRepository;
    @Autowired
    ShipRepository shipRepository;
    @Autowired
    StopAbstractRepository stopAbstractRepository;
    private float removeOxygen = 20;


    @Override
    public Ship calculateDammage(Weapon w, Section sec, Ship s) {
        return null;
    }

    @Override
    @RequestMapping(value = "/weapons", method = RequestMethod.GET)
    public List<Weapon> getAllWeapons() {
        return weaponRepository.findAll();
    }

    @Override
    @RequestMapping(value = "/weapon/{id}", method = RequestMethod.GET)
    public Weapon getWeapon(@PathVariable Integer id) {
        return weaponRepository.getOne(id);
    }

    @Override
    @GetMapping(value = "/ship/{id}/weapons")
    public List<Weapon> getWeapons(@PathVariable Integer id) {
        Optional<Ship> ship = shipRepository.findById(id);
        if (ship.isEmpty()) {
            return new ArrayList<Weapon>();
        }
        List<Section> sections = sectionRepository.findAllByShip(ship.get()).get();
        List<Weapon> weapons = new ArrayList<>();

        for (Section s :
                sections) {
            Optional<List<Weapon>> w = weaponRepository.findBySection(s);
            w.ifPresent(weapons::addAll);
        }

        return weapons;
    }

    @Override
    @RequestMapping(value = "/weapon", method = RequestMethod.POST)
    public String addWeapon(@RequestBody Weapon weapon) {
        Ship ship = weapon.getSection().getShip();
        ship = shipRepository.findShipByName(ship.getName()).get();
        List<Section> sections = sectionRepository.findAllByShip(ship).get();
        for (Section s : sections) {
            if (s.getSectionTyp().equals(SectionTyp.WEAPONS)) {
                weapon.setSection(s);
                break;
            }
        }
        weaponRepository.save(weapon);
        return HttpStatus.CREATED.toString();
    }

    @RequestMapping(value = "/listweapons", method = RequestMethod.POST)
    public String addWeapons(@RequestBody List<Weapon> weapons) {
        List<Weapon> weaponList = new ArrayList<Weapon>();
        for (Weapon w :
                weapons) {
            Weapon weapon = weaponRepository.save(w);
            weaponList.add(weapon);
        }
        Gson gson = new Gson();
        return gson.toJson(weaponList);
    }

    @Override
    @RequestMapping(value = "/weapon", method = RequestMethod.PUT)

    public Weapon updateWeapon(@RequestBody Weapon weapon) {
        Weapon weapon1 = weaponRepository.save(weapon);
        return weapon1;
    }

    @Override
    @RequestMapping(value = "/weapon/{id}", method = RequestMethod.DELETE)

    public String deleteWeaponById(@PathVariable Integer id) {
        weaponRepository.deleteById(id);
        return HttpStatus.ACCEPTED.toString();
    }

    @Override
    @RequestMapping(value = "/weapons", method = RequestMethod.DELETE)

    public String deleteAllWeapons() {
        weaponRepository.deleteAll();
        return HttpStatus.OK.toString();
    }

    /**
     * Generate a random Number
     *
     * @param min lowest
     * @param max highest
     * @return a number inside the bounds
     */
    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    @Override
    public String fire(@RequestBody List<Weapon> weapons) {
    Random random = new Random();

        Ship ship = new Ship();
        for (Weapon weapon :
                weapons) {
            //Search the objective
            boolean hasHit = (  (float) (random.nextInt(100) / 100) + weapon.getHitRate()) >= 1;  // Treffer falls ueber 50%
            if (hasHit) {  // Dont change anything if no hit
                ship = shipRepository.findById(weapon.getObjectiv().getShip().getId()).get();
                if (ship.getShield() > 0) {
                    ship.setShield(ship.getShield() - weapon.getDamage());
                } else {
                    //Without_Schield
                    ship.setHp(ship.getHp() - weapon.getDamage());
                    weapon.getObjectiv().setUsable(false);
                    weapon.getObjectiv().setOxygen(  weapon.getObjectiv().getOxygen()- removeOxygen);
                    sectionRepository.save(weapon.getObjectiv());
                }
            }
            shipRepository.save(ship);
        }
        List<Section> sectionToSend = sectionRepository.findAllByShip(ship).get();
        Gson gson = new Gson();

        return gson.toJson(sectionToSend);
    }

    @Override

    public List<Boolean> shotValidation(List<Weapon> weapons) {
        List<Boolean> shots = new ArrayList<>();
        weapons.forEach(w -> {
             shots.add(canShoot(w));
    });
        return shots;
    }

    private boolean canShoot(Weapon w) {

        if (w.getObjectiv() != null && w.getObjectiv().getShip().getHp() > 0 && isOutsideRange(w.getLastShot(), w.getCoolDown())) {
            return w.getSection().getUsable();
        }
        return false;
    }


    /**
     * Has the last shot been within coolDown Time
     *
     * @param lastShot happend at this time
     * @param coolDown lasts this long
     * @return if the weapon can shot
     */
    boolean isOutsideRange(long lastShot, long coolDown) {
        long now = System.nanoTime();
        long timeElapsed = now - lastShot;
        long nanosPassed = coolDown * 1000000;
        return ( timeElapsed > nanosPassed);  // Convert to Milliseconds
    }
}
