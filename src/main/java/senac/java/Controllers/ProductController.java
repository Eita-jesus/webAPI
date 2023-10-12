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
                response = "Essa e a rota de Produtos - GET";
                res.enviarResponse(exchange,response, 200);
            } else if ("POST".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de Produtos - POST";
                res.enviarResponse(exchange,response, 200);
            }else if ("PUT".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de Produtos - PUT";
                res.enviarResponse(exchange,response,200);
            }else if("DELETE".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de Produtos - DELETE";
                res.enviarResponse(exchange,response,405);
            }else {
                response = "ERROOOOOOO \n " +
                    "O método imprementado é: " + exchange.getRequestMethod();
                res.enviarResponse(exchange,response, 405);
            }



        }

    }

}
