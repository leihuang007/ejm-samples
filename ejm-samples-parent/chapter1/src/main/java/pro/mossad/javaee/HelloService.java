/**
 * 
 */
package pro.mossad.javaee;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author Home
 *
 */
@ApplicationScoped
public class HelloService {

	public String sayHello(String name) {
		return "Hello " + name;
	}
}
