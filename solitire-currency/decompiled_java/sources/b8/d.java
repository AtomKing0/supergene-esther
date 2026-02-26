package b8;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HttpResponsePipeline.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final m8.a f2246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Object f2247b;

    public d(@NotNull m8.a expectedType, @NotNull Object response) {
        t.i(expectedType, "expectedType");
        t.i(response, "response");
        this.f2246a = expectedType;
        this.f2247b = response;
    }

    @NotNull
    public final m8.a a() {
        return this.f2246a;
    }

    @NotNull
    public final Object b() {
        return this.f2247b;
    }

    @NotNull
    public final Object c() {
        return this.f2247b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return t.d(this.f2246a, dVar.f2246a) && t.d(this.f2247b, dVar.f2247b);
    }

    public int hashCode() {
        return (this.f2246a.hashCode() * 31) + this.f2247b.hashCode();
    }

    @NotNull
    public String toString() {
        return "HttpResponseContainer(expectedType=" + this.f2246a + ", response=" + this.f2247b + ')';
    }
}
