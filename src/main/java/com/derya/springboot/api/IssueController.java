package com.derya.springboot.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.derya.springboot.dto.IssueDto;
import com.derya.springboot.dto.ProjectDto;
import com.derya.springboot.service.impl.IssueServiceImpl;
import com.derya.springboot.util.ApiPaths;
import com.fasterxml.jackson.core.JsonParseException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
@Api(value=ApiPaths.ProjectCtrl.CTRL,description="Issue APIs")
public class IssueController {
	
	private final IssueServiceImpl issueServiceImpl;

	public IssueController(IssueServiceImpl issueServiceImpl) {
		this.issueServiceImpl = issueServiceImpl;
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="Get by id operation", code=200, response=ProjectDto.class)
	public ResponseEntity<IssueDto> getById(@PathVariable("id") Long id){
		IssueDto issueDto = issueServiceImpl.getById(id);
		return ResponseEntity.ok(issueDto);
	}
	
	@PostMapping
	@ApiOperation(value="Create operation", code=200, response=ProjectDto.class)
	public ResponseEntity<IssueDto> createIssue(@Valid @RequestBody IssueDto issue){
		return ResponseEntity.ok(issueServiceImpl.save(issue));
	}

	@PutMapping("/{id}")
	@ApiOperation(value="Update operation", code=200, response=ProjectDto.class)
	public ResponseEntity<IssueDto> updateProject(@PathVariable(value="id", required=true)Long id,@Valid @RequestBody IssueDto issue){
		return ResponseEntity.ok(issueServiceImpl.update(issue));
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value="Delete operation", code=200, response=ProjectDto.class)
	public ResponseEntity<Boolean> deleteProject(@PathVariable(value="id", required=true) Long id){
		return ResponseEntity.ok(issueServiceImpl.delete(id));
	
	}
	
	@ExceptionHandler(com.fasterxml.jackson.core.JsonParseException.class)
    public ResponseEntity<Object> handleException(JsonParseException ex) {
        System.out.println(ex.getMessage());
		return null;
      
    }
}
