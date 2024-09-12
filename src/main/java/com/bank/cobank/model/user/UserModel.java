package com.bank.cobank.model.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "fullname", nullable = false, length = 100)
    private String fullname;

    @Transient
    private String firstname;

    @Transient
    private String lastname;

    @Column(name = "phonenumber", nullable = false, unique = true, length = 20)
    private String phonenumber;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "password_changed_at")
    private Date passwordChangedAt;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "is_default_account")
    private Boolean isDefaultAccount;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private UserRole role;

    @Column(name = "otp")
    private String otp;

    @Column(name = "is_verified", nullable = false)
    private boolean isVerified;

    @PrePersist
    public void prePersist() {
        this.password = BCrypt.hashpw(this.password, BCrypt.gensalt());
    }

    @PostLoad
    public void postLoad() {
        if (this.fullname != null) {
            String[] names = this.fullname.split(" ");
            this.firstname = names.length > 0 ? names[0] : null;
            this.lastname = names.length > 1 ? names[1] : null;
        }
    }
}
