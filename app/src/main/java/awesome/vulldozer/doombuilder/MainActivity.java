package awesome.vulldozer.doombuilder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainActivity extends AppCompatActivity
{
    TextView infoText;
    Spinner pwad_iwad;
    Spinner mapslot;
    EditText mapname;
    final int EXTERNAL_STORAGE_PERMISSION_CODE = 23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        infoText = findViewById(R.id.infoText);
        pwad_iwad = findViewById(R.id.pwad_iwad);
        mapslot = findViewById(R.id.mapslot);
        mapname = findViewById(R.id.mapname);
    }

    public void saverButtonClicked(View view)
    {
        Map map = new Map();
        map.createMap(pwad_iwad.getSelectedItem().toString(),mapslot.getSelectedItem().toString()); // Create map from spinners
        //region Stuff you shouldn't touch
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},EXTERNAL_STORAGE_PERMISSION_CODE);
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        //endregion
        File file = new File(folder, mapname.getText().toString() + ".wad");
        writeData(file, map.toByteArray());
    }

    private void writeData(File file, byte[] data) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(data);
            Toast.makeText(this, "File has been saved to location: " + file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}