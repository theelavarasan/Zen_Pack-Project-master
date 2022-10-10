package com.ZenPack.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Featured_List")
public class FeaturedList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "feature_name")
    private String featureName;
    @Column(name = "feature_url")
    private String featureUrl;
    @Column(name = "created_time")
    private Date createdTime=new Date();
    @Column(name = "created_by")
    private String createdBy;
}
