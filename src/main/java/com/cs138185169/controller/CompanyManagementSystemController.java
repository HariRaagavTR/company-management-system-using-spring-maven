package com.cs138185169.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cs138185169.entity.Department;
import com.cs138185169.entity.Project;
import com.cs138185169.entity.ProjectManager;
import com.cs138185169.entity.SoftwareEngineer;
import com.cs138185169.entity.Ticket;

import com.cs138185169.service.DepartmentService;
import com.cs138185169.service.ProjectService;
import com.cs138185169.service.ProjectManagerService;
import com.cs138185169.service.SoftwareEngineerService;
import com.cs138185169.service.TicketService;

@Controller
public class CompanyManagementSystemController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectManagerService projectManagerService;
    @Autowired
    private SoftwareEngineerService softwareEngineerService;
    @Autowired
    private TicketService ticketService;

    @GetMapping("/")
    public String homePage(Model model) {
        List<Department> departments = departmentService.getAllDepartments();
        List<Project> projects = projectService.getAllProjects();
        List<ProjectManager> projectManagers = projectManagerService.getAllProjectManagers();
        List<SoftwareEngineer> softwareEngineers = softwareEngineerService.getAllSoftwareEngineers();
        List<Ticket> tickets = ticketService.getAllTickets();

        model.addAttribute("departments", departments);
        model.addAttribute("projects", projects);
        model.addAttribute("projectManagers", projectManagers);
        model.addAttribute("softwareEngineers", softwareEngineers);
        model.addAttribute("tickets", tickets);

        return "index";
    }

    @GetMapping("/addDepartment")
    public String addDepartmentForm() {
        return "addDepartment";
    }

    @PostMapping("/addDepartment")
    public String addNewDepartment(@ModelAttribute Department newDepartment, HttpSession session) {
        departmentService.addDepartment(newDepartment);
        session.setAttribute("successMsg", "Department Added Successfully!");
        return "redirect:/";
    }

    @GetMapping("/addProject")
    public String addProjectForm(Model model, HttpSession session) {
        List<Department> departments = departmentService.getAllDepartments();
        List<Integer> departmentIDs = new ArrayList<>();
        for (Department dep : departments) {
            departmentIDs.add(dep.getDid());
        }

        if (departmentIDs.size() > 0) {
            model.addAttribute("departmentIDs", departmentIDs);
            return "addProject";
        } else {
            session.setAttribute("errorMsg", "ERROR: No Departments Found!");
            return "redirect:/";
        }
    }

    @PostMapping("/addProject")
    public String addNewProject(@ModelAttribute Project newProject, HttpSession session) {
        projectService.addProject(newProject);
        session.setAttribute("successMsg", "Project Added Successfully!");
        return "redirect:/";
    }

    @GetMapping("/addProjectManager")
    public String addProjectManagerForm(Model model, HttpSession session) {
        List<Project> projects = projectService.getAllProjects();
        List<Integer> projectIDs = new ArrayList<>();
        for (Project p : projects) {
            projectIDs.add(p.getPid());
        }

        if (projectIDs.size() > 0) {
            model.addAttribute("projectIDs", projectIDs);
            return "addProjectManager";
        } else {
            session.setAttribute("errorMsg", "ERROR: No Projects Found!");
            return "redirect:/";
        }
    }

    @PostMapping("/addProjectManager")
    public String addNewProjectManager(@ModelAttribute ProjectManager newProjectManager, HttpSession session) {
        projectManagerService.addProjectManager(newProjectManager);
        session.setAttribute("successMsg", "Project Manager Added Successfully!");
        return "redirect:/";
    }

    @GetMapping("/addSoftwareEngineer")
    public String addSoftwareEngineerForm() {
        return "addSoftwareEngineer";
    }

    @PostMapping("/addSoftwareEngineer")
    public String addNewSoftwareEngineer(@ModelAttribute SoftwareEngineer newSoftwareEngineer, HttpSession session) {
        softwareEngineerService.addSoftwareEngineer(newSoftwareEngineer);
        session.setAttribute("successMsg", "Software Engineer Added Successfully!");
        return "redirect:/";
    }

    @GetMapping("/addTicket/{pid}/{pmid}")
    public String addTicketForm(@PathVariable int pid, @PathVariable int pmid, Model model) {
        List<Integer> listOfSeid = softwareEngineerService.getAllSeid();
        int seid = listOfSeid.get((new Random()).nextInt(listOfSeid.size()));
        model.addAttribute("pid", pid);
        model.addAttribute("pmid", pmid);
        model.addAttribute("seid", seid);
        return "addTicket";
    }

    @PostMapping("/addTicket/{pmid}")
    public String addNewTicket(@PathVariable int pmid, @ModelAttribute Ticket newTicket, HttpSession session) {
        ticketService.addTicket(newTicket);
        session.setAttribute("successMsg", "Ticket Added Successfully!");
        return "redirect:/projectManager/" + Integer.toString(pmid);
    }

    @GetMapping("/editDepartment/{id}")
    public String editDepartment(@PathVariable int id, Model model) {
        Department returnedDepartment = departmentService.getDepartmentById(id);
        model.addAttribute("returnedDepartment", returnedDepartment);
        return "editDepartment";
    }

    @GetMapping("/editProject/{id}")
    public String editProject(@PathVariable int id, Model model) {
        List<Department> departments = departmentService.getAllDepartments();
        List<Integer> departmentIDs = new ArrayList<>();
        for (Department dep : departments) {
            departmentIDs.add(dep.getDid());
        }
        Project returnedProject = projectService.getProjectById(id);

        model.addAttribute("returnedProject", returnedProject);
        model.addAttribute("departmentIDs", departmentIDs);

        return "editProject";
    }

    @GetMapping("/editProjectManager/{id}")
    public String editProjectManager(@PathVariable int id, Model model) {
        ProjectManager returnedProjectManager = projectManagerService.getProjectManagerById(id);
        List<Project> projects = projectService.getAllProjects();
        List<Integer> projectIDs = new ArrayList<>();
        for (Project p : projects) {
            projectIDs.add(p.getPid());
        }

        model.addAttribute("projectIDs", projectIDs);
        model.addAttribute("returnedProjectManager", returnedProjectManager);

        return "editProjectManager";
    }

    @GetMapping("/editSoftwareEngineer/{id}")
    public String editSoftwareEngineer(@PathVariable int id, Model model) {
        SoftwareEngineer returnedSoftwareEngineer = softwareEngineerService.getSoftwareEngineerById(id);
        model.addAttribute("returnedSoftwareEngineer", returnedSoftwareEngineer);
        return "editSoftwareEngineer";
    }

    @GetMapping("/editTicket/{id}/{pmid}")
    public String editTicket(@PathVariable int id, @PathVariable int pmid, Model model) {
        Ticket returnedTicket = ticketService.getTicketById(id);
        model.addAttribute("returnedTicket", returnedTicket);
        model.addAttribute("pmid", pmid);
        return "editTicket";
    }

    @PostMapping("/updateDepartment/{pmid}")
    public String updateDepartment(@PathVariable int pmid, @ModelAttribute Department updatedDepartment,
            HttpSession session) {
        departmentService.addDepartment(updatedDepartment);
        session.setAttribute("successMsg", "Department Updated Successfully!");
        return "redirect:/projectManager/" + Integer.toString(pmid);
    }

    @PostMapping("/updateProject")
    public String updateProject(@ModelAttribute Project updatedProject, HttpSession session) {
        projectService.addProject(updatedProject);
        session.setAttribute("successMsg", "Project Updated Successfully!");
        return "redirect:/";
    }

    @PostMapping("/updateProjectManager")
    public String updateProjectManager(@ModelAttribute ProjectManager updatedProjectManager, HttpSession session) {
        projectManagerService.addProjectManager(updatedProjectManager);
        session.setAttribute("successMsg", "Project Manager Updated Successfully!");
        return "redirect:/";
    }

    @PostMapping("/updateSoftwareEngineer")
    public String updateSoftwareEngineer(@ModelAttribute SoftwareEngineer updatedSoftwareEngineer,
            HttpSession session) {
        softwareEngineerService.addSoftwareEngineer(updatedSoftwareEngineer);
        session.setAttribute("successMsg", "Software Engineer Updated Successfully!");
        return "redirect:/";
    }

    @PostMapping("/updateTicket/{pmid}")
    public String updateTicket(@PathVariable int pmid, @ModelAttribute Ticket updatedTicket,
            HttpSession session) {
        ticketService.addTicket(updatedTicket);
        session.setAttribute("successMsg", "Ticket Updated Successfully!");
        return "redirect:/projectManager/" + Integer.toString(pmid);
    }

    @GetMapping("/deleteDepartment/{id}")
    public String deleteDepartment(@PathVariable int id, HttpSession session) {
        if (projectService.getAllProjectsByDid(id).size() == 0) {
            departmentService.deleteDepartment(id);
            session.setAttribute("warningMsg", "Department Deleted Successfully!");
        } else {
            session.setAttribute("errorMsg", "ERROR: Dependency Found @ Project Table.");
        }
        return "redirect:/";
    }

    @GetMapping("/deleteProject/{id}")
    public String deleteProject(@PathVariable int id, HttpSession session) {
        if (projectManagerService.getAllProjectManagersByPid(id).size() == 0 &&
                ticketService.getTicketByPid(id).size() == 0) {
            projectService.deleteProject(id);
            session.setAttribute("warningMsg", "Project Deleted Successfully!");
        } else {
            session.setAttribute("errorMsg", "ERROR: Dependency Found @ Project Manager / Ticket Table.");
        }
        return "redirect:/";
    }

    @GetMapping("/deleteProjectManager/{id}")
    public String deleteProjectManager(@PathVariable int id, HttpSession session) {
        projectManagerService.deleteProjectManager(id);
        session.setAttribute("successMsg", "ProjectManager Deleted Successfully!");
        return "redirect:/";
    }

    @GetMapping("/deleteSoftwareEngineer/{id}")
    public String deleteSoftwareEngineer(@PathVariable int id, HttpSession session) {
        if (ticketService.getTicketBySeid(id).size() == 0) {
            softwareEngineerService.deleteSoftwareEngineer(id);
            session.setAttribute("warningMsg", "Software Engineer Deleted Successfully!");
        } else {
            session.setAttribute("errorMsg", "ERROR: Dependency Found @ Ticket Table.");
        }
        return "redirect:/";
    }

    @GetMapping("/completeTicket/{id}/{seid}")
    public String completeTicket(@PathVariable int id, @PathVariable int seid, HttpSession session) {
        ticketService.deleteTicket(id);
        session.setAttribute("successMsg", "Ticket Completed!");
        return "redirect:/softwareEngineer/" + Integer.toString(seid);
    }

    @GetMapping("/deleteTicket/{id}/{pmid}")
    public String deleteTicket(@PathVariable int id, @PathVariable int pmid, HttpSession session) {
        ticketService.deleteTicket(id);
        session.setAttribute("successMsg", "Ticket Deleted Successfully!");
        return "redirect:/projectManager/" + Integer.toString(pmid);
    }

    @GetMapping("/reassignTicket/{id}/{seid}")
    public String reassignTicket(@PathVariable int id, @PathVariable int seid, HttpSession session) {
        List<Integer> listOfSeid = softwareEngineerService.getAllSeid();
        Random rand = new Random();

        if (listOfSeid.size() > 1) {
            int updatedSeid = listOfSeid.get(rand.nextInt(listOfSeid.size()));
            while (updatedSeid == seid) {
                updatedSeid = listOfSeid.get(rand.nextInt(listOfSeid.size()));
            }
            ticketService.updateTicketSeidByTid(id, updatedSeid);
            session.setAttribute("successMsg", "Ticket Passed Successfully to " + updatedSeid + "!");
        } else
            session.setAttribute("errorMsg", "ERROR: Not enough software engineers to reassign!");

        return "redirect:/softwareEngineer/" + Integer.toString(seid);
    }

    @GetMapping("/softwareEngineer/{id}")
    public String softwareEngineerPage(@PathVariable int id, HttpSession session, Model model) {
        SoftwareEngineer softwareEngineerDetails = softwareEngineerService.getSoftwareEngineerById(id);
        if (softwareEngineerDetails == null)
            return "redirect:/";
        List<Ticket> ticketsAssignedToSoftwareEngineer = ticketService.getTicketBySeid(id);
        model.addAttribute("softwareEngineerDetails", softwareEngineerDetails);
        model.addAttribute("ticketsAssignedToSoftwareEngineer", ticketsAssignedToSoftwareEngineer);
        return "softwareEngineer";
    }

    @GetMapping("/projectManager/{id}")
    public String projectManagerPage(@PathVariable int id, HttpSession session, Model model) {
        ProjectManager projectManagerDetails = projectManagerService.getProjectManagerById(id);
        if (projectManagerDetails == null)
            return "redirect:/";
        List<Ticket> ticketsUnderThatProject = ticketService.getTicketByPid(projectManagerDetails.getPid());
        model.addAttribute("projectManagerDetails", projectManagerDetails);
        model.addAttribute("ticketsUnderThatProject", ticketsUnderThatProject);
        return "projectManager";
    }
}