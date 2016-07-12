package com.chatter.android.uploadrec;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    String rName,timeTillDone,category,people,hezka,worth,lvl,hollyday,halfy,amountNum,editAmount,editIng;
    EditText userName;
    final List<Recpie> myData=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText)findViewById(R.id.UName);
    }


    public void insertRecData(View v)
    {
        //start activity and wait for result - request code 1
        startActivityForResult(new Intent(this, DetailsActivity.class), 1);

    }
    public void insertIngredients(View v)
    {
        //start activity and wait for result - request code 2
        startActivityForResult(new Intent(this, IngredientsActivity.class), 2);
    }
    public void insertProcess(View v)
    {

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //if request code is 1 , it's data1.class
        if (requestCode == 1) {
            rName = data.getStringExtra("rName");
            timeTillDone = data.getStringExtra("timeTillDone");
            category = data.getStringExtra("category");
            people = data.getStringExtra("people");
            hezka = data.getStringExtra("hezka");
            worth = data.getStringExtra("worth");
            lvl = data.getStringExtra("lvl");
            hollyday = data.getStringExtra("hollyday");
            halfy = data.getStringExtra("halfy");
        }

        //if request code is 1 , it's data2.class
        if (requestCode == 2) {
            amountNum = data.getStringExtra("amountNum");
            editAmount = data.getStringExtra("editAmount");
            editIng = data.getStringExtra("editIng");

        }

    }

    public void saveRecData(View v)
    {
        Toast.makeText(MainActivity.this, rName + "" + timeTillDone , Toast.LENGTH_LONG).show();
        //getting the info from the activity
        //creating new instance of the project
        Recpie recpie=new Recpie(getMac(),userName.getText().toString(),rName,timeTillDone,category,people,hezka,worth,lvl,hollyday,halfy);
        //calling inside method from the class to save the data
        recpie.saveRecpie();

        //creating an instance to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //creating a reference to message object
       // DatabaseReference myRef = database.getReference("Recpie");
        //getting the message from the activity
        String myString = getPackageName();
        //setting the value
        //myRef.setValue(rName);
    }

    public void cancelRecUpload(View v)
    {

    }

    private String getUUID()
    {
        //create a unique UUID
        UUID idOne = UUID.randomUUID();
        //returning the UUID
        return idOne.toString();
    }
    private String getMac()
    {
        //seeting WifiManager
        WifiManager manager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        //getting the info for the manager
        WifiInfo info = manager.getConnectionInfo();
        //getting mac address , physical address of the wifi card
        String address = info.getMacAddress();
        //returning the address
        return address;
    }
    /*public  void createUser(View v)
    {
        Toast.makeText(MainActivity.this, "Creating user" + userName.getText().toString(), Toast.LENGTH_LONG).show();
        User user = new User(userName.getText().toString(),getUUID());
        user.saveUser();
    }*/
}
