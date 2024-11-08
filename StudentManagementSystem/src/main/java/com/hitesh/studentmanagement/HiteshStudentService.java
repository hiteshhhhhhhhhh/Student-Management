package com.hitesh.studentmanagement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HiteshStudentService {

    @Autowired
    private HiteshStudentRepository studentRepository;

    public List<HiteshStudent> listAll() {
        return studentRepository.findAll();
    }

    public HiteshStudent get(Integer id) throws StudentNotFoundException {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
    }

    public HiteshStudent save(HiteshStudent student) {
        return studentRepository.save(student);
    }

    public void delete(Integer id) throws StudentNotFoundException {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }
}
