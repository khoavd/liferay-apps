package com.dogoo.sample.animal.rest.internal.exception;

import com.dogoo.sample.animal.service.exception.DG_AnimalNotFoundException;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.BaseExceptionMapper;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.Problem;
import org.osgi.service.component.annotations.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

@Component(
        property = {
                "osgi.jaxrs.application.select=(osgi.jaxrs.name=*)",
                "osgi.jaxrs.extension=true",
                "osgi.jaxrs.name=com.dogoo.sample.animal.rest.internal.exception.NotFountExceptionMapper2"
        },
        service = ExceptionMapper.class
)public class NotFountExceptionMapper  extends BaseExceptionMapper<DG_AnimalNotFoundException> {

    @Override
    protected Problem getProblem(DG_AnimalNotFoundException exception) {
        return new Problem(exception.getMessage(),
                Response.Status.BAD_REQUEST,
                "Animal Category not Found",
                "NOT_FOUND");
    }
}
