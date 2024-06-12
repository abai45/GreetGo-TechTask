package GreetGo.CRUDtelephony.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDocumentDto {
    private String firstName;
    private String lastName;
    private String phone;
    private String secondPhone;
    private String birthday;
    private String createdAt;
    private String updatedAt;
}
