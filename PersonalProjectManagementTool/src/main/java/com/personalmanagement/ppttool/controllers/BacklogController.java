package com.personalmanagement.ppttool.controllers;

import com.personalmanagement.ppttool.domain.ProjectTask;
import com.personalmanagement.ppttool.services.ProjectTaskService;
import com.personalmanagement.ppttool.services.UtilityService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/backlog")
public class BacklogController {

    @Autowired
    private ProjectTaskService projectTaskService;

    @Autowired
    private UtilityService utilityService;

    @PostMapping("/{backlog_id}")
    public ResponseEntity<?> addProjectTaskToBacklog(@Valid @RequestBody ProjectTask projectTask, BindingResult result, @PathVariable String backlog_id){
        if (result.hasErrors()) {
            return new ResponseEntity<>(utilityService.fieldErrorValidation(result), HttpStatus.BAD_REQUEST);
        }

        ProjectTask projectTask1 = projectTaskService.addProjectTask(backlog_id,projectTask);

        return new ResponseEntity<ProjectTask>(projectTask1,HttpStatus.CREATED);

    }
    @GetMapping("/{backlog_id}")
    public ResponseEntity<List<ProjectTask>> getProjectBacklogById(@PathVariable String backlog_id){

        return new ResponseEntity<List<ProjectTask>>(projectTaskService.findBacklogById(backlog_id), HttpStatus.OK);

    }

    @GetMapping("/{backlog_id}/{pt_id}")
    public ResponseEntity<?> getProjectTask(@PathVariable String backlog_id, @PathVariable String pt_id){
        ProjectTask projectTask = projectTaskService.findPTByProjectSequence(backlog_id,pt_id);
        return new ResponseEntity<ProjectTask>(projectTask, HttpStatus.OK);

    }
}
