package com.vungle.ads.internal.network;

import com.vungle.ads.internal.util.p;
import ga.d0;
import ga.e0;
import ga.x;
import java.io.IOException;
import java.util.Objects;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ua.k0;
import ua.m;

/* JADX INFO: compiled from: OkHttpCall.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c<T> implements com.vungle.ads.internal.network.a<T> {

    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    private static final String TAG = "OkHttpCall";
    private volatile boolean canceled;

    @NotNull
    private final ga.e rawCall;

    @NotNull
    private final com.vungle.ads.internal.network.converters.a<e0, T> responseConverter;

    /* JADX INFO: compiled from: OkHttpCall.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void throwIfFatal(Throwable th) throws Throwable {
            if ((th instanceof VirtualMachineError) || (th instanceof ThreadDeath) || (th instanceof LinkageError)) {
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: OkHttpCall.kt */
    public static final class b extends e0 {

        @NotNull
        private final e0 delegate;

        @NotNull
        private final ua.e delegateSource;

        @Nullable
        private IOException thrownException;

        /* JADX INFO: compiled from: OkHttpCall.kt */
        public static final class a extends m {
            a(ua.e eVar) {
                super(eVar);
            }

            @Override // ua.m, ua.z0
            public long read(@NotNull ua.c sink, long j10) throws IOException {
                t.i(sink, "sink");
                try {
                    return super.read(sink, j10);
                } catch (IOException e10) {
                    b.this.setThrownException(e10);
                    throw e10;
                }
            }
        }

        public b(@NotNull e0 delegate) {
            t.i(delegate, "delegate");
            this.delegate = delegate;
            this.delegateSource = k0.d(new a(delegate.source()));
        }

        @Override // ga.e0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
        }

        @Override // ga.e0
        public long contentLength() {
            return this.delegate.contentLength();
        }

        @Override // ga.e0
        @Nullable
        public x contentType() {
            return this.delegate.contentType();
        }

        @Nullable
        public final IOException getThrownException() {
            return this.thrownException;
        }

        public final void setThrownException(@Nullable IOException iOException) {
            this.thrownException = iOException;
        }

        @Override // ga.e0
        @NotNull
        public ua.e source() {
            return this.delegateSource;
        }

        public final void throwIfCaught() throws IOException {
            IOException iOException = this.thrownException;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    /* JADX INFO: renamed from: com.vungle.ads.internal.network.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OkHttpCall.kt */
    public static final class C0523c extends e0 {
        private final long contentLength;

        @Nullable
        private final x contentType;

        public C0523c(@Nullable x xVar, long j10) {
            this.contentType = xVar;
            this.contentLength = j10;
        }

        @Override // ga.e0
        public long contentLength() {
            return this.contentLength;
        }

        @Override // ga.e0
        @Nullable
        public x contentType() {
            return this.contentType;
        }

        @Override // ga.e0
        @NotNull
        public ua.e source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    /* JADX INFO: compiled from: OkHttpCall.kt */
    public static final class d implements ga.f {
        final /* synthetic */ com.vungle.ads.internal.network.b<T> $callback;
        final /* synthetic */ c<T> this$0;

        d(c<T> cVar, com.vungle.ads.internal.network.b<T> bVar) {
            this.this$0 = cVar;
            this.$callback = bVar;
        }

        private final void callFailure(Throwable th) throws Throwable {
            try {
                this.$callback.onFailure(this.this$0, th);
            } catch (Throwable th2) {
                c.Companion.throwIfFatal(th2);
                p.Companion.e(c.TAG, "Cannot pass failure to callback", th2);
            }
        }

        @Override // ga.f
        public void onFailure(@NotNull ga.e call, @NotNull IOException e10) throws Throwable {
            t.i(call, "call");
            t.i(e10, "e");
            callFailure(e10);
        }

        @Override // ga.f
        public void onResponse(@NotNull ga.e call, @NotNull d0 response) throws Throwable {
            t.i(call, "call");
            t.i(response, "response");
            try {
                try {
                    this.$callback.onResponse(this.this$0, this.this$0.parseResponse(response));
                } catch (Throwable th) {
                    c.Companion.throwIfFatal(th);
                    p.Companion.e(c.TAG, "Cannot pass response to callback", th);
                }
            } catch (Throwable th2) {
                c.Companion.throwIfFatal(th2);
                callFailure(th2);
            }
        }
    }

    public c(@NotNull ga.e rawCall, @NotNull com.vungle.ads.internal.network.converters.a<e0, T> responseConverter) {
        t.i(rawCall, "rawCall");
        t.i(responseConverter, "responseConverter");
        this.rawCall = rawCall;
        this.responseConverter = responseConverter;
    }

    private final e0 buffer(e0 e0Var) throws IOException {
        ua.c cVar = new ua.c();
        e0Var.source().V(cVar);
        return e0.Companion.f(cVar, e0Var.contentType(), e0Var.contentLength());
    }

    @Override // com.vungle.ads.internal.network.a
    public void cancel() {
        ga.e eVar;
        this.canceled = true;
        synchronized (this) {
            eVar = this.rawCall;
            v8.k0 k0Var = v8.k0.f35197a;
        }
        eVar.cancel();
    }

    @Override // com.vungle.ads.internal.network.a
    public void enqueue(@NotNull com.vungle.ads.internal.network.b<T> callback) {
        ga.e eVar;
        t.i(callback, "callback");
        Objects.requireNonNull(callback, "callback == null");
        synchronized (this) {
            eVar = this.rawCall;
            v8.k0 k0Var = v8.k0.f35197a;
        }
        if (this.canceled) {
            eVar.cancel();
        }
        eVar.n(new d(this, callback));
    }

    @Override // com.vungle.ads.internal.network.a
    @Nullable
    public com.vungle.ads.internal.network.d<T> execute() throws IOException {
        ga.e eVar;
        synchronized (this) {
            eVar = this.rawCall;
            v8.k0 k0Var = v8.k0.f35197a;
        }
        if (this.canceled) {
            eVar.cancel();
        }
        return parseResponse(eVar.execute());
    }

    @Override // com.vungle.ads.internal.network.a
    public boolean isCanceled() {
        boolean zIsCanceled;
        if (this.canceled) {
            return true;
        }
        synchronized (this) {
            zIsCanceled = this.rawCall.isCanceled();
        }
        return zIsCanceled;
    }

    @Nullable
    public final com.vungle.ads.internal.network.d<T> parseResponse(@NotNull d0 rawResp) throws IOException {
        t.i(rawResp, "rawResp");
        e0 e0VarA = rawResp.a();
        if (e0VarA == null) {
            return null;
        }
        d0 d0VarC = rawResp.W().b(new C0523c(e0VarA.contentType(), e0VarA.contentLength())).c();
        int iQ = d0VarC.q();
        if (iQ >= 200 && iQ < 300) {
            if (iQ == 204 || iQ == 205) {
                e0VarA.close();
                return com.vungle.ads.internal.network.d.Companion.success(null, d0VarC);
            }
            b bVar = new b(e0VarA);
            try {
                return com.vungle.ads.internal.network.d.Companion.success(this.responseConverter.convert(bVar), d0VarC);
            } catch (RuntimeException e10) {
                bVar.throwIfCaught();
                throw e10;
            }
        }
        try {
            com.vungle.ads.internal.network.d<T> dVarError = com.vungle.ads.internal.network.d.Companion.error(buffer(e0VarA), d0VarC);
            f9.c.a(e0VarA, null);
            return dVarError;
        } finally {
        }
    }
}
