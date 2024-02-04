import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Cm {

    String[][] campo;
    String[][] gioco;

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
        LinkedList<Integer> celleDisp = new LinkedList <>();
        for (int i = 0; i < campo.length*campo[0].length; i++) {
            celleDisp.add(i);
        }

        int ncelle = (this.campo[0].length * this.campo.length);
        Random r = new Random();

        for (int i = 0; i < ncelle; i++) {
            int celle = r.nextInt(celleDisp.size());
            celleDisp.remove(celle);
            int riga = celle/this.campo[0].length;
            int colonna = celle % this.campo[0].length;

            this.campo[riga][colonna] = "-1";
        }
    }

    public boolean eseguiClick(int riga, int colonna){
        if(this.campo[riga][colonna].equals("-1")){
            return false;
        } else {
            Queue<Integer> coda = new LinkedList<>();
            coda.add(riga*this.campo[0].length + colonna);
            while(coda.isEmpty()){
                int a = 0;
                if(riga!=0 && (campo[coda.peek()/this.campo[0].length][colonna]==0)){
                    coda.add(riga-1*this.campo[0].length + colonna);
                }
            }
        }
    }

}
