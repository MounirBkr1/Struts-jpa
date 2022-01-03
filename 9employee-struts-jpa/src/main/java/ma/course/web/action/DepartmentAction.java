package ma.course.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;

import com.opensymphony.xwork2.ActionSupport;

import ma.course.dao.DepartmentJpa;
import ma.course.dao.config.EntityManagerConfig;
import ma.course.domain.Department;
import ma.course.web.form.DepartmentForm;
import ma.course.web.mapper.DepartmentMapper;

@Action("Department")
public class DepartmentAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private DepartmentForm department;
	
	DepartmentJpa departmentJpa=new DepartmentJpa(EntityManagerConfig.em);
		
	public String execute() {
		List<Department> departmentsData=departmentJpa.getAllDepartments();
		
		List<DepartmentForm> departments=new ArrayList<DepartmentForm>();
		
		for(Department department : departmentsData) {
			departments.add(DepartmentMapper.mapDepartment(department));
		}
		
		HttpServletRequest request= ServletActionContext.getRequest();
		request.setAttribute("departments", departments);
		return "success";
	}

	public DepartmentForm getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentForm department) {
		this.department = department;
	}
	
}
