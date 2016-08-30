package mitu.com.recyclerviewtesting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    private RecyclerView mRecyclerViewSecondType;
    private RecyclerViewAdapterSecondWay mAdapterSecondType;


    private String[] mDataset = {"python","java","C++","C","pearl","ruby"};
    private String[] mDatasetSecondType = {"Microsoft","Linux","Mac","Xanix"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerViewSecondType = (RecyclerView) findViewById(R.id.my_recycler_view_second_type);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerViewSecondType.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new RecyclerViewAdapterFirstWay(getApplicationContext(),Arrays.asList(mDataset));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setNestedScrollingEnabled(false);


        mAdapterSecondType = new RecyclerViewAdapterSecondWay(getApplicationContext(),Arrays.asList(mDatasetSecondType));
        mRecyclerViewSecondType.setAdapter(mAdapterSecondType);
        mAdapterSecondType.setOnItemClickListener(new RecyclerViewAdapterSecondWay.customInterface() {
            @Override
            public void onItemClick(int position, View v) {
                Toast.makeText(getApplicationContext(),mDatasetSecondType[position],Toast.LENGTH_SHORT).show();

            }
        });
        mRecyclerViewSecondType.setNestedScrollingEnabled(false);




    }
}
