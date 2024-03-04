package com.restful.triagil.challenge.repository;

import com.restful.triagil.challenge.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query("SELECT t FROM Team t WHERE t.owner = ?1")
    Team findByName(String name);
}
