package com.juno.competitionmanagementsystemserver.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

public class AuthUserDetails implements UserDetails {
    private final String username;

    private final String password;

    private final Integer userId;

    private Integer tokenId;

    private final String role;

    private Date expiresAt;

    private final Collection<? extends GrantedAuthority> authorities;

    public AuthUserDetails(String username, String password, Integer userId, String role) {
        this.username = username;
        this.password = password;
        this.userId = userId;
        this.role = role;
        this.authorities =  AuthorityUtils.commaSeparatedStringToAuthorityList(this.getRole());
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }

    public void setTokenId(Integer tokenId) {
        this.tokenId = tokenId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getTokenId() {
        return tokenId;
    }

    public String getRole() {
        return role;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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
        Date current = new Date(System.currentTimeMillis());
        if (this.expiresAt == null) {
            return true;
        } else {
            return !this.expiresAt.before(current);
        }
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
