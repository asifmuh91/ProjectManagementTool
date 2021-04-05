package com.personalmanagement.ppttool.services;


import com.personalmanagement.ppttool.domain.Backlog;
import com.personalmanagement.ppttool.domain.Project;
import com.personalmanagement.ppttool.exceptions.ProjectUniquenessException;
import com.personalmanagement.ppttool.repositories.BacklogRepository;
import com.personalmanagement.ppttool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private BacklogRepository backlogRepository;

    public Project saveOrUpdateProject(Project project) {

        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());

            if(project.getId()==null){
                Backlog backlog = new Backlog();
                project.setBacklog(backlog);
                backlog.setProject(project);
                backlog.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            }
            else if(project.getId()!=null){
                Backlog backlog = backlogRepository.findByProjectIdentifier(project.getProjectIdentifier());
                project.setBacklog(backlog);
            }

            return projectRepository.save(project);

        } catch (Exception e) {
            throw new ProjectUniquenessException("Project Id " + project.getProjectIdentifier() + " already exist - please try unique Identifier");
        }
    }

    public Project findProjectByIdentifier(String projectId) {
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if (project == null)
            throw new ProjectUniquenessException("Project Id " + projectId + " doesn't exist in database");
        else
            return project;
    }

    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String project_id){
        Project project=projectRepository.findByProjectIdentifier(project_id);
        if(project == null)
            throw new ProjectUniquenessException("Cannot delete project with Id " + project_id + ". Identifier doesn't exist");

        projectRepository.delete(project);
    }


}



