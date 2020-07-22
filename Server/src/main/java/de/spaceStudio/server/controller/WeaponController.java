package de.spaceStudio.server.controller;

import de.spaceStudio.server.model.CrewMember;
import de.spaceStudio.server.model.Section;
import de.spaceStudio.server.model.Ship;
import de.spaceStudio.server.model.Weapon;
import org.springframework.web.bind.annotation.*;

import java.net.Inet4Address;
import java.util.List;

public interface WeaponController {


    /**
     * Calculate the Dammage and update the Ship to reflect the Attack
     *
     * @param w   is used for attacking
     * @param sec is being attacked
     * @param s   is the ship being attacked
     * @return the Ship after being attacked
     */
    Ship calculateDammage(Weapon w, Section sec, Ship s);

    /**
     * Get all weapons from db
     *
     * @return List of all weapons
     */
    @RequestMapping(value = "/weapons", method = RequestMethod.GET)
    List<Weapon> getAllWeapons();


    /**
     * Get one weapon by Id
     *
     * @param id of the weapon
     * @return the Weapon
     */
    @RequestMapping(value = "/weapon/{id}", method = RequestMethod.GET)
    Weapon getWeapon(@PathVariable Integer id);

    /**
     * Get all weapons of a Ship
     *
     * @param id of the Ship
     * @return the Weapons of the Ship
     */
    @RequestMapping(value = "/ship/{id}/weapons", method = RequestMethod.GET)
    List<Weapon> getWeapons(@PathVariable Integer id);


    /**
     * Creates a new weapon from JSON weapon object
     *
     * @param weapon the weapon to be created, which is serialised from the POST JSON
     * @return the serialised Weapon
     */
    @RequestMapping(value = "/weapon", method = RequestMethod.POST)
    String addWeapon(@RequestBody Weapon weapon);


    /**
     * Update data of the weapon
     *
     * @param weapon the weapon to be updated, which is serialised from the POST JSON
     * @return the updated Weapon
     */
    @RequestMapping(value = "/weapon", method = RequestMethod.PUT)
    Weapon updateWeapon(@RequestBody Weapon weapon);


    /**
     * Delete weapon by Id
     *
     * @param id of the weapon
     * @return JSON of the delted Weapon
     */
    @RequestMapping(value = "/weapon/{id}", method = RequestMethod.DELETE)
    String deleteWeaponById(@PathVariable Integer id);


    /**
     * Delete all weapons
     *
     * @return JSON of deleted weapon
     */
    @RequestMapping(value = "/weapons", method = RequestMethod.DELETE)
    String deleteAllWeapons();

    @RequestMapping(value = "/fire", method = RequestMethod.POST)
    String fire(@RequestBody List<Weapon> weapons);

    @RequestMapping(value = "/shotvalidation", method = RequestMethod.POST)
    String shotValidation(@RequestBody List<Weapon> weapons);
}


