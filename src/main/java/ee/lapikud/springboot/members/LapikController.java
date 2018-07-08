package ee.lapikud.springboot.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Controller
@Path("/members")
public class LapikController {

    @Autowired
    private LapikService lapikService;

    @POST
    @Path("/add")
    @Transactional /*makes sure all changes to the database are rolled back if anything goes wrong,
                    should be used on any method that makes changes to the database*/
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addMember(Lapik lapik) {
        try {
            lapikService.addMember(lapik);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Lapik> getAll() {
        return lapikService.findAll();
    }

    //TODO: 3) Add @DELETE endpoint for deleting a member by id.
    //TODO: 4) Add @GET endpoint for finding members by their first name.
    //TODO: 5) Add @GET endpoint for finding members by their team.
    //TODO: 6) Add @PUT endpoint for updating member data.
}
