package y7;

import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: BodyProgress.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final g8.a<h9.q<Long, Long, z8.d<? super k0>, Object>> f36650a = new g8.a<>("UploadProgressListenerAttributeKey");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final g8.a<h9.q<Long, Long, z8.d<? super k0>, Object>> f36651b = new g8.a<>("DownloadProgressListenerAttributeKey");

    @NotNull
    public static final b8.c c(@NotNull b8.c cVar, @NotNull h9.q<? super Long, ? super Long, ? super z8.d<? super k0>, ? extends Object> listener) {
        kotlin.jvm.internal.t.i(cVar, "<this>");
        kotlin.jvm.internal.t.i(listener, "listener");
        return z7.b.a(cVar.R(), c8.a.a(cVar.c(), cVar.getCoroutineContext(), e8.s.b(cVar), listener)).f();
    }
}
