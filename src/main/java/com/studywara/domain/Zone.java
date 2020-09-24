package com.studywara.domain;/*
 * @created 24/09/2020 - 7:28 오후
 * @project studywara
 * @author ryan
 */

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Zone {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String localNameOfCity;

    @Column(nullable = true)
    private String province;

    @Override
    public String toString(){
        return String.format("%s(%s)/%s", city,localNameOfCity,province);
    }
}

