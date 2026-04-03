package io.ktor.util.internal;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LockFreeLinkedList.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Object f26636a = new f("CONDITION_FALSE");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Object f26637b = new f("ALREADY_REMOVED");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Object f26638c = new f("LIST_EMPTY");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Object f26639d = new f("REMOVE_PREPARED");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Object f26640e = new f("NO_DECISION");

    @NotNull
    public static final c a(@NotNull Object obj) {
        c cVar;
        t.i(obj, "<this>");
        e eVar = obj instanceof e ? (e) obj : null;
        return (eVar == null || (cVar = eVar.f26644a) == null) ? (c) obj : cVar;
    }
}
