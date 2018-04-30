package bean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Student;

/**
 * Session Bean implementation class StudentBean
 */
@Stateless
@LocalBean
public class StudentBean implements StudentBeanLocal {

	@PersistenceContext  
	 private EntityManager entityManager; 
    /**
     * Default constructor. 
     */
    public StudentBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addStudent(Student student) {
		entityManager.persist(student);
	}

	@Override
	public void deleteStudent(Student student) {
		entityManager.remove(
	            entityManager.contains(student) ? student : entityManager.merge(student)
	        );
	}

	@Override
	public void updateStudent(Student student) {
		entityManager.merge(student);
	}

	@Override
	public Student findStudentById(int id) {
		 return entityManager.find(Student.class,  id);
	}

	@Override
	public List<Student> showAllStudents() {
		return entityManager.createNamedQuery("Student.findAll", Student.class)
                .getResultList();
	}

}
