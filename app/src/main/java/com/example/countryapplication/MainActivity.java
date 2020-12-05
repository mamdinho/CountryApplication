package com.example.countryapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    int languageCode = 1;
    Menu menu;
    GridView gridview;
    ArrayList arrayList = new ArrayList(0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            languageCode = savedInstanceState.getInt("language");
            if(languageCode == 2){
                Locale locale = new Locale("ar");
                Locale.setDefault(locale);

                Configuration config = new Configuration();
                config.setLocale(locale);

                getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                Toast.makeText(getApplicationContext(), "Arabic", Toast.LENGTH_SHORT).show();
                languageCode = 2;//app language is Arabic

                finish();
                startActivity(getIntent());
            }else{
                Locale locale = new Locale("en");
                Locale.setDefault(locale);

                Configuration config = new Configuration();
                config.setLocale(locale);

                getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                Toast.makeText(getApplicationContext(), "English", Toast.LENGTH_SHORT).show();
                languageCode = 1;//app language is english

                finish();
                startActivity(getIntent());
            }
        }
        setContentView(R.layout.activity_main);
        updateMenuTitles();
        gridview = findViewById(R.id.gridView);

        arrayList.add(new Country(R.drawable.ar,R.string.argentina));
        arrayList.add(new Country(R.drawable.br,R.string.Brazil));
        arrayList.add(new Country(R.drawable.ca,R.string.Canada));
        arrayList.add(new Country(R.drawable.cn,R.string.China));
        arrayList.add(new Country(R.drawable.de,R.string.Germany));
        arrayList.add(new Country(R.drawable.eg,R.string.Egyte));
        arrayList.add(new Country(R.drawable.es,R.string.Spain));
        arrayList.add(new Country(R.drawable.eu,R.string.EuropeanUnion));
        arrayList.add(new Country(R.drawable.fr,R.string.France));
        arrayList.add(new Country(R.drawable.gb,R.string.England));
        arrayList.add(new Country(R.drawable.it,R.string.Italy));

       CountryAdapter adapter = new CountryAdapter(this, R.layout.country_image_row, arrayList);
        gridview.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         super.onOptionsItemSelected(item);
         switch(item.getItemId()){
             case  R.id.menuItemId :{
                 if(item.getTitle().equals("Arabic")){ //If app menu title is arabic
                     Locale locale = new Locale("ar");
                     locale.setDefault(locale);
                     languageCode = 2; //means arabic is chosen so display english
                     Configuration config = new Configuration();
                     config.setLocale(locale);
                     getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                     finish();
                     startActivity(getIntent());

                 }else if(languageCode == 1){
                     Locale locale = new Locale("en");
                     locale.setDefault(locale);
                     languageCode = 1; //means arabic is chosen so display english
                     Configuration config = new Configuration();
                     config.setLocale(locale);
                     getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                     finish();
                     startActivity(getIntent());
                 }else{
                     Locale locale = new Locale("ru");
                     locale.setDefault(locale);
                     languageCode = 3; //means arabic is chosen so display english
                     Configuration config = new Configuration();
                     config.setLocale(locale);
                     getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                     finish();
                     startActivity(getIntent());
                 }


             }
         }
        return true;
    }

    private void updateMenuTitles() {
        if (menu != null) {
            MenuItem langMenuItem = menu.findItem(R.id.menuItemId);
            if (languageCode == 1) {// if app language is 1 then menu to be Arabic
                langMenuItem.setTitle(R.string.Arabic);
            } else {// if app languege is 2 then menu to be english
                langMenuItem.setTitle(R.string.English);
            }
        }
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("language", languageCode); //saving the language code
    }

    public void changeToRussian(View view){
        Locale locale = new Locale("ru");
        locale.setDefault(locale);

        Configuration config = new Configuration();
        config.setLocale(locale);
        languageCode = 3;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        finish();
        startActivity(getIntent());
    }

    public void changeToSwahili(View view){
        Locale locale = new Locale("sw");
        locale.setDefault(locale);

        Configuration config = new Configuration();
        config.setLocale(locale);
        languageCode = 4;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        finish();
        startActivity(getIntent());
    }
}