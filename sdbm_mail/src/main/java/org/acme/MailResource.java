package org.acme;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import io.quarkus.mailer.reactive.ReactiveMailer;
import io.smallrye.common.annotation.Blocking;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.io.Serializable;

@Path("/mail")
public class MailResource implements Serializable {

    @Inject Mailer mailer;

    @GET
    @Blocking
    public void sendEmail() {
        mailer.send(
                Mail.withText("gamotakuze@gmail.com",
                        "test mail",
                        "A simple email sent from a Quarkus application."
                )
        );
    }

    @Inject
    ReactiveMailer reactiveMailer;

    @GET
    @Path("/reactive")

    public Uni<Response> sendEmailUsingReactiveMailer() {
        return reactiveMailer.send(
                Mail.withHtml("gamotakuze@gmail.com", // recipient email
                        "Subject of mail reactive", // email subject
                        "<h1>Body of mail</h1><p>This is an HTML email.</p>" // HTML message body
                )
        ).onFailure().invoke(Throwable::printStackTrace).replaceWith(Response.accepted().build());
    }


}