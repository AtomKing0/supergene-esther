package e8;

import e8.z;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parameters.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f implements z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final f f25234c = new f();

    private f() {
    }

    @Override // g8.t
    @NotNull
    public Set<Map.Entry<String, List<String>>> a() {
        return z0.e();
    }

    @Override // g8.t
    public boolean b() {
        return true;
    }

    @Override // g8.t
    @Nullable
    public List<String> c(@NotNull String name) {
        kotlin.jvm.internal.t.i(name, "name");
        return null;
    }

    @Override // g8.t
    public void d(@NotNull h9.p<? super String, ? super List<String>, v8.k0> pVar) {
        z.b.a(this, pVar);
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof z) && ((z) obj).isEmpty();
    }

    @Override // g8.t
    public boolean isEmpty() {
        return true;
    }

    @Override // g8.t
    @NotNull
    public Set<String> names() {
        return z0.e();
    }

    @NotNull
    public String toString() {
        return "Parameters " + a();
    }
}
