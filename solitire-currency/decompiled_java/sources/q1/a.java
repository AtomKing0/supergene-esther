package q1;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidColorFilter_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.LayoutDirection;
import j9.c;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.l;
import v8.n;
import v8.q;

/* JADX INFO: compiled from: DrawablePainter.kt */
/* JADX INFO: loaded from: classes2.dex */
@StabilityInferred(parameters = 0)
public final class a extends Painter implements RememberObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Drawable f33120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final MutableState f33121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final MutableState f33122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final l f33123d;

    /* JADX INFO: renamed from: q1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DrawablePainter.kt */
    public /* synthetic */ class C0657a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f33124a;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            f33124a = iArr;
        }
    }

    /* JADX INFO: compiled from: DrawablePainter.kt */
    static final class b extends v implements h9.a<C0658a> {

        /* JADX INFO: renamed from: q1.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DrawablePainter.kt */
        public static final class C0658a implements Drawable.Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f33126a;

            C0658a(a aVar) {
                this.f33126a = aVar;
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(@NotNull Drawable d10) {
                t.i(d10, "d");
                a aVar = this.f33126a;
                aVar.h(aVar.e() + 1);
                a aVar2 = this.f33126a;
                aVar2.i(q1.b.c(aVar2.f()));
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(@NotNull Drawable d10, @NotNull Runnable what, long j10) {
                t.i(d10, "d");
                t.i(what, "what");
                q1.b.d().postAtTime(what, j10);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(@NotNull Drawable d10, @NotNull Runnable what) {
                t.i(d10, "d");
                t.i(what, "what");
                q1.b.d().removeCallbacks(what);
            }
        }

        b() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final C0658a invoke() {
            return new C0658a(a.this);
        }
    }

    public a(@NotNull Drawable drawable) {
        t.i(drawable, "drawable");
        this.f33120a = drawable;
        this.f33121b = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.f33122c = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m1424boximpl(q1.b.c(drawable)), null, 2, null);
        this.f33123d = n.a(new b());
        if (drawable.getIntrinsicWidth() < 0 || drawable.getIntrinsicHeight() < 0) {
            return;
        }
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    private final Drawable.Callback d() {
        return (Drawable.Callback) this.f33123d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final int e() {
        return ((Number) this.f33121b.getValue()).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long g() {
        return ((Size) this.f33122c.getValue()).m1441unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(int i10) {
        this.f33121b.setValue(Integer.valueOf(i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(long j10) {
        this.f33122c.setValue(Size.m1424boximpl(j10));
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyAlpha(float f10) {
        this.f33120a.setAlpha(o.n(c.c(f10 * 255), 0, 255));
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyColorFilter(@Nullable ColorFilter colorFilter) {
        this.f33120a.setColorFilter(colorFilter != null ? AndroidColorFilter_androidKt.asAndroidColorFilter(colorFilter) : null);
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyLayoutDirection(@NotNull LayoutDirection layoutDirection) {
        t.i(layoutDirection, "layoutDirection");
        Drawable drawable = this.f33120a;
        int i10 = C0657a.f33124a[layoutDirection.ordinal()];
        int i11 = 1;
        if (i10 == 1) {
            i11 = 0;
        } else if (i10 != 2) {
            throw new q();
        }
        return drawable.setLayoutDirection(i11);
    }

    @NotNull
    public final Drawable f() {
        return this.f33120a;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public long mo2089getIntrinsicSizeNHjbRc() {
        return g();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        onForgotten();
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected void onDraw(@NotNull DrawScope drawScope) {
        t.i(drawScope, "<this>");
        Canvas canvas = drawScope.getDrawContext().getCanvas();
        e();
        this.f33120a.setBounds(0, 0, c.c(Size.m1436getWidthimpl(drawScope.mo1996getSizeNHjbRc())), c.c(Size.m1433getHeightimpl(drawScope.mo1996getSizeNHjbRc())));
        try {
            canvas.save();
            this.f33120a.draw(AndroidCanvas_androidKt.getNativeCanvas(canvas));
        } finally {
            canvas.restore();
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        Object obj = this.f33120a;
        if (obj instanceof Animatable) {
            ((Animatable) obj).stop();
        }
        this.f33120a.setVisible(false, false);
        this.f33120a.setCallback(null);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        this.f33120a.setCallback(d());
        this.f33120a.setVisible(true, true);
        Object obj = this.f33120a;
        if (obj instanceof Animatable) {
            ((Animatable) obj).start();
        }
    }
}
