package ed1priscilla.conjunto;

public class TesteConjunto {
    public static void main(String[] args) {
        Playlist playlist1 = new Playlist();
        Playlist playlist2 = new Playlist();

        // set títulos das playlists
        playlist1.setTitulo("Playlist 1");
        playlist2.setTitulo("Playlist 2");

        Musica musica1 = new Musica("Number One Fan", 0001, "MUNA", "Saves The World", 2019);
        Musica musica2 = new Musica("Idiota", 0002, "Jão", "Pirata", 2020);
        Musica musica3 = new Musica("As It Was", 0003, "Harry Styles", "As It Was", 2022);
        Musica musica4 = new Musica("Catch", 0004, "Allie X", "Collxtion I", 2015);
        Musica musica5 = new Musica("Summertime Gladness", 0005, "Dance Gavin Dance", "Summertime Gladness", 2017);
        Musica musica8  = new Musica("Die Another Day", 0005, "Dance Gavin Dance", "Jackpot Juicer", 2022);
        // músicas com mesmo título e id diferentes
        Musica musica6 = new Musica("Feels Bad Man", 0006, "Dance Gavin Dance", "Jackpot Juicer", 2022);
        Musica musica7 = new Musica("Feels Bad Man", 0007, "Dance Gavin Dance", "Jackpot Juicer", 2022);

        // insere músicas na playlist 1
        playlist1.insere(musica1);
        playlist1.insere(musica5);
        playlist1.insere(musica3);
        playlist1.insere(musica6);
        playlist1.insere(musica7);
        playlist1.insere(musica8);

        playlist1.imprime();

        // insere músicas na playlist 2
        playlist2.insere(musica2);
        playlist2.insere(musica4);
        playlist2.insere(musica1);

        // união de duas playlists
        Playlist uniao;
        uniao = playlist1.uniao(playlist2);
        uniao.imprime();

        //intersecão
        Playlist intersecao;
        intersecao = playlist1.intersecao(playlist2);
        intersecao.imprime();

        //complementar
        Playlist complementar;
        complementar = playlist1.complementar(playlist2);
        complementar.imprime();

        //subconjunto
        if (playlist2.subconjunto(playlist1))
            System.out.println("Subconjunto - Todas as músicas contidas na Playlist 2 estão na Playlist 1.\n");
        else
            System.out.println("Não é subconjunto - Algumas das músicas da Playlist 2 não estão na Playlist 1.\n");

        //diferencaPlaylists
        Playlist diferenca;
        diferenca = playlist2.diferencaPlaylists(playlist1);
        diferenca.imprime();

        // Testa igualdade das duas playlists
        if (playlist1.igualdadePlaylists(playlist2))
            System.out.println("Playlists iguais");
        else
            System.out.println("Playlists diferentes");

    }
}
