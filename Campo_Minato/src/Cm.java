import java.util.LinkedList;
import java.util.Random;

public class Cm {

    String[][] campo;

    public Cm(int righe, int colonne){
        campo = new String[righe][colonne];
    }

    public void inizializzaCampo(){
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo[i].length; j++) {
                campo[i][j] = " ";
            }
        }
    }

    public void posizionaMine(int percentuale){
        LinkedList<Integer> celleDisp = new LinkedList<Integer>();
        for (int i = 0; i < campo.length*campo[0].length; i++) {
            celleDisp.add(i);
        }

        Random r = new Random();

        for (int i = 0; i < percentuale; i++) {
            int celle = r.nextInt(celleDisp.size());
            int riga = celle/this.campo[0].length;
            int colonna = celle % this.campo[0].length;

            this.campo[riga][colonna] = "-1";
        }
    }

}
