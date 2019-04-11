package tslaboratory.custom.dialog.sample.customdialogapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ダイアログを出す
        findViewById(R.id.button_appear_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
                TextDialog textDialog = new TextDialog();
                textDialog.show(fm, "tagTextDialog");
            }
        });
    }

    // 入力された数字を表示する
    public void onUpdateText(String inputText) {
        ((TextView) findViewById(R.id.text_input)).setText(inputText);
    }
}
