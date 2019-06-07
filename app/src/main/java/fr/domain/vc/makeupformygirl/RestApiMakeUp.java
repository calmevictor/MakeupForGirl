package fr.domain.vc.makeupformygirl;

import java.util.List;

import fr.domain.vc.makeupformygirl.model.MakeUp;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiMakeUp {
    @GET("products.json?product_category=lipstick&product_type=lipstick")
    Call<List<MakeUp>> getMakeUpData();
}
