import Benda.Benda;
import Benda2D.*;
import Benda3D.*;
import Threading.*;

public class Main {
    public static void main(String[] args) {

        Persegi persegi = new Persegi(5);      // extends Benda2D
        Bola bola = new Bola(7);

        Thread t1 = new Thread(new HitungBendaTask(persegi));
        Thread t2 = new Thread(new HitungBendaTask(bola));

        t1.start();
        t2.start();
        new MainMenuView().setVisible(true);
    }
}