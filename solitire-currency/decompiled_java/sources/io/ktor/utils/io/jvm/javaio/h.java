package io.ktor.utils.io.jvm.javaio;

import h9.p;
import io.ktor.utils.io.q;
import io.ktor.utils.io.w;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.t1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: Reading.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: compiled from: Reading.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.jvm.javaio.ReadingKt$toByteReadChannel$1", f = "Reading.kt", l = {61}, m = "invokeSuspend")
    static final class a extends l implements p<w, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f26908j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f26909k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private /* synthetic */ Object f26910l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ s8.g<ByteBuffer> f26911m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final /* synthetic */ InputStream f26912n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(s8.g<ByteBuffer> gVar, InputStream inputStream, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f26911m = gVar;
            this.f26912n = inputStream;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            a aVar = new a(this.f26911m, this.f26912n, dVar);
            aVar.f26910l = obj;
            return aVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull w wVar, @Nullable z8.d<? super k0> dVar) {
            return ((a) create(wVar, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws IOException {
            ByteBuffer byteBufferK0;
            w wVar;
            Throwable th;
            a aVar;
            InputStream inputStream;
            Object objE = a9.d.e();
            int i10 = this.f26909k;
            if (i10 == 0) {
                u.b(obj);
                w wVar2 = (w) this.f26910l;
                byteBufferK0 = this.f26911m.k0();
                wVar = wVar2;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                byteBufferK0 = (ByteBuffer) this.f26908j;
                wVar = (w) this.f26910l;
                try {
                    u.b(obj);
                } catch (Throwable th2) {
                    th = th2;
                    aVar = this;
                    try {
                        wVar.mo4209a().d(th);
                        aVar.f26911m.C0(byteBufferK0);
                        inputStream = aVar.f26912n;
                        inputStream.close();
                        return k0.f35197a;
                    } catch (Throwable th3) {
                        aVar.f26911m.C0(byteBufferK0);
                        aVar.f26912n.close();
                        throw th3;
                    }
                }
            }
            while (true) {
                try {
                    byteBufferK0.clear();
                    int i11 = this.f26912n.read(byteBufferK0.array(), byteBufferK0.arrayOffset() + byteBufferK0.position(), byteBufferK0.remaining());
                    if (i11 < 0) {
                        this.f26911m.C0(byteBufferK0);
                        inputStream = this.f26912n;
                        break;
                    }
                    if (i11 != 0) {
                        byteBufferK0.position(byteBufferK0.position() + i11);
                        byteBufferK0.flip();
                        io.ktor.utils.io.j jVarMo4209a = wVar.mo4209a();
                        this.f26910l = wVar;
                        this.f26908j = byteBufferK0;
                        this.f26909k = 1;
                        if (jVarMo4209a.j(byteBufferK0, this) == objE) {
                            return objE;
                        }
                    }
                } catch (Throwable th4) {
                    aVar = this;
                    th = th4;
                    wVar.mo4209a().d(th);
                    aVar.f26911m.C0(byteBufferK0);
                    inputStream = aVar.f26912n;
                }
            }
            inputStream.close();
            return k0.f35197a;
        }
    }

    /* JADX INFO: compiled from: Reading.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.jvm.javaio.ReadingKt$toByteReadChannel$2", f = "Reading.kt", l = {90}, m = "invokeSuspend")
    static final class b extends l implements p<w, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f26913j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f26914k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private /* synthetic */ Object f26915l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ s8.g<byte[]> f26916m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final /* synthetic */ InputStream f26917n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(s8.g<byte[]> gVar, InputStream inputStream, z8.d<? super b> dVar) {
            super(2, dVar);
            this.f26916m = gVar;
            this.f26917n = inputStream;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            b bVar = new b(this.f26916m, this.f26917n, dVar);
            bVar.f26915l = obj;
            return bVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull w wVar, @Nullable z8.d<? super k0> dVar) {
            return ((b) create(wVar, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws IOException {
            byte[] bArrK0;
            w wVar;
            Throwable th;
            b bVar;
            InputStream inputStream;
            Object objE = a9.d.e();
            int i10 = this.f26914k;
            if (i10 == 0) {
                u.b(obj);
                w wVar2 = (w) this.f26915l;
                bArrK0 = this.f26916m.k0();
                wVar = wVar2;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                bArrK0 = (byte[]) this.f26913j;
                wVar = (w) this.f26915l;
                try {
                    u.b(obj);
                } catch (Throwable th2) {
                    th = th2;
                    bVar = this;
                    try {
                        wVar.mo4209a().d(th);
                        bVar.f26916m.C0(bArrK0);
                        inputStream = bVar.f26917n;
                        inputStream.close();
                        return k0.f35197a;
                    } catch (Throwable th3) {
                        bVar.f26916m.C0(bArrK0);
                        bVar.f26917n.close();
                        throw th3;
                    }
                }
            }
            while (true) {
                try {
                    int i11 = this.f26917n.read(bArrK0, 0, bArrK0.length);
                    if (i11 < 0) {
                        this.f26916m.C0(bArrK0);
                        inputStream = this.f26917n;
                        break;
                    }
                    if (i11 != 0) {
                        io.ktor.utils.io.j jVarMo4209a = wVar.mo4209a();
                        this.f26915l = wVar;
                        this.f26913j = bArrK0;
                        this.f26914k = 1;
                        if (jVarMo4209a.l(bArrK0, 0, i11, this) == objE) {
                            return objE;
                        }
                    }
                } catch (Throwable th4) {
                    bVar = this;
                    th = th4;
                    wVar.mo4209a().d(th);
                    bVar.f26916m.C0(bArrK0);
                    inputStream = bVar.f26917n;
                }
            }
            inputStream.close();
            return k0.f35197a;
        }
    }

    @NotNull
    public static final io.ktor.utils.io.g a(@NotNull InputStream inputStream, @NotNull z8.g context, @NotNull s8.g<ByteBuffer> pool) {
        t.i(inputStream, "<this>");
        t.i(context, "context");
        t.i(pool, "pool");
        return q.d(t1.f29982a, context, true, new a(pool, inputStream, null)).mo4208a();
    }

    @NotNull
    public static final io.ktor.utils.io.g b(@NotNull InputStream inputStream, @NotNull z8.g context, @NotNull s8.g<byte[]> pool) {
        t.i(inputStream, "<this>");
        t.i(context, "context");
        t.i(pool, "pool");
        return q.d(t1.f29982a, context, true, new b(pool, inputStream, null)).mo4208a();
    }

    public static /* synthetic */ io.ktor.utils.io.g c(InputStream inputStream, z8.g gVar, s8.g gVar2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = e1.b();
        }
        if ((i10 & 2) != 0) {
            gVar2 = s8.a.a();
        }
        return b(inputStream, gVar, gVar2);
    }
}
