package e8;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HttpProtocolVersion.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f25361d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final u f25362e = new u("HTTP", 2, 0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final u f25363f = new u("HTTP", 1, 1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private static final u f25364g = new u("HTTP", 1, 0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private static final u f25365h = new u("SPDY", 3, 0);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private static final u f25366i = new u("QUIC", 1, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f25367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f25368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f25369c;

    /* JADX INFO: compiled from: HttpProtocolVersion.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final u a() {
            return u.f25363f;
        }
    }

    public u(@NotNull String name, int i10, int i11) {
        kotlin.jvm.internal.t.i(name, "name");
        this.f25367a = name;
        this.f25368b = i10;
        this.f25369c = i11;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return kotlin.jvm.internal.t.d(this.f25367a, uVar.f25367a) && this.f25368b == uVar.f25368b && this.f25369c == uVar.f25369c;
    }

    public int hashCode() {
        return (((this.f25367a.hashCode() * 31) + this.f25368b) * 31) + this.f25369c;
    }

    @NotNull
    public String toString() {
        return this.f25367a + '/' + this.f25368b + '.' + this.f25369c;
    }
}
