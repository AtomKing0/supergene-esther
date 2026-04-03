package o1;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ironsource.v8;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import y0.l;

/* JADX INFO: compiled from: Util.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f31808a = "0123456789abcdef".toCharArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f31809b = new char[64];

    /* JADX INFO: compiled from: Util.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f31810a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f31810a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31810a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31810a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31810a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31810a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static void a() {
        if (!p()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean b(@Nullable Object obj, @Nullable Object obj2) {
        return obj == null ? obj2 == null : obj instanceof l ? ((l) obj).a(obj2) : obj.equals(obj2);
    }

    public static boolean c(@Nullable Object obj, @Nullable Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    @NonNull
    private static String d(@NonNull byte[] bArr, @NonNull char[] cArr) {
        for (int i10 = 0; i10 < bArr.length; i10++) {
            int i11 = bArr[i10] & 255;
            int i12 = i10 * 2;
            char[] cArr2 = f31808a;
            cArr[i12] = cArr2[i11 >>> 4];
            cArr[i12 + 1] = cArr2[i11 & 15];
        }
        return new String(cArr);
    }

    @NonNull
    public static <T> Queue<T> e(int i10) {
        return new ArrayDeque(i10);
    }

    public static int f(int i10, int i11, @Nullable Bitmap.Config config) {
        return i10 * i11 * h(config);
    }

    @TargetApi(19)
    public static int g(@NonNull Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getHeight() * bitmap.getRowBytes();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + v8.i.f15837d + bitmap.getWidth() + ViewHierarchyNode.JsonKeys.X + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    private static int h(@Nullable Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i10 = a.f31810a[config.ordinal()];
        if (i10 == 1) {
            return 1;
        }
        if (i10 == 2 || i10 == 3) {
            return 2;
        }
        return i10 != 4 ? 4 : 8;
    }

    @NonNull
    public static <T> List<T> i(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t10 : collection) {
            if (t10 != null) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    public static int j(float f10) {
        return k(f10, 17);
    }

    public static int k(float f10, int i10) {
        return l(Float.floatToIntBits(f10), i10);
    }

    public static int l(int i10, int i11) {
        return (i11 * 31) + i10;
    }

    public static int m(@Nullable Object obj, int i10) {
        return l(obj == null ? 0 : obj.hashCode(), i10);
    }

    public static int n(boolean z10, int i10) {
        return l(z10 ? 1 : 0, i10);
    }

    public static boolean o() {
        return !p();
    }

    public static boolean p() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private static boolean q(int i10) {
        return i10 > 0 || i10 == Integer.MIN_VALUE;
    }

    public static boolean r(int i10, int i11) {
        return q(i10) && q(i11);
    }

    @NonNull
    public static String s(@NonNull byte[] bArr) {
        String strD;
        char[] cArr = f31809b;
        synchronized (cArr) {
            strD = d(bArr, cArr);
        }
        return strD;
    }
}
