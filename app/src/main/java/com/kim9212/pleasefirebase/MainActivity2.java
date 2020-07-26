package com.kim9212.pleasefirebase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ArrayList<String> datas= new ArrayList<String>();

    ListView listView;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        adapter= new ArrayAdapter(this, R.layout.list_item, datas);
        listView =  findViewById(R.id.db_list_view2);
        listView.setAdapter(adapter);

        //TO DO: 홍드로이드 34로 파이어베이스에있는거가져오기



    }

    public void clickbtn(View view) {
        Intent intent= new Intent(this, MainActivity.class);
        startActivityForResult(intent, 10);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==10 && resultCode==RESULT_OK ){
            String name= data.getStringExtra("Name");
            String nick= data.getStringExtra("Nick");
            String str= name+"   " + nick ;
            datas.add( 0, str );
            adapter.notifyDataSetChanged();
            Log.i("TAG",name);

        }
    }
}