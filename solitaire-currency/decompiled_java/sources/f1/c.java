package f1;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import f1.g;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import r0.l;

/* JADX INFO: compiled from: GifDrawable.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends Drawable implements g.b, Animatable, Animatable2Compat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f25544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f25545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f25546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f25547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f25548e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f25549f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f25550g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f25551h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Paint f25552i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Rect f25553j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<Animatable2Compat.AnimationCallback> f25554k;

    /* JADX INFO: compiled from: GifDrawable.java */
    static final class a extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @VisibleForTesting
        final g f25555a;

        a(g gVar) {
            this.f25555a = gVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new c(this);
        }
    }

    public c(Context context, q0.a aVar, l<Bitmap> lVar, int i10, int i11, Bitmap bitmap) {
        this(new a(new g(com.bumptech.glide.b.c(context), aVar, i10, i11, lVar, bitmap)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Drawable.Callback b() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    private Rect d() {
        if (this.f25553j == null) {
            this.f25553j = new Rect();
        }
        return this.f25553j;
    }

    private Paint h() {
        if (this.f25552i == null) {
            this.f25552i = new Paint(2);
        }
        return this.f25552i;
    }

    private void j() {
        List<Animatable2Compat.AnimationCallback> list = this.f25554k;
        if (list != null) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f25554k.get(i10).onAnimationEnd(this);
            }
        }
    }

    private void l() {
        this.f25549f = 0;
    }

    private void n() {
        o1.j.a(!this.f25547d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f25544a.f25555a.f() == 1) {
            invalidateSelf();
        } else {
            if (this.f25545b) {
                return;
            }
            this.f25545b = true;
            this.f25544a.f25555a.r(this);
            invalidateSelf();
        }
    }

    private void o() {
        this.f25545b = false;
        this.f25544a.f25555a.s(this);
    }

    @Override // f1.g.b
    public void a() {
        if (b() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (g() == f() - 1) {
            this.f25549f++;
        }
        int i10 = this.f25550g;
        if (i10 == -1 || this.f25549f < i10) {
            return;
        }
        j();
        stop();
    }

    public ByteBuffer c() {
        return this.f25544a.f25555a.b();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> list = this.f25554k;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f25547d) {
            return;
        }
        if (this.f25551h) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), d());
            this.f25551h = false;
        }
        canvas.drawBitmap(this.f25544a.f25555a.c(), (Rect) null, d(), h());
    }

    public Bitmap e() {
        return this.f25544a.f25555a.e();
    }

    public int f() {
        return this.f25544a.f25555a.f();
    }

    public int g() {
        return this.f25544a.f25555a.d();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f25544a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f25544a.f25555a.h();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f25544a.f25555a.k();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public int i() {
        return this.f25544a.f25555a.j();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f25545b;
    }

    public void k() {
        this.f25547d = true;
        this.f25544a.f25555a.a();
    }

    public void m(l<Bitmap> lVar, Bitmap bitmap) {
        this.f25544a.f25555a.o(lVar, bitmap);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f25551h = true;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback == null) {
            return;
        }
        if (this.f25554k == null) {
            this.f25554k = new ArrayList();
        }
        this.f25554k.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        h().setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        h().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        o1.j.a(!this.f25547d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f25548e = z10;
        if (!z10) {
            o();
        } else if (this.f25546c) {
            n();
        }
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f25546c = true;
        l();
        if (this.f25548e) {
            n();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f25546c = false;
        o();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.f25554k;
        if (list == null || animationCallback == null) {
            return false;
        }
        return list.remove(animationCallback);
    }

    c(a aVar) {
        this.f25548e = true;
        this.f25550g = -1;
        this.f25544a = (a) o1.j.d(aVar);
    }
}
