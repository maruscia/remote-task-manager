package experimentRunner.entity;


public class ExperimentType {
    private int id;
    private String name;
    private String dataset;
    private String type;
    private int la;
    private int lp;

    public ExperimentType(){}

    public ExperimentType(int id) {
        this.id = id;
    }

    public ExperimentType(int id, String name, String dataset, String type, int la, int lp) {
        this.id = id;
        this.name = name;
        this.dataset = dataset;
        this.type = type;
        this.la = la;
        this.lp = lp;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDataset() {
        return dataset;
    }

    public String getType() {
        return type;
    }

    public int getLa() {
        return la;
    }

    public int getLp() {
        return lp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDataset(String dataset) {
        this.dataset = dataset;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLa(int la) {
        this.la = la;
    }

    public void setLp(int lp) {
        this.lp = lp;
    }

    @Override
    public String toString() {
        return "ExperimentType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dataset='" + dataset + '\'' +
                ", type='" + type + '\'' +
                ", la=" + la +
                ", lp=" + lp +
                '}';
    }
}
