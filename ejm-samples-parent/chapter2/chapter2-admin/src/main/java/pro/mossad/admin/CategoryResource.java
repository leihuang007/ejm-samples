/**
 * 
 */
package pro.mossad.admin;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Path;

/**
 * @author Home
 *
 */
@Path("/")
@ApplicationScoped
public class CategoryResource {

	@PersistenceContext(unitName = "AdminPU")
	private EntityManager em;
	
}
