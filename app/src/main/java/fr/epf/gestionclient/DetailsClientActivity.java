package fr.epf.gestionclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import fr.epf.gestionclient.model.Client;

public class DetailsClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_client);

        Intent intent = getIntent();

        int idClient = intent.getIntExtra(ListClientsFragment.ID_CLIENT, 0);
        Client client = Client.getClients().get(idClient);

        TextView id_client = (TextView)findViewById(R.id.lastname_textview);


        id_client.setText(client.getLastname());

    }
}
