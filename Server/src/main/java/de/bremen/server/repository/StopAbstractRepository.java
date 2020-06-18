package de.bremen.server.repository;

import de.bremen.server.model.StopAbstract;
import org.springframework.data.jpa.repository.JpaRepository;import org.springframework.stereotype.Repository;

@Repository
public interface StopAbstractRepository extends JpaRepository<StopAbstract, Integer> {
}
