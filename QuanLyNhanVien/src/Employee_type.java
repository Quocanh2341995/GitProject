public enum Employee_type {
    EXPERIENCE(0), FRESHER(1), INTERN(2);
    private int value;
    Employee_type(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }


}
