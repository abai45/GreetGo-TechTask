package GreetGo.CRUDtelephony.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class ClientDocument extends Auditable{
    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String phone;
    @Indexed(unique = true)
    private String secondPhone;
    private String birthday;
}
