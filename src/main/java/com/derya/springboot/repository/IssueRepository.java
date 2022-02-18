package com.derya.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.derya.springboot.entity.Issue;


public interface IssueRepository extends JpaRepository<Issue, Long> {

}
