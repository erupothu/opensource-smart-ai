package com.smartschool.school.controller;

import com.smartschool.school.model.School;
import com.smartschool.school.service.SchoolService;
import com.smartschool.school.dto.SchoolDTO;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {
    private final SchoolService service;

    public SchoolController(SchoolService service) { this.service = service; }

    @Operation(summary = "Create a school")
    @PostMapping
    public ResponseEntity<School> create(@Valid @RequestBody SchoolDTO dto) {
        School s = new School();
        s.setName(dto.getName());
        s.setCity(dto.getCity());
        s.setAddress(dto.getAddress());
        return ResponseEntity.ok(service.create(s));
    }

    @Operation(summary = "List schools")
    @GetMapping
    public ResponseEntity<List<School>> list() { return ResponseEntity.ok(service.findAll()); }

    @GetMapping("/{id}")
    public ResponseEntity<School> get(@PathVariable Long id) {
        School s = service.findById(id);
        return s == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(s);
    }

    @PutMapping("/{id}")
    public ResponseEntity<School> update(@PathVariable Long id, @Valid @RequestBody SchoolDTO dto) {
        School s = new School();
        s.setName(dto.getName());
        s.setCity(dto.getCity());
        s.setAddress(dto.getAddress());
        return ResponseEntity.ok(service.update(id, s));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }

    @GetMapping("/search")
    public ResponseEntity<List<School>> search(@RequestParam(required = false, defaultValue = "") String term,
                                               @RequestParam(required = false, defaultValue = "") String city) {
        return ResponseEntity.ok(service.search(term, city));
    }
}
