package com.toko.tokoonline.service;

import com.toko.tokoonline.exception.InternalErrorException;
import com.toko.tokoonline.exception.NotFoundException;
import com.toko.tokoonline.model.Order;
import com.toko.tokoonline.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Object getAllOrder() {
        try {
            return orderRepository.findAll();
        } catch (Exception c) {
            return "Kesalahan memunculkan data";
        }
    }

    @Override
    public Order addOrder(Order order) {
        if (orderRepository.findByPemilik(order.getPemilik()).isPresent()){
            throw new InternalErrorException("Email Sudah ada Yang Diguanakan");
        }
        return orderRepository.save(order);
    }

    @Override
    public Object getOrder(Long id) {
        var order = orderRepository.findById(id).orElseThrow(() -> new NotFoundException("Id Tidak Ditemukan"));
        try {
            order.setHarga(order.getHarga()+ 0);
            return orderRepository.save(order);
        } catch (Exception z) {
            throw  new InternalErrorException("Kesalahan Munculkan Data");
        }
    }

    @Override
    public Order editOrder(Long id, String namaBarang, String harga, String pemilik) {
        Order order = orderRepository.findById(id).get();
        order.setNamaBarang(namaBarang);
    order.setHarga(harga);
        return orderRepository.save(order);
    }


    @Override
    public void deleteOrderById(Long No) {
        orderRepository.deleteById(No);
    }

}
