package io.ktor.utils.io;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ByteReadChannelJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: compiled from: ByteReadChannelJVM.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.ByteReadChannelJVMKt", f = "ByteReadChannelJVM.kt", l = {309, 312}, m = "copyToImpl")
    static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f26804j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f26805k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Object f26806l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        long f26807m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        long f26808n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        int f26809o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        int f26810p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        /* synthetic */ Object f26811q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        int f26812r;

        a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f26811q = obj;
            this.f26812r |= Integer.MIN_VALUE;
            return h.c(null, null, 0L, this);
        }
    }

    @Nullable
    public static final Object b(@NotNull g gVar, @NotNull j jVar, long j10, @NotNull z8.d<? super Long> dVar) {
        if (gVar != jVar) {
            return j10 == 0 ? kotlin.coroutines.jvm.internal.b.e(0L) : ((gVar instanceof io.ktor.utils.io.a) && (jVar instanceof io.ktor.utils.io.a)) ? ((io.ktor.utils.io.a) jVar).J((io.ktor.utils.io.a) gVar, j10, null, dVar) : ((gVar instanceof f) && (jVar instanceof f)) ? io.ktor.utils.io.internal.j.b((f) gVar, (f) jVar, Long.MAX_VALUE, dVar) : c(gVar, jVar, j10, dVar);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0097 A[Catch: all -> 0x00ff, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00ff, blocks: (B:37:0x00f5, B:39:0x00fb, B:25:0x0097), top: B:56:0x00f5 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d0 A[Catch: all -> 0x006f, TRY_LEAVE, TryCatch #2 {all -> 0x006f, blocks: (B:13:0x0040, B:29:0x00c7, B:31:0x00d0, B:46:0x010f, B:18:0x006b), top: B:58:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v3, types: [int] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00e7 -> B:35:0x00f1). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(io.ktor.utils.io.g r21, io.ktor.utils.io.j r22, long r23, z8.d<? super java.lang.Long> r25) {
        /*
            Method dump skipped, instruction units count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.h.c(io.ktor.utils.io.g, io.ktor.utils.io.j, long, z8.d):java.lang.Object");
    }
}
