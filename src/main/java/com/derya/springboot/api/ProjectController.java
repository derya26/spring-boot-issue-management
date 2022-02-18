package com.derya.springboot.api;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.derya.springboot.dto.ProjectDto;
import com.derya.springboot.service.impl.ProjectServiceImpl;
import com.derya.springboot.util.ApiPaths;
import com.derya.springboot.util.TPage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Api(value=ApiPaths.ProjectCtrl.CTRL,description="Project APIs")
@Slf4j
public class ProjectController {
	
	private final ProjectServiceImpl projectServiceImpl;
	
	
	
	public ProjectController(ProjectServiceImpl projectServiceImpl) {
		this.projectServiceImpl = projectServiceImpl;
	}

    @GetMapping("/pagination")
    @ApiOperation(value = "Get By Pagination Operation", response = ProjectDto.class)
    public ResponseEntity<TPage<ProjectDto>> getAllByPagination(Pageable pageable) {
        TPage<ProjectDto> data = projectServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }

	//@Mapping()
	//@RequestMapping()
	@GetMapping("/{id}")
	@ApiOperation(value="Get by id operation", code=200, response=ProjectDto.class)
	public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id) {
		log.info("ProjectController --> getById --> Param :  "+id);
		log.debug("ProjectController --> getById --> Param :  "+id);
		ProjectDto projectDto = projectServiceImpl.getById(id);
		return ResponseEntity.ok(projectDto);
	}
	
	@PostMapping
	@ApiOperation(value="Create operation", response=ProjectDto.class)
	public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto project/*, Errors errors*/){
	    /*
		if (errors.hasErrors()) {
	        return new ResponseEntity( HttpStatus.BAD_REQUEST);
	    }
	    */
		return ResponseEntity.ok(projectServiceImpl.save(project));
	}
	
	//@RequestMapping(path="/update", method=RequestMethod.PUT)
	@PutMapping("/{id}")
	@ApiOperation(value="Update operation", response=ProjectDto.class)
	public ResponseEntity<ProjectDto> updateProject(@PathVariable(value="id", required=true) Long id, @Valid @RequestBody ProjectDto project){
		return ResponseEntity.ok(projectServiceImpl.update(id,project));
	
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value="Delete operation", response=ProjectDto.class)
	public ResponseEntity<Boolean> deleteProject(@PathVariable(value="id", required=true) Long id){
		return ResponseEntity.ok(projectServiceImpl.delete(id));
	
	}
}
