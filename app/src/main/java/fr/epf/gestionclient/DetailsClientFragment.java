package fr.epf.gestionclient;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.epf.gestionclient.model.Client;

public class DetailsClientFragment extends Fragment {

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.activity_details_client, container, true);
        return view;
    }
}
