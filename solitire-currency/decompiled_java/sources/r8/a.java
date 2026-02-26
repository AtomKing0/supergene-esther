package r8;

import h9.l;
import io.ktor.utils.io.g;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.m0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Writing.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: r8.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Writing.kt */
    @f(c = "io.ktor.utils.io.jvm.nio.WritingKt", f = "Writing.kt", l = {50}, m = "copyTo")
    static final class C0665a extends d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f33325j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f33326k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Object f33327l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        long f33328m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        /* synthetic */ Object f33329n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        int f33330o;

        C0665a(z8.d<? super C0665a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f33329n = obj;
            this.f33330o |= Integer.MIN_VALUE;
            return a.a(null, null, 0L, this);
        }
    }

    /* JADX INFO: compiled from: Writing.kt */
    static final class b extends v implements l<ByteBuffer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f33331g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ m0 f33332h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ WritableByteChannel f33333i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(long j10, m0 m0Var, WritableByteChannel writableByteChannel) {
            super(1);
            this.f33331g = j10;
            this.f33332h = m0Var;
            this.f33333i = writableByteChannel;
        }

        public final void a(@NotNull ByteBuffer bb2) throws IOException {
            t.i(bb2, "bb");
            long j10 = this.f33331g - this.f33332h.f29833a;
            if (j10 >= bb2.remaining()) {
                long jWrite = 0;
                while (bb2.hasRemaining()) {
                    jWrite += (long) this.f33333i.write(bb2);
                }
                this.f33332h.f29833a += jWrite;
                return;
            }
            int iLimit = bb2.limit();
            bb2.limit(bb2.position() + ((int) j10));
            while (bb2.hasRemaining()) {
                this.f33333i.write(bb2);
            }
            bb2.limit(iLimit);
            this.f33332h.f29833a += j10;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(ByteBuffer byteBuffer) throws IOException {
            a(byteBuffer);
            return k0.f35197a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0085 A[PHI: r2 r8 r10 r12
      0x0085: PHI (r2v2 h9.l<? super java.nio.ByteBuffer, v8.k0>) = (r2v1 h9.l<? super java.nio.ByteBuffer, v8.k0>), (r2v3 h9.l<? super java.nio.ByteBuffer, v8.k0>) binds: [B:33:0x007b, B:40:0x00a0] A[DONT_GENERATE, DONT_INLINE]
      0x0085: PHI (r8v11 io.ktor.utils.io.g) = (r8v0 io.ktor.utils.io.g), (r8v12 io.ktor.utils.io.g) binds: [B:33:0x007b, B:40:0x00a0] A[DONT_GENERATE, DONT_INLINE]
      0x0085: PHI (r10v1 long) = (r10v0 long), (r10v2 long) binds: [B:33:0x007b, B:40:0x00a0] A[DONT_GENERATE, DONT_INLINE]
      0x0085: PHI (r12v13 kotlin.jvm.internal.m0) = (r12v7 kotlin.jvm.internal.m0), (r12v14 kotlin.jvm.internal.m0) binds: [B:33:0x007b, B:40:0x00a0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0099 -> B:39:0x009c). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(@org.jetbrains.annotations.NotNull io.ktor.utils.io.g r8, @org.jetbrains.annotations.NotNull java.nio.channels.WritableByteChannel r9, long r10, @org.jetbrains.annotations.NotNull z8.d<? super java.lang.Long> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r8.a.a(io.ktor.utils.io.g, java.nio.channels.WritableByteChannel, long, z8.d):java.lang.Object");
    }

    public static /* synthetic */ Object b(g gVar, WritableByteChannel writableByteChannel, long j10, z8.d dVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = Long.MAX_VALUE;
        }
        return a(gVar, writableByteChannel, j10, dVar);
    }
}
