package com.derya.springboot.service;

import org.springframework.data.domain.Pageable;

import com.derya.springboot.dto.IssueDto;
import com.derya.springboot.entity.Issue;
import com.derya.springboot.util.TPage;

public interface IssueService {

    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(Long issue);

    IssueDto update(Long id, IssueDto project);

	Boolean delete(IssueDto issue);
}