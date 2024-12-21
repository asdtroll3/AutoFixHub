package com.carparts.AutoFixHub.data.service;
import com.carparts.AutoFixHub.data.entity.TermekEntity;
import com.carparts.AutoFixHub.data.repository.TermekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TermekService {

    @Autowired
    private TermekRepository termekRepository;

    public List<TermekEntity> getAllItems() {
        return termekRepository.findAll();
    }

    public void saveItem(TermekEntity item) {
        termekRepository.save(item);
    }

    public Optional<TermekEntity> getItemById(Long id) {
        return termekRepository.findById(id);
    }

    public void deleteItem(Long id) {
        termekRepository.deleteById(id);
    }
}
