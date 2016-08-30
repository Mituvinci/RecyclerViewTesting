package mitu.com.recyclerviewtesting;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mitu on 8/30/16.
 */
public class RecyclerViewAdapterSecondWay extends RecyclerView.Adapter<RecyclerViewAdapterSecondWay.CustomViewHolder> {
    private List<String> mDataSet;
    private static customInterface customInterface;
    private Context mContext;


    public RecyclerViewAdapterSecondWay(Context context, List<String> mDataSet) {
        this.mDataSet = mDataSet;
        mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout_item,parent,false);

        CustomViewHolder customViewHolder = new CustomViewHolder(view);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.mNameTextView.setText(mDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mNameTextView;
        public CustomViewHolder(View itemView) {
            super(itemView);
            mNameTextView = (TextView) itemView.findViewById(R.id.name_text_view);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            customInterface.onItemClick(getAdapterPosition(),v);
        }
    }

    public void setOnItemClickListener(customInterface clickListener){
        this.customInterface = clickListener;
    }

    public interface customInterface{
        void onItemClick(int position, View v);    }
}
