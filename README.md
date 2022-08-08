# Projeto Final de Estruturas de Dados I 2022.1

## Filas de Prioridade: Fila de Processos

O escalonamento FIFO (priority scheduling) é um dos algoritmos de escalonamento mais comuns em sistemas em lote. Nessa aplicação, a implementação foi feita através de uma Array que armazena objetos do tipo Processo. A cada processo é atribuída uma prioridade e o processo com a prioridade mais alta deve ser executado primeiro. Os processos com a mesma prioridade são executados por ordem de chegada. A prioridade, então, pode ser decidida com base nos requisitos de memória, requisitos de tempo ou qualquer outro requisito de recursos. Se dois processos tiverem o mesmo tempo de chegada, as suas prioridades são então comparadas (processo com maior prioridade primeiro). Se dois processos tiverem a mesma prioridade, seus números de identificação são comparados (o processo com menor número vem primeiro).

### Diagrama de Classes da Implementação
<img
  src="https://i.imgur.com/D4ORyuX.png"
  alt="Alt text"
  title="Optional title"
  style="display: inline-block; margin: 0 auto; max-width: 300px">
  
## Conjuntos: Playlist de Músicas

Conjuntos são estruturas de dados capazes de armazenar valores sem uma ordem específica e sem repetição, ou seja, cada valor armazenado é único no conjunto. Essa estrutura é uma implementação do conceito matemático de conjuntos finitos.
Nessa aplicação, os conjuntos armazenam valores em uma ordem específica, já que estão sendo implementados por meio de uma lista encadeada que usa o fator de ordenação para inserir novos elementos. Ainda assim, cada valor ali armazenado é único, ou seja, não há repetição. Cada conjunto representa uma playlist que armazena objetos do tipo Musica. A classe Playlist permite que esses conjuntos de músicas possam ser manipulados através de operações como união, interseção, complementar, subconjunto e diferença.

### Diagrama de Classes da Implementação
<img
  src="https://i.imgur.com/yXTEtvB.png"
  alt="Alt text"
  title="Optional title"
  style="display: inline-block; margin: 0 auto; max-width: 300px">
  
## Grafos: Menor caminho de uma origem a um destino com algoritmo de Dijkstra

A implementação faz o uso do algoritmo de Dijkstra para descobrir o menor caminho de uma origem para todos os destinos em um grafo direcionado. Um dos vértices do grafo é ponto de origem e os restantes são os possíveis destinos. Cada uma das arestas é uma rua que pode ou não ser usada para se chegar a um destino específico.
Primeiramente, apenas o elo de origem está contido no conjunto dos não resolvidos. Existem dois conjuntos de elos (pontos): unsettledNodes (elos não resolvidos) e settledNodes (elos resolvidos). Os algoritmos são executados até que o conjunto dos não resolvidos fique vazio. A cada iteração, ele seleciona o elo com a menor distância da origem para fora dos elos não resolvidos. Então, lê todas as arestas (ruas) que saem da origem e avalia para cada elo de destino, nas arestas ainda não estabelecidas, se a distância conhecida da origem até este elo pode ser reduzida ao usar a aresta selecionada. Se isso puder ser feito, é atualizado e o elo é adicionado aos elos que precisam de avaliação.

### Diagrama de Classes da Implementação
<img
  src="https://i.imgur.com/sJoqBqc.png"
  alt="Alt text"
  title="Optional title"
  style="display: inline-block; margin: 0 auto; max-width: 300px">
