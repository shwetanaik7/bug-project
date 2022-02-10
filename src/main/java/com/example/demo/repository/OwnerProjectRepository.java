package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.OwnerProject;

public interface OwnerProjectRepository extends CrudRepository<OwnerProject, Integer> {

}
