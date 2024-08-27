package com.example.store;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowInsets;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    ImageButton buttonDrawerToggle;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    MenuItem navy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        View decoreView = getWindow().getDecorView();

        decoreView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener(){
            @NonNull
            @Override
            public WindowInsets onApplyWindowInsets(@NonNull View v, @NonNull WindowInsets insets){
                int left = insets.getSystemWindowInsetLeft();
                int top = insets.getSystemWindowInsetTop();
                int right = insets.getSystemWindowInsetRight();
                int bottom = insets.getSystemWindowInsetBottom();

                v.setPadding(left,top,right,bottom);
                return insets.consumeSystemWindowInsets();
            }
        });

        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawerLayout);
        buttonDrawerToggle = findViewById(R.id.buttonDrawerToggle);

        buttonDrawerToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.open();
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Intent intent;
                if(id == R.id.todolist){
                    intent = new Intent(MainActivity.this, ToDo.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this , "click",Toast.LENGTH_SHORT).show();
                }
                if(id == R.id.timetable){
                    intent = new Intent(MainActivity.this, TimeTable.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this , "click",Toast.LENGTH_SHORT).show();
                }
                if(id == R.id.settime){
                    intent = new Intent(MainActivity.this, SetTime.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this , "click",Toast.LENGTH_SHORT).show();
                }
               return true;
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawerLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}