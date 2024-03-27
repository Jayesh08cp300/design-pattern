package com.example.patterns.creational.objectpool;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

abstract class Connection implements Cloneable {

	protected String connectionUrl;
	protected String connectionName;

	protected String getConnectionUrl() {
		return connectionUrl;
	}

	public String getConnectionName() {
		return connectionName;
	}

	public void setConnectionName(String connectionName) {
		this.connectionName = connectionName;
	}

	abstract void setConnectionUrl(String connectionUrl);

	@Override
	public Connection clone() {
		Object clone = null;

		try {
			clone = super.clone();

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return (Connection) clone;
	}
}

class MySqlConnection extends Connection {

	@Override
	void setConnectionUrl(String connectionUrl) {
		this.connectionUrl = connectionUrl;
	}
}

class OracleConnection extends Connection {
	@Override
	void setConnectionUrl(String connectionUrl) {
		this.connectionUrl = connectionUrl;
	}
}

class ConnectionPool {
	private List<Connection> connectionAvailable;
	private List<Connection> connectionsInUse;
	private Connection connection;
	private int size;

	public ConnectionPool(Connection connection, int size) {
		this.connection = connection;
		this.size = size;
		connectionAvailable = new LinkedList<>();
		connectionsInUse = new LinkedList<>();
	}

	public synchronized void loadConnectionPool() {
		while ((size--) > 0) {
			Connection connectionTemp = connection.clone();
			connectionTemp.setConnectionName("ConnectionName-" + size);
			connectionAvailable.add(connectionTemp);
		}
	}

	public synchronized Connection getConnection() {
		if (connectionAvailable.size() == 0) {
			throw new RuntimeException("Connection pool is empty");
		}
		Connection connectionTemp = connectionAvailable.get(0);
		connectionsInUse.add(connectionTemp);
		connectionAvailable.remove(connectionTemp);
		return connectionTemp;
	}

	public synchronized void releaseConnection(String connectionName) {
		Optional<Connection> connectionOptional = connectionsInUse.stream()
				.filter(c -> c.getConnectionName()
						.equalsIgnoreCase(connectionName))
				.findAny();
		if (connectionOptional.isPresent()) {
			Connection connectionTemp = connectionOptional.get();
			connectionAvailable.add(connectionTemp);
			connectionsInUse.remove(connectionTemp);
		} else {
			throw new RuntimeException("this connection is not available.");
		}
	}
}

public class ExampleOne {
	public static void main(String[] args) {
		Connection mySqlConnection = new MySqlConnection();
		ConnectionPool connectionPool = new ConnectionPool(mySqlConnection, 2);
		connectionPool.loadConnectionPool();
		Connection connection = connectionPool.getConnection();
		System.out.println(connection.getConnectionName());
		Connection connection2 = connectionPool.getConnection();
		System.out.println(connection2.getConnectionName());
		connectionPool.releaseConnection(connection.getConnectionName());
		Connection connection4 = connectionPool.getConnection();
		System.out.println(connection4.getConnectionName());

	}
}
