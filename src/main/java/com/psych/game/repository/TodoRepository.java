package com.psych.game.repository;

import com.psych.game.model.Tasks;
import com.psych.game.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Tasks> findByName(String name);
}
