package com.vungle.ads.internal.util;

import android.os.CountDownTimer;
import androidx.annotation.VisibleForTesting;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SuspendableTimer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class u {
    private final double durationSecs;
    private boolean isCanceled;
    private boolean isPaused;
    private double nextDurationSecs;

    @NotNull
    private final h9.a<k0> onFinish;

    @NotNull
    private final h9.a<k0> onTick;
    private final boolean repeats;
    private long startTimeMillis;

    @Nullable
    private CountDownTimer timer;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: compiled from: SuspendableTimer.kt */
    public static final class a extends kotlin.jvm.internal.v implements h9.a<k0> {
        public static final a INSTANCE = new a();

        a() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            invoke2();
            return k0.f35197a;
        }
    }

    /* JADX INFO: compiled from: SuspendableTimer.kt */
    public static final class b extends CountDownTimer {
        final /* synthetic */ u this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(long j10, u uVar) {
            super(j10, j10);
            this.this$0 = uVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            u uVar = this.this$0;
            uVar.onFinish.invoke();
            if (!uVar.repeats || uVar.isCanceled) {
                uVar.cancel();
            } else {
                uVar.setNextDurationSecs$vungle_ads_release(uVar.durationSecs);
                uVar.start();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            this.this$0.onTick.invoke();
        }
    }

    public u(double d10, boolean z10, @NotNull h9.a<k0> onTick, @NotNull h9.a<k0> onFinish) {
        kotlin.jvm.internal.t.i(onTick, "onTick");
        kotlin.jvm.internal.t.i(onFinish, "onFinish");
        this.durationSecs = d10;
        this.repeats = z10;
        this.onTick = onTick;
        this.onFinish = onFinish;
        this.nextDurationSecs = d10;
    }

    private final CountDownTimer createCountdown(long j10) {
        return new b(j10, this);
    }

    private final long getDurationMillis() {
        return (long) (this.durationSecs * ((double) 1000));
    }

    private final double getElapsedSecs() {
        return getElapsedMillis$vungle_ads_release() / ((long) 1000);
    }

    private final long getNextDurationMillis() {
        return (long) (this.nextDurationSecs * ((double) 1000));
    }

    public final void cancel() {
        this.isPaused = false;
        this.isCanceled = true;
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timer = null;
    }

    public final long getElapsedMillis$vungle_ads_release() {
        long jCurrentTimeMillis;
        long nextDurationMillis;
        if (this.isPaused) {
            jCurrentTimeMillis = getDurationMillis();
            nextDurationMillis = getNextDurationMillis();
        } else {
            jCurrentTimeMillis = System.currentTimeMillis();
            nextDurationMillis = this.startTimeMillis;
        }
        return jCurrentTimeMillis - nextDurationMillis;
    }

    public final double getNextDurationSecs$vungle_ads_release() {
        return this.nextDurationSecs;
    }

    public final long getStartTimeMillis$vungle_ads_release() {
        return this.startTimeMillis;
    }

    @Nullable
    public final CountDownTimer getTimer$vungle_ads_release() {
        return this.timer;
    }

    public final void pause() {
        if (this.timer == null) {
            return;
        }
        this.nextDurationSecs -= getElapsedSecs();
        this.isPaused = true;
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timer = null;
    }

    public final void reset() {
        cancel();
        start();
    }

    public final void resume() {
        if (this.isPaused) {
            this.isPaused = false;
            start();
        }
    }

    public final void setNextDurationSecs$vungle_ads_release(double d10) {
        this.nextDurationSecs = d10;
    }

    public final void setStartTimeMillis$vungle_ads_release(long j10) {
        this.startTimeMillis = j10;
    }

    public final void setTimer$vungle_ads_release(@Nullable CountDownTimer countDownTimer) {
        this.timer = countDownTimer;
    }

    public final void start() {
        this.startTimeMillis = System.currentTimeMillis();
        CountDownTimer countDownTimerCreateCountdown = createCountdown(getNextDurationMillis());
        this.timer = countDownTimerCreateCountdown;
        if (countDownTimerCreateCountdown != null) {
            countDownTimerCreateCountdown.start();
        }
    }

    public /* synthetic */ u(double d10, boolean z10, h9.a aVar, h9.a aVar2, int i10, kotlin.jvm.internal.k kVar) {
        this(d10, z10, (i10 & 4) != 0 ? a.INSTANCE : aVar, aVar2);
    }

    @VisibleForTesting
    public static /* synthetic */ void getElapsedMillis$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getNextDurationSecs$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getStartTimeMillis$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getTimer$vungle_ads_release$annotations() {
    }
}
