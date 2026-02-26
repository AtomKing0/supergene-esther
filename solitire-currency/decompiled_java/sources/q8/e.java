package q8;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Numbers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    @NotNull
    public static final Void a(long j10, @NotNull String name) {
        t.i(name, "name");
        throw new IllegalArgumentException("Long value " + j10 + " of " + name + " doesn't fit into 32-bit integer");
    }
}
