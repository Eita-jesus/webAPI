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
                Salesperson salespersonJson = new Salesperson();

                if (!getAllFromArray.isEmpty()){
                    for(Salesperson salesperson: getAllFromArray){

                            System.out.println("Nome:" + salesperson.getName());
                            System.out.println("Sobrenome:" + salesperson.getLastName());
                            System.out.println("Número de Telefone:" + salesperson.getPhoneNumber());
                            System.out.println("Endereço:" + salesperson.getAddress());
                            System.out.println("Email:" + salesperson.getEmail());
                            System.out.println("Cpf:" + salesperson.getCPF());
                            System.out.println();
                            System.out.println("-----------------------------------------------------");
                            System.out.println();
                        }
                        response = "Dados encontrados com Sucesso - Estou no GET validation";
                        res.enviarResponseJson(exchange,salespersonJson.arrayToJson(getAllFromArray),200);
                    }else {
                        response = "Dados não encontrado Estou no GET ELSE";
                        res.enviarResponse(exchange, response, 200);
                    }
                } else if ("POST".equals(exchange.getRequestMethod())){
                    try (InputStream requestBody = exchange.getRequestBody()) {
                        JSONObject json = new JSONObject(new String(requestBody.readAllBytes()));
                        System.out.println("CHEGUEI NO POST - TRY");
                        Salesperson salesperson = new Salesperson(
                                    json.getString("name"),
                                    json.getString("lastName"),
                                    json.getString("phoneNumber"),
                                    json.getString("cpf"),
                                    json.getString("email"),
                                    json.getString("address")
                        );
                        salespersonList.add(salesperson);
                        System.out.println(salesperson);

                        response = "Dados cadastrados com Sucesso";
                        res.enviarResponse(exchange, response, 200);
                        System.out.println(salesperson.toJson());
                    }
                    catch (Exception e){
                        String response1 = e.toString();
                        System.out.println(response1);
                        System.out.println("Cheguei no catch");
                        response = "Estou caindo no catch do POST Sales Personcontroler" ;
                        res.enviarResponse(exchange,response, 200);
                    }
                }else if ("PUT".equals(exchange.getRequestMethod())){
                    response = "Essa e a rota de Vendedor - PUT";
                    res.enviarResponse(exchange,response, 200);
                }else if("DELETE".equals(exchange.getRequestMethod())){
                    response = "Essa e a rota de Vendedor - DELETE";
                    res.enviarResponse(exchange,response, 200);
                }else if("OPTION".equals(exchange.getRequestMethod())){
                    exchange.sendResponseHeaders(204,-1);
                    exchange.close();
                }

            }

        }

}
