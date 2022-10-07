package com.ZenPack;

import com.ZenPack.model.FeaturedList;
import com.ZenPack.repository.FeaturedListRepository;
import com.ZenPack.service.FeaturedListService;
import com.ZenPack.service.FeaturedListServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FeaturedListServiceImplTest {

    @Mock
    private FeaturedListRepository featuredListRepository;

    @InjectMocks
    private FeaturedListServiceImpl featuredListServiceImpl;

//    @Autowired
//    private FeaturedListService service;

    private FeaturedList list;
    private FeaturedList list1;

    @BeforeEach
    void init(){
        FeaturedList list=new FeaturedList();
        list.setId(1);
        list.setFeatureName("Project Management");
        list.setFeatureUrl(null);
        list.setCreatedTime(LocalDate.of(2022, Month.OCTOBER,06));
        list.setCreatedBy("Elavarasan");

        FeaturedList list1=new FeaturedList();
        list.setId(1);
        list.setFeatureName("Project Summary");
        list.setFeatureUrl(null);
        list.setCreatedTime(LocalDate.of(2022,Month.OCTOBER,06));
        list.setCreatedBy("Murugan");
    }

    @Test
    void save(){
        FeaturedList list=new FeaturedList();
        list.setId(1);
        list.setFeatureName("Project Management");
        list.setFeatureUrl(null);
        list.setCreatedTime(LocalDate.of(2022, Month.OCTOBER,06));
        list.setCreatedBy("Elavarasan");
        when(featuredListRepository.save(any(FeaturedList.class))).thenReturn(list);
        FeaturedList newList = featuredListServiceImpl.save(list);

        assertNotNull(newList);
        assertThat(newList.getFeatureName()).isEqualTo("Project Management");
    }

    @Test
    void getList(){
        List<FeaturedList> featuredLists = new ArrayList<>();
        featuredLists.add(list);
        featuredLists.add(list1);
        when(featuredListRepository.findAll()).thenReturn(featuredLists);
        List<FeaturedList> featuredLists1 =featuredListServiceImpl.findAllList();

        assertEquals(2,featuredLists1.size());
        assertNotNull(featuredLists);
    }

//    @Test
//    void getListByName(){
//        when(featuredListRepository.findByKeyword(anyString())).thenReturn(Optional.of(list));
//        FeaturedList existingList = featuredListServiceImpl.findByKeyword(list.getFeatureName());
//        assertNotNull(existingList);
//        assertThat(existingList.getFeatureName()).isNotEqualTo(null);

}
