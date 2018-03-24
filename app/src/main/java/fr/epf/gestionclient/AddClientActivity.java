package fr.epf.gestionclient;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import fr.epf.gestionclient.model.Client;

public class AddClientActivity extends AppCompatActivity {

    String name;
    String surname;
    int age;
    String sex = "man";
    String mail;
    String level;
    Boolean active = false;
    Client.Gender gender = null;
    @BindView(R.id.varage)
    TextView var_age;
    @BindView(R.id.name)
    EditText var_name;
    @BindView(R.id.surname)
    EditText var_surname;
    @BindView(R.id.email)
    EditText var_email;
    private Calendar birthDate;

    private final static SimpleDateFormat dateFormat =
            new SimpleDateFormat("dd/MM/YYYY");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        birthDate = Calendar.getInstance();
        int year = birthDate.get(Calendar.YEAR);
        int month = birthDate.get(Calendar.MONTH);
        int day = birthDate.get(Calendar.DAY_OF_MONTH);

        SeekBar simpleSeekBar = findViewById(R.id.seekage);
        simpleSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int valeur;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean b) {
                valeur = seekBar.getProgress();
                Log.v("debug", "" + valeur);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                TextView t = findViewById(R.id.varage);
                t.setText("" + valeur);

            }
        });
        Spinner simpleSpinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.levels, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        simpleSpinner.setAdapter(adapter);
        simpleSpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                level = parent.getItemAtPosition(pos).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });


        ToggleButton ActiveBt = findViewById(R.id.active);
        ActiveBt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                active = isChecked;
            }
        });

        RadioGroup radioGroup=(RadioGroup)findViewById(R.id.radioGRP);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioGRP =(RadioButton)findViewById(i);
                if (radioGRP.getId()==R.id.homme){
                    gender = Client.Gender.MAN;
                }
                else if (radioGRP.getId()==R.id.femme) {
                    gender = Client.Gender.WOMAN;
                }

            }
        });


    }

    @OnClick(R.id.add_bt)
    public void onClick(View v) {
        age = Integer.parseInt(var_age.getText().toString());
        name = var_name.getText().toString();
        surname = var_surname.getText().toString();
        mail = var_email.getText().toString();

        Log.v("Debug", name + "  " + surname + "  " + mail);
        TextView display = findViewById(R.id.display);
        if (name.equals("Prenom") || surname.equals("Nom") || mail.equals("Email")) {
            String affiche = "Erreur : veuillez remplir tout les champs ! ";
            display.setText(affiche);

        } else {
            Log.v("[User]", "Name :" + name + "// Surname: " + surname + "// Email: " + mail + "// Age: " + age + " Sex: " + sex + " Level: " + level + " Active " + active);
            String affiche = "[Name] :" + name + " // [Surname] : " + surname + "\n// [Email] : " + mail + "\n// [Age] : " + age + "// [Sex] : " + sex + "//\n [Level] : " + level + "// [Active] : " + active;
            display.setText(affiche);
        }
        Client client = new Client(name, surname, mail, 0, gender, level, active);
        Client.getClients().add(client);
        finish();

    }

    @OnClick(R.id.date)
    public void selectDate(final Button button) {

        int year = birthDate.get(Calendar.YEAR);
        int month = birthDate.get(Calendar.MONTH);
        int day = birthDate.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog.OnDateSetListener listener =
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        birthDate.set(Calendar.YEAR, i);
                        birthDate.set(Calendar.MONTH, i1);
                        birthDate.set(Calendar.DAY_OF_MONTH, i2);
                        Date birthDateTime = birthDate.getTime();
                        button.setText(dateFormat.format(birthDateTime));
                    }
                };

        DatePickerDialog dialog =
                new DatePickerDialog(this, listener, year, month, day);
        dialog.show();


    }


}

