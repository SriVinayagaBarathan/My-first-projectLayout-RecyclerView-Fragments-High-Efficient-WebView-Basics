





package android.example.training;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.example.training.R;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
{

    Button firstButton;


   RecyclerView recycleList;
   String[] Streams,Descrps;
   int[]images={R.drawable.andro,R.drawable.ioso,R.drawable.windowso,R.drawable.macoso,R.drawable.gameo,R.drawable.webo};
   MyAdapter adapter;



    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override


    protected void onCreate(Bundle savedInstanceState)
    {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstButton=findViewById(R.id.bt1);

        recycleList=findViewById(R.id.rv1);

        //recycler view things
        Streams=getResources().getStringArray(R.array.Stream);
        Descrps=getResources().getStringArray(R.array.description);


        adapter=new MyAdapter(this,Streams,Descrps,images);

        recycleList.setAdapter(adapter);
        recycleList.setLayoutManager(new LinearLayoutManager(this));













        //recycler View Method











        // it helps to moveto next page
         firstButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view)
             {
                 Intent nextpageIntent=new Intent(MainActivity.this,NavigationFirstPage.class);
                 startActivity(nextpageIntent);
             }
         });









    }









}


