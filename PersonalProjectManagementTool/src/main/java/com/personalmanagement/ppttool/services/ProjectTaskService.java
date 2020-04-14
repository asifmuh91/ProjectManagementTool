package com.personalmanagement.ppttool.services;

import com.personalmanagement.ppttool.Util.ProjectStatus;
import com.personalmanagement.ppttool.domain.Backlog;
import com.personalmanagement.ppttool.domain.ProjectTask;
import com.personalmanagement.ppttool.exceptions.ProjectNotFoundException;
import com.personalmanagement.ppttool.repositories.BacklogRepository;
import com.personalmanagement.ppttool.repositories.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectTaskService {

    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask) {

        Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);
        if(backlog ==null){
            throw new ProjectNotFoundException("Project not found by the ID provided");
        }

        else {
            projectTask.setBacklog(backlog);

            Integer backLogSequence = backlog.getPTSequence();
            ++backLogSequence;
            backlog.setPTSequence(backLogSequence);

            projectTask.setProjectSequence(projectIdentifier + "-" + backLogSequence);
            projectTask.setProjectIdentifier(projectIdentifier);

            if (projectTask.getPriority() == null || projectTask.getPriority() == 0)
                projectTask.setPriority(3);

            if (projectTask.getStatus() == null) {
                projectTask.setStatus(ProjectStatus.TO_DO);
            }

            return projectTaskRepository.save(projectTask);
        }
    }

    public Backlog findBacklogById(String backlog_id) {
        Backlog backlog =  backlogRepository.findByProjectIdentifier(backlog_id);
        if(backlog == null){
            throw new ProjectNotFoundException("Project not found by the ID provided");
        }
        else
            return backlog;

    }
}
