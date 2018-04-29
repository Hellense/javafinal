package model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the course database table.
 * 
 */
@Entity
@Table(name="course")
@NamedQuery(name="Course.findAll", query="SELECT c FROM Course c")
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COURSE_IDCOURSE_GENERATOR", sequenceName="SEQ_COURSE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COURSE_IDCOURSE_GENERATOR")
	@Column(unique=true, nullable=false)
	private int idcourse;

	@Temporal(TemporalType.DATE)
	private Date endDate;

	private int idProfessor;

	@Column(nullable=false, length=45)
	private String nameCourse;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	//bi-directional many-to-one association to Exam
	@OneToMany(mappedBy="course")
	private List<Exam> exams;

	//bi-directional one-to-one association to Professor
	@OneToOne(mappedBy="course")
	private Professor professor;

	public Course() {
	}

	public int getIdcourse() {
		return this.idcourse;
	}

	public void setIdcourse(int idcourse) {
		this.idcourse = idcourse;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getIdProfessor() {
		return this.idProfessor;
	}

	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}

	public String getNameCourse() {
		return this.nameCourse;
	}

	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public List<Exam> getExams() {
		return this.exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public Exam addExam(Exam exam) {
		getExams().add(exam);
		exam.setCourse(this);

		return exam;
	}

	public Exam removeExam(Exam exam) {
		getExams().remove(exam);
		exam.setCourse(null);

		return exam;
	}

	public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

}