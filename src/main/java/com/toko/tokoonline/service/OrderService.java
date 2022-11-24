package com.toko.tokoonline.service;

import com.toko.tokoonline.model.Order;

public interface OrderService {

    Object getAllOrder();

    Order addOrder(Order order);

    Object getOrder(Long id);

    Order editOrder(Long id, String namaBarang, String harga, String pemilik);

    void deleteOrderById(Long id);

}
