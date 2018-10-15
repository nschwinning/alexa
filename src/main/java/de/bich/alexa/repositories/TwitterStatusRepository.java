package de.bich.alexa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.bich.alexa.model.TwitterStatus;

@Repository
public interface TwitterStatusRepository extends JpaRepository<TwitterStatus, Long>{

}
