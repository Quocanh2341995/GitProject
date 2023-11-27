package model;

public enum Role {
    ClassMonitor("Lop Truong"), Member("Thanh vien"), ViceMonitor("Lop Pho");

    private final String value;

    Role (String value) {
        this.value = value;
    }
}
