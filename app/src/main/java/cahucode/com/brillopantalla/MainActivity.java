package cahucode.com.brillopantalla;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.WindowManager;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    SeekBar skBrillo;
    TextView txtbrillo;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;
        txtbrillo = findViewById(R.id.txtporcentaje);
        radioGroup = findViewById(R.id.opcionesBrillo);
        skBrillo = findViewById(R.id.seekbar);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                WindowManager.LayoutParams layout = getWindow().getAttributes();
                switch (checkedId) {
                    case R.id.radio1:
                        layout.screenBrightness = 0.1F;
                        getWindow().setAttributes(layout);
                        break;
                    case R.id.radio2:
                        layout.screenBrightness = 0.2F;
                        getWindow().setAttributes(layout);
                        break;
                    case R.id.radio3:
                        layout.screenBrightness = 0.3F;
                        getWindow().setAttributes(layout);
                        break;
                    case R.id.radio4:
                        layout.screenBrightness = 0.4F;
                        getWindow().setAttributes(layout);
                        break;
                    case R.id.radio5:
                        layout.screenBrightness = 0.5F;
                        getWindow().setAttributes(layout);
                        break;
                    case R.id.radio6:
                        layout.screenBrightness = 0.6F;
                        getWindow().setAttributes(layout);
                        break;
                    case R.id.radio7:
                        layout.screenBrightness = 0.7F;
                        getWindow().setAttributes(layout);
                        break;
                    case R.id.radio8:
                        layout.screenBrightness = 0.8F;
                        getWindow().setAttributes(layout);
                        break;
                    case R.id.radio9:
                        layout.screenBrightness = 0.9F;
                        getWindow().setAttributes(layout);
                        break;
                    case R.id.radio10:
                        layout.screenBrightness = 1F;
                        getWindow().setAttributes(layout);
                        break;
                    default:
                        break;
                }
            }
        });

        // brightness = Settings.System.getInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, 0);
        skBrillo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (Settings.System.canWrite(context)) {
                        txtbrillo.setText(progress + " %");
                        Settings.System.putInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, progress);
                    } else {
                        Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                        intent.setData(Uri.parse("package:" + context.getPackageName()));
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}