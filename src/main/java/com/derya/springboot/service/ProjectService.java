package com.derya.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.derya.springboot.dto.ProjectDto;
import com.derya.springboot.entity.Project;
import com.derya.springboot.util.TPage;




public interface ProjectService {

	ProjectDto save(ProjectDto projectDto);
	
	ProjectDto getById(Long id);
	
	TPage<ProjectDto> getAllPageable(Pageable pageable);

	ProjectDto getByProjectCode(String projectCode);

	Boolean delete(ProjectDto project);

	Boolean delete(Long id);
}
