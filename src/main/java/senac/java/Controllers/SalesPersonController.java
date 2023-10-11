package senac.java.Controllers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;
import senac.java.Services.ResponseEndPoints;

import java.io.IOException;





public class SalesPersonController {
    static ResponseEndPoints res = new ResponseEndPoints();
     public JSONObject ob = new JSONObject();


    public String creatingJsonString() {
        JSONObject pets = new JSONObject();
        pets.put(String.valueOf(1),"dog");
        pets.put(String.valueOf(2), "gato");

        return pets.toString(1);

//        JSONObject person = new JSONObject();
//        person.put("name", "John Brown");
//        person.put("age", 35);
//        person.put("pets", pets);
//        return person.toString(2);
    }



    public static class SalesPensonHandler implements HttpHandler {
        @Override
        public  void handle(HttpExchange exchange)throws IOException {

            JSONObject pets = new JSONObject();
            pets.put(String.valueOf(1),"dog");
            pets.put(String.valueOf(2), "gato");
//            pets.put()


            String response = "";
            String teste1 = "";

            if ("GET".equals(exchange.getRequestMethod())){
                teste1 = pets.toString(1);

                response = "Essa e a rota de Vendedor - GET" + teste1;
                res.enviarResponse(exchange,response, 200);
            } else if ("POST".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de Vendedor - POST";
                res.enviarResponse(exchange,response, 200);
            }else if ("PUT".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de Vendedor - PUT";
                res.enviarResponse(exchange,response, 200);
            }else if("DELETE".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de Vendedor - DELETE";
                res.enviarResponse(exchange,response, 200);
            }else {
                response = "ERROOOOOOO \n " +
                        "O método imprementado é: " + exchange.getRequestMethod();
                res.enviarResponse(exchange,response, 405);
            }


        }
    }

}
