package sv.edu.alcaldiaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class DesarrolloEconomicoActivity extends AppCompatActivity {

    BottomNavigationView menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desarrollo_economico);

        menu = findViewById(R.id.bottom_navigation);

        menu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.Ir_EvenSocial:
                        startActivity(new Intent(DesarrolloEconomicoActivity.this, MainActivity.class));
                        return true;
                    case R.id.Ir_DesaEcon:
                        startActivity(new Intent(DesarrolloEconomicoActivity.this, DesarrolloEconomicoActivity.class));
                        return true;
                    case R.id.Ir_Revista:
                        return true;
                }

                return false;
            }
        });
    }
}