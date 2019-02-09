package ca.ulaval.ima.tp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UlavalActivity extends AppCompatActivity implements View.OnClickListener {

    private Button Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulaval);

        Button = (Button) findViewById(R.id.btn_close);
        Button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
