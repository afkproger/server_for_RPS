package ru.technolog.sorting_algorithms_server.entitys.data;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
public class saUserAuthData implements UserDetails, IDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String GUID;
    private int version;
    private String username;
    private String password;
    private String displayableUsername;
    private boolean enabled;
    private String roles;

    public void setId(Long id) {
        this.id = id;
    }

    public void setGUID(String GUID) {
        this.GUID = GUID;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayableUsername() {
        return displayableUsername;
    }

    public void setDisplayableUsername(String displayableUsername) {
        this.displayableUsername = displayableUsername;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isAccountNonExpired();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new saRole(roles,roles));
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getGUID() {
        return GUID;
    }

    @Override
    public Integer getVersion() {
        return version;
    }

    @Override
    public void upVersion() {
        version++;
    }
}
