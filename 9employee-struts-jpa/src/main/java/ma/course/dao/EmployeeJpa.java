package ma.course.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ma.course.domain.Department;
import ma.course.domain.Employee;

public class EmployeeJpa {

	private EntityManager em=null;

	public EmployeeJpa(EntityManager em) {
		super();
		this.em = em;
	}

	public void createEmployee(String firstName, String lastName, Department department) {
		Employee employee=new Employee(null, firstName, lastName, department);
		em.getTransaction().begin();
		
		try {
			em.persist(employee);
			em.getTransaction().commit();		
		}
		catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();	
		}
	}

	public List<Employee> getAllDepartmentEmployees(Long departmentId) {
		List<Employee> employees =em.createQuery("select e from Employee e where e.department.id=:departmentId", Employee.class)
				.setParameter("departmentId", departmentId)
				.getResultList();
		return employees;
	}
	
	

}
