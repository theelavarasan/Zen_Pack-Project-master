package com.ZenPack;

import com.ZenPack.model.FeaturedList;
import com.ZenPack.repository.FeaturedListRepository;
import com.ZenPack.service.Impl.FeaturedListServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FeaturedListServiceImplTest {

    @Mock
    private FeaturedListRepository featuredListRepository;

    @InjectMocks
    private FeaturedListServiceImpl featuredListServiceImpl;



    private FeaturedList list;
    private FeaturedList list1;

    @BeforeEach
    void init(){
        FeaturedList list=new FeaturedList();
        list.setId(1);
        list.setFeatureName("Project Management");
        list.setFeatureUrl(null);
//        list.setCreatedTime(LocalDate.of(2022, Month.OCTOBER,06));
        list.setCreatedBy("Elavarasan");

        FeaturedList list1=new FeaturedList();
        list.setId(2);
        list.setFeatureName("Project Summary");
        list.setFeatureUrl(null);
//        list.setCreatedTime(LocalDate.of(2022,Month.OCTOBER,06));
        list.setCreatedBy("Murugan");
    }

    @Test
    void save(){
        FeaturedList list=new FeaturedList();
        list.setId(1);
        list.setFeatureName("Project Management");
        list.setFeatureUrl(null);
//        list.setCreatedTime(LocalDate.of(2022, Month.OCTOBER,06));
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

//    @Test
//    void updateList() {
//
//        when(featuredListRepository.findById(anyInt())).thenReturn(Optional.of(list));
//
//        when(featuredListRepository.save(any(FeaturedList.class))).thenReturn(list);
//        list.setFeatureName("Project");
//        FeaturedList exisitingMovie = featuredListServiceImpl.updateList(list, list.getId());
//
//        assertNotNull(exisitingMovie);
//        assertEquals("Project Management", list.getFeatureUrl());
//    }
//
//    @Test
//    void deleteList() {
//
//        Integer listId = 2;
//        when(featuredListRepository.findById(anyInt())).thenReturn(Optional.of(list));
////        this.list= Objects.requireNonNull(list,"list must not be null");
//        doNothing().when(featuredListRepository).delete(any(FeaturedList.class));
//
//        featuredListServiceImpl.deleteList(listId);
//
//        verify(featuredListRepository, times(2)).delete(list);
//
//    }

    @Test
    void delete(){
        Integer listId = 19;

        willDoNothing().given(featuredListRepository).deleteById(listId);

        featuredListServiceImpl.deleteList(listId);

        verify(featuredListRepository,times(1)).deleteById(listId);
    }

}
