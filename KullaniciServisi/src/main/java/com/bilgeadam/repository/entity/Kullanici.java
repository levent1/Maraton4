package com.bilgeadam.repository.entity;

import com.bilgeadam.repository.enums.EDurum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "tbl_user")

public class Kullanici  extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ad;
    private String mail;
    private  String password;
    @Enumerated(EnumType.STRING)
    private EDurum durum;

}
