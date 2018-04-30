package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * The persistent class for the exam database table.
 * 
 */
@Entity
@Table(name="exam")
@NamedQuery(name="Exam.findAll", query="SELECT e FROM Exam e")
public class Exam implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idexam")
    private Integer idexam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nameexam")
    private String nameexam;
    @Column(name = "idprofessor")
    private Integer idprofessor;
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mark")
    private int mark;
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

    public Exam(Integer idexam) {
        this.idexam = idexam;
    }

    public Exam(Integer idexam, String nameexam, int mark) {
        this.idexam = idexam;
        this.nameexam = nameexam;
        this.mark = mark;
    }

    public Integer getIdexam() {
        return idexam;
    }

    public void setIdexam(Integer idexam) {
        this.idexam = idexam;
    }

    public String getNameexam() {
        return nameexam;
    }

    public void setNameexam(String nameexam) {
        this.nameexam = nameexam;
    }

    public Integer getIdprofessor() {
        return idprofessor;
    }

    public void setIdprofessor(Integer idprofessor) {
        this.idprofessor = idprofessor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexam != null ? idexam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exam)) {
            return false;
        }
        Exam other = (Exam) object;
        if ((this.idexam == null && other.idexam != null) || (this.idexam != null && !this.idexam.equals(other.idexam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Exam[ idexam=" + idexam + " ]";
    }

}