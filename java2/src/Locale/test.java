package Locale;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Locale;

import java.util.*; 
import java.util.ResourceBundle;
public class test {
  String name="Ho Van Cuong",dob="20-11-1991";
   double free=2000;
 public static void main(String[] args) {
   String name="Ho Van Cuong",dob="20-11-1991";
   double free=2000;
   ResourceBundle bundle;
   NumberFormat formatter =NumberFormat.getCurrencyInstance();
   NumberFormat n = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
   String currency = formatter.format(free);
   DateFormat formatterdate=DateFormat.getDateInstance(DateFormat.DEFAULT,Locale.US);
   DateFormat formatterdatevn=DateFormat.getDateInstance(DateFormat.DEFAULT,new Locale("vi", "VN"));  
   
   Date currentDate=new Date();  
   String date=formatterdate.format(currentDate);  
   String datevn=formatterdatevn.format(currentDate);

   

       bundle = ResourceBundle.getBundle("Locale.MessageBundle", Locale.US);
       System.out.println(bundle.getString("name")+name);
       System.out.println(bundle.getString("dob")+date);
       System.out.println(bundle.getString("free")+currency);
       
       Locale.setDefault(new Locale("vi", "VN"));
       bundle = ResourceBundle.getBundle("Locale.MessageBundle");
       System.out.println(bundle.getString("name")+name);
       System.out.println(bundle.getString("dob")+datevn);
       System.out.println(bundle.getString("free")+n.format(free));
       

 }
}