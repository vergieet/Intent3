package id.sch.smktelkom_mlg.learn.intent3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.imageViewPhone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
dialPhoneNumber("0341712500");
            }
        });
        findViewById(R.id.imageViewSMS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
composeSmsMessage("Pesan dari SMK Telkom Malang");
            }
        });
    }

    public void dialPhoneNumber(String phoneNumber){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+phoneNumber));
        if(intent.resolveActivity(getPackageManager()) !=null)
            startActivity(intent);
    }
    public void composeSmsMessage(String message){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra("sms_body",message);
        if(intent.resolveActivity(getPackageManager()) !=null)
            startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
        Bitmap bitmap = data.getParcelableExtra("data");
        ImageView iv = (ImageView) findViewById(R.id.imageViewCamera);
        iv.setImageBitmap(bitmap);
    }
    }
}
