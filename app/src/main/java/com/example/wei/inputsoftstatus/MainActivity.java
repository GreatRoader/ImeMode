package com.example.wei.inputsoftstatus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
                        | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        setContentView(R.layout.activity_main);
        final TextView imeIndicator = findViewById(R.id.imeIndicator);
        InputSoftRelativeLayout mRootLayout =  findViewById(R.id.rootLayout);

        mRootLayout.setSoftKeyboardListener(new InputSoftRelativeLayout.OnSoftKeyboardListener() {
            @Override
            public void onSoftKeyboardChange(boolean show) {
                String content = getString(R.string.app_name)+": "+(show? getString(R.string.show) : getString(R.string.hidden));
                imeIndicator.setText(content);
            }
        });
    }
}
