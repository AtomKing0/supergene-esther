package com.king.amp.sa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class BrowserComponent {
    private static String TAG = "AdsBrowserComponent";

    @Nullable
    private static WeakReference<BrowserComponent> sInstance;
    private long mComponentAddress;

    @Nullable
    private final WeakReference<Context> mContext;

    public BrowserComponent(long j10, Activity activity) {
        if (activity == null) {
            Log.e(TAG, "openUrl: Activity is null");
            onDismissedWrapper(j10);
            this.mContext = null;
        } else if (j10 == 0) {
            Log.e(TAG, "Component address is 0");
            this.mContext = null;
        } else {
            this.mComponentAddress = j10;
            this.mContext = new WeakReference<>(activity.getApplicationContext());
            sInstance = new WeakReference<>(this);
        }
    }

    @Nullable
    public static BrowserComponent getInstance() {
        WeakReference<BrowserComponent> weakReference = sInstance;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static Intent getStartIntent(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) BrowserComponentActivity.class);
        intent.putExtra("url", str);
        return intent;
    }

    private static native void onAppeared(long j10);

    private static native void onDismissed(long j10);

    private static native void onError(long j10, String str);

    @VisibleForTesting
    public static void setInstance(BrowserComponent browserComponent) {
        sInstance = new WeakReference<>(browserComponent);
    }

    public void browserAppeared() {
        long j10 = this.mComponentAddress;
        if (j10 != 0) {
            onAppearedWrapper(j10);
        }
    }

    public void browserDismissed() {
        long j10 = this.mComponentAddress;
        if (j10 != 0) {
            onDismissedWrapper(j10);
        }
    }

    public void browserError(String str) {
        long j10 = this.mComponentAddress;
        if (j10 != 0) {
            onErrorWrapper(j10, str);
        }
    }

    @VisibleForTesting
    protected void onAppearedWrapper(long j10) {
        if (this.mComponentAddress != 0) {
            onAppeared(j10);
        }
    }

    @VisibleForTesting
    protected void onDismissedWrapper(long j10) {
        if (this.mComponentAddress != 0) {
            onDismissed(j10);
        }
    }

    @VisibleForTesting
    protected void onErrorWrapper(long j10, String str) {
        if (this.mComponentAddress != 0) {
            onError(j10, str);
        }
    }

    public void openUrl(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e(TAG, "openUrl: Url is empty");
            browserDismissed();
        } else if (!AbmMediaPlayer.isActivityRunningInForeground(this.mContext.get(), AbmMediaPlayerActivity.class)) {
            Intent startIntent = getStartIntent(this.mContext.get(), str);
            startIntent.setFlags(268435456);
            this.mContext.get().startActivity(startIntent);
        } else {
            Log.i(TAG, "Player activity is running");
            Intent intent = new Intent();
            intent.setAction("com.king.amp.sa.UPDATE_PLAYER_ACTIVITY");
            intent.putExtra("open_url", str);
            LocalBroadcastManager.getInstance(this.mContext.get()).sendBroadcast(intent);
        }
    }

    public void resetComponentAddress() {
        this.mComponentAddress = 0L;
    }
}
