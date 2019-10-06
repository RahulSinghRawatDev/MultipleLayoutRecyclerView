package com.rahul.multiplelayoutrecyclerview.adapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.rahul.multiplelayoutrecyclerview.R;
import com.rahul.multiplelayoutrecyclerview.model.DataModel;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private DataModel model;

    private final static int TYPE_BANNER = 1;
    private final static int TYPE_VERTICALLIST = 2;
    private final static int TYPE_HORIZONTALLIST = 3;


    public HomeAdapter(Context context, DataModel entityDataResponse) {
        this.context = context;
        this.model = entityDataResponse;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view;
        if (viewType == TYPE_BANNER) {
            view = LayoutInflater.from(context).inflate(R.layout.item_banner, viewGroup, false);
            return new BannerViewHolder(view);
        } else if (viewType == TYPE_VERTICALLIST) {
            view = LayoutInflater.from(context).inflate(R.layout.item_vertical, viewGroup, false);
            return new VerticalViewHolder(view);
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.itemhorizontal, viewGroup, false);
            return new HorizontalViewHolder(view);
        }

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        if (getItemViewType(position) == TYPE_BANNER){
            ((BannerViewHolder) viewHolder).txtData.setText(" Banner "+model.getHomeData().get(position).getTitle()+"  - "+model.getHomeData().get(position).getData().size());
        }else if(getItemViewType(position) == TYPE_VERTICALLIST){
            ((VerticalViewHolder) viewHolder).txtData.setText(" Vertical "+model.getHomeData().get(position).getTitle()+"  - "+model.getHomeData().get(position).getData().size());
        }else {
            ((HorizontalViewHolder) viewHolder).txtData.setText(" Horizontal "+model.getHomeData().get(position).getTitle()+"  - "+model.getHomeData().get(position).getData().size());

        }

    }

    @Override
    public int getItemCount() {
        return model.getHomeData().size();
    }

    @Override
    public int getItemViewType(int position) {
        if (model.getHomeData().get(position).getType().equalsIgnoreCase("banner")) {
            return TYPE_BANNER;
        } else if (model.getHomeData().get(position).getType().equalsIgnoreCase("veticalList")) {
            return TYPE_VERTICALLIST;
        } else {
            return TYPE_HORIZONTALLIST;
        }
    }

    private class BannerViewHolder extends RecyclerView.ViewHolder {
        private TextView txtData;

        BannerViewHolder(View view) {
            super(view);
            txtData = itemView.findViewById(R.id.txtData);
        }
    }


    private class VerticalViewHolder extends RecyclerView.ViewHolder {
        private TextView txtData;
        public VerticalViewHolder(View view) {
            super(view);
            txtData = itemView.findViewById(R.id.txtData);
        }
    }


    private class HorizontalViewHolder extends RecyclerView.ViewHolder {
        private TextView txtData;
        public HorizontalViewHolder(View view) {
            super(view);
            txtData = itemView.findViewById(R.id.txtData);
        }
    }
}
