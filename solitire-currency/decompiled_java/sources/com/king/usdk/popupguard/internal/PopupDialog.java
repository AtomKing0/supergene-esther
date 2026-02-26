package com.king.usdk.popupguard.internal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentCallbacks2;
import android.content.DialogInterface;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.webkit.WebViewCompat;
import com.king.usdk.popupguard.IPopupDialog;

/* JADX INFO: loaded from: classes4.dex */
@Keep
class PopupDialog implements IPopupDialog, DefaultLifecycleObserver {
    private final ActivityWrapper activityWrapper;
    private AlertDialog dialog;

    PopupDialog(Activity activity) {
        ActivityWrapper activityWrapper = new ActivityWrapper(activity);
        this.activityWrapper = activityWrapper;
        ComponentCallbacks2 activity2 = activityWrapper.getActivity();
        if (activity2 instanceof LifecycleOwner) {
            ((LifecycleOwner) activity2).getLifecycle().addObserver(this);
        }
    }

    @Keep
    private boolean isWebviewPackageUnavailable() {
        try {
            return WebViewCompat.getCurrentWebViewPackage(this.activityWrapper.getActivity()) == null;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closeAlertDialog$2() {
        AlertDialog alertDialog = this.dialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        this.dialog.dismiss();
        this.dialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showNativeDialog$0(long j10, DialogInterface dialogInterface, int i10) {
        closeAlertDialog();
        onDialogDismissed(j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showNativeDialog$1(String str, String str2, boolean z10, String str3, final long j10) {
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.dialog.dismiss();
        }
        Activity activity = this.activityWrapper.getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(str);
        TextView textView = new TextView(activity);
        textView.setText(str2);
        textView.setPadding(50, 20, 50, 20);
        textView.setAutoLinkMask(1);
        textView.setGravity(17);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        builder.setView(textView);
        if (z10) {
            builder.setCancelable(false);
        } else {
            builder.setPositiveButton(str3, new DialogInterface.OnClickListener() { // from class: com.king.usdk.popupguard.internal.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    this.f17240a.lambda$showNativeDialog$0(j10, dialogInterface, i10);
                }
            });
        }
        AlertDialog alertDialogCreate = builder.create();
        this.dialog = alertDialogCreate;
        alertDialogCreate.show();
    }

    @Keep
    private native void onDialogDismissed(long j10);

    public void closeAlertDialog() {
        this.activityWrapper.runOnUIThread(new Runnable() { // from class: com.king.usdk.popupguard.internal.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f17242a.lambda$closeAlertDialog$2();
            }
        });
    }

    @Override // com.king.usdk.popupguard.IPopupDialog
    @Keep
    public boolean isWebviewEnabled() {
        try {
            Activity activity = this.activityWrapper.getActivity();
            if (activity == null) {
                return false;
            }
            activity.getApplicationContext();
            return !isWebviewPackageUnavailable();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.a(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(LifecycleOwner lifecycleOwner) {
        closeAlertDialog();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.c(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.d(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.e(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.f(this, lifecycleOwner);
    }

    @Override // com.king.usdk.popupguard.IPopupDialog
    @Keep
    public void showNativeDialog(final String str, final String str2, final String str3, final boolean z10, final long j10) {
        this.activityWrapper.runOnUIThread(new Runnable() { // from class: com.king.usdk.popupguard.internal.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f17234a.lambda$showNativeDialog$1(str2, str, z10, str3, j10);
            }
        });
    }
}
