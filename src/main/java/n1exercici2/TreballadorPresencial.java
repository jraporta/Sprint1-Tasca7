package n1exercici2;

public class TreballadorPresencial extends Treballador{
	
	private static float benzina;
		
	public TreballadorPresencial(String nom, String cognom, double preuPerHora) {
		super(nom, cognom, preuPerHora);
	}

	public static void setBenzina (float benzina) {
		TreballadorPresencial.benzina = benzina;
	}
	
	/**
	 * 
	 * @deprecated
	 * Per cualcular el sou es fa servir el métode calcularSou(int horesTreballades)
	 * 
	 */
	@Deprecated
	public double determinarSou(int horesTreballades) {
		return super.calcularSou(horesTreballades) + 4.5 * horesTreballades;
	}
	
	@Override
	public double calcularSou(int horesTreballades) {
 		return super.calcularSou(horesTreballades) + TreballadorPresencial.benzina;
	}
	
	

}
