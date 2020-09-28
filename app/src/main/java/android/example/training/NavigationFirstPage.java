package android.example.training;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationFirstPage extends AppCompatActivity {

    BottomNavigationView navi;
    Button homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_first_page);

        navi=findViewById(R.id.bnv);
        navi.setSelectedItemId(R.id.regformid);

        homeButton=findViewById(R.id.homebutton);





        navi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.regformid:
                        Toast.makeText(NavigationFirstPage.this, "Already in Register Form", Toast.LENGTH_SHORT).show();
                         return true;

                    case R.id.webid:
                        Intent intent = new Intent(NavigationFirstPage.this,NavigationSecondPage.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        Toast.makeText(NavigationFirstPage.this, "Stay connected With", Toast.LENGTH_SHORT).show();
                        return true;
                }

                return false;
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(NavigationFirstPage.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(NavigationFirstPage.this, "Home", Toast.LENGTH_SHORT).show();
            }
        });
    }
}