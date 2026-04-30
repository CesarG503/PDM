package com.example.navigationfragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.navigationfragment.fragment.IngredientesFragment;
import com.example.navigationfragment.fragment.PersonasFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.deleteDatabase("db_prestamos");
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                int itemId = menuItem.getItemId();

                if (itemId == R.id.receta)
                {
                    loadFragment(new RecetasFragment());
                    return true;
                }
                if (itemId == R.id.ingrediente)
                {
                    loadFragment(new IngredientesFragment());
                    return true;
                }
                if (itemId == R.id.persona)
                {
                    loadFragment(new PersonasFragment());
                    return true;
                }
                return false;
            }
        });

        if(savedInstanceState == null)
        {
            loadFragment(new RecetasFragment());
            bottomNavigationView.setSelectedItemId(R.id.receta);
        }
    }
    private void loadFragment(Fragment fragment)
    {
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
    }
}