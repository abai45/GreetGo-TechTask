package GreetGo.CRUDtelephony.entity;

import GreetGo.CRUDtelephony.enumeration.OperationEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractAudit {
    private LocalDateTime date;
    private OperationEnum operationType;
}
