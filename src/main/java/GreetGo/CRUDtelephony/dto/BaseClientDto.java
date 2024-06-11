package GreetGo.CRUDtelephony.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseClientDto {
    private String firstName;
    private String lastName;
    private String phone;
    private String secondPhone;
    private String birthday;
}
