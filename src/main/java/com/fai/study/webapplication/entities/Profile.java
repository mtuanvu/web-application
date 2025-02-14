package com.fai.study.webapplication.entities;

import com.fai.study.webapplication.utils.DateTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profiles")
public class Profile extends DateTime {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String displayName;
    private String avatarUrl;
    private String bio;


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Profile(String displayName, String avatarUrl, String bio, User user) {
        this.displayName = displayName;
        this.avatarUrl = avatarUrl;
        this.bio = bio;
        this.user = user;
    }
}
