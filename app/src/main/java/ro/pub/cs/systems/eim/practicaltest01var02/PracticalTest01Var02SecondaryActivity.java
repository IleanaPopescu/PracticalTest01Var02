package ro.pub.cs.systems.eim.practicaltest01var02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var02SecondaryActivity extends AppCompatActivity {


    private EditText rez = null;
    private Button corect = null;
    private Button incorect = null;


    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.buttonc:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.buttoni:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_secondary);

        rez = (EditText)findViewById(R.id.editTexts);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("rezultat")) {
            int rezultat = intent.getIntExtra("rezultat", -1);
            rez.setText(String.valueOf(rezultat));
        }

        corect = (Button)findViewById(R.id.buttonc);
        corect.setOnClickListener(buttonClickListener);
        incorect = (Button)findViewById(R.id.buttoni);
        incorect.setOnClickListener(buttonClickListener);
    }
}
