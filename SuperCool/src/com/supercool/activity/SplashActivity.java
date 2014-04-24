package com.supercool.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.newsapp.R;
import com.supercool.tool.MyConfig;

public class SplashActivity extends Activity {
	/**
	 * 闪屏界面的view类
	 */
	private ImageView img_spalsh;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_splash);
		initUI();
		startAnimation(img_spalsh);
	}

	/**
	 * 绑定ui元素
	 */
	private void initUI() {
		img_spalsh = (ImageView) findViewById(R.id.img_splash);

	}

	/**
	 * 给imageview添加动画
	 * 
	 * @param img
	 */
	private void startAnimation(ImageView img) {
		Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.anim_splash);
		img.startAnimation(anim);
		anim.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				skipToOtherActivity();
			}
		});
	}

	/**
	 * 根据是否是第一次登陆跳转到不同的acitity
	 */
	private void skipToOtherActivity() {
		Intent intent = new Intent();
		if (isFirstOpen()) {
			// 首次登陆 跳转到引导界面
			intent.setClass(getApplicationContext(), null);
		} else {
			// 跳转到主界面
			intent.setClass(getApplicationContext(), null);

		}

		startActivity(intent);

	}

	/**
	 * 判断是否是首次登陆
	 * 
	 * @return
	 */
	private boolean isFirstOpen() {

		return getSharedPreferences(MyConfig.SHARE_NAME, MODE_PRIVATE)
				.getBoolean(MyConfig.IS_FIRST_OPEN, true);

	}
}
