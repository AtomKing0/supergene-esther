package a0;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.ironsource.v8;
import ga.u;
import java.io.Closeable;
import java.io.File;
import kotlin.collections.d0;
import n.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q.b;
import v.v;
import w.c;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Bitmap.Config[] f40a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Bitmap.Config f41b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final ga.u f42c;

    /* JADX INFO: compiled from: Utils.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f43a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f44b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f45c;

        static {
            int[] iArr = new int[m.f.values().length];
            iArr[m.f.MEMORY_CACHE.ordinal()] = 1;
            iArr[m.f.MEMORY.ordinal()] = 2;
            iArr[m.f.DISK.ordinal()] = 3;
            iArr[m.f.NETWORK.ordinal()] = 4;
            f43a = iArr;
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            iArr2[ImageView.ScaleType.FIT_START.ordinal()] = 1;
            iArr2[ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
            iArr2[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            iArr2[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 4;
            f44b = iArr2;
            int[] iArr3 = new int[w.h.values().length];
            iArr3[w.h.FILL.ordinal()] = 1;
            iArr3[w.h.FIT.ordinal()] = 2;
            f45c = iArr3;
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        f40a = i10 >= 26 ? new Bitmap.Config[]{Bitmap.Config.ARGB_8888, Bitmap.Config.RGBA_F16} : new Bitmap.Config[]{Bitmap.Config.ARGB_8888};
        f41b = i10 >= 26 ? Bitmap.Config.HARDWARE : Bitmap.Config.ARGB_8888;
        f42c = new u.a().f();
    }

    public static final void a(@NotNull a.b bVar) {
        try {
            bVar.a();
        } catch (Exception unused) {
        }
    }

    @NotNull
    public static final u.a b(@NotNull u.a aVar, @NotNull String str) {
        int iD0 = p9.r.d0(str, ':', 0, false, 6, null);
        if (!(iD0 != -1)) {
            throw new IllegalArgumentException(("Unexpected header: " + str).toString());
        }
        String strSubstring = str.substring(0, iD0);
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        String string = p9.r.b1(strSubstring).toString();
        String strSubstring2 = str.substring(iD0 + 1);
        kotlin.jvm.internal.t.h(strSubstring2, "this as java.lang.String).substring(startIndex)");
        aVar.e(string, strSubstring2);
        return aVar;
    }

    public static final int c(@NotNull Context context, double d10) {
        int largeMemoryClass;
        try {
            Object systemService = ContextCompat.getSystemService(context, ActivityManager.class);
            kotlin.jvm.internal.t.f(systemService);
            ActivityManager activityManager = (ActivityManager) systemService;
            largeMemoryClass = (context.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass();
        } catch (Exception unused) {
            largeMemoryClass = 256;
        }
        double d11 = 1024;
        return (int) (d10 * ((double) largeMemoryClass) * d11 * d11);
    }

    public static final void d(@NotNull Closeable closeable) {
        try {
            closeable.close();
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception unused) {
        }
    }

    public static final double e(@NotNull Context context) {
        try {
            Object systemService = ContextCompat.getSystemService(context, ActivityManager.class);
            kotlin.jvm.internal.t.f(systemService);
            return ((ActivityManager) systemService).isLowRamDevice() ? 0.15d : 0.2d;
        } catch (Exception unused) {
            return 0.2d;
        }
    }

    @NotNull
    public static final Bitmap.Config f() {
        return f41b;
    }

    @NotNull
    public static final j.c g(@NotNull b.a aVar) {
        return aVar instanceof q.c ? ((q.c) aVar).d() : j.c.f28547b;
    }

    @Nullable
    public static final String h(@NotNull Uri uri) {
        return (String) d0.k0(uri.getPathSegments());
    }

    public static final int i(@NotNull Drawable drawable) {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        return (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) ? drawable.getIntrinsicHeight() : bitmap.getHeight();
    }

    @Nullable
    public static final String j(@NotNull MimeTypeMap mimeTypeMap, @Nullable String str) {
        if (str == null || p9.q.z(str)) {
            return null;
        }
        return mimeTypeMap.getMimeTypeFromExtension(p9.r.O0(p9.r.Q0(p9.r.Y0(p9.r.Y0(str, '#', null, 2, null), '?', null, 2, null), '/', null, 2, null), '.', ""));
    }

    public static final int k(@NotNull Configuration configuration) {
        return configuration.uiMode & 48;
    }

    @NotNull
    public static final v l(@NotNull View view) {
        int i10 = k.a.f28885a;
        Object tag = view.getTag(i10);
        v vVar = tag instanceof v ? (v) tag : null;
        if (vVar == null) {
            synchronized (view) {
                Object tag2 = view.getTag(i10);
                v vVar2 = tag2 instanceof v ? (v) tag2 : null;
                if (vVar2 != null) {
                    vVar = vVar2;
                } else {
                    vVar = new v(view);
                    view.addOnAttachStateChangeListener(vVar);
                    view.setTag(i10, vVar);
                }
            }
        }
        return vVar;
    }

    @NotNull
    public static final File m(@NotNull Context context) {
        File cacheDir = context.getCacheDir();
        cacheDir.mkdirs();
        return cacheDir;
    }

    @NotNull
    public static final w.h n(@NotNull ImageView imageView) {
        ImageView.ScaleType scaleType = imageView.getScaleType();
        int i10 = scaleType == null ? -1 : a.f44b[scaleType.ordinal()];
        return (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) ? w.h.FIT : w.h.FILL;
    }

    @NotNull
    public static final Bitmap.Config[] o() {
        return f40a;
    }

    public static final int p(@NotNull Drawable drawable) {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        return (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) ? drawable.getIntrinsicWidth() : bitmap.getWidth();
    }

    public static final boolean q(@NotNull Uri uri) {
        return kotlin.jvm.internal.t.d(uri.getScheme(), v8.h.f15781b) && kotlin.jvm.internal.t.d(h(uri), "android_asset");
    }

    public static final boolean r() {
        return kotlin.jvm.internal.t.d(Looper.myLooper(), Looper.getMainLooper());
    }

    public static final boolean s(int i10) {
        return i10 == Integer.MIN_VALUE || i10 == Integer.MAX_VALUE;
    }

    public static final boolean t(@NotNull b.a aVar) {
        return (aVar instanceof q.c) && ((q.c) aVar).e();
    }

    public static final boolean u(@NotNull Drawable drawable) {
        return (drawable instanceof VectorDrawable) || (drawable instanceof VectorDrawableCompat);
    }

    @NotNull
    public static final ga.u v(@Nullable ga.u uVar) {
        return uVar == null ? f42c : uVar;
    }

    @NotNull
    public static final v.o w(@Nullable v.o oVar) {
        return oVar == null ? v.o.f34955c : oVar;
    }

    @NotNull
    public static final v.s x(@Nullable v.s sVar) {
        return sVar == null ? v.s.f34971c : sVar;
    }

    public static final int y(@NotNull String str, int i10) {
        Long lN = p9.p.n(str);
        if (lN == null) {
            return i10;
        }
        long jLongValue = lN.longValue();
        if (jLongValue > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (jLongValue < 0) {
            return 0;
        }
        return (int) jLongValue;
    }

    public static final int z(@NotNull w.c cVar, @NotNull w.h hVar) {
        if (cVar instanceof c.a) {
            return ((c.a) cVar).f35260a;
        }
        int i10 = a.f45c[hVar.ordinal()];
        if (i10 == 1) {
            return Integer.MIN_VALUE;
        }
        if (i10 == 2) {
            return Integer.MAX_VALUE;
        }
        throw new v8.q();
    }
}
