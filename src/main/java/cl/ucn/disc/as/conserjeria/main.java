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
        log.debug("Starting...");
        Database db = DB.getDefault();
        Sistema sistema = new SistemaImpl(db);

        //base de datos

        //crear persona
        Persona persona = Persona.builder()
                .rut("20984692-6")
                .nombre("Benjamín")
                .apellidos("Plaza Flores")
                .email("benja@gmail.com")
                .telefono("+56912345678")
                .build();

        //guargar persona
        db.save(persona);

        //the sistema

        Edificio edificio = Edificio.builder()
                .nombre("LADECO")
                .direccion("Angamos")
                .build();

        log.debug("Edificio before DB: " + edificio);

        edificio = sistema.add(edificio);
        log.debug("Edificio After DB: " + edificio);

        /*ApiRestServer.start(7070, new WebController());
        log.debug("Done");
        */
        var app = Javalin.create(/*config*/)
                .get("/", ctx -> ctx.result("Hello World"))
                .get("personas", ctx -> ctx.json((sistema.getPersonas())))
                .start(7070);

    }

}