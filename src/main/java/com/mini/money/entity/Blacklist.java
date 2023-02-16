package com.mini.money.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "blacklist")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
public class Blacklist {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "token")
    private String token;

    @CreationTimestamp
    @Column(name = "input_date")
    private Date inputDate;

}
