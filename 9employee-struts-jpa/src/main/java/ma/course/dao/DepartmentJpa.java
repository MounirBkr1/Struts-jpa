package ma.course.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ma.course.domain.Department;

public class DepartmentJpa {

	private EntityManager em=null;

	public DepartmentJpa(EntityManager em) {
		super();
		this.em = em;
	}

	public void createDepartment(String name) {
		Department department=new Department();
		department.setName(name);
		em.getTransaction().begin();
		
		try {
			em.persist(department);
			em.getTransaction().commit();		
		}
		catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();	
		}
	}

	public List<Department> getAllDepartments() {
		List<Department> departments=em.createQuery("select d from Department d", Department.class)
			.getResultList();
		return departments;
	}
	
	public Department getDepartmentById(Long id) {
		Department department=em.find(Department.class, id);
		return department;
	}

}
