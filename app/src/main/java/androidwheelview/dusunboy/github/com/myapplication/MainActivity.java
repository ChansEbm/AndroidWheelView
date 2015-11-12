package androidwheelview.dusunboy.github.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidwheelview.dusunboy.github.com.library.dialog.OnDateSetListener;
import androidwheelview.dusunboy.github.com.library.dialog.OnTextSetListener;
import androidwheelview.dusunboy.github.com.library.dialog.WheelViewDialog;
import androidwheelview.dusunboy.github.com.library.model.AreaBean;
import androidwheelview.dusunboy.github.com.library.util.LogUtil;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogUtil.setDebugMode(true);
        TextView tv_date = (TextView) findViewById(R.id.tv_date);
        TextView tv_time = (TextView) findViewById(R.id.tv_time);
        TextView tv_province_city_area = (TextView) findViewById(R.id.tv_province_city_area);
        TextView tv_two_level_linkage = (TextView) findViewById(R.id.tv_two_level_linkage);

        tv_date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                WheelViewDialog wheelViewDialog = new WheelViewDialog(
                        MainActivity.this, WheelViewDialog.DATE);
                wheelViewDialog.setTitle("日期");
                wheelViewDialog.setCurrentDate("2015-11-11");
                wheelViewDialog.setPositiveButton("确认", new OnDateSetListener() {
                    @Override
                    public void onDateSet(WheelViewDialog wheelViewDialog, int currentYear, int currentMonth, int currentDay,
                                          int currentHour, int currentMinutes) {
                        wheelViewDialog.dismiss();
                        StringBuffer stringBuffer = new StringBuffer().append(currentYear).append("-").append(currentMonth).append("-").append(currentDay).append("-")
                                .append(currentHour).append("-").append(currentMinutes);
                        Toast.makeText(MainActivity.this,
                                stringBuffer.toString(),
                                Toast.LENGTH_LONG).show();
                    }
                });
                wheelViewDialog.setNegativeButton("取消", null);
                wheelViewDialog.show();
            }
        });

        tv_time.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                WheelViewDialog wheelViewDialog = new WheelViewDialog(
                        MainActivity.this, WheelViewDialog.DATE_TIME);
                wheelViewDialog.setTitle("时间");
                wheelViewDialog.setCurrentDate("2015-11-11 05:30");
                wheelViewDialog.setPositiveButton("确认", new OnDateSetListener() {
                    @Override
                    public void onDateSet(WheelViewDialog wheelViewDialog, int currentYear, int currentMonth, int currentDay,
                                          int currentHour, int currentMinutes) {
                        wheelViewDialog.dismiss();
                        StringBuffer stringBuffer = new StringBuffer().append(currentYear).append("-").append(currentMonth).append("-").append(currentDay).append("-")
                                .append(currentHour).append("-").append(currentMinutes);
                        Toast.makeText(MainActivity.this,
                                stringBuffer.toString(),
                                Toast.LENGTH_LONG).show();
                    }
                });
                wheelViewDialog.setNegativeButton("取消", null);
                wheelViewDialog.show();
            }
        });

        tv_province_city_area.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                WheelViewDialog wheelViewDialog = new WheelViewDialog(
                        MainActivity.this, WheelViewDialog.PROVINCE_CITY_AREA);
                wheelViewDialog.setTitle("省市区三级联动");
                wheelViewDialog.setPositiveButton("确认", new OnTextSetListener() {
                    @Override
                    public void onTextSet(WheelViewDialog wheelViewDialog, String text) {
                        wheelViewDialog.dismiss();
                        Toast.makeText(MainActivity.this,
                                text,
                                Toast.LENGTH_LONG).show();
                    }
                });
                wheelViewDialog.setNegativeButton("取消", null);
                wheelViewDialog.show();
            }
        });


        final ArrayList<AreaBean> areaBeans = new ArrayList<AreaBean>();

        //------------------------------------------------
        AreaBean areaBean1 = new AreaBean();
        ArrayList<AreaBean> areaBean1s = new ArrayList<AreaBean>();
        AreaBean areaBean1_1 = new AreaBean();
        areaBean1_1.setName("啤酒");
        areaBean1s.add(areaBean1_1);

        AreaBean areaBean1_2 = new AreaBean();
        areaBean1_2.setName("白酒");
        areaBean1s.add(areaBean1_2);

        areaBean1.setArea(areaBean1s);
        areaBean1.setName("酒");
        areaBeans.add(areaBean1);

        //------------------------------------------------
        AreaBean areaBean2 = new AreaBean();
        ArrayList<AreaBean> areaBean2s = new ArrayList<AreaBean>();
        AreaBean areaBean2_1 = new AreaBean();
        areaBean2_1.setName("可乐");
        areaBean2s.add(areaBean2_1);

        AreaBean areaBean2_2 = new AreaBean();
        areaBean2_2.setName("雪碧");
        areaBean2s.add(areaBean2_2);

        areaBean2.setArea(areaBean2s);
        areaBean2.setName("饮料");
        areaBeans.add(areaBean2);

        tv_two_level_linkage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                WheelViewDialog wheelViewDialog = new WheelViewDialog(
                        MainActivity.this, WheelViewDialog.TWO_LINKAGE);
                wheelViewDialog.setTitle("二级联动");
                wheelViewDialog.setData(areaBeans);
                wheelViewDialog.setPositiveButton("确认", new OnTextSetListener() {
                    @Override
                    public void onTextSet(WheelViewDialog wheelViewDialog, String text) {
                        wheelViewDialog.dismiss();
                        Toast.makeText(MainActivity.this,
                                text,
                                Toast.LENGTH_LONG).show();
                    }
                });
                wheelViewDialog.setNegativeButton("取消", null);
                wheelViewDialog.show();
            }
        });

        //----------------------无联动选择--------------------------

    }

}
