package com.tsc_barcode_print;

import android.os.Bundle;

import com.example.tscdll.TSCActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    TSCActivity TscDll = new TSCActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                printNow();
            }
        });
    }

    private void printNow() {
        TscDll.openport("00:19:0E:A3:79:DD");
        TscDll.downloadpcx("UL.PCX");
        TscDll.downloadbmp("Triangle.bmp");
        TscDll.downloadttf("ARIAL.TTF");
        TscDll.setup(30, 30, 4, 4, 0, 0, 0);
        TscDll.clearbuffer();
        TscDll.sendcommand("SET TEAR ON\n");
        TscDll.sendcommand("SET COUNTER @1 1\n");
        TscDll.sendcommand("@1 = \"0001\"\n");
        TscDll.sendcommand("TEXT 100,300,\"3\",0,1,1,@1\n");
        TscDll.sendcommand("PUTPCX 100,300,\"UL.PCX\"\n");
        TscDll.sendcommand("PUTBMP 100,520,\"Triangle.bmp\"\n");
        TscDll.sendcommand("TEXT 100,760,\"ARIAL.TTF\",0,15,15,\"THIS IS ARIAL FONT\"\n");
       // TscDll.sendcommand("QRCODE 50,50,H,4,A,0,M2,S7,\"123TSCtest\"\n");
        //TscDll.barcode(100, 100, "128", 100, 1, 0, 3, 3, "123456789");
        TscDll.printerfont(100,40, "0", 0, 14, 14, "Aher");
        TscDll.qrcode(15,90,"H","4","A","0","M2","S7","N123");
        TscDll.printerfont(20,200, "0", 0, 12, 12, "Aher");
        String status = TscDll.status();
        System.out.println("Status : "+status);
        TscDll.printlabel(1, 1);
        TscDll.sendfile("zpl.txt");
        TscDll.closeport();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
