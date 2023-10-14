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

    public boolean busca(Node raiz, int valor){
        if (raiz == null){
            return false;
        } else {
            if (valor < raiz.getInfo()){
                return busca(raiz.getEsquerda(), valor);
            } else if (valor > raiz.getInfo()) {
                return busca(raiz.getDireita(), valor);
            } else {
                return true;
            }
        }
    }


}
