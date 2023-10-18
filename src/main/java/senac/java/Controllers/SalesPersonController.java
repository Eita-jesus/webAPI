package senac.java.Controllers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;
import senac.java.Domain.Salesperson;
import senac.java.Services.ResponseEndPoints;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class SalesPersonController {
    static ResponseEndPoints res = new ResponseEndPoints();
     public JSONObject ob = new JSONObject();

public static List<Salesperson> salespersonList = new ArrayList<>();
    public static class SalesPensonHandler implements HttpHandler {
        @Override
        public  void handle(HttpExchange exchange)throws IOException {

            String response = "";


            if ("GET".equals(exchange.getRequestMethod())){
                List<Salesperson> getAllFromArray = Salesperson.getAllSalesPerson(salespersonList);
                if (!getAllFromArray.isEmpty()){

                    for(Salesperson salesperson: getAllFromArray){
                        System.out.println("Os dados encontrados foram:" + salesperson.getName());
                        System.out.println("Os dados encontrados foram:" + salesperson.getLastName());
                        System.out.println("Os dados encontrados foram:" + salesperson.getPhoneNumber());
                        System.out.println("Os dados encontrados foram:" + salesperson.getAddress());
                        System.out.println("Os dados encontrados foram:" + salesperson.getEmail());
                        System.out.println("Os dados encontrados foram:" + salesperson.getCPF());

                    }

                    response = "Dados encontrados com Sucesso";
                    res.enviarResponse(exchange, response, 200);

                }else {
                    response = "Dados não encontrados 123";
                    res.enviarResponse(exchange, response, 400);

                }

            } else if ("POST".equals(exchange.getRequestMethod())) {
                try (InputStream requestBody = exchange.getRequestBody()) {
                    JSONObject json = new JSONObject(new String(requestBody.readAllBytes()));

                    System.out.println("Cheguei no try - POST");

                    Salesperson salesperson = new Salesperson(
                            json.getString("name"),
                            json.getString("lastName"),
                            json.getString("phoneNumber"),
                            json.getString("CPF"),
                            json.getString("Email"),
                            json.getString("address")

                    );

                    System.out.println(salesperson);

                    salespersonList.add(salesperson);


                    response = "Dados cadastrados com Sucesso";
                    res.enviarResponse(exchange, response, 200);
                    System.out.println(salesperson.toJson());


                    }


                catch (Exception e){

                        System.out.println("Cheguei no catch");
                        response = "Estou caindo no catch";
                        res.enviarResponse(exchange,response, 200);
                }





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
