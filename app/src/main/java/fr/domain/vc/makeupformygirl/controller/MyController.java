package fr.domain.vc.makeupformygirl.controller;

import fr.domain.vc.makeupformygirl.RestApiMakeUp;
import fr.domain.vc.makeupformygirl.model.MakeUp;
import fr.domain.vc.makeupformygirl.view.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyController {
    public MainActivity view;
    private RestApiMakeUp response;

    public MyController(MainActivity view, RestApiMakeUp response) {
        this.view = view;
        this.response = response;
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
        });
    }
}
