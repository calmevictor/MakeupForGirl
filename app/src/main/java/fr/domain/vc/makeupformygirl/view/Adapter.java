package fr.domain.vc.makeupformygirl.view;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import fr.domain.vc.makeupformygirl.R;
import fr.domain.vc.makeupformygirl.model.MakeUp;

public class Adapter  extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<MakeUp> values;
    private MainActivity mainActivity;
    private int position;

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView img;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            img = (ImageView)v.findViewById((R.id.icon));
        }
    }

    public void add(int position, MakeUp item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }
    private static final String SelectedMakeUp = "selected_MakeUp";
    public void infoDisplay(int position){
        Log.d("position", String.valueOf(position));
        // Create an Intent to start the second activity
        Intent infoIntent = new Intent(mainActivity, SecondActivity.class);
        final MakeUp selectedMakeUp = values.get(position);
        ArrayList<String> MakeUp= new ArrayList<>() ;
        MakeUp.add(selectedMakeUp.getBrand());
        MakeUp.add(selectedMakeUp.getName());


        /*MakeUp.add(selectedMakeUp.getBrand());
        MakeUp.add(selectedMakeUp.getPrice_sign());
        MakeUp.add(selectedMakeUp.getCurrency());
        MakeUp.add(selectedMakeUp.getCategory());*/
        infoIntent.putStringArrayListExtra(SelectedMakeUp,MakeUp);
// Start the new activity.
        mainActivity.startActivity(infoIntent);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public Adapter(List<MakeUp> values, MainActivity mainActivity) {
        this.values = values;
        this.mainActivity = mainActivity;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        this.position = position;
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final MakeUp selectedMakeUp = values.get(position);
        holder.txtHeader.setText(selectedMakeUp.getName());

        holder.txtFooter.setText("Marque : " + selectedMakeUp.getBrand());
        Log.d("URL", String.valueOf(position));
        Glide.with(holder.itemView).load(selectedMakeUp.getImage_link()).into(holder.img);
        //Picasso.get().load(selectedMakeUp.getImage_link()).into(image);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                infoDisplay(position);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    public int getItemCount() {
        return values.size();
    }


}
