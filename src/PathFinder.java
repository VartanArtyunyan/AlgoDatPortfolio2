// Vartan Artyunyan
// Martikelnummer 5120007

import java.util.*;

public class PathFinder {

	public static ArrayList<Integer> findPath(Graph g, int start, int ziel) {

		List<Integer> Knotn = new ArrayList<>();
		int[] Kosten = new int[g.getSize()];
		int[] vor = new int[g.getSize()];

		for (int i = 0; i < g.getSize(); i++) {
			Knotn.add(i, i);
			Kosten[i] = Integer.MAX_VALUE;
		}
		Kosten[start] = 0;

		while (Knotn.size() > 0) {

			int skIndex = findSmallest(Kosten, Knotn);
			Knotn.remove(Knotn.indexOf(skIndex));

			for (Integer k : g.getNachbar(skIndex)) {
				int alt = Integer.MAX_VALUE;
				if (Knotn.contains(k)) {
					alt = Kosten[skIndex] + g.getDistance(skIndex, k);
				}
				if (alt < Kosten[k]) {
					Kosten[k] = alt;
					vor[k] = skIndex;
				}

			}

		}
		ArrayList<Integer> pfad = new ArrayList<>();
		int current = ziel;
		pfad.add(current);
		while (current != start) {
			pfad.add(vor[current]);
			current = vor[current];
		}
		return pfad;
	}

	public static int findSmallest(int[] liste, List<Integer> Knotn) {

		int index = Knotn.get(0);
		int smallest = liste[Knotn.get(0)];

		for (int i = 0; i < liste.length; i++) {
			if ((liste[i] < smallest) && (Knotn.contains(i)))
				index = i;
			smallest = liste[i];
		}

		return index;

	}

}
