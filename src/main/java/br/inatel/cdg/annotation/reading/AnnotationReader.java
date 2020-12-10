package br.inatel.cdg.annotation.reading;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

//Nessa classe você deverá implementar a sua solução
//Adicionalmente você também deverá criar
//a anotação NumberToSum como parte da solução

public class AnnotationReader<T> {

	Class<?> clazz;
	int soma;
	
	public AnnotationReader(Class<?> clazz) {
		this.soma = 0;
		this.clazz = clazz;
	}

	public void readAnnotations()  {
		
		for (Field field : clazz.getDeclaredFields()) {
			if(field.isAnnotationPresent(NumberToSum.class)) {
				try {
					this.soma += field.getAnnotation(NumberToSum.class).numero(); //somar o valor dos parâmetros configurados (enquanto recupera as anotações)
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		for (Method method : clazz.getDeclaredMethods()) {
			if(method.isAnnotationPresent(NumberToSum.class)) {
				try {
					this.soma += method.getAnnotation(NumberToSum.class).numero(); //somar o valor dos parâmetros configurados (enquanto recupera as anotações)
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	public int getTotalSum() {
		return this.soma;
	}

}