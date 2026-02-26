package w0;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* JADX INFO: compiled from: MemorySizeCalculator.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f35299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f35300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f35301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f35302d;

    /* JADX INFO: compiled from: MemorySizeCalculator.java */
    public static final class a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        static final int f35303i;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f35304a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ActivityManager f35305b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        c f35306c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f35308e;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f35307d = 2.0f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        float f35309f = 0.4f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        float f35310g = 0.33f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f35311h = 4194304;

        static {
            f35303i = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public a(Context context) {
            this.f35308e = f35303i;
            this.f35304a = context;
            this.f35305b = (ActivityManager) context.getSystemService("activity");
            this.f35306c = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !i.e(this.f35305b)) {
                return;
            }
            this.f35308e = 0.0f;
        }

        public i a() {
            return new i(this);
        }
    }

    /* JADX INFO: compiled from: MemorySizeCalculator.java */
    private static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DisplayMetrics f35312a;

        b(DisplayMetrics displayMetrics) {
            this.f35312a = displayMetrics;
        }

        @Override // w0.i.c
        public int a() {
            return this.f35312a.heightPixels;
        }

        @Override // w0.i.c
        public int b() {
            return this.f35312a.widthPixels;
        }
    }

    /* JADX INFO: compiled from: MemorySizeCalculator.java */
    interface c {
        int a();

        int b();
    }

    i(a aVar) {
        this.f35301c = aVar.f35304a;
        int i10 = e(aVar.f35305b) ? aVar.f35311h / 2 : aVar.f35311h;
        this.f35302d = i10;
        int iC = c(aVar.f35305b, aVar.f35309f, aVar.f35310g);
        float fB = aVar.f35306c.b() * aVar.f35306c.a() * 4;
        int iRound = Math.round(aVar.f35308e * fB);
        int iRound2 = Math.round(fB * aVar.f35307d);
        int i11 = iC - i10;
        int i12 = iRound2 + iRound;
        if (i12 <= i11) {
            this.f35300b = iRound2;
            this.f35299a = iRound;
        } else {
            float f10 = i11;
            float f11 = aVar.f35308e;
            float f12 = aVar.f35307d;
            float f13 = f10 / (f11 + f12);
            this.f35300b = Math.round(f12 * f13);
            this.f35299a = Math.round(f13 * aVar.f35308e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(f(this.f35300b));
            sb.append(", pool size: ");
            sb.append(f(this.f35299a));
            sb.append(", byte array size: ");
            sb.append(f(i10));
            sb.append(", memory class limited? ");
            sb.append(i12 > iC);
            sb.append(", max size: ");
            sb.append(f(iC));
            sb.append(", memoryClass: ");
            sb.append(aVar.f35305b.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(e(aVar.f35305b));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    private static int c(ActivityManager activityManager, float f10, float f11) {
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (e(activityManager)) {
            f10 = f11;
        }
        return Math.round(memoryClass * f10);
    }

    @TargetApi(19)
    static boolean e(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    private String f(int i10) {
        return Formatter.formatFileSize(this.f35301c, i10);
    }

    public int a() {
        return this.f35302d;
    }

    public int b() {
        return this.f35299a;
    }

    public int d() {
        return this.f35300b;
    }
}
