package com.cell.ardemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputLayout;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:

                ARScan();
                // User chose the "Settings" item, show the app settings UI...
                return true;


            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }


    public void ARLauncher(View _v){
        TextInputLayout textInputLayout = findViewById(R.id.textInputLayout);
        String text = textInputLayout.getEditText().getText().toString();
        Intent intent = new Intent(this, ARView.class);
        intent.putExtra("EXTRA_PROJECT_ID",text);
        intent.putExtra("EXTRA_ACTION_TYPE","FetchProjectById");
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityForResult(intent, 1);
    }

    public void ARScan(){
        Intent intent = new Intent(this, ARView.class);
        intent.putExtra("EXTRA_ACTION_TYPE","FetchProjectByImage");
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityForResult(intent, 1);
    }
}