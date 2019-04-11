package tslaboratory.custom.dialog.sample.customdialogapp;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

public class TextDialog extends DialogFragment {

    private View view;
    private EditText mEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // ダイアログのタイトル領域を消す
        this.getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

        // ダイアログ外をタップされてもダイアログを消さない
        this.getDialog().setCanceledOnTouchOutside(false);

        // レイアウトを指定する
        view = inflater.inflate(R.layout.dialog_text, container);

        // 数字入力のみにする
        mEditText = view.findViewById(R.id.edit_text);
        mEditText.setInputType(InputType.TYPE_CLASS_NUMBER);

        // 自動的にソフトキーボードを表示する
        mEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        // OK
        view.findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 入力された数字をMainActivityに渡す
                String inputText = ((EditText) view.findViewById(R.id.edit_text)).getText().toString();
                ((MainActivity) getActivity()).onUpdateText(inputText);
                getFragmentManager().beginTransaction().remove(TextDialog.this).commit();
            }
        });

        // キャンセル
        view.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // このdialogを閉じる
                getFragmentManager().beginTransaction().remove(TextDialog.this).commit();
            }
        });

        return view;
    }
}
