package viewdevs.com.ar.x;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class MainActivity extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_main, super.wrapper);
        //setContentView(R.layout.activity_main);
        super.setNombreVentana("Main 1");
    }
}
