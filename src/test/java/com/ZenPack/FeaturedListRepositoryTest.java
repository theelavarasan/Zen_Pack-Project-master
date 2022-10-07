package com.ZenPack;

import com.ZenPack.model.FeaturedList;
import com.ZenPack.repository.FeaturedListRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class FeaturedListRepositoryTest {
    @Autowired
    private FeaturedListRepository featuredListRepository;

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
    @DisplayName("It Should save the list to database")
    void save(){
        FeaturedList newList = featuredListRepository.save(list);
        assertNotNull(newList);
        assertThat(newList.getId()).isNotEqualTo(null);
    }
}
