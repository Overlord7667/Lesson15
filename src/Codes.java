enum Codes {
    CREATE(0), READ(1), UPDATE(2), DELETE(3);

    public int getCode() {
        return code;
    }

    Codes(int code) {
        this.code = code;
    }

    public static Codes getEnumByCode(int code) throws Exception {
        for (Codes c : Codes.values()) {
            if (c.code == code) {
                return c;
            }
        }
        throw new Exception("No equals");
    }

    private final int code;
}
