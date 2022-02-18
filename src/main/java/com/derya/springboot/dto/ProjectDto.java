package com.derya.springboot.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="Project Data Transfer Object")
public class ProjectDto {
	
	@ApiModelProperty(required=false,value="Id of Project")
	private Long id;
	
	@NotNull(message="project name cannot be null")
	@ApiModelProperty(required=true,value="Name of Project")
	private String projectName;
	
	@NotNull
	@ApiModelProperty(required=true,value="Code of Project")
	private String projectCode;

}
