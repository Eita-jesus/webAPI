package senac.java.Controllers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;
import senac.java.Services.ResponseEndPoints;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductController {
    static ResponseEndPoints res = new ResponseEndPoints();
    public JSONObject ob = new JSONObject();
    public static List<Produts> produtsList = new ArrayList<>();
    public static class Produts implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {

            String response = "";


            if ("GET".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de Produtos - GET api/produtos";
                res.enviarResponse(exchange,response, 200);
            } else if ("POST".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de Produtos - POST api/produtos";
                res.enviarResponse(exchange,response, 200);
            }else if ("PUT".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de Produtos - PUT api/produtos";
                res.enviarResponse(exchange,response,200);
            }else if("DELETE".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de Produtos - DELETE api/produtos";
                res.enviarResponse(exchange,response,200);
            }else {
                response = "ERROOOOOOO \n " +
                    "O método imprementado é:  api/produtos" + exchange.getRequestMethod();
                res.enviarResponse(exchange,response, 200);
            }



        }

    }

}
