package com.ZenPack.controller;

import com.ZenPack.model.FeaturedList;
import com.ZenPack.service.ZenPackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FeatureListController {

    @Autowired
    private ZenPackServiceImpl service;

    @PostMapping("/create_feature_list")
    public ResponseEntity<FeaturedList> saveFeatureList(@RequestBody FeaturedList featuredList){
        return service.saveFeatureList(featuredList);
    }

    @GetMapping("/get_feature_list")
    public ResponseEntity<List<FeaturedList>> findAllFeatureList(){
        return service.findAllList();
    }

    @GetMapping("/feature_list")
    public List<FeaturedList> findByName(@RequestParam String keyword){
        return service.findByKeyword(keyword);
    }

}
