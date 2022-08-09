// Vartan Artyunyan
// Martikelnummer 5120007
public class Main {

	public static void main(String[] args) {
		
		Graph g = new Graph("Aufgabe2.csv");
		for (Integer i : PathFinder.findPath(g, 0, 5)) {
			System.out.print("->" + (char) (i + 65));
		}

		System.out.println();
		
		Graph g2 = new Graph("Aufgabe3.csv");
		for (Integer i : PathFinder.findPath(g2, 0, 25)) {
			System.out.print("->" + (char) (i + 65));
		}

	}

}
