package experimentRunner.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import experimentRunner.entity.Server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by fabrizio.battini on 26/05/2015.
 */

@Repository
public class ServerRepository {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    protected JdbcTemplate jdbc;

    public Server getServer(int id) {
        return jdbc.queryForObject("SELECT * FROM server WHERE id=?", serverMapper, id);
    }

    public List<Server> getListServer() {
        return jdbc.query("SELECT * FROM server", serverMapper);
    }

    public Server createServer(Server server) {
        String SQL = "INSERT INTO server (name, ip, core) values (?, ?, ?)";
        jdbc.update(SQL, server.getName(), server.getIp(), server.getCore());
        log.info("CREATE Server: " + server.toString() + "\n");
        return server;
    }

    public Server updateServer(Server server) {
        String SQL = "INSERT INTO server (name, ip, core) values (?, ?, ?)";
        jdbc.update(SQL, server.getName(), server.getIp(), server.getCore());
        log.info("UPDATE Server: " + server.toString() + "\n");
        return server;
    }

    public void deleteServer(int id) {
        String sql = "DELETE FROM server WHERE id=?";
        jdbc.update(sql, id);
        log.info("Delete Server id: " + id + "\n");
    }

    private static final RowMapper<Server> serverMapper = new RowMapper<Server>() {
        public Server mapRow(ResultSet rs, int rowNum) throws SQLException {
            Server server = new Server(rs.getInt("id"));
            server.setName(rs.getString("name"));
            server.setIp(rs.getString("ip"));
            server.setCore(rs.getInt("core"));
            server.setCore_busy(rs.getInt("core_busy"));
            return server;
        }
    };





}
