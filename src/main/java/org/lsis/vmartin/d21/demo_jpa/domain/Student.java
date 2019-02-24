package org.lsis.vmartin.d21.demo_jpa.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by vincent on 08/02/16.
 */
@Entity
@Table(name = "STUDENT")
@NamedQueries({
		@NamedQuery(name = Student.GET_BY_SECTION, query = "select s from Student s where s.level.code = :levelCode") })
public class Student extends Person {
	private static final long serialVersionUID = 1L;

	public static final String GET_BY_SECTION = "Student.getBySection";

	@Column(name = "num_student", nullable = true)
	@NotNull
	private String numStudent;
	@ManyToOne
	@JoinColumn(name = "level_student")
	private Level level;

	// @PostPersist
	private void postPersist() {
		LOG.info("\t PostPersist on " + this.getClass().getName());
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String firstName, String lastName, Calendar birthDate, String phoneNumber, String email,
			String numStudent, Level level) {
		super(firstName, lastName, birthDate, phoneNumber, email);
		this.numStudent = numStudent;
		this.level = level;
	}

	public String getNumStudent() {
		return numStudent;
	}

	public void setNumStudent(String numStudent) {
		this.numStudent = numStudent;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Student: " + super.toString() + ", numStudent=" + numStudent + ", level=" + level;
	}

}
