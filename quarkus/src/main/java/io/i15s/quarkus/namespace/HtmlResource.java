package io.i15s.quarkus.namespace;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.i18n.MessageBundles;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Locale;

@Path("/html")
@RequestScoped
@Produces(MediaType.TEXT_HTML)
public class HtmlResource {

    @CheckedTemplate
    static class Templates {
        public static native TemplateInstance test();
    }

    @GET
    public Response get() {
        var html = Templates.test()
                .setAttribute(MessageBundles.ATTRIBUTE_LOCALE, new Locale("de", "AT"))
                .render();

        return Response.ok(html)
                .build();
    }
}
