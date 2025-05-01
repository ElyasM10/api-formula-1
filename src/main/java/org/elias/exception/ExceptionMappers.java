package org.elias.exception;

import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import static jakarta.ws.rs.core.Response.Status.NO_CONTENT;


//import static org.jboss.resteasy.reactive.RestResponse.StatusCode.NO_CONTENT;

public class ExceptionMappers {

    @Inject
    Logger auditor;

    @ServerExceptionMapper
    public Response mapHttpNoContentException(HttpNoContentException x) {

        auditor.debug("mapHttpNoContentException");
        return Response.status(NO_CONTENT).header("warning", x.getMessage()).build();
    }

    @ServerExceptionMapper
    public Response mapHttpConflictException(HttpConflictException x) {

        auditor.debug("mapHttpConflictException: " + x.getMessage());
        return Response.status(Response.Status.CONFLICT).header("Warning",x.getMessage()).build();
    }

    @ServerExceptionMapper
    public Response mapHttpBadRequestException(HttpBadResquestException x) {

        auditor.debug("mapHttpConflictException: " + x.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).header("Warning", x.getMessage()).build();
    }

    @ServerExceptionMapper
    public Response mapHttpNotFoundException(HttpNotFoundException x) {

        auditor.debug("mapHttpNotFoundException: " + x.getMessage());
        return Response.status(Response.Status.NOT_FOUND).header("Warning",x.getMessage()).build();
    }

    @ServerExceptionMapper
    public Response mapHttpForbiddenException(HttpForbiddenException x) {

        auditor.debug("mapHttpForbiddenException: " + x.getMessage());
        return Response.status(Response.Status.FORBIDDEN).header("Warning",x.getMessage()).build();
    }

}
