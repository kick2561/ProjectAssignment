package com.psych.game.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Tasks")
public class Tasks {
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
}
