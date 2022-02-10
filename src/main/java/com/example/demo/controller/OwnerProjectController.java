package com.example.demo.controller;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.OwnerProject;
import com.example.demo.service.OwnerProjectService;

@RestController
public class OwnerProjectController {
	@Autowired
	OwnerProjectService projectService;
	
	@PostMapping("/project")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void saveProject(@RequestBody @Valid OwnerProject project) {
		projectService.save(project);
	}
	
	@GetMapping("/project")
	Iterable<OwnerProject> getProject() {
		return projectService.getProject();
	}
	
	@GetMapping("/project/{id}")
	Optional<OwnerProject> getProject(@PathVariable Integer id) {
		return projectService.getProject(id);
	}
}
