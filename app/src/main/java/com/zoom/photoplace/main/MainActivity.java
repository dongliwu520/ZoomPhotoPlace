package com.zoom.photoplace;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import me.ele.uetool.UETool;

/**
 * Created by wudongli on 2018/6/27.
 */

public class StartActivity extends Activity implements View.OnClickListener {

    @ViewInject(R.id.btn1)
    private Button btn1;

    @ViewInject(R.id.btn2)
    private Button btn2;

    Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        x.view().inject(this);

        UETool.showUETMenu();
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btn2:
                intent = new Intent(this, CarouselLayoutActivity.class);
                startActivity(intent);
                break;
        }
    }
}
