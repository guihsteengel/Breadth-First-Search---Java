import java.io.*;
import java.util.*;

// Esta classe representa um gráfico direcionado usando lista de adjacências

class Graph {
    String[] city = {"Arad","Bucharest","Craiova","Dobreta","Eforie","Fagaras","Giurgio","Hirsova","Iasi","Lugoj","Mehadia","Neamt","Oradea","Pitesti","Rimnicu_Vilsea","Sibiu","Timisora","Urziceni","Vaslui","Zerind"};
        
    private int V; // No. of vertices
    private LinkedList<Integer> adj[]; // Adjacency Lists

    // Construtor
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

   // Função para adicionar uma aresta no gráfico
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // imprime o percurso BFS de uma determinada fonte s
    void BFS(int s, int e) {
        // Marca todos os vértices como não visitados(Por padrão definido como falso)
        boolean visited[] = new boolean[V];
        int parent[] = new int[V];
        int aux_parent = 0;
        boolean find = false;

        // Cria uma fila para o BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

       // Marca o nó atual como visitado e enfileira-o
        visited[s] = true;
        queue.add(s);
        parent[s] = s;

        System.out.print("( ");
        while (queue.size() != 0 && !find) {

            // Retira um vértice da fila e o imprime
            s = queue.poll();
            
            System.out.print(city[s-1] + " ");
            aux_parent = s;

            if (s == e) {
                find = true;
            } else {
               // Obtém todos os vértices adjacentes do vértice desenfileirado
                 // Se um adjacente não foi visitado, marque-o
                 // visitou e enfileira
                Iterator<Integer> i = adj[s].listIterator();
                while (i.hasNext()) {
                    int n = i.next();
                    if (!visited[n]) {
                        parent[n] = aux_parent;
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }
        System.out.println(") ");
        
    }
}

class Main {
    // Método do driver
    public static void main(String args[]) {
        Graph g = new Graph(160);

        g.addEdge(1, 16);
        g.addEdge(1, 17);
        g.addEdge(1, 20);

        g.addEdge(2, 6);
        g.addEdge(2, 7);
        g.addEdge(2, 14);
        g.addEdge(2, 18);

        g.addEdge(3, 4);
        g.addEdge(3, 14);
        g.addEdge(3, 15);

        g.addEdge(4, 3);
        g.addEdge(4, 11);

        g.addEdge(5, 8);

        g.addEdge(6, 2);
        g.addEdge(6, 16);

        g.addEdge(7, 2);

        g.addEdge(8, 5);
        g.addEdge(8, 18);

        g.addEdge(9, 12);
        g.addEdge(9, 19);

        g.addEdge(10, 11);
        g.addEdge(10, 17);

        g.addEdge(11, 4);
        g.addEdge(11, 10);

        g.addEdge(12, 9);

        g.addEdge(13, 16);
        g.addEdge(13, 20);

        g.addEdge(14, 2);
        g.addEdge(14, 3);
        g.addEdge(14, 15);

        g.addEdge(15, 3);
        g.addEdge(15, 14);
        g.addEdge(15, 16);

        g.addEdge(16, 1);
        g.addEdge(16, 6);
        g.addEdge(16, 13);
        g.addEdge(16, 15);

        g.addEdge(17, 1);
        g.addEdge(17, 10);

        g.addEdge(18, 2);
        g.addEdge(18, 8);
        g.addEdge(18, 19);

        g.addEdge(19, 9);
        g.addEdge(19, 18);

        g.addEdge(20, 1);
        g.addEdge(20, 13);
        System.out.println("Caminho a baixo:\n");

        g.BFS(20, 6);


    }
}


