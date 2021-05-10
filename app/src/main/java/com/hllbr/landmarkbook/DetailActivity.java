package com.hllbr.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

//import static com.hllbr.landmarkbook.MainActivity.selectedImage;//burada selectedImage import edildi.Normalde biz sınıfları import ederiz fakat bu sefer değişken import edilmiş oldu.


public class DetailActivity extends AppCompatActivity {
    //Burada bir imageView ihtiyacım var.Görsellerini Göstermek için Bir TextView ihtiyacım var ismini yazmak için.Eğer istersem detaylı bilgi vermek için yada tarihlerini ifade etmek içinde ayrı ayrı textViewler ekleyebilirim.
    TextView countryNameText,landmarkNameText;
    ImageView imageView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        countryNameText = findViewById(R.id.countryNameText);
        landmarkNameText = findViewById(R.id.landmarkNameText);
        imageView = findViewById(R.id.imageView);
        //şimdi birinci aktivite içerisinde tıklama işemi yapıldığında geçişi ve geçiş sırasında bilgilerin aktarılması kaldı.
        Intent intent = getIntent();
        String landmar = intent.getStringExtra("name");
        String country = intent.getStringExtra("country");
        countryNameText.setText(country);
        landmarkNameText.setText(landmar);
        //imageView.setImageBitmap(selectedImage);//seçili olan bitmap gösterilebilir.
        Singleton singleton = Singleton.getInstance();
        imageView.setImageBitmap(singleton.getChosenImage());
    }
}