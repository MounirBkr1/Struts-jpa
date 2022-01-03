package ma.course.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;

import com.opensymphony.xwork2.ActionSupport;

import ma.course.dao.EmployeeJpa;
import ma.course.dao.config.EntityManagerConfig;
import ma.course.domain.Employee;
import ma.course.web.form.EmployeeForm;
import ma.course.web.mapper.EmployeeMapper;

@Action("Employee")
public class EmployeeAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private EmployeeForm employee;
	

	EmployeeJpa employeeJpa=new EmployeeJpa(EntityManagerConfig.em);
	
	
	public String execute() {
		Long departmentId=employee.getDepartment().getId();
		List<Employee> employeesData=employeeJpa.getAllDepartmentEmployees(departmentId);
		
		List<EmployeeForm> employees=new ArrayList<EmployeeForm>();
		
		for(Employee employee : employeesData) {
			employees.add(EmployeeMapper.mapEmployee(employee));
		}
		
		HttpServletRequest request= ServletActionContext.getRequest();
		request.setAttribute("employees", employees);
		return "success";
	}

	public EmployeeForm getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeForm employee) {
		this.employee = employee;
	}
	
}
