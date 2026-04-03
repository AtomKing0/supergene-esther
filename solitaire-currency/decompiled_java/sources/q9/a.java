package q9;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TimeSource.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface a extends j, Comparable<a> {

    /* JADX INFO: renamed from: q9.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TimeSource.kt */
    public static final class C0661a {
        public static int a(@NotNull a aVar, @NotNull a other) {
            t.i(other, "other");
            return b.i(aVar.b(other), b.f33177b.c());
        }
    }

    long b(@NotNull a aVar);
}
