package app.izhang.medtalk.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

import app.izhang.medtalk.DetailMedView;
import app.izhang.medtalk.R;

public class DetailInfoCardViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mInflater;
    private ArrayList<Map> items;
    private DetailMedView mActivity;

    public DetailInfoCardViewAdapter(ArrayList<Map> data, DetailMedView activity) {
        this.items = data;
        this.mActivity = activity;
        this.mInflater = LayoutInflater.from(mActivity.getApplicationContext());
    }

    public void addItem(Map result) {
        items.add(result);
    }

    public void setInflater(LayoutInflater layoutInflater){
        this.mInflater =layoutInflater;
    }

    public void replaceItems(ArrayList<Map> newItems) {
        this.items.clear();
        for(Map item: newItems)
            this.items.add(item);
    }

    public void insertItem(Map item) {
        items.add(0, item);
    }

    public void clearItems(){
        items.clear();
    }

    public void AddResults(ArrayList<Map> result) {
        items.addAll(result);
    }

    public Map getItemsAt(int position){
        return  items.get(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Map <String, String> model = items.get(position);

        // TODO: 5/14/17
        if(model != null) {
            int currentTextView = 1;
            MessageViewHolder messageViewHolder = (MessageViewHolder) holder;
            ArrayList<TextView> textViews = ((MessageViewHolder) holder).getTextViews();
            for (Map.Entry<String, String> entry : model.entrySet()) {
                Log.v("Entry", entry.getKey() + " " + entry.getValue());
                if (entry.getKey().equals("title")) {
                    messageViewHolder.textTitle.setText(entry.getValue());
                } else {
                    switch(currentTextView){
                        case 1:
                            if(entry.getKey().equals("-")) {
                                messageViewHolder.textView1.setText(entry.getKey() + " " + entry.getValue());
                            }else{
                                messageViewHolder.textView1.setText(entry.getKey() + ": " + entry.getValue());
                            }
                            messageViewHolder.textView1.setVisibility(View.VISIBLE);
                            break;
                        case 2:
                            if(entry.getKey().equals("-")) {
                                messageViewHolder.textView2.setText(entry.getKey() + " " + entry.getValue());
                            }else{
                                messageViewHolder.textView2.setText(entry.getKey() + ": " + entry.getValue());
                            }
                            messageViewHolder.textView2.setVisibility(View.VISIBLE);
                            break;
                        case 3:
                            if(entry.getKey().equals("-")) {
                                messageViewHolder.textView3.setText(entry.getKey() + " " + entry.getValue());
                            }else{
                                messageViewHolder.textView3.setText(entry.getKey() + ": " + entry.getValue());
                            }
                            messageViewHolder.textView3.setVisibility(View.VISIBLE);
                            break;
                        case 4:
                            if(entry.getKey().equals("-")) {
                                messageViewHolder.textView4.setText(entry.getKey() + " " + entry.getValue());
                            }else{
                                messageViewHolder.textView4.setText(entry.getKey() + ": " + entry.getValue());
                            }
                            messageViewHolder.textView4.setVisibility(View.VISIBLE);
                            break;
                        case 5:
                            if(entry.getKey().equals("-")) {
                                messageViewHolder.textView5.setText(entry.getKey() + " " + entry.getValue());
                            }else{
                                messageViewHolder.textView5.setText(entry.getKey() + ": " + entry.getValue());
                            }
                            messageViewHolder.textView5.setVisibility(View.VISIBLE);
                            break;
                        case 6:
                            if(entry.getKey().equals("-")) {
                                messageViewHolder.textView6.setText(entry.getKey() + " " + entry.getValue());
                            }else{
                                messageViewHolder.textView6.setText(entry.getKey() + ": " + entry.getValue());
                            }
                            messageViewHolder.textView6.setVisibility(View.VISIBLE);
                            break;
                        case 7:
                            if(entry.getKey().equals("-")) {
                                messageViewHolder.textView7.setText(entry.getKey() + " " + entry.getValue());
                            }else{
                                messageViewHolder.textView7.setText(entry.getKey() + ": " + entry.getValue());
                            }
                            messageViewHolder.textView7.setVisibility(View.VISIBLE);
                            break;
                    }

                    currentTextView++;

                }
            }
        }


    }

    @Override
    public int getItemViewType(int position) {
        return  super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootCategoryView = mInflater.inflate(R.layout.detail_card_view, parent, false);
        return new MessageViewHolder(rootCategoryView, this);
    }

    private class MessageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textTitle;
        private TextView textView1;
        private TextView textView2;
        private TextView textView3;
        private TextView textView4;
        private TextView textView5;
        private TextView textView6;
        private TextView textView7;

        private ArrayList<TextView> textViews;

        private CardView cardView;

        private MessageViewHolder(View itemView, DetailInfoCardViewAdapter adapter) {
            super(itemView);

        }

        @Override
        public void onClick(View v) {
            final int pos = getAdapterPosition();
        }

        private ArrayList getTextViews(){
            return textViews;
        }
    }
}
