package com.derya.springboot.service.impl;

import java.util.Arrays;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.derya.springboot.dto.IssueDto;
import com.derya.springboot.entity.Issue;
import com.derya.springboot.repository.IssueRepository;
import com.derya.springboot.service.IssueService;
import com.derya.springboot.util.TPage;



@Service
public class IssueServiceImpl implements IssueService {

	private final IssueRepository issueRepository;
	private final ModelMapper modelMapper ;
	
	
	public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) {
		this.issueRepository = issueRepository;
		this.modelMapper = modelMapper;
	}



	@Override
	public IssueDto save(IssueDto issueDto) {
		if(issueDto.getDate()==null) {
			throw new IllegalArgumentException("Issue Date cannot be null");
		}
		Issue issueDb = modelMapper.map(issueDto, Issue.class);
		issueDb = issueRepository.save(issueDb);
		return modelMapper.map(issueDb, IssueDto.class);
	}



	@Override
	public IssueDto getById(Long id) {
		
		Issue issue = issueRepository.getOne(id);
        return modelMapper.map(issue, IssueDto.class);
	}



	@Override
	public TPage<IssueDto> getAllPageable(Pageable pageable) {
		Page<Issue> data = issueRepository.findAll(pageable);
		TPage page = new TPage<IssueDto>();
		IssueDto[] dtos =  modelMapper.map(data.getContent(), IssueDto[].class);
		page.setStat(data, Arrays.asList(dtos));
		return page;
	}



	@Override
	public Boolean delete(IssueDto issue) {
		issueRepository.deleteById(issue.getId());
		return true;
	}



	public IssueDto update(IssueDto issue) {
		
		return null;
	}



	public Boolean delete(Long id) {
		
		issueRepository.deleteById(id);
		return true;
	}



	@Override
	public IssueDto update(Long id, IssueDto project) {
		
		return null;
	}

	
}
