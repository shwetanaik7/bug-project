package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Bug;
import com.example.demo.repository.BugRepository;

@Service
public class BugService {
	@Autowired
	BugRepository bugRepository;

	public Iterable<Bug> getComponents() {
		return bugRepository.findAll();
	}

	public Optional<Bug> getBugs(Integer id) {
		return bugRepository.findById(id);
	}

}
