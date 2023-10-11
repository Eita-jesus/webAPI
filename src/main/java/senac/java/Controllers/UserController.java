package senac.java.Controllers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;
import senac.java.Domain.Users;
import senac.java.Services.ResponseEndPoints;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UserController {
     static ResponseEndPoints res = new ResponseEndPoints();

     private static List<Users> usersList = new ArrayList<>();

    public static class UserHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "";

            if ("GET".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de Usuario - GET";
                res.enviarResponse(exchange,response, 200);
            } else if ("POST".equals(exchange.getRequestMethod())){

                //Aqui estamos desserialização o código em JavaScript

                try (InputStream resquestbody = exchange.getRequestBody()){

                    JSONObject json = new JSONObject(new String(resquestbody.readAllBytes()));
                    Users user = new Users(

                            json.getString("name"),
                            json.getString("last_name"),
                            json.getInt("age"),
                            json.getString("address"),
                            json.getString("email"),
                            json.getString("password"),
                            json.getString("cpf")

                    );

                    usersList.add(user);


                    System.out.println("O valor foi" + user.toJson());
                    res.e




                }catch(Exception e ){

//                    String resposta = e.toString();
                    String resposta = e.toString();


                    res.enviarResponse(exchange,resposta, 405);
                    res.enviarResponse(exchange,response, 405);


                }


                response = "Essa e a rota de Usuario - POST";
                res.enviarResponse(exchange,response,200);


            }else if ("PUT".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de Usuario - PUT";
                res.enviarResponse(exchange,response,200);
            }else if("DELETE".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de Usuario - DELETE";
                res.enviarResponse(exchange,response,200);
            }else {
                response = "ERROOOOOOO \n " +
                        "O método imprementado é: " + exchange.getRequestMethod();
                res.enviarResponse(exchange,response,200);
            }

            res.enviarResponse(exchange, response,405);
        }
    }
}
