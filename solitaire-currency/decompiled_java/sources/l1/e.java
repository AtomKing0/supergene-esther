package l1;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import m1.b;

/* JADX INFO: compiled from: ImageViewTarget.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e<Z> extends i<ImageView, Z> implements b.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private Animatable f30217h;

    public e(ImageView imageView) {
        super(imageView);
    }

    private void l(@Nullable Z z10) {
        if (!(z10 instanceof Animatable)) {
            this.f30217h = null;
            return;
        }
        Animatable animatable = (Animatable) z10;
        this.f30217h = animatable;
        animatable.start();
    }

    private void o(@Nullable Z z10) {
        n(z10);
        l(z10);
    }

    @Override // l1.i, l1.a, l1.h
    public void c(@Nullable Drawable drawable) {
        super.c(drawable);
        o(null);
        m(drawable);
    }

    @Override // l1.i, l1.a, l1.h
    public void d(@Nullable Drawable drawable) {
        super.d(drawable);
        Animatable animatable = this.f30217h;
        if (animatable != null) {
            animatable.stop();
        }
        o(null);
        m(drawable);
    }

    @Override // l1.a, l1.h
    public void f(@Nullable Drawable drawable) {
        super.f(drawable);
        o(null);
        m(drawable);
    }

    @Override // l1.h
    public void g(@NonNull Z z10, @Nullable m1.b<? super Z> bVar) {
        if (bVar == null || !bVar.a(z10, this)) {
            o(z10);
        } else {
            l(z10);
        }
    }

    public void m(Drawable drawable) {
        ((ImageView) this.f30220a).setImageDrawable(drawable);
    }

    protected abstract void n(@Nullable Z z10);

    @Override // l1.a, h1.i
    public void onStart() {
        Animatable animatable = this.f30217h;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // l1.a, h1.i
    public void onStop() {
        Animatable animatable = this.f30217h;
        if (animatable != null) {
            animatable.stop();
        }
    }
}
