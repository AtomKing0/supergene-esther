package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public final class PendingIntentCompat {

    @RequiresApi(23)
    private static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static void send(@NonNull PendingIntent pendingIntent, @NonNull Context context, int i10, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler, @Nullable String str, @Nullable Bundle bundle) throws PendingIntent.CanceledException {
            pendingIntent.send(context, i10, intent, onFinished, handler, str, bundle);
        }
    }

    @RequiresApi(26)
    private static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static PendingIntent getForegroundService(Context context, int i10, Intent intent, int i11) {
            return PendingIntent.getForegroundService(context, i10, intent, i11);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface Flags {
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class GatedCallback implements Closeable {

        @Nullable
        private PendingIntent.OnFinished mCallback;
        private final CountDownLatch mComplete = new CountDownLatch(1);
        private boolean mSuccess = false;

        GatedCallback(@Nullable PendingIntent.OnFinished onFinished) {
            this.mCallback = onFinished;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onSendFinished(PendingIntent pendingIntent, Intent intent, int i10, String str, Bundle bundle) {
            boolean z10 = false;
            while (true) {
                try {
                    this.mComplete.await();
                    break;
                } catch (InterruptedException unused) {
                    z10 = true;
                } catch (Throwable th) {
                    if (z10) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
            PendingIntent.OnFinished onFinished = this.mCallback;
            if (onFinished != null) {
                onFinished.onSendFinished(pendingIntent, intent, i10, str, bundle);
                this.mCallback = null;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.mSuccess) {
                this.mCallback = null;
            }
            this.mComplete.countDown();
        }

        public void complete() {
            this.mSuccess = true;
        }

        @Nullable
        public PendingIntent.OnFinished getCallback() {
            if (this.mCallback == null) {
                return null;
            }
            return new PendingIntent.OnFinished() { // from class: androidx.core.app.b4
                @Override // android.app.PendingIntent.OnFinished
                public final void onSendFinished(PendingIntent pendingIntent, Intent intent, int i10, String str, Bundle bundle) {
                    this.f830a.onSendFinished(pendingIntent, intent, i10, str, bundle);
                }
            };
        }
    }

    private PendingIntentCompat() {
    }

    private static int addMutabilityFlags(boolean z10, int i10) {
        int i11;
        if (!z10) {
            i11 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        } else {
            if (Build.VERSION.SDK_INT < 31) {
                return i10;
            }
            i11 = 33554432;
        }
        return i10 | i11;
    }

    @NonNull
    public static PendingIntent getActivities(@NonNull Context context, int i10, @NonNull @SuppressLint({"ArrayReturn"}) Intent[] intentArr, int i11, @Nullable Bundle bundle, boolean z10) {
        return PendingIntent.getActivities(context, i10, intentArr, addMutabilityFlags(z10, i11), bundle);
    }

    @Nullable
    public static PendingIntent getActivity(@NonNull Context context, int i10, @NonNull Intent intent, int i11, boolean z10) {
        return PendingIntent.getActivity(context, i10, intent, addMutabilityFlags(z10, i11));
    }

    @Nullable
    public static PendingIntent getBroadcast(@NonNull Context context, int i10, @NonNull Intent intent, int i11, boolean z10) {
        return PendingIntent.getBroadcast(context, i10, intent, addMutabilityFlags(z10, i11));
    }

    @NonNull
    @RequiresApi(26)
    public static PendingIntent getForegroundService(@NonNull Context context, int i10, @NonNull Intent intent, int i11, boolean z10) {
        return Api26Impl.getForegroundService(context, i10, intent, addMutabilityFlags(z10, i11));
    }

    @Nullable
    public static PendingIntent getService(@NonNull Context context, int i10, @NonNull Intent intent, int i11, boolean z10) {
        return PendingIntent.getService(context, i10, intent, addMutabilityFlags(z10, i11));
    }

    @SuppressLint({"LambdaLast"})
    public static void send(@NonNull PendingIntent pendingIntent, int i10, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler) throws PendingIntent.CanceledException {
        GatedCallback gatedCallback = new GatedCallback(onFinished);
        try {
            pendingIntent.send(i10, gatedCallback.getCallback(), handler);
            gatedCallback.complete();
            gatedCallback.close();
        } catch (Throwable th) {
            try {
                gatedCallback.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @NonNull
    public static PendingIntent getActivities(@NonNull Context context, int i10, @NonNull @SuppressLint({"ArrayReturn"}) Intent[] intentArr, int i11, boolean z10) {
        return PendingIntent.getActivities(context, i10, intentArr, addMutabilityFlags(z10, i11));
    }

    @Nullable
    public static PendingIntent getActivity(@NonNull Context context, int i10, @NonNull Intent intent, int i11, @Nullable Bundle bundle, boolean z10) {
        return PendingIntent.getActivity(context, i10, intent, addMutabilityFlags(z10, i11), bundle);
    }

    @SuppressLint({"LambdaLast"})
    public static void send(@NonNull PendingIntent pendingIntent, @NonNull @SuppressLint({"ContextFirst"}) Context context, int i10, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler) throws PendingIntent.CanceledException {
        send(pendingIntent, context, i10, intent, onFinished, handler, null, null);
    }

    @SuppressLint({"LambdaLast"})
    public static void send(@NonNull PendingIntent pendingIntent, @NonNull @SuppressLint({"ContextFirst"}) Context context, int i10, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler, @Nullable String str, @Nullable Bundle bundle) throws PendingIntent.CanceledException {
        GatedCallback gatedCallback = new GatedCallback(onFinished);
        try {
            Api23Impl.send(pendingIntent, context, i10, intent, onFinished, handler, str, bundle);
            gatedCallback.complete();
            gatedCallback.close();
        } catch (Throwable th) {
            try {
                gatedCallback.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
