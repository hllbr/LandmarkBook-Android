package com.hllbr.landmarkbook;

import android.graphics.Bitmap;

public class Singleton {



    //normalde burada bu sınıfta ne gibi değişkenler olacak özellikler olacak onu yazıyorduk ardından bunlar için bir constructor yazıyorduk sonra getter and setter yapıalrını oluşturuyorduk
    //bu alanda bir adet bitmapımız olsun.Bu yapıyı public private yada protected olarakta oluşturabiliriz.
    //Singleton oluduğu için public yapacagız
    private Bitmap chosenImage ;
    private static Singleton singleton ;//bu objeyi burda oluşturduktan sonra heryerde bunu kullanabilirim.bunu kullanabilmek için static bir metod oluşturabilirim.

    public Bitmap getChosenImage() {
        return chosenImage;
    }

    public void setChosenImage(Bitmap chosenImage) {
        this.chosenImage = chosenImage;
    }

    public Singleton(){
        //burası constructorumuz yani bu sınıftan bir obje oluştrulduğunda ilk çağrılacak ilk metoddur.
        //normalde burada bir adet bitmap isteriz bir objeyi oluşturduğumda istediğimiz gösteri buraya eşitleriz.ardından getter ve setter ile gösreli alabilir ve  değiştirebiliriz.


    }
    public static Singleton getInstance(){
        //getInstance o sınıfın objesini al o instanceı al anlamına geliyor.
        if(singleton == null){
            //null yada ilk defa çağrılıyorsa singleton yeni singleton objesine eşit olsun diyorum
            singleton = new Singleton();
        }
            return singleton;
    }
/*
Tek bir obje oluşturmak istediğin bir sınıf varsa tam olarak bu yapı yazılabilir.Buradaki mantık Singleton objesini private yapmak .Sadece sınıf içerisinden erişilebilir hale getirmek .

Sadece Görsel aktarmak için değil diğer alanlarda da kullanılabilir.
 */
}
