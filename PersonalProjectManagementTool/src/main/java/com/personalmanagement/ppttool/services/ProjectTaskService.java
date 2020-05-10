package com.personalmanagement.ppttool.services;

import com.personalmanagement.ppttool.Util.ProjectStatus;
import com.personalmanagement.ppttool.domain.Backlog;
import com.personalmanagement.ppttool.domain.Project;
import com.personalmanagement.ppttool.domain.ProjectTask;
import com.personalmanagement.ppttool.exceptions.ProjectNotFoundException;
import com.personalmanagement.ppttool.repositories.BacklogRepository;
import com.personalmanagement.ppttool.repositories.ProjectRepository;
import com.personalmanagement.ppttool.repositories.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectTaskService {

    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public ProjectTask addOrUpdateProjectTask(String projectIdentifier, ProjectTask projectTask, String pt_id) {

        Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);
        if (backlog == null) {
            throw new ProjectNotFoundException("Project not found by the ID provided");
        }
        projectTask.setBacklog(backlog);
        if(pt_id==null) {

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
        }

        if(findPTByProjectSequence(projectIdentifier,pt_id)==null){
            throw new ProjectNotFoundException("This pt_id " +pt_id+" does not exist in project id "+projectIdentifier);
        }
            return projectTaskRepository.save(projectTask);
        }


    public List<ProjectTask> findBacklogById(String id) {
        Project project = projectRepository.findByProjectIdentifier(id);
        if (project == null) {
            throw new ProjectNotFoundException("Project not found by the ID provided");
        } else
            return projectTaskRepository.findByProjectIdentifierOrderByPriority(id);

    }

    public ProjectTask findPTByProjectSequence(String backlog_id, String pt_id) {
        Backlog backlog = backlogRepository.findByProjectIdentifier(backlog_id);
        if (backlog == null) {
            throw new ProjectNotFoundException("Project not found by the ID provided");
        }
        ProjectTask projectTask = projectTaskRepository.findByProjectSequence(pt_id);
        if (projectTask == null) {
            throw new ProjectNotFoundException("pt_id not found");
        }

        if (!projectTask.getProjectIdentifier().equals(backlog_id)) {
            throw new ProjectNotFoundException("Project Sequence not found on backlog id provided");
        }
        return projectTask;
    }

    public void deleteProjectTaskByProjectTaskId(String project_id, String pt_id){
        ProjectTask projectTask = findPTByProjectSequence(project_id,pt_id);
        projectTaskRepository.delete(projectTask);

    }
}
