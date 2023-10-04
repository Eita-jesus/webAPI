package senac.java.Services;

import senac.java.Views.Presentation;
import senac.java.Views.ScreenRegister;

import static java.lang.System.exit;


public class SelectedOption {
    public void selected(int numberSelected){
        ScreenRegister screenRegister = new ScreenRegister();
        Presentation  presentation = new Presentation();


        int SelectOption = 0;

        switch (numberSelected){
            case 1:
                //1. Cadastrar vendedor
                    ScreenRegister.inputSalesperson();
                break;
            case 2:
                //2. Cadastrar Cliente
                    ScreenRegister.inputUser();
                break;
            case 3:
                //3. Cadastrar Produtos
                    ScreenRegister.inputProdut();
                 break;
            case 4:
                //4. Sair
                    exit(0);
                    System.out.print("execute o método 4");
                break;
            default:
                    System.out.print("Opção inválida");
                    Presentation.showOptions();
                break;



        }

    }
}
