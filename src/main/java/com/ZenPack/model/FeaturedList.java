package com.ZenPack.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Featured_List")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FeaturedList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feature_id")
    private Integer featureId;
    @Column(name = "feature_name")
    private String featureName;
    @Column(name = "feature_url")
    private String featureUrl;
    @Column(name = "created_time")
    private Date createdTime=new Date();
    @Column(name = "created_by")
    private String createdBy;
}
