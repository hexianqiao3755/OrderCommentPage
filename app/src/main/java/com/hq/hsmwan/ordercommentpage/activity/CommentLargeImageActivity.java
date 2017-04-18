package com.hq.hsmwan.ordercommentpage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hq.hsmwan.ordercommentpage.adapter.LargeImageAdapter;
import com.hq.hsmwan.ordercommentpage.R;

import java.util.ArrayList;
import java.util.List;

public class CommentLargeImageActivity extends BaseActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private ViewPager vp_large_image;
    private LinearLayout ll_back, ll_remove;
    private TextView tv_current_index;

    private LargeImageAdapter adapter;
    private List<String> imgUrls;
    private int currentIndex;

    private final int RESULT_CODE_LARGE_IMAGE = 1;

    @Override
    public void setContentView() {
        super.isNoTitle = true;
        setContentView(R.layout.activity_comment_large_image);
    }

    @Override
    public void initView() {
        vp_large_image = (ViewPager) findViewById(R.id.vp_large_image);
        tv_current_index = (TextView) findViewById(R.id.tv_current_index);
        ll_back = (LinearLayout) findViewById(R.id.ll_back);
        ll_remove = (LinearLayout) findViewById(R.id.ll_remove);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            currentIndex = bundle.getInt(MainActivity.KEY_CURRENT_INDEX);
            imgUrls = bundle.getStringArrayList(MainActivity.KEY_IMAGE_LIST);
            vp_large_image.setAdapter(adapter = new LargeImageAdapter(this, imgUrls));
            vp_large_image.setOffscreenPageLimit(imgUrls.size());
            vp_large_image.setCurrentItem(currentIndex);
            tv_current_index.setText(++currentIndex + " / " + imgUrls.size());
            currentIndex--;
        }
    }

    @Override
    public void initListener() {
        ll_back.setOnClickListener(this);
        ll_remove.setOnClickListener(this);
        vp_large_image.addOnPageChangeListener(this);
    }

    @Override
    public void initData() {
    }

    @Override
    public void onBackPressed() {
        //回到晒单页时候把处理后的图片集合返回过去
        Intent intent = new Intent();
        intent.putStringArrayListExtra(MainActivity.KEY_IMAGE_LIST, (ArrayList<String>) adapter.getData());
        setResult(RESULT_CODE_LARGE_IMAGE, intent);
        super.onBackPressed();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        currentIndex = position;
        tv_current_index.setText(++position + " / " + imgUrls.size());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_back:
                onBackPressed();
                break;

            case R.id.ll_remove:
                //删除当前晒单图
                if (imgUrls.size() == 1) {
                    //删除最后一张时直接回到晒单评论页
                    imgUrls.clear();
                    onBackPressed();
                } else {
                    removeImage(currentIndex);
                }
                break;

            default:
                break;
        }
    }

    /**
     * 删除指定索引的晒单图
     * @param index
     */
    private void removeImage(int index) {
        imgUrls.remove(index);
        setImageTitle(index);
        vp_large_image.removeAllViews();
        vp_large_image.setAdapter(adapter = new LargeImageAdapter(this, imgUrls));
        vp_large_image.setCurrentItem(index == imgUrls.size() - 1 ? ++index : --index);
        adapter.notifyDataSetChanged();
    }

    private void setImageTitle(int index) {
        if (index == 0 ||imgUrls.size() == 1) {
            index = 1;
        } else if (index == imgUrls.size() - 1) {

        } else {
            index += 1;
        }
        tv_current_index.setText(index + " / " + imgUrls.size());
    }
}
