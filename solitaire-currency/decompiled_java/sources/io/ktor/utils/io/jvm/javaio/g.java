package io.ktor.utils.io.jvm.javaio;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Pollers.kt */
/* JADX INFO: loaded from: classes3.dex */
final class g implements e<Thread> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f26907a = new g();

    private g() {
    }

    private final Void c() {
        throw new UnsupportedOperationException("Parking is prohibited on this thread. Most likely you are using blocking operation on the wrong thread/dispatcher that doesn't allow blocking. Consider wrapping you blocking code withContext(Dispatchers.IO) {...}.");
    }

    @Override // io.ktor.utils.io.jvm.javaio.e
    public void a(long j10) {
        c();
        throw new v8.h();
    }

    @Override // io.ktor.utils.io.jvm.javaio.e
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull Thread token) {
        t.i(token, "token");
        c.f26895a.b(token);
    }
}
