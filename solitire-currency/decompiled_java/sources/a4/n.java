package a4;

import a4.o;
import android.opengl.GLES20;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: GlProgram.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a[] f199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b[] f200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, a> f201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<String, b> f202e;

    /* JADX INFO: compiled from: GlProgram.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f203a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f204b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f205c;

        private a(String str, int i10, int i11) {
            this.f203a = str;
            this.f204b = i10;
            this.f205c = i11;
        }

        public static a a(int i10, int i11) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i10, 35722, iArr, 0);
            int i12 = iArr[0];
            byte[] bArr = new byte[i12];
            GLES20.glGetActiveAttrib(i10, i11, i12, new int[1], 0, new int[1], 0, new int[1], 0, bArr, 0);
            String str = new String(bArr, 0, n.h(bArr));
            return new a(str, i11, n.f(i10, str));
        }
    }

    /* JADX INFO: compiled from: GlProgram.java */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f206a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f207b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f208c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float[] f209d = new float[16];

        private b(String str, int i10, int i11) {
            this.f206a = str;
            this.f207b = i10;
            this.f208c = i11;
        }

        public static b a(int i10, int i11) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i10, 35719, iArr, 0);
            int[] iArr2 = new int[1];
            int i12 = iArr[0];
            byte[] bArr = new byte[i12];
            GLES20.glGetActiveUniform(i10, i11, i12, new int[1], 0, new int[1], 0, iArr2, 0, bArr, 0);
            String str = new String(bArr, 0, n.h(bArr));
            return new b(str, n.i(i10, str), iArr2[0]);
        }
    }

    public n(String str, String str2) throws o.a {
        int iGlCreateProgram = GLES20.glCreateProgram();
        this.f198a = iGlCreateProgram;
        o.b();
        d(iGlCreateProgram, 35633, str);
        d(iGlCreateProgram, 35632, str2);
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        o.c(iArr[0] == 1, "Unable to link shader program: \n" + GLES20.glGetProgramInfoLog(iGlCreateProgram));
        GLES20.glUseProgram(iGlCreateProgram);
        this.f201d = new HashMap();
        int[] iArr2 = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35721, iArr2, 0);
        this.f199b = new a[iArr2[0]];
        for (int i10 = 0; i10 < iArr2[0]; i10++) {
            a aVarA = a.a(this.f198a, i10);
            this.f199b[i10] = aVarA;
            this.f201d.put(aVarA.f203a, aVarA);
        }
        this.f202e = new HashMap();
        int[] iArr3 = new int[1];
        GLES20.glGetProgramiv(this.f198a, 35718, iArr3, 0);
        this.f200c = new b[iArr3[0]];
        for (int i11 = 0; i11 < iArr3[0]; i11++) {
            b bVarA = b.a(this.f198a, i11);
            this.f200c[i11] = bVarA;
            this.f202e.put(bVarA.f206a, bVarA);
        }
        o.b();
    }

    private static void d(int i10, int i11, String str) throws o.a {
        int iGlCreateShader = GLES20.glCreateShader(i11);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        o.c(iArr[0] == 1, GLES20.glGetShaderInfoLog(iGlCreateShader) + ", source: " + str);
        GLES20.glAttachShader(i10, iGlCreateShader);
        GLES20.glDeleteShader(iGlCreateShader);
        o.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int f(int i10, String str) {
        return GLES20.glGetAttribLocation(i10, str);
    }

    private int g(String str) {
        return f(this.f198a, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int h(byte[] bArr) {
        for (int i10 = 0; i10 < bArr.length; i10++) {
            if (bArr[i10] == 0) {
                return i10;
            }
        }
        return bArr.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int i(int i10, String str) {
        return GLES20.glGetUniformLocation(i10, str);
    }

    public int e(String str) throws o.a {
        int iG = g(str);
        GLES20.glEnableVertexAttribArray(iG);
        o.b();
        return iG;
    }

    public int j(String str) {
        return i(this.f198a, str);
    }
}
