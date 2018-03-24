package fr.epf.gestionclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import fr.epf.gestionclient.model.Client;

/**
 * Created by stephaneguichard on 01/03/2018.
 */

public class ListClientsFragment extends ListFragment{

    public static final String ID_CLIENT = "idclient";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<Client> clients = Client.getClients();
        ClientAdapter adapter = new ClientAdapter(getActivity(), clients);
        setListAdapter(adapter);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(getActivity(), DetailsClientFragment.class);
        intent.putExtra(ID_CLIENT, position);
        startActivity(intent);

    }
}
