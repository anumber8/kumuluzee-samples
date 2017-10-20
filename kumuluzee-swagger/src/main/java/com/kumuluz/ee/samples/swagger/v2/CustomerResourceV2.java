package com.kumuluz.ee.samples.swagger.v2;

import com.kumuluz.ee.samples.swagger.Customer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * CustomerResource class with openAPI
 *
 * @author Zvone Gazvoda
 * @since 2.5.0
 */
//@Path("customer2")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "CustomerResource")
public class CustomerResourceV2 {

    @GET
    @ApiOperation(value = "Get customers list", tags = {"customers"}, notes = "Returns a list of customers.")
    @ApiResponses(value = {@ApiResponse(message = "List of customers", code = 200, response = Customer.class)})
    public Response getCustomers() {

        List<Customer> customers = new ArrayList<>();
        Customer c = new Customer("2", "Johnny", "Doey");

        customers.add(c);

        return Response.status(Response.Status.OK).entity(customers).build();
    }

    @GET
    @ApiOperation(value = "Get customer details", tags = {"customers"}, notes = "Returns customer details.")
    @ApiResponses(value = {@ApiResponse(message = "Customer details", code = 200, response = Customer.class)})
    @Path("{customerId}")
    public Response getCustomer(@PathParam("customerId") String customerId) {

        Customer c = new Customer("1", "John", "Doe");

        return Response.status(Response.Status.OK).entity(c).build();
    }

}