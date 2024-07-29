package n1exercici1;

public class TreballadorOnline extends Treballador{
	
	private static float preuInternet;
	
	public TreballadorOnline(String nom, String cognom, double preuPerHora) {
		super(nom, cognom, preuPerHora);
	}

	public static void setPreuInternet(float preuInternet) {
		TreballadorOnline.preuInternet = preuInternet;
	}
	
	@Override
	public double calcularSou(int horesTreballades) {
		return super.calcularSou(horesTreballades) + TreballadorOnline.preuInternet;
	}

}
