package com.psych.game.repository;

import com.psych.game.model.Tasks;
import com.psych.game.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<Tasks, Long> {

}
