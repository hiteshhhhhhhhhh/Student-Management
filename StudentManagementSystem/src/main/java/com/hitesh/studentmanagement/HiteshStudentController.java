package com.hitesh.studentmanagement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/students")
public class HiteshStudentController {

    private static final Logger logger = LoggerFactory.getLogger(HiteshStudentController.class);

    @Autowired
    private HiteshStudentService service;

    @GetMapping
    public ResponseEntity<List<HiteshStudent>> list() {
        List<HiteshStudent> students = service.listAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HiteshStudent> get(@PathVariable Integer id) {
        try {
            HiteshStudent student = service.get(id);
            logger.info("Fetched student details: {}", student); // Log student details
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (StudentNotFoundException e) {
            logger.error("Student not found for ID: {}", id, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<HiteshStudent> add(@RequestBody HiteshStudent student) {
        try {
            HiteshStudent savedStudent = service.save(student);
            return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error saving student: {}", student, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<HiteshStudent> update(@RequestBody HiteshStudent student, @PathVariable Integer id) {
        try {
            student.setId(id); // Ensure the ID is set for the updated student
            HiteshStudent updatedStudent = service.save(student);
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        } catch (StudentNotFoundException e) {
            logger.error("Student not found for update with ID: {}", id, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Error updating student: {}", student, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (StudentNotFoundException e) {
            logger.error("Student not found for deletion with ID: {}", id, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Error deleting student with ID: {}", id, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
