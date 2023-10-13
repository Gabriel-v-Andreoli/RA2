import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArvoreBinariaNormal arvore = new ArvoreBinariaNormal();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            arvore.inserir(random.nextInt(11));
        }

        arvore.emOrdem(arvore.getRaiz());
        System.out.println();
        arvore.preOrdem(arvore.getRaiz());
        System.out.println();
        arvore.posOrdem(arvore.getRaiz());
    }
}
