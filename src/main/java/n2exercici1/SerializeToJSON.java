package n2exercici1;

public @interface SerializeToJSON {
	String directory () default ".\\json";
}
