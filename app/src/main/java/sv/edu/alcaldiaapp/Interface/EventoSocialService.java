package sv.edu.alcaldiaapp.Interface;

import java.util.List;

import sv.edu.alcaldiaapp.Model.EventoSocialResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface EventoSocialService {

    @GET("api")
    Call<List<EventoSocialResponse>> getAllEvents();

}
