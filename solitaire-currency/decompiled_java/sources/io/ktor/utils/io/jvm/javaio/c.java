package io.ktor.utils.io.jvm.javaio;

import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Pollers.kt */
/* JADX INFO: loaded from: classes3.dex */
final class c implements e<Thread> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f26895a = new c();

    private c() {
    }

    @Override // io.ktor.utils.io.jvm.javaio.e
    public void a(long j10) {
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        LockSupport.parkNanos(j10);
    }

    @Override // io.ktor.utils.io.jvm.javaio.e
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull Thread token) {
        t.i(token, "token");
        LockSupport.unpark(token);
    }
}
