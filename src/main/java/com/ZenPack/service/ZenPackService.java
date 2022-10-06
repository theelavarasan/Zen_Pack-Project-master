package com.ZenPack.service;

import com.ZenPack.model.FeaturedList;
import com.ZenPack.model.ZenPack;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ZenPackService {
//    ResponseEntity<ZenPack> saveZenPack(ZenPack zenPack);

    ResponseEntity<FeaturedList> saveFeatureList(FeaturedList featuredList);

    ResponseEntity<List<FeaturedList>> findAllList();

    //Get Feature_list by keyword
    List<FeaturedList> findByKeyword(String keyword);


//    ResponseEntity<FeaturedList> saveFeauturedList(FeaturedList list);
}
