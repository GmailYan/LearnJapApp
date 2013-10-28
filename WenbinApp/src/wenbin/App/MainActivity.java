package wenbin.App;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	
	private static final int VOICE_RECOGNITION_REQUEST_CODE = 1001;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void OnCloseButtonClicked(View view) {
		// Kabloey
		finish();
		
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);;
		startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);

	}

	public void checkVoiceRecognition() {
		// Check if voice recognition is present

		PackageManager pm = getPackageManager();

		List<ResolveInfo> activities = pm.queryIntentActivities(new Intent(
				RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);

		if (activities.size() == 0) {

			// mbtSpeak.setText("Voice recognizer not present")

		}

	}

}
