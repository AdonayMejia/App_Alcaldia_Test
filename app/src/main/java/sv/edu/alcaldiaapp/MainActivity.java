package sv.edu.alcaldiaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sv.edu.alcaldiaapp.Adapter.EventoSocialAdapter;
import sv.edu.alcaldiaapp.Api.ApiEventoSocial;
import sv.edu.alcaldiaapp.Model.EventoSocialResponse;

public class MainActivity extends AppCompatActivity implements EventoSocialAdapter.ClickedItem {
    BottomNavigationView menu;
    Toolbar toolbar;
    RecyclerView recyclerView;
    EventoSocialAdapter eventoSocialAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu = findViewById(R.id.bottom_navigation);
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        eventoSocialAdapter = new EventoSocialAdapter(this::ClickedUser);



        menu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.Ir_EvenSocial:
                        startActivity(new Intent(MainActivity.this, MainActivity.class));
                        return true;
                    case R.id.Ir_DesaEcon:
                        startActivity(new Intent(MainActivity.this, DesarrolloEconomicoActivity.class));
                        return true;
                    case R.id.Ir_Revista:
                        return true;
                }

                return false;
            }
        });

        getAllEvents();
    }

    public void getAllEvents() {

        Call<List<EventoSocialResponse>> eventslist = ApiEventoSocial.getEventService().getAllEvents();

        eventslist.enqueue(new Callback<List<EventoSocialResponse>>() {
            @Override
            public void onResponse(Call<List<EventoSocialResponse>> call, Response<List<EventoSocialResponse>> response) {

                if (response.isSuccessful()) {
                    List<EventoSocialResponse> eventoSocialRespons = response.body();
                    eventoSocialAdapter.setData(eventoSocialRespons);
                    recyclerView.setAdapter(eventoSocialAdapter);

                }

            }

            @Override
            public void onFailure(Call<List<EventoSocialResponse>> call, Throwable t) {
                Log.e("failure", t.getLocalizedMessage());

            }
        });
    }


    @Override
    public void ClickedUser(EventoSocialResponse eventoSocialResponse) {
        startActivity(new Intent(this, EvontoSocialDetailsActivity.class).putExtra("data", eventoSocialResponse));
    }
}