package bean;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Student;

public class StudentBean {
	
	   @PersistenceContext(unitName = "Simple_JPA_EJB_JSF_ProjectPU")
	    private EntityManager entityManager;
	       
	       public List<Student> findStudent(){
	              TypedQuery<Student> query = entityManager.createNamedQuery("Student.findAll", Student.class);        
	              return query.getResultList();
	       }
	       
	       public Student addNew(Student student) {
	              entityManager.persist(student);
	              return student;
	       }

}
