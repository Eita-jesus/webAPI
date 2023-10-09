package senac.java.Controllers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import senac.java.Services.ResponseEndPoints;

import java.io.IOException;

public class ProductController {

    static ResponseEndPoints res = new ResponseEndPoints();
    public static class Produts implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {

            String response = "";

            if ("GET".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de vendedor - GET";
                res.enviarResponse(exchange,response);
            } else if ("POST".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de Vendedor - POST";
                res.enviarResponse(exchange,response);
            }else if ("PUT".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de Vendedor - PUT";
                res.enviarResponse(exchange,response);
            }else if("DELETE".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de Vendedor - DELETE";
                res.enviarResponse(exchange,response);
            }else {
                response = "ERROOOOOOO \n " +
                    "O método imprementado é: " + exchange.getRequestMethod();
                res.enviarResponse(exchange,response);
            }



        }

    }

}
