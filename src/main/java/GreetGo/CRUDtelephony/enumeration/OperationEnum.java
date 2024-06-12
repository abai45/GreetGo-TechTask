package GreetGo.CRUDtelephony.enumeration;

public enum OperationEnum {
    CREATE("Create"),
    READ("Read"),
    UPDATE("Update"),
    DELETE("Delete");
    private final String value;
    OperationEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }
}
