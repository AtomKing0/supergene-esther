package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Matrix.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Matrix {

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int Perspective0 = 3;
    public static final int Perspective1 = 7;
    public static final int Perspective2 = 15;
    public static final int ScaleX = 0;
    public static final int ScaleY = 5;
    public static final int ScaleZ = 10;
    public static final int SkewX = 4;
    public static final int SkewY = 1;
    public static final int TranslateX = 12;
    public static final int TranslateY = 13;
    public static final int TranslateZ = 14;

    @NotNull
    private final float[] values;

    /* JADX INFO: compiled from: Matrix.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    private /* synthetic */ Matrix(float[] fArr) {
        this.values = fArr;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Matrix m1774boximpl(float[] fArr) {
        return new Matrix(fArr);
    }

    @NotNull
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static float[] m1775constructorimpl(@NotNull float[] values) {
        kotlin.jvm.internal.t.i(values, "values");
        return values;
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ float[] m1776constructorimpl$default(float[] fArr, int i10, kotlin.jvm.internal.k kVar) {
        if ((i10 & 1) != 0) {
            fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        }
        return m1775constructorimpl(fArr);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1777equalsimpl(float[] fArr, Object obj) {
        return (obj instanceof Matrix) && kotlin.jvm.internal.t.d(fArr, ((Matrix) obj).m1797unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1778equalsimpl0(float[] fArr, float[] fArr2) {
        return kotlin.jvm.internal.t.d(fArr, fArr2);
    }

    /* JADX INFO: renamed from: get-impl, reason: not valid java name */
    public static final float m1779getimpl(float[] fArr, int i10, int i11) {
        return fArr[(i10 * 4) + i11];
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1780hashCodeimpl(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    /* JADX INFO: renamed from: invert-impl, reason: not valid java name */
    public static final void m1781invertimpl(float[] fArr) {
        float f10 = fArr[0];
        float f11 = fArr[1];
        float f12 = fArr[2];
        float f13 = fArr[3];
        float f14 = fArr[4];
        float f15 = fArr[5];
        float f16 = fArr[6];
        float f17 = fArr[7];
        float f18 = fArr[8];
        float f19 = fArr[9];
        float f20 = fArr[10];
        float f21 = fArr[11];
        float f22 = fArr[12];
        float f23 = fArr[13];
        float f24 = fArr[14];
        float f25 = fArr[15];
        float f26 = (f10 * f15) - (f11 * f14);
        float f27 = (f10 * f16) - (f12 * f14);
        float f28 = (f10 * f17) - (f13 * f14);
        float f29 = (f11 * f16) - (f12 * f15);
        float f30 = (f11 * f17) - (f13 * f15);
        float f31 = (f12 * f17) - (f13 * f16);
        float f32 = (f18 * f23) - (f19 * f22);
        float f33 = (f18 * f24) - (f20 * f22);
        float f34 = (f18 * f25) - (f21 * f22);
        float f35 = (f19 * f24) - (f20 * f23);
        float f36 = (f19 * f25) - (f21 * f23);
        float f37 = (f20 * f25) - (f21 * f24);
        float f38 = (((((f26 * f37) - (f27 * f36)) + (f28 * f35)) + (f29 * f34)) - (f30 * f33)) + (f31 * f32);
        if (f38 == 0.0f) {
            return;
        }
        float f39 = 1.0f / f38;
        fArr[0] = (((f15 * f37) - (f16 * f36)) + (f17 * f35)) * f39;
        fArr[1] = ((((-f11) * f37) + (f12 * f36)) - (f13 * f35)) * f39;
        fArr[2] = (((f23 * f31) - (f24 * f30)) + (f25 * f29)) * f39;
        fArr[3] = ((((-f19) * f31) + (f20 * f30)) - (f21 * f29)) * f39;
        float f40 = -f14;
        fArr[4] = (((f40 * f37) + (f16 * f34)) - (f17 * f33)) * f39;
        fArr[5] = (((f37 * f10) - (f12 * f34)) + (f13 * f33)) * f39;
        float f41 = -f22;
        fArr[6] = (((f41 * f31) + (f24 * f28)) - (f25 * f27)) * f39;
        fArr[7] = (((f31 * f18) - (f20 * f28)) + (f21 * f27)) * f39;
        fArr[8] = (((f14 * f36) - (f15 * f34)) + (f17 * f32)) * f39;
        fArr[9] = ((((-f10) * f36) + (f34 * f11)) - (f13 * f32)) * f39;
        fArr[10] = (((f22 * f30) - (f23 * f28)) + (f25 * f26)) * f39;
        fArr[11] = ((((-f18) * f30) + (f28 * f19)) - (f21 * f26)) * f39;
        fArr[12] = (((f40 * f35) + (f15 * f33)) - (f16 * f32)) * f39;
        fArr[13] = (((f10 * f35) - (f11 * f33)) + (f12 * f32)) * f39;
        fArr[14] = (((f41 * f29) + (f23 * f27)) - (f24 * f26)) * f39;
        fArr[15] = (((f18 * f29) - (f19 * f27)) + (f20 * f26)) * f39;
    }

    /* JADX INFO: renamed from: map-MK-Hz9U, reason: not valid java name */
    public static final long m1782mapMKHz9U(float[] fArr, long j10) {
        float fM1367getXimpl = Offset.m1367getXimpl(j10);
        float fM1368getYimpl = Offset.m1368getYimpl(j10);
        float f10 = 1 / (((fArr[3] * fM1367getXimpl) + (fArr[7] * fM1368getYimpl)) + fArr[15]);
        if (!((Float.isInfinite(f10) || Float.isNaN(f10)) ? false : true)) {
            f10 = 0.0f;
        }
        return OffsetKt.Offset(((fArr[0] * fM1367getXimpl) + (fArr[4] * fM1368getYimpl) + fArr[12]) * f10, f10 * ((fArr[1] * fM1367getXimpl) + (fArr[5] * fM1368getYimpl) + fArr[13]));
    }

    @NotNull
    /* JADX INFO: renamed from: map-impl, reason: not valid java name */
    public static final Rect m1783mapimpl(float[] fArr, @NotNull Rect rect) {
        kotlin.jvm.internal.t.i(rect, "rect");
        long jM1782mapMKHz9U = m1782mapMKHz9U(fArr, OffsetKt.Offset(rect.getLeft(), rect.getTop()));
        long jM1782mapMKHz9U2 = m1782mapMKHz9U(fArr, OffsetKt.Offset(rect.getLeft(), rect.getBottom()));
        long jM1782mapMKHz9U3 = m1782mapMKHz9U(fArr, OffsetKt.Offset(rect.getRight(), rect.getTop()));
        long jM1782mapMKHz9U4 = m1782mapMKHz9U(fArr, OffsetKt.Offset(rect.getRight(), rect.getBottom()));
        return new Rect(Math.min(Math.min(Offset.m1367getXimpl(jM1782mapMKHz9U), Offset.m1367getXimpl(jM1782mapMKHz9U2)), Math.min(Offset.m1367getXimpl(jM1782mapMKHz9U3), Offset.m1367getXimpl(jM1782mapMKHz9U4))), Math.min(Math.min(Offset.m1368getYimpl(jM1782mapMKHz9U), Offset.m1368getYimpl(jM1782mapMKHz9U2)), Math.min(Offset.m1368getYimpl(jM1782mapMKHz9U3), Offset.m1368getYimpl(jM1782mapMKHz9U4))), Math.max(Math.max(Offset.m1367getXimpl(jM1782mapMKHz9U), Offset.m1367getXimpl(jM1782mapMKHz9U2)), Math.max(Offset.m1367getXimpl(jM1782mapMKHz9U3), Offset.m1367getXimpl(jM1782mapMKHz9U4))), Math.max(Math.max(Offset.m1368getYimpl(jM1782mapMKHz9U), Offset.m1368getYimpl(jM1782mapMKHz9U2)), Math.max(Offset.m1368getYimpl(jM1782mapMKHz9U3), Offset.m1368getYimpl(jM1782mapMKHz9U4))));
    }

    /* JADX INFO: renamed from: reset-impl, reason: not valid java name */
    public static final void m1785resetimpl(float[] fArr) {
        int i10 = 0;
        while (i10 < 4) {
            int i11 = 0;
            while (i11 < 4) {
                fArr[(i11 * 4) + i10] = i10 == i11 ? 1.0f : 0.0f;
                i11++;
            }
            i10++;
        }
    }

    /* JADX INFO: renamed from: rotateX-impl, reason: not valid java name */
    public static final void m1786rotateXimpl(float[] fArr, float f10) {
        double d10 = (((double) f10) * 3.141592653589793d) / 180.0d;
        float fCos = (float) Math.cos(d10);
        float fSin = (float) Math.sin(d10);
        float f11 = fArr[1];
        float f12 = fArr[2];
        float f13 = fArr[5];
        float f14 = fArr[6];
        float f15 = fArr[9];
        float f16 = fArr[10];
        float f17 = fArr[13];
        float f18 = fArr[14];
        fArr[1] = (f11 * fCos) - (f12 * fSin);
        fArr[2] = (f11 * fSin) + (f12 * fCos);
        fArr[5] = (f13 * fCos) - (f14 * fSin);
        fArr[6] = (f13 * fSin) + (f14 * fCos);
        fArr[9] = (f15 * fCos) - (f16 * fSin);
        fArr[10] = (f15 * fSin) + (f16 * fCos);
        fArr[13] = (f17 * fCos) - (f18 * fSin);
        fArr[14] = (f17 * fSin) + (f18 * fCos);
    }

    /* JADX INFO: renamed from: rotateY-impl, reason: not valid java name */
    public static final void m1787rotateYimpl(float[] fArr, float f10) {
        double d10 = (((double) f10) * 3.141592653589793d) / 180.0d;
        float fCos = (float) Math.cos(d10);
        float fSin = (float) Math.sin(d10);
        float f11 = fArr[0];
        float f12 = fArr[2];
        float f13 = fArr[4];
        float f14 = fArr[6];
        float f15 = fArr[8];
        float f16 = fArr[10];
        float f17 = fArr[12];
        float f18 = fArr[14];
        fArr[0] = (f11 * fCos) + (f12 * fSin);
        fArr[2] = ((-f11) * fSin) + (f12 * fCos);
        fArr[4] = (f13 * fCos) + (f14 * fSin);
        fArr[6] = ((-f13) * fSin) + (f14 * fCos);
        fArr[8] = (f15 * fCos) + (f16 * fSin);
        fArr[10] = ((-f15) * fSin) + (f16 * fCos);
        fArr[12] = (f17 * fCos) + (f18 * fSin);
        fArr[14] = ((-f17) * fSin) + (f18 * fCos);
    }

    /* JADX INFO: renamed from: rotateZ-impl, reason: not valid java name */
    public static final void m1788rotateZimpl(float[] fArr, float f10) {
        double d10 = (((double) f10) * 3.141592653589793d) / 180.0d;
        float fCos = (float) Math.cos(d10);
        float fSin = (float) Math.sin(d10);
        float f11 = fArr[0];
        float f12 = fArr[4];
        float f13 = (fCos * f11) + (fSin * f12);
        float f14 = -fSin;
        float f15 = fArr[1];
        float f16 = fArr[5];
        float f17 = (fCos * f15) + (fSin * f16);
        float f18 = fArr[2];
        float f19 = fArr[6];
        float f20 = (fCos * f18) + (fSin * f19);
        float f21 = fArr[3];
        float f22 = fArr[7];
        fArr[0] = f13;
        fArr[1] = f17;
        fArr[2] = f20;
        fArr[3] = (fCos * f21) + (fSin * f22);
        fArr[4] = (f11 * f14) + (f12 * fCos);
        fArr[5] = (f15 * f14) + (f16 * fCos);
        fArr[6] = (f18 * f14) + (f19 * fCos);
        fArr[7] = (f14 * f21) + (fCos * f22);
    }

    /* JADX INFO: renamed from: scale-impl, reason: not valid java name */
    public static final void m1789scaleimpl(float[] fArr, float f10, float f11, float f12) {
        fArr[0] = fArr[0] * f10;
        fArr[1] = fArr[1] * f10;
        fArr[2] = fArr[2] * f10;
        fArr[3] = fArr[3] * f10;
        fArr[4] = fArr[4] * f11;
        fArr[5] = fArr[5] * f11;
        fArr[6] = fArr[6] * f11;
        fArr[7] = fArr[7] * f11;
        fArr[8] = fArr[8] * f12;
        fArr[9] = fArr[9] * f12;
        fArr[10] = fArr[10] * f12;
        fArr[11] = fArr[11] * f12;
    }

    /* JADX INFO: renamed from: scale-impl$default, reason: not valid java name */
    public static /* synthetic */ void m1790scaleimpl$default(float[] fArr, float f10, float f11, float f12, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 1.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 1.0f;
        }
        if ((i10 & 4) != 0) {
            f12 = 1.0f;
        }
        m1789scaleimpl(fArr, f10, f11, f12);
    }

    /* JADX INFO: renamed from: set-impl, reason: not valid java name */
    public static final void m1791setimpl(float[] fArr, int i10, int i11, float f10) {
        fArr[(i10 * 4) + i11] = f10;
    }

    /* JADX INFO: renamed from: setFrom-58bKbWc, reason: not valid java name */
    public static final void m1792setFrom58bKbWc(float[] fArr, @NotNull float[] matrix) {
        kotlin.jvm.internal.t.i(matrix, "matrix");
        for (int i10 = 0; i10 < 16; i10++) {
            fArr[i10] = matrix[i10];
        }
    }

    /* JADX INFO: renamed from: timesAssign-58bKbWc, reason: not valid java name */
    public static final void m1793timesAssign58bKbWc(float[] fArr, @NotNull float[] m10) {
        kotlin.jvm.internal.t.i(m10, "m");
        float fM1799dotp89u6pk = MatrixKt.m1799dotp89u6pk(fArr, 0, m10, 0);
        float fM1799dotp89u6pk2 = MatrixKt.m1799dotp89u6pk(fArr, 0, m10, 1);
        float fM1799dotp89u6pk3 = MatrixKt.m1799dotp89u6pk(fArr, 0, m10, 2);
        float fM1799dotp89u6pk4 = MatrixKt.m1799dotp89u6pk(fArr, 0, m10, 3);
        float fM1799dotp89u6pk5 = MatrixKt.m1799dotp89u6pk(fArr, 1, m10, 0);
        float fM1799dotp89u6pk6 = MatrixKt.m1799dotp89u6pk(fArr, 1, m10, 1);
        float fM1799dotp89u6pk7 = MatrixKt.m1799dotp89u6pk(fArr, 1, m10, 2);
        float fM1799dotp89u6pk8 = MatrixKt.m1799dotp89u6pk(fArr, 1, m10, 3);
        float fM1799dotp89u6pk9 = MatrixKt.m1799dotp89u6pk(fArr, 2, m10, 0);
        float fM1799dotp89u6pk10 = MatrixKt.m1799dotp89u6pk(fArr, 2, m10, 1);
        float fM1799dotp89u6pk11 = MatrixKt.m1799dotp89u6pk(fArr, 2, m10, 2);
        float fM1799dotp89u6pk12 = MatrixKt.m1799dotp89u6pk(fArr, 2, m10, 3);
        float fM1799dotp89u6pk13 = MatrixKt.m1799dotp89u6pk(fArr, 3, m10, 0);
        float fM1799dotp89u6pk14 = MatrixKt.m1799dotp89u6pk(fArr, 3, m10, 1);
        float fM1799dotp89u6pk15 = MatrixKt.m1799dotp89u6pk(fArr, 3, m10, 2);
        float fM1799dotp89u6pk16 = MatrixKt.m1799dotp89u6pk(fArr, 3, m10, 3);
        fArr[0] = fM1799dotp89u6pk;
        fArr[1] = fM1799dotp89u6pk2;
        fArr[2] = fM1799dotp89u6pk3;
        fArr[3] = fM1799dotp89u6pk4;
        fArr[4] = fM1799dotp89u6pk5;
        fArr[5] = fM1799dotp89u6pk6;
        fArr[6] = fM1799dotp89u6pk7;
        fArr[7] = fM1799dotp89u6pk8;
        fArr[8] = fM1799dotp89u6pk9;
        fArr[9] = fM1799dotp89u6pk10;
        fArr[10] = fM1799dotp89u6pk11;
        fArr[11] = fM1799dotp89u6pk12;
        fArr[12] = fM1799dotp89u6pk13;
        fArr[13] = fM1799dotp89u6pk14;
        fArr[14] = fM1799dotp89u6pk15;
        fArr[15] = fM1799dotp89u6pk16;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1794toStringimpl(float[] fArr) {
        return p9.j.f("\n            |" + fArr[0] + ' ' + fArr[1] + ' ' + fArr[2] + ' ' + fArr[3] + "|\n            |" + fArr[4] + ' ' + fArr[5] + ' ' + fArr[6] + ' ' + fArr[7] + "|\n            |" + fArr[8] + ' ' + fArr[9] + ' ' + fArr[10] + ' ' + fArr[11] + "|\n            |" + fArr[12] + ' ' + fArr[13] + ' ' + fArr[14] + ' ' + fArr[15] + "|\n        ");
    }

    /* JADX INFO: renamed from: translate-impl, reason: not valid java name */
    public static final void m1795translateimpl(float[] fArr, float f10, float f11, float f12) {
        float f13 = (fArr[0] * f10) + (fArr[4] * f11) + (fArr[8] * f12) + fArr[12];
        float f14 = (fArr[1] * f10) + (fArr[5] * f11) + (fArr[9] * f12) + fArr[13];
        float f15 = (fArr[2] * f10) + (fArr[6] * f11) + (fArr[10] * f12) + fArr[14];
        float f16 = (fArr[3] * f10) + (fArr[7] * f11) + (fArr[11] * f12) + fArr[15];
        fArr[12] = f13;
        fArr[13] = f14;
        fArr[14] = f15;
        fArr[15] = f16;
    }

    /* JADX INFO: renamed from: translate-impl$default, reason: not valid java name */
    public static /* synthetic */ void m1796translateimpl$default(float[] fArr, float f10, float f11, float f12, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 0.0f;
        }
        if ((i10 & 4) != 0) {
            f12 = 0.0f;
        }
        m1795translateimpl(fArr, f10, f11, f12);
    }

    public boolean equals(Object obj) {
        return m1777equalsimpl(this.values, obj);
    }

    @NotNull
    public final float[] getValues() {
        return this.values;
    }

    public int hashCode() {
        return m1780hashCodeimpl(this.values);
    }

    @NotNull
    public String toString() {
        return m1794toStringimpl(this.values);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float[] m1797unboximpl() {
        return this.values;
    }

    /* JADX INFO: renamed from: map-impl, reason: not valid java name */
    public static final void m1784mapimpl(float[] fArr, @NotNull MutableRect rect) {
        kotlin.jvm.internal.t.i(rect, "rect");
        long jM1782mapMKHz9U = m1782mapMKHz9U(fArr, OffsetKt.Offset(rect.getLeft(), rect.getTop()));
        long jM1782mapMKHz9U2 = m1782mapMKHz9U(fArr, OffsetKt.Offset(rect.getLeft(), rect.getBottom()));
        long jM1782mapMKHz9U3 = m1782mapMKHz9U(fArr, OffsetKt.Offset(rect.getRight(), rect.getTop()));
        long jM1782mapMKHz9U4 = m1782mapMKHz9U(fArr, OffsetKt.Offset(rect.getRight(), rect.getBottom()));
        rect.setLeft(Math.min(Math.min(Offset.m1367getXimpl(jM1782mapMKHz9U), Offset.m1367getXimpl(jM1782mapMKHz9U2)), Math.min(Offset.m1367getXimpl(jM1782mapMKHz9U3), Offset.m1367getXimpl(jM1782mapMKHz9U4))));
        rect.setTop(Math.min(Math.min(Offset.m1368getYimpl(jM1782mapMKHz9U), Offset.m1368getYimpl(jM1782mapMKHz9U2)), Math.min(Offset.m1368getYimpl(jM1782mapMKHz9U3), Offset.m1368getYimpl(jM1782mapMKHz9U4))));
        rect.setRight(Math.max(Math.max(Offset.m1367getXimpl(jM1782mapMKHz9U), Offset.m1367getXimpl(jM1782mapMKHz9U2)), Math.max(Offset.m1367getXimpl(jM1782mapMKHz9U3), Offset.m1367getXimpl(jM1782mapMKHz9U4))));
        rect.setBottom(Math.max(Math.max(Offset.m1368getYimpl(jM1782mapMKHz9U), Offset.m1368getYimpl(jM1782mapMKHz9U2)), Math.max(Offset.m1368getYimpl(jM1782mapMKHz9U3), Offset.m1368getYimpl(jM1782mapMKHz9U4))));
    }
}
