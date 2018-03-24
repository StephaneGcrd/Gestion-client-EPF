package fr.epf.gestionclient;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.epf.gestionclient.model.Client;

public class DetailsClientFragment extends Fragment {

    @BindView(R.id.lastname_textview)
    TextView lastnameTextView;

    public void updateClient(int id){
        Client client = Client.getClients().get(id);
        lastnameTextView.setText(client.getLastname());

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.fragment_details_client, container, true);
        ButterKnife.bind(this,view);
        return view;
    }
}
