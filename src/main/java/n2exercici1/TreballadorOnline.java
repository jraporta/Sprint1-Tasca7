package n2exercici1;


@SerializeToJSON
public class TreballadorOnline extends Treballador {
	
	private static float preuInternet;
	
	public TreballadorOnline(String nom, String cognom, double preuPerHora) {
		super(nom, cognom, preuPerHora);
	}

	public static void setPreuInternet(float preuInternet) {
		TreballadorOnline.preuInternet = preuInternet;
	}
	
	/**
	 * 
	 * @deprecated
	 * Per cualcular el sou es fa servir el métode calcularSou(int horesTreballades)
	 * 
	 */
	@Deprecated
	public double determinarSou(int horesTreballades) {
		return super.calcularSou(horesTreballades)*1.10;
	}
	
	@Override
	public double calcularSou(int horesTreballades) {
		return super.calcularSou(horesTreballades) + TreballadorOnline.preuInternet;
	}

}
