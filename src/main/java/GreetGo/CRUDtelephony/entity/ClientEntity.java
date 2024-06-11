package GreetGo.CRUDtelephony.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="clients")
public class ClientEntity extends AbstractClient{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
