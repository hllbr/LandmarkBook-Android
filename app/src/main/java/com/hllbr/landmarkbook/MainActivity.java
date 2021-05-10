package com.hllbr.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //static Bitmap selectedImage ;//static anahtar kelimesi heryerden ulaşılabilir standartlarda olduğunu ifade eder tanımlanan ifadenin
    /*
    kÜÇÜK PROJELERDE BU YÖNTEMLE ÇALIŞILABİLİR.Fakat genelde proje üzerinde birçok kişinin çalıştığı durumlarda bir kişi yanlış yerde bu selected ımage ifadesinin çağırabilir .Değiştirebilir.böyle yapılara heryerden ulaşmak çok tercih edilen bir durum değildir.
    Profesyönel yazılımlarda bu static yapısı çok dikkatli olarak kullanılır.
    Bu yöntemin çirkinliği güvensizliğinden geliyor daha güvenli bir yöntem var bunun yerine onu tercih etmek gerek
    Buradaki yapı yerine singleton adı verilen bir yapıyı kullanmak kodu daha güvenli hale getirir.
    Singleton nedir ?

    tek bir obje tek bir instance'a sahip sınıf anlamına gelir.

    bir adet java sınıfı oluşturuyorum normal bir sınıf yazacağım ve bunu singletona çevireceğim.
     */

