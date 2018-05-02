package viewdevs.com.ar.x;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_main2, super.wrapper);

        super.setNombreVentana("Main2");
    }
}
