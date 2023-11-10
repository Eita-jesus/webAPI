package senac.java.Domain;

import org.json.JSONObject;

import java.util.List;

public class Products {
        public static int id;
        public static String pName = "";
        public static String pPrice = "";
        public static String pColor = "";
        public static String pDescription = "";
        public static int pQuantidade = 0;
        public static String img = "";

        public  String getpName() {return pName;}
        public  String getpPrice() {return pPrice;}
        public  String getpColor() {return pColor;}
        public  String getpDescription() {return pDescription;}
        public  int getpQuantidade() {return pQuantidade;}
        public  String getImg() {return img;}

        public  void setpName(String pName) {Products.pName = pName;}
        public  void setpPrice(String pPrice) {Products.pPrice = pPrice;}
        public  void setpColor(String pColor) {Products.pColor = pColor;}
        public  void setpDescription(String pDescription) {Products.pDescription = pDescription;}
        public  void setpQuantidade(int pQuantidade) {Products.pQuantidade = pQuantidade;}
        public  void setImg(String img) {Products.img = img;}

        public JSONObject toJson(){

                JSONObject json = new JSONObject();

                json.put("pName", pName);
                json.put("pPrice",pPrice);
                json.put("pColor",pColor);
                json.put("pDescription",pDescription);
                json.put("pQuantidade",pQuantidade);
                json.put("img",img);

                return json;
        }


        public JSONObject arrayToJson(List<Products> productsList){

                JSONObject json = new JSONObject();

                if (!productsList.isEmpty()) {

                        var keyJson = 0;
                        for (Products products : productsList) {
                                JSONObject jsonFor = new JSONObject();

                                jsonFor.put("pName", products.getpName());
                                jsonFor.put("pPrice",products.getpPrice());
                                jsonFor.put("pColor",products.getpColor());
                                jsonFor.put("pDescription",products.getpDescription());
                                jsonFor.put("pQuantidade",products.getpQuantidade());
                                jsonFor.put("img",products.getImg());

                                keyJson++;
                                json.put(String.valueOf(keyJson),jsonFor);

                                System.out.println("================================================================");
                        }
                        return json;
                }else{
                        return null;
                }
        }

        public static Products getProducts(int index, List <Products> productsListList){

                if (index >= 0 && index < productsListList.size()){

                        return productsListList.get(index);

                }else {
                        return null;
                }
        }

        public static List<Products>  getAllProducts (List<Products>productsList){
                return productsList;

        }






}


