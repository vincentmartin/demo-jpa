package org.lsis.vmartin.d21.demo_jpa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * import javax.persistence.Id; * Created by vincent on 08/02/16.
 */
@Entity
@Table(name = "LEVEL")
public class Level implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LoggerFactory.getLogger(Level.class);

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	@Column(name = "code", nullable = false)
	@NotNull
	private String code;
	@Column(name = "description")
	private String description;

	public Level() {
	}

	public Level(String code, String description) {
		this.code = code;
		this.description = description;
	}

	//@PostPersist
	private void postPersist() {
		LOG.info("\t PostPersist on " + this.getClass().getName());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Level course = (Level) o;

		return id == course.id;

	}

	@Override
	public int hashCode() {
		return (int) (id ^ (id >>> 32));
	}

	@Override
	public String toString() {
		return "Course{" + "id=" + id + ", code='" + code + '\'' + ", description='" + description + '\'' + '}';
	}
}
