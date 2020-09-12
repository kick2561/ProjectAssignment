package com.psych.game.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "Todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    public Long id;

    @Getter
    @Setter
    public String name;

    @Getter
    @Setter
    public String description;

    @Getter
    @Setter
    @OneToMany
    public List<Tasks> task;
}
