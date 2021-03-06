package app.izhang.medtalk.adapter;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import android.support.v7.widget.*;
import java.util.ArrayList;

import app.izhang.medtalk.view.DetailMedView;
import app.izhang.medtalk.view.FavListFragment;
import app.izhang.medtalk.model.MedInfo;
import app.izhang.medtalk.view.MedListFragment;
import app.izhang.medtalk.R;

public class MedinfoCardViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mInflater;
    private ArrayList<MedInfo> items;
    private Fragment mActivity;

    public MedinfoCardViewAdapter(ArrayList<MedInfo> data, MedListFragment activity) {
        this.items = data;
        this.mActivity = activity;
        this.mInflater = LayoutInflater.from(mActivity.getContext());
    }

    public MedinfoCardViewAdapter(ArrayList<MedInfo> data, FavListFragment activity) {
        this.items = data;
        this.mActivity = activity;
        this.mInflater = LayoutInflater.from(mActivity.getContext());
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
        MessageViewHolder messageViewHolder = (MessageViewHolder) holder;
//        messageViewHolder.imageViewIcon.setBackgroundResource(model.getImage());
//        messageViewHolder.textViewName.setText(model.getName());
//        messageViewHolder.textViewStatus.setText(model.getStatus());
//         messageViewHolder.textViewMobile.setText(model.getMobile());

        messageViewHolder.textTitle.setText(model.getTradename());
        messageViewHolder.textSubTitle.setText(model.getGenericName());

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
        private TextView textTitle;
        private TextView textSubTitle;
        private TextView textViewMobile;
        private CardView cardView;

        private MessageViewHolder(View itemView, MedinfoCardViewAdapter adapter) {
            super(itemView);
            textTitle = (TextView) itemView.findViewById(R.id.tv_tradename);
            textSubTitle = (TextView) itemView.findViewById(R.id.tv_genericname);

            cardView = (CardView) itemView.findViewById(R.id.cardView);

            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            final int pos = getAdapterPosition();
            MedInfo medInfoObj = items.get(pos);
            Intent detailViewIntent = new Intent(mActivity.getContext(), DetailMedView.class);
            detailViewIntent.putExtra("MEDINFO_OBJ", medInfoObj);
            mActivity.startActivity(detailViewIntent);
        }
    }
}
