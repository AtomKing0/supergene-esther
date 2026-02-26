package io.ktor.utils.io.jvm.javaio;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.InputStream;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.f2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Blocking.kt */
/* JADX INFO: loaded from: classes3.dex */
final class d extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final io.ktor.utils.io.g f26896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final a0 f26897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final a f26898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private byte[] f26899d;

    /* JADX INFO: compiled from: Blocking.kt */
    public static final class a extends io.ktor.utils.io.jvm.javaio.a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d f26900g;

        /* JADX INFO: renamed from: io.ktor.utils.io.jvm.javaio.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Blocking.kt */
        @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1", f = "Blocking.kt", l = {Sdk$SDKError.b.SILENT_MODE_MONITOR_ERROR_VALUE, 38}, m = "loop")
        static final class C0579a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            Object f26901j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            Object f26902k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            /* synthetic */ Object f26903l;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            int f26905n;

            C0579a(z8.d<? super C0579a> dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f26903l = obj;
                this.f26905n |= Integer.MIN_VALUE;
                return a.this.h(this);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(b2 b2Var, d dVar) {
            super(b2Var);
            this.f26900g = dVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0060 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0083 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x008d  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0081 -> B:25:0x0084). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // io.ktor.utils.io.jvm.javaio.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected java.lang.Object h(@org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r10) {
            /*
                r9 = this;
                boolean r0 = r10 instanceof io.ktor.utils.io.jvm.javaio.d.a.C0579a
                if (r0 == 0) goto L13
                r0 = r10
                io.ktor.utils.io.jvm.javaio.d$a$a r0 = (io.ktor.utils.io.jvm.javaio.d.a.C0579a) r0
                int r1 = r0.f26905n
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f26905n = r1
                goto L18
            L13:
                io.ktor.utils.io.jvm.javaio.d$a$a r0 = new io.ktor.utils.io.jvm.javaio.d$a$a
                r0.<init>(r10)
            L18:
                java.lang.Object r10 = r0.f26903l
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.f26905n
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L44
                if (r2 == r4) goto L38
                if (r2 != r3) goto L30
                java.lang.Object r2 = r0.f26901j
                io.ktor.utils.io.jvm.javaio.d$a r2 = (io.ktor.utils.io.jvm.javaio.d.a) r2
                v8.u.b(r10)
                goto L84
            L30:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L38:
                java.lang.Object r2 = r0.f26902k
                io.ktor.utils.io.jvm.javaio.a r2 = (io.ktor.utils.io.jvm.javaio.a) r2
                java.lang.Object r2 = r0.f26901j
                io.ktor.utils.io.jvm.javaio.d$a r2 = (io.ktor.utils.io.jvm.javaio.d.a) r2
                v8.u.b(r10)
                goto L61
            L44:
                v8.u.b(r10)
                r10 = 0
                r2 = r9
            L49:
                r2.result = r10
                r0.f26901j = r2
                r0.f26902k = r2
                r0.f26905n = r4
                java.lang.Object r10 = io.ktor.utils.io.jvm.javaio.a.c(r2, r0)
                java.lang.Object r5 = a9.b.e()
                if (r10 != r5) goto L5e
                kotlin.coroutines.jvm.internal.h.c(r0)
            L5e:
                if (r10 != r1) goto L61
                return r1
            L61:
                java.lang.String r5 = "null cannot be cast to non-null type kotlin.ByteArray"
                kotlin.jvm.internal.t.g(r10, r5)
                byte[] r10 = (byte[]) r10
                io.ktor.utils.io.jvm.javaio.d r5 = r2.f26900g
                io.ktor.utils.io.g r5 = io.ktor.utils.io.jvm.javaio.d.a(r5)
                int r6 = r2.f()
                int r7 = r2.e()
                r0.f26901j = r2
                r8 = 0
                r0.f26902k = r8
                r0.f26905n = r3
                java.lang.Object r10 = r5.g(r10, r6, r7, r0)
                if (r10 != r1) goto L84
                return r1
            L84:
                java.lang.Number r10 = (java.lang.Number) r10
                int r10 = r10.intValue()
                r5 = -1
                if (r10 != r5) goto L49
                io.ktor.utils.io.jvm.javaio.d r0 = r2.f26900g
                kotlinx.coroutines.a0 r0 = io.ktor.utils.io.jvm.javaio.d.c(r0)
                r0.complete()
                r2.d(r10)
                v8.k0 r10 = v8.k0.f35197a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.javaio.d.a.h(z8.d):java.lang.Object");
        }
    }

    public d(@Nullable b2 b2Var, @NotNull io.ktor.utils.io.g channel) {
        t.i(channel, "channel");
        this.f26896a = channel;
        this.f26897b = f2.a(b2Var);
        this.f26898c = new a(b2Var, this);
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f26896a.f();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        super.close();
        io.ktor.utils.io.i.a(this.f26896a);
        if (!this.f26897b.i()) {
            b2.a.a(this.f26897b, null, 1, null);
        }
        this.f26898c.k();
    }

    @Override // java.io.InputStream
    public synchronized int read() {
        byte[] bArr = this.f26899d;
        if (bArr == null) {
            bArr = new byte[1];
            this.f26899d = bArr;
        }
        int iM = this.f26898c.m(bArr, 0, 1);
        if (iM == -1) {
            return -1;
        }
        if (iM == 1) {
            return bArr[0] & 255;
        }
        throw new IllegalStateException(("Expected a single byte or EOF. Got " + iM + " bytes.").toString());
    }

    @Override // java.io.InputStream
    public synchronized int read(@Nullable byte[] bArr, int i10, int i11) {
        a aVar;
        aVar = this.f26898c;
        t.f(bArr);
        return aVar.m(bArr, i10, i11);
    }
}
