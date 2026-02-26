package io.ktor.util.internal;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LockFreeLinkedList.kt */
/* JADX INFO: loaded from: classes.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final c f26644a;

    public e(@NotNull c ref) {
        t.i(ref, "ref");
        this.f26644a = ref;
    }

    @NotNull
    public String toString() {
        return "Removed[" + this.f26644a + ']';
    }
}
