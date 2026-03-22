package com.smartschool.student.controller;

import com.smartschool.student.model.Student;
import com.smartschool.student.service.StudentService;
import com.smartschool.student.dto.StudentDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service) { this.service = service; }

    @Operation(summary = "Create a student")
    @PostMapping
    public ResponseEntity<Student> create(@Valid @RequestBody StudentDTO dto) {
        Student s = new Student();
        s.setName(dto.getName());
        s.setAge(dto.getAge());
        s.setSchoolId(dto.getSchoolId());
        return ResponseEntity.ok(service.create(s));
    }

    @GetMapping
    public ResponseEntity<List<Student>> list() { return ResponseEntity.ok(service.findAll()); }

    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable Long id) {
        Student s = service.findById(id);
        return s == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(s);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @Valid @RequestBody StudentDTO dto) {
        Student s = new Student();
        s.setName(dto.getName());
        s.setAge(dto.getAge());
        s.setSchoolId(dto.getSchoolId());
        return ResponseEntity.ok(service.update(id, s));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }

    @GetMapping("/by-school")
    public ResponseEntity<List<Student>> bySchool(@RequestParam Long schoolId) { return ResponseEntity.ok(service.findBySchool(schoolId)); }
}
