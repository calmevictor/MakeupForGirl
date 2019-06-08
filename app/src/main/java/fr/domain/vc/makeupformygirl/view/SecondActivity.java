package fr.domain.vc.makeupformygirl.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import fr.domain.vc.makeupformygirl.R;
import fr.domain.vc.makeupformygirl.model.MakeUp;

public class SecondActivity extends AppCompatActivity {

    private static final String selection = "selection_label";

    private TextView brand;
    private TextView name;
    private TextView price;
    private TextView price_sign;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        MakeUp mu = (MakeUp) getIntent().getSerializableExtra("MakeUp");

        description = findViewById(R.id.desc);
        brand = findViewById(R.id.brand);
        name = findViewById(R.id.titre);
        price = findViewById(R.id.prix);
        price_sign = findViewById(R.id.prix_b);
        ImageView image_link = findViewById(R.id.imageView);
       Picasso.get().load(mu.getImage_link()).into(image_link);

        description.setText(mu.getDescription());
        brand.setText(mu.getBrand());
        name.setText(mu.getName());
        price.setText(mu.getPrice());
        price_sign.setText(mu.getPrice_sign());

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
