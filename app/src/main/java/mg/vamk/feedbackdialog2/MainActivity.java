package mg.vamk.feedbackdialog2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "EVH_Demo";

    private long lastEventTimeMs = -1;

    private EditText etFirstName, etLastName, etPhone, etComment;

    private void logEvent(String eventName) {
        long now = SystemClock.elapsedRealtime();
        if (lastEventTimeMs < 0) {
            Log.d(TAG, eventName + " (first event)");
        } else {
            long delta = now - lastEventTimeMs;
            Log.d(TAG, eventName + " (+" + delta + " ms)");
        }
        lastEventTimeMs = now;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Poistaa title-featuren (varmistus)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etPhone = findViewById(R.id.etPhone);
        etComment = findViewById(R.id.etComment);

        Button btnSend = findViewById(R.id.btnSend);
        Button btnReset = findViewById(R.id.btnReset);

        btnSend.setOnClickListener(v -> {
            Toast.makeText(this, getString(R.string.sent_ok), Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Send clicked");
        });

        btnReset.setOnClickListener(v -> {
            etFirstName.setText("");
            etLastName.setText("");
            etPhone.setText("");
            etComment.setText("");
            Log.d(TAG, "Reset clicked");
        });

        logEvent("onCreate()");
    }

    @Override protected void onStart() { super.onStart(); logEvent("onStart()"); }
    @Override protected void onRestart() { super.onRestart(); logEvent("onRestart()"); }
    @Override protected void onResume() { super.onResume(); logEvent("onResume()"); }
    @Override protected void onPause() { super.onPause(); logEvent("onPause()"); }
    @Override protected void onStop() { super.onStop(); logEvent("onStop()"); }
    @Override protected void onDestroy() { super.onDestroy(); logEvent("onDestroy()"); }
}
