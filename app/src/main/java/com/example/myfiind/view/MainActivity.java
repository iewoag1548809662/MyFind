package com.example.myfiind.view;

import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.myfiind.R;
import com.example.myfiind.base.BaseActivity;
import com.example.myfiind.bean.HomeBean;
import com.example.myfiind.fragment.BlankFragment;
import com.example.myfiind.fragment.ClassIficationFragment;
import com.example.myfiind.fragment.HomeFragment;
import com.example.myfiind.fragment.MyFragment;
import com.example.myfiind.fragment.ShowFragment;
import com.example.myfiind.interfacer.MainContract;
import com.example.myfiind.presenter.MainPrenter;

import java.util.ArrayList;

public class MainActivity extends BaseActivity<MainPrenter>
        implements MainContract.Iview, RadioGroup.OnCheckedChangeListener {


    private RadioGroup radoi;
    private RadioButton butt1;
    private RadioButton butt2;
    private RadioButton butt3;
    private RadioButton butt4;
    private RadioButton butt5;
    private ArrayList<Fragment> fragments;
    private ViewPager vp;

    @Override
    protected void initData() {
        IPresenter.getHomes();
    }

    @Override
    protected void initView() {
        radoi = findViewById(R.id.radoi);
        butt1 = findViewById(R.id.butt1);
        butt2 = findViewById(R.id.butt2);
        butt3 = findViewById(R.id.butt3);
        butt4 = findViewById(R.id.butt4);
        butt5 = findViewById(R.id.butt5);
        vp = findViewById(R.id.vp);

        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new BlankFragment());
        fragments.add(new ClassIficationFragment());
        fragments.add(new ShowFragment());
        fragments.add(new MyFragment());
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        radoi.setOnCheckedChangeListener(this);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case  R.id.butt1:
                       butt1.setChecked(true);
                        break;
                    case  R.id.butt2:
                        butt2.setChecked(true);
                        break;
                    case  R.id.butt3:
                        butt3.setChecked(true);
                        break;
                    case  R.id.butt4:
                        butt4.setChecked(true);
                        break;
                    case  R.id.butt5:
                        butt5.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @Override
    protected int getView() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPrenter getPresenter() {
        return new MainPrenter();
    }

    @Override
    public void getHomesDatas(HomeBean homeBean) {

    }



    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case  R.id.butt1:
                vp.setCurrentItem(0);
                break;

            case  R.id.butt2:
                vp.setCurrentItem(1);
                break;
            case  R.id.butt3:
                vp.setCurrentItem(2);
                break;
            case  R.id.butt4:
                vp.setCurrentItem(3);
                break;
            case  R.id.butt5:
                vp.setCurrentItem(4);
                break;
        }
    }


}