package br.com.IanOliv.teste;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Formatter;

public class GeraCodigo {

	static public String getCodigoCliente(String estado) {
		long id = Calendar.getInstance().getTimeInMillis();
		Formatter formatter = new Formatter();
		String str = formatter.format("%d", id).toString();
		return estado + str.substring(str.length() - 6, str.length());

	}

	static public String getCodigoProduto() {
		long id = Calendar.getInstance().getTimeInMillis();
		Formatter formatter = new Formatter();
		String str = formatter.format("%x", id).toString();
		int endPosi = str.length() > 12 ? 12 : str.length();
		System.out.println(endPosi);
		return str.substring(0, endPosi);

	}

}
