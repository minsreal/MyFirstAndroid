package com.example.pc4.itjob;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by PC4 on 2017/4/13.
 */

public class RelativeDmoActivity extends Activity {
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        TitileBar.getTitleBar(this, "FrameLayout_Demo");
        setContentView(R.layout.relative_layout);
    }
}
