package org.lsis.vmartin.d21.demo_jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.lsis.vmartin.d21.demo_jpa.dao.UniversityDAO;
import org.lsis.vmartin.d21.demo_jpa.domain.Level;
import org.lsis.vmartin.d21.demo_jpa.domain.Person;
import org.lsis.vmartin.d21.demo_jpa.domain.Student;
import org.lsis.vmartin.d21.demo_jpa.domain.Teacher;
import org.lsis.vmartin.d21.demo_jpa.domain.Teacher.Rank;

public class Main {

	public static void main(String[] args) {

		// 1. Obtention de l'entity manager
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("demo-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("\n\n\n");

		// 2. Ouverture d'une transaction
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		// 3. Gestion des entités : opérations CRUD, recherche, ...

		Level l1 = new Level("L1", "Licence - Première année");
		Level l2 = new Level("L2", "Licence - Seconde année");

		// Création d'un étudiant (type déclaré = Person)
		Person student = new Student("Vincent", "Martin", null, "00000000", "vincent.martin@nonono.fr", "00000000",
				l1);

		// Création d'un enseignant (type déclaré = Teacher)
		Teacher teacher = new Teacher("Méchant", "Roger", null, "00000000", "mechant@nonono.fr", Rank.FULL_PROCESSOR);
		teacher.getTeachingLevels().add(l1);
		teacher.getTeachingLevels().add(l2);

		///////////// À ce moment, rien n'est enregistré dans la base de
		///////////// données. Les entités sont détachés.

		// Enregistrement dans la base de données (/!\, ce n'est pas
		// instantanné)
		entityManager.persist(l1);
		entityManager.persist(l2);
		entityManager.persist(student);
		entityManager.persist(teacher);

		// Flush du cache
		entityManager.flush();

		tx.commit();

		/// Test avec la DAO
		UniversityDAO universityDAO = new UniversityDAO(entityManager);
		System.out.println(universityDAO.getPersonByEmail("vincent.martin@nonono.fr"));

		System.out.println(universityDAO.getStudentByLevelCode("L1"));

		// 4. Fermeture de l'EntityManager et l'EntityManagerFactory
		System.out.println("\n\n\n");
		entityManager.close();
		entityManagerFactory.close();

	}

}
