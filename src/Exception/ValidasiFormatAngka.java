package Exception;

public class ValidasiFormatAngka extends Exception {
    public void operasiFormatAngka(String input) throws NumberFormatException {
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Format angka tidak valid: " + input);
        }
    }

    public ValidasiFormatAngka() {
        super();
    }

    public ValidasiFormatAngka(String message) {
        super(message);
    }
}



