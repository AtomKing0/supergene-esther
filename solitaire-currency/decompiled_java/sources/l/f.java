package l;

import android.os.SystemClock;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ScaleFactorKt;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CrossfadePainter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Stable
public final class f extends Painter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private Painter f30173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final Painter f30174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final ContentScale f30175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f30176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f30177e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f30178f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f30181i;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final MutableState f30179g = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f30180h = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private final MutableState f30182j = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), null, 2, null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private final MutableState f30183k = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    public f(@Nullable Painter painter, @Nullable Painter painter2, @NotNull ContentScale contentScale, int i10, boolean z10, boolean z11) {
        this.f30173a = painter;
        this.f30174b = painter2;
        this.f30175c = contentScale;
        this.f30176d = i10;
        this.f30177e = z10;
        this.f30178f = z11;
    }

    private final long a(long j10, long j11) {
        Size.Companion companion = Size.Companion;
        if (!(j10 == companion.m1444getUnspecifiedNHjbRc()) && !Size.m1438isEmptyimpl(j10)) {
            if (!(j11 == companion.m1444getUnspecifiedNHjbRc()) && !Size.m1438isEmptyimpl(j11)) {
                return ScaleFactorKt.m3051timesUQTWf7w(j10, this.f30175c.mo2978computeScaleFactorH7hwNQA(j10, j11));
            }
        }
        return j11;
    }

    private final long b() {
        Painter painter = this.f30173a;
        long jMo2089getIntrinsicSizeNHjbRc = painter != null ? painter.mo2089getIntrinsicSizeNHjbRc() : Size.Companion.m1445getZeroNHjbRc();
        Painter painter2 = this.f30174b;
        long jMo2089getIntrinsicSizeNHjbRc2 = painter2 != null ? painter2.mo2089getIntrinsicSizeNHjbRc() : Size.Companion.m1445getZeroNHjbRc();
        Size.Companion companion = Size.Companion;
        boolean z10 = jMo2089getIntrinsicSizeNHjbRc != companion.m1444getUnspecifiedNHjbRc();
        boolean z11 = jMo2089getIntrinsicSizeNHjbRc2 != companion.m1444getUnspecifiedNHjbRc();
        if (z10 && z11) {
            return SizeKt.Size(Math.max(Size.m1436getWidthimpl(jMo2089getIntrinsicSizeNHjbRc), Size.m1436getWidthimpl(jMo2089getIntrinsicSizeNHjbRc2)), Math.max(Size.m1433getHeightimpl(jMo2089getIntrinsicSizeNHjbRc), Size.m1433getHeightimpl(jMo2089getIntrinsicSizeNHjbRc2)));
        }
        if (this.f30178f) {
            if (z10) {
                return jMo2089getIntrinsicSizeNHjbRc;
            }
            if (z11) {
                return jMo2089getIntrinsicSizeNHjbRc2;
            }
        }
        return companion.m1444getUnspecifiedNHjbRc();
    }

    private final void c(DrawScope drawScope, Painter painter, float f10) {
        if (painter == null || f10 <= 0.0f) {
            return;
        }
        long jMo1996getSizeNHjbRc = drawScope.mo1996getSizeNHjbRc();
        long jA = a(painter.mo2089getIntrinsicSizeNHjbRc(), jMo1996getSizeNHjbRc);
        if ((jMo1996getSizeNHjbRc == Size.Companion.m1444getUnspecifiedNHjbRc()) || Size.m1438isEmptyimpl(jMo1996getSizeNHjbRc)) {
            painter.m2095drawx_KDEd0(drawScope, jA, f10, d());
            return;
        }
        float f11 = 2;
        float fM1436getWidthimpl = (Size.m1436getWidthimpl(jMo1996getSizeNHjbRc) - Size.m1436getWidthimpl(jA)) / f11;
        float fM1433getHeightimpl = (Size.m1433getHeightimpl(jMo1996getSizeNHjbRc) - Size.m1433getHeightimpl(jA)) / f11;
        drawScope.getDrawContext().getTransform().inset(fM1436getWidthimpl, fM1433getHeightimpl, fM1436getWidthimpl, fM1433getHeightimpl);
        painter.m2095drawx_KDEd0(drawScope, jA, f10, d());
        float f12 = -fM1436getWidthimpl;
        float f13 = -fM1433getHeightimpl;
        drawScope.getDrawContext().getTransform().inset(f12, f13, f12, f13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ColorFilter d() {
        return (ColorFilter) this.f30183k.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int e() {
        return ((Number) this.f30179g.getValue()).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final float f() {
        return ((Number) this.f30182j.getValue()).floatValue();
    }

    private final void g(ColorFilter colorFilter) {
        this.f30183k.setValue(colorFilter);
    }

    private final void h(int i10) {
        this.f30179g.setValue(Integer.valueOf(i10));
    }

    private final void i(float f10) {
        this.f30182j.setValue(Float.valueOf(f10));
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyAlpha(float f10) {
        i(f10);
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyColorFilter(@Nullable ColorFilter colorFilter) {
        g(colorFilter);
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public long mo2089getIntrinsicSizeNHjbRc() {
        return b();
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected void onDraw(@NotNull DrawScope drawScope) {
        if (this.f30181i) {
            c(drawScope, this.f30174b, f());
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.f30180h == -1) {
            this.f30180h = jUptimeMillis;
        }
        float f10 = (jUptimeMillis - this.f30180h) / this.f30176d;
        float fM = o.m(f10, 0.0f, 1.0f) * f();
        float f11 = this.f30177e ? f() - fM : f();
        this.f30181i = f10 >= 1.0f;
        c(drawScope, this.f30173a, f11);
        c(drawScope, this.f30174b, fM);
        if (this.f30181i) {
            this.f30173a = null;
        } else {
            h(e() + 1);
        }
    }
}
