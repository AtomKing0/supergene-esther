package v;

import android.graphics.Bitmap;
import androidx.lifecycle.Lifecycle;
import kotlinx.coroutines.k0;
import org.jetbrains.annotations.Nullable;
import z.c;

/* JADX INFO: compiled from: DefinedRequestOptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final Lifecycle f34865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final w.j f34866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final w.h f34867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final k0 f34868d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final k0 f34869e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private final k0 f34870f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private final k0 f34871g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private final c.a f34872h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private final w.e f34873i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private final Bitmap.Config f34874j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private final Boolean f34875k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private final Boolean f34876l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private final b f34877m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private final b f34878n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private final b f34879o;

    public d(@Nullable Lifecycle lifecycle, @Nullable w.j jVar, @Nullable w.h hVar, @Nullable k0 k0Var, @Nullable k0 k0Var2, @Nullable k0 k0Var3, @Nullable k0 k0Var4, @Nullable c.a aVar, @Nullable w.e eVar, @Nullable Bitmap.Config config, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable b bVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.f34865a = lifecycle;
        this.f34866b = jVar;
        this.f34867c = hVar;
        this.f34868d = k0Var;
        this.f34869e = k0Var2;
        this.f34870f = k0Var3;
        this.f34871g = k0Var4;
        this.f34872h = aVar;
        this.f34873i = eVar;
        this.f34874j = config;
        this.f34875k = bool;
        this.f34876l = bool2;
        this.f34877m = bVar;
        this.f34878n = bVar2;
        this.f34879o = bVar3;
    }

    @Nullable
    public final Boolean a() {
        return this.f34875k;
    }

    @Nullable
    public final Boolean b() {
        return this.f34876l;
    }

    @Nullable
    public final Bitmap.Config c() {
        return this.f34874j;
    }

    @Nullable
    public final k0 d() {
        return this.f34870f;
    }

    @Nullable
    public final b e() {
        return this.f34878n;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (kotlin.jvm.internal.t.d(this.f34865a, dVar.f34865a) && kotlin.jvm.internal.t.d(this.f34866b, dVar.f34866b) && this.f34867c == dVar.f34867c && kotlin.jvm.internal.t.d(this.f34868d, dVar.f34868d) && kotlin.jvm.internal.t.d(this.f34869e, dVar.f34869e) && kotlin.jvm.internal.t.d(this.f34870f, dVar.f34870f) && kotlin.jvm.internal.t.d(this.f34871g, dVar.f34871g) && kotlin.jvm.internal.t.d(this.f34872h, dVar.f34872h) && this.f34873i == dVar.f34873i && this.f34874j == dVar.f34874j && kotlin.jvm.internal.t.d(this.f34875k, dVar.f34875k) && kotlin.jvm.internal.t.d(this.f34876l, dVar.f34876l) && this.f34877m == dVar.f34877m && this.f34878n == dVar.f34878n && this.f34879o == dVar.f34879o) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final k0 f() {
        return this.f34869e;
    }

    @Nullable
    public final k0 g() {
        return this.f34868d;
    }

    @Nullable
    public final Lifecycle h() {
        return this.f34865a;
    }

    public int hashCode() {
        Lifecycle lifecycle = this.f34865a;
        int iHashCode = (lifecycle != null ? lifecycle.hashCode() : 0) * 31;
        w.j jVar = this.f34866b;
        int iHashCode2 = (iHashCode + (jVar != null ? jVar.hashCode() : 0)) * 31;
        w.h hVar = this.f34867c;
        int iHashCode3 = (iHashCode2 + (hVar != null ? hVar.hashCode() : 0)) * 31;
        k0 k0Var = this.f34868d;
        int iHashCode4 = (iHashCode3 + (k0Var != null ? k0Var.hashCode() : 0)) * 31;
        k0 k0Var2 = this.f34869e;
        int iHashCode5 = (iHashCode4 + (k0Var2 != null ? k0Var2.hashCode() : 0)) * 31;
        k0 k0Var3 = this.f34870f;
        int iHashCode6 = (iHashCode5 + (k0Var3 != null ? k0Var3.hashCode() : 0)) * 31;
        k0 k0Var4 = this.f34871g;
        int iHashCode7 = (iHashCode6 + (k0Var4 != null ? k0Var4.hashCode() : 0)) * 31;
        c.a aVar = this.f34872h;
        int iHashCode8 = (iHashCode7 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        w.e eVar = this.f34873i;
        int iHashCode9 = (iHashCode8 + (eVar != null ? eVar.hashCode() : 0)) * 31;
        Bitmap.Config config = this.f34874j;
        int iHashCode10 = (iHashCode9 + (config != null ? config.hashCode() : 0)) * 31;
        Boolean bool = this.f34875k;
        int iHashCode11 = (iHashCode10 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.f34876l;
        int iHashCode12 = (iHashCode11 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        b bVar = this.f34877m;
        int iHashCode13 = (iHashCode12 + (bVar != null ? bVar.hashCode() : 0)) * 31;
        b bVar2 = this.f34878n;
        int iHashCode14 = (iHashCode13 + (bVar2 != null ? bVar2.hashCode() : 0)) * 31;
        b bVar3 = this.f34879o;
        return iHashCode14 + (bVar3 != null ? bVar3.hashCode() : 0);
    }

    @Nullable
    public final b i() {
        return this.f34877m;
    }

    @Nullable
    public final b j() {
        return this.f34879o;
    }

    @Nullable
    public final w.e k() {
        return this.f34873i;
    }

    @Nullable
    public final w.h l() {
        return this.f34867c;
    }

    @Nullable
    public final w.j m() {
        return this.f34866b;
    }

    @Nullable
    public final k0 n() {
        return this.f34871g;
    }

    @Nullable
    public final c.a o() {
        return this.f34872h;
    }
}
