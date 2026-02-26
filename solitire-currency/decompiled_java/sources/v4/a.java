package v4;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.TintAwareDrawable;
import x4.g;
import x4.k;
import x4.n;

/* JADX INFO: compiled from: RippleDrawableCompat.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a extends Drawable implements n, TintAwareDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f35112a;

    @Override // android.graphics.drawable.Drawable
    @NonNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a mutate() {
        this.f35112a = new b(this.f35112a);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b bVar = this.f35112a;
        if (bVar.f35114b) {
            bVar.f35113a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.f35112a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f35112a.f35113a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        this.f35112a.f35113a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(@NonNull int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        if (this.f35112a.f35113a.setState(iArr)) {
            zOnStateChange = true;
        }
        boolean zB = v4.b.b(iArr);
        b bVar = this.f35112a;
        if (bVar.f35114b == zB) {
            return zOnStateChange;
        }
        bVar.f35114b = zB;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f35112a.f35113a.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f35112a.f35113a.setColorFilter(colorFilter);
    }

    @Override // x4.n
    public void setShapeAppearanceModel(@NonNull k kVar) {
        this.f35112a.f35113a.setShapeAppearanceModel(kVar);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@ColorInt int i10) {
        this.f35112a.f35113a.setTint(i10);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.f35112a.f35113a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        this.f35112a.f35113a.setTintMode(mode);
    }

    public a(k kVar) {
        this(new b(new g(kVar)));
    }

    /* JADX INFO: compiled from: RippleDrawableCompat.java */
    static final class b extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        g f35113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f35114b;

        public b(g gVar) {
            this.f35113a = gVar;
            this.f35114b = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a newDrawable() {
            return new a(new b(this));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        public b(@NonNull b bVar) {
            this.f35113a = (g) bVar.f35113a.getConstantState().newDrawable();
            this.f35114b = bVar.f35114b;
        }
    }

    private a(b bVar) {
        this.f35112a = bVar;
    }
}
