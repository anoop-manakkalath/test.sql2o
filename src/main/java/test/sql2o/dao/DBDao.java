package test.sql2o.dao;

import java.util.List;

import javax.inject.Inject;

import org.sql2o.Connection;

import test.sql2o.db.Connector;
import test.sql2o.model.Student;

public class DBDao {
	
	@Inject
	private Connector connector;

	public void addStudent(Student student) {
		String sql = "INSERT INTO student (studentId, firstName, lastName) VALUES (:studentId, :firstName, :lastName)";
                
		try (Connection con = connector.getSql2o().open()) {
			con.createQuery(sql).addParameter("studentId",  student.getStudentId())
					.addParameter("firstName",  student.getFirstName())
					.addParameter("lastName",  student.getLastName())
					.executeUpdate();
		}
	}
	
	public void updateStudent(Student student) {
		String sql = "UPDATE student SET firstName = :firstName, lastName = :lastName WHERE studentId = :studentId";
                
		try (Connection con = connector.getSql2o().beginTransaction()) {
			con.createQuery(sql).bind(student).executeUpdate(); // bind instead of providing the parameters
			con.commit();
		}
	}
	
	public int getStudentCount() {
		String sql = "SELECT count(studentId) FROM student";
                
		try (Connection con = connector.getSql2o().open()) {
			return con.createQuery(sql).executeScalar(Integer.class);
		}
	}
	
	public Student getStudent(int studentId) {
		String sql = "SELECT * FROM student WHERE studentId = :studentId";

		try (Connection con = connector.getSql2o().open()) {
			return con.createQuery(sql)
				.addParameter("studentId", studentId)
				.executeAndFetchFirst(Student.class);
		}
	}
	
	public List<Student> getStudents() {
		String sql = "SELECT * FROM student";

		try (Connection con = connector.getSql2o().open()) {
			return con.createQuery(sql)
				.executeAndFetch(Student.class);
		}
	}

}
