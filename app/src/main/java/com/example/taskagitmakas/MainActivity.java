package com.example.taskagitmakas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";
    TextView kullaniciSecim,bilgisayarSecim,kimkazandi,skor;

    int kullaniciskor=0,bilgskor=0;

    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kullaniciSecim=findViewById(R.id.oyunSecim);
        bilgisayarSecim=findViewById(R.id.bilgSecim);
        kimkazandi=findViewById(R.id.sonuc);
        skor=findViewById(R.id.skorTextView);

        kullaniciSecim.setText("");
        bilgisayarSecim.setText("");
        kimkazandi.setText("");

        random = new Random();
    }

    public void resetButton(View view) {
        kullaniciskor=0;
        bilgskor=0;
        skorText(kullaniciskor,bilgskor);
        kullaniciSecim.setText("");
        bilgisayarSecim.setText("");
        kimkazandi.setText("");
    }

    public void rpsButtonSelected(View view) {
        int kullsec= Integer.parseInt(view.getTag().toString());
        Log.i(TAG,"rpsButtonSelected"+kullsec);
        oyun(kullsec);
    }

    private void oyun(int kullsec){

        int x=1,y=3;
        int bsecim=random.nextInt(y)+x;

        if (kullsec==bsecim){
            //berabere
            kimkazandi.setText("berabere");
        } else if ((kullsec-bsecim)%3==1) {
            //kullanici kazandi
            kimkazandi.setText("kazandin");
            kullaniciskor++;
        }else {
            //bilgisayar kazandi
            kimkazandi.setText("kaybettin");
            bilgskor++;
        }

        switch (kullsec){
            case 1:
                kullaniciSecim.setText("Tas");
                break;
            case 2:
                kullaniciSecim.setText("kagit");
                break;
            case 3:
                kullaniciSecim.setText("makas");
                break;
        }

        switch (bsecim){
            case 1:
                bilgisayarSecim.setText("Tas");
                break;
            case 2:
                bilgisayarSecim.setText("kagit");
                break;
            case 3:
                bilgisayarSecim.setText("makas");
                break;
        }
        skorText(kullaniciskor,bilgskor);
    }

    private void skorText(int user,int comp){
        skor.setText(String.valueOf(user)+" : "+String.valueOf(comp));
    }
}