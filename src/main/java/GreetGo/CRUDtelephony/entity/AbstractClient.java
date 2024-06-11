package GreetGo.CRUDtelephony.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractClient {
    private String firstName;
    private String lastName;
    private String phone;
    private String secondPhone;
    private String birthday;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}

