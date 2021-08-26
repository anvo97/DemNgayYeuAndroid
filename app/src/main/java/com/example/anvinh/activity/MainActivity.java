package com.example.anvinh.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.anvinh.R;
import com.example.anvinh.adapter.pager.ViewPagerMain;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE = 1;

    public ImageView imageAn, imageZinh, imageHeart, icMemory;
    public TextView nameAn, nameZinh, tuoiAn, tuoiZinh;
    public LinearLayout sliderDotspanel;
    public ViewPager viewPager;
    public ViewPagerMain pagerAdapter;
    public Animation animZoomIn, animZoomOut;

    int calendarYear = Calendar.getInstance().get(Calendar.YEAR);
    int calendarMonth = Calendar.getInstance().get(Calendar.MONTH);
    int calendarDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    public long nam, thang, tuan, ngay, ngayShow, tongNgay;
    private int dotscount;
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViewByID();
        startAnimationHeart();
        tuoiAn.setText(getAge(1997, 9, 16));
        tuoiZinh.setText(getAge(1998, 6, 10));
        printDifference();
        pagerAdapter = new ViewPagerMain(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        setUpDotSlider();
        loadProfileDefault();
    }

    public void setViewByID() {
        imageAn = (ImageView) findViewById(R.id.image_an);
        imageZinh = (ImageView) findViewById(R.id.image_zinh);
        imageHeart = (ImageView) findViewById(R.id.heart_animation);
        icMemory = (ImageView) findViewById(R.id.memory);
        nameAn = (TextView) findViewById(R.id.name_an);
        nameZinh = (TextView) findViewById(R.id.name_zinh);
        tuoiAn = (TextView) findViewById(R.id.tuoi_an);
        tuoiZinh = (TextView) findViewById(R.id.tuoi_zinh);
        sliderDotspanel = (LinearLayout) findViewById(R.id.layoutDotSlder);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        animZoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        animZoomOut = AnimationUtils.loadAnimation(this, R.anim.zoom_out);
        imageAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImagePickerOptions();
            }
        });
        imageZinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImagePickerOptions();
            }
        });
        icMemory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MemoryActivity.class));
            }
        });
    }

    private void printDifference() {
        LocalDateTime fromDateTime = LocalDateTime.of(2019, 9, 27, 0, 0, 0);
        LocalDateTime toDateTime = LocalDateTime.of(calendarYear,
                calendarMonth + 1, calendarDay, 0, 0, 0);

        LocalDateTime tempDateTime = LocalDateTime.from(fromDateTime);

        tongNgay = tempDateTime.until(toDateTime, ChronoUnit.DAYS);
        nam = tempDateTime.until(toDateTime, ChronoUnit.YEARS);
        tempDateTime = tempDateTime.plusYears(nam);

        thang = tempDateTime.until(toDateTime, ChronoUnit.MONTHS);
        tempDateTime = tempDateTime.plusMonths(thang);

        ngay = tempDateTime.until(toDateTime, ChronoUnit.DAYS);
        tuan = ngay / 7;
        ngayShow = ngay % 7;
    }

    private void setUpDotSlider() {
        dotscount = pagerAdapter.getCount();
        dots = new ImageView[dotscount];
        sliderDotspanel.removeAllViews();
        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(MainActivity.this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.dot_none_active));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.dot_active));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.dot_none_active));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.dot_active));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private String getAge(int year, int month, int day) {
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        Integer ageInt = new Integer(age);
        String ageS = ageInt.toString();

        return ageS;
    }

    private void startAnimationHeart() {
        imageHeart.startAnimation(animZoomIn);
        animZoomIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageHeart.startAnimation(animZoomOut);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animZoomOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageHeart.startAnimation(animZoomIn);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void loadProfileDefault() {
        Glide.with(this).load(R.drawable.anzinh)
                .into(imageAn);
        Glide.with(this).load(R.drawable.anzinh)
                .into(imageZinh);
    }

    public void showImagePickerOptions() {
        ImagePickerActivity.showImagePickerOptions(this, new ImagePickerActivity.PickerOptionListener() {
            @Override
            public void onCameraSelected() {
                launchCamera();
            }

            @Override
            public void onGallerySelected() {
                launchGallery();
            }
        });
    }

    public void launchCamera() {
        Intent intent = new Intent(MainActivity.this, ImagePickerActivity.class);
        intent.putExtra(ImagePickerActivity.REQUEST_CODE_TYPE, ImagePickerActivity.REQUEST_IMAGE_CAPTURE);

        // Gán tỉ lệ khóa là 1x1
        intent.putExtra(ImagePickerActivity.EXTRA_LOCK_ASPECT_RATIO, true);
        intent.putExtra(ImagePickerActivity.EXTRA_ASPECT_RATIO_X, 1);
        intent.putExtra(ImagePickerActivity.EXTRA_ASPECT_RATIO_Y, 1);

        startActivityForResult(intent, REQUEST_IMAGE);
    }

    public void launchGallery() {
        Intent intent = new Intent(MainActivity.this, ImagePickerActivity.class);
        intent.putExtra(ImagePickerActivity.REQUEST_CODE_TYPE, ImagePickerActivity.REQUEST_IMAGE_GALLERY);

        // Gán kích thước tối đa cho ảnh
        intent.putExtra(ImagePickerActivity.EXTRA_SET_BITMAP_MAX_WIDTH_HEIGHT, true);
        intent.putExtra(ImagePickerActivity.EXTRA_BITMAP_MAX_WIDTH, 480);
        intent.putExtra(ImagePickerActivity.EXTRA_BITMAP_MAX_HEIGHT, 640);

        startActivityForResult(intent, REQUEST_IMAGE);
    }

    public void loadImageProfile(String url) {
        Glide.with(this).load(url)
                .into(imageAn);
        imageAn.setColorFilter(ContextCompat.getColor(this, android.R.color.transparent));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE) {
            if (resultCode == RESULT_OK) {
                Uri uri = data.getParcelableExtra("path");
                loadImageProfile(uri.toString());
            }
        }
    }
}
