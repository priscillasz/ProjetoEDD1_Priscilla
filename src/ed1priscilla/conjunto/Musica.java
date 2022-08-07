package ed1priscilla.conjunto;

public class Musica implements Comparable<Musica> {
    private String titulo;
    private int id; //
    private String artista;
    private String album;
    private int anoLancamento;

    /* Construtores */
    public Musica(String titulo, int id, String artista, String album, int anoLancamento) {
        this.titulo = titulo;
        this.id = id;
        this.artista = artista;
        this.album = album;
        this.anoLancamento = anoLancamento;
    }

    /* public Musica() { }*/

    /* Getters e setters */
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    /* toString */
    @Override
    public String toString() {
        return "Título: '" + titulo + '\'' +
                ", ID: " + id +
                ", Artista: " + artista + '\'' +
                ", Álbum: " + album + '\'' +
                ", Ano de Lançamento: " + anoLancamento +
                "\n";
    }

    /* implementa compareTo */
    @Override
    public int compareTo(Musica o) {
        if (this.id > o.id)
            return 1;
        else if (this.id < o.id)
            return -1;
        else
            return 0;
    }
}
