package com.smartschool.school.service;

import com.smartschool.school.model.School;
import com.smartschool.school.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    private final SchoolRepository repo;

    public SchoolService(SchoolRepository repo) { this.repo = repo; }

    public School create(School s) { return repo.save(s); }
    public School update(Long id, School s) { s.setId(id); return repo.save(s); }
    public List<School> findAll() { return repo.findAll(); }
    public School findById(Long id) { return repo.findById(id).orElse(null); }
    public void delete(Long id) { repo.deleteById(id); }
    public List<School> search(String term, String city) { return repo.searchByTermOrCity(term, city); }
}
