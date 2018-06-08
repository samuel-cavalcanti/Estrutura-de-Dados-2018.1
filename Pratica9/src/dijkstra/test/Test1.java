package dijkstra.test;


// Test de la classe Graph

import dijkstra.Fenetre;
import dijkstra.Graph;




public class Test1 {
	public static void main(String[] args) throws Exception {
		System.out.println("Teste 1 : teste da classe Graph");
		
		Graph g;

		// petit graphe
		g = new Graph("data/mini.gr");
		System.out.println(g);

		// gros graphe
		g = new Graph("data/USA-road-d-NY.gr");
		g.setCoordinates("data/USA-road-d-NY.co");
		Fenetre f;
		f = new Fenetre("data/NY_Metropolitan.png", "Dijkstra", -73.9987, -73.9437, 40.7523, 40.78085);
		g.drawGraph(f);
	}
}
