package com.czxy.jk;

import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Table(name = "orders")
public class Orders {

    private String oid;
    private String ordertime;
    private String total;
    private String address;
    private String name;
    private String tetephone;
    private String uid;
    private List<Orderitem> oilist = new ArrayList<Orderitem>();

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTetephone() {
        return tetephone;
    }

    public void setTetephone(String tetephone) {
        this.tetephone = tetephone;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public List<Orderitem> getOilist() {
        return oilist;
    }

    public void setOilist(List<Orderitem> oilist) {
        this.oilist = oilist;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }
}
