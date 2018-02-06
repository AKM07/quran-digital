package com.example.akm.quran_digital.widget.dialog.base;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.example.akm.quran_digital.R;


/**
 * Created by AKM on 12/10/15.
 */
public class MessageDialog {
    private AlertDialog.Builder builder;

    public static MessageDialog getInstance(Activity activity) {
        MessageDialog dialog = new MessageDialog();
        dialog.builder = new AlertDialog.Builder(activity);
        dialog.builder.setTitle(R.string.app_name);
        dialog.builder.setPositiveButton(R.string.label_yes, (dialog1, which) -> dialog1.dismiss());

        return dialog;
    }

    public MessageDialog setTitle(String title) {
        builder.setTitle(title);

        return this;
    }

    public MessageDialog setTitle(int resource) {
        builder.setTitle(resource);

        return this;
    }

    public MessageDialog setMessage(String message) {
        builder.setMessage(message);

        return this;
    }

    public MessageDialog setMessage(int resource) {
        builder.setMessage(resource);

        return this;
    }

    public MessageDialog setPositiveButton(int resourceString, DialogInterface.OnClickListener onClickListener) {
        builder.setPositiveButton(resourceString, onClickListener);

        return this;
    }

    public MessageDialog setPositiveButton(String text, DialogInterface.OnClickListener onClickListener) {
        builder.setPositiveButton(text, onClickListener);

        return this;
    }

    public MessageDialog setNegativeButton(int resourceString, DialogInterface.OnClickListener onClickListener) {
        builder.setNegativeButton(resourceString, onClickListener);

        return this;
    }

    public MessageDialog setNegativeButton(String text, DialogInterface.OnClickListener onClickListener) {
        builder.setNegativeButton(text, onClickListener);

        return this;
    }

    public MessageDialog setNeutralButton(int resourceString, DialogInterface.OnClickListener onClickListener) {
        builder.setNeutralButton(resourceString, onClickListener);

        return this;
    }

    public MessageDialog setNeutralButton(String text, DialogInterface.OnClickListener onClickListener) {
        builder.setNeutralButton(text, onClickListener);

        return this;
    }

    public MessageDialog setOnDismissListener(DialogInterface.OnDismissListener listener) {
        builder.setOnDismissListener(listener);

        return this;
    }

    public MessageDialog setCancelable(boolean cancelable) {
        builder.setCancelable(cancelable);

        return this;
    }

    public void showDialog() {
//        builder.setTitle(R.string.title_warning);
        builder.create().show();
    }
}
