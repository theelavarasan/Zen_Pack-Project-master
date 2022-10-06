package com.ZenPack.service;

import com.ZenPack.model.FeaturedList;
import com.ZenPack.model.ZenPack;
import com.ZenPack.repository.ZenPackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ZenPackServiceImpl implements ZenPackService{


    @Autowired
    private ZenPackRepository repository;

    @Override
    public ResponseEntity<ZenPack> saveZenPack(ZenPack zenPack) {
         repository.save(zenPack);
         return new ResponseEntity<>(zenPack, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<FeaturedList> saveFeauturedList(FeaturedList list) {
        return new ResponseEntity<>(list,HttpStatus.CREATED);
    }

}
