package n1exercici1;

public class Principal 
{
    public static void main( String[] args )
    {
    	Treballador tOnline = null, tPresencial = null;
    	double sou = 0;
    	
        tOnline = new TreballadorOnline("Mariana", "Pérez", 35);
        TreballadorOnline.setPreuInternet(48.99f);
        sou = tOnline.calcularSou(100);
        System.out.printf("%s, sou: %.2f€%n", tOnline, sou);
        
        tPresencial = new TreballadorPresencial("Fulanito", "Ruiz", 35);
        TreballadorPresencial.setBenzina(180);
        sou = tPresencial.calcularSou(100);
        System.out.printf("%s, sou: %.2f€%n", tPresencial, sou);
        
        
    }
}
