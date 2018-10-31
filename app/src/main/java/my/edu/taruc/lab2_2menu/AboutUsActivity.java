package my.edu.taruc.lab2_2menu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AboutUsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
    }

    public void visitTARUC(View v){
        String uri = "http://www.tarc.edu.my";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(uri));
        startActivity(intent);
    }

    public void showMain(View v){
        Intent intent = new Intent (Intent.ACTION_MAIN);
        startActivity(intent);
    }

    public void showDial(View v){
        Intent intent = new Intent (Intent.ACTION_DIAL,
                Uri.parse("tel:" + "012-3456789"));
        startActivity(intent);
    }

    public void showSendTo(View v){
        Intent intent = new Intent (Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mail to:" + "handsomesky@tarc.edu.my"));
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        } else{
            Toast.makeText(this,"No app to handle this intent",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
