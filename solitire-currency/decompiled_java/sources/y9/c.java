package y9;

import org.jetbrains.annotations.NotNull;
import u9.h0;

/* JADX INFO: compiled from: Mutex.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final h0 f36915a = new h0("NO_OWNER");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final h0 f36916b = new h0("ALREADY_LOCKED_BY_OWNER");

    @NotNull
    public static final a a(boolean z10) {
        return new b(z10);
    }

    public static /* synthetic */ a b(boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return a(z10);
    }
}
