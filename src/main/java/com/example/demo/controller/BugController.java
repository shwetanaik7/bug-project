package com.example.demo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Bug;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.BugRepository;
import com.example.demo.repository.OwnerProjectRepository;
import com.example.demo.service.BugService;

@RestController
public class BugController {
	@Autowired
	BugService bugService;
	
	@Autowired
	OwnerProjectRepository projectRepository;
	
	@Autowired
	BugRepository bugRepository;
	
	@PostMapping("/bug/{id}")
	public Bug addBug(@PathVariable Integer id, @RequestBody @Valid Bug bug) {
		return projectRepository.findById(id).map(project -> {
			bug.setProject(project);
			return bugRepository.save(bug);
		}).orElseThrow(() -> new ResourceNotFoundException("id " + id + " not found"));
	}
	
	@GetMapping("/bug")
	Iterable<Bug> getBugs() {
		return bugService.getComponents();
	}
	
	@GetMapping("/bug/{id}")
	Optional<Bug> getBugs(@PathVariable("id") Integer id) {
		return bugService.getBugs(id);
	}
}
