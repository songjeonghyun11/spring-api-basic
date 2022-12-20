package com.example.sec1.user.entity;

import com.example.sec1.user.model.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;
    @Column
    private String userName;
    @Column
    private String password;
    @Column
    private String phone;
    @Column
    private LocalDateTime regDate;
    @Column
    private LocalDateTime updateDate;
    @Column
    private UserStatus status;
    @Column
    private boolean lockYn;

}
