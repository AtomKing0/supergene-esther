package h8;

import h9.p;
import io.ktor.utils.io.g;
import io.ktor.utils.io.j;
import io.ktor.utils.io.q;
import io.ktor.utils.io.u;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.t1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: FileChannels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: compiled from: FileChannels.kt */
    @f(c = "io.ktor.util.cio.FileChannelsKt$writeChannel$1", f = "FileChannels.kt", l = {96}, m = "invokeSuspend")
    static final class a extends l implements p<u, d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f26500j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f26501k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f26502l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private /* synthetic */ Object f26503m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final /* synthetic */ File f26504n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(File file, d<? super a> dVar) {
            super(2, dVar);
            this.f26504n = file;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            a aVar = new a(this.f26504n, dVar);
            aVar.f26503m = obj;
            return aVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull u uVar, @Nullable d<? super k0> dVar) {
            return ((a) create(uVar, dVar)).invokeSuspend(k0.f35197a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7 */
        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws IOException {
            RandomAccessFile randomAccessFile;
            Object objE = a9.d.e();
            ?? r12 = this.f26502l;
            try {
                if (r12 == 0) {
                    v8.u.b(obj);
                    u uVar = (u) this.f26503m;
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(this.f26504n, "rw");
                    g gVarMo4209a = uVar.mo4209a();
                    FileChannel channel = randomAccessFile2.getChannel();
                    t.h(channel, "file.channel");
                    this.f26503m = randomAccessFile2;
                    this.f26500j = randomAccessFile2;
                    this.f26501k = 0;
                    this.f26502l = 1;
                    obj = r8.a.b(gVarMo4209a, channel, 0L, this, 2, null);
                    if (obj == objE) {
                        return objE;
                    }
                    randomAccessFile = randomAccessFile2;
                    r12 = randomAccessFile2;
                } else {
                    if (r12 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    RandomAccessFile randomAccessFile3 = (RandomAccessFile) this.f26500j;
                    Closeable closeable = (Closeable) this.f26503m;
                    v8.u.b(obj);
                    randomAccessFile = randomAccessFile3;
                    r12 = closeable;
                }
                randomAccessFile.setLength(((Number) obj).longValue());
                k0 k0Var = k0.f35197a;
                r12.close();
                return k0.f35197a;
            } finally {
            }
        }
    }

    @NotNull
    public static final j a(@NotNull File file, @NotNull z8.g coroutineContext) {
        t.i(file, "<this>");
        t.i(coroutineContext, "coroutineContext");
        return q.b(t1.f29982a, new n0("file-writer").plus(coroutineContext), true, new a(file, null)).mo4208a();
    }

    public static /* synthetic */ j b(File file, z8.g gVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = e1.b();
        }
        return a(file, gVar);
    }
}
