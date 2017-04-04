package com.example.orderapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class Alcohol extends Activity {
	
	int Kokanee = 0;
	int Budweiser = 0;
	int Chivas = 0;
	int Ballantines = 0;
	static int Alcohol[] = {0,0,0,0}; //fixed elements just for now : Alcohol[kok, Bud, Chivas, Ballan]
	int AlcoholKind = Alcohol.length;
	static double AlcoholPrice[] = {5.00,7.00,5.00,6.00};
	static double price = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alcohol);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alcohol, menu);
		return true;
	}
	public static String getAlcohols(int i){
		String Al[] = {"Kokanee","Chivas","Budweiser","Ballantines"};
		
		return Al[i];
	}
	
	public static int[] getAl(){
		return Alcohol;// = {"Kokanee","Chivas","Budweiser","Ballantines"};
		
	}
	
	public static double getAlPrice(){
		return price;
	}
	
	
	public void onClickSaveAndCont(View view){

		price = 0;
		//buffer to send to DE2
//		int Alcohol[] = {0,0,0,0}; //fixed elements just for now : Alcohol[kok, Bud, Chivas, Ballan]
		
		EditText EditText1 = (EditText) findViewById(R.id.editText1);
		EditText EditText2 = (EditText) findViewById(R.id.editText2);
		EditText EditText3 = (EditText) findViewById(R.id.editText3);
		EditText EditText4 = (EditText) findViewById(R.id.editText4);
		
		
		if(EditText1.getText().toString().matches("")){
			Kokanee = 0;
		}
		if(EditText2.getText().toString().matches("")){
			Chivas = 0;
		}
		if(EditText3.getText().toString().matches("")){
			Budweiser = 0;
		}
		if(EditText4.getText().toString().matches("")){
			Ballantines = 0;
		}
		try{
			int message1 = Integer.parseInt(EditText1.getText().toString());	
			NumberCustomers.CurrentCust.alcohol[0] = message1;
			Kokanee = message1;
		}
			catch(NumberFormatException nfe)
			{
				Kokanee = 0;
				NumberCustomers.CurrentCust.alcohol[0] = 0;
			}
		
		try{
			int message2 = Integer.parseInt(EditText2.getText().toString());	
			Chivas = message2;
			NumberCustomers.CurrentCust.alcohol[1] = message2;
		}
			catch(NumberFormatException nfe)
			{
				Chivas = 0;
				NumberCustomers.CurrentCust.alcohol[1] = 0;
			}
		try{
			int message3 = Integer.parseInt(EditText3.getText().toString());	
			Budweiser = message3;
			NumberCustomers.CurrentCust.alcohol[2] = message3;
		}
			catch(NumberFormatException nfe)
			{
				Budweiser = 0;
				NumberCustomers.CurrentCust.alcohol[2] = 0;
			}
		try{
			int message4 = Integer.parseInt(EditText4.getText().toString());	
			NumberCustomers.CurrentCust.alcohol[3] = message4;
			Ballantines = message4;
		}
			catch(NumberFormatException nfe)
			{
				NumberCustomers.CurrentCust.alcohol[3] = 0;
				Ballantines = 0;
			}
			
		Alcohol[0] = Kokanee;
		Alcohol[1] = Chivas;
		Alcohol[2] = Budweiser;
		Alcohol[3] = Ballantines;
		
		//NumberCustomers.CurrentCust.CustAl(Alcohol);
	
		
		for(int i=0; i<AlcoholKind; i++)
		{
			price = AlcoholPrice[i]*Alcohol[i]+price;
		}
		
		NumberCustomers.CurrentCust.Alsum = price;
		
		Intent intent = new Intent(this, ViewMenu.class);
		//intent.putExtra("Alcohol_Data", Alcohol);
		startActivity(intent);
		
		
	}
	
	@Override
	public void onBackPressed() {
	}
	
	
}

