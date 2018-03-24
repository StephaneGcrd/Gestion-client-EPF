package fr.epf.gestionclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void OnAddClientClick(View view) {
        Intent intent = new Intent(HomeActivity.this, AddClientActivity.class);
        startActivity(intent);
    }


    public void OnAddListClick(View view) {
        Intent intent = new Intent(HomeActivity.this, ListClientsFragment.class);
        startActivity(intent);
    }
}
