package ca.ulaval.ima.tp1;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final String UrlToLoad = "http://danstonchat.com/";
    public Button ButtonOne;
    public Button ButtonTwo;
    public Button ButtonThree;
    public Button ButtonFor;
    public Profil profil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonOne = (Button) findViewById(R.id.btn_1);
        ButtonOne.setOnClickListener(this);

        ButtonTwo = (Button) findViewById(R.id.btn_2);
        ButtonTwo.setOnClickListener(this);

        ButtonThree = (Button) findViewById(R.id.btn_3);
        ButtonThree.setOnClickListener(this);

        ButtonFor = (Button) findViewById(R.id.btn_4);
        ButtonFor.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                LayoutInflater li = LayoutInflater.from(this);
                View promptsView = li.inflate(R.layout.input, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = (EditText) promptsView.findViewById(R.id.dialog_input);

                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("GO", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                String input = userInput.getText().toString();
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(input));
                                startActivity(browserIntent);
                            }
                        })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                break;
            case R.id.btn_2:
                Intent WebViewActivity = new Intent(MainActivity.this, mWebView.class);
                WebViewActivity.putExtra("url", UrlToLoad);
                startActivity(WebViewActivity);
                break;
            case R.id.btn_3:
                Intent i = new Intent(this, UlavalActivity.class);
                startActivity(i);
                break;
            case R.id.btn_4:
                Intent ii = new Intent(this, ProfilActivity.class);
                profil = new Profil("Charpentier", "Nicolas", new Date("02/10/1996"), "NDCHA");
                ii.putExtra("profil", profil);
                startActivity(ii);
                break;
        }
    }
}
