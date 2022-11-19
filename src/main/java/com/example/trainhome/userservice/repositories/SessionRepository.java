package com.example.trainhome.userservice.repositories;

import com.example.trainhome.userservice.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

    @Query(value = "select * from session where token = :token", nativeQuery = true)
    Session getByToken(@Param("token") String token);
}
