package com.example.jerk;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	
	RelativeLayout backgroundclick;
	private int[] sounds = { R.raw.stepbrothers, R.raw.stepbrothers3, R.raw.stepbrothers4};
	private int pool = 0;
	MediaPlayer mp;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mp = MediaPlayer.create(this, sounds[pool]);

		RelativeLayout backgroundclick = (RelativeLayout) findViewById(R.id.backgroundclick);
		backgroundclick.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if (pool < sounds.length - 1) {
					pool++;
				} else {
					pool = 0;
				}
				
				refreshMediaPlayerWithSound(pool);

			}
			private void refreshMediaPlayerWithSound(int pool) {
				if (mp != null) {
					mp.release();
				}
				mp = MediaPlayer.create(MainActivity.this, sounds[pool]);
				mp.start();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
