package com.example.em_project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Emprepositry  extends JpaRepository<EmployeeEntity , Long>{


} 