package fr.epf.gestionclient;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fr.epf.gestionclient.model.Client;

/**
 * Created by stephaneguichard on 01/03/2018.
 */

public class ClientAdapter extends ArrayAdapter<Client> {

    public ClientAdapter(@NonNull Context context, @NonNull List<Client> objects){
        super(context,0,objects);

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (view == null) {
            LayoutInflater inflater =
                    (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.adapter_client_view, parent, false);
        }
        Client client = getItem(position);
        String lastname = client.getLastname();
        String firstname = client.getFirstname();
        Client.Gender gender = client.getGender();
        ImageView picture = (ImageView)view.findViewById(R.id.client_picture_imageview);
        TextView clientName = (TextView)view.findViewById(R.id.client_name_textview);
        if(gender == Client.Gender.MAN){
            picture.setBackgroundResource(R.drawable.boy);
        } else{
            picture.setBackgroundResource(R.drawable.girl);
        }
        clientName.setText(firstname + " " + lastname);


        return view;
    }



}
