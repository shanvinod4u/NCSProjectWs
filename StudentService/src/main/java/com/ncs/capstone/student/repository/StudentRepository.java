package com.ncs.capstone.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncs.capstone.student.model.TestScore;
import com.ncs.capstone.student.model.User;

public interface StudentRepository extends JpaRepository<User, Integer>  {

}
