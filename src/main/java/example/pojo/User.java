package example.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.sql.Timestamp;
import java.util.Date;

public class User {
    private long id;
    private String name;
    private String password;
    @JSONField(format ="yyyy-MM-dd HH:mm:ss")
    private Timestamp createDate;
    @JSONField(format ="yyyy-MM-dd HH:mm:ss")
    private Timestamp updateDate;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate() {
        this.createDate = new Timestamp(new Date().getTime());
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate() {
        this.updateDate = new Timestamp(new Date().getTime());
    }
}
