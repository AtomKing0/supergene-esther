package com.applovin.impl;

import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.PixelCopy;
import android.view.View;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f4991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f4992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f4993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f4994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f4995e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f4996f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f4997g;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Handler f5001k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private HandlerThread f5002l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private c f5004n;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private WeakReference f4998h = new WeakReference(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f4999i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Integer f5000j = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Runnable f5003m = new Runnable() { // from class: com.applovin.impl.c9
        @Override // java.lang.Runnable
        public final void run() {
            this.f4967a.a();
        }
    };

    class b implements PixelCopy.OnPixelCopyFinishedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f5006a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bitmap f5007b;

        b(d dVar, Bitmap bitmap) {
            this.f5006a = dVar;
            this.f5007b = bitmap;
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public void onPixelCopyFinished(int i10) {
            if (i10 == 0) {
                this.f5006a.a(this.f5007b);
                return;
            }
            com.applovin.impl.sdk.n unused = d0.this.f4992b;
            if (com.applovin.impl.sdk.n.a()) {
                d0.this.f4992b.b("BlackViewDetector", "Failed to capture screenshot with error code: " + i10);
            }
            this.f5006a.a(true);
        }
    }

    public interface c {
        void a(View view);
    }

    private interface d {
        void a(Bitmap bitmap);

        void a(boolean z10);
    }

    public d0(com.applovin.impl.sdk.j jVar) {
        this.f4991a = jVar;
        this.f4992b = jVar.I();
        this.f4993c = ((Long) jVar.a(l4.f5791z5)).longValue();
        this.f4994d = ((Long) jVar.a(l4.f5784y5)).longValue();
        this.f4995e = ((Integer) jVar.a(l4.A5)).intValue();
        this.f4996f = ((Integer) jVar.a(l4.B5)).intValue();
        this.f4997g = ((Integer) jVar.a(l4.C5)).intValue();
    }

    static /* synthetic */ int e(d0 d0Var) {
        int i10 = d0Var.f4999i;
        d0Var.f4999i = i10 + 1;
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        this.f5004n = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        long j10 = this.f4993c;
        if (j10 <= 0) {
            if (this.f4999i == 1) {
                e();
            }
            g();
        } else {
            if (this.f4999i > 1) {
                e();
                g();
                return;
            }
            Handler handler = this.f5001k;
            if (handler != null) {
                handler.postDelayed(this.f5003m, j10);
                return;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f4992b.k("BlackViewDetector", "Monitoring handler was unexpectedly null");
            }
            g();
        }
    }

    private void e() {
        final View view = (View) this.f4998h.get();
        if (com.applovin.impl.sdk.n.a()) {
            this.f4992b.k("BlackViewDetector", "Detected black view: " + view);
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.b9
            @Override // java.lang.Runnable
            public final void run() {
                this.f4916a.a(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f4999i = 0;
        this.f5000j = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f4998h.get() != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f4992b.a("BlackViewDetector", "Stopped monitoring view: " + this.f4998h.get());
            }
            this.f4998h.clear();
        }
        Handler handler = this.f5001k;
        if (handler != null) {
            handler.removeCallbacks(this.f5003m);
            this.f5001k = null;
        }
        if (this.f5004n != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.a9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f4736a.c();
                }
            });
        }
    }

    public void b() {
        g();
        HandlerThread handlerThread = this.f5002l;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f5002l = null;
        }
    }

    public void a(View view, c cVar) {
        if (((Boolean) this.f4991a.a(l4.f5777x5)).booleanValue()) {
            View view2 = (View) this.f4998h.get();
            if (view2 != null) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f4992b.k("BlackViewDetector", "Monitoring is already in progress for a view: " + view2);
                    return;
                }
                return;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f4992b.a("BlackViewDetector", "Started monitoring view: " + view);
            }
            try {
                if (this.f5002l == null) {
                    HandlerThread handlerThread = new HandlerThread("AppLovinSdk:black_view_detector");
                    this.f5002l = handlerThread;
                    handlerThread.start();
                } else {
                    this.f4991a.A().a(y1.f7786i0, "BlackViewDetector:maybeStartMonitoring() unexpectedly called multiple times");
                    g();
                }
                this.f5004n = cVar;
                this.f4998h = new WeakReference(view);
                f();
                Handler handler = new Handler(this.f5002l.getLooper());
                this.f5001k = handler;
                handler.postDelayed(this.f5003m, this.f4994d);
            } catch (Throwable th) {
                g();
                this.f4991a.A().a("BlackViewDetector", "maybeStartMonitoring", th);
            }
        }
    }

    class a implements d {
        a() {
        }

        @Override // com.applovin.impl.d0.d
        public void a(Bitmap bitmap) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int i10 = width / d0.this.f4995e;
                int i11 = height / d0.this.f4995e;
                int i12 = i10 / 2;
                for (int i13 = i11 / 2; i13 < height; i13 += i11) {
                    for (int i14 = i12; i14 < width; i14 += i10) {
                        int pixel = bitmap.getPixel(i14, i13);
                        if (d0.this.a(pixel)) {
                            bitmap.recycle();
                            d0.this.f();
                            d0.this.d();
                            return;
                        }
                        if (d0.this.f5000j == null) {
                            d0.this.f5000j = Integer.valueOf(pixel);
                        }
                    }
                }
                d0.e(d0.this);
                bitmap.recycle();
                d0.this.d();
            } catch (Exception e10) {
                d0.this.f4991a.A().a("BlackViewDetector", "onScreenshotCaptured", e10);
                d0.this.g();
            }
        }

        @Override // com.applovin.impl.d0.d
        public void a(boolean z10) {
            if (z10) {
                d0.this.g();
            } else {
                d0.this.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        ActivityManager.MemoryInfo memoryInfoA;
        View view = (View) this.f4998h.get();
        if (view == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f4992b.k("BlackViewDetector", "Monitored view no longer exists.");
            }
            g();
            return;
        }
        Long l10 = (Long) this.f4991a.a(l4.G5);
        if (l10.longValue() > 0 && (memoryInfoA = z6.a((ActivityManager) com.applovin.impl.sdk.j.n().getSystemService("activity"))) != null && memoryInfoA.availMem < l10.longValue()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f4992b.k("BlackViewDetector", "Cancelling black view detection due to low memory");
                return;
            }
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f4992b.a("BlackViewDetector", "Checking for black view: " + view);
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (measuredWidth != 0 && measuredHeight != 0) {
            a(view, new a());
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f4992b.k("BlackViewDetector", "Monitored view is not visible due to dimensions (width = " + measuredWidth + ", height = " + measuredHeight + ")");
        }
        f();
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        c cVar = this.f5004n;
        if (cVar != null) {
            cVar.a(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(int r9) {
        /*
            r8 = this;
            int r0 = android.graphics.Color.red(r9)
            int r1 = android.graphics.Color.green(r9)
            int r9 = android.graphics.Color.blue(r9)
            java.lang.Integer r2 = r8.f5000j
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L4e
            int r2 = r2.intValue()
            int r2 = android.graphics.Color.red(r2)
            java.lang.Integer r5 = r8.f5000j
            int r5 = r5.intValue()
            int r5 = android.graphics.Color.green(r5)
            java.lang.Integer r6 = r8.f5000j
            int r6 = r6.intValue()
            int r6 = android.graphics.Color.blue(r6)
            int r2 = r0 - r2
            int r2 = java.lang.Math.abs(r2)
            int r7 = r8.f4997g
            if (r2 > r7) goto L4c
            int r2 = r1 - r5
            int r2 = java.lang.Math.abs(r2)
            int r5 = r8.f4997g
            if (r2 > r5) goto L4c
            int r2 = r9 - r6
            int r2 = java.lang.Math.abs(r2)
            int r5 = r8.f4997g
            if (r2 <= r5) goto L4e
        L4c:
            r2 = r3
            goto L4f
        L4e:
            r2 = r4
        L4f:
            int r5 = r8.f4996f
            if (r0 > r5) goto L5b
            if (r1 > r5) goto L5b
            if (r9 > r5) goto L5b
            if (r2 == 0) goto L5a
            goto L5b
        L5a:
            r3 = r4
        L5b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.d0.a(int):boolean");
    }

    private void a(View view, d dVar) {
        if (Build.VERSION.SDK_INT >= 26) {
            Activity activityA = this.f4991a.e().a();
            if (activityA == null) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f4992b.b("BlackViewDetector", "Failed to capture screenshot due to no active activity");
                }
                dVar.a(false);
                return;
            }
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int i10 = iArr[0];
            int i11 = iArr[1];
            Rect rect = new Rect(i10, i11, i10 + measuredWidth, i11 + measuredHeight);
            try {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
                PixelCopy.request(activityA.getWindow(), rect, bitmapCreateBitmap, new b(dVar, bitmapCreateBitmap), new Handler());
                return;
            } catch (Throwable th) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f4992b.b("BlackViewDetector", "Failed to capture screenshot due to exception: " + th);
                }
                dVar.a(true);
                return;
            }
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f4992b.k("BlackViewDetector", "Unable to capture screenshots on views below API 26");
        }
        dVar.a(true);
    }
}
