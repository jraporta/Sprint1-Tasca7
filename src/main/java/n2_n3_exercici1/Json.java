package n2_n3_exercici1;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
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
	
	public String toJson() {
		StringBuilder response = new StringBuilder();
		int i = 0;
		String fmt = "  \"%s\": \"%s\"";
		response.append("{%n");
		for (ArrayList<Field> f : this.fields) {
			for (Field f2 : f) {
				String name = f2.getName();
				boolean originalAccessible = f2.canAccess(this.obj);
				f2.setAccessible(true);
				String value;
				try {
					value = f2.get(this.obj).toString();
				} catch (IllegalArgumentException | IllegalAccessException e) {
					System.out.printf("Error retrieving %s value: %s", name, e.getMessage());
					throw new RuntimeException();
				}
				f2.setAccessible(originalAccessible);
				i++;
				response.append(String.format(fmt + (i == this.numberOfNonStaticFields ? "%n" : ",%n"), name, value));
			}
		} 
		response.append("}");
		return response.toString();
	}





}
