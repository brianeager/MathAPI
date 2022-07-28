package sojern.mathapi.rest;

import com.google.gson.Gson;
import sojern.mathapi.data.NumberAndQuantifierDTO;
import sojern.mathapi.data.NumberDTO;
import sojern.mathapi.service.CalculationService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/math-api")
public class MathAPI {

    public CalculationService calculationService = new CalculationService();

    @POST
    @Path("/min")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response minimum(@Context HttpHeaders headers,
                          NumberAndQuantifierDTO inputData) {
        if(inputData.getNumbers().size()!=inputData.getQuantifier()){
            return Response.status(Response.Status.NOT_ACCEPTABLE)
                    .entity("Number of values in array does not equal quantifier").build();
        }else{
            return handleResponse(calculationService.calculateMinimum(inputData));
        }
    }

    @POST
    @Path("/max")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response maximum(@Context HttpHeaders headers,
                          NumberAndQuantifierDTO inputData) {
        if(inputData.getNumbers().size()!=inputData.getQuantifier()){
            return Response.status(Response.Status.NOT_ACCEPTABLE)
                    .entity("Number of values in array does not equal quantifier").build();
        }else{
            return handleResponse(calculationService.calculateMaximum(inputData));
        }
    }

    @POST
    @Path("/avg")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response average(@Context HttpHeaders headers,
                            NumberDTO inputData) {
        return handleResponse(calculationService.calculateAverage(inputData));
    }

    @POST
    @Path("/median")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response median(@Context HttpHeaders headers,
                         NumberDTO inputData) {
        return handleResponse(calculationService.calculateMedian(inputData));
    }

    @POST
    @Path("/percentile")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response percentile(@Context HttpHeaders headers,
                               NumberAndQuantifierDTO inputData) {
        return handleResponse(calculationService.calculatePercentile(inputData));
    }

    private Response handleResponse(Object response){
        if(response!=null){
            return Response.status(Response.Status.OK).entity(new Gson().toJson(response)).build();
        }
        else{
            return Response.status(Response.Status.NOT_ACCEPTABLE)
                    .entity("Error handling request").build();
        }
    }
}