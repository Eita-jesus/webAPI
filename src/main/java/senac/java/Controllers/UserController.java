package senac.java.Controllers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;
import senac.java.DAL.UserDal;
import senac.java.Domain.Users;
import senac.java.Services.ResponseEndPoints;
import senac.java.Services.Servidor.Conexao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UserController {
    static ResponseEndPoints res = new ResponseEndPoints();
    private static List<Users> usersList = new ArrayList<>();

    public static class UserHandler implements HttpHandler {


        public void doGet(HttpExchange exchange){
            String response = "";
            List<Users> getAllFromArrey = Users.getAllUsers(usersList);
            if (!getAllFromArrey.isEmpty()){
                for (Users user : getAllFromArrey){
                    System.out.println("Os dados encontrados foram:" + user.getUname());
                    System.out.println("Os dados encontrados foram:" + user.getAge());
                    System.out.println("Os dados encontrados foram:" + user.getAddress());
                    System.out.println("Os dados encontrados foram:" + user.getEmail());
                    System.out.println("Os dados encontrados foram:" + user.getCPF());
                    System.out.println();
                    System.out.println("------------------------------------------" );
                    System.out.println();
                }
            }else {
                System.out.println("Nenhum usuário foi encontrado");
            }
            response = "Essa e a rota de Usuario - GET";
            res.enviarResponse(exchange,response, 200);
        }




        public void doPost(HttpExchange exchange){
            String response = "";

            UserDal userDal = new UserDal();

            int resp = 0;
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

                resp = userDal.inserUsuario(user.uname , user.age, user.address,user.email,user.password,user.cpf);


//                  userDal.inserUsuario(user.uname , user.age, user.address,user.email,user.password,user.cpf);

                System.out.println("O valor foi" + user.toJson());

                //tratar os dados
                if (resp == 0) {
                    response = "Houve um erro ao criar esse usuário";
                }else{
                    response = "Usuário criado com sucesso";
                }

            }catch(Exception e ){

//                    String resposta = e.toString();
                String resposta = e.toString();

                res.enviarResponse(exchange,resposta, 405);
                res.enviarResponse(exchange,response, 405);
            }
            response = "Essa e a rota de Usuario - POST api/usuario";
            res.enviarResponse(exchange,response,200);

        }


        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "";

            if ("GET".equals(exchange.getRequestMethod())){

                doGet(exchange);

            } else if ("POST".equals(exchange.getRequestMethod())){

                doPost(exchange);
                //Criar uma instancia

            }else if ("PUT".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de Usuario - PUT";
                res.enviarResponse(exchange,response,200);
            }else if("DELETE".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de Usuario - DELETE";
                res.enviarResponse(exchange,response,200);
            }else if ("OPTION".equals(exchange.getRequestMethod())){
                res.enviarResponse(exchange,response,200);
            }else{
                response = "ERROOOOOOO \n " + "O método imprementado é: "
                        + exchange.getRequestMethod();
                res.enviarResponse(exchange,response,200);
            }
            res.enviarResponse(exchange, response,405);
        }
    }




}
