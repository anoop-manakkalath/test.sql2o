package test.sql2o.db;

import javax.enterprise.inject.Produces;

import org.hsqldb.jdbc.JDBCDataSource;

public class DBDataSource {
	
	private final JDBCDataSource ds = new JDBCDataSource();

	@Produces
	public JDBCDataSource getDs() {
		ds.setUrl("jdbc:hsqldb:file:/opt/db/testdb");
		ds.setUser("SA");
		ds.setPassword("");
		return ds;
	}
}
