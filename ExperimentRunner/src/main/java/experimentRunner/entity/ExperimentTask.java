package experimentRunner.entity;

import java.util.Date;


public class ExperimentTask {

    private int id;
    private int server_id;
    private int experiment_id;
    private int core_assigned;
    private Date starting_time;
    private Date end_time;

    private String server_name;
    private String server_ip;

    private String experimentType_name;
    private String experimentType_dataset;
    private String experimentType_type;
    private int experimentType_la;
    private int experimentType_lp;



    public ExperimentTask() {}


    public ExperimentTask(int id) {
        this.id = id;
    }

    public ExperimentTask(int id, int server_id, int experiment_id, int core_assigned, Date starting_time,
                          Date end_time, String server_name, String server_ip, String experimentType_name,
                          String experimentType_dataset, String experimentType_type, int experimentType_la,
                          int experimentType_lp) {
        this.id = id;
        this.server_id = server_id;
        this.experiment_id = experiment_id;
        this.core_assigned = core_assigned;
        this.starting_time = starting_time;
        this.end_time = end_time;
        this.server_name = server_name;
        this.server_ip = server_ip;
        this.experimentType_name = experimentType_name;
        this.experimentType_dataset = experimentType_dataset;
        this.experimentType_type = experimentType_type;
        this.experimentType_la = experimentType_la;
        this.experimentType_lp = experimentType_lp;
    }

    public int getId() {
        return id;
    }

    public int getServer_id() {
        return server_id;
    }

    public int getExperiment_id() {
        return experiment_id;
    }

    public int getCore_assigned() {
        return core_assigned;
    }

    public Date getStarting_time() {
        return starting_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public String getServer_name() {
        return server_name;
    }

    public String getServer_ip() {
        return server_ip;
    }

    public String getExperimentType_name() {
        return experimentType_name;
    }

    public String getExperimentType_dataset() {
        return experimentType_dataset;
    }

    public String getExperimentType_type() {
        return experimentType_type;
    }

    public int getExperimentType_la() {
        return experimentType_la;
    }

    public int getExperimentType_lp() {
        return experimentType_lp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setServer_id(int server_id) {
        this.server_id = server_id;
    }

    public void setExperiment_id(int experiment_id) {
        this.experiment_id = experiment_id;
    }

    public void setCore_assigned(int core_assigned) {
        this.core_assigned = core_assigned;
    }

    public void setStarting_time(Date starting_time) {
        this.starting_time = starting_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public void setServer_name(String server_name) {
        this.server_name = server_name;
    }

    public void setServer_ip(String server_ip) {
        this.server_ip = server_ip;
    }

    public void setExperimentType_name(String experimentType_name) {
        this.experimentType_name = experimentType_name;
    }

    public void setExperimentType_dataset(String experimentType_dataset) {
        this.experimentType_dataset = experimentType_dataset;
    }

    public void setExperimentType_type(String experimentType_type) {
        this.experimentType_type = experimentType_type;
    }

    public void setExperimentType_la(int experimentType_la) {
        this.experimentType_la = experimentType_la;
    }

    public void setExperimentType_lp(int experimentType_lp) {
        this.experimentType_lp = experimentType_lp;
    }


}
