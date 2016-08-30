package mitu.com.recyclerviewtesting;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by mitu on 8/30/16.
 */
public class RecyclerViewAdapterFirstWay extends RecyclerView.Adapter<RecyclerViewAdapterFirstWay.CustomViewHolder> {

    private List<String> mDataSet;
    private Context mContext;
    public RecyclerViewAdapterFirstWay(Context context, List<String>mDataSet) {
        this.mDataSet = mDataSet;
        mContext  = context;

    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        private TextView mNameTextView;

        public CustomViewHolder(View view){
            super(view);
            mNameTextView = (TextView) view.findViewById(R.id.name_text_view);
        }


    }
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout_item,parent,false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {
        holder.mNameTextView.setText(mDataSet.get(position));
        holder.mNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,mDataSet.get(position),Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
