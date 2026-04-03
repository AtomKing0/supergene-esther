package v;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.k0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z.c;

/* JADX INFO: compiled from: DefaultRequestOptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final k0 f34850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final k0 f34851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final k0 f34852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final k0 f34853d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final c.a f34854e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final w.e f34855f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final Bitmap.Config f34856g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f34857h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f34858i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private final Drawable f34859j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private final Drawable f34860k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private final Drawable f34861l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    private final b f34862m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    private final b f34863n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    private final b f34864o;

    public c() {
        this(null, null, null, null, null, null, null, false, false, null, null, null, null, null, null, 32767, null);
    }

    public final boolean a() {
        return this.f34857h;
    }

    public final boolean b() {
        return this.f34858i;
    }

    @NotNull
    public final Bitmap.Config c() {
        return this.f34856g;
    }

    @NotNull
    public final k0 d() {
        return this.f34852c;
    }

    @NotNull
    public final b e() {
        return this.f34863n;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (kotlin.jvm.internal.t.d(this.f34850a, cVar.f34850a) && kotlin.jvm.internal.t.d(this.f34851b, cVar.f34851b) && kotlin.jvm.internal.t.d(this.f34852c, cVar.f34852c) && kotlin.jvm.internal.t.d(this.f34853d, cVar.f34853d) && kotlin.jvm.internal.t.d(this.f34854e, cVar.f34854e) && this.f34855f == cVar.f34855f && this.f34856g == cVar.f34856g && this.f34857h == cVar.f34857h && this.f34858i == cVar.f34858i && kotlin.jvm.internal.t.d(this.f34859j, cVar.f34859j) && kotlin.jvm.internal.t.d(this.f34860k, cVar.f34860k) && kotlin.jvm.internal.t.d(this.f34861l, cVar.f34861l) && this.f34862m == cVar.f34862m && this.f34863n == cVar.f34863n && this.f34864o == cVar.f34864o) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final Drawable f() {
        return this.f34860k;
    }

    @Nullable
    public final Drawable g() {
        return this.f34861l;
    }

    @NotNull
    public final k0 h() {
        return this.f34851b;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((this.f34850a.hashCode() * 31) + this.f34851b.hashCode()) * 31) + this.f34852c.hashCode()) * 31) + this.f34853d.hashCode()) * 31) + this.f34854e.hashCode()) * 31) + this.f34855f.hashCode()) * 31) + this.f34856g.hashCode()) * 31) + androidx.compose.foundation.e.a(this.f34857h)) * 31) + androidx.compose.foundation.e.a(this.f34858i)) * 31;
        Drawable drawable = this.f34859j;
        int iHashCode2 = (iHashCode + (drawable != null ? drawable.hashCode() : 0)) * 31;
        Drawable drawable2 = this.f34860k;
        int iHashCode3 = (iHashCode2 + (drawable2 != null ? drawable2.hashCode() : 0)) * 31;
        Drawable drawable3 = this.f34861l;
        return ((((((iHashCode3 + (drawable3 != null ? drawable3.hashCode() : 0)) * 31) + this.f34862m.hashCode()) * 31) + this.f34863n.hashCode()) * 31) + this.f34864o.hashCode();
    }

    @NotNull
    public final k0 i() {
        return this.f34850a;
    }

    @NotNull
    public final b j() {
        return this.f34862m;
    }

    @NotNull
    public final b k() {
        return this.f34864o;
    }

    @Nullable
    public final Drawable l() {
        return this.f34859j;
    }

    @NotNull
    public final w.e m() {
        return this.f34855f;
    }

    @NotNull
    public final k0 n() {
        return this.f34853d;
    }

    @NotNull
    public final c.a o() {
        return this.f34854e;
    }

    public c(@NotNull k0 k0Var, @NotNull k0 k0Var2, @NotNull k0 k0Var3, @NotNull k0 k0Var4, @NotNull c.a aVar, @NotNull w.e eVar, @NotNull Bitmap.Config config, boolean z10, boolean z11, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @NotNull b bVar, @NotNull b bVar2, @NotNull b bVar3) {
        this.f34850a = k0Var;
        this.f34851b = k0Var2;
        this.f34852c = k0Var3;
        this.f34853d = k0Var4;
        this.f34854e = aVar;
        this.f34855f = eVar;
        this.f34856g = config;
        this.f34857h = z10;
        this.f34858i = z11;
        this.f34859j = drawable;
        this.f34860k = drawable2;
        this.f34861l = drawable3;
        this.f34862m = bVar;
        this.f34863n = bVar2;
        this.f34864o = bVar3;
    }

    public /* synthetic */ c(k0 k0Var, k0 k0Var2, k0 k0Var3, k0 k0Var4, c.a aVar, w.e eVar, Bitmap.Config config, boolean z10, boolean z11, Drawable drawable, Drawable drawable2, Drawable drawable3, b bVar, b bVar2, b bVar3, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? e1.c().getImmediate() : k0Var, (i10 & 2) != 0 ? e1.b() : k0Var2, (i10 & 4) != 0 ? e1.b() : k0Var3, (i10 & 8) != 0 ? e1.b() : k0Var4, (i10 & 16) != 0 ? c.a.f36960b : aVar, (i10 & 32) != 0 ? w.e.AUTOMATIC : eVar, (i10 & 64) != 0 ? a0.j.f() : config, (i10 & 128) != 0 ? true : z10, (i10 & 256) != 0 ? false : z11, (i10 & 512) != 0 ? null : drawable, (i10 & 1024) != 0 ? null : drawable2, (i10 & 2048) == 0 ? drawable3 : null, (i10 & 4096) != 0 ? b.ENABLED : bVar, (i10 & 8192) != 0 ? b.ENABLED : bVar2, (i10 & 16384) != 0 ? b.ENABLED : bVar3);
    }
}
