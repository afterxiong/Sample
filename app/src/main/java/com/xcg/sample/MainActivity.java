package com.xcg.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by xiongchengguang on 2018/4/12.
 */

public class MainActivity extends AppCompatActivity {

    private EditText ed_count;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_count = findViewById(R.id.count);
    }

    public void compile(View view) {
        if (ed_count.getText().toString().isEmpty()) {
            Toast.makeText(this, R.string.main_count_is_null, Toast.LENGTH_SHORT).show();
        } else {
            int count = Integer.parseInt(ed_count.getText().toString());
            if (count <= 999) {
                Intent intent = new Intent(this, PageActivity.class);
                intent.putExtra(Constant.MAX_COUNT, count);
                startActivity(intent);
            } else {
                Toast.makeText(this, R.string.main_max_count, Toast.LENGTH_SHORT).show();
            }

        }

    }
}
