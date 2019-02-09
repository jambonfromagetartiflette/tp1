package ca.ulaval.ima.tp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfilActivity extends AppCompatActivity {
    private TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        content = (TextView) findViewById(R.id.profil);
        Profil profil = getIntent().getParcelableExtra("profil");

        content.setText("Prénom: " + profil.getFirst_name()
                + "\nNom: " + profil.getLast_name()
                + "\nDate de naisssance: " + profil.getBirthdate()
                + "\nIDUL: " + profil.getIdul()
        );
    }
}
