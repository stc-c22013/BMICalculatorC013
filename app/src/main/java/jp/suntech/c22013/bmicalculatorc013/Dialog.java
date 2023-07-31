package jp.suntech.c22013.bmicalculatorc013;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class Dialog extends DialogFragment {
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstate) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("警告");
        builder.setMessage("適切な肥満度を求めるには、６歳未満の場合はカウブ指数が、６歳から１５歳まではローレル指数が使われます。本アプリはBMIのみに対応しています。");
        builder.setPositiveButton("確認", new DialogButtonClickListener());
        AlertDialog dialog = builder.create();

        return dialog;
    }

    private class DialogButtonClickListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            String msg = "";
            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    msg = "ありがとうございます。";
                    break;

            }

        }
    }
}

