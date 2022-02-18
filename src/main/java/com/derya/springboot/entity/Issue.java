package com.derya.springboot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity
@Table(name="issue")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Issue extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  //for postgres and oracle use sequence this otherwise use identity
	private Long id;
	
	@Column(name="description", length=1000)
	private String description;
	
	@Column(name="details", length=4000)
	private String details;
	
	@Column(name="date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@Column(name="issue_status")
	@Enumerated(EnumType.STRING)
	private IssueStatus issueStatus;
	
	@JoinColumn(name="assignee_user_id")
	@ManyToOne(optional=true, fetch = FetchType.LAZY)
	private User assignee;
	
	@JoinColumn(name="project_id")
	@ManyToOne(optional=true,fetch = FetchType.LAZY)
	private Project project;

}
