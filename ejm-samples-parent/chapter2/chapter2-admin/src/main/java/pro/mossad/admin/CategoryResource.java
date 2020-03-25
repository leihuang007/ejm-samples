/**
 * 
 */
package pro.mossad.admin;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pro.mossad.admin.model.Category;
import pro.mossad.admin.model.CategoryTree;

/**
 * @author Home
 *
 */
@Path("/")
@ApplicationScoped
public class CategoryResource {

	@PersistenceContext(unitName = "AdminPU")
	private EntityManager em;

	@GET
	@Path("/category")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Category> all() throws Exception {
		return em.createNamedQuery("Category.findAll", Category.class).getResultList();
	}
	
	@GET
	@Path("/categorytree")
	@Produces(MediaType.APPLICATION_JSON)
	public CategoryTree tree() throws Exception{
		return em.find(CategoryTree.class, 1);
	}
	
	public Response create(Category category) throws Exception{
		if (category.getId() != null) {
			return Response.status(Response.Status.CONFLICT).entity("Unable to create Category, id was already set").build();
		}
		
		
	}

}
