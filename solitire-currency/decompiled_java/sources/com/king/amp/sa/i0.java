package com.king.amp.sa;

import android.animation.TimeInterpolator;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.animation.LinearInterpolator;

/* JADX INFO: compiled from: AbmSafeValueAnimator.java */
/* JADX INFO: loaded from: classes4.dex */
public class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f16768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TimeInterpolator f16769d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c f16770e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final b f16771f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f16772g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f16773h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f16774i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f16775j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f16776k = 0.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Handler f16777l = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Runnable f16778m = new a();

    /* JADX INFO: compiled from: AbmSafeValueAnimator.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!i0.this.f16772g || i0.this.f16773h) {
                return;
            }
            float fMin = Math.min(1.0f, (SystemClock.uptimeMillis() - i0.this.f16774i) / i0.this.f16768c);
            float interpolation = i0.this.f16769d.getInterpolation(fMin);
            i0.this.f16776k = r3.f16766a + ((i0.this.f16767b - i0.this.f16766a) * interpolation);
            if (i0.this.f16770e != null) {
                i0.this.f16770e.a(i0.this.f16776k);
            }
            if (fMin < 1.0f) {
                i0.this.f16777l.postDelayed(this, 16L);
                return;
            }
            i0.this.f16772g = false;
            if (i0.this.f16771f != null) {
                i0.this.f16771f.a();
            }
        }
    }

    /* JADX INFO: compiled from: AbmSafeValueAnimator.java */
    public interface b {
        void a();
    }

    /* JADX INFO: compiled from: AbmSafeValueAnimator.java */
    public interface c {
        void a(float f10);
    }

    public i0(int i10, int i11, long j10, TimeInterpolator timeInterpolator, c cVar, b bVar) {
        this.f16766a = i10;
        this.f16767b = i11;
        this.f16768c = j10;
        this.f16769d = timeInterpolator == null ? new LinearInterpolator() : timeInterpolator;
        this.f16770e = cVar;
        this.f16771f = bVar;
    }

    public void n() {
        this.f16772g = false;
        this.f16773h = false;
        this.f16777l.removeCallbacks(this.f16778m);
    }

    public long o() {
        long jUptimeMillis;
        long j10;
        if (!this.f16772g) {
            return 0L;
        }
        if (this.f16773h) {
            jUptimeMillis = this.f16775j;
            j10 = this.f16774i;
        } else {
            jUptimeMillis = SystemClock.uptimeMillis();
            j10 = this.f16774i;
        }
        return jUptimeMillis - j10;
    }

    public boolean p() {
        return this.f16772g;
    }

    public boolean q() {
        return this.f16772g || this.f16773h;
    }

    public void r() {
        if (!this.f16772g || this.f16773h) {
            return;
        }
        this.f16773h = true;
        this.f16775j = SystemClock.uptimeMillis();
    }

    public void s() {
        if (this.f16772g && this.f16773h) {
            this.f16774i += SystemClock.uptimeMillis() - this.f16775j;
            this.f16773h = false;
            this.f16777l.post(this.f16778m);
        }
    }

    public void t(long j10) {
        this.f16774i = SystemClock.uptimeMillis() - j10;
        float interpolation = this.f16769d.getInterpolation(Math.min(1.0f, j10 / this.f16768c));
        float f10 = this.f16766a + ((this.f16767b - r4) * interpolation);
        this.f16776k = f10;
        c cVar = this.f16770e;
        if (cVar != null) {
            cVar.a(f10);
        }
        if (this.f16773h || !this.f16772g) {
            return;
        }
        this.f16777l.removeCallbacks(this.f16778m);
        this.f16777l.postDelayed(this.f16778m, 16L);
    }

    public void u(int i10, int i11) {
        this.f16766a = i10;
        this.f16767b = i11;
    }

    public void v() {
        if (this.f16772g) {
            return;
        }
        this.f16772g = true;
        this.f16773h = false;
        this.f16774i = SystemClock.uptimeMillis();
        this.f16777l.post(this.f16778m);
    }
}
