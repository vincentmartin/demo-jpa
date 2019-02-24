package org.lsis.vmartin.d21.demo_jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.lsis.vmartin.d21.demo_jpa.domain.Person;
import org.lsis.vmartin.d21.demo_jpa.domain.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Gestion de l'université. Remarque : si le domaine est trop important, il est
 * préférable de créer plusieurs DAO.
 * 
 * @author vincent
 *
 */
public class UniversityDAO {

	private static final Logger LOG = LoggerFactory.getLogger(UniversityDAO.class);
	private EntityManager entityManager = null;

	public UniversityDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Person getPersonByEmail(String email) {
		Person person = null;

		TypedQuery<Person> query = entityManager.createNamedQuery(Person.GET_BY_EMAIL, Person.class)
				.setParameter("email", email);
		try {
			person = query.getSingleResult();
		} catch (NoResultException e) {
			LOG.error("Cannot find person for email {}", email, e);
		}
		return person;
	}

	public List<Student> getStudentByLevelCode(String levelCode) {
		return entityManager.createNamedQuery(Student.GET_BY_SECTION, Student.class)
				.setParameter("levelCode", levelCode).getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

}