/*
listView üzerinde çalışma
bir diziyi nasıl listede gösteririm
internetten çektiğim verileri göstermek gibi farklı işlemleri nasıl yaparım

Proje amacı kent simgelerinin gösterildiği bir liste oluşturmak bu listedeki elemana tıklandığında başka bir alana gidilecek ve gidilen ctivite içerisinde de seçtiğim kent simgesinin resmi ve bununla ilgili diğer bilgiler gösterilecek
V2 tarihlerinin de işin içine dahjl edilmesi
 */

    ListView listView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        app açıldığı gibi gerçekleşmesini istediğim işlemler olduğu için buradan başlıyorum
        App açıldığı gibi bir liste ile karşılaşmak istiyorum
        listView da grid layout gibi kendini atıldığı anda genişletiyor ve ekranı kaplıyor.Fakat bu constraint verildiği anlamına gelmez bizim bu işlemi yapmamız gerekiyor
         */
        listView = findViewById(R.id.listView);//listView tanımalaması gerçekleşti işlemlerimi bu yapı içerisinde gerçekleştiriyorum

        //bu yapının içerisine metinlerimi(Görünümlerimi) yerleştirmem gerekiyor.
        //Şuan bir listem yok öncelikli olarak bir liste oluşturmam gerekiyor.
        //oluşturduğum listede sadece isimlerim bulunacak

        //Data
        ArrayList<String> landmarkNames = new ArrayList<String>();
        //boş birt liste oluşturduk şimdi içerisine göstermek istediğim elemanları eklemem gerekiyor.
        //Arraylist içerisine eleman eklenirken add adlı metod kullanılır.
        //sadece String ifadelerle değil farklı veri tipleri ilede listeler metdana getirebilrim character yada ınteger ....
        //Şuan sanat eserlerinin isimlerini ifade etmek istediğim için String veri tipi ile bir liste oluşturuyorum

        landmarkNames.add("Pisa Tower");
        landmarkNames.add("Effiel Tower");
        landmarkNames.add("Colosseum");
        landmarkNames.add("London Bridge");
        landmarkNames.add("Great wall of China");
        landmarkNames.add("Travertines of Pamukkale");
        //buradaki listeyi(Diziyi) listView içerisinde Göstermek istiyorum

        //Bu işlemi gerçekleştirmek için arrayAdapter olarak bilinen bir yapıya ihtiyaç duyuyoruz


        //ArrayAdapter kullanım çeşitlerinden biri listView içerisinde bazı contentleri(içerikleri) göstermek için kullanıyoruz.
        //bu sınıfran yararlanabilmek için bu sınıftan bir obje oluşturmam gerekiyor ve oluşturduğum obje üzerinden işlemlerimi gerçekleştirmeliyim.


        ArrayList<String> countryName = new ArrayList<String>();
        //veriler uyuşsun diye aynı sıra ile bilgileri girmem gerekiyor.
        countryName.add("Italy");
        countryName.add("France");
        countryName.add("Italy");
        countryName.add("England");
        countryName.add("China");
        countryName.add("Turkiye");



        //Resimlerimide bir liste olarak ifade edeceiğim fakat kullanacağım parametre farklı olacak

        //resimleri bir obje gibi tanımlamak için Bitmap adı verilen bir sınıftan yararlanıyoruz.Android graphics içerisinde bulunan yapıyı kullanacağız.

        //Bu yapı sayesinde resimlerimizi tanımlayabiliyoruz sadece drawable içerisinde olanları değil aynı zamanda internetten bir data vesaire indirildiğinde de bitmap ile tanımlamalar yapabiliyoruz.

        //Bitmap oluşturmanın çok fazla yolu var ben Drawable içerisindekileri almak istediğim için bitmakFactory denilen bir yapıdan faydalanıyorum.

        //BitmapFactory yapısı bazı farklı kaynaklardan Dosyalardan özellikle bir bitmap oluşturmak için gerekli olan bir sınıf
        Bitmap pisa = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.pisatower);
        //Bu yapıyı artık arrayList içerisinde saklayabilirim.İstediğim heryerde artık kullanabilirim.Aynı işlemi diğer değerlerim içinde yapcağım
        Bitmap effiel = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.effiel);
        Bitmap colleseo = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.collesseo);
        Bitmap London_bridge = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.londonbridge);
        Bitmap greatWll = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.greatwall);
        Bitmap travertines = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.tra);

        //şimdiki işlemim bir arraylist oluşturarak bu bitmaplarımı eklemek olacak .Arraylist içerisinde vereceğim veri tipi Bitmap olacak

        ArrayList<Bitmap> ımageArrays = new ArrayList<Bitmap>();

        //bu liste içerisine elemanlarımı eklediğmi sıra kritik önem taşıyor aynı sıra ile eklemeliyimki yanlış bilgi ile yanlış resim eşleşmesin

        ımageArrays.add(pisa);
        ımageArrays.add(effiel);
        ımageArrays.add(colleseo);
        ımageArrays.add(London_bridge);
        ımageArrays.add(greatWll);
        ımageArrays.add(travertines);

        //tüm liste işlemlerim şimdi bitti fakat tıklama işlemi henüz yazılmadı
        //liste üzerinde tıklama işlemlerini yapmak ve ikinci aktiviteye geçişlerin sağlanması bunun yanı sıra buradaki bilgilerin ikinci aktivite içerisine aktarılması işlemleri yapılacak .





            //ListView
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,landmarkNames) ;//DİREKT OLARAK CONSTRUCTOR boş bir şekilde adapter oluşturamıyorum bazı parametreler göndermem gerekiyor.
        //birinci paramtre nerede bu bu işlemin yapılmasını istediğimi soruyor ben içerisinde bulunduğum activity ile bu işlemi gerçekleştirmek istediğimi MainActivity.this yada getApplicationContext ile bu tanumlamayı yapabilirim
        //ikinci prametre olarak ise bana bir layoutResource yani düzen kaynağı olarak ifade edebilriz.
        //simplelistItem1 ben sadece metin göstereceğim demek
        //üçüncü parametre olarak benden list objelerimi soruyor .Bunuda oluşturduğum listeyi vererek işlemimi tamamlıyorum.
        //şimdi listWiew ile arrayAdapter birbirine bağlamam gerekiyor.
        listView.setAdapter(arrayAdapter);
        /*
        Neden ListView çok önemli sorusuna gelecek olursak =

        Neden ListView kullanıyoruz ?

        bir tıklama gerçekleştiğinde tıklanan alanın indexi veriliyor.Pisa Tower tıklandığında 0 indexini Effiel Tower tıklanırsa 1 indexini alıyorum

        index yapısı hem arraylist hemde listView içerisinde bulunduğu için senkronize bir şekilde kullanabiliyorum

        eğer ben göstermek istediğim görselleride landmarkImage olarak eklersem başka bir arrayList eklersem aynı sırada Bitmapleri(Görselleri) eklersem

        Landmarknames.get(0) dediğimde landmarkImage.get(0) ifade ederek doğru resmi göstermiş olurum.

        bir taraftan ismi diğer taraftan gösreli alarak işlemimi gerçekleştirebilirim.

        Temel olarak listView ve ArrayList içersinde de index yapısının olması senkronize çalışmamıza olanak tanıyor.

        liste üzerinde tıklama işlemi gerçekleştiğinde bir aktivite açılmasını istiyorum.Bunu önce oluşturmam sonra iki activity arası iletişimi sağlamam gerekiyor.
         */
        //liste üzerinde tıklama işlemleri için bir metod yazıyorum. ==

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //herhangi bir ıteme tıklandığında ne olacağını buraya yazıyoruz.
                //System.out.println(landmarkNames.get(position));
                //System.out.println(countryName.get(position));

                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("name",landmarkNames.get(position));
                intent.putExtra("country",countryName.get(position));
                //Görselleri intentputExtra ile aktaramıyoruz çünkü bitmap büyük bir veri olarak kalıyor bunların yanında

                //Bitmapleri aktarmanın bir estetik birde çirkin yolu var .Çirkin olan yol static ifadesini kullanarak gerçekleştiriliyor.
               // selectedImage = ımageArrays.get(position);
                    Singleton singleton = Singleton.getInstance();
                    singleton.setChosenImage(ımageArrays.get(position));
                    startActivity(intent);
            }
        });//setClickListener değil setOnItemClickListener listede bir iteme(şeye) tıklandığında rowa tıklandığında ne olacağını bu metod belirtiyor.
        //setOnCIntemLongListener ise bir iteme uzun süre tıklandığında ne olacağını ifade eder.3 saniye basılı kalırsa mesela.
        //bu işlem benden bir dinleyici bekliyor.Dinleyici bir aksiyon olduğunda bir işlem olduğunda kullanıcının bir yere tıklaması internetten bir verinin gelmesi ...gibi durumlar gerçekleştiğinde ne çağrılacak hangi metod çağrılacak .Değişimi dinleyip bu işlem gerçekleşti o zmana şunlar olmaı diyor ....



    }
}