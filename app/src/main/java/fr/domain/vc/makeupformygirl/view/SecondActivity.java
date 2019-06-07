package fr.domain.vc.makeupformygirl.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

import fr.domain.vc.makeupformygirl.R;

public class SecondActivity extends AppCompatActivity {

    private static final String selection = "selection_label";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        showDescription();
    }

    public void showDescription() {

        // Get the text view where the description is displayed
        TextView descriptionView = findViewById(R.id.descritionLabel);
        // Get the text view where the title is displayed
        TextView titleView = findViewById(R.id.titleLabel);
        TextView dateView = findViewById(R.id.dateLabel);
        TextView directorView = findViewById(R.id.directorLabel);
        TextView producerView = findViewById(R.id.producerLabel);
        TextView scoreView = findViewById(R.id.scoreLabel);


        //String makeUp = getIntent().getStringExtra(selection);
        ArrayList<String> makeUp = getIntent().getStringArrayListExtra(selection);

        titleView.setText(makeUp.get(0));
        descriptionView.setText(makeUp.get(1));
        dateView.setText(makeUp.get(2));
        directorView.setText("Director: "+makeUp.get(3));
        producerView.setText("Producer: "+makeUp.get(4));
        scoreView.setText(makeUp.get(5)+"/100");
    }
}
