package com.toko.tokoonline.service;

import com.toko.tokoonline.exception.InternalErrorException;
import com.toko.tokoonline.exception.NotFoundException;
import com.toko.tokoonline.model.User;
import com.toko.tokoonline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


    @Override
    public Object getAllUser() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            return "Kesalahan memunculkan data";
        }
    }

    @Override
    public User addUser(User user) {
if (userRepository.findByEmail(user.getEmail()).isPresent()){
    throw new InternalErrorException("Email Sudah ada Yang Diguanakan");
}
        return userRepository.save(user);
    }

    @Override
    public Object getUser(Long id) {
        var user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Id Tidak Ditemukan"));
        try {
            user.setPhoneNumber(user.getPhoneNumber() + 0);
            user.setAge(user.getAge() + 0);
            return userRepository.save(user);
        } catch (Exception y) {
            throw  new InternalErrorException("Kesalahan Munculkan Data");
        }
    }


    @Override
    public User editUser(Long id, String username, String email, Long age, String addres, Long phoneNumber) {
        User user = userRepository.findById(id).get();
        user.setUsername(username);
        user.setEmail(email);
        user.setAge(age);
        user.setAddres(addres);
        user.setPhoneNumber(phoneNumber);
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long No) {
        userRepository.deleteById(No);
    }

}
