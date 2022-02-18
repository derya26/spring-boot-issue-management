package com.derya.springboot.dto;

import java.util.Date;

import com.derya.springboot.entity.IssueStatus;

import lombok.Data;

@Data
public class IssueDto {
	
	private Long id;
	
	private String description;
	
	private String details;
	
	private Date date;
	
	private IssueStatus issueStatus;
	
	private UserDto assignee;
	
	private ProjectDto project;

}
