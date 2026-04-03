package x8;

import java.util.Comparator;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes5.dex */
final class f implements Comparator<Comparable<? super Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f36222a = new f();

    private f() {
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(@NotNull Comparable<Object> a10, @NotNull Comparable<Object> b10) {
        t.i(a10, "a");
        t.i(b10, "b");
        return b10.compareTo(a10);
    }

    @Override // java.util.Comparator
    @NotNull
    public final Comparator<Comparable<? super Object>> reversed() {
        return e.f36221a;
    }
}
