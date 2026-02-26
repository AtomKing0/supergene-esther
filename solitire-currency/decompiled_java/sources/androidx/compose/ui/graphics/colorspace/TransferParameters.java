package androidx.compose.ui.graphics.colorspace;

import androidx.compose.animation.core.b;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TransferParameters.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TransferParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final double f770d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final double f771e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final double f772f;
    private final double gamma;

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0062, code lost:
    
        if ((r2 == 0.0d) == false) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public TransferParameters(double r2, double r4, double r6, double r8, double r10, double r12, double r14) {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.TransferParameters.<init>(double, double, double, double, double, double, double):void");
    }

    public final double component1() {
        return this.gamma;
    }

    public final double component2() {
        return this.f767a;
    }

    public final double component3() {
        return this.f768b;
    }

    public final double component4() {
        return this.f769c;
    }

    public final double component5() {
        return this.f770d;
    }

    public final double component6() {
        return this.f771e;
    }

    public final double component7() {
        return this.f772f;
    }

    @NotNull
    public final TransferParameters copy(double d10, double d11, double d12, double d13, double d14, double d15, double d16) {
        return new TransferParameters(d10, d11, d12, d13, d14, d15, d16);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransferParameters)) {
            return false;
        }
        TransferParameters transferParameters = (TransferParameters) obj;
        return t.d(Double.valueOf(this.gamma), Double.valueOf(transferParameters.gamma)) && t.d(Double.valueOf(this.f767a), Double.valueOf(transferParameters.f767a)) && t.d(Double.valueOf(this.f768b), Double.valueOf(transferParameters.f768b)) && t.d(Double.valueOf(this.f769c), Double.valueOf(transferParameters.f769c)) && t.d(Double.valueOf(this.f770d), Double.valueOf(transferParameters.f770d)) && t.d(Double.valueOf(this.f771e), Double.valueOf(transferParameters.f771e)) && t.d(Double.valueOf(this.f772f), Double.valueOf(transferParameters.f772f));
    }

    public final double getA() {
        return this.f767a;
    }

    public final double getB() {
        return this.f768b;
    }

    public final double getC() {
        return this.f769c;
    }

    public final double getD() {
        return this.f770d;
    }

    public final double getE() {
        return this.f771e;
    }

    public final double getF() {
        return this.f772f;
    }

    public final double getGamma() {
        return this.gamma;
    }

    public int hashCode() {
        return (((((((((((b.a(this.gamma) * 31) + b.a(this.f767a)) * 31) + b.a(this.f768b)) * 31) + b.a(this.f769c)) * 31) + b.a(this.f770d)) * 31) + b.a(this.f771e)) * 31) + b.a(this.f772f);
    }

    @NotNull
    public String toString() {
        return "TransferParameters(gamma=" + this.gamma + ", a=" + this.f767a + ", b=" + this.f768b + ", c=" + this.f769c + ", d=" + this.f770d + ", e=" + this.f771e + ", f=" + this.f772f + ')';
    }

    public /* synthetic */ TransferParameters(double d10, double d11, double d12, double d13, double d14, double d15, double d16, int i10, k kVar) {
        this(d10, d11, d12, d13, d14, (i10 & 32) != 0 ? 0.0d : d15, (i10 & 64) != 0 ? 0.0d : d16);
    }
}
