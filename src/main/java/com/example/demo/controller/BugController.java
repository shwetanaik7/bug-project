package com.example.demo.controller;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

	@PutMapping("/bug/{id}")
	public ResponseEntity<Bug> updateBug(@PathVariable("id") Integer id, @RequestBody Bug bug) {
		Bug b = bugRepository.findById(id).get();
		if (b.getEmail() != null) {
			b.setEmail(bug.getEmail());
			b.setPriority(bug.getPriority());
			b.setStatus(bug.getStatus());
			b.setDescription(bug.getDescription());
			b.setCreatedDate(bug.getCreatedDate());
			b.setCompletedDate(bug.getCompletedDate());
		}
		return new ResponseEntity<Bug>(bugRepository.save(b),HttpStatus.OK);
	}
}
