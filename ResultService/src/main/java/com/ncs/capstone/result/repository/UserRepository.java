package com.ncs.capstone.result.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ncs.capstone.result.model.TestScore;
import com.ncs.capstone.result.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
