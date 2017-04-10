package de.alt.senseless.model.repos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import de.alt.senseless.model.entities.Bookmark;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
	Collection<Bookmark> findByAccountUsername(String username);
}
