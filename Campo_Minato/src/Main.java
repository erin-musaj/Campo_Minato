public class Main {
    public class CampoMinato {

        private static final int RIGHE = 5; // Numero di righe del campo minato
        private static final int COLONNE = 5; // Numero di colonne del campo minato

        // Funzione per trovare le celle adiacenti
        private static void trovaCelleAdiacenti(int[][] campoMinato, int riga, int colonna) {
            for (int i = riga - 1; i <= riga + 1; i++) {
                for (int j = colonna - 1; j <= colonna + 1; j++) {
                    // Verifica se la cella è all'interno del campo minato
                    if (i >= 0 && i < RIGHE && j >= 0 && j < COLONNE) {
                        // Ignora la cella stessa
                        if (i != riga || j != colonna) {
                            System.out.println("Cella adiacente: (" + i + ", " + j + ")");
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] campoMinato = {
                {0, 1, 0, 0, 1},
                {1, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 0, 1, 0}
        };

        int riga = 2;
        int colonna = 2;

        System.out.println("Celle adiacenti alla cella (" + riga + ", " + colonna + "):");
        CampoMinato.trovaCelleAdiacenti(campoMinato, riga, colonna);
    }
}