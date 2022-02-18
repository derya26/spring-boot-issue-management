package com.derya.springboot.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.derya.springboot.dto.ProjectDto;
import com.derya.springboot.entity.Project;
import com.derya.springboot.repository.ProjectRepository;
import com.derya.springboot.service.ProjectService;
import com.derya.springboot.util.TPage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor  //create constructor using fields which are final or annotated with nonnull
public class ProjectServiceImpl implements ProjectService{
	
	private final ProjectRepository projectRepository;
	
	private final ModelMapper modelMapper;
	
	

	@Override
	public ProjectDto save(ProjectDto projectDto) {
		/*
		if(projectDto.getProjectCode()==null) {
			throw new IllegalArgumentException("Project code cannot be null");
		}
		*/
		Project projectCheck = projectRepository.getByProjectCode(projectDto.getProjectCode());
		
		if(projectCheck != null) {
			throw new IllegalArgumentException(	"Project code already exist!");
		}
		
		Project p = modelMapper.map(projectDto, Project.class);
		p = projectRepository.save(p);
		projectDto.setId(p.getId());
		return projectDto;
	}

	@Override
	public ProjectDto getById(Long id) {
		Project p = projectRepository.getOne(id);
		//log.info("ProjectController --> getById --> Param :  "+id);
		return modelMapper.map(p, ProjectDto.class);
	}

	@Override
	public TPage<ProjectDto> getAllPageable(Pageable pageable) {
		Page<Project> data = projectRepository.findAll(pageable);
		TPage<ProjectDto> response = new TPage<>();
		response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), ProjectDto[].class)));
		return response;
	}
	
	@Override
	public ProjectDto getByProjectCode(String projectCode){
		return null;
	}

	public ProjectDto update(Long id, ProjectDto project) {

		Project projectDb= projectRepository.getOne(id);
		if(projectDb ==null) {
			throw new IllegalArgumentException("Project does not exist "+id);
		}
		Project projectCheck = projectRepository.getByProjectCodeAndIdNot(project.getProjectCode(), id);
		
		/*
		if(projectCheck != null && projectCheck.getId() != projectDb.getId()) {
			throw new IllegalArgumentException(	"Project code already exist!");
		}
		*/
		if(projectCheck != null ) {
			throw new IllegalArgumentException(	"Project code already exist!");
		}
		
		projectDb.setProjectCode(project.getProjectCode());
		projectDb.setProjectName(project.getProjectName());
		
		projectRepository.save(projectDb);
		return modelMapper.map(projectDb, ProjectDto.class);

	}
	
	@Override
	public Boolean delete(ProjectDto project) {
		return false;
	}
	
	@Override
	public Boolean delete(Long id) {
		projectRepository.deleteById(id);
		return true;
	}

}
