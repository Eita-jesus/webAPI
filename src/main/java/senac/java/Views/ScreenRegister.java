package senac.java.Views;

import senac.java.Domain.Products;
import senac.java.Domain.Salesperson;
import senac.java.Domain.Stores;
import senac.java.Domain.Users;
import senac.java.Services.NewCadastro;

import java.util.Scanner;

public class ScreenRegister {
    public static  String Userinput = "";
    NewCadastro novo = new NewCadastro();
    ScreenPrint screenPrint = new ScreenPrint();
    public static Products products = new Products();
    public static Scanner sc = new Scanner(System.in);

    public static void inputProdut() {

        System.out.print("Digite um id: ");
        products.id = Integer.parseInt(sc.nextLine());
        System.out.print("Digite um Name: ");
        products.pName = sc.nextLine();
        System.out.print("Digite um Price: ");
        products.pPrice = sc.nextLine();
        System.out.print("Digite um Color: ");
        products.pColor = sc.nextLine();
        System.out.print("Digite um Description: ");
        products.pDescription = sc.nextLine();
        System.out.print("Digite um Quantidade: ");
        products.pQuantidade = Integer.parseInt(sc.nextLine());
        System.out.print("Digite um img: ");
        products.img = sc.nextLine();


    }
    public static void inputSalesperson() {
        System.out.print("id:");
        Salesperson.id = Integer.parseInt(sc.nextLine());
        System.out.print("name :");
        Salesperson.name = sc.nextLine();
        System.out.print("lastName:");
        Salesperson.lastName = sc.nextLine();
        System.out.print("phoneNumber:");
        Salesperson.phoneNumber = sc.nextLine();
        System.out.print("CPF :");
        Salesperson.CPF = sc.nextLine();
        System.out.print("Email :");
        Salesperson.Email = sc.nextLine();
        System.out.print("address:");
        Salesperson.address = sc.nextLine();

    }

    public static void inputStores() {
        System.out.print("id");
        Stores.id = Integer.parseInt(sc.nextLine());
        System.out.print("Address");
        Stores.address = sc.nextLine();
        System.out.print("City");
        Stores.city = sc.nextLine();
        System.out.print("State");
        Stores.state = sc.nextLine();
        System.out.print("CNPJ");
        Stores.CNPJ = sc.nextLine();
        System.out.print("Phone Number");
        Stores.phoneNumber = sc.nextLine();
        System.out.print("Email");
        Stores.email = sc.nextLine();


//        System.out.print(
//                "---- Descrição da Loja cadastrada ---" +
//                        "id:" + Stores.id + "\n" +
//                        "Address:" + Stores.address + "\n" +
//                        "City:" + Stores.city + "\n" +
//                        "State:" + Stores.state + "\n" +
//                        "CNPJ: " + Stores.CNPJ + "\n" +
//                        "Phone Number:" + Stores.phoneNumber + "\n" +
//                        "Email:" + Stores.email
//        );

    }

    public static void inputUser() {
        System.out.print("id");
        Users.id = Integer.parseInt(sc.nextLine());
        System.out.print("Name:");
        Users.name = sc.nextLine();
        System.out.print("Last Name:");
        Users.lastName = sc.nextLine();
        System.out.print("Adress:");
        Users.address = sc.nextLine();
        System.out.print("Email:");
        Users.Email = sc.nextLine();
        System.out.print("Password: ");
        Users.password = sc.nextLine();
        System.out.print("CPF: ");
        Users.CPF = sc.nextLine();



    }


}
