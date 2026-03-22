package com.smartschool.student.service;

import com.smartschool.student.model.Student;
import com.smartschool.student.repository.StudentRepository;
import com.smartschool.student.client.SchoolClient;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class StudentService {
    private final StudentRepository repo;
    private final SchoolClient schoolClient;

    public StudentService(StudentRepository repo, SchoolClient schoolClient) { this.repo = repo; this.schoolClient = schoolClient; }

    public Student create(Student s) {
        // validate school exists via inter-service call
        if (s.getSchoolId() != null) {
            boolean ok = schoolClient.getSchool(s.getSchoolId()).isPresent();
            if (!ok) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "School with id " + s.getSchoolId() + " not found");
        }
        return repo.save(s);
    }

    public Student update(Long id, Student s) { s.setId(id); return repo.save(s); }
    public List<Student> findAll() { return repo.findAll(); }
    public Student findById(Long id) { return repo.findById(id).orElse(null); }
    public void delete(Long id) { repo.deleteById(id); }
    public List<Student> findBySchool(Long schoolId) { return repo.findBySchoolId(schoolId); }
}
