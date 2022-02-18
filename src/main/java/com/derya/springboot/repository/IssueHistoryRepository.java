package com.derya.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.derya.springboot.entity.IssueHistory;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory, Long> {

}
