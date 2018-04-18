package cn.rpm.goods.bean;

public class Region {

    public  Region(){

    }
    public Region(int region_id, String name, int pid, int status, String level, int hot) {
        this.region_id = region_id;
        this.name = name;
        this.pid = pid;
        this.status = status;
        this.level = level;
        this.hot = hot;
    }

    int region_id;
    String name;
    int pid;
    int status;
    String level;
    int hot;

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }
}
