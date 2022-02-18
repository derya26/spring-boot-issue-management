package com.derya.springboot.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.derya.springboot.entity.IssueHistory;
import com.derya.springboot.repository.IssueHistoryRepository;
import com.derya.springboot.service.IssueHistoryService;

public class IssueHistoryServiceImpl implements IssueHistoryService{
	
	private final IssueHistoryRepository issueHistoryRepository;
	
	

	public IssueHistoryServiceImpl(IssueHistoryRepository issueHistoryRepository) {
		this.issueHistoryRepository = issueHistoryRepository;
	}

	@Override
	public IssueHistory save(IssueHistory issueHistory) {
		//Business Logic
		if(issueHistory.getDate()==null) {
			throw new IllegalArgumentException("Issue cannot be null");
		}
		issueHistory = issueHistoryRepository.save(issueHistory);
		return null;
	}

	@Override
	public IssueHistory getById(Long id) {
		
		return issueHistoryRepository.getOne(id);
	}

	@Override
	public Page<IssueHistory> getAllPageable(Pageable pageable) {
		
		return issueHistoryRepository.findAll(pageable);
	}
	
	

}
