package android.example.Planner;

import android.content.Intent;
import android.example.Planner.Database.AppDatabase;
import android.example.Planner.Database.Node;
import android.os.Bundle;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import java.util.List;


public class TaskActivity extends GameTemplate {
    private NodeAdapter mAdapter;
    private String name = "temp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int id = getIntent().getIntExtra("NAME", 0);
        Node temp = AppDatabase.getAppDatabase(getApplicationContext()).nodeDAO().findById(id).get(0);
        name = temp.getName();
        super.setParentIdName(id, name);
        setContentView(R.layout.activity_task);

        AppDatabase.buildAppDatabase(getApplicationContext());

        for(Node elem : AppDatabase.getAppDatabase(getApplicationContext()).nodeDAO().getAllNodes()) {
            AppDatabase.getAppDatabase(getApplicationContext()).nodeDAO().deletefrom(elem);
            elem.setExpanded(false);
            AppDatabase.getAppDatabase(getApplicationContext()).nodeDAO().insertinto(elem);
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new NodeAdapter(this, AppDatabase.getAppDatabase(getApplicationContext()).nodeDAO().findByParentId(id), false, false);
        super.setmAdapter(mAdapter);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}

