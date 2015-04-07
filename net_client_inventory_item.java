import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.imageio.*;
import java.awt.image.*;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONValue;

import java.net.HttpURLConnection;
import javax.net.SocketFactory;







public class net_client_inventory_item{


Timer xtimerx;//class loop.
Toolkit toolkit;

String item_id_xx = new String("");


net_client_inventory_item(String item_id_x){//*****************************************************************

item_id_xx = item_id_x;

request_status();

}//************************************************************************************************************














public void request_status(){//*****************************************************************

String jsonText = new String("");


try{

JSONObject obj = new JSONObject();
obj.put(lm.program_version, "get_item_info");
obj.put("password", lm.passx);
obj.put("item_idx", item_id_xx);

StringWriter out = new StringWriter();
obj.writeJSONString(out);
jsonText = out.toString();
System.out.println(jsonText);

}catch(Exception e){System.out.println("JSON ERROR");}




try{

String sentence;   
String modifiedSentence = new String("");   

System.out.println("go");

	try{

		System.out.println("socket");

		SocketFactory factory = lm.tor.getSocketFactory();

   		Socket socket = factory.createSocket(lm.httpx, 80);

		System.out.println("socketg");

    		OutputStream outputStream = socket.getOutputStream();
    		PrintWriter outx = new PrintWriter(outputStream);
    		outx.print(jsonText + "\r\n\r\n");
    		outx.flush();
    		InputStream inputStream = socket.getInputStream();
    		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
    		BufferedReader in = new BufferedReader(inputStreamReader);

		System.out.println("socketw");

    		String line;
    		while ((line = in.readLine()) != null) {

    		  System.out.println(line);
		  modifiedSentence = line;

    		}//*************************************

   		outx.close();
    		in.close();
    		socket.close();

	}catch(Exception e){e.printStackTrace();}





	JSONParser parser = new JSONParser();

	try {//*********************************************************
 

		Object obj = parser.parse(modifiedSentence);
 
		JSONObject jsonObject = (JSONObject) obj;
  
		String request = (String) jsonObject.get("response");

		String currency = (String) jsonObject.get("[[currency]]");
		String custom_template = (String) jsonObject.get("[[custom_template]]");
		String custom_1 = (String) jsonObject.get("[[custom_1]]");
		String custom_2 = (String) jsonObject.get("[[custom_2]]");
		String custom_3 = (String) jsonObject.get("[[custom_3]]");
		String item_errors = (String) jsonObject.get("[[item_errors]]");
		String item_date_listed = (String) jsonObject.get("[[item_date_listed]]");
		String item_date_listed_day = (String) jsonObject.get("[[item_date_listed_day]]");
		String item_date_listed_int = (String) jsonObject.get("[[item_date_listed_int]]");
		String item_hits = (String) jsonObject.get("[[item_hits]]");
		String item_confirm_code = (String) jsonObject.get("[[item_confirm_code]]");
		String item_confirmed = (String) jsonObject.get("[[item_confirmed]]");
		String item_cost = (String) jsonObject.get("[[item_cost]]");
		String item_description = (String) jsonObject.get("[[item_description]]");
		String item_id = (String) jsonObject.get("[[item_id]]");
		String item_price = (String) jsonObject.get("[[item_price]]");
		String item_weight = (String) jsonObject.get("[[item_weight]]");
		String item_listing_id = (String) jsonObject.get("[[item_listing_id]]");
		String item_notes = (String) jsonObject.get("[[item_notes]]");
		String item_package_d = (String) jsonObject.get("[[item_package_d]]");
		String item_package_l = (String) jsonObject.get("[[item_package_l]]");
		String item_package_w = (String) jsonObject.get("[[item_package_w]]");
		String item_part_number = (String) jsonObject.get("[[item_part_number]]");
		String item_title = (String) jsonObject.get("[[item_title]]");
		String item_title_url = (String) jsonObject.get("[[item_title_url]]");
		String item_type = (String) jsonObject.get("[[item_type]]");
		String item_search_1 = (String) jsonObject.get("[[item_search_1]]");
		String item_search_2 = (String) jsonObject.get("[[item_search_2]]");
		String item_search_3 = (String) jsonObject.get("[[item_search_3]]");
		String item_site_id = (String) jsonObject.get("[[item_site_id]]");
		String item_site_url = (String) jsonObject.get("[[item_site_url]]");
		String item_picture_1 = (String) jsonObject.get("[[item_picture_1]]");
		String item_total_on_hand = (String) jsonObject.get("[[item_total_on_hand]]");
		String seller_address_1 = (String) jsonObject.get("[[seller_address_1]]");
		String seller_address_2 = (String) jsonObject.get("[[seller_address_2]]");
		String seller_address_city = (String) jsonObject.get("[[seller_address_city]]");
		String seller_address_state = (String) jsonObject.get("[[seller_address_state]]");
		String seller_address_zip = (String) jsonObject.get("[[seller_address_zip]]");
		String seller_address_country = (String) jsonObject.get("[[seller_address_country]]");
		String seller_id = (String) jsonObject.get("[[seller_id]]");
		String seller_ip = (String) jsonObject.get("[[seller_ip]]");
		String seller_email = (String) jsonObject.get("[[seller_email]]");
		String seller_first_name = (String) jsonObject.get("[[seller_first_name]]");
		String seller_last_name = (String) jsonObject.get("[[seller_last_name]]");
		String seller_notes = (String) jsonObject.get("[[seller_notes]]");
		String seller_phone = (String) jsonObject.get("[[seller_phone]]");
		String seller_logo = (String) jsonObject.get("[[seller_logo]]");
		String seller_url = (String) jsonObject.get("[[seller_url]]");

	
			for(int xloop = 1; xloop < lm.carbon_buy[0].length; xloop++){//****************************************************


			if(lm.carbon_buy[lm.item_id_xx][xloop].equals(item_id_xx)){

			System.out.println(xloop + " item_id_xx " + lm.carbon_buy[lm.item_id_xx][xloop]);

 
			lm.carbon_buy[lm.currency_xx][xloop] = currency;
			lm.carbon_buy[lm.custom_template_xx][xloop] = custom_template;
			lm.carbon_buy[lm.custom_1_xx][xloop] = custom_1;
			lm.carbon_buy[lm.custom_2_xx][xloop] = custom_2;
			lm.carbon_buy[lm.custom_3_xx][xloop] = custom_3;
			lm.carbon_buy[lm.item_errors_xx][xloop] = item_errors;
			lm.carbon_buy[lm.item_date_listed_xx][xloop] = item_date_listed;
			lm.carbon_buy[lm.item_date_listed_day_xx][xloop] = item_date_listed_day;
			lm.carbon_buy[lm.item_date_listed_int_xx][xloop] = item_date_listed_int;
			lm.carbon_buy[lm.item_hits_xx][xloop] = item_hits;
			lm.carbon_buy[lm.item_confirm_code_xx][xloop] = item_confirm_code;
			lm.carbon_buy[lm.item_confirmed_xx][xloop] = item_confirmed;
			lm.carbon_buy[lm.item_cost_xx][xloop] = item_cost;
			lm.carbon_buy[lm.item_description_xx][xloop] = item_description;
			lm.carbon_buy[lm.item_id_xx][xloop] = item_id;
			lm.carbon_buy[lm.item_price_xx][xloop] = item_price;
			lm.carbon_buy[lm.item_weight_xx][xloop] = item_weight;
			lm.carbon_buy[lm.item_listing_id_xx][xloop] = item_listing_id;
			lm.carbon_buy[lm.item_notes_xx][xloop] = item_notes;
			lm.carbon_buy[lm.item_package_d_xx][xloop] = item_package_d;
			lm.carbon_buy[lm.item_package_l_xx][xloop] = item_package_l;
			lm.carbon_buy[lm.item_package_w_xx][xloop] = item_package_w;
			lm.carbon_buy[lm.item_part_number_xx][xloop] = item_part_number;
			lm.carbon_buy[lm.item_title_xx][xloop] = item_title;
			lm.carbon_buy[lm.item_title_url_xx][xloop] = item_title_url;
			lm.carbon_buy[lm.item_type_xx][xloop] = item_type;
			lm.carbon_buy[lm.item_search_1_xx][xloop] = item_search_1;
			lm.carbon_buy[lm.item_search_2_xx][xloop] = item_search_2;
			lm.carbon_buy[lm.item_search_3_xx][xloop] = item_search_3;
			lm.carbon_buy[lm.item_site_id_xx][xloop] = item_site_id;
			lm.carbon_buy[lm.item_site_url_xx][xloop] = item_site_url;
			lm.carbon_buy[lm.item_picture_1_xx][xloop] = item_picture_1;
			lm.carbon_buy[lm.item_total_on_hand_xx][xloop] = item_total_on_hand;
			lm.carbon_buy[lm.seller_address_1_xx][xloop] = seller_address_1;
			lm.carbon_buy[lm.seller_address_2_xx][xloop] = seller_address_2;
			lm.carbon_buy[lm.seller_address_city_xx][xloop] = seller_address_city;
			lm.carbon_buy[lm.seller_address_state_xx][xloop] = seller_address_state;
			lm.carbon_buy[lm.seller_address_zip_xx][xloop] = seller_address_zip;
			lm.carbon_buy[lm.seller_address_country_xx][xloop] = seller_address_country;
			lm.carbon_buy[lm.seller_id_xx][xloop] = seller_id;
			lm.carbon_buy[lm.seller_ip_xx][xloop] = seller_ip;
			lm.carbon_buy[lm.seller_email_xx][xloop] = seller_email;
			lm.carbon_buy[lm.seller_first_name_xx][xloop] = seller_first_name;
			lm.carbon_buy[lm.seller_last_name_xx][xloop] = seller_last_name;
			lm.carbon_buy[lm.seller_notes_xx][xloop] = seller_notes;
			lm.carbon_buy[lm.seller_phone_xx][xloop] = seller_phone;
			lm.carbon_buy[lm.seller_logo_xx][xloop] = seller_logo;
			lm.carbon_buy[lm.seller_url_xx][xloop] = seller_url;

			//break;

			}//*******************************************************

			}//*****************************************************************************************************************




		if(request.equals("1")){lm.connection_active = 1;}
		else{lm.connection_active = 0; JOptionPane.showMessageDialog(null, "Server Offline");}


	}//try
	catch (ParseException e){e.printStackTrace(); lm.connection_active = 0; JOptionPane.showMessageDialog(null, "Connection failure!");}



}catch(Exception e){e.printStackTrace(); lm.connection_active = 0; JOptionPane.showMessageDialog(null, "Cannot find a host! 56"); lm.error_codes_client = "";}

}//*********************************************************************************************











}//last
