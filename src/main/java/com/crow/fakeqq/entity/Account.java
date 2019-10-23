package com.crow.fakeqq.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Accounts",uniqueConstraints = {
        @UniqueConstraint(columnNames = "username")
})
@Data
public class Account implements Serializable {
    @Id
    @Column(length = 50)
    private String id;
    @Column(length = 20)
    private String username;
    @Column(length = 20)
    private String password;
    @Column(length = 50)
    private Long create_time;
    @Column(length = 12)
    private String nickname;
    @Column(length = 200)
    private String address;
    @Column(length = 50)
    private String headImg;
    @Column(length = 200)
    private String bio;
    @Column(length = 2)
    private int status;
}
