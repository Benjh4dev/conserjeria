package cl.ucn.disc.as.conserjeria.ui;

import cl.ucn.disc.as.conserjeria.services.Sistema;
import cl.ucn.disc.as.conserjeria.services.SistemaImpl;
import io.ebean.DB;
import io.javalin.Javalin;
import java.util.Optional;


public final class WebController implements RoutesConfigurator{
    private final Sistema sistema;

    public WebController() {
        this.sistema = new SistemaImpl(DB.getDefault());
        //this.sistema.populate();
    }

    /***
     *
     * @param app to use
     */
    @Override
    public void configure(final Javalin app) {
        app.get("/", ctx -> {
            ctx.result("Hello World");
        });
    }
}
