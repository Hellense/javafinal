package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the exam database table.
 * 
 */
@Entity
@Table(name="exam")
@NamedQuery(name="Exam.findAll", query="SELECT e FROM Exam e")
public class Exam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXAM_IDEXAM_GENERATOR", sequenceName="SEQ_EXAM")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXAM_IDEXAM_GENERATOR")
	@Column(unique=true, nullable=false)
	private int idexam;

	@Temporal(TemporalType.DATE)
	private Date date;

	private int idprofessor;

	@Column(nullable=false)
	private int mark;

	@Column(nullable=false, length=45)
	private String nameexam;

	//bi-directional many-to-one association to Course
	@ManyToOne
	@JoinColumn(name="idcourse", nullable=false)
	private Course course;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="idstudent", nullable=false)
	private Student student;

	public Exam() {
	}

	public int getIdexam() {
		return this.idexam;
	}

	public void setIdexam(int idexam) {
		this.idexam = idexam;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getIdprofessor() {
		return this.idprofessor;
	}

	public void setIdprofessor(int idprofessor) {
		this.idprofessor = idprofessor;
	}

	public int getMark() {
		return this.mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public String getNameexam() {
		return this.nameexam;
	}

	public void setNameexam(String nameexam) {
		this.nameexam = nameexam;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}