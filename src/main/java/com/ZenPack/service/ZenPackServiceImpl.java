package com.ZenPack.service;

import com.ZenPack.model.FeaturedList;
import com.ZenPack.model.ZenPack;
import com.ZenPack.repository.ZenPackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZenPackServiceImpl implements ZenPackService{


    @Autowired
    private ZenPackRepository repository;

    @Override
    public ResponseEntity<FeaturedList> saveFeatureList(FeaturedList featuredList) {
        repository.save(featuredList);
        return new ResponseEntity<>(featuredList,HttpStatus.CREATED);
    }

    //Get the Feature_List
    @Override
    public ResponseEntity<List<FeaturedList>> findAllList() {
        repository.findAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Get Feature_list by keyword
    @Override
    public List<FeaturedList> findByKeyword(String keyword){
        return repository.findByKeyword(keyword);
    }


}
