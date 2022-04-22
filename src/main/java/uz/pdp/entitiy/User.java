package uz.pdp.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue
    private UUID id;//userning takrorlanmas qismi

    @Size(min = 3, max = 50)
    @Column(nullable = false, length = 50)
    private String firstName;//ismi

    @Length( min = 3, max = 50)
    @Column(nullable = false, length = 50)
    private String lastName;//familiyasi

    @Column(nullable = false, unique = true)
    private String email;//userning emaili(USERNAME SIFATIDA )

    @Column(nullable = false)
    private String password;//kalit so'zi

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;//qachon ro'yhatdan o'tganligi

    @UpdateTimestamp
    private Timestamp updateAt;//oxirgi marta qachon tahrirlanganligi

    @ManyToMany
    private Set<Role> roles;

    private boolean AccountNonExpired = true;//BU USERNING AMAL QILISH MUDDATI O'TMAGAN

    private boolean AccountNonLocked=true;//BU USER BLOKLANMAGANLIGI

    private boolean CredentialsNonExpired=true;

    private boolean Enabled;

    private  String emailCode;


    //--------BU USERDETAILSNING METODLARI---------//

    //BU USERNING HUQUQLARI RO'YXATI

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }
//USERNING USERNAMENI QAUTARUVCHI METODLARI
    @Override
    public String getUsername() {
        return email;
    }
//ACCAUNTNING AMAL QILISH NUDDATINI O'TMAGANINI QAYTARADI
    @Override
    public boolean isAccountNonExpired() {
        return AccountNonExpired;
    }
    //ACCAUNT BLOCLANGANLIGI HOLATINI QAYTARADI
    @Override
    public boolean isCredentialsNonExpired() {
        return CredentialsNonExpired;
    }

    //ACCAUNTNING ISHONCHLILIK MUDDATI TUGAMGANMI
    @Override
    public boolean isAccountNonLocked() {
        return AccountNonLocked;
    }
//ACCAUNTNINNG YONIQ UCHIQLIGINI QAYTARADI
    @Override
    public boolean isEnabled() {
        return Enabled;
    }
}
