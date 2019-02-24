package org.lsis.vmartin.d21.demo_jpa.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by vincent on 08/02/16.
 */
@Entity
@Table(name = "TEACHER")
public class Teacher extends Person {
	private static final long serialVersionUID = 1L;

	public enum Rank {
		ATER, ASSOCIATE_PROFESSOR, FULL_PROCESSOR
	};

	@Enumerated(EnumType.STRING)
	@Column(name = "rank")
	private Rank rank;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(name = "TEACHER_LEVEL", joinColumns = @JoinColumn(name = "teacher") , inverseJoinColumns = @JoinColumn(name = "level") )
	private List<Level> teachingLevels = new ArrayList<>();

	// Constructeur par défault obligatoire pour JPA.
	public Teacher() {

	}

	public Teacher(String firstName, String lastName, Calendar birthDate, String phoneNumber, String email, Rank rank) {
		super(firstName, lastName, birthDate, phoneNumber, email);
		this.rank = rank;
	}

	// @PostPersist
	private void postPersist() {
		LOG.info("\t PostPersist on " + this.getClass().getName());
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public List<Level> getTeachingLevels() {
		return teachingLevels;
	}

	public void setTeachingLevels(List<Level> teachingLevels) {
		this.teachingLevels = teachingLevels;
	}

	@Override
	public String toString() {
		return "Teacher: " + super.toString() + ", rank=" + rank + ", levels=" + teachingLevels;
	}

}
