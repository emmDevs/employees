package com.example.DepartmentService;

import com.example.DepartmentService.models.Department;
import com.example.DepartmentService.models.Employee;
import com.example.DepartmentService.models.Project;
import com.example.DepartmentService.repositories.DepartmentRepository;
import com.example.DepartmentService.repositories.EmployeeRepository;
import com.example.DepartmentService.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class DepartmentServiceApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createEmployeeAndDepartment(){
		Department department = new Department("HR");
		departmentRepository.save(department);

		Employee employee1 = new Employee("Joe","Bloggs", 123456, department);
		employeeRepository.save(employee1);
	}

	@Test
	public void addEmployeesAndProjects(){
		Department department = new Department("HR");
		departmentRepository.save(department);

		Employee employee1 = new Employee("Joe","Bloggs", 123456, department);
		employeeRepository.save(employee1);

		Project project1 = new Project("recruitment", 7);
		projectRepository.save(project1);

		project1.addEmployee(employee1);
		projectRepository.save(project1);

	}

	@Test
	public void addEmployeesAndProjects2(){
		Department department = new Department("Engineering");
		departmentRepository.save(department);

		Employee employee1 = new Employee("Charlotte","Webb", 645312, department);
		employeeRepository.save(employee1);

		Project project1 = new Project("Native App", 65);
		projectRepository.save(project1);

		project1.addEmployee(employee1);
		projectRepository.save(project1);

	}




}
