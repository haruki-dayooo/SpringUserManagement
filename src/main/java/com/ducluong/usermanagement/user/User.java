package com.ducluong.usermanagement.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tblusers")
@Table(name = "tblusers")
public class User implements UserDetails {
    @Id
    @Column(name = "userid", updatable = false, nullable = false, columnDefinition = "TEXT")
    private String userId;

    @Column(name = "password", columnDefinition = "TEXT")
    @JsonIgnore
    private String password;

    @Column(name = "fullname", columnDefinition = "TEXT")
    private String fullName;

    @Column(name = "roleid", columnDefinition = "TEXT")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "status", columnDefinition = "TEXT")
    private boolean status;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return status;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
