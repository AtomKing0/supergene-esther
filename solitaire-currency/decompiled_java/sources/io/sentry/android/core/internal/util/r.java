package io.sentry.android.core.internal.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.PixelCopy;
import android.view.View;
import android.view.Window;
import androidx.annotation.Nullable;
import io.sentry.SentryLevel;
import io.sentry.w0;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ScreenshotUtils.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public class r {
    @Nullable
    @SuppressLint({"NewApi"})
    public static Bitmap c(@NotNull Activity activity, @NotNull io.sentry.util.thread.a aVar, @NotNull final w0 w0Var, @NotNull io.sentry.android.core.w0 w0Var2) {
        boolean z10 = false;
        if (!e(activity)) {
            w0Var.c(SentryLevel.DEBUG, "Activity isn't valid, not taking screenshot.", new Object[0]);
            return null;
        }
        Window window = activity.getWindow();
        if (window == null) {
            w0Var.c(SentryLevel.DEBUG, "Activity window is null, not taking screenshot.", new Object[0]);
            return null;
        }
        View viewPeekDecorView = window.peekDecorView();
        if (viewPeekDecorView == null) {
            w0Var.c(SentryLevel.DEBUG, "DecorView is null, not taking screenshot.", new Object[0]);
            return null;
        }
        final View rootView = viewPeekDecorView.getRootView();
        if (rootView == null) {
            w0Var.c(SentryLevel.DEBUG, "Root view is null, not taking screenshot.", new Object[0]);
            return null;
        }
        if (rootView.getWidth() <= 0 || rootView.getHeight() <= 0) {
            w0Var.c(SentryLevel.DEBUG, "View's width and height is zeroed, not taking screenshot.", new Object[0]);
            return null;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(rootView.getWidth(), rootView.getHeight(), Bitmap.Config.ARGB_8888);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            if (w0Var2.d() >= 26) {
                HandlerThread handlerThread = new HandlerThread("SentryScreenshot");
                handlerThread.start();
                try {
                    Handler handler = new Handler(handlerThread.getLooper());
                    final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                    PixelCopy.request(window, bitmapCreateBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: io.sentry.android.core.internal.util.p
                        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                        public final void onPixelCopyFinished(int i10) {
                            r.f(atomicBoolean, countDownLatch, i10);
                        }
                    }, handler);
                    if (countDownLatch.await(1000L, TimeUnit.MILLISECONDS)) {
                        if (atomicBoolean.get()) {
                            z10 = true;
                        }
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
                if (!z10) {
                    return null;
                }
            } else {
                final Canvas canvas = new Canvas(bitmapCreateBitmap);
                if (aVar.a()) {
                    rootView.draw(canvas);
                    countDownLatch.countDown();
                } else {
                    activity.runOnUiThread(new Runnable() { // from class: io.sentry.android.core.internal.util.q
                        @Override // java.lang.Runnable
                        public final void run() {
                            r.g(rootView, canvas, w0Var, countDownLatch);
                        }
                    });
                }
                if (!countDownLatch.await(1000L, TimeUnit.MILLISECONDS)) {
                    return null;
                }
            }
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            w0Var.b(SentryLevel.ERROR, "Taking screenshot failed.", th);
            return null;
        }
    }

    @Nullable
    public static byte[] d(@Nullable Bitmap bitmap, @NotNull w0 w0Var) {
        if (bitmap != null && !bitmap.isRecycled()) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                    bitmap.recycle();
                    if (byteArrayOutputStream.size() <= 0) {
                        w0Var.c(SentryLevel.DEBUG, "Screenshot is 0 bytes, not attaching the image.", new Object[0]);
                        byteArrayOutputStream.close();
                        return null;
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                } finally {
                }
            } catch (Throwable th) {
                w0Var.b(SentryLevel.ERROR, "Compressing bitmap failed.", th);
            }
        }
        return null;
    }

    private static boolean e(@NotNull Activity activity) {
        return (activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(AtomicBoolean atomicBoolean, CountDownLatch countDownLatch, int i10) {
        atomicBoolean.set(i10 == 0);
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(View view, Canvas canvas, w0 w0Var, CountDownLatch countDownLatch) {
        try {
            view.draw(canvas);
        } finally {
            try {
            } finally {
            }
        }
    }
}
