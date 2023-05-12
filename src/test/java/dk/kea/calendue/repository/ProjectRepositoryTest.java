package dk.kea.calendue.repository;

import dk.kea.calendue.model.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ProjectRepositoryTest
{
    @Autowired
    private ProjectRepository projectRepo;

    @Autowired
    public ProjectRepositoryTest(ProjectRepository projectRepo)
    {
        this.projectRepo = projectRepo;
    }

    @Test
    void createProject()
    {
        //arrange
        projectRepo = new ProjectRepository();
        Project project = new Project("Project Pluto");

        //act
        projectRepo.createProject(project);
        int tempProject_id = project.getProject_id();
        Project p = projectRepo.getOneProject(tempProject_id);
        String result = p.getProject_name();

        //assert
        assertEquals("Project Pluto", result, "Not the same project name");



    }
}