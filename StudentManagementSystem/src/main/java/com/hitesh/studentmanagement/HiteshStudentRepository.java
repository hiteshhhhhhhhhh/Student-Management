package com.hitesh.studentmanagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HiteshStudentRepository extends JpaRepository<HiteshStudent, Integer> {
}
