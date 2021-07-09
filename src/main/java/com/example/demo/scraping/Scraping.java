package com.example.demo.scraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scraping {
	
	public String url;

	public static Document getHtml(String url) {
		Document html = null;
		try {
			html =Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();
			//System.out.println(html);
		} catch (Exception e) {
			System.out.println("Error al obtener el codigo");
		}
		return html;
	}
	
	public void scraping() {
		Elements productos = getHtml(url).select("li.product__list--item");
		for (Element elemento : productos) {
			String urlProducto = elemento.select("a").attr("abs:href");
			Document htmlProducto = getHtml(urlProducto);
			String nombre = htmlProducto.select("h1").text();
			String precio = htmlProducto.select("span.price-alkomprar").text();
			String codigo = htmlProducto.select("span.code").text();
			System.out.println(nombre);
			System.out.println(precio);
			System.out.println(codigo);
			System.out.println("-------------------------------");
		}
		System.out.println("Cantidad de produtos = " + productos.size());
	}
}
