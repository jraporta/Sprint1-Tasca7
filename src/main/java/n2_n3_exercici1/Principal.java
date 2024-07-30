package n2_n3_exercici1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;


public class Principal {
    
	public static void main( String[] args ) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, IOException {
		
		Treballador tOnline = null;
    	
        tOnline = new TreballadorOnline("Mariana", "Pérez", 35);
        TreballadorOnline.setPreuInternet(48.99f);
        
        Json json = new Json(tOnline);
        WhereToSerialize a = tOnline.getClass().getAnnotation(WhereToSerialize.class);
        Path directoryPath = Path.of(a.directory()).normalize();
        Files.createDirectories(directoryPath);
        Path filePath = Path.of(directoryPath.toString(), "\\" + tOnline.getNomComplet() + ".json");
        try(BufferedWriter output = Files.newBufferedWriter(filePath, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)){
        	output.write(String.format(json.toJson()));
        	System.out.println("Objecto serialized successfully");
        }
        
    }
	
	
	
	
}
