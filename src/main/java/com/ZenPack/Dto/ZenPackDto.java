package com.ZenPack.Dto;

import com.ZenPack.model.FeaturedList;
import com.ZenPack.model.Menu;
import lombok.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ZenPackDto {
    private Integer id;
    private String name;
    private String createdBy;
    private Date createdDate=new Date();
    private String updatedBy;
    private Date updatedTime=new Date();
    private List<Menu> menus;
//    private List<FeaturedList> features;
}
