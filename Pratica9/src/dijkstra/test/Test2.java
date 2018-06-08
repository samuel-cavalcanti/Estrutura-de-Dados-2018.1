package dijkstra.test;

import dijkstra.Dijkstra;
import dijkstra.Graph;


// Test de l'initialisation de la classe Dijkstra
public class Test2 {
	public static void main(String args[]) throws Exception {
		System.out.println("Teste 2 : inicialização da classe Dijkstra");
	    Graph g = new Graph("data/mini.gr");
	    Dijkstra d = new Dijkstra(g,2,7);
	    int n = g.n;
	    System.out.println("---Grafo---");
	    System.out.println(g);
	    System.out.println("---Dijkstra---");
	    System.out.println("origem : " + d.source);
	    System.out.println("destino : " + d.dest);
	    for(int i = 0; i < n; i++)
	    	System.out.println(i + " dist = " + d.dist[i] + "   pred = " + d.pred[i] + "   settled = " + d.settled[i]);
	  }
}
