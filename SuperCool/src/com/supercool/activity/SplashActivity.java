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
	 * ���������view��
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
	 * ��uiԪ��
	 */
	private void initUI() {
		img_spalsh = (ImageView) findViewById(R.id.img_splash);

	}

	/**
	 * ��imageview��Ӷ���
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
	 * �����Ƿ��ǵ�һ�ε�½��ת����ͬ��acitity
	 */
	private void skipToOtherActivity() {
		Intent intent = new Intent();
		if (isFirstOpen()) {
			// �״ε�½ ��ת����������
			intent.setClass(getApplicationContext(), null);
		} else {
			// ��ת��������
			intent.setClass(getApplicationContext(), null);

		}

		startActivity(intent);

	}

	/**
	 * �ж��Ƿ����״ε�½
	 * 
	 * @return
	 */
	private boolean isFirstOpen() {

		return getSharedPreferences(MyConfig.SHARE_NAME, MODE_PRIVATE)
				.getBoolean(MyConfig.IS_FIRST_OPEN, true);

	}
}
