package ga;

import androidx.browser.trusted.sharing.ShareTarget;
import com.ironsource.nb;
import ga.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MultipartBody.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class y extends c0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static final b f26244f = new b(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public static final x f26245g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public static final x f26246h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public static final x f26247i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public static final x f26248j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    public static final x f26249k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private static final byte[] f26250l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    private static final byte[] f26251m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    private static final byte[] f26252n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ua.f f26253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final x f26254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final List<c> f26255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final x f26256d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f26257e;

    /* JADX INFO: compiled from: MultipartBody.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final ua.f f26258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private x f26259b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final List<c> f26260c;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @NotNull
        public final a a(@Nullable u uVar, @NotNull c0 body) {
            kotlin.jvm.internal.t.i(body, "body");
            b(c.f26261c.a(uVar, body));
            return this;
        }

        @NotNull
        public final a b(@NotNull c part) {
            kotlin.jvm.internal.t.i(part, "part");
            this.f26260c.add(part);
            return this;
        }

        @NotNull
        public final y c() {
            if (!this.f26260c.isEmpty()) {
                return new y(this.f26258a, this.f26259b, ha.d.T(this.f26260c));
            }
            throw new IllegalStateException("Multipart body must have at least one part.".toString());
        }

        @NotNull
        public final a d(@NotNull x type) {
            kotlin.jvm.internal.t.i(type, "type");
            if (!kotlin.jvm.internal.t.d(type.h(), "multipart")) {
                throw new IllegalArgumentException(kotlin.jvm.internal.t.r("multipart != ", type).toString());
            }
            this.f26259b = type;
            return this;
        }

        public a(@NotNull String boundary) {
            kotlin.jvm.internal.t.i(boundary, "boundary");
            this.f26258a = ua.f.f34755d.d(boundary);
            this.f26259b = y.f26245g;
            this.f26260c = new ArrayList();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ a(String str, int i10, kotlin.jvm.internal.k kVar) {
            if ((i10 & 1) != 0) {
                str = UUID.randomUUID().toString();
                kotlin.jvm.internal.t.h(str, "randomUUID().toString()");
            }
            this(str);
        }
    }

    /* JADX INFO: compiled from: MultipartBody.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: MultipartBody.kt */
    public static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public static final a f26261c = new a(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private final u f26262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final c0 f26263b;

        /* JADX INFO: compiled from: MultipartBody.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final c a(@Nullable u uVar, @NotNull c0 body) {
                kotlin.jvm.internal.t.i(body, "body");
                kotlin.jvm.internal.k kVar = null;
                if (!((uVar == null ? null : uVar.a(nb.K)) == null)) {
                    throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
                }
                if ((uVar == null ? null : uVar.a("Content-Length")) == null) {
                    return new c(uVar, body, kVar);
                }
                throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
            }
        }

        public /* synthetic */ c(u uVar, c0 c0Var, kotlin.jvm.internal.k kVar) {
            this(uVar, c0Var);
        }

        @NotNull
        public final c0 a() {
            return this.f26263b;
        }

        @Nullable
        public final u b() {
            return this.f26262a;
        }

        private c(u uVar, c0 c0Var) {
            this.f26262a = uVar;
            this.f26263b = c0Var;
        }
    }

    static {
        x.a aVar = x.f26237e;
        f26245g = aVar.a("multipart/mixed");
        f26246h = aVar.a("multipart/alternative");
        f26247i = aVar.a("multipart/digest");
        f26248j = aVar.a("multipart/parallel");
        f26249k = aVar.a(ShareTarget.ENCODING_TYPE_MULTIPART);
        f26250l = new byte[]{58, 32};
        f26251m = new byte[]{13, 10};
        f26252n = new byte[]{45, 45};
    }

    public y(@NotNull ua.f boundaryByteString, @NotNull x type, @NotNull List<c> parts) {
        kotlin.jvm.internal.t.i(boundaryByteString, "boundaryByteString");
        kotlin.jvm.internal.t.i(type, "type");
        kotlin.jvm.internal.t.i(parts, "parts");
        this.f26253a = boundaryByteString;
        this.f26254b = type;
        this.f26255c = parts;
        this.f26256d = x.f26237e.a(type + "; boundary=" + a());
        this.f26257e = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long b(ua.d dVar, boolean z10) throws IOException {
        ua.c cVar;
        if (z10) {
            dVar = new ua.c();
            cVar = dVar;
        } else {
            cVar = 0;
        }
        int size = this.f26255c.size();
        long j10 = 0;
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            c cVar2 = this.f26255c.get(i10);
            u uVarB = cVar2.b();
            c0 c0VarA = cVar2.a();
            kotlin.jvm.internal.t.f(dVar);
            dVar.write(f26252n);
            dVar.I(this.f26253a);
            dVar.write(f26251m);
            if (uVarB != null) {
                int size2 = uVarB.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    dVar.E(uVarB.e(i12)).write(f26250l).E(uVarB.i(i12)).write(f26251m);
                }
            }
            x xVarContentType = c0VarA.contentType();
            if (xVarContentType != null) {
                dVar.E("Content-Type: ").E(xVarContentType.toString()).write(f26251m);
            }
            long jContentLength = c0VarA.contentLength();
            if (jContentLength != -1) {
                dVar.E("Content-Length: ").b0(jContentLength).write(f26251m);
            } else if (z10) {
                kotlin.jvm.internal.t.f(cVar);
                cVar.c();
                return -1L;
            }
            byte[] bArr = f26251m;
            dVar.write(bArr);
            if (z10) {
                j10 += jContentLength;
            } else {
                c0VarA.writeTo(dVar);
            }
            dVar.write(bArr);
            i10 = i11;
        }
        kotlin.jvm.internal.t.f(dVar);
        byte[] bArr2 = f26252n;
        dVar.write(bArr2);
        dVar.I(this.f26253a);
        dVar.write(bArr2);
        dVar.write(f26251m);
        if (!z10) {
            return j10;
        }
        kotlin.jvm.internal.t.f(cVar);
        long size3 = j10 + cVar.size();
        cVar.c();
        return size3;
    }

    @NotNull
    public final String a() {
        return this.f26253a.G();
    }

    @Override // ga.c0
    public long contentLength() throws IOException {
        long j10 = this.f26257e;
        if (j10 != -1) {
            return j10;
        }
        long jB = b(null, true);
        this.f26257e = jB;
        return jB;
    }

    @Override // ga.c0
    @NotNull
    public x contentType() {
        return this.f26256d;
    }

    @Override // ga.c0
    public void writeTo(@NotNull ua.d sink) throws IOException {
        kotlin.jvm.internal.t.i(sink, "sink");
        b(sink, false);
    }
}
