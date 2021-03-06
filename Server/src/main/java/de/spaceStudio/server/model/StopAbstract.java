package de.spaceStudio.server.model;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Inheritance(
        strategy = InheritanceType.TABLE_PER_CLASS
)
public class StopAbstract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(cascade = CascadeType.DETACH)
    private List<Ship> ships;

    @ManyToOne
    private Universe universe;

    private String name;
    @Column
    private String img;

    public StopAbstract() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ship) {
        this.ships = ship;
    }

    public Universe getUniverse() {
        return universe;
    }

    public void setUniverse(Universe universe) {
        this.universe = universe;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public static class StopAbstractBuilder {
    }
}
