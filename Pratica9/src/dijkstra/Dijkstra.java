package dijkstra;

import java.util.ArrayList;
import java.util.PriorityQueue;

// Algoritmo de Dijkstra
public class Dijkstra {

    final Graph g;
    public final int n;
    public final int source;
    public final int dest;
    public int[] dist;
    public int[] pred;
    public boolean[] settled;
    public Fenetre f;
    PriorityQueue<Node> naoacomodados;

    // construtor
    public Dijkstra(Graph g, int source, int dest) {
        this.g = g;
        n = g.n;
        this.source = source;
        this.dest = dest;
        dist = new int[n];
        pred = new int[n];
        naoacomodados = new PriorityQueue<>();
        settled = new boolean[n];
        setDist();
        setSettled();
        setPred();
        setNaoAcomodados();

    }

    // atualizacao da distancia, da prioridade, e do predecessor de um no
    void update(int target, int origin) {
        if (dist[origin] == Integer.MAX_VALUE )
            return;
                
        int currentDist =  dist[origin] + g.value(origin, target) ;

        if (dist[target] < currentDist) {
            return;
        }

        dist[target] = currentDist;
        naoacomodados.add(new Node(target, currentDist));
        pred[target] = origin;

    }

    // retorna o próximo nó a ser acomodado
    int nextNode() {
        Node next = naoacomodados.poll();
       
        while (settled[next.id]) {
           
            if (naoacomodados.isEmpty()) {
                return -1;
            }
            next = naoacomodados.poll();
        }

        return next.id;
    }

    // uma etapa do algoritmo de Dijkstra
    int oneStep() {
        slow();
        
        int currentNodeid = nextNode();
        if (currentNodeid == -1) {
            return -1;
        }
        settled[currentNodeid] = true;
        ArrayList<Integer> neighbourhood = g.successors(currentNodeid);

        for (Integer i : neighbourhood) {
            update(i, currentNodeid);
        }

        return currentNodeid;
    }

    // algoritmo de Dijsktra completo
    public int compute() {
        int currentNodeid = oneStep();
        while (currentNodeid != -1 && currentNodeid != dest) {
            currentNodeid = oneStep();
        }
        if (currentNodeid == -1) {
            return -1;
        } else {
            return dist[currentNodeid];
        }

    }

    // desacelera o visualizador
    void slow() {
        if (f == null) {
            return;
        }
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
        }
    }

    private void setDist() {
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[source] = 0;

    }

    private void setSettled() {
        for (int i = 0; i < settled.length; i++) {
            settled[i] = false;
        }

    }

    private void setPred() {
        for (int i = 0; i < pred.length; i++) {
            pred[i] = -1;

        }

        pred[source] = source;
    }

    private void setNaoAcomodados() {
        for (int i = 0; i < n; i++) {
            naoacomodados.add(new Node(i, dist[i]));
        }
    }
}
