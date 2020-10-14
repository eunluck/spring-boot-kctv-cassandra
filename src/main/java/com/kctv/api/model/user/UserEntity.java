package com.kctv.api.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "user_List_table")
public class UserEntity implements UserDetails {

    @PrimaryKeyColumn(value = "user_email_type",type = PrimaryKeyType.PARTITIONED,ordinal = 1)
    private String userEmailType;
    @PrimaryKeyColumn(value = "user_email",type = PrimaryKeyType.PARTITIONED,ordinal = 0)
    private String userEmail;
    @Column("user_address")
    private String userAddress;
    @Column("user_birth")
    private String userBirth;
    @Column("user_gender")
    private String userGender;
    @Column("user_mac")
    private String userMac;
    @Column("user_name")
    private String userName;
    @Column("user_nickname")
    private String userNickname;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column("user_password")
    private String userPassword;
    @Column("user_phone")
    private String userPhone;
    @Column("user_status")
    private String userStatus;
    @Column("create_date")
    private Date createDate;
    @Column("update_date")
    private Date updateDate;
    @Column("user_uid")
    private String userUid;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column("user_sns_key")
    private String userSnsKey;
    @Column("service_accept")
    private boolean serviceAccept;
    @Column("location_accept")
    private boolean locationAccept;
    @Column("marketing_accept")
    private boolean marketingAccept;


    @Builder.Default
    private List<String> roles = new ArrayList<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public String getPassword() {
        return null;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public String getUsername() {
        return this.userUid;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isEnabled() {
        return true;
    }
}
