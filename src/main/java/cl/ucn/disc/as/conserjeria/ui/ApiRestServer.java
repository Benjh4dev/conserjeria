package cl.ucn.disc.as.conserjeria.ui;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import io.javalin.Javalin;
//import io.javalin.json.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.time.Instant;

@Slf4j
public final class ApiRestServer {
    private ApiRestServer(){

    }
    private static Gson createAndConfigureGson(){
        TypeAdapter<Instant> instantTypeAdapter = new TypeAdapter<>() {
            @Override
            public void write(JsonWriter out, Instant instant) throws IOException {
                if(instant == null){
                    out.nullValue();
                } else {
                    out.value(instant.toEpochMilli());
                }
            };

            @Override
            public Instant read(JsonReader in) throws IOException {
                if(in.peek() == JsonToken.NULL){
                    in.nextNull();
                    return null;
                }
                return Instant.ofEpochMilli(in.nextLong());
            };

        };

        return new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Instant.class, instantTypeAdapter)
                .create();
    }

    private static Javalin createAndConfigureJavalin(){
        return null;
    }

    public static void start (final Integer port, final RoutesConfigurator routesConfigurator){
        if(port < 1024 || port > 65525){
            log.error("Bad port");
            throw new IllegalArgumentException("Bad port");
        }
        log.debug("Starting in port {} ..", port);
        Javalin app = createAndConfigureJavalin();
        routesConfigurator.configure(app);
        Runtime.getRuntime().addShutdownHook(new Thread(app::stop));
        app.events(event -> {
           event.serverStarting(() ->{
               log.debug("Starting the Javalin Server");
           });
            event.serverStarted(() ->{
                log.debug("Starting the Javalin Server");
            });
            event.serverStopping(() ->{
                log.debug("Starting the Javalin Server");
            });
            event.serverStopped(() ->{
                log.debug("Starting the Javalin Server");
            });
        });
    }
}
