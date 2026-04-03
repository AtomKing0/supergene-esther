package k2;

import android.annotation.SuppressLint;
import androidx.media3.exoplayer.RendererCapabilities;

/* JADX INFO: compiled from: RendererCapabilities.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b3 {
    public static int a(int i10) {
        return b(i10, 0, 0);
    }

    public static int b(int i10, int i11, int i12) {
        return c(i10, i11, i12, 0, 128);
    }

    @SuppressLint({"WrongConstant"})
    public static int c(int i10, int i11, int i12, int i13, int i14) {
        return i10 | i11 | i12 | i13 | i14;
    }

    @SuppressLint({"WrongConstant"})
    public static int d(int i10) {
        return i10 & 24;
    }

    @SuppressLint({"WrongConstant"})
    public static int e(int i10) {
        return i10 & RendererCapabilities.DECODER_SUPPORT_MASK;
    }

    @SuppressLint({"WrongConstant"})
    public static int f(int i10) {
        return i10 & 7;
    }

    @SuppressLint({"WrongConstant"})
    public static int g(int i10) {
        return i10 & 64;
    }

    @SuppressLint({"WrongConstant"})
    public static int h(int i10) {
        return i10 & 32;
    }
}
