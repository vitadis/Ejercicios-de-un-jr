package molde_preguntas;

import java.util.ArrayList;

public class BancoPreguntas {

	public static ArrayList<Pregunta> cargarPreguntas() {

		ArrayList<Pregunta> lista = new ArrayList<>();

		ArrayList<String> op1 = new ArrayList<>();
		op1.add("C#");
		op1.add("Java");
		op1.add("C++");
		lista.add(new Pregunta("¿Qué lenguaje usa la JVM?", op1, 1));

		ArrayList<String> op3 = new ArrayList<>();
		op3.add("Google");
		op3.add("Microsoft");
		op3.add("Oracle");
		lista.add(new Pregunta("¿Quién mantiene Java actualmente?", op3, 2));

		ArrayList<String> op4 = new ArrayList<>();
		op4.add("JFrame");
		op4.add("Window");
		op4.add("Dialog");
		lista.add(new Pregunta("¿Qué clase crea una ventana principal?", op4, 0));

		ArrayList<String> op5 = new ArrayList<>();
		op5.add("Django");
		op5.add("Laravel");
		op5.add("Swing");
		lista.add(new Pregunta("¿Qué librería gráfica usamos?", op5, 2));

		ArrayList<String> op2 = new ArrayList<>();
		op2.add("2005");
		op2.add("1995");
		op2.add("1985");
		lista.add(new Pregunta("¿En qué año apareció Java?", op2, 1));
		
		return lista;
	}
}