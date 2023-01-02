package com.example.phonesearchplatform.service.impl;

import com.example.phonesearchplatform.model.Phone;
import com.example.phonesearchplatform.repository.PhoneRepository;
import com.example.phonesearchplatform.service.inter.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;

    @Override
    public List<Phone> findAll() {
        return phoneRepository.findAll();
    }

    @Override
    public Phone getById(Integer id) {
        return phoneRepository.getReferenceById(id);
    }

    @Override
    public Phone create(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Override
    public Phone update(Integer id, Phone phone) {

        Phone existPhone = phoneRepository.getReferenceById(id);

        existPhone.setName(phone.getName());
        existPhone.setMemory(phone.getMemory());
        existPhone.setColor(phone.getColor());
        existPhone.setPrice(phone.getPrice());

        return phoneRepository.save(existPhone);
    }

    @Override
    public void deleteById(Integer id) {
        phoneRepository.deleteById(id);
    }
}
