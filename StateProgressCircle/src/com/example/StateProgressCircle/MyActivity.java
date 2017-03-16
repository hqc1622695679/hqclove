package com.example.StateProgressCircle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MyActivity extends Activity {

    private StateCircleProgress stateCircleProgress;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        stateCircleProgress = (StateCircleProgress) findViewById(R.id.state_progress);
    }

    public void onclick(View v) {
        switch (v.getId()) {

            case R.id.start:
                stateCircleProgress.start();
                break;
            case R.id.stop:
                stateCircleProgress.stop();
                break;
            case R.id.showok:
                stateCircleProgress.showSucess();
                break;
            case R.id.showerror:
                stateCircleProgress.showError();
                break;
        }

    }
}
