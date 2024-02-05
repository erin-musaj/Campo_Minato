import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Cm {

    int[][] campo;
    String[][] gioco;

    public Cm(int righe, int colonne){
        campo = new String[righe][colonne];
    }

    public void inizializzaCampo(){
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo[i].length; j++) {
                campo[i][j] = -1;
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

            this.campo[riga][colonna] = -2;
        }
    }

    public boolean eseguiClick(int y, int x){
        if(this.campo[y][x]==-2){
            return false;
        } else {
            LinkedList<Integer> visitati = new LinkedList<Integer>();
            LinkedList<Integer> coda = new LinkedList<>();
            this.campo[y][x] = 0;
            coda.add(y*this.campo[0].length + x);
            int cx = x;
            int cy = y;
            while(coda.isEmpty()){
                int cella = coda.pop();
                cx = cella/this.campo[0].length;
                cy = cella % this.campo[0].length;
                if(this.campo[cy][cx]==-1){
                    for(int i = -1; i<=1; i++){
                        for (int j = -1; j <= 1 ; j++) {
                            try{
                                if(!visitati.contains(cy*this.campo[0].length + cx) && this.campo[cy+i][cx+j]!=-2){
                                    coda.add(cy*this.campo[0].length + cx);
                                    if(this.campo[cy][cx] == -1){
                                        this.campo[cy][cx] = 0;
                                    } else if (this.campo[cy][cx] < 9 && this.campo[cy][cx]> 17){
                                        this.campo[cy][cx] -= 9;
                                    }
                                }
                            } catch (Exception ignored){}
                        }
                    }
                }
            }
        }
        return true;
    }

}
