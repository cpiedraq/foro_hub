package com.alura.challenge_cpiedra.models;

import com.alura.challenge_cpiedra.DtoGetData.user.DtoCreateUser;
import com.alura.challenge_cpiedra.DtoGetData.user.DtoCreateUserToDatabase;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Table(name = "user")
@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "Id")
public class User implements UserDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Code;
    private String username;
    private String email;
    private String password;

    @JoinColumn(name="type_profile", referencedColumnName="code")
    @OneToOne
    private Profile profile;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public User(DtoCreateUserToDatabase dtoCreateUserToDatabase)
    {
        this.username = dtoCreateUserToDatabase.username();
        this.email = dtoCreateUserToDatabase.email();
        this.password = dtoCreateUserToDatabase.passwordEncrypted();
        this.profile = dtoCreateUserToDatabase.typeOfProfile();
    }
}
