package ru.sapteh.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "logun")
    private String logun;

    @Column(name = "password")
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", logun='" + logun + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
