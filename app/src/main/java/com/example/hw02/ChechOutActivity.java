package com.example.hw02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ChechOutActivity extends AppCompatActivity {
    ArrayList<String> toppingsName = new ArrayList<String>();
    double toppingPrice ;
    double totalPrice;
    Boolean isChecked;
    Button finish;
    StringBuilder builder = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chech_out);
        setTitle("YOUR ORDER");

        EditText base_price = findViewById(R.id.ed_basePrice);
        base_price.setText("6.5$");

        EditText toppingsAdded = findViewById(R.id.et_toppings);
        EditText deliveryPrice = findViewById(R.id.et_delivery);
        EditText total = findViewById(R.id.editText8);
        EditText addedToppings = findViewById(R.id.addedToppings);
        TextView deliveryCost = findViewById(R.id.delivery_cost);
         finish = findViewById(R.id.button_finish);



        toppingsName = getIntent().getExtras().getStringArrayList("key");
        isChecked =getIntent().getExtras().getBoolean("deliveryCheck");


        // add toppings name
        String separator ="";
        for(String value : toppingsName){
            builder.append(separator);
            builder.append(value);
            separator= ", ";

        }
        String text = builder.toString();
        addedToppings.setText(text);
        toppingPrice = toppingsName.size()*1.50 ;
        toppingsAdded.setText(String.valueOf(toppingPrice)+"$");

        if(isChecked){
        totalPrice= toppingPrice +6.5+ 4;
            deliveryPrice.setText("4.0$");
        }
        else {
            totalPrice= toppingPrice +6.5;
            deliveryPrice.setVisibility(View.INVISIBLE);
            deliveryCost.setVisibility(View.INVISIBLE);

        }

        total.setText(String.valueOf(totalPrice)+"$");


        Log.d("demo",toppingsName.toString());


      finish.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(ChechOutActivity.this,MainActivity.class);
              startActivity(intent);
              setResult(ChechOutActivity.RESULT_OK,intent);
              finish();
          }
      });

    }



}
