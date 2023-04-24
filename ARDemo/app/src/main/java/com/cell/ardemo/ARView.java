package com.cell.ardemo;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.phantomsxr.armodplugin.ARMODEventListener;
import com.phantomsxr.armodplugin.AndroidCallback;
import com.phantomsxr.armodplugin.BaseARMODActivity;
import com.phantomsxr.armodplugin.Utils;

public class ARView extends BaseARMODActivity implements ARMODEventListener {
     ProgressDialog progressdialog;

    @Override
    public void onCreateUI() {
        Utils.getInstance().addARMODEventListener(this);
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
                Log.i("Fetch project by Image","Doing");
                fetchProjectByImage();
                break;
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Utils.getInstance().removeARMODEventListener(this);
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

    @Override
    public void onMessageReceived(String data) {

    }

    @Override
    public void onDeviceNotSupport() {
        alertConfirmationView("Not Support", "Your device is not support AR");
    }

    @Override
    public void onAddLoadingOverlay() {
        if(progressdialog==null)
            progressdialog = new ProgressDialog(ARView.this);

        progressdialog.setMessage("Please Wait....");
        progressdialog.setCancelable(false);
        progressdialog.show();

    }

    @Override
    public void onUpdateLoadingProgress(float progress) {
        System.out.println(progress);
    }

    @Override
    public void onRemoveLoadingOverlay() {
        progressdialog.dismiss();
    }

    @Override
    public void onThrowException(String errorMsg, int errorCode) {
        Log.e("Error",errorMsg);
        alertConfirmationView("ERROR!",errorMsg);
        if(errorCode == 5){
            Log.i("","Paused recognized");
        }
    }

    @Override
    public void onNeedInstallARCoreService() {
        alertConfirmationView("Installing","Your device support AR,But you need install the AR Service");
    }

    @Override
    public void onSdkInitialized() {
        Log.v("AR MOD","AR Algorithm Initialized");
    }

    @Override
    public void onOpenBuiltInBrowser(String url) {
        Log.i("Open URL",url);
        unloadAndHideARMOD();
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }

    @Override
    public void onRecognitionStart() {
        Log.i("AR MOD","On Recognized");
    }

    @Override
    public void onRecognitionComplete() {
        Log.i("AR MOD","Start Recognized");
    }

    @Override
    public void onTryAcquireInformation(String opTag, AndroidCallback androidCallback) {
        Log.i("AR MOD",opTag);
        if(androidCallback!=null)
            androidCallback.TryAcquireInformationCallback(opTag);
    }

    @Override
    public void onPackageSizeMoreThanPresetSize(String currentSize, String presetSize) {

    }

    @Override
    public void onARMODExit() {
        Log.i("AR MOD","On AR MOD Exit");
    }

    @Override
    public void onARMODLaunch() {
        Log.i("AR MOD","On AR MOD Launch");
    }
}
