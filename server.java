// verticle
import org.vertx.java.core.Handler;
import org.vertx.java.core.http.HttpServer;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.platform.Verticle;
//pour les bus
import org.vertx.java.core.sockjs.EventBusBridgeHook;
import org.vertx.java.core.sockjs.SockJSServer;
import org.vertx.java.core.sockjs.SockJSSocket;
//serveur temps réel-- peut commencer la discussion
import org.vertx.java.core.eventbus.EventBus;
import org.vertx.java.core.eventbus.Message;
//jsonObject
import org.vertx.java.core.json.JsonArray;
import org.vertx.java.core.json.JsonObject;

import org.vertx.java.core.http.RouteMatcher;


import java.util.Map;

public class server extends Verticle {

 private EventBus eventBus;
 private HttpServer server;
 private SockJSServer sockJSServer; 
 private String port = "8080";
 private String ip= "localhost";
		
  	public void start() {
	RouteMatcher rm = new RouteMatcher();

  		server = vertx.createHttpServer();
  		server.requestHandler(rm);
  		rm.get("/", new Handler<HttpServerRequest>(){
			public void handle(HttpServerRequest req){
              req.response().sendFile("index.html");
            }
        });
		
		 rm.getWithRegEx(".*", new Handler<HttpServerRequest>() {
        public void handle(HttpServerRequest req) {
          container.logger().info(req.path().substring(1));
		  
               req.response().sendFile(req.path().substring(1));
         
      
      }
    });

     JsonArray permitted = new JsonArray();
	permitted.add(new JsonObject());
	sockJSServer = vertx.createSockJSServer(server);
	sockJSServer.bridge(new JsonObject().putString("prefix", "/eventbus2"), permitted, permitted);

	server.listen(Integer.parseInt(port), ip);
   }
   

  @Override
	public void stop() {
		container.logger().info("server.stop()");

		if (sockJSServer != null)
			sockJSServer.close();

		if (server != null)
			server.close();

		container.logger().info("Closing the sockJS and http server.");
	}
	public JsonObject getDatabaseconfig(){	
		return new JsonObject();
	}
}