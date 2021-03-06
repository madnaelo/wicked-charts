package de.adesso.wickedcharts.highcharts.options;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This test ensures that all classes in the options package implement the
 * builder pattern. For each class all setter methods are checked. If a setter
 * method returns void it does not implement the builder pattern.
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 */
class BuilderPatternTest {

	private static final String[] PACKAGES_TO_TEST = {

	"de.adesso.wicketcharts.highcharts.options",

	"de.adesso.wicketcharts.highcharts.options.color",

	"de.adesso.wicketcharts.highcharts.options.series" };

	/**
	 * A class is only tested if it is dubbed relevant by this method.
	 */
	private boolean isClassRelevant(final Class<?> clazz) {
		return !clazz.isEnum();
	}

	/**
	 * A method is only tested if it is dubbed relevant by this method.
	 */
	private boolean isMethodRelevant(final Method method) {
		return method.getName().startsWith("set");
	}

	@Test
	void testBuilderPattern() throws ClassNotFoundException, IOException {
		Set<Class<?>> allClasses = ClassFinder
		    .getClasses(this.getClass().getClassLoader(), PACKAGES_TO_TEST);

		for (Class<?> clazz : allClasses) {
			if (isClassRelevant(clazz)) {
				Method[] methods = clazz.getMethods();
				for (Method method : methods) {
					if (isMethodRelevant(method)) {
						testMethod(method);
					}
				}
			}
		}
	}

	/**
	 * Asserts that a method returns the type in which the method is declared.
	 */
	private void testMethod(final Method method) {
		System.out.println("Testing method " + method + " for builder pattern...");
		Class<?> returnType = method.getReturnType();
		Class<?> declaringType = method.getDeclaringClass();
		assertTrue(returnType.isAssignableFrom(declaringType), "The method " + method + " does not implement builder pattern! Expected return value: "
				+ declaringType + " (or a descendant)!");
	}

}
