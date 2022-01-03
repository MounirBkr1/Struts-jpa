package ma.course.web.mapper;

import ma.course.domain.Employee;
import ma.course.web.form.EmployeeForm;

public class EmployeeMapper {

	public static EmployeeForm mapEmployee(Employee employee) {
		EmployeeForm employeeForm= new EmployeeForm();
		
		employeeForm.setId(employee.getId());
		employeeForm.setFirstName(employee.getFirstName());
		employeeForm.setLastName(employee.getLastName());
		employeeForm.setDepartment(
				DepartmentMapper.mapDepartment(employee.getDepartment())
				);
		
		return employeeForm;
	}
}
