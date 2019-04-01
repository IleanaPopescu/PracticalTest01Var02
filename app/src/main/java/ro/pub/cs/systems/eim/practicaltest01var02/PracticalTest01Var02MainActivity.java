package ro.pub.cs.systems.eim.practicaltest01var02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var02MainActivity extends AppCompatActivity {

    private Button plus = null;
    private Button minus = null;
    private Button navigateToSecondaryActivityButton = null;

    private EditText editabil1 = null;
    private EditText editabil2 = null;
    private EditText needitabil = null;


    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.button1:
                    int nr1 = Integer.parseInt(editabil1.getText().toString());
                    int nr2 = Integer.parseInt(editabil2.getText().toString());
                    int sum = nr1 + nr2;
                    needitabil.setText(String.valueOf(sum));
                    break;
                case R.id.button2:
                    int nrm1 = Integer.parseInt(editabil1.getText().toString());
                    int nrm2 = Integer.parseInt(editabil2.getText().toString());
                    int dif = nrm1 - nrm2;
                    needitabil.setText(String.valueOf(dif));
                    break;
                case R.id.button3:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var02SecondaryActivity.class);
                    int rezultat = Integer.parseInt(needitabil.getText().toString());
                    intent.putExtra("rezultat", rezultat);
                    startActivityForResult(intent, 270);
                    break;
            }
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_main);

        plus = (Button)findViewById(R.id.button1);
        minus = (Button)findViewById(R.id.button2);

        editabil1 = (EditText)findViewById(R.id.editText1);
        editabil2 = (EditText)findViewById(R.id.editText2);
        needitabil = (EditText)findViewById(R.id.editText3);

        plus.setOnClickListener(buttonClickListener);
        minus.setOnClickListener(buttonClickListener);

        Toast.makeText(this, "Prima valoare:" + editabil1.getText().toString() +"A doua val:" + editabil2.getText().toString(), Toast.LENGTH_LONG).show();

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("leftCount")) {
                editabil1.setText(savedInstanceState.getString("leftCount"));
            } else {
                editabil1.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("rightCount")) {
                editabil2.setText(savedInstanceState.getString("rightCount"));
            } else {
                editabil2.setText(String.valueOf(0));
            }
        } else {
            editabil1.setText(String.valueOf(0));
            editabil2.setText(String.valueOf(0));
        }

        navigateToSecondaryActivityButton = (Button)findViewById(R.id.button3);
        navigateToSecondaryActivityButton.setOnClickListener(buttonClickListener);

    }


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("editabil1", editabil1.getText().toString());
        savedInstanceState.putString("editabil2", editabil2.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("leftCount")) {
            editabil1.setText(savedInstanceState.getString("leftCount"));
        } else {
            editabil1.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("rightCount")) {
            editabil2.setText(savedInstanceState.getString("rightCount"));
        } else {
            editabil2.setText(String.valueOf(0));
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 270) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }

}
