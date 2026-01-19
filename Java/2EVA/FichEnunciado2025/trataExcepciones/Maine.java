package trataExcepciones;
import java.util.ArrayList;
import java.util.HashMap;
public class Maine {
	public static void main(String[] args) {
		Cargo[] carguillos = Cargo.values();
		Equipo[] equipillos = Equipo.values();
		HashMap<Equipo, HashMap<Cargo, Integer>> equipos = new HashMap<Equipo, HashMap<Cargo, Integer>>();
		ArrayList<Tecnico> tecni = new ArrayList<Tecnico>();
		tecni.add(new Tecnico(Equipo.BARCELONA, Cargo.C));
		tecni.add(new Tecnico(Equipo.BARCELONA, Cargo.A));
		tecni.add(new Tecnico(Equipo.OSASUNA, Cargo.C));
		tecni.add(new Tecnico(Equipo.OSASUNA, Cargo.C));
		for (Equipo e : equipillos) {
			HashMap<Cargo, Integer> cargui = new HashMap<Cargo, Integer>();
			for (Cargo c : carguillos) {
				cargui.put(c, 0);
			}
			equipos.put(e, cargui);
		}
		for (Tecnico t : tecni) {
			HashMap<Cargo, Integer> cargui = equipos.get(t.getE());
			for (Cargo c : cargui.keySet()) {
				if (c == t.getC()) {
					int valor = cargui.get(c) + 1;
					cargui.put(c, valor);
				}
			}
			equipos.put(t.getE(), cargui);
		}
		for (Equipo e : equipos.keySet()) {
			System.out.println("Equipo: " + e);

			HashMap<Cargo, Integer> cargui = equipos.get(e);
			for (Cargo c : cargui.keySet()) {
				System.out.println(c + ": " + cargui.get(c));
			}
		}
	}
}