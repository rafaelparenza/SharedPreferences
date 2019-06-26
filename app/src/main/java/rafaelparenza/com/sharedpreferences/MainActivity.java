package rafaelparenza.com.sharedpreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    public static final String PREFS_NAME = "Preferences";
    EditText etUsuario;
    EditText etSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario = (EditText)findViewById(R.id.etUsuarioi);
        etSenha = (EditText)findViewById(R.id.etSenhai);

        //Restaura as preferencias gravadas
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);//
        etUsuario.setText(settings.getString("PrefUsuario", ""));//Altera o usuario
    }

    protected void onStop(){
        super.onStop();

        //Caso o checkbox esteja marcado gravamos o usuário
        CheckBox chkSalvar = (CheckBox)findViewById(R.id.chkSalvar);
        if (chkSalvar.isChecked()){
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString("PrefUsuario", etUsuario.getText().toString());

            //Confirma a gravação dos dados
            editor.commit();
        }
    }
    public void btnFechar_Click(View v){
        finish(); // fecha aplicativo
    }


}
