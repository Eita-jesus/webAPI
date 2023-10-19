package senac.java.Domain;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class Salesperson {

    public  int id = 0;
    public  String name = "";
    public  String lastName = "";
    public  String phoneNumber = "";
    public  String cpf = "";
    public  String email = "";
    public  String address = "";


    public Salesperson(){};

    public Salesperson( String name, String lastName, String phoneNumber, String CPF, String Email, String address){
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.cpf = CPF;
        this.email= Email;
        this.address = address;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public  void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public  String getCPF() {return cpf;}
    public  void setCPF(String cpf) {
        this.cpf = cpf;
    }
    public  String getEmail() {
        return email;
    }
    public  void setEmail(String email) {this.email = email;}
    public  String getAddress() {
        return address;
    }
    public  void setAddress(String address) {
        this.address = address;
    }

    public JSONObject toJson(){

        JSONObject json = new JSONObject();

        json.put("name", name);
        json.put("lastName",lastName);
        json.put("phoneNumber",phoneNumber);
        json.put("CPF",cpf);
        json.put("Email",email);
        json.put("address",address);

    return json;
    }


    public JSONObject arrayToJson(List<Salesperson>salesPersonList){

        JSONObject json = new JSONObject();

          if (!salesPersonList.isEmpty()) {

              var keyJson = 0;
              for (Salesperson salesperson : salesPersonList) {
                    JSONObject jsonFor = new JSONObject();

                  jsonFor.put("name", salesperson.getName());
                  jsonFor.put("lastName",salesperson.getLastName());
                  jsonFor.put("phoneNumber",salesperson.getPhoneNumber());
                  jsonFor.put("CPF",salesperson.getAddress());
                  jsonFor.put("Email",salesperson.getEmail());
                  jsonFor.put("address",salesperson.getCPF());

                  keyJson++;
                  json.put(String.valueOf(keyJson),jsonFor);

                  System.out.println("================================================================");
              }
              return json;
          }else{
              return null;
          }
    }

    public static Salesperson getSalesPerson(int index, List <Salesperson> salespersonList){

            if (index >= 0 && index < salespersonList.size()){

                return salespersonList.get(index);

            }else {
                return null;
            }
    }

    public static List<Salesperson>  getAllSalesPerson (List<Salesperson>salespersonList){
        return salespersonList;

    }

}
