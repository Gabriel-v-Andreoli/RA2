package AVL;

public class ArvoreAVL {
    private Node raiz;

    public ArvoreAVL() {
        raiz = null;
    }

    public Node getRaiz() {
        return raiz;
    }

    public int maior(Node n1, Node n2){
        if (altura(n1) > altura(n2)){
            return altura(n1);
        } else {
            return altura(n2);
        }
    }

    public int altura(Node atual) {
        if (atual == null) {
            return 0;
        }
        return atual.getAltura();
    }

    public int balanco(Node atual) {
        if (atual == null) {
            return 0;
        }
        return altura(atual.getEsquerda()) - altura(atual.getDireita());
    }

    public Node giraDireita(Node atual) {
        Node a = atual.getEsquerda();
        Node b = a.getDireita();
        a.setDireita(atual);
        atual.setEsquerda(b);
        atual.setAltura(maior(atual.getEsquerda(), atual.getDireita()) + 1);
        a.setAltura(maior(a.getEsquerda(), a.getDireita()) + 1);
        return a;
    }

    public Node giraEsquerda(Node atual) {
        Node a = atual.getDireita();
        Node b = a.getEsquerda();
        a.setEsquerda(atual);
        atual.setDireita(b);
        atual.setAltura(maior(atual.getEsquerda(), atual.getDireita()) + 1);
        a.setAltura(maior(a.getEsquerda(), a.getDireita()) + 1);
        return a;
    }

    public Node iRecurcao(Node atual, int valor) {
        if (atual == null) {
            Node no = new Node();
            no.setInfo(valor);
            atual = no;
            return atual;
        }
        if (valor < atual.getInfo()) {
            atual.setEsquerda(iRecurcao(atual.getEsquerda(), valor));
        } else {
            atual.setDireita(iRecurcao(atual.getDireita(), valor));
        }
        atual.setAltura(1 + maior(atual.getEsquerda(), atual.getDireita()));
        int balance = balanco(atual);
        if (balance > 1 && valor < atual.getEsquerda().getInfo()) {
            return giraDireita(atual);
        }
        if (balance < -1 && valor > atual.getDireita().getInfo()) {
            return giraEsquerda(atual);
        }
        if (balance > 1 && valor > atual.getEsquerda().getInfo()) {
            atual.setEsquerda(giraEsquerda(atual.getEsquerda()));
            return giraDireita(atual);
        }
        if (balance < -1 && valor < atual.getDireita().getInfo()) {
            atual.setDireita(giraDireita(atual.getDireita()));
            return giraEsquerda(atual);
        }

        return atual;
    }

    public void inserir(int valor) {
        raiz = iRecurcao(raiz, valor);
    }

    public Node encontrarMenorValor(Node no) {
        Node atual = no;
        while (atual.getEsquerda() != null) {
            atual = atual.getEsquerda();
        }
        return atual;
    }
    public Node rRecurcao(Node atual, int valor) {
        if (atual == null) {
            return atual;
        } else {
            if (valor < atual.getInfo()) {
                atual.setEsquerda(rRecurcao(atual.getEsquerda(), valor));
            } else if (valor > atual.getInfo()) {
                atual.setDireita(rRecurcao(atual.getDireita(), valor));
            } else {
                if (atual.getEsquerda() == null || atual.getDireita() == null) {
                    Node temp = (atual.getEsquerda() != null) ? atual.getEsquerda() : atual.getDireita();

                    if (temp == null) {
                        temp = atual;
                        atual = null;
                    } else {
                        atual = temp;
                    }
                } else {
                    Node temp = encontrarMenorValor(atual.getDireita());
                    atual.setInfo(temp.getInfo());
                    atual.setDireita(rRecurcao(atual.getDireita(), temp.getInfo()));
                }
            }
        }
        if (atual == null) {
            return atual;
        } else {
            atual.setAltura(1 + maior(atual.getEsquerda(), atual.getDireita()));
            int balancoAtual = balanco(atual);
            if (balancoAtual > 1 && balanco(atual.getEsquerda()) >= 0) {
                return giraDireita(atual);
            }
            if (balancoAtual > 1 && balanco(atual.getEsquerda()) < 0) {
                atual.setEsquerda(giraEsquerda(atual.getEsquerda()));
                return giraDireita(atual);
            }
            if (balancoAtual < -1 && balanco(atual.getDireita()) <= 0) {
                return giraEsquerda(atual);
            }
            if (balancoAtual < -1 && balanco(atual.getDireita()) > 0) {
                atual.setDireita(giraDireita(atual.getDireita()));
                return giraEsquerda(atual);
            }
            return atual;
        }
    }

    public void remover(int valor) {
        raiz = rRecurcao(raiz, valor);
    }

    public Node busca(Node atual, int valor) {
        if (atual == null) {
            return null;
        } else {
            if (valor == atual.getInfo()) {
                return atual;
            } else if (valor < atual.getInfo()) {
                return busca(atual.getEsquerda(), valor);
            } else {
                return busca(atual.getDireita(), valor);
            }
        }
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
}

