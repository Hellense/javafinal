package bean;

import javax.ejb.Local;

@Local
public interface ProfessorBeanLocal {

	void addProfessor(ProfessorBean p);

	void deleteProfessor(ProfessorBean p);

	void updateProfessor(ProfessorBean p);

}
