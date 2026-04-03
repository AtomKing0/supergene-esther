package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class k2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final u9.h0 f29935a = new u9.h0("COMPLETING_ALREADY");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final u9.h0 f29936b = new u9.h0("COMPLETING_WAITING_CHILDREN");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final u9.h0 f29937c = new u9.h0("COMPLETING_RETRY");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private static final u9.h0 f29938d = new u9.h0("TOO_LATE_TO_CANCEL");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final u9.h0 f29939e = new u9.h0("SEALED");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final j1 f29940f = new j1(false);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private static final j1 f29941g = new j1(true);

    @Nullable
    public static final Object g(@Nullable Object obj) {
        return obj instanceof v1 ? new w1((v1) obj) : obj;
    }

    @Nullable
    public static final Object h(@Nullable Object obj) {
        v1 v1Var;
        w1 w1Var = obj instanceof w1 ? (w1) obj : null;
        return (w1Var == null || (v1Var = w1Var.f29991a) == null) ? obj : v1Var;
    }
}
