package experimentRunner.repository;

import experimentRunner.entity.ExperimentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by fabrizio.battini on 26/05/2015.
 */

@Repository
public class ExperimentTypeRepository {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    protected JdbcTemplate jdbc;

    public ExperimentType getExperimentType(int id) {
        return jdbc.queryForObject("SELECT * FROM experiment_type WHERE id=?", experimentTypeMapper, id);
    }

    public List<ExperimentType> getListExperimentType() {
        return jdbc.query("SELECT * FROM experiment_type", experimentTypeMapper);
    }

    public ExperimentType createExperimentType(ExperimentType experimentType) {
        String SQL = "INSERT INTO experiment_type (name, dataset, type, la, lp) values (?, ?, ?, ?, ?)";
        String name = experimentType.getDataset() + "_" + experimentType.getType() + "_" + experimentType.getLa() + "_" + experimentType.getLp();
        jdbc.update(SQL, name, experimentType.getDataset(), experimentType.getType(), experimentType.getLa(), experimentType.getLp());
        log.info("CREATE ExperimentType: " + experimentType.toString() + "\n");
        return experimentType;
    }


    private static final RowMapper<ExperimentType> experimentTypeMapper = new RowMapper<ExperimentType>() {
        public ExperimentType mapRow(ResultSet rs, int rowNum) throws SQLException {
            ExperimentType experimentType = new ExperimentType(rs.getInt("id"));
            experimentType.setName(rs.getString("name"));
            experimentType.setDataset(rs.getString("dataset"));
            experimentType.setType(rs.getString("type"));
            experimentType.setLa(rs.getInt("la"));
            experimentType.setLp(rs.getInt("lp"));
            return experimentType;
        }
    };

}
