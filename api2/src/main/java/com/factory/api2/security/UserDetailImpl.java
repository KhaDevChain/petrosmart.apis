package com.factory.api2.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.factory.api2.models.sso.Employee;
import com.factory.api2.models.sso.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Dùng để chuyển thông tin employee thành dạng yêu cầu của Spring Security Interface là UserDetails
 */
@ToString
@Data
@AllArgsConstructor
public class UserDetailImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    // lấy thông tin của employee
    public Employee employee;

    // danh sách list role
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(
            authority -> new SimpleGrantedAuthority(authority.getRoleName())
        ).collect(Collectors.toList());
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return employee.getPassword();
    }

    @Override
    public String getUsername() {
        return employee.getEmail();
    }

    @Override
    public boolean isEnabled() {
        return employee.isActivated();
    }
}
