package com.ZenPack.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sub_menu")
public class SubMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sub_menu_id")
    private Long subMenuId;
    @Column(name = "sub_menu_name")
    private String subMenuName;


    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "sub_menu_id")
    private List<FeaturedList> features;
}
