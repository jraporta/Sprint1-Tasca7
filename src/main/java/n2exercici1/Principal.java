package n2exercici1;

import java.io.IOException;

public class Principal {
    
	public static void main( String[] args ) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, IOException {
		
		
    	Treballador tOnline = null;
    	
        tOnline = new TreballadorOnline("Mariana", "Pérez", 35);
        TreballadorOnline.setPreuInternet(48.99f);
        
        Json json = new Json(tOnline);
        System.out.println(json.getMyClass());
        System.out.println(json.getFields());
        json.serialize();
    }
}
