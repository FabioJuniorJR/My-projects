package com.courseJava.Project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.courseJava.Project.entities.Category;

//Esta ligada ao produto

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
