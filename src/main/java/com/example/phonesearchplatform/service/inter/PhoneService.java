package com.example.phonesearchplatform.service.inter;

import com.example.phonesearchplatform.model.Phone;

import java.util.List;

public interface PhoneService {
    List<Phone> findAll();

    Phone getById(Integer id);

    Phone create(Phone phone);

    Phone update(Integer id, Phone phone);

    void deleteById(Integer id);
}
