package ga;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ua.k0;
import ua.z0;

/* JADX INFO: compiled from: RequestBody.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class c0 {

    @NotNull
    public static final a Companion = new a(null);

    /* JADX INFO: compiled from: RequestBody.kt */
    public static final class a {

        /* JADX INFO: renamed from: ga.c0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: RequestBody.kt */
        public static final class C0564a extends c0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ x f25991a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ File f25992b;

            C0564a(x xVar, File file) {
                this.f25991a = xVar;
                this.f25992b = file;
            }

            @Override // ga.c0
            public long contentLength() {
                return this.f25992b.length();
            }

            @Override // ga.c0
            @Nullable
            public x contentType() {
                return this.f25991a;
            }

            @Override // ga.c0
            public void writeTo(@NotNull ua.d sink) throws FileNotFoundException {
                kotlin.jvm.internal.t.i(sink, "sink");
                z0 z0VarK = k0.k(this.f25992b);
                try {
                    sink.s(z0VarK);
                    f9.c.a(z0VarK, null);
                } finally {
                }
            }
        }

        /* JADX INFO: compiled from: RequestBody.kt */
        public static final class b extends c0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ x f25993a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ua.f f25994b;

            b(x xVar, ua.f fVar) {
                this.f25993a = xVar;
                this.f25994b = fVar;
            }

            @Override // ga.c0
            public long contentLength() {
                return this.f25994b.B();
            }

            @Override // ga.c0
            @Nullable
            public x contentType() {
                return this.f25993a;
            }

            @Override // ga.c0
            public void writeTo(@NotNull ua.d sink) throws IOException {
                kotlin.jvm.internal.t.i(sink, "sink");
                sink.I(this.f25994b);
            }
        }

        /* JADX INFO: compiled from: RequestBody.kt */
        public static final class c extends c0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ x f25995a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f25996b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ byte[] f25997c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f25998d;

            c(x xVar, int i10, byte[] bArr, int i11) {
                this.f25995a = xVar;
                this.f25996b = i10;
                this.f25997c = bArr;
                this.f25998d = i11;
            }

            @Override // ga.c0
            public long contentLength() {
                return this.f25996b;
            }

            @Override // ga.c0
            @Nullable
            public x contentType() {
                return this.f25995a;
            }

            @Override // ga.c0
            public void writeTo(@NotNull ua.d sink) throws IOException {
                kotlin.jvm.internal.t.i(sink, "sink");
                sink.write(this.f25997c, this.f25998d, this.f25996b);
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public static /* synthetic */ c0 n(a aVar, x xVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
            if ((i12 & 4) != 0) {
                i10 = 0;
            }
            if ((i12 & 8) != 0) {
                i11 = bArr.length;
            }
            return aVar.f(xVar, bArr, i10, i11);
        }

        public static /* synthetic */ c0 o(a aVar, byte[] bArr, x xVar, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                xVar = null;
            }
            if ((i12 & 2) != 0) {
                i10 = 0;
            }
            if ((i12 & 4) != 0) {
                i11 = bArr.length;
            }
            return aVar.m(bArr, xVar, i10, i11);
        }

        @NotNull
        public final c0 a(@Nullable x xVar, @NotNull File file) {
            kotlin.jvm.internal.t.i(file, "file");
            return g(file, xVar);
        }

        @NotNull
        public final c0 b(@Nullable x xVar, @NotNull String content) {
            kotlin.jvm.internal.t.i(content, "content");
            return h(content, xVar);
        }

        @NotNull
        public final c0 c(@Nullable x xVar, @NotNull ua.f content) {
            kotlin.jvm.internal.t.i(content, "content");
            return i(content, xVar);
        }

        @NotNull
        public final c0 d(@Nullable x xVar, @NotNull byte[] content) {
            kotlin.jvm.internal.t.i(content, "content");
            return n(this, xVar, content, 0, 0, 12, null);
        }

        @NotNull
        public final c0 e(@Nullable x xVar, @NotNull byte[] content, int i10) {
            kotlin.jvm.internal.t.i(content, "content");
            return n(this, xVar, content, i10, 0, 8, null);
        }

        @NotNull
        public final c0 f(@Nullable x xVar, @NotNull byte[] content, int i10, int i11) {
            kotlin.jvm.internal.t.i(content, "content");
            return m(content, xVar, i10, i11);
        }

        @NotNull
        public final c0 g(@NotNull File file, @Nullable x xVar) {
            kotlin.jvm.internal.t.i(file, "<this>");
            return new C0564a(xVar, file);
        }

        @NotNull
        public final c0 h(@NotNull String str, @Nullable x xVar) {
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
            byte[] bytes = str.getBytes(charset);
            kotlin.jvm.internal.t.h(bytes, "this as java.lang.String).getBytes(charset)");
            return m(bytes, xVar, 0, bytes.length);
        }

        @NotNull
        public final c0 i(@NotNull ua.f fVar, @Nullable x xVar) {
            kotlin.jvm.internal.t.i(fVar, "<this>");
            return new b(xVar, fVar);
        }

        @NotNull
        public final c0 j(@NotNull byte[] bArr) {
            kotlin.jvm.internal.t.i(bArr, "<this>");
            return o(this, bArr, null, 0, 0, 7, null);
        }

        @NotNull
        public final c0 k(@NotNull byte[] bArr, @Nullable x xVar) {
            kotlin.jvm.internal.t.i(bArr, "<this>");
            return o(this, bArr, xVar, 0, 0, 6, null);
        }

        @NotNull
        public final c0 l(@NotNull byte[] bArr, @Nullable x xVar, int i10) {
            kotlin.jvm.internal.t.i(bArr, "<this>");
            return o(this, bArr, xVar, i10, 0, 4, null);
        }

        @NotNull
        public final c0 m(@NotNull byte[] bArr, @Nullable x xVar, int i10, int i11) {
            kotlin.jvm.internal.t.i(bArr, "<this>");
            ha.d.l(bArr.length, i10, i11);
            return new c(xVar, i11, bArr, i10);
        }
    }

    @NotNull
    public static final c0 create(@Nullable x xVar, @NotNull File file) {
        return Companion.a(xVar, file);
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    @Nullable
    public abstract x contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(@NotNull ua.d dVar) throws IOException;

    @NotNull
    public static final c0 create(@Nullable x xVar, @NotNull String str) {
        return Companion.b(xVar, str);
    }

    @NotNull
    public static final c0 create(@Nullable x xVar, @NotNull ua.f fVar) {
        return Companion.c(xVar, fVar);
    }

    @NotNull
    public static final c0 create(@Nullable x xVar, @NotNull byte[] bArr) {
        return Companion.d(xVar, bArr);
    }

    @NotNull
    public static final c0 create(@Nullable x xVar, @NotNull byte[] bArr, int i10) {
        return Companion.e(xVar, bArr, i10);
    }

    @NotNull
    public static final c0 create(@Nullable x xVar, @NotNull byte[] bArr, int i10, int i11) {
        return Companion.f(xVar, bArr, i10, i11);
    }

    @NotNull
    public static final c0 create(@NotNull File file, @Nullable x xVar) {
        return Companion.g(file, xVar);
    }

    @NotNull
    public static final c0 create(@NotNull String str, @Nullable x xVar) {
        return Companion.h(str, xVar);
    }

    @NotNull
    public static final c0 create(@NotNull ua.f fVar, @Nullable x xVar) {
        return Companion.i(fVar, xVar);
    }

    @NotNull
    public static final c0 create(@NotNull byte[] bArr) {
        return Companion.j(bArr);
    }

    @NotNull
    public static final c0 create(@NotNull byte[] bArr, @Nullable x xVar) {
        return Companion.k(bArr, xVar);
    }

    @NotNull
    public static final c0 create(@NotNull byte[] bArr, @Nullable x xVar, int i10) {
        return Companion.l(bArr, xVar, i10);
    }

    @NotNull
    public static final c0 create(@NotNull byte[] bArr, @Nullable x xVar, int i10, int i11) {
        return Companion.m(bArr, xVar, i10, i11);
    }
}
