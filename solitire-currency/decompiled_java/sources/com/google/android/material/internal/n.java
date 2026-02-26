package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: TextDrawableHelper.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f9482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f9483d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private u4.d f9486g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextPaint f9480a = new TextPaint(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u4.f f9481b = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f9484e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private WeakReference<b> f9485f = new WeakReference<>(null);

    /* JADX INFO: compiled from: TextDrawableHelper.java */
    class a extends u4.f {
        a() {
        }

        @Override // u4.f
        public void a(int i10) {
            n.this.f9484e = true;
            b bVar = (b) n.this.f9485f.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // u4.f
        public void b(@NonNull Typeface typeface, boolean z10) {
            if (z10) {
                return;
            }
            n.this.f9484e = true;
            b bVar = (b) n.this.f9485f.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* JADX INFO: compiled from: TextDrawableHelper.java */
    public interface b {
        void a();

        @NonNull
        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public n(@Nullable b bVar) {
        i(bVar);
    }

    private float c(@Nullable String str) {
        if (str == null) {
            return 0.0f;
        }
        return Math.abs(this.f9480a.getFontMetrics().ascent);
    }

    private float d(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f9480a.measureText(charSequence, 0, charSequence.length());
    }

    private void h(String str) {
        this.f9482c = d(str);
        this.f9483d = c(str);
        this.f9484e = false;
    }

    @Nullable
    public u4.d e() {
        return this.f9486g;
    }

    @NonNull
    public TextPaint f() {
        return this.f9480a;
    }

    public float g(String str) {
        if (!this.f9484e) {
            return this.f9482c;
        }
        h(str);
        return this.f9482c;
    }

    public void i(@Nullable b bVar) {
        this.f9485f = new WeakReference<>(bVar);
    }

    public void j(@Nullable u4.d dVar, Context context) {
        if (this.f9486g != dVar) {
            this.f9486g = dVar;
            if (dVar != null) {
                dVar.o(context, this.f9480a, this.f9481b);
                b bVar = this.f9485f.get();
                if (bVar != null) {
                    this.f9480a.drawableState = bVar.getState();
                }
                dVar.n(context, this.f9480a, this.f9481b);
                this.f9484e = true;
            }
            b bVar2 = this.f9485f.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void k(boolean z10) {
        this.f9484e = z10;
    }

    public void l(Context context) {
        this.f9486g.n(context, this.f9480a, this.f9481b);
    }
}
