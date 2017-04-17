package com.example.pc4.itjob;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by PC4 on 2017/4/13.
 */

public class ListViewDemoActivity extends Activity{

    private ListView listView;
    private List<HashMap<String, Object>>  mHashMaps;
    private HashMap<String, Object> map;
    private SimpleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        TitileBar.getTitleBar(this, "ListView_Demo");
        setContentView(R.layout.listview_layout);

        listView = (ListView) findViewById(R.id.listView);

        setInfo();

        mAdapter = new SimpleAdapter(this, setInfo(), R.layout.listview_item, new String[]{"img", "title", "info"}, new int[]{R.id.img, R.id.title, R.id.info});
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dialog dialog = new AlertDialog.Builder(ListViewDemoActivity.this)
                        .setTitle("提示").setMessage("您点击了第"+position+"条item！")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).create();
                dialog.show();
            }
        });
       // listView.setAdapter(new ListViewAdapter(mlistInfo));
    }

    private List<HashMap<String, Object>> setInfo(){
        mHashMaps = new ArrayList<HashMap<String, Object>>();

        for(int i = 0; i < 10; i++){
            map = new HashMap<String, Object>();

            map.put("img", R.drawable.listview_item);
            map.put("title", "标题"+i);
            map.put("info", "详细信息"+i);

            mHashMaps.add(map);
        }

        return mHashMaps;
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        ListViewDemoActivity.this.finish();
    }
}
