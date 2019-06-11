package test.sql2o.main;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import test.sql2o.dao.DBDao;

public class SQL2OTest {

	public static void main(String[] args) {

		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		try {
			DBDao dbDao = container.select(DBDao.class).get();

//			dbDao.addStudent(new Student(2, "Rohit", "Manakkalath"));
//			dbDao.updateStudent(new Student(1, "Anoop", "Manakkalath"));
			System.out.println(dbDao.getStudentCount());

			dbDao.getStudents().stream().map((s) -> s.getFirstName() + " " + s.getLastName())
					.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
		container.shutdown();
	}
}
