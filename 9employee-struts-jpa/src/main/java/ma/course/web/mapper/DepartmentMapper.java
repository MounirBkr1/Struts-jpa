package ma.course.web.mapper;

import ma.course.domain.Department;
import ma.course.web.form.DepartmentForm;

public class DepartmentMapper {

	public static DepartmentForm mapDepartment(Department department) {
		DepartmentForm departmentForm=new DepartmentForm();
		
		departmentForm.setId(department.getId());
		departmentForm.setName(department.getName());
				
		return departmentForm;
	}

}
