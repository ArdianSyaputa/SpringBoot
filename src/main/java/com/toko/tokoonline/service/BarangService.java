package com.toko.tokoonline.service;

import com.toko.tokoonline.model.Barang;

public interface BarangService {
    Object getAllBarang();

    Barang addBarang(Barang barang);

    Object getBarang(Long id);

    Barang editBarang(Long id, String Name, Float Price, Long Count, Long Reting, String Deskripsi, Boolean Publish);
    void deleteBarangById(Long id);
}
