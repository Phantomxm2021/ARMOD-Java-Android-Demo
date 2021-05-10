package com.cell.ardemo;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.phantoms.armodapi.android.AbstractARMODActivity;


public class ARView extends AbstractARMODActivity {
    ProgressDialog progressdialog = null;

    @Override
    public void onCreateUI() {
        initARMOD(getResources().getString(R.string.config), MainActivity.class);
        LayoutInflater tmp_Inflater = getLayoutInflater();
        View tmp_ARView = tmp_Inflater.inflate(R.layout.arview_main, null);
        getARMODFrameLayout().addView(tmp_ARView);

        String tmp_ActionType = getIntent().getStringExtra("EXTRA_ACTION_TYPE");
        switch (tmp_ActionType){
            case "FetchProjectById":
                String tmp_ProjectId = getIntent().getStringExtra("EXTRA_PROJECT_ID");
                fetchProject(tmp_ProjectId);
                break;
            case "FetchProjectByImage":
                Log.i("Fetch projecet by Image","Doing");
                fetchProjectByImage();
                break;
        }
    }

    @Override
    public void deviceNotSupport() {
       // alertConfirmationView("Not Support", "Your device is not support AR");
    }

    @Override
    public void removeLoadingOverlay() {
        progressdialog.dismiss();
    }

    @Override
    public void updateLoadingProgress(float _progressValue) {
        Log.i("Download Assets:", String.valueOf(_progressValue));
    }

    @Override
    public void addLoadingOverlay() {
        progressdialog = new ProgressDialog(this);
        progressdialog.setMessage("Please Wait....");
        progressdialog.setCancelable(false);
        progressdialog.show();
    }


    @Override
    public void throwException(String _error,int _errorCode){
        Log.e("Error",_error);
        alertConfirmationView("ERROR!",_error);
        if(_errorCode == 5){
            Log.i("","Paused recognized");
        }
    }

    @Override
    public void needInstallARCoreService() {
        alertConfirmationView("Installing","Your device support AR,But you need install the AR Service");
    }

    @Override
    public void openBuiltInBrowser(String _url) {
        Log.i("Open URL",_url);
        unloadAndHideARMOD();
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(_url));
        startActivity(browserIntent);
    }

    @Override
    public void sdkInitialized() {
        Log.v("","AR Algorithm Initialized");

    }

    @Override
    public void  recognitionComplete() {
        Log.i("","On Recognized");
    }

    @Override
    public void recognitionStart() {
        Log.i("","start Recognized");
    }


    @Override
    public String tryAcquireInformation(String _opTag) {
        Log.i("",_opTag);
        return "This is from Native code";
    }

    public void alertConfirmationView(String _title, String _message) {
        new AlertDialog.Builder(this)
                .setTitle(_title)
                .setMessage(_message)
                .setCancelable(false)
                .setNegativeButton(R.string.no, (dialog, which) -> {
                    unloadAndHideARMOD();
                })
                .show();
    }


    public void CloseARView(View _v) {
        unloadAndHideARMOD();
    }
}
