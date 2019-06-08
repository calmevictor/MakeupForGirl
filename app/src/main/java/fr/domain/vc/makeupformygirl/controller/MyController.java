package fr.domain.vc.makeupformygirl.controller;

import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import fr.domain.vc.makeupformygirl.RestApiMakeUp;
import fr.domain.vc.makeupformygirl.model.MakeUp;
import fr.domain.vc.makeupformygirl.view.MainActivity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyController {
    public MainActivity view;
    private RestApiMakeUp response;
    private SharedPreferences sharedPreferences;

    public MyController(MainActivity view, RestApiMakeUp response, SharedPreferences sharedPreferences) {
        this.view = view;
        this.response = response;
        this.sharedPreferences = sharedPreferences;
    }

    public void onCreate() {
        Call<List<MakeUp>> call = response.getMakeUpData();
        call.enqueue(new Callback<List<MakeUp>>() {
            @Override
            public void onResponse(Call<List<MakeUp>> call, Response<List<MakeUp>> response) {
                List<MakeUp> RestApiMakeUp = response.body();
                List<MakeUp> MakeUpList = RestApiMakeUp;
                view.showList(MakeUpList);
            }

            @Override
            public void onFailure(Call<List<MakeUp>> call, Throwable t) {

            }

            private void storeData(List<MakeUp> makeUpList) {
                Gson gson = new Gson();
                String listMU = gson.toJson(makeUpList);
                sharedPreferences
                        .edit()
                        .putString("mu_string", listMU)
                        .apply();
            }

            private List<MakeUp> getDataFromCache() {
                String listMUString = sharedPreferences.getString("mu_string", "");
                if(listMUString != null && !TextUtils.isEmpty(listMUString)){
                    Type listType = new TypeToken<List<MakeUp>>(){}.getType();
                    List<MakeUp> makeUpList = new Gson().fromJson(listMUString, listType);
                    return makeUpList;
                }
                return new ArrayList<>();
            }
        });
    }
}
