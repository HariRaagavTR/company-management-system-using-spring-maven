package com.cs138185169.controller;

import java.util.List;

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
    public String addProjectForm() {
        return "addProject";
    }

    @PostMapping("/addProject")
    public String addNewProject(@ModelAttribute Project newProject, HttpSession session) {
        projectService.addProject(newProject);
        session.setAttribute("successMsg", "Project Added Successfully!");
        return "redirect:/";
    }

    @GetMapping("/addProjectManager")
    public String addProjectManagerForm() {
        return "addProjectManager";
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

    @GetMapping("/addTicket")
    public String addTicketForm() {
        return "addTicket";
    }

    @PostMapping("/addTicket")
    public String addNewTicket(@ModelAttribute Ticket newTicket, HttpSession session) {
        ticketService.addTicket(newTicket);
        session.setAttribute("successMsg", "Ticket Added Successfully!");
        return "redirect:/";
    }

    @GetMapping("/editDepartment/{id}")
    public String editDepartment(@PathVariable int id, Model model) {
        Department returnedDepartment = departmentService.getDepartmentById(id);
        model.addAttribute("returnedDepartment", returnedDepartment);
        return "editDepartment";
    }

    @GetMapping("/editProject/{id}")
    public String editProject(@PathVariable int id, Model model) {
        Project returnedProject = projectService.getProjectById(id);
        model.addAttribute("returnedProject", returnedProject);
        return "editProject";
    }

    @GetMapping("/editProjectManager/{id}")
    public String editProjectManager(@PathVariable int id, Model model) {
        ProjectManager returnedProjectManager = projectManagerService.getProjectManagerById(id);
        model.addAttribute("returnedProjectManager", returnedProjectManager);
        return "editProjectManager";
    }
    
    @GetMapping("/editSoftwareEngineer/{id}")
    public String editSoftwareEngineer(@PathVariable int id, Model model) {
        SoftwareEngineer returnedSoftwareEngineer = softwareEngineerService.getSoftwareEngineerById(id);
        model.addAttribute("returnedSoftwareEngineer", returnedSoftwareEngineer);
        return "editSoftwareEngineer";
    }

    @GetMapping("/editTicket/{id}")
    public String editTicket(@PathVariable int id, Model model) {
        Ticket returnedTicket = ticketService.getTicketById(id);
        model.addAttribute("returnedTicket", returnedTicket);
        return "editTicket";
    }
    
    @PostMapping("/updateDepartment")
    public String updateDepartment(@ModelAttribute Department updatedDepartment, HttpSession session) {
        departmentService.addDepartment(updatedDepartment);
        session.setAttribute("warningMsg", "Department Updated Successfully!");
        return "redirect:/";
    }

    @PostMapping("/updateProject")
    public String updateProject(@ModelAttribute Project updatedProject, HttpSession session) {
        projectService.addProject(updatedProject);
        session.setAttribute("warningMsg", "Project Updated Successfully!");
        return "redirect:/";
    }

    @PostMapping("/updateProjectManager")
    public String updateProjectManager(@ModelAttribute ProjectManager updatedProjectManager, HttpSession session) {
        projectManagerService.addProjectManager(updatedProjectManager);
        session.setAttribute("warningMsg", "Project Manager Updated Successfully!");
        return "redirect:/";
    }

    @PostMapping("/updateSoftwareEngineer")
    public String updateSoftwareEngineer(@ModelAttribute SoftwareEngineer updatedSoftwareEngineer, HttpSession session) {
        softwareEngineerService.addSoftwareEngineer(updatedSoftwareEngineer);
        session.setAttribute("warningMsg", "Software Engineer Updated Successfully!");
        return "redirect:/";
    }

    @PostMapping("/updateTicket")
    public String updateTicket(@ModelAttribute Ticket updatedTicket,
            HttpSession session) {
        ticketService.addTicket(updatedTicket);
        session.setAttribute("warningMsg", "Ticket Updated Successfully!");
        return "redirect:/";
    }

    @GetMapping("/deleteDepartment/{id}")
    public String deleteDepartment(@PathVariable int id, HttpSession session) {
        departmentService.deleteDepartment(id);
        session.setAttribute("warningMsg", "Department Deleted Successfully!");
        return "redirect:/";
    }

    @GetMapping("/deleteProject/{id}")
    public String deleteProject(@PathVariable int id, HttpSession session) {
        projectService.deleteProject(id);
        session.setAttribute("warningMsg", "Project Deleted Successfully!");
        return "redirect:/";
    }

    @GetMapping("/deleteProjectManager/{id}")
    public String deleteProjectManager(@PathVariable int id, HttpSession session) {
        projectManagerService.deleteProjectManager(id);
        session.setAttribute("warningMsg", "ProjectManager Deleted Successfully!");
        return "redirect:/";
    }

    @GetMapping("/deleteSoftwareEngineer/{id}")
    public String deleteSoftwareEngineer(@PathVariable int id, HttpSession session) {
        softwareEngineerService.deleteSoftwareEngineer(id);
        session.setAttribute("warningMsg", "Software Engineer Deleted Successfully!");
        return "redirect:/";
    }

    @GetMapping("/deleteTicket/{id}")
    public String deleteTicket(@PathVariable int id, HttpSession session) {
        ticketService.deleteTicket(id);
        session.setAttribute("warningMsg", "Ticket Deleted Successfully!");
        return "redirect:/";
    }
}