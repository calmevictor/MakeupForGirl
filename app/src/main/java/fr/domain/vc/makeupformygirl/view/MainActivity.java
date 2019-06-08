package fr.domain.vc.makeupformygirl.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import fr.domain.vc.makeupformygirl.Injection;
import fr.domain.vc.makeupformygirl.R;
import fr.domain.vc.makeupformygirl.controller.MyController;
import fr.domain.vc.makeupformygirl.model.MakeUp;

import java.util.List;

public class MainActivity extends Activity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private MyController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        controller = new MyController(this, Injection.getRestApi(), this.getSharedPreferences("user_prefs", Context.MODE_PRIVATE));
        controller.onCreate();
    }
    public void showList(List<MakeUp> ghibliList) {
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        //Instanciation de layoutManager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // define an adapter
        //Instanciation de mAdapter
        mAdapter = new Adapter(ghibliList,this);
        recyclerView.setAdapter(mAdapter);
    }
}
