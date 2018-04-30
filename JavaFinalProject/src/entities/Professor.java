package entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;


/**
 * The persistent class for the professor database table.
 * 
 */
@Entity
@Table(name="professor")
@NamedQuery(name="Professor.findAll", query="SELECT p FROM Professor p")
public class Professor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProfessor")
    private Integer idProfessor;
    @Size(max = 45)
    @Column(name = "nameProfessor")
    private String nameProfessor;
    @Size(max = 45)
    @Column(name = "surnameProfessor")
    private String surnameProfessor;
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

    public Professor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }

    public Integer getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNameProfessor() {
        return nameProfessor;
    }

    public void setNameProfessor(String nameProfessor) {
        this.nameProfessor = nameProfessor;
    }

    public String getSurnameProfessor() {
        return surnameProfessor;
    }

    public void setSurnameProfessor(String surnameProfessor) {
        this.surnameProfessor = surnameProfessor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfessor != null ? idProfessor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professor)) {
            return false;
        }
        Professor other = (Professor) object;
        if ((this.idProfessor == null && other.idProfessor != null) || (this.idProfessor != null && !this.idProfessor.equals(other.idProfessor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Professor[ idProfessor=" + idProfessor + " ]";
    }

}