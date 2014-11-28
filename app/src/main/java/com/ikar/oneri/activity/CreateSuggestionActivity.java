package com.ikar.oneri.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;
import com.ikar.oneri.R;
import com.ikar.oneri.adapter.CategorySpinnerAdapter;
import com.ikar.oneri.application.OneriApplication;
import com.melnykov.fab.FloatingActionButton;

public class CreateSuggestionActivity extends BaseActionBarActivity implements View.OnClickListener {
    private EditText editTextAdviceTitle;
    private ImageView imageViewAdvice;
    private Spinner spinnerAdviceCategory;
    private Spinner spinnerAdviceSubCategory;
    private NiftyDialogBuilder dialogBuilder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialogBuilder = NiftyDialogBuilder.getInstance(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_create_suggestion_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(this);
        editTextAdviceTitle = (EditText) findViewById(R.id.edittext_advice_title);
        imageViewAdvice = (ImageView) findViewById(R.id.imageview_advice);
        spinnerAdviceCategory = (Spinner) findViewById(R.id.spinner_advice_category);
        spinnerAdviceSubCategory = (Spinner) findViewById(R.id.spinner_advice_sub_category);
        CategorySpinnerAdapter catAdapter = new CategorySpinnerAdapter(CreateSuggestionActivity.this, R.layout.spinner_item, OneriApplication.categoryList);
        spinnerAdviceCategory.setAdapter(catAdapter);
        imageViewAdvice.setOnClickListener(this);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.layout_create_suggestion;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                onBackPressed();
                break;
            case R.id.imageview_advice:
                clickImage();
                break;
        }
    }

    private void clickImage() {
        dialogBuilder
                .withTitle("Modal Dialog")                                  //.withTitle(null)  no title
                .withTitleColor("#FFFFFF")                                  //def
                .withDividerColor("#11000000")                              //def
                .withMessage("This is a modal Dialog.")                     //.withMessage(null)  no Msg
                .withMessageColor("#FFFFFFFF")                              //def  | withMessageColor(int resid)
                .withDialogColor("#FFE74C3C")                               //def  | withDialogColor(int resid)
                .withIcon(getResources().getDrawable(R.drawable.left_menu_plus))
                .withDuration(1000)                                          //def
                .withEffect(Effectstype.Fall)                                         //def Effectstype.Slidetop
                .withButton1Text("OK")                                      //def gone
                .withButton2Text("Cancel")                                  //def gone
                .isCancelableOnTouchOutside(true)                           //def    | isCancelable(true)
//                .setCustomView(R.layout.custom_view, getApplicationContext())         //.setCustomView(View or ResId,context)
                .setButton1Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "i'm btn1", Toast.LENGTH_SHORT).show();
                    }
                })
                .setButton2Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "i'm btn2", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
