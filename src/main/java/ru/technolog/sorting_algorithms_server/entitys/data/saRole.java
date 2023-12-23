package ru.technolog.sorting_algorithms_server.entitys.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "sa_role")
public class saRole implements GrantedAuthority, IDataEntity{
    @Id
    @GeneratedValue
    private Long id;
    private String code;
    private String GUID;
    private String title;
    private int version;

    public saRole(String code, String title) {
        this.code = code;
        this.title = title;
    }

    @Override
    public String getAuthority() {
        return code;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
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