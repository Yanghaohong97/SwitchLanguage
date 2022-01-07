package com.tnnowu.android.switchlanguage;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    private TextView titleTextView;
    private TextView descTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleTextView = findViewById(R.id.titleTextView);
        descTextView = findViewById(R.id.descTextView);
        Locale locale = new Locale("zhi");
        Log.d("TAG", "onCreate: locale.getDisplayLanguage()="+locale.getDisplayLanguage());
//        Locale locale2 = new Locale(locale.getDisplayLanguage());
        String iso2Language = Arrays.toString(locale.getISOLanguages());
        Log.d("TAG", "onOptionsItemSelected: iso2Language="+iso2Language);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.language_english) {

            updateViews("en");
        } else if (id == R.id.language_simplified_chinese) {

            updateViews("zh");
        } else if (id == R.id.language_turkish) {
            updateViews("tr");
        } else if (id == R.id.language_japanese) {
            updateViews("ja");
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateViews(String languageCode) {
        Context context = LocaleHelper.setLocale(this, languageCode);
        Resources resources = context.getResources();

        titleTextView.setText(resources.getString(R.string.title));
        descTextView.setText(resources.getString(R.string.desc));

        setTitle(resources.getString(R.string.toolbar_title));
    }

}
