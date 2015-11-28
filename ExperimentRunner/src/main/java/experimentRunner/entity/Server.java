package experimentRunner.entity;

public class Server {
    private int id;
    private String name;
    private String ip;
    private int core;
    private int core_busy;

    public Server() {}

    public Server(int id) {
        this.id = id;
    }

    public Server(int id, String name, String ip, int core, int core_busy) {
        this.id = id;
        this.name = name;
        this.ip = ip;
        this.core = core;
        this.core_busy = core_busy;
    }

    public int getCore_busy() {
        return core_busy;
    }

    public void setCore_busy(int core_busy) {
        this.core_busy = core_busy;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIp() {
        return ip;
    }

    public int getCore() {
        return core;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setCore(int core) {
        this.core = core;
    }

    @Override
    public String toString() {
        return "Server{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ip='" + ip + '\'' +
                ", core=" + core +
                ", core_busy=" + core_busy +
                '}';
    }
}