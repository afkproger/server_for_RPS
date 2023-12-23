package ru.technolog.sorting_algorithms_server.entitys.data;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public interface IDataEntity {
    Long getId();
    String getGUID();
    Integer getVersion();
    void upVersion();
}
