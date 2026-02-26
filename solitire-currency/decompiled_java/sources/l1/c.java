package l1;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import o1.k;

/* JADX INFO: compiled from: CustomTarget.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c<T> implements h<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f30214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f30215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private k1.c f30216c;

    public c() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // l1.h
    public final void a(@Nullable k1.c cVar) {
        this.f30216c = cVar;
    }

    @Override // l1.h
    public final void e(@NonNull g gVar) {
        gVar.c(this.f30214a, this.f30215b);
    }

    @Override // l1.h
    @Nullable
    public final k1.c getRequest() {
        return this.f30216c;
    }

    public c(int i10, int i11) {
        if (k.r(i10, i11)) {
            this.f30214a = i10;
            this.f30215b = i11;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i10 + " and height: " + i11);
    }

    @Override // h1.i
    public void onDestroy() {
    }

    @Override // h1.i
    public void onStart() {
    }

    @Override // h1.i
    public void onStop() {
    }

    @Override // l1.h
    public final void b(@NonNull g gVar) {
    }

    @Override // l1.h
    public void c(@Nullable Drawable drawable) {
    }

    @Override // l1.h
    public void f(@Nullable Drawable drawable) {
    }
}
