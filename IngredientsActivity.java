package com.chatter.android.uploadrec;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class IngredientsActivity extends AppCompatActivity {
    EditText editIng,amountNum;
    Button editAmount;
    Context context;
    ListView mlistViewIng;
    List<Ingredients> inglist;
    private static List<String> listOfAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);
        editIng = (EditText)findViewById(R.id.editIng);
        editAmount = (Button)findViewById(R.id.editAmount);
        amountNum = (EditText)findViewById(R.id.amountNum);
        mlistViewIng = (ListView)findViewById(R.id.listViewIng);
        listOfAmount = new ArrayList<>();  //creation of the list
        inglist = new ArrayList<>();
        //enter options to the list
        listOfAmount.add("קג");listOfAmount.add("גרם");listOfAmount.add("ליטר");listOfAmount.add("מ'ליטר");listOfAmount.add("כף");listOfAmount.add("כפית");
        context=this;
        //calling to the custom listView Inflater
        editAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setInflater(context);
            }
        });



    }


    public void save(View view)
    {
        String amountNum1=amountNum.getText().toString();
        String editAmount1= editAmount.getText().toString();
        String editIng1= editIng.getText().toString();
        IngListAdapter ILA = new IngListAdapter(context,inglist);
        inglist.add(new Ingredients(amountNum1,editAmount1,editIng1));
        mlistViewIng.setAdapter(ILA);
        amountNum.setText("");
        editAmount.setText("גרם");
        editIng.setText("");

    }


    public void setInflater(Context context)
    {
        final AlertDialog bldr = new AlertDialog.Builder(context).create();
        bldr.setTitle("בחר יחידת מידה");
        final LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = vi.inflate(R.layout.custom_listview, null);
        ListView lst = (ListView)view.findViewById(R.id.cusAmountList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context,android.R.layout.simple_list_item_1,listOfAmount);;
        lst.setAdapter(adapter);
        bldr.setView(view);
        lst.setClickable(true);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                editAmount.setText(listOfAmount.get(position).toString());
                bldr.dismiss();
            }
        });

        bldr.show();
    }





    public void dSave(View view)
    {
        //create empty intent for puting data
        Intent i = new Intent();
        //put data in the intent
        i.putExtra("amountNum",amountNum.getText().toString());
        i.putExtra("editAmount",editAmount.getText().toString());
        i.putExtra("editIng",editIng.getText().toString());
        //return result with code RESULT_OK
        setResult(Activity.RESULT_OK,i);
        //kill the activity
        finish();
    }

    public void dCanceled(View view)
    {
        //create empty intent for puting data
        Intent i = new Intent();
        //return result with code RESULT_OK
        setResult(Activity.RESULT_CANCELED,i);
        //kill the activity
        finish();
    }
}


