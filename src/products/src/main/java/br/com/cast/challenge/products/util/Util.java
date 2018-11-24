package br.com.cast.challenge.products.util;

public class Util {
	
	public static final int INICIO = 0;
	public static final int FIM = 1;

	
	public static final String completeChar(String str, char caracter, int sentido, int str_length) {

		String aux = str;

		while (aux.length() < str_length) {
			if (sentido == INICIO) {
				aux = caracter + aux;
			} else if (sentido == FIM) {
				aux = aux + caracter;
			}
		}

		return aux;

	}
	
}
