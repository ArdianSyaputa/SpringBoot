package com.toko.tokoonline.controller;

import com.toko.tokoonline.model.Barang;
import com.toko.tokoonline.response.ResponseHelper;
import com.toko.tokoonline.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Barang")
public class BarangController {
    @Autowired
    private BarangService barangService;

    @GetMapping("/all")
    public Object getAllBarang(){
        return ResponseHelper.ok(barangService.getAllBarang()) ;
    }

    @GetMapping("/{id}")
    public Object  getBarang(@PathVariable("id") Long id) {
        return ResponseHelper.ok(barangService.getBarang(id)) ;
    }

    @PostMapping
    public Object addBarang(@RequestBody Barang barang) {
        return ResponseHelper.ok( barangService.addBarang(barang)) ;
    }

    @PutMapping("/{id}")
    public Object editBarangById(@PathVariable("id") Long Id, @RequestBody Barang barang) {
        return ResponseHelper.ok(  barangService.editBarang(Id, barang.getName(), barang.getPrice(), barang.getCount(), barang.getReting(), barang.getDeskripsi(), barang.getPublish())) ;
    }

    @DeleteMapping("/{id}")
    public void deleteBarangById(@PathVariable("id") Long id) { barangService.deleteBarangById(id);}

}
