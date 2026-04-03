package a4;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.opengl.Matrix;
import androidx.work.Data;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: compiled from: GlUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f211a = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f212b = {12352, 4, 12324, 10, 12323, 10, 12322, 10, 12321, 2, 12325, 0, 12326, 0, 12344};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f213c = {12344};

    /* JADX INFO: compiled from: GlUtil.java */
    public static final class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public static void a(int i10, int i11) throws a {
        GLES20.glBindTexture(i10, i11);
        b();
        GLES20.glTexParameteri(i10, Data.MAX_DATA_BYTES, 9729);
        b();
        GLES20.glTexParameteri(i10, 10241, 9729);
        b();
        GLES20.glTexParameteri(i10, 10242, 33071);
        b();
        GLES20.glTexParameteri(i10, 10243, 33071);
        b();
    }

    public static void b() throws a {
        StringBuilder sb = new StringBuilder();
        boolean z10 = false;
        while (true) {
            int iGlGetError = GLES20.glGetError();
            if (iGlGetError == 0) {
                break;
            }
            if (z10) {
                sb.append('\n');
            }
            sb.append("glError: ");
            sb.append(GLU.gluErrorString(iGlGetError));
            z10 = true;
        }
        if (z10) {
            throw new a(sb.toString());
        }
    }

    public static void c(boolean z10, String str) throws a {
        if (!z10) {
            throw new a(str);
        }
    }

    private static FloatBuffer d(int i10) {
        return ByteBuffer.allocateDirect(i10 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public static FloatBuffer e(float[] fArr) {
        return (FloatBuffer) d(fArr.length).put(fArr).flip();
    }

    public static int f() throws a {
        int iG = g();
        a(36197, iG);
        return iG;
    }

    private static int g() throws a {
        c(!o0.c(EGL14.eglGetCurrentContext(), EGL14.EGL_NO_CONTEXT), "No current context");
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        b();
        return iArr[0];
    }

    public static boolean h(Context context) {
        String strEglQueryString;
        int i10 = o0.f214a;
        if (i10 < 24) {
            return false;
        }
        if (i10 >= 26 || !("samsung".equals(o0.f216c) || "XT1650".equals(o0.f217d))) {
            return (i10 >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && strEglQueryString.contains("EGL_EXT_protected_content");
        }
        return false;
    }

    public static boolean i() {
        String strEglQueryString;
        return o0.f214a >= 17 && (strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && strEglQueryString.contains("EGL_KHR_surfaceless_context");
    }

    public static void j(float[] fArr) {
        Matrix.setIdentityM(fArr, 0);
    }
}
