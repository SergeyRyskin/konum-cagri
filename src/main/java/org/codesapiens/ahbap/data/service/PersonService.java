package org.codesapiens.ahbap.data.service;

import org.codesapiens.ahbap.data.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Optional<PersonEntity> get(UUID id) {
        return repository.findById(id);
    }

    public Optional<PersonEntity> getByPhone(String phone) {
        return repository.findByPhone(phone);
    }

    public PersonEntity update(PersonEntity entity) {
        return repository.save(entity);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public Page<PersonEntity> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public int count() {
        return (int) repository.count();
    }

}
