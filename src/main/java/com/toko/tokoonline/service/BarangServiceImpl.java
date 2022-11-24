package com.toko.tokoonline.service;

import com.toko.tokoonline.exception.InternalErrorException;
import com.toko.tokoonline.exception.NotFoundException;
import com.toko.tokoonline.model.Barang;
import com.toko.tokoonline.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarangServiceImpl implements BarangService{

    @Autowired
    BarangRepository barangRepository;

    @Override
    public Object getAllBarang() {
        try {
            return barangRepository.findAll();
        } catch (Exception e) {
            return "Kesalahan memunculkan data";
        }
    }
    @Override
    public Barang addBarang(Barang barang) {

        return barangRepository.save(barang);
    }

    @Override
    public Object getBarang(Long id) {
        var barang = barangRepository.findById(id).orElseThrow(() -> new NotFoundException("Id Tidak Ditemukan"));
        try {
            barang.setPrice(barang.getPrice()+ 0);
            barang.setReting(barang.getReting()+ 0);
            return barangRepository.save(barang);
        } catch (Exception e) {
            throw  new InternalErrorException("Kesalahan Munculkan Data");
        }
    }


    @Override
    public Barang editBarang(Long id, String name, Float price, Long count, Long reting, String deskripsi, Boolean publish) {
        Barang barang = barangRepository.findById(id).get();
        barang.setName(name);
        barang.setPrice(price);
        barang.setCount(count);
        barang.setReting(reting);
        barang.setDeskripsi(deskripsi);
        barang.setPublish(publish);

        return barangRepository.save(barang);
    }

    @Override
    public void deleteBarangById(Long No) {
        barangRepository.deleteById(No);
    }


}
