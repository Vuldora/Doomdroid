package awesome.vulldozer.doombuilder;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity
{
    TextView infoText;
    Spinner pwad_iwad;
    Spinner mapslot;
    EditText mapname;

    Archive archive;
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

    public void newmapButtonClicked(View view)
    {
        archive = new Archive(pwad_iwad.getSelectedItem().toString());
        archive.addMap(mapslot.getSelectedItem().toString());
    }

    public void saverButtonClicked(View view)
    {
        //region Irrelevant stuff
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},EXTERNAL_STORAGE_PERMISSION_CODE);
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        //endregion
        File file = new File(folder, mapname.getText().toString() + ".wad");
        writeData(file, archive.toByteArray());
    }

    public void createThingButtonClicked(View view)
    {
        EditText et_ypos = findViewById(R.id.ypos);
        EditText et_xpos = findViewById(R.id.xpos);
        EditText et_angle = findViewById(R.id.anglenum);
        EditText et_type = findViewById(R.id.typenum);
        EditText et_flags = findViewById(R.id.flagsnum);
        short th_ypos = Short.parseShort(et_ypos.getText().toString());
        short th_xpos = Short.parseShort(et_xpos.getText().toString());
        short th_angle = Short.parseShort(et_angle.getText().toString());
        short th_type = Short.parseShort(et_type.getText().toString());
        short th_flags = Short.parseShort(et_flags.getText().toString());
        Thing th_thing = new Thing(th_ypos, th_xpos, th_angle, th_type, th_flags);
        archive.getMapList().getMaps()[0].addThing(th_thing);

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