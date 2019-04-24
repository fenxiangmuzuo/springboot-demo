package com.atguigu.springboot.crud.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.atguigu.springboot.crud.dao.DepartmentDao;
import com.atguigu.springboot.crud.dao.EmployeeDao;
import com.atguigu.springboot.crud.entities.Department;
import com.atguigu.springboot.crud.entities.Employee;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeDao employeeDao;
	@GetMapping("/emps")
	public String list(Model model) {
		Collection<Employee> collection = employeeDao.getAll();
		model.addAttribute("emps", collection);
		return "/emp/list";
	}
	@Autowired
	DepartmentDao departmentDao;
	@GetMapping("/emp")
	public String toAddPage(Model model) {
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("depts", departments);
		return "emp/add";
	}
	@PostMapping("/emp")
	public String addEmployee(Employee employee) {
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	@DeleteMapping("/emp/{id}")
	public String deleteEmployee(@PathVariable("id") Integer id) {
		employeeDao.delete(id);
		return "redirect:/emps";
	}
	@GetMapping("/emp/{id}")
	public String toEditPage(@PathVariable("id") Integer id,Model model) {
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("depts", departments);
		Employee employee = employeeDao.get(id);
		model.addAttribute("emp", employee);
		return "emp/add";
	}
	@PutMapping("/emp")
	public String updateEmployee(Employee employee) {
		employeeDao.save(employee);
		return "redirect:/emps";
	}

}
