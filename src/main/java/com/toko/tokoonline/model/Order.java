package com.toko.tokoonline.model;

import com.toko.tokoonline.auditing.Auditable;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama_barang", nullable = false)
    private String namaBarang;


    @Column(name = "harga")
    private String harga;

    @Column(name = "pemilik", nullable = false)
    private String pemilik;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getPemilik() {
        return pemilik;
    }

    public void setPemilik(String pemilik) {
        this.pemilik = pemilik;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", namaBarang='" + namaBarang + '\'' +
                ", harga='" + harga + '\'' +
                ", pemilik='" + pemilik + '\'' +
                '}';
    }

}
