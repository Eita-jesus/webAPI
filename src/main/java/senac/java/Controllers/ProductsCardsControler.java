package senac.java.Controllers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;
import senac.java.Services.ResponseEndPoints;
import senac.java.Domain.ProductsCards;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

    public class ProductsCardsControler {
     static ResponseEndPoints res = new ResponseEndPoints();
    public JSONObject ob = new JSONObject();
    public static List<ProductsCardsControler> productsCardsControlerList = new ArrayList<>();

        public static class ProductsCardsHandler implements HttpHandler{


            public void handle(HttpExchange exchange)throws IOException{
                String response = "";

                if ("GET".equals(exchange.getRequestMethod())){
                    response = "Estamos no GET da rota de Products Cards";
                    res.enviarResponse(exchange,response,200);


                }else if("POST".equals(exchange.getRequestMethod())){
                    response = "Estamos no POST da rota de Products Cards";
                    try(InputStream requestBody = exchange.getRequestBody()){
                        JSONObject json = new JSONObject(new String(requestBody.readAllBytes()));

                        ProductsCards ProductsCards = new ProductsCards(
                                json.getString("pName"),
                                json.getString("pPrice"),
                                json.getString("imagemcelular")
                        );



                    }catch (Exception e){


                    }

                    res.enviarResponse(exchange, response,200);
                }else if("PUT".equals(exchange.getRequestMethod())){
                    response = "Estamos no PUT da rota de Products Cards";
                    res.enviarResponse(exchange,response,200);

                }else if("DELETE".equals(exchange.getRequestMethod())){
                    response = "Estamos no DELETE da rota de Products Cards";
                    res.enviarResponse(exchange,response,200);

                }else if("OPTIONS".equals(exchange.getRequestMethod())){
                    response = "Estamos no OPTIONS da rota de Products Cards";
                    res.enviarResponse(exchange,response,200);
                }else{
                    response = "ERROR no Cards Controler";
                    res.enviarResponse(exchange,response,401);


                }

            }

        }
}
