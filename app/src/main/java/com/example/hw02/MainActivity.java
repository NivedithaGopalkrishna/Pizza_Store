package com.example.hw02;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    private Button add_topping;
    private Button clear_pizza;
    private Button check_out;
    private ImageView pizza;
    private TextView viewToppings;
    private ImageView bacon ;
    private GridView gridView;
    private CheckBox checkDelivery;
    ArrayList<Integer> toppingsList = new ArrayList<Integer>();
    ArrayList<String> toppingsName = new ArrayList<String>();

    private ProgressBar progressBar;
    Boolean isChecked = false;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 001) {
            if (resultCode == RESULT_OK) {
                toppingsList.clear();
                progressBar.setProgress(0);



                }
            }
        }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("PIZZA STORE");


        // assigning

        add_topping = findViewById(R.id.button_addToppings);
        clear_pizza = findViewById(R.id.button_clearPizza);
        check_out = findViewById(R.id.button_checkOut);
        pizza= findViewById(R.id.imageView_pizza);
        viewToppings= findViewById(R.id.textView_topping);
        gridView= findViewById(R.id.gridView);
        // setting up progess bar
        progressBar= findViewById(R.id.progressBar);
        progressBar.setMax(10);
        //  check for delivery
        checkDelivery= findViewById(R.id.delivery);



       final String[] toppings = getResources().getStringArray(R.array.toppings);
        final ImageView imageView = new ImageView(this);
       final MyAdapter myAdapter = new MyAdapter(this,toppingsList);



        // creating alert dialog

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        mBuilder.setTitle("Choose A Topping");
        mBuilder.setItems(toppings, new DialogInterface.OnClickListener() {



     @Override
     public void onClick(DialogInterface dialogInterface, int i) {


             if(myAdapter.getCount()<=9){
                        switch (i){

                            case 0 :
                                toppingsList.add(R.drawable.bacon);
                                toppingsName.add("Bacon");
                                progressBar.incrementProgressBy(1);
                                gridView.setAdapter(myAdapter);
                                break;

                            case 1:
                                toppingsList.add(R.drawable.cheese);
                                toppingsName.add("Cheese");
                                progressBar.incrementProgressBy(1);
                                gridView.setAdapter(myAdapter);
                                break;
                            case 2:
                                toppingsList.add(R.drawable.garlic);
                                toppingsName.add("Garlic");
                                progressBar.incrementProgressBy(1);
                                gridView.setAdapter(myAdapter);
                                break;
                            case 3:
                                toppingsList.add(R.drawable.green_pepper);
                                toppingsName.add("Green Pepper");
                                progressBar.incrementProgressBy(1);
                                gridView.setAdapter(myAdapter);
                                break;
                            case 4:
                                toppingsList.add(R.drawable.mashroom);
                                toppingsName.add("Mashroom");
                                progressBar.incrementProgressBy(1);
                                gridView.setAdapter(myAdapter);
                                break;
                            case 5:
                                toppingsList.add(R.drawable.olive);
                                toppingsName.add("Olive");
                                progressBar.incrementProgressBy(1);
                                gridView.setAdapter(myAdapter);
                                break;
                            case 6:
                                toppingsList.add(R.drawable.onion);
                                toppingsName.add("Onion");
                                progressBar.incrementProgressBy(1);
                                gridView.setAdapter(myAdapter);
                                break;
                            case 7:
                                toppingsList.add(R.drawable.red_pepper);
                                toppingsName.add("Red Pepper");
                                progressBar.incrementProgressBy(1);
                                gridView.setAdapter(myAdapter);
                                break;
                        }}
             else{
                 Toast.makeText(MainActivity.this,"MAximum Capacity!",Toast.LENGTH_LONG).show();
             }

                        dialogInterface.dismiss();
                    }
                });

               final AlertDialog mDialog = mBuilder.create();

                add_topping.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mDialog.show();
                    }
                });

 gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
     @Override
     public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

         switch (i){
             case 0 :
                 toppingsList.remove(i);
                 toppingsName.remove(i);
                 progressBar.incrementProgressBy(-1);
                 gridView.setAdapter(myAdapter);
                 break;
             case 1 :
                 toppingsList.remove(i);
                 toppingsName.remove(i);
                 progressBar.incrementProgressBy(-1);
                 gridView.setAdapter(myAdapter);
                 break;
             case 2 :
                 toppingsList.remove(i);
                 toppingsName.remove(i);
                 progressBar.incrementProgressBy(-1);
                 gridView.setAdapter(myAdapter);
                 break;
             case 3:
                 toppingsList.remove(i);
                 toppingsName.remove(i);
                 progressBar.incrementProgressBy(-1);
                 gridView.setAdapter(myAdapter);
                 break;
             case 4 :
                 toppingsList.remove(i);
                 toppingsName.remove(i);
                 progressBar.incrementProgressBy(-1);
                 gridView.setAdapter(myAdapter);
                 break;
             case 5 :
                 toppingsList.remove(i);
                 toppingsName.remove(i);
                 progressBar.incrementProgressBy(-1);
                 gridView.setAdapter(myAdapter);
                 break;
             case 6 :
                 toppingsList.remove(i);
                 toppingsName.remove(i);
                 progressBar.incrementProgressBy(-1);
                 gridView.setAdapter(myAdapter);
                 break;
             case 7 :
                 toppingsList.remove(i);
                 toppingsName.remove(i);
                 progressBar.incrementProgressBy(-1);
                 gridView.setAdapter(myAdapter);
                 break;
         }

     }
 });



        clear_pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toppingsList.clear();
                toppingsName.clear();
                progressBar.setProgress(0);
                gridView.setAdapter(myAdapter);
            }
        });


        check_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ChechOutActivity.class);
                intent.putExtra("key",toppingsName);
                intent.putExtra("deliveryCheck",isChecked);
                startActivityForResult(intent , 001);

            }
        });





        checkDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(((CheckBox)view).isChecked())

                    isChecked= true;
                }

        });
            }






}






