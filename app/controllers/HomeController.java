package controllers;

import actors.WebSocketActor;
import akka.actor.*;
import akka.stream.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.mvc.*;
import play.libs.streams.ActorFlow;

import javax.inject.Inject;

/**
 * A very simple chat client using websockets.
 */
public class HomeController extends Controller {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ActorSystem actorSystem;
    private final Materializer materializer;

    @Inject
    public HomeController(ActorSystem actorSystem, Materializer materializer) {
        this.actorSystem = actorSystem;
        this.materializer = materializer;
    }


    public Result index() {
        Http.Request request = request();
        String url = routes.HomeController.chat().webSocketURL(request);
        return Results.ok(views.html.index.render(url));
    }

    public WebSocket chat() {
        logger.info("New member is coming...");
        return WebSocket.Text.accept(request -> {
            logger.info("UserId ..... {}", request.getQueryString("userId"));
            return ActorFlow.actorRef(actorRef -> WebSocketActor.props(
                    actorRef, Long.parseLong(request.getQueryString("userId"))),
                    actorSystem, materializer
            );
        }

        );
    }




}
