package Normal;

import Normal.ArvoreBinariaNormal;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArvoreBinariaNormal arvore = new ArvoreBinariaNormal();
        Random random = new Random();

        arvore.inserir(5);
        arvore.inserir(8);
        arvore.inserir(2);
        arvore.inserir(6);
        arvore.inserir(1);
        arvore.inserir(5);
        arvore.inserir(3);
        arvore.inserir(4);
        arvore.inserir(7);
        arvore.inserir(10);
        arvore.inserir(9);
        arvore.inserir(6);

        arvore.emOrdem(arvore.getRaiz());
        System.out.println();
        arvore.remove(6);
        arvore.emOrdem(arvore.getRaiz());
        System.out.println();
        System.out.println(arvore.busca(arvore.getRaiz(), 6));
        arvore.remove(6);
        arvore.emOrdem(arvore.getRaiz());
        System.out.println();
        System.out.println(arvore.busca(arvore.getRaiz(), 6));
    }
}
