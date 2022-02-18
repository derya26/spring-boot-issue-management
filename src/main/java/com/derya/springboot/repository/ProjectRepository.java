package com.derya.springboot.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.derya.springboot.dto.ProjectDto;
import com.derya.springboot.entity.Project;



 /**
 * @author Derya Ucar
 * @version
 * @since  1:32:24 PM 
 * Feb 17, 2022
 *
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {
	
	Project getByProjectCode(String projectCode);
	
	List<Project> getByProjectCodeContains(String projectCode);
	
	Page<Project> findAll(Pageable pageable);
	
	List<Project> findAll(Sort sort);

	Project save(Project project);

	Project getByProjectCodeAndIdNot(String projectCode, Long id);
	

}
