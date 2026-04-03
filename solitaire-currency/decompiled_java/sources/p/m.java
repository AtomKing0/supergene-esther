package p;

import kotlin.jvm.internal.t;
import m.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FetchResult.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class m extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final p f32372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f32373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final m.f f32374c;

    public m(@NotNull p pVar, @Nullable String str, @NotNull m.f fVar) {
        super(null);
        this.f32372a = pVar;
        this.f32373b = str;
        this.f32374c = fVar;
    }

    @NotNull
    public final m.f a() {
        return this.f32374c;
    }

    @NotNull
    public final p b() {
        return this.f32372a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (t.d(this.f32372a, mVar.f32372a) && t.d(this.f32373b, mVar.f32373b) && this.f32374c == mVar.f32374c) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = this.f32372a.hashCode() * 31;
        String str = this.f32373b;
        return ((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f32374c.hashCode();
    }
}
