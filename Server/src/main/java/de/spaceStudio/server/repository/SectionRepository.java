package de.spaceStudio.server.repository;

import de.spaceStudio.server.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Integer> {
}