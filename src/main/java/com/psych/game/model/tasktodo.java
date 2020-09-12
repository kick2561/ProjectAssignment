package com.psych.game.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class tasktodo {
    @Getter
    @Setter
    public String Name;

    @Getter
    @Setter
    public String Description;

    @Getter
    @Setter
    public String taskName;

    @Getter
    @Setter
    public String taskDescription;
}
