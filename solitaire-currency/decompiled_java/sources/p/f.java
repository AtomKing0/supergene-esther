package p;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p.i;
import v.n;

/* JADX INFO: compiled from: DrawableFetcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Drawable f32343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final n f32344b;

    /* JADX INFO: compiled from: DrawableFetcher.kt */
    public static final class a implements i.a<Drawable> {
        @Override // p.i.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public i a(@NotNull Drawable drawable, @NotNull n nVar, @NotNull j.e eVar) {
            return new f(drawable, nVar);
        }
    }

    public f(@NotNull Drawable drawable, @NotNull n nVar) {
        this.f32343a = drawable;
        this.f32344b = nVar;
    }

    @Override // p.i
    @Nullable
    public Object a(@NotNull z8.d<? super h> dVar) {
        Drawable bitmapDrawable;
        boolean zU = a0.j.u(this.f32343a);
        if (zU) {
            bitmapDrawable = new BitmapDrawable(this.f32344b.g().getResources(), a0.l.f48a.a(this.f32343a, this.f32344b.f(), this.f32344b.n(), this.f32344b.m(), this.f32344b.c()));
        } else {
            bitmapDrawable = this.f32343a;
        }
        return new g(bitmapDrawable, zU, m.f.MEMORY);
    }
}
