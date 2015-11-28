package experimentRunner.repository;

import experimentRunner.entity.ExperimentTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by fabrizio.battini on 26/05/2015.
 */

@Repository
public class ExperimentTaskRepository {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    protected JdbcTemplate jdbc;

    public ExperimentTask getExperimentTask(int id){
        return jdbc.queryForObject("SELECT experiment_task.id as id, " +
                "experiment_task.server as server_id, " +
                "experiment_task.experiment as experiment_id, " +
                "experiment_task.core_assigned as core_assigned, " +
                "experiment_task.starting_time as starting_time, " +
                "experiment_task.end_time as end_time," +
                "server.name as server_name," +
                "server.ip as server_ip," +
                "experiment_type.name as experimentType_name, " +
                "experiment_type.dataset as experimentType_dataset, " +
                "experiment_type.type as experimentType_type, " +
                "experiment_type.la as experimentType_la, " +
                "experiment_type.lp as experimentType_lp " +
                "FROM experiment_task " +
                "JOIN server ON experiment_task.server = server.id " +
                "JOIN experiment_type ON experiment_task.experiment = experiment_type.id " +
                "WHERE experiment_task.id=? ", experimentTaskMapper, id);
    }

    public List<ExperimentTask> getListExperimentTask() {
        return jdbc.query("SELECT experiment_task.id as id, " +
                "experiment_task.server as server_id, " +
                "experiment_task.experiment as experiment_id, " +
                "experiment_task.core_assigned as core_assigned, " +
                "experiment_task.starting_time as starting_time, " +
                "experiment_task.end_time as end_time, " +
                "server.name as server_name, " +
                "server.ip as server_ip, " +
                "experiment_type.name as experimentType_name, " +
                "experiment_type.dataset as experimentType_dataset, " +
                "experiment_type.type as experimentType_type, " +
                "experiment_type.la as experimentType_la, " +
                "experiment_type.lp as experimentType_lp  " +
                "FROM experiment_task " +
                "JOIN server ON experiment_task.server = server.id " +
                "JOIN experiment_type ON experiment_task.experiment = experiment_type.id ", experimentTaskMapper);
    }

    public ExperimentTask createExperimentTask(ExperimentTask experimentTask) {
        String SQL = "INSERT INTO experiment_task (server_id, experiment_id, core_assigned) values (?, ?, ?)";
        jdbc.update(SQL,experimentTask.getServer_id(),experimentTask.getExperiment_id(),experimentTask.getCore_assigned());
        log.info("CREATE ExperimentTask: " + experimentTask.toString() + "\n");
        return experimentTask;
    }


    private static final RowMapper<ExperimentTask> experimentTaskMapper = new RowMapper<ExperimentTask>() {
        public ExperimentTask mapRow(ResultSet rs, int rowNum) throws SQLException {
            ExperimentTask experimentTask = new ExperimentTask(rs.getInt("id"));
            experimentTask.setServer_id(rs.getInt("server_id"));
            experimentTask.setExperiment_id(rs.getInt("experiment_id"));
            experimentTask.setCore_assigned(rs.getInt("core_assigned"));
            experimentTask.setStarting_time(rs.getTime("starting_time"));
            experimentTask.setEnd_time(rs.getTime("end_time"));

            experimentTask.setServer_name(rs.getString("server_name"));
            experimentTask.setServer_ip(rs.getString("server_ip"));

            experimentTask.setExperimentType_name(rs.getString("experimentType_name"));
            experimentTask.setExperimentType_dataset(rs.getString("experimentType_dataset"));
            experimentTask.setExperimentType_type(rs.getString("experimentType_type"));
            experimentTask.setExperimentType_la(rs.getInt("experimentType_la"));
            experimentTask.setExperimentType_lp(rs.getInt("experimentType_lp"));

            return experimentTask;
        }
    };
}
