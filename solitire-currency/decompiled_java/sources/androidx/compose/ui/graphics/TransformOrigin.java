package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TransformOrigin.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class TransformOrigin {
    private final long packedValue;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long Center = TransformOriginKt.TransformOrigin(0.5f, 0.5f);

    /* JADX INFO: compiled from: TransformOrigin.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getCenter-SzJe1aQ, reason: not valid java name */
        public final long m1923getCenterSzJe1aQ() {
            return TransformOrigin.Center;
        }
    }

    private /* synthetic */ TransformOrigin(long j10) {
        this.packedValue = j10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TransformOrigin m1910boximpl(long j10) {
        return new TransformOrigin(j10);
    }

    @Stable
    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final float m1911component1impl(long j10) {
        return m1918getPivotFractionXimpl(j10);
    }

    @Stable
    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final float m1912component2impl(long j10) {
        return m1919getPivotFractionYimpl(j10);
    }

    /* JADX INFO: renamed from: copy-zey9I6w, reason: not valid java name */
    public static final long m1914copyzey9I6w(long j10, float f10, float f11) {
        return TransformOriginKt.TransformOrigin(f10, f11);
    }

    /* JADX INFO: renamed from: copy-zey9I6w$default, reason: not valid java name */
    public static /* synthetic */ long m1915copyzey9I6w$default(long j10, float f10, float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = m1918getPivotFractionXimpl(j10);
        }
        if ((i10 & 2) != 0) {
            f11 = m1919getPivotFractionYimpl(j10);
        }
        return m1914copyzey9I6w(j10, f10, f11);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1916equalsimpl(long j10, Object obj) {
        return (obj instanceof TransformOrigin) && j10 == ((TransformOrigin) obj).m1922unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1917equalsimpl0(long j10, long j11) {
        return j10 == j11;
    }

    /* JADX INFO: renamed from: getPivotFractionX-impl, reason: not valid java name */
    public static final float m1918getPivotFractionXimpl(long j10) {
        kotlin.jvm.internal.m mVar = kotlin.jvm.internal.m.f29832a;
        return Float.intBitsToFloat((int) (j10 >> 32));
    }

    /* JADX INFO: renamed from: getPivotFractionY-impl, reason: not valid java name */
    public static final float m1919getPivotFractionYimpl(long j10) {
        kotlin.jvm.internal.m mVar = kotlin.jvm.internal.m.f29832a;
        return Float.intBitsToFloat((int) (j10 & 4294967295L));
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1920hashCodeimpl(long j10) {
        return androidx.compose.animation.a.a(j10);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1921toStringimpl(long j10) {
        return "TransformOrigin(packedValue=" + j10 + ')';
    }

    public boolean equals(Object obj) {
        return m1916equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m1920hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m1921toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m1922unboximpl() {
        return this.packedValue;
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m1913constructorimpl(long j10) {
        return j10;
    }
}
