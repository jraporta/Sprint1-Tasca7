package n2exercici1;

public abstract class Treballador {
	private String nom;
	private String cognom;
	private double preuPerHora;
	
	
	
	public Treballador(String nom, String cognom, double preuPerHora) {
		this.nom = nom;
		this.cognom = cognom;
		this.preuPerHora = preuPerHora;
	}

	public double calcularSou(int horesTreballades){
		return horesTreballades * preuPerHora;
	}

	@Override
	public String toString() {
		return String.format("%s %s", this.nom, this.cognom);
	}
	
	

}
