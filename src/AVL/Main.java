package AVL;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();
        Random random = new Random();
        long inicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arvore.inserir(random.nextInt());
        }
        long fim = System.nanoTime();

        long resultado = fim - inicio;
        System.out.println(resultado);
    }


}
