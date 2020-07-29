package de.spaceStudio.server.repository;

import de.spaceStudio.server.model.Actor;
import de.spaceStudio.server.model.GameRound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
    Optional<Actor> findByName(String name);
}
