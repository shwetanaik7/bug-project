package com.example.demo.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.OwnerProject;
import com.example.demo.repository.OwnerProjectRepository;

@Service
public class OwnerProjectService {
	@Autowired
	OwnerProjectRepository projectRepository;
	
	public void save(OwnerProject project) {
		projectRepository.save(project);
	}

	public Iterable<OwnerProject> getProject() {
		return projectRepository.findAll();
	}

	public Optional<OwnerProject> getProject(Integer id) {
		return projectRepository.findById(id);
	}

}
