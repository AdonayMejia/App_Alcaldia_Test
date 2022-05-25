package sv.edu.alcaldiaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import sv.edu.alcaldiaapp.Model.EventoSocialResponse;

public class EvontoSocialDetailsActivity extends AppCompatActivity {

    TextView descripcion;
    ImageView imagen;
    EventoSocialResponse eventoSocialResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evonto_social_details);

        descripcion  = findViewById(R.id.nameTextView);
        imagen  = findViewById(R.id.posterImgeView);

        Intent intent = getIntent();
        if(intent.getExtras() !=null){
            eventoSocialResponse = (EventoSocialResponse) intent.getSerializableExtra("data");

            String usernamedata = eventoSocialResponse.getDescripcion();
            //String img = userResponse.getLast_name();

            String urlImg = "https://apiclinica.000webhostapp.com/Sitio/dashboard/Imagenes/";


            Picasso.get().load(urlImg + eventoSocialResponse.getFoto()).into(imagen);


            descripcion.setText(usernamedata);




        }

    }
}