package com.kbzbank.payment.sdk.callback;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.octoverse.payment.kbztesting.R;
import com.octoverse.payment.octoversesdk.OctoversePay;

public class CallbackResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callback_result);

        Intent intent = getIntent();
        int result = intent.getIntExtra(OctoversePay.EXTRA_RESULT, 0);
        if (result == OctoversePay.COMPLETED) {
            Log.d("KBZPay", "pay success!");
        } else {
            String failMsg = intent.getStringExtra(OctoversePay.EXTRA_FAIL_MSG);
            Log.d("KBZPay", "pay fail, fail reason = " + failMsg);
        }
    }
}