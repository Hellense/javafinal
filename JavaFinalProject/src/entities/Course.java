package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * The persistent class for the course database table.
 * 
 */
@Entity
@Table(name="course")
@NamedQuery(name="Course.findAll", query="SELECT c FROM Course c")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcourse")
    private Integer idcourse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nameCourse")
    private String nameCourse;
    @Column(name = "idProfessor")
    private Integer idProfessor;
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
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

    public Course(Integer idcourse) {
        this.idcourse = idcourse;
    }

    public Course(Integer idcourse, String nameCourse) {
        this.idcourse = idcourse;
        this.nameCourse = nameCourse;
    }

    public Integer getIdcourse() {
        return idcourse;
    }

    public void setIdcourse(Integer idcourse) {
        this.idcourse = idcourse;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public Integer getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcourse != null ? idcourse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.idcourse == null && other.idcourse != null) || (this.idcourse != null && !this.idcourse.equals(other.idcourse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Course[ idcourse=" + idcourse + " ]";
    }

}