package com.rahul.multiplelayoutrecyclerview;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.google.gson.Gson;
import com.rahul.multiplelayoutrecyclerview.Utlis.Utility;
import com.rahul.multiplelayoutrecyclerview.adapter.HomeAdapter;
import com.rahul.multiplelayoutrecyclerview.model.DataModel;
import static androidx.recyclerview.widget.DividerItemDecoration.VERTICAL;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HomeAdapter homeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initAdapter();
    }

    private void initAdapter() {
        String jsonData = Utility.loadJSONFromAsset(this);
        DataModel entityDataResponse = new Gson().fromJson(jsonData, DataModel.class);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        homeAdapter = new HomeAdapter(this,entityDataResponse);
        DividerItemDecoration itemDecor = new DividerItemDecoration(this, VERTICAL);
        recyclerView.addItemDecoration(itemDecor);
        recyclerView.setAdapter(homeAdapter);


    }

    private void initView() {
        recyclerView = findViewById(R.id.rc_view);
    }


}
