package com.personalmanagement.ppttool.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class ProjectUniquenessExceptionResponse {

    private String projectIdentifier;

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public ProjectUniquenessExceptionResponse(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

}
