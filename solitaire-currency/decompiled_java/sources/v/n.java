package v;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.os.Build;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Options.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Context f34939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Bitmap.Config f34940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final ColorSpace f34941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final w.i f34942d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final w.h f34943e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f34944f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f34945g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f34946h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private final String f34947i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private final ga.u f34948j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private final s f34949k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private final o f34950l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    private final b f34951m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    private final b f34952n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    private final b f34953o;

    public n(@NotNull Context context, @NotNull Bitmap.Config config, @Nullable ColorSpace colorSpace, @NotNull w.i iVar, @NotNull w.h hVar, boolean z10, boolean z11, boolean z12, @Nullable String str, @NotNull ga.u uVar, @NotNull s sVar, @NotNull o oVar, @NotNull b bVar, @NotNull b bVar2, @NotNull b bVar3) {
        this.f34939a = context;
        this.f34940b = config;
        this.f34941c = colorSpace;
        this.f34942d = iVar;
        this.f34943e = hVar;
        this.f34944f = z10;
        this.f34945g = z11;
        this.f34946h = z12;
        this.f34947i = str;
        this.f34948j = uVar;
        this.f34949k = sVar;
        this.f34950l = oVar;
        this.f34951m = bVar;
        this.f34952n = bVar2;
        this.f34953o = bVar3;
    }

    @NotNull
    public final n a(@NotNull Context context, @NotNull Bitmap.Config config, @Nullable ColorSpace colorSpace, @NotNull w.i iVar, @NotNull w.h hVar, boolean z10, boolean z11, boolean z12, @Nullable String str, @NotNull ga.u uVar, @NotNull s sVar, @NotNull o oVar, @NotNull b bVar, @NotNull b bVar2, @NotNull b bVar3) {
        return new n(context, config, colorSpace, iVar, hVar, z10, z11, z12, str, uVar, sVar, oVar, bVar, bVar2, bVar3);
    }

    public final boolean c() {
        return this.f34944f;
    }

    public final boolean d() {
        return this.f34945g;
    }

    @Nullable
    public final ColorSpace e() {
        return this.f34941c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (kotlin.jvm.internal.t.d(this.f34939a, nVar.f34939a) && this.f34940b == nVar.f34940b && ((Build.VERSION.SDK_INT < 26 || kotlin.jvm.internal.t.d(this.f34941c, nVar.f34941c)) && kotlin.jvm.internal.t.d(this.f34942d, nVar.f34942d) && this.f34943e == nVar.f34943e && this.f34944f == nVar.f34944f && this.f34945g == nVar.f34945g && this.f34946h == nVar.f34946h && kotlin.jvm.internal.t.d(this.f34947i, nVar.f34947i) && kotlin.jvm.internal.t.d(this.f34948j, nVar.f34948j) && kotlin.jvm.internal.t.d(this.f34949k, nVar.f34949k) && kotlin.jvm.internal.t.d(this.f34950l, nVar.f34950l) && this.f34951m == nVar.f34951m && this.f34952n == nVar.f34952n && this.f34953o == nVar.f34953o)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final Bitmap.Config f() {
        return this.f34940b;
    }

    @NotNull
    public final Context g() {
        return this.f34939a;
    }

    @Nullable
    public final String h() {
        return this.f34947i;
    }

    public int hashCode() {
        int iHashCode = ((this.f34939a.hashCode() * 31) + this.f34940b.hashCode()) * 31;
        ColorSpace colorSpace = this.f34941c;
        int iHashCode2 = (((((((((((iHashCode + (colorSpace != null ? colorSpace.hashCode() : 0)) * 31) + this.f34942d.hashCode()) * 31) + this.f34943e.hashCode()) * 31) + androidx.compose.foundation.e.a(this.f34944f)) * 31) + androidx.compose.foundation.e.a(this.f34945g)) * 31) + androidx.compose.foundation.e.a(this.f34946h)) * 31;
        String str = this.f34947i;
        return ((((((((((((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.f34948j.hashCode()) * 31) + this.f34949k.hashCode()) * 31) + this.f34950l.hashCode()) * 31) + this.f34951m.hashCode()) * 31) + this.f34952n.hashCode()) * 31) + this.f34953o.hashCode();
    }

    @NotNull
    public final b i() {
        return this.f34952n;
    }

    @NotNull
    public final ga.u j() {
        return this.f34948j;
    }

    @NotNull
    public final b k() {
        return this.f34953o;
    }

    public final boolean l() {
        return this.f34946h;
    }

    @NotNull
    public final w.h m() {
        return this.f34943e;
    }

    @NotNull
    public final w.i n() {
        return this.f34942d;
    }

    @NotNull
    public final s o() {
        return this.f34949k;
    }
}
