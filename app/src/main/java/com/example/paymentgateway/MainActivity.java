package com.example.paymentgateway;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.razorpay.Checkout;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultListener;
import com.razorpay.PaymentResultWithDataListener;
import org.json.JSONObject;
public class MainActivity extends AppCompatActivity implements PaymentResultWithDataListener {

    private Button pay;
    private EditText editTextPayment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Checkout.preload(getApplicationContext());
        findViews();
        listeners();
    }
    public void findViews() {
        pay = (Button) findViewById(R.id.paybtn);
    }
    public void listeners() {
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPayment();
            }
        });
    }
    public void startPayment() {
        Uri uri = Uri.parse("https://rzp.io/l/glxUqSPMCJ"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @Override
    public void onPaymentSuccess(String s, PaymentData paymentData) {
        Toast.makeText(this, "Payment Successful." , Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onPaymentError(int i, String s, PaymentData paymentData) {
    }
}
