package io.sentry.android.core;

import android.app.Activity;
import android.graphics.Bitmap;
import androidx.media3.common.MimeTypes;
import androidx.media3.exoplayer.ExoPlayer;
import io.sentry.SentryLevel;
import io.sentry.protocol.SentryTransaction;
import io.sentry.r6;
import java.util.concurrent.Callable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class ScreenshotEventProcessor implements io.sentry.g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final SentryAndroidOptions f27075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final w0 f27076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final io.sentry.android.core.internal.util.h f27077c = new io.sentry.android.core.internal.util.h(io.sentry.android.core.internal.util.b.b(), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, 3);

    public ScreenshotEventProcessor(@NotNull SentryAndroidOptions sentryAndroidOptions, @NotNull w0 w0Var) {
        this.f27075a = (SentryAndroidOptions) io.sentry.util.w.c(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f27076b = (w0) io.sentry.util.w.c(w0Var, "BuildInfoProvider is required");
        if (sentryAndroidOptions.isAttachScreenshot()) {
            io.sentry.util.p.a("Screenshot");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ byte[] d(Bitmap bitmap) throws Exception {
        return io.sentry.android.core.internal.util.r.d(bitmap, this.f27075a.getLogger());
    }

    @Override // io.sentry.g0
    @NotNull
    public r6 a(@NotNull r6 r6Var, @NotNull io.sentry.l0 l0Var) {
        final Bitmap bitmapC;
        if (!r6Var.s()) {
            return r6Var;
        }
        if (!this.f27075a.isAttachScreenshot()) {
            this.f27075a.getLogger().c(SentryLevel.DEBUG, "attachScreenshot is disabled.", new Object[0]);
            return r6Var;
        }
        Activity activityB = f1.c().b();
        if (activityB != null && !io.sentry.util.m.i(l0Var)) {
            boolean zA = this.f27077c.a();
            this.f27075a.getBeforeScreenshotCaptureCallback();
            if (zA || (bitmapC = io.sentry.android.core.internal.util.r.c(activityB, this.f27075a.getThreadChecker(), this.f27075a.getLogger(), this.f27076b)) == null) {
                return r6Var;
            }
            l0Var.k(io.sentry.b.a(new Callable() { // from class: io.sentry.android.core.b2
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f27124a.d(bitmapC);
                }
            }, "screenshot.png", MimeTypes.IMAGE_PNG, false));
            l0Var.j("android:activity", activityB);
        }
        return r6Var;
    }

    @Override // io.sentry.g0
    @Nullable
    public Long getOrder() {
        return 10000L;
    }

    @Override // io.sentry.g0
    @NotNull
    public SentryTransaction c(@NotNull SentryTransaction sentryTransaction, @NotNull io.sentry.l0 l0Var) {
        return sentryTransaction;
    }
}
