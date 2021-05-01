package sg.edu.np.madprac2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User user = new User("Duck", 123, "A duck is called a duck because it ducks its head under the water to feed. The animal was named after the verb and not the other way around.",
                false);
        Button button = findViewById(R.id.button);
        TextView nameText = (TextView)findViewById(R.id.textView);
        nameText.setText(user.name);
        TextView descText = (TextView)findViewById(R.id.textView2);
        descText.setText(user.desc);

        if (!user.isFollowed()) {
            button.setText("Follow");
        }
        else {
            button.setText("Unfollow");
        }

        button.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View view) {
              if(!user.isFollowed()) {
                  button.setText("Unfollow");
                  user.setFollowed(true);
              }else {
                  button.setText("Follow");
                  user.setFollowed(false);
              }
          }
        }
        );
    }
}