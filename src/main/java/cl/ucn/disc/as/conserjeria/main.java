package cl.ucn.disc.as.conserjeria;
import cl.ucn.disc.as.conserjeria.model.Persona;
import cl.ucn.disc.as.conserjeria.model.Edificio;
import cl.ucn.disc.as.conserjeria.services.SistemaImpl;
import cl.ucn.disc.as.conserjeria.ui.ApiRestServer;
import cl.ucn.disc.as.conserjeria.ui.WebController;
import io.ebean.DB;
import io.ebean.Database;
import io.javalin.Javalin;
import lombok.extern.slf4j.Slf4j;
import cl.ucn.disc.as.conserjeria.services.Sistema;

@Slf4j
public final class main {

    public static void main(String[] args) {

        //var app = Javalin.create(/*config*/)
                //.get("/", ctx -> ctx.result("Hello World"))
                //.get("personas", ctx -> ctx.json((sistema.getPersonas())))
                //.start(7070);

        log.debug("Starting Main ..");


        //Start the API Rest server
        Javalin app = ApiRestServer.start(7070, new WebController());

        log.debug("Done. :)");

    }

}