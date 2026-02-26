package t0;

import android.net.Uri;
import com.ironsource.v8;

/* JADX INFO: compiled from: MediaStoreUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static boolean a(Uri uri) {
        return b(uri) && !e(uri);
    }

    public static boolean b(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && v8.h.I0.equals(uri.getAuthority());
    }

    public static boolean c(Uri uri) {
        return b(uri) && e(uri);
    }

    public static boolean d(int i10, int i11) {
        return i10 != Integer.MIN_VALUE && i11 != Integer.MIN_VALUE && i10 <= 512 && i11 <= 384;
    }

    private static boolean e(Uri uri) {
        return uri.getPathSegments().contains("video");
    }
}
