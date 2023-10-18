package senac.java.Domain;

import org.json.JSONObject;

import java.util.List;

public class Salesperson {

    public  int id = 0;
    public  String name = "";
    public  String lastName = "";
    public  String phoneNumber = "";
    public  String CPF = "";
    public  String Email = "";
    public  String address = "";


    public Salesperson(){};

    public Salesperson( String name, String lastName, String phoneNumber, String CPF, String Email, String address){
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.CPF = CPF;
        this.Email= Email;
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

    public  String getCPF() {
        return CPF;
    }

    public  void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public  String getEmail() {
        return Email;
    }

    public  void setEmail(String email) {Email = email;}

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
        json.put("CPF",CPF);
        json.put("Email",Email);
        json.put("address",address);

    return json;
    }


    public static Salesperson getSalesPerson(int index, List <Salesperson> salespersonList){

            if (index >= 0 && index < salespersonList.size()){

                return salespersonList.get(index);

            }else {
                return null;
            }
    }

    public static List<Salesperson>  getAllSalesPerson(List<Salesperson>salespersonList){
        return salespersonList;

    }

}
