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
            } else if (valor > atual.getInfo()){
                atual.setDireita(recurcao(atual.getDireita(), valor));
            } else {
                return atual;
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

    public Node busca(Node atual, int valor){
        if (atual == null){
            return null;
        } else {
            if (valor < atual.getInfo()){
                return busca(atual.getEsquerda(), valor);
            } else if (valor > atual.getInfo()) {
                return busca(atual.getDireita(), valor);
            } else {
                return atual;
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

    private Node remover(Node atual, int valor){
        if (atual == null){
            return atual;
        } else {
            if (valor < atual.getInfo()){
                atual.setEsquerda(remover(atual.getEsquerda(), valor));
            } else if (valor > atual.getInfo()){
                atual.setDireita(remover(atual.getDireita(), valor));
            } else {
                if (atual.getEsquerda() == null){
                    return atual.getDireita();
                } else if (atual.getDireita() == null) {
                    return atual.getEsquerda();
                }
                atual.setInfo(menor(atual.getDireita()));
                atual.setDireita(remover(atual.getDireita(), atual.getInfo()));
            }
        }
        return atual;
    }

    public void remove(int valor){
        raiz = remover(raiz, valor);
    }
}
