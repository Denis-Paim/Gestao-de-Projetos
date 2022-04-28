package denis.paim.easymed;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    int tempoDeEspera = 1000 * 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();


        trocarTela();
    }

    private void trocarTela() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent trocarDeTela = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(trocarDeTela);
                finish();
            }
        },tempoDeEspera);
    }

}
