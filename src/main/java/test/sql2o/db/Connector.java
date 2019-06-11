package test.sql2o.db;

import javax.inject.Inject;

import org.sql2o.Sql2o;

public final class Connector {

	private final Sql2o sql2o;
	
	@Inject
	public Connector(DBDataSource ds) {
		this.sql2o = new Sql2o(ds.getDs());
	}
	
	public Sql2o getSql2o() {
		return sql2o;
	}
}
