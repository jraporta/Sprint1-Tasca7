package n1exercici1;

public class TreballadorPresencial extends Treballador{
	
	private static float benzina;
		
	public TreballadorPresencial(String nom, String cognom, double preuPerHora) {
		super(nom, cognom, preuPerHora);
	}

	public static void setBenzina (float benzina) {
		TreballadorPresencial.benzina = benzina;
	}
	
	@Override
	public double calcularSou(int horesTreballades) {
 		return super.calcularSou(horesTreballades) + TreballadorPresencial.benzina;
	}

}
