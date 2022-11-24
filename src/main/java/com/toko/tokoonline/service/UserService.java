package com.toko.tokoonline.service;

import com.toko.tokoonline.model.User;

public interface UserService {
    Object getAllUser();

    User addUser(User user);

    Object getUser(Long id);

    User editUser(Long id, String username, String email, Long age, String addres, Long phoneNumber);

    void deleteUserById(Long id);

}
