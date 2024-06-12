package GreetGo.CRUDtelephony.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class ClientDocument {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String secondPhone;
    private String birthday;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
