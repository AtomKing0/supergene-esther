package com.google.android.material.textfield;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import x4.g;

/* JADX INFO: compiled from: CutoutDrawable.java */
/* JADX INFO: loaded from: classes3.dex */
class h extends x4.g {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @NonNull
    b f9744z;

    /* JADX INFO: compiled from: CutoutDrawable.java */
    @TargetApi(18)
    private static class c extends h {
        c(@NonNull b bVar) {
            super(bVar);
        }

        @Override // x4.g
        protected void r(@NonNull Canvas canvas) {
            if (this.f9744z.f9745w.isEmpty()) {
                super.r(canvas);
                return;
            }
            canvas.save();
            if (Build.VERSION.SDK_INT >= 26) {
                canvas.clipOutRect(this.f9744z.f9745w);
            } else {
                canvas.clipRect(this.f9744z.f9745w, Region.Op.DIFFERENCE);
            }
            super.r(canvas);
            canvas.restore();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static h k0(@NonNull b bVar) {
        return new c(bVar);
    }

    static h l0(@Nullable x4.k kVar) {
        if (kVar == null) {
            kVar = new x4.k();
        }
        return k0(new b(kVar, new RectF()));
    }

    boolean m0() {
        return !this.f9744z.f9745w.isEmpty();
    }

    @Override // x4.g, android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        this.f9744z = new b(this.f9744z);
        return this;
    }

    void n0() {
        o0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    void o0(float f10, float f11, float f12, float f13) {
        if (f10 == this.f9744z.f9745w.left && f11 == this.f9744z.f9745w.top && f12 == this.f9744z.f9745w.right && f13 == this.f9744z.f9745w.bottom) {
            return;
        }
        this.f9744z.f9745w.set(f10, f11, f12, f13);
        invalidateSelf();
    }

    void p0(@NonNull RectF rectF) {
        o0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    /* JADX INFO: compiled from: CutoutDrawable.java */
    private static final class b extends g.c {

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        @NonNull
        private final RectF f9745w;

        @Override // x4.g.c, android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            h hVarK0 = h.k0(this);
            hVarK0.invalidateSelf();
            return hVarK0;
        }

        private b(@NonNull x4.k kVar, @NonNull RectF rectF) {
            super(kVar, null);
            this.f9745w = rectF;
        }

        private b(@NonNull b bVar) {
            super(bVar);
            this.f9745w = bVar.f9745w;
        }
    }

    private h(@NonNull b bVar) {
        super(bVar);
        this.f9744z = bVar;
    }
}
