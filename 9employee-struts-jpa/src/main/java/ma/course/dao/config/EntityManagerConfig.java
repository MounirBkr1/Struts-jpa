package ma.course.dao.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerConfig {

	private static EntityManagerFactory emFactory=null;
	public static EntityManager em=null;
	
	static {
		emFactory = Persistence.createEntityManagerFactory("Employees");
        em = emFactory.createEntityManager();
	}
}
