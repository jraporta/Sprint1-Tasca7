package n1exercici1;

public class TreballadorOnline extends Treballador{
	
	private static double preuInternet;
	
	static {
		preuInternet = 45;
	}
	
	public TreballadorOnline(String nom, String cognom, double preuPerHora) {
		super(nom, cognom, preuPerHora);
	}

	public static void setPreuInternet(double preuInternet) {
		TreballadorOnline.preuInternet = preuInternet;
	}
	
	@Override
	public double calcularSou(int horesTreballades) {
		return super.calcularSou(horesTreballades) + TreballadorOnline.preuInternet;
	}

}
