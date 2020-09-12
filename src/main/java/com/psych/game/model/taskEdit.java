package com.psych.game.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class taskEdit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    public Long id;

    @Getter
    @Setter
    public String taskName;

    @Getter
    @Setter
    public String taskDescription;
}
