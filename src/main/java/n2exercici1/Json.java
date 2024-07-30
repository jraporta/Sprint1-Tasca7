package n2exercici1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Json {
	
	private Object obj;
	private Class<?> objClass;
	private ArrayList<ArrayList<Field>> fields;
	private int numberOfNonStaticFields;
	
	public <T> Json(T t) throws IllegalArgumentException, IllegalAccessException {
		this.obj = t;
		this.objClass = t.getClass();
		getAllDeclaredFields(this.objClass);
		removeStaticFields();
	}
	
	public Class<?> getMyClass() {
		return objClass;
	}

	public ArrayList<ArrayList<Field>> getFields() {
		return fields;
	}
	
	public void getAllDeclaredFields(Class<?> c){
		if (c != Object.class) {
			this.fields = new ArrayList<>();
			getAllDeclaredFields(c.getSuperclass());
			this.fields.add(0, new ArrayList<Field>(Arrays.asList(c.getDeclaredFields())));
		}
	}
	
	public void removeStaticFields(){
		this.numberOfNonStaticFields = 0;
		for (ArrayList<Field> f : this.fields) {
			for (Iterator<Field> iter = f.iterator(); iter.hasNext(); ) {
				if (Modifier.isStatic(iter.next().getModifiers())) {
					iter.remove();
				}else {
					this.numberOfNonStaticFields++;
				}
			}
		}
	}
	
	public void serialize() throws IOException, IllegalArgumentException, IllegalAccessException {
		//retrieve path from annotation
		int i = 0;
		Path path = Paths.get("object.txt").normalize();
		try(BufferedWriter output = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)){
			String fmt = "  \"%s\": \"%s\"";
			output.write(String.format("{%n"));
			for (ArrayList<Field> f : this.fields) {
				for (Field f2 : f) {
					boolean originalAccessible = f2.canAccess(this.obj);
					f2.setAccessible(true);
					String value = f2.get(this.obj).toString();
					f2.setAccessible(originalAccessible);
					String name = f2.getName().toString();
					i++;
					output.write(String.format(fmt + (i == this.numberOfNonStaticFields ? "" : ",%n"), name, value));					
				}
			} 
			output.write(String.format("%n}"));
		}
	}





}
