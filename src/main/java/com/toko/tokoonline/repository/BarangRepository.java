package com.toko.tokoonline.repository;

import com.toko.tokoonline.model.Barang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarangRepository extends JpaRepository<Barang, Long> {

}
