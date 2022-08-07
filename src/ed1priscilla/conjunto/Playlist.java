package ed1priscilla.conjunto;

public class Playlist {
    private String titulo; // nome da playlist
    private Elo prim;  // referência para o primeiro elemento

    /* Classe auxiliar para guardar cada elemento (música) do conjunto (playlist). */
    private class Elo {
        Musica dado;
        Elo prox;

        public Elo() {
            prox = null;
        }

        public Elo(Musica elem) {
            dado = elem;
            prox = null;
        }

        public Elo(Musica elem, Elo prox_elem) {
            dado = elem;
            prox = prox_elem;
        }
    }

    /* construtor */
    public Playlist() {
        prim = null;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /* Função privada para realizar uma cópia de um outro conjunto */
    private void copia(Playlist playlist2) {
        Elo ult = null, q;

        prim = null;
        for (Elo p = playlist2.prim; p != null; p = p.prox) {
            q = new Elo(p.dado);
            if (ult == null)
                prim = q;
            else
                ult.prox = q;
            ult = q;
        }
    }

    /* apaga playlist. */
    public void apaga(){
        for (Elo p = prim; p != null; p = prim) {
            prim = prim.prox;
        }
    }

    /* Simula uma sobrecarga do operador de atribuição. */
    public Playlist atribui(Playlist playlist2) {
        if (this != playlist2)
        {
            apaga();
            copia(playlist2);
        }
        return this;
    }

    /* Testa se a playlist (conjunto) está vazia. */
    public boolean vazio(){
        return prim == null;
    }

    /* Teste de pertinência. Usa fato de estar ordenado */
    public boolean pertence(Musica musica) {
        Elo p;

        for (p = prim; ((p != null) && (p.dado.compareTo(musica) < 0)); p = p.prox);

        if ((p == null) || (p.dado.compareTo(musica) > 0)) return false;

        return true;
    }

    /* Inserção de elemento no conjunto. Usa fato de estar ordenado. Retorna false se elemento já estava lá. */
    public boolean insere(Musica musica) {
        Elo p = prim, ant = null;

        for (p = prim; (p != null); p = p.prox){
            if (p.dado.compareTo(musica) == 0) return false;
            if (p.dado.compareTo(musica) > 0) break;
            ant = p;
        }
        Elo q = new Elo(musica);
        if (p == prim)
            prim = q;
        else
            ant.prox = q;
        q.prox = p;
        return true;
    }

    /* Remoção de música da playlist. Usa fato de estar ordenado. Retorna false se elemento não estava lá. */
    public boolean remove(Musica musica) {
        Elo p = prim, ant = null;

        for (p = prim; (p != null); p = p.prox){
            if (p.dado.compareTo(musica) > 0) return false;
            if (p.dado.compareTo(musica) == 0) break;
            ant = p;
        }
        if (p == null) return false;
        if (p == prim)
            prim = prim.prox;
        else
            ant.prox = p.prox;

        p = null;
        return true;
    }

    /* Método para união de conjuntos. Une a playlist principal com playlist2 e retorna umq nova playlist com a união.
     * Usa fato de conjuntos estarem ordenados e percorre as listas em paralelo. */
    public Playlist uniao(Playlist playlist2) {
        Elo q, p1 = prim, p2 = playlist2.prim, ult = null;
        Playlist uniao = new Playlist();

        while ( (p1 != null) || (p2 != null) )
        {
            if ( (p1 != null) && ( (p2 == null) || (p1.dado.compareTo(p2.dado) < 0)))
            {
                q = new Elo(p1.dado);
                p1 = p1.prox;
            }
            else
            {
                q = new Elo(p2.dado);
                if ((p1 != null) && (p1.dado == p2.dado))
                    p1 = p1.prox;
                p2 = p2.prox;
            }

            if (ult == null)
                uniao.prim = q;
            else
                ult.prox = q;

            ult = q;
        }

        return uniao;
    }

    /* Método para intersecao de playlists. Calcula intersecao do playlist principal com playlist2 e retorna nova playlist com a intersecao.
     * Usa fato de conjuntos estarem ordenados e percorre as listas em paralelo. */
    public Playlist intersecao(Playlist playlist2) {
        Elo q, p1 = prim, p2 = playlist2.prim, ult = null;
        Playlist inter = new Playlist();

        while ((p1 != null) && (p2 != null)) {
            if (p1.dado.compareTo(p2.dado) < 0) {
                p1 = p1.prox;
            }
            else if(p2.dado.compareTo(p1.dado) < 0) {
                p2 = p2.prox;
            }
            else {
                q = new Elo(p1.dado);
                p1 = p1.prox;
                p2 = p2.prox;

                if (ult == null)
                    inter.prim = q;
                else
                    ult.prox = q;

                ult = q;
            }
        }

        return inter;
    }

    /* Retorna cardinalidade do conjunto */
    public int tamanho() {
        int tam = 0;
        Elo p;

        for(p = prim; p != null; p = p.prox)
            tam++;
        return tam;
    }

    /* Imprime todas as musicas da playlist */
    public void imprime() {
        Elo p;
        for(p = prim; p != null; p = p.prox)
            System.out.print(p.dado);
        System.out.println();
    }

    /* Retorna o complementar do conjunto (playlist). */
    public Playlist complementar(Playlist universo) {

        Elo prim1 = this.prim;
        Elo prim2 = universo.prim;

        Playlist comp = new Playlist(); // para guardar o conjunto complementar

        // loop que itera até o final do conjunto universo
        while (prim2 != null) {
            // se o elemento do conjunto universo for igual ao do conjunto 1...
            if (prim2.dado.compareTo(prim1.dado) == 0) {
                //...as heads de cada conjunto recebem o proximo elemento, caso o proximo elemento do conjunto 1 não seja nulo
                if (prim1.prox != null) {
                    prim2 = prim2.prox;
                    prim1 = prim1.prox;

                } else { // ...a head do conjunto universo recebe o proximo elemento
                    prim2 = prim2.prox;
                }
            } else if (prim2.dado.compareTo(prim1.dado) != 0) { // especificar isso aqui é redundante
                // se o elemento do conjunto universo for diferente do elemento do conjunto 1, ele é inserido
                // no conjunto complementar.
                // a head do conjunto universo recebe o proximo elemento desse mesmo conjunto
                comp.insere(prim2.dado);
                prim2 = prim2.prox;
            }
        }
        return comp;
    }

    /* verifica se um conjunto é subconjunto de outro conjunto.
    * ou seja, verifica se todas as músicas contidas em uma playlist estão contidas na playlist principal. */
    public boolean subconjunto(Playlist playlist2) {

        Elo prim1 = this.prim;
        Elo prim2 = playlist2.prim;

        while (prim2 != null) {
            if (prim1.dado.compareTo(prim2.dado) == 0) {
                if (prim1.prox != null) {
                    prim2 = prim2.prox;
                    prim1 = prim1.prox;
                } else {
                    return true;
                }
            } else if (prim2.dado.compareTo(prim1.dado) != 0) {
                prim2 = prim2.prox;
            }
        }

        return false;
    }

    /* retorna um conjunto que armazena a diferença entre duas playlists. */
    public Playlist diferencaPlaylists(Playlist playlist2) {

        Elo prim1 = this.prim;
        Elo prim2 = playlist2.prim;
        Elo ult = null;
        Elo aux;

        Playlist diferenca = new Playlist();

        while (prim1 != null) {
            if (prim1.dado.compareTo(prim2.dado) == 0) {
                prim1 = prim1.prox;
                prim2 = prim2.prox;

            } else if (prim1.dado.compareTo(prim2.dado) < 0) {
                aux = new Elo(prim1.dado);
                prim1 = prim1.prox;

                if (ult == null) {
                    diferenca.prim = aux;
                } else {
                    ult.prox = aux;
                }

                ult = aux;
            } else { // if prim2.dado.compareTo(prim1.dado) < 0
                prim2 = prim2.prox;
            }
        }
        return diferenca;
    }

    /* verifica se duas playlists são iguais ou não. (Se as duas possuem as mesmas músicas) */
    public boolean igualdadePlaylists(Playlist playlist2) {

        return igualdadePlaylistsRec(this.prim, playlist2.prim);
    }

    boolean igualdadePlaylistsRec(Elo prim1, Elo prim2) {

        if (prim1 == null && prim2 == null) { // caso ambas as listas estejam vazias
            return true;
        }

        if (prim1 != null && prim2 != null) {
            return (prim1.dado == prim2.dado) && igualdadePlaylistsRec(prim1.prox, prim2.prox);
        }

        // falso caso uma das listas esteja vazia e a outra não
        return false;
    }


}
