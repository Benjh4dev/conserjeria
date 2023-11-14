package cl.ucn.disc.as.conserjeria.ui;

import cl.ucn.disc.as.conserjeria.exceptions.SistemaException;
import cl.ucn.disc.as.conserjeria.model.Persona;
import cl.ucn.disc.as.conserjeria.services.Sistema;
import cl.ucn.disc.as.conserjeria.services.SistemaImpl;

import io.ebean.DB;
import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;

import java.util.Optional;

public final class WebController implements RoutesConfigurator {
    /**
     * The sistema
     */
    private final Sistema sistema;
    /**
     * The web controller
     */
    public WebController() {
        this.sistema = new SistemaImpl(DB.getDefault());
        // FIXME: only populate in case of new database.
        this.sistema.populate();
    }
    /**
     * Configure the routes.
     *
     * @param app to use.
     */
    @Override
    public void configure(final Javalin app){
        app.get("/", ctx -> {
            ctx.result("Welcome to Conserjeria API REST");
        });

        // the personas api
        app.get("/personas", ctx -> {
            try {
                ctx.json(this.sistema.getPersonas());
            } catch (SistemaException e) {
                e.printStackTrace();
            }
        });

        app.get("/personas/rut/{rut}", ctx -> {
            String rut = ctx.pathParam("rut");
            Optional<Persona> oPersona = null;
            try {
                oPersona = Optional.ofNullable(this.sistema.getPersona(rut));
            } catch (SistemaException e) {
                e.printStackTrace();
            }
            ctx.json(oPersona.orElseThrow(() -> new NotFoundResponse("Can't find persona with ruth: " + rut)));
        });
    }

}
