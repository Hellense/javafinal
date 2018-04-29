package model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the professor database table.
 * 
 */
@Entity
@Table(name="professor")
@NamedQuery(name="Professor.findAll", query="SELECT p FROM Professor p")
public class Professor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROFESSOR_IDPROFESSOR_GENERATOR", sequenceName="SEQ_PROFESSOR")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROFESSOR_IDPROFESSOR_GENERATOR")
	@Column(unique=true, nullable=false)
	private int idProfessor;

	@Column(length=45)
	private String nameProfessor;

	@Column(length=45)
	private String surnameProfessor;

	//bi-directional one-to-one association to Course
	@OneToOne
	@JoinColumn(name="idProfessor", nullable=false, insertable=false, updatable=false)
	private Course course;

	public Professor() {
	}

	public int getIdProfessor() {
		return this.idProfessor;
	}

	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}

	public String getNameProfessor() {
		return this.nameProfessor;
	}

	public void setNameProfessor(String nameProfessor) {
		this.nameProfessor = nameProfessor;
	}

	public String getSurnameProfessor() {
		return this.surnameProfessor;
	}

	public void setSurnameProfessor(String surnameProfessor) {
		this.surnameProfessor = surnameProfessor;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}