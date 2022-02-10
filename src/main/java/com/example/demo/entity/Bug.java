package com.example.demo.entity;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Bug {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer bugId;
	
	@NotBlank
	@NotEmpty
	@Email
	String email;
	
	@NotBlank
	@NotEmpty
	String priority;
	
	@NotBlank
	@NotEmpty
	String status;
	
	@NotNull
	Date createdDate = new Date();
	
	@NotNull
	Date completedDate = new Date();
	
	@NotBlank
	@NotEmpty
	String description;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "projectId", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "projectId")
	@JsonIdentityReference(alwaysAsId = true)
	@JsonProperty("projectId")
	private OwnerProject project;

	public OwnerProject getProject() {
		return project;
	}

	public void setProject(OwnerProject project) {
		this.project = project;
	}

	public Integer getBugId() {
		return bugId;
	}

	public void setBugId(Integer bugId) {
		this.bugId = bugId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
