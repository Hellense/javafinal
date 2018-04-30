package bean;

import java.util.List;

import javax.ejb.Local;

import entities.Student;

@Local
public interface StudentBeanLocal {

	void addStudent(Student student);

	void deleteStudent(Student student);

	void updateStudent(Student student);

	Student findStudentById(int id);

	List<Student> showAllStudents();
}
