package com.example.dhritiman.yugyugjiyo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

/**
 * Created by Dhritiman on 3/17/2017.
 */

public class singleitem_recycler_adapter extends RecyclerView.Adapter<singleitem_recycler_adapter.MyViewHolder> {
    private List<DataModel> feedsList;
    private Context context;
    private LayoutInflater inflater;

    public singleitem_recycler_adapter(Context context, List<DataModel> feedsList) {

        this.context = context;
        this.feedsList = feedsList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View rootView = inflater.inflate(R.layout.singleitem_recycleview, parent, false);
        return new MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final DataModel feeds = feedsList.get(position);
        //Pass the values of feeds object to Views
        holder.id.setText(feeds.getId());
        holder.name.setText(feeds.getName());
        // holder.logo.setImageUrl(feeds.getLogo(), NetworkController.getInstance(context).getImageLoader());
        holder.bannerimage.setImageUrl(feeds.getBanner_image(), NetworkController.getInstance(context).getImageLoader());
        holder.hospname.setText(feeds.getHospname());
        holder.price.setText("Rs."+feeds.getPrice());
        // holder.ratingbar.setProgress(feeds.getRating());
        // holder.linearlayout.setOnClickListener(new View.OnClickListener() {
        //@Override
        //  public void onClick(View v) {
        //Intent intent = null;
        // Toast.makeText(context,"You clicked "+feeds.getFeedName(),Toast.LENGTH_SHORT).show();
        // switch(feeds.getFeedName()){
        // case "RecyclerView":
        //  intent =  new Intent(context, FirstActivity.class);
        // break;
        // case "Hello World":
        // intent =  new Intent(context, HelloActivity.class);
        //  break;


        //  }
        // context.startActivity(intent);
        //}
        //});
    }

    @Override
    public int getItemCount() {
        return feedsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView id,name,hospname,price;
        private NetworkImageView logo,bannerimage;
        //  private ProgressBar ratingbar;
        private LinearLayout linearlayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.id);
            name = (TextView) itemView.findViewById(R.id.name);
            //logo = (NetworkImageView) itemView.findViewById(R.id.logo);
            bannerimage = (NetworkImageView) itemView.findViewById(R.id.banner_image);
            hospname = (TextView) itemView.findViewById(R.id.hospname);
            price= (TextView) itemView.findViewById(R.id.price);
            // Volley's NetworkImageView which will load Image from URL

            //  ratingbar = (ProgressBar) itemView.findViewById(R.id.ratingbar_view);
            linearlayout=(LinearLayout)itemView.findViewById(R.id.linearlayout);
            // ratingbar.setOnClickListener(new View.OnClickListener() {
            //  @Override
            //  public void onClick(View view) {

            //   Toast.makeText(context, "Rated By User : " + feedsList.get(getAdapterPosition()).getRating(), Toast.LENGTH_SHORT).show();


            // }
            //});

        }
    }
}
