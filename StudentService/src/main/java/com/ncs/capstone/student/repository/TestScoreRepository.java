package com.ncs.capstone.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncs.capstone.student.model.TestScore;
import com.ncs.capstone.student.model.User;

public interface TestScoreRepository extends JpaRepository<TestScore, Integer>  {

}
