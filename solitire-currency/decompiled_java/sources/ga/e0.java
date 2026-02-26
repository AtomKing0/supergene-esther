package ga;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ResponseBody.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class e0 implements Closeable {

    @NotNull
    public static final b Companion = new b(null);

    @Nullable
    private Reader reader;

    /* JADX INFO: compiled from: ResponseBody.kt */
    public static final class a extends Reader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final ua.e f26050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final Charset f26051b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f26052c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private Reader f26053d;

        public a(@NotNull ua.e source, @NotNull Charset charset) {
            kotlin.jvm.internal.t.i(source, "source");
            kotlin.jvm.internal.t.i(charset, "charset");
            this.f26050a = source;
            this.f26051b = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            k0 k0Var;
            this.f26052c = true;
            Reader reader = this.f26053d;
            if (reader == null) {
                k0Var = null;
            } else {
                reader.close();
                k0Var = k0.f35197a;
            }
            if (k0Var == null) {
                this.f26050a.close();
            }
        }

        @Override // java.io.Reader
        public int read(@NotNull char[] cbuf, int i10, int i11) throws IOException {
            kotlin.jvm.internal.t.i(cbuf, "cbuf");
            if (this.f26052c) {
                throw new IOException("Stream closed");
            }
            Reader inputStreamReader = this.f26053d;
            if (inputStreamReader == null) {
                inputStreamReader = new InputStreamReader(this.f26050a.F0(), ha.d.J(this.f26050a, this.f26051b));
                this.f26053d = inputStreamReader;
            }
            return inputStreamReader.read(cbuf, i10, i11);
        }
    }

    /* JADX INFO: compiled from: ResponseBody.kt */
    public static final class b {

        /* JADX INFO: compiled from: ResponseBody.kt */
        public static final class a extends e0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ x f26054a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f26055b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ ua.e f26056c;

            a(x xVar, long j10, ua.e eVar) {
                this.f26054a = xVar;
                this.f26055b = j10;
                this.f26056c = eVar;
            }

            @Override // ga.e0
            public long contentLength() {
                return this.f26055b;
            }

            @Override // ga.e0
            @Nullable
            public x contentType() {
                return this.f26054a;
            }

            @Override // ga.e0
            @NotNull
            public ua.e source() {
                return this.f26056c;
            }
        }

        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        public static /* synthetic */ e0 i(b bVar, byte[] bArr, x xVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                xVar = null;
            }
            return bVar.h(bArr, xVar);
        }

        @NotNull
        public final e0 a(@Nullable x xVar, long j10, @NotNull ua.e content) {
            kotlin.jvm.internal.t.i(content, "content");
            return f(content, xVar, j10);
        }

        @NotNull
        public final e0 b(@Nullable x xVar, @NotNull String content) {
            kotlin.jvm.internal.t.i(content, "content");
            return e(content, xVar);
        }

        @NotNull
        public final e0 c(@Nullable x xVar, @NotNull ua.f content) {
            kotlin.jvm.internal.t.i(content, "content");
            return g(content, xVar);
        }

        @NotNull
        public final e0 d(@Nullable x xVar, @NotNull byte[] content) {
            kotlin.jvm.internal.t.i(content, "content");
            return h(content, xVar);
        }

        @NotNull
        public final e0 e(@NotNull String str, @Nullable x xVar) {
            kotlin.jvm.internal.t.i(str, "<this>");
            Charset charset = p9.d.f32952b;
            if (xVar != null) {
                Charset charsetD = x.d(xVar, null, 1, null);
                if (charsetD == null) {
                    xVar = x.f26237e.b(xVar + "; charset=utf-8");
                } else {
                    charset = charsetD;
                }
            }
            ua.c cVarZ0 = new ua.c().Z0(str, charset);
            return f(cVarZ0, xVar, cVarZ0.size());
        }

        @NotNull
        public final e0 f(@NotNull ua.e eVar, @Nullable x xVar, long j10) {
            kotlin.jvm.internal.t.i(eVar, "<this>");
            return new a(xVar, j10, eVar);
        }

        @NotNull
        public final e0 g(@NotNull ua.f fVar, @Nullable x xVar) {
            kotlin.jvm.internal.t.i(fVar, "<this>");
            return f(new ua.c().I(fVar), xVar, fVar.B());
        }

        @NotNull
        public final e0 h(@NotNull byte[] bArr, @Nullable x xVar) {
            kotlin.jvm.internal.t.i(bArr, "<this>");
            return f(new ua.c().write(bArr), xVar, bArr.length);
        }
    }

    private final Charset charset() {
        x xVarContentType = contentType();
        Charset charsetC = xVarContentType == null ? null : xVarContentType.c(p9.d.f32952b);
        return charsetC == null ? p9.d.f32952b : charsetC;
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [T, java.lang.Object] */
    private final <T> T consumeSource(h9.l<? super ua.e, ? extends T> lVar, h9.l<? super T, Integer> lVar2) throws IOException {
        long jContentLength = contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException(kotlin.jvm.internal.t.r("Cannot buffer entire body for content length: ", Long.valueOf(jContentLength)));
        }
        ua.e eVarSource = source();
        try {
            T tInvoke = lVar.invoke(eVarSource);
            kotlin.jvm.internal.r.b(1);
            f9.c.a(eVarSource, null);
            kotlin.jvm.internal.r.a(1);
            int iIntValue = lVar2.invoke(tInvoke).intValue();
            if (jContentLength == -1 || jContentLength == iIntValue) {
                return tInvoke;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + iIntValue + ") disagree");
        } finally {
        }
    }

    @NotNull
    public static final e0 create(@Nullable x xVar, long j10, @NotNull ua.e eVar) {
        return Companion.a(xVar, j10, eVar);
    }

    @NotNull
    public final InputStream byteStream() {
        return source().F0();
    }

    @NotNull
    public final ua.f byteString() throws IOException {
        long jContentLength = contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException(kotlin.jvm.internal.t.r("Cannot buffer entire body for content length: ", Long.valueOf(jContentLength)));
        }
        ua.e eVarSource = source();
        try {
            ua.f fVarW0 = eVarSource.w0();
            f9.c.a(eVarSource, null);
            int iB = fVarW0.B();
            if (jContentLength == -1 || jContentLength == iB) {
                return fVarW0;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + iB + ") disagree");
        } finally {
        }
    }

    @NotNull
    public final byte[] bytes() throws IOException {
        long jContentLength = contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException(kotlin.jvm.internal.t.r("Cannot buffer entire body for content length: ", Long.valueOf(jContentLength)));
        }
        ua.e eVarSource = source();
        try {
            byte[] bArrL0 = eVarSource.l0();
            f9.c.a(eVarSource, null);
            int length = bArrL0.length;
            if (jContentLength == -1 || jContentLength == length) {
                return bArrL0;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + length + ") disagree");
        } finally {
        }
    }

    @NotNull
    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        a aVar = new a(source(), charset());
        this.reader = aVar;
        return aVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ha.d.m(source());
    }

    public abstract long contentLength();

    @Nullable
    public abstract x contentType();

    @NotNull
    public abstract ua.e source();

    @NotNull
    public final String string() throws IOException {
        ua.e eVarSource = source();
        try {
            String strS0 = eVarSource.s0(ha.d.J(eVarSource, charset()));
            f9.c.a(eVarSource, null);
            return strS0;
        } finally {
        }
    }

    @NotNull
    public static final e0 create(@Nullable x xVar, @NotNull String str) {
        return Companion.b(xVar, str);
    }

    @NotNull
    public static final e0 create(@Nullable x xVar, @NotNull ua.f fVar) {
        return Companion.c(xVar, fVar);
    }

    @NotNull
    public static final e0 create(@Nullable x xVar, @NotNull byte[] bArr) {
        return Companion.d(xVar, bArr);
    }

    @NotNull
    public static final e0 create(@NotNull String str, @Nullable x xVar) {
        return Companion.e(str, xVar);
    }

    @NotNull
    public static final e0 create(@NotNull ua.e eVar, @Nullable x xVar, long j10) {
        return Companion.f(eVar, xVar, j10);
    }

    @NotNull
    public static final e0 create(@NotNull ua.f fVar, @Nullable x xVar) {
        return Companion.g(fVar, xVar);
    }

    @NotNull
    public static final e0 create(@NotNull byte[] bArr, @Nullable x xVar) {
        return Companion.h(bArr, xVar);
    }
}
