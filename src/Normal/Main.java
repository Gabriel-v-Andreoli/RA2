package Normal;


import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArvoreBinariaNormal arvore = new ArvoreBinariaNormal();
        Random random = new Random();

        for (int i = 0; i < 30000; i++) {
            arvore.inserir(random.nextInt());
        }
        /*long inicio = System.nanoTime();
        arvore.remove(566938067);
        long fim = System.nanoTime();*/
        long inicio = System.nanoTime();
        arvore.busca(arvore.getRaiz(),566938067);
        long fim = System.nanoTime();

        long resultado = fim - inicio;
        System.out.println(resultado);
    }
}
