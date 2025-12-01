package com.abhiram.tech.crudBasics.repository;

import com.abhiram.tech.crudBasics.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Integer> {

}
