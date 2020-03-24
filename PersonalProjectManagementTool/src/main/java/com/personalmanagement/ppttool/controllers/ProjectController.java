package com.personalmanagement.ppttool.controllers;

import com.personalmanagement.ppttool.services.ProjectService;
import com.personalmanagement.ppttool.services.UtilityService;
import com.personalmanagement.ppttool.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UtilityService utilityService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {

        if (result.hasErrors()) {
            return new ResponseEntity<Map<String, String>>(utilityService.fieldErrorValidation(result), HttpStatus.BAD_REQUEST);
        }
        projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(project, HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> findProjectByIdentifier(@PathVariable String projectId) {
        return new ResponseEntity<Project>(projectService.findProjectByIdentifier(projectId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllProject() {
        return new ResponseEntity<Iterable<Project>>(projectService.findAllProjects(), HttpStatus.OK);
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteProjectById(@PathVariable String projectId) {
        projectService.deleteProjectByIdentifier(projectId.toUpperCase());
        return new ResponseEntity<String>("Project Id with id" + projectId +"has Successfully been deleted",HttpStatus.OK);
    }


}
