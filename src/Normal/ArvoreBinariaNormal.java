package Normal;

public class ArvoreBinariaNormal {
    private Node raiz;

    public ArvoreBinariaNormal(){
        raiz = null;
    }

    public Node getRaiz() {
        return raiz;
    }

    public Node recurcao(Node atual, int valor){
        if (atual == null){
            Node no = new Node();
            no.setInfo(valor);
            atual = no;
            return atual;
        } else {
            if (valor < atual.getInfo()){
                atual.setEsquerda(recurcao(atual.getEsquerda(), valor));
            } else {
                atual.setDireita(recurcao(atual.getDireita(), valor));
            }
        }

        return atual;
    }

    public void inserir(int valor){
        raiz = recurcao(raiz, valor);
    }

    public void emOrdem(Node atual) {
        if (atual != null) {
            emOrdem(atual.getEsquerda());
            System.out.print(atual.getInfo() + " ");
            emOrdem(atual.getDireita());
        }
    }

    public void preOrdem(Node atual) {
        if(atual != null) {
            System.out.print(atual.getInfo() + " ");
            preOrdem(atual.getEsquerda());
            preOrdem(atual.getDireita());
        }
    }

    public void posOrdem(Node atual) {
        if(atual != null) {
            posOrdem(atual.getEsquerda());
            posOrdem(atual.getDireita());
            System.out.print(atual.getInfo() + " ");
        }
    }

    public Node busca(Node raiz, int valor){
        if (raiz == null){
            return null;
        } else {
            if (valor < raiz.getInfo()){
                return busca(raiz.getEsquerda(), valor);
            } else if (valor > raiz.getInfo()) {
                return busca(raiz.getDireita(), valor);
            } else {
                return raiz;
            }
        }
    }

    public int menor(Node no){
        int menor = no.getInfo();
        while (no.getEsquerda() != null){
            menor = no.getEsquerda().getInfo();
            no = no.getEsquerda();
        }
        return  menor;
    }

    private Node remover(Node raiz, int valor){
        if (raiz == null){
            return raiz;
        } else {
            if (valor < raiz.getInfo()){
                raiz.setEsquerda(remover(raiz.getEsquerda(), valor));
            } else if (valor > raiz.getInfo()){
                raiz.setDireita(remover(raiz.getDireita(), valor));
            } else {
                if (raiz.getEsquerda() == null){
                    return raiz.getDireita();
                } else if (raiz.getDireita() == null) {
                    return raiz.getEsquerda();
                }
                raiz.setInfo(menor(raiz.getDireita()));
                raiz.setDireita(remover(raiz.getDireita(), raiz.getInfo()));
            }
        }
        return raiz;
    }

    public void remove(int valor){
        raiz = remover(raiz, valor);
    }
}
