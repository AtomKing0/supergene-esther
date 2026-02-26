package io.sentry.android.core.internal.gestures;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.Window;
import androidx.core.view.GestureDetectorCompat;
import io.sentry.SentryOptions;
import io.sentry.q8;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SentryWindowCallback.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class h extends k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Window.Callback f27259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final g f27260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final GestureDetectorCompat f27261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final SentryOptions f27262e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final b f27263f;

    /* JADX INFO: compiled from: SentryWindowCallback.java */
    class a implements b {
        a() {
        }

        @Override // io.sentry.android.core.internal.gestures.h.b
        public /* synthetic */ MotionEvent a(MotionEvent motionEvent) {
            return i.a(this, motionEvent);
        }
    }

    /* JADX INFO: compiled from: SentryWindowCallback.java */
    interface b {
        @NotNull
        MotionEvent a(@NotNull MotionEvent motionEvent);
    }

    public h(@NotNull Window.Callback callback, @NotNull Context context, @NotNull g gVar, @Nullable SentryOptions sentryOptions) {
        this(callback, new GestureDetectorCompat(context, gVar, new Handler(Looper.getMainLooper())), gVar, sentryOptions, new a());
    }

    private void b(@NotNull MotionEvent motionEvent) {
        this.f27261d.onTouchEvent(motionEvent);
        if (motionEvent.getActionMasked() == 1) {
            this.f27260c.o(motionEvent);
        }
    }

    @NotNull
    public Window.Callback a() {
        return this.f27259b;
    }

    public void c() {
        this.f27260c.q(q8.CANCELLED);
    }

    @Override // io.sentry.android.core.internal.gestures.k, android.view.Window.Callback
    public boolean dispatchTouchEvent(@Nullable MotionEvent motionEvent) {
        if (motionEvent != null) {
            try {
                b(this.f27263f.a(motionEvent));
            } finally {
                try {
                } finally {
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    h(@NotNull Window.Callback callback, @NotNull GestureDetectorCompat gestureDetectorCompat, @NotNull g gVar, @Nullable SentryOptions sentryOptions, @NotNull b bVar) {
        super(callback);
        this.f27259b = callback;
        this.f27260c = gVar;
        this.f27262e = sentryOptions;
        this.f27261d = gestureDetectorCompat;
        this.f27263f = bVar;
    }
}
