package bean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Student;

/**
 * Session Bean implementation class Professor
 */
@Stateless
@LocalBean
public class ProfessorBean implements ProfessorBeanLocal {

    @PersistenceContext  
	 private EntityManager entityManager; 
   /**
    * Default constructor. 
    */
    public ProfessorBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addProfessor(ProfessorBean p) {
		entityManager.persist(p);
	}

	@Override
	public void deleteProfessor(ProfessorBean p) {
		entityManager.remove(
	            entityManager.contains(p) ? p : entityManager.merge(p)
	        );
	}

	@Override
	public void updateProfessor(ProfessorBean p) {
		entityManager.merge(p);
	}


}
