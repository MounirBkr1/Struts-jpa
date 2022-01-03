package ma.course.web.form;

public class EmployeeForm {

	private Long id;
	private String firstName;
	private String lastName;
	private DepartmentForm department;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public DepartmentForm getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentForm department) {
		this.department = department;
	}
	
}
