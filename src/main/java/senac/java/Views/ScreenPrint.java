package senac.java.Views;

import senac.java.Domain.Salesperson;
import senac.java.Domain.Users;
import senac.java.Services.NewCadastro;
import senac.java.Domain.Products;

public class ScreenPrint {


    public static void screenPrint(int selectOptioned){


        if (selectOptioned == 1){
            //vendedor
            System.out.print(
                    "---- Descrição do Funcionário cadastrado ---" +
                            "id:" + Salesperson.id + "\n" +
                            "Name:" + Salesperson.name + "\n" +
                            "LastName:" + Salesperson.lastName + "\n" +
                            "Phone Number:" + Salesperson.phoneNumber + "\n" +
                            "CPF:" + Salesperson.CPF + "\n" +
                            "Email:" + Salesperson.Email + "\n" +
                            "Address:" + Salesperson.address
            );


        }else if (selectOptioned == 2){
            //cliente
            System.out.print(
                    "---- Descrição do usuário cadastrado ---" +
                            "id:" + Users.id +
                            "Name:" + Users.name + "\n" +
                            "Last Name:" + Users.lastName + "\n" +
                            "Age:" + Users.age + "\n" +
                            "Adress: " + Users.address + "\n" +
                            "Email:" + Users.Email + "\n" +
                            "Password:" + Users.password + "\n" +
                            "CPF: " + Users.CPF
            );

        }else{
            //produto

            System.out.print(
                    "---- Descrição do produto cadastrado ---" +
                            "id: " + Products.id + "\n" +
                            "Name: " + Products.pName + "\n" +
                            "Price: " + Products.pPrice + "\n" +
                            "Color: " + Products.pColor + "\n" +
                            "Description: " + Products.pDescription + "\n" +
                            "Quantidade: " + Products.pQuantidade + "\n" +
                            "img: " + Products.img +"\n"+
                            "---------------------------------------------"+
                            "Você quer continuar efetuando novos cadastro ?"
            );
            System.out.print("Digite S para Sim e N para voltar para tela inicial ou Sair para fechar a aplixação");

//            Userinput = sc.nextLine();
//            NewCadastro.confirmar(Userinput);

        }

    }


}
