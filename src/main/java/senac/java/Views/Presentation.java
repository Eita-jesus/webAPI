package senac.java.Views;

import senac.java.Domain.Users;
import senac.java.Domain.*;
import senac.java.Services.SelectedOption;

import java.util.Scanner;

public class Presentation {


    public static Scanner sc = new Scanner(System.in);
    public static SelectedOption rotas = new SelectedOption();

    public static void showOptions(){
        int numberSelected = 0;
        System.out.println("------------------------------------------------------");
        System.out.println("Bem Vindo ao gestor" + "\n");

        System.out.println(
                        "1. Cadastrar vendedor"  + "\n"+
                        "2. Cadastrar Cliente" + "\n"+
                        "3. Cadastrar Produtos" + "\n"+
                        "4. Sair" + "\n"
        );
        System.out.println("------------------------------------------------------");
        System.out.print("Digite um número: ");
        numberSelected = sc.nextInt();

        rotas.selected(numberSelected);


    }


}
