package v;

import android.graphics.drawable.Drawable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t.c;

/* JADX INFO: compiled from: ImageResult.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class r extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Drawable f34963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final i f34964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final m.f f34965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final c.b f34966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final String f34967e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f34968f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f34969g;

    public r(@NotNull Drawable drawable, @NotNull i iVar, @NotNull m.f fVar, @Nullable c.b bVar, @Nullable String str, boolean z10, boolean z11) {
        super(null);
        this.f34963a = drawable;
        this.f34964b = iVar;
        this.f34965c = fVar;
        this.f34966d = bVar;
        this.f34967e = str;
        this.f34968f = z10;
        this.f34969g = z11;
    }

    @Override // v.j
    @NotNull
    public Drawable a() {
        return this.f34963a;
    }

    @Override // v.j
    @NotNull
    public i b() {
        return this.f34964b;
    }

    @NotNull
    public final m.f c() {
        return this.f34965c;
    }

    public final boolean d() {
        return this.f34969g;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (kotlin.jvm.internal.t.d(a(), rVar.a()) && kotlin.jvm.internal.t.d(b(), rVar.b()) && this.f34965c == rVar.f34965c && kotlin.jvm.internal.t.d(this.f34966d, rVar.f34966d) && kotlin.jvm.internal.t.d(this.f34967e, rVar.f34967e) && this.f34968f == rVar.f34968f && this.f34969g == rVar.f34969g) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = ((((a().hashCode() * 31) + b().hashCode()) * 31) + this.f34965c.hashCode()) * 31;
        c.b bVar = this.f34966d;
        int iHashCode2 = (iHashCode + (bVar != null ? bVar.hashCode() : 0)) * 31;
        String str = this.f34967e;
        return ((((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + androidx.compose.foundation.e.a(this.f34968f)) * 31) + androidx.compose.foundation.e.a(this.f34969g);
    }
}
