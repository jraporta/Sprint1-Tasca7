package n1exercici2;

public class Principal 
{
    
	@SuppressWarnings("deprecation")
	public static void main( String[] args )
    {
    	Treballador tOnline = null, tPresencial = null;
    	
    	double sou = 0;
    	
        tOnline = new TreballadorOnline("Mariana", "Pérez", 35);
        TreballadorOnline.setPreuInternet(48.99f);
        sou = ((TreballadorOnline)tOnline).determinarSou(100);
        System.out.printf("%s, sou: %.2f€%n", tOnline, sou);
        
        tPresencial = new TreballadorPresencial("Fulanito", "Ruiz", 35);
        TreballadorPresencial.setBenzina(180);
        sou =((TreballadorPresencial)tPresencial).determinarSou(100);
        System.out.printf("%s, sou: %.2f€%n", tPresencial, sou);
        
        
    }
}
