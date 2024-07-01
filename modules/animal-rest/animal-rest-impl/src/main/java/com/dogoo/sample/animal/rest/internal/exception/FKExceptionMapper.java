package com.dogoo.sample.animal.rest.internal.exception;

import com.liferay.portal.vulcan.jaxrs.exception.mapper.BaseExceptionMapper;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.Problem;
import org.osgi.service.component.annotations.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

@Component(
        property = {
                "osgi.jaxrs.application.select=(osgi.jaxrs.name=*)",
                "osgi.jaxrs.extension=true",
                "osgi.jaxrs.name=com.dogoo.sample.animal.rest.internal.exception.FKExceptionMapper2"
        },
        service = ExceptionMapper.class
)public class FKExceptionMapper extends BaseExceptionMapper<Exception> {

    @Override
    protected Problem getProblem(Exception exception) {

        return new Problem(exception.getMessage(),
                Response.Status.INTERNAL_SERVER_ERROR,
                "There is a common exception, contact to the SysAdmin to see more detail",
                "INTERNAL_SERVER");
    }

}
