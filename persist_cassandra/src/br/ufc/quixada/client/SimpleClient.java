package br.ufc.quixada.client;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class SimpleClient {
	private Cluster cluster;
	private Session session;

	public void Connect(String node) {
		this.cluster = Cluster.builder().addContactPoint(node).build();
		Metadata metadata = cluster.getMetadata();
		System.out.println("Conectado ao cluster: " + metadata.getClusterName());
		for (Host host : metadata.getAllHosts()) {
			System.out.println("Datacenter: " + host.getDatacenter() +
					", Host: " + host.getAddress() + ", Rack: " + host.getRack());
		}
		this.session = this.cluster.connect();
	}

	public Session getSession() {
		return this.session;
	}

	public void close() {
		this.cluster.close();
	}

	public void createSchema() {
		this.session.execute("CREATE KEYSPACE simplex WITH replication "
				+ "= {'class':'SimpleStrategy', 'replication_factor':3};");
		this.session.execute("CREATE TABLE simplex.songs ("
				+ "id uuid PRIMARY KEY,"
				+ "title text," + "album text," + "artist text,"
				+ "tags set<text>," + "data blob" + ");");
		this.session.execute("CREATE TABLE simplex.playlists ("
				+ "id uuid,"
				+ "title text," + "album text, " + "artist text,"
				+ "song_id uuid," + "PRIMARY KEY (id, title, album, artist)"
				+ ");");
	}

	public void loadData() {
		session.execute(
				"INSERT INTO simplex.songs (id, title, album, artist, tags) " +
						"VALUES (" +
						"756716f7-2e54-4715-9f00-91dcbea6cf50," +
						"'La Petite Tonkinoise'," +
						"'Bye Bye Blackbird'," +
						"'Joséphine Baker'," +
						"{'jazz', '2013'})" +
				";");
		session.execute(
				"INSERT INTO simplex.playlists (id, song_id, title, album, artist) " +
						"VALUES (" +
						"2cc9ccb7-6221-4ccb-8387-f22b6a1b354d," +
						"756716f7-2e54-4715-9f00-91dcbea6cf50," +
						"'La Petite Tonkinoise'," +
						"'Bye Bye Blackbird'," +
						"'Joséphine Baker'" +
				");");
	}

	public void querySchema() {
		ResultSet results = session.execute(
				"SELECT * FROM simplex.playlists " +
				"WHERE id = 2cc9ccb7-6221-4ccb-8387-f22b6a1b354d;");
		System.out.println(String.format("%-30s\t%-20s\t%-20s\n%s",
				"title", "album", "artist",
				"-------------------------------+-----------------------+--------------------"));
		for (Row row : results) {
			System.out.println(String.format("%-30s\t%-20s\t%-20s",
					row.getString("title"),
					row.getString("album"), row.getString("artist")));
		}
		System.out.println();
	}

	public void dropSchema(String keyspace) {
		getSession().execute("DROP KEYSPACE " + keyspace);
		System.out.println("Finished dropping " + keyspace + " keyspace.");
	}

	public void insertDataPreparedStatement() {
		PreparedStatement statement = getSession().prepare(
				"INSERT INTO simplex.songs "
						+ "(id, title, album, artist, tags) "
						+ "VALUES (?, ?, ?, ?, ?);");
		BoundStatement boundStatement = new BoundStatement(statement);
		Set<String> tags = new HashSet<String>();
		tags.add("jazz");
		tags.add("2013");
		getSession().execute(boundStatement.bind(
				UUID.fromString("756716f7-2e54-4715-9f00-91dcbea6cf50"),
				"La Petite Tonkinoise'", "Bye Bye Blackbird'",
				"Joséphine Baker", tags));
		statement = getSession().prepare(
				"INSERT INTO simplex.playlists "
						+ "(id, song_id, title, album, artist) "
						+ "VALUES (?, ?, ?, ?, ?);");
		boundStatement = new BoundStatement(statement);
		getSession().execute(boundStatement.bind(
				UUID.fromString("2cc9ccb7-6221-4ccb-8387-f22b6a1b354d"),
				UUID.fromString("756716f7-2e54-4715-9f00-91dcbea6cf50"),
				"La Petite Tonkinoise", "Bye Bye Blackbird", "Joséphine Baker"));
	}
}
