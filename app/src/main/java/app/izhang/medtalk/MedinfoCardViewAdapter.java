package app.izhang.medtalk;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.*;
import java.util.ArrayList;

public class MedinfoCardViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mInflater;
    private ArrayList<MedInfo> items;
    private Homeactivity mActivity;

    public MedinfoCardViewAdapter(ArrayList<MedInfo> data, Homeactivity activity) {
        this.items = data;
        this.mActivity = activity;
        this.mInflater = LayoutInflater.from(mActivity.getApplicationContext());
    }

    public void addItem(MedInfo result) {
        items.add(result);
    }

    public void setInflater(LayoutInflater layoutInflater){
        this.mInflater =layoutInflater;
    }

    public void replaceItems(ArrayList<MedInfo> newItems) {
        this.items.clear();
        for(MedInfo item: newItems)
            this.items.add(item);
    }

    public void insertItem(MedInfo item) {
        items.add(0, item);
    }

    public void clearItems(){
        items.clear();
    }

    public void AddResults(ArrayList<MedInfo> result) {
        items.addAll(result);
    }

    public MedInfo getItemsAt(int position){
        return  items.get(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MedInfo model = items.get(position);
        // TODO: 5/14/17
//        MessageViewHolder messageViewHolder = (MessageViewHolder) holder;
//        messageViewHolder.imageViewIcon.setBackgroundResource(model.getImage());
//        messageViewHolder.textViewName.setText(model.getName());
//        messageViewHolder.textViewStatus.setText(model.getStatus());
//        messageViewHolder.textViewMobile.setText(model.getMobile());
    }

    @Override
    public int getItemViewType(int position) {
        return  super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootCategoryView = mInflater.inflate(R.layout.card_view, parent, false);
        return new MessageViewHolder(rootCategoryView, this);
    }

    private class MessageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageViewIcon;
        private TextView textViewName;
        private TextView textViewStatus;
        private TextView textViewMobile;
        private CardView cardView;

        private MessageViewHolder(View itemView, MedinfoCardViewAdapter adapter) {
            super(itemView);
            // TODO: 5/14/17
//            imageViewIcon = (ImageView) itemView.findViewById(R.id.imageViewIcon);
//            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
//            textViewStatus = (TextView) itemView.findViewById(R.id.textViewStatus);
//            textViewMobile = (TextView) itemView.findViewById(R.id.textViewMobile);
//            cardView = (CardView) itemView.findViewById(R.id.cardView);
//
//            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            final int pos = getAdapterPosition();
            if (pos >= 0) {
                Toast.makeText(mActivity.getApplicationContext(), "Selected Item Position "+pos, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
