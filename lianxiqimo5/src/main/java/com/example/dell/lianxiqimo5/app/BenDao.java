package com.example.dell.lianxiqimo5.app;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class BenDao {
    @Id(autoincrement = true)
    private Long id;
    private String pic;
    private String title;
    private String collect_num;
    private boolean dian;
    @Generated(hash = 2096085197)
    public BenDao(Long id, String pic, String title, String collect_num,
            boolean dian) {
        this.id = id;
        this.pic = pic;
        this.title = title;
        this.collect_num = collect_num;
        this.dian = dian;
    }
    @Generated(hash = 364112457)
    public BenDao() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPic() {
        return this.pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCollect_num() {
        return this.collect_num;
    }
    public void setCollect_num(String collect_num) {
        this.collect_num = collect_num;
    }
    public boolean getDian() {
        return this.dian;
    }
    public void setDian(boolean dian) {
        this.dian = dian;
    }
}
