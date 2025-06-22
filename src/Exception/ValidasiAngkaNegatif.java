package Exception;

public class ValidasiAngkaNegatif extends Exception {

    public void operasiAngkaNegatif(double nilai) throws IllegalArgumentException {
        if (nilai <= 0) {
            throw new IllegalArgumentException("Nilai tidak boleh nol atau negatif: " + nilai);
        }
    }

    public ValidasiAngkaNegatif() {
        super();
    }

    public ValidasiAngkaNegatif(String message) {
        super(message);
    }
}
