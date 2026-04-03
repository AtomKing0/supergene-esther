package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.g;

/* JADX INFO: compiled from: CoroutineName.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class n0 extends z8.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f29957b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f29958a;

    /* JADX INFO: compiled from: CoroutineName.kt */
    public static final class a implements g.c<n0> {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public n0(@NotNull String str) {
        super(f29957b);
        this.f29958a = str;
    }

    @NotNull
    public final String I0() {
        return this.f29958a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof n0) && kotlin.jvm.internal.t.d(this.f29958a, ((n0) obj).f29958a);
    }

    public int hashCode() {
        return this.f29958a.hashCode();
    }

    @NotNull
    public String toString() {
        return "CoroutineName(" + this.f29958a + ')';
    }
}
