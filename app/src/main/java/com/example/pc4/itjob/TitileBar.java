package com.example.pc4.itjob;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by PC4 on 2017/4/14.
 */

public class TitileBar {
    private static Activity mActivity;

    public static void getTitleBar(Activity activity, String title){
        mActivity = activity;
        activity.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        activity.setContentView((R.layout.head));
        activity.getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.head);

        TextView textView = (TextView) activity.findViewById(R.id.toolbar_title);
        Button backButton = (Button) activity.findViewById(R.id.back_head);

        textView.setText(title);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.finish();
            }
        });
    }
}
