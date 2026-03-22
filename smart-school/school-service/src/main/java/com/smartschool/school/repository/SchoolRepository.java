package com.smartschool.school.repository;

import com.smartschool.school.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School, Long> {
    List<School> findByNameContainingIgnoreCase(String name);
    List<School> findByCity(String city);

    @Query("SELECT s FROM School s WHERE s.name LIKE %:term% OR s.city = :city")
    List<School> searchByTermOrCity(@Param("term") String term, @Param("city") String city);
}
