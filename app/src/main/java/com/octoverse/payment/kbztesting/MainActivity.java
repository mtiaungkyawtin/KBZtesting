package com.octoverse.payment.kbztesting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.octoverse.payment.octoversesdk.OctoversePay;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    //@BindView(R.id.payButton)
    Button btnStartPay, btnCBPay , btnWebPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStartPay = findViewById(R.id.payButton);
        btnCBPay = findViewById(R.id.cbButton);
        btnWebPay = findViewById(R.id.webUrlButton);
        btnStartPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ordInfo = "appid=kpeb32993266db4d628b104a7bce7b7c&merch_code=779001&nonce_str=da59ac08d86a48498726b2fa938b9731&prepay_id=KBZ0079668a9ef38b4200943182a0f8ec305f113537238&sub_appid=kp6c5e4848445d459a8baa4feab434eb&sub_merch_code=77900101&timestamp=1675919106";
                String sign = "C15C096E74D58CA0C0D03A943BCB6B96E0FE2F9C11F2BEA7BBA625E73B36F1ED";
                String signType = "SHA256";
                Log.d("signType=============",signType);
                OctoversePay.invokePayment(MainActivity.this, ordInfo,sign, signType, null,"KBZPAY_APP");
            }
        });

        btnCBPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCBPay(view);
            }
        });

        btnWebPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickWebPay(view);
            }
        });
    }


    private void clickCBPay(View view) {
        String deepLink = "cbuat://pay?keyreference=a02c8323-dcea-49dd-8df2-39ac311fa869";
        Log.d("CB Pay PIN : ", deepLink);
        OctoversePay.invokePayment(MainActivity.this, deepLink,"CBPAY_PIN");
    }

    private void clickWebPay(View view) {
        String redirectUrl = "https://test.octoverse.com.mm/payment/direct/gateway?itoken=eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJwYXltZW50LWFwaS1ndy1zeXN0ZW0iLCJzdWIiOiJBS1QxMjU1IiwiZXhwIjoxNjc1OTE4MDc4fQ.MsacJTv0X0RNUhn495fsba0Y9ZsWqjQR93fK5YATXEQ&ptoken=b9n1wv4FpIfLt7SvCZvh9StvcVyfSLU%2BDd6mq8mILqc%3D&pcode=WAVEMONEY_WEB";
        Log.d("WEB Url : ", redirectUrl);
        OctoversePay.invokePayment(MainActivity.this, redirectUrl,"WEB");
    }
}