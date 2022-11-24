package com.toko.tokoonline.model;

import com.toko.tokoonline.auditing.Auditable;

import javax.persistence.*;

@Entity
@Table(name = "barang")
public class Barang extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Float price = 0f ;

    @Column(name = "count")
    private Long count = 0l;

    @Column(name = "reting")
    private Long reting = 0l;

    @Lob
    @Column(name = "deskripsi")
    private String deskripsi;

    @Column(name = "publish")
    private Boolean publish;

    @Override
    public String toString() {
        return "Barang{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", reting=" + reting +
                ", deskripsi='" + deskripsi + '\'' +
                ", publish=" + publish +
                '}';
    }

    public Barang() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getReting() {
        return reting;
    }

    public void setReting(Long reting) {
        this.reting = reting;
    }

    public Boolean getPublish() {
        return publish;
    }

    public void setPublish(Boolean publish) {
        this.publish = publish;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
