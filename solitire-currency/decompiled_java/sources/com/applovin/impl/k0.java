package com.applovin.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.StrictMode;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.RoundedCorner;
import android.view.WindowManager;
import com.applovin.sdk.AppLovinSdkUtils;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map f5522a = new HashMap(2);

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f5523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f5524b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f5525c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f5526d;

        /* JADX INFO: renamed from: com.applovin.impl.k0$a$a, reason: collision with other inner class name */
        public static class C0162a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f5527a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f5528b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f5529c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f5530d;

            C0162a() {
            }

            public C0162a a(int i10) {
                this.f5529c = i10;
                return this;
            }

            public C0162a b(int i10) {
                this.f5530d = i10;
                return this;
            }

            public C0162a c(int i10) {
                this.f5527a = i10;
                return this;
            }

            public C0162a d(int i10) {
                this.f5528b = i10;
                return this;
            }

            public String toString() {
                return "CompatibilityUtils.ScreenCornerRadii.ScreenCornerRadiiBuilder(topLeft=" + this.f5527a + ", topRight=" + this.f5528b + ", bottomLeft=" + this.f5529c + ", bottomRight=" + this.f5530d + ")";
            }

            public a a() {
                return new a(this.f5527a, this.f5528b, this.f5529c, this.f5530d);
            }
        }

        a(int i10, int i11, int i12, int i13) {
            this.f5523a = i10;
            this.f5524b = i11;
            this.f5525c = i12;
            this.f5526d = i13;
        }

        protected boolean a(Object obj) {
            return obj instanceof a;
        }

        public int b() {
            return this.f5526d;
        }

        public int c() {
            return this.f5523a;
        }

        public int d() {
            return this.f5524b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return aVar.a(this) && c() == aVar.c() && d() == aVar.d() && a() == aVar.a() && b() == aVar.b();
        }

        public int hashCode() {
            return ((((((c() + 59) * 59) + d()) * 59) + a()) * 59) + b();
        }

        public String toString() {
            return "CompatibilityUtils.ScreenCornerRadii(topLeft=" + c() + ", topRight=" + d() + ", bottomLeft=" + a() + ", bottomRight=" + b() + ")";
        }

        public int a() {
            return this.f5525c;
        }
    }

    public static void a() {
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        } catch (Throwable unused) {
        }
    }

    public static Point b(Context context) {
        int orientation = AppLovinSdkUtils.getOrientation(context);
        com.applovin.impl.sdk.j jVar = com.applovin.impl.sdk.j.f7084v0;
        boolean z10 = jVar == null || ((Boolean) jVar.a(l4.S5)).booleanValue();
        if (!c(context) || z10) {
            Map map = f5522a;
            if (map.containsKey(Integer.valueOf(orientation))) {
                return (Point) map.get(Integer.valueOf(orientation));
            }
        }
        Point point = new Point();
        point.x = 480;
        point.y = Sdk$SDKError.b.WEBVIEW_ERROR_VALUE;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            if (b()) {
                Rect bounds = windowManager.getMaximumWindowMetrics().getBounds();
                point = new Point(bounds.width(), bounds.height());
            } else {
                defaultDisplay.getRealSize(point);
            }
        }
        StrictMode.setVmPolicy(vmPolicy);
        f5522a.put(Integer.valueOf(orientation), point);
        return point;
    }

    public static boolean c(Context context) {
        PackageManager packageManager = context.getPackageManager();
        return packageManager.hasSystemFeature("android.hardware.type.foldable") || packageManager.hasSystemFeature("android.hardware.sensor.hinge_angle");
    }

    public static boolean d() {
        return true;
    }

    public static boolean e() {
        return true;
    }

    public static boolean f() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean g() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean h() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static boolean i() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static boolean j() {
        return Build.VERSION.SDK_INT >= 33;
    }

    public static boolean k() {
        return Build.VERSION.SDK_INT >= 31;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 34;
    }

    public static Point a(Context context) {
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        Point point = new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
        StrictMode.setVmPolicy(vmPolicy);
        return point;
    }

    public static a a(Context context, com.applovin.impl.sdk.j jVar) {
        a aVarA = null;
        if (((Boolean) jVar.a(l4.I3)).booleanValue() && k()) {
            StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
            StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                try {
                    Display defaultDisplay = windowManager.getDefaultDisplay();
                    aVarA = new a.C0162a().c(a(0, defaultDisplay)).d(a(1, defaultDisplay)).a(a(3, defaultDisplay)).b(a(2, defaultDisplay)).a();
                } catch (Throwable unused) {
                }
            }
            StrictMode.setVmPolicy(vmPolicy);
        }
        return aVarA;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 30;
    }

    private static int a(int i10, Display display) {
        RoundedCorner roundedCorner = display.getRoundedCorner(i10);
        if (roundedCorner != null) {
            return roundedCorner.getRadius();
        }
        return -1;
    }

    public static boolean a(String str, Context context) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
