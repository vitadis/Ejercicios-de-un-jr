package ejerciciosnumericos;

public class NumPrimos {

	public static void main(String[] args) {
		int num1=10, num2=30;
		boolean hayPrimos, esPrimo;
		
		if (num1>num2) {
			int temporal = num1;
			num1 = num2;
			num2 = temporal;
		}
		hayPrimos = false;
		for (int i = num1; i<=num2;i++) {
			esPrimo=true;
			for (int x = 2; x<i;x++) {
				if(i%x==0)
					esPrimo = false;
			}
			if(esPrimo) {
				hayPrimos = true;
				System.out.print(i+" ");
			}
		}
		
		if(!hayPrimos)
			System.out.println("No hay primos");
		
		
	}

}
