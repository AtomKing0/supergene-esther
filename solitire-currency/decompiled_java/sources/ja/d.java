package ja;

import h9.l;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;
import p9.r;
import qa.j;
import ua.m;
import ua.x0;
import ua.z0;
import v8.h;
import v8.k0;

/* JADX INFO: compiled from: DiskLruCache.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d implements Closeable, Flushable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final pa.a f28835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final File f28836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f28837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f28838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f28839e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final File f28840f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final File f28841g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final File f28842h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f28843i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private ua.d f28844j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private final LinkedHashMap<String, c> f28845k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f28846l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f28847m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f28848n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f28849o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f28850p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f28851q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f28852r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f28853s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NotNull
    private final ka.d f28854t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NotNull
    private final e f28855u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NotNull
    public static final a f28830v = new a(null);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @NotNull
    public static final String f28831w = "journal";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NotNull
    public static final String f28832x = "journal.tmp";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NotNull
    public static final String f28833y = "journal.bkp";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @NotNull
    public static final String f28834z = "libcore.io.DiskLruCache";

    @NotNull
    public static final String A = "1";
    public static final long B = -1;

    @NotNull
    public static final p9.f C = new p9.f("[a-z0-9_-]{1,120}");

    @NotNull
    public static final String D = "CLEAN";

    @NotNull
    public static final String E = "DIRTY";

    @NotNull
    public static final String F = "REMOVE";

    @NotNull
    public static final String G = "READ";

    /* JADX INFO: compiled from: DiskLruCache.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.kt */
    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final c f28856a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private final boolean[] f28857b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f28858c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f28859d;

        /* JADX INFO: compiled from: DiskLruCache.kt */
        static final class a extends v implements l<IOException, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ d f28860g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ b f28861h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(d dVar, b bVar) {
                super(1);
                this.f28860g = dVar;
                this.f28861h = bVar;
            }

            public final void a(@NotNull IOException it) {
                t.i(it, "it");
                d dVar = this.f28860g;
                b bVar = this.f28861h;
                synchronized (dVar) {
                    bVar.c();
                    k0 k0Var = k0.f35197a;
                }
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(IOException iOException) {
                a(iOException);
                return k0.f35197a;
            }
        }

        public b(@NotNull d this$0, c entry) {
            t.i(this$0, "this$0");
            t.i(entry, "entry");
            this.f28859d = this$0;
            this.f28856a = entry;
            this.f28857b = entry.g() ? null : new boolean[this$0.J0()];
        }

        public final void a() throws IOException {
            d dVar = this.f28859d;
            synchronized (dVar) {
                if (!(!this.f28858c)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                if (t.d(d().b(), this)) {
                    dVar.L(this, false);
                }
                this.f28858c = true;
                k0 k0Var = k0.f35197a;
            }
        }

        public final void b() throws IOException {
            d dVar = this.f28859d;
            synchronized (dVar) {
                if (!(!this.f28858c)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                if (t.d(d().b(), this)) {
                    dVar.L(this, true);
                }
                this.f28858c = true;
                k0 k0Var = k0.f35197a;
            }
        }

        public final void c() throws IOException {
            if (t.d(this.f28856a.b(), this)) {
                if (this.f28859d.f28848n) {
                    this.f28859d.L(this, false);
                } else {
                    this.f28856a.q(true);
                }
            }
        }

        @NotNull
        public final c d() {
            return this.f28856a;
        }

        @Nullable
        public final boolean[] e() {
            return this.f28857b;
        }

        @NotNull
        public final x0 f(int i10) {
            d dVar = this.f28859d;
            synchronized (dVar) {
                if (!(!this.f28858c)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                if (!t.d(d().b(), this)) {
                    return ua.k0.b();
                }
                if (!d().g()) {
                    boolean[] zArrE = e();
                    t.f(zArrE);
                    zArrE[i10] = true;
                }
                try {
                    return new ja.e(dVar.G0().f(d().c().get(i10)), new a(dVar, this));
                } catch (FileNotFoundException unused) {
                    return ua.k0.b();
                }
            }
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.kt */
    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f28862a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final long[] f28863b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final List<File> f28864c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        private final List<File> f28865d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f28866e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f28867f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        private b f28868g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f28869h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f28870i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ d f28871j;

        /* JADX INFO: compiled from: DiskLruCache.kt */
        public static final class a extends m {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f28872a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ z0 f28873b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ d f28874c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ c f28875d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(z0 z0Var, d dVar, c cVar) {
                super(z0Var);
                this.f28873b = z0Var;
                this.f28874c = dVar;
                this.f28875d = cVar;
            }

            @Override // ua.m, ua.z0, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                super.close();
                if (this.f28872a) {
                    return;
                }
                this.f28872a = true;
                d dVar = this.f28874c;
                c cVar = this.f28875d;
                synchronized (dVar) {
                    cVar.n(cVar.f() - 1);
                    if (cVar.f() == 0 && cVar.i()) {
                        dVar.S0(cVar);
                    }
                    k0 k0Var = k0.f35197a;
                }
            }
        }

        public c(@NotNull d this$0, String key) {
            t.i(this$0, "this$0");
            t.i(key, "key");
            this.f28871j = this$0;
            this.f28862a = key;
            this.f28863b = new long[this$0.J0()];
            this.f28864c = new ArrayList();
            this.f28865d = new ArrayList();
            StringBuilder sb = new StringBuilder(key);
            sb.append('.');
            int length = sb.length();
            int iJ0 = this$0.J0();
            for (int i10 = 0; i10 < iJ0; i10++) {
                sb.append(i10);
                this.f28864c.add(new File(this.f28871j.i0(), sb.toString()));
                sb.append(".tmp");
                this.f28865d.add(new File(this.f28871j.i0(), sb.toString()));
                sb.setLength(length);
            }
        }

        private final Void j(List<String> list) throws IOException {
            throw new IOException(t.r("unexpected journal line: ", list));
        }

        private final z0 k(int i10) throws FileNotFoundException {
            z0 z0VarE = this.f28871j.G0().e(this.f28864c.get(i10));
            if (this.f28871j.f28848n) {
                return z0VarE;
            }
            this.f28869h++;
            return new a(z0VarE, this.f28871j, this);
        }

        @NotNull
        public final List<File> a() {
            return this.f28864c;
        }

        @Nullable
        public final b b() {
            return this.f28868g;
        }

        @NotNull
        public final List<File> c() {
            return this.f28865d;
        }

        @NotNull
        public final String d() {
            return this.f28862a;
        }

        @NotNull
        public final long[] e() {
            return this.f28863b;
        }

        public final int f() {
            return this.f28869h;
        }

        public final boolean g() {
            return this.f28866e;
        }

        public final long h() {
            return this.f28870i;
        }

        public final boolean i() {
            return this.f28867f;
        }

        public final void l(@Nullable b bVar) {
            this.f28868g = bVar;
        }

        public final void m(@NotNull List<String> strings) throws IOException {
            t.i(strings, "strings");
            if (strings.size() != this.f28871j.J0()) {
                j(strings);
                throw new h();
            }
            try {
                int size = strings.size();
                int i10 = 0;
                while (i10 < size) {
                    int i11 = i10 + 1;
                    this.f28863b[i10] = Long.parseLong(strings.get(i10));
                    i10 = i11;
                }
            } catch (NumberFormatException unused) {
                j(strings);
                throw new h();
            }
        }

        public final void n(int i10) {
            this.f28869h = i10;
        }

        public final void o(boolean z10) {
            this.f28866e = z10;
        }

        public final void p(long j10) {
            this.f28870i = j10;
        }

        public final void q(boolean z10) {
            this.f28867f = z10;
        }

        @Nullable
        public final C0599d r() {
            d dVar = this.f28871j;
            if (ha.d.f26515h && !Thread.holdsLock(dVar)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + dVar);
            }
            if (!this.f28866e) {
                return null;
            }
            if (!this.f28871j.f28848n && (this.f28868g != null || this.f28867f)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            long[] jArr = (long[]) this.f28863b.clone();
            try {
                int iJ0 = this.f28871j.J0();
                for (int i10 = 0; i10 < iJ0; i10++) {
                    arrayList.add(k(i10));
                }
                return new C0599d(this.f28871j, this.f28862a, this.f28870i, arrayList, jArr);
            } catch (FileNotFoundException unused) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ha.d.m((z0) it.next());
                }
                try {
                    this.f28871j.S0(this);
                } catch (IOException unused2) {
                }
                return null;
            }
        }

        public final void s(@NotNull ua.d writer) throws IOException {
            t.i(writer, "writer");
            long[] jArr = this.f28863b;
            int length = jArr.length;
            int i10 = 0;
            while (i10 < length) {
                long j10 = jArr[i10];
                i10++;
                writer.writeByte(32).b0(j10);
            }
        }
    }

    /* JADX INFO: renamed from: ja.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DiskLruCache.kt */
    public final class C0599d implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f28876a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f28877b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final List<z0> f28878c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        private final long[] f28879d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f28880e;

        /* JADX WARN: Multi-variable type inference failed */
        public C0599d(@NotNull d this$0, String key, @NotNull long j10, @NotNull List<? extends z0> sources, long[] lengths) {
            t.i(this$0, "this$0");
            t.i(key, "key");
            t.i(sources, "sources");
            t.i(lengths, "lengths");
            this.f28880e = this$0;
            this.f28876a = key;
            this.f28877b = j10;
            this.f28878c = sources;
            this.f28879d = lengths;
        }

        @Nullable
        public final b a() throws IOException {
            return this.f28880e.R(this.f28876a, this.f28877b);
        }

        @NotNull
        public final z0 c(int i10) {
            return this.f28878c.get(i10);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Iterator<z0> it = this.f28878c.iterator();
            while (it.hasNext()) {
                ha.d.m(it.next());
            }
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.kt */
    public static final class e extends ka.a {
        e(String str) {
            super(str, false, 2, null);
        }

        @Override // ka.a
        public long f() {
            d dVar = d.this;
            synchronized (dVar) {
                if (!dVar.f28849o || dVar.h0()) {
                    return -1L;
                }
                try {
                    dVar.U0();
                } catch (IOException unused) {
                    dVar.f28851q = true;
                }
                try {
                    if (dVar.L0()) {
                        dVar.Q0();
                        dVar.f28846l = 0;
                    }
                } catch (IOException unused2) {
                    dVar.f28852r = true;
                    dVar.f28844j = ua.k0.c(ua.k0.b());
                }
                return -1L;
            }
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.kt */
    static final class f extends v implements l<IOException, k0> {
        f() {
            super(1);
        }

        public final void a(@NotNull IOException it) {
            t.i(it, "it");
            d dVar = d.this;
            if (!ha.d.f26515h || Thread.holdsLock(dVar)) {
                d.this.f28847m = true;
                return;
            }
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + dVar);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(IOException iOException) {
            a(iOException);
            return k0.f35197a;
        }
    }

    public d(@NotNull pa.a fileSystem, @NotNull File directory, int i10, int i11, long j10, @NotNull ka.e taskRunner) {
        t.i(fileSystem, "fileSystem");
        t.i(directory, "directory");
        t.i(taskRunner, "taskRunner");
        this.f28835a = fileSystem;
        this.f28836b = directory;
        this.f28837c = i10;
        this.f28838d = i11;
        this.f28839e = j10;
        this.f28845k = new LinkedHashMap<>(0, 0.75f, true);
        this.f28854t = taskRunner.i();
        this.f28855u = new e(t.r(ha.d.f26516i, " Cache"));
        if (!(j10 > 0)) {
            throw new IllegalArgumentException("maxSize <= 0".toString());
        }
        if (!(i11 > 0)) {
            throw new IllegalArgumentException("valueCount <= 0".toString());
        }
        this.f28840f = new File(directory, f28831w);
        this.f28841g = new File(directory, f28832x);
        this.f28842h = new File(directory, f28833y);
    }

    private final synchronized void J() {
        if (!(!this.f28850p)) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean L0() {
        int i10 = this.f28846l;
        return i10 >= 2000 && i10 >= this.f28845k.size();
    }

    private final ua.d M0() throws FileNotFoundException {
        return ua.k0.c(new ja.e(this.f28835a.c(this.f28840f), new f()));
    }

    private final void N0() throws IOException {
        this.f28835a.h(this.f28841g);
        Iterator<c> it = this.f28845k.values().iterator();
        while (it.hasNext()) {
            c next = it.next();
            t.h(next, "i.next()");
            c cVar = next;
            int i10 = 0;
            if (cVar.b() == null) {
                int i11 = this.f28838d;
                while (i10 < i11) {
                    this.f28843i += cVar.e()[i10];
                    i10++;
                }
            } else {
                cVar.l(null);
                int i12 = this.f28838d;
                while (i10 < i12) {
                    this.f28835a.h(cVar.a().get(i10));
                    this.f28835a.h(cVar.c().get(i10));
                    i10++;
                }
                it.remove();
            }
        }
    }

    private final void O0() throws IOException {
        ua.e eVarD = ua.k0.d(this.f28835a.e(this.f28840f));
        try {
            String strN = eVarD.N();
            String strN2 = eVarD.N();
            String strN3 = eVarD.N();
            String strN4 = eVarD.N();
            String strN5 = eVarD.N();
            if (t.d(f28834z, strN) && t.d(A, strN2) && t.d(String.valueOf(this.f28837c), strN3) && t.d(String.valueOf(J0()), strN4)) {
                int i10 = 0;
                if (!(strN5.length() > 0)) {
                    while (true) {
                        try {
                            P0(eVarD.N());
                            i10++;
                        } catch (EOFException unused) {
                            this.f28846l = i10 - I0().size();
                            if (eVarD.m0()) {
                                this.f28844j = M0();
                            } else {
                                Q0();
                            }
                            k0 k0Var = k0.f35197a;
                            f9.c.a(eVarD, null);
                            return;
                        }
                    }
                }
            }
            throw new IOException("unexpected journal header: [" + strN + ", " + strN2 + ", " + strN4 + ", " + strN5 + ']');
        } finally {
        }
    }

    private final void P0(String str) throws IOException {
        String strSubstring;
        int iD0 = r.d0(str, ' ', 0, false, 6, null);
        if (iD0 == -1) {
            throw new IOException(t.r("unexpected journal line: ", str));
        }
        int i10 = iD0 + 1;
        int iD02 = r.d0(str, ' ', i10, false, 4, null);
        if (iD02 == -1) {
            strSubstring = str.substring(i10);
            t.h(strSubstring, "this as java.lang.String).substring(startIndex)");
            String str2 = F;
            if (iD0 == str2.length() && q.K(str, str2, false, 2, null)) {
                this.f28845k.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i10, iD02);
            t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        c cVar = this.f28845k.get(strSubstring);
        if (cVar == null) {
            cVar = new c(this, strSubstring);
            this.f28845k.put(strSubstring, cVar);
        }
        if (iD02 != -1) {
            String str3 = D;
            if (iD0 == str3.length() && q.K(str, str3, false, 2, null)) {
                String strSubstring2 = str.substring(iD02 + 1);
                t.h(strSubstring2, "this as java.lang.String).substring(startIndex)");
                List<String> listB0 = r.B0(strSubstring2, new char[]{' '}, false, 0, 6, null);
                cVar.o(true);
                cVar.l(null);
                cVar.m(listB0);
                return;
            }
        }
        if (iD02 == -1) {
            String str4 = E;
            if (iD0 == str4.length() && q.K(str, str4, false, 2, null)) {
                cVar.l(new b(this, cVar));
                return;
            }
        }
        if (iD02 == -1) {
            String str5 = G;
            if (iD0 == str5.length() && q.K(str, str5, false, 2, null)) {
                return;
            }
        }
        throw new IOException(t.r("unexpected journal line: ", str));
    }

    public static /* synthetic */ b S(d dVar, String str, long j10, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            j10 = B;
        }
        return dVar.R(str, j10);
    }

    private final boolean T0() throws IOException {
        for (c toEvict : this.f28845k.values()) {
            if (!toEvict.i()) {
                t.h(toEvict, "toEvict");
                S0(toEvict);
                return true;
            }
        }
        return false;
    }

    private final void V0(String str) {
        if (C.a(str)) {
            return;
        }
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + '\"').toString());
    }

    @NotNull
    public final pa.a G0() {
        return this.f28835a;
    }

    @NotNull
    public final LinkedHashMap<String, c> I0() {
        return this.f28845k;
    }

    public final int J0() {
        return this.f28838d;
    }

    public final synchronized void K0() throws IOException {
        if (ha.d.f26515h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
        }
        if (this.f28849o) {
            return;
        }
        if (this.f28835a.b(this.f28842h)) {
            if (this.f28835a.b(this.f28840f)) {
                this.f28835a.h(this.f28842h);
            } else {
                this.f28835a.g(this.f28842h, this.f28840f);
            }
        }
        this.f28848n = ha.d.F(this.f28835a, this.f28842h);
        if (this.f28835a.b(this.f28840f)) {
            try {
                O0();
                N0();
                this.f28849o = true;
                return;
            } catch (IOException e10) {
                j.f33228a.g().k("DiskLruCache " + this.f28836b + " is corrupt: " + ((Object) e10.getMessage()) + ", removing", 5, e10);
                try {
                    O();
                    this.f28850p = false;
                    Q0();
                    this.f28849o = true;
                } catch (Throwable th) {
                    this.f28850p = false;
                    throw th;
                }
            }
        }
        Q0();
        this.f28849o = true;
    }

    public final synchronized void L(@NotNull b editor, boolean z10) throws IOException {
        t.i(editor, "editor");
        c cVarD = editor.d();
        if (!t.d(cVarD.b(), editor)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        int i10 = 0;
        if (z10 && !cVarD.g()) {
            int i11 = this.f28838d;
            int i12 = 0;
            while (i12 < i11) {
                int i13 = i12 + 1;
                boolean[] zArrE = editor.e();
                t.f(zArrE);
                if (!zArrE[i12]) {
                    editor.a();
                    throw new IllegalStateException(t.r("Newly created entry didn't create value for index ", Integer.valueOf(i12)));
                }
                if (!this.f28835a.b(cVarD.c().get(i12))) {
                    editor.a();
                    return;
                }
                i12 = i13;
            }
        }
        int i14 = this.f28838d;
        while (i10 < i14) {
            int i15 = i10 + 1;
            File file = cVarD.c().get(i10);
            if (!z10 || cVarD.i()) {
                this.f28835a.h(file);
            } else if (this.f28835a.b(file)) {
                File file2 = cVarD.a().get(i10);
                this.f28835a.g(file, file2);
                long j10 = cVarD.e()[i10];
                long jD = this.f28835a.d(file2);
                cVarD.e()[i10] = jD;
                this.f28843i = (this.f28843i - j10) + jD;
            }
            i10 = i15;
        }
        cVarD.l(null);
        if (cVarD.i()) {
            S0(cVarD);
            return;
        }
        this.f28846l++;
        ua.d dVar = this.f28844j;
        t.f(dVar);
        if (cVarD.g() || z10) {
            cVarD.o(true);
            dVar.E(D).writeByte(32);
            dVar.E(cVarD.d());
            cVarD.s(dVar);
            dVar.writeByte(10);
            if (z10) {
                long j11 = this.f28853s;
                this.f28853s = 1 + j11;
                cVarD.p(j11);
            }
        } else {
            I0().remove(cVarD.d());
            dVar.E(F).writeByte(32);
            dVar.E(cVarD.d());
            dVar.writeByte(10);
        }
        dVar.flush();
        if (this.f28843i > this.f28839e || L0()) {
            ka.d.j(this.f28854t, this.f28855u, 0L, 2, null);
        }
    }

    public final void O() throws IOException {
        close();
        this.f28835a.a(this.f28836b);
    }

    public final synchronized void Q0() throws IOException {
        ua.d dVar = this.f28844j;
        if (dVar != null) {
            dVar.close();
        }
        ua.d dVarC = ua.k0.c(this.f28835a.f(this.f28841g));
        try {
            dVarC.E(f28834z).writeByte(10);
            dVarC.E(A).writeByte(10);
            dVarC.b0(this.f28837c).writeByte(10);
            dVarC.b0(J0()).writeByte(10);
            dVarC.writeByte(10);
            for (c cVar : I0().values()) {
                if (cVar.b() != null) {
                    dVarC.E(E).writeByte(32);
                    dVarC.E(cVar.d());
                    dVarC.writeByte(10);
                } else {
                    dVarC.E(D).writeByte(32);
                    dVarC.E(cVar.d());
                    cVar.s(dVarC);
                    dVarC.writeByte(10);
                }
            }
            k0 k0Var = k0.f35197a;
            f9.c.a(dVarC, null);
            if (this.f28835a.b(this.f28840f)) {
                this.f28835a.g(this.f28840f, this.f28842h);
            }
            this.f28835a.g(this.f28841g, this.f28840f);
            this.f28835a.h(this.f28842h);
            this.f28844j = M0();
            this.f28847m = false;
            this.f28852r = false;
        } finally {
        }
    }

    @Nullable
    public final synchronized b R(@NotNull String key, long j10) throws IOException {
        t.i(key, "key");
        K0();
        J();
        V0(key);
        c cVar = this.f28845k.get(key);
        if (j10 != B && (cVar == null || cVar.h() != j10)) {
            return null;
        }
        if ((cVar == null ? null : cVar.b()) != null) {
            return null;
        }
        if (cVar != null && cVar.f() != 0) {
            return null;
        }
        if (!this.f28851q && !this.f28852r) {
            ua.d dVar = this.f28844j;
            t.f(dVar);
            dVar.E(E).writeByte(32).E(key).writeByte(10);
            dVar.flush();
            if (this.f28847m) {
                return null;
            }
            if (cVar == null) {
                cVar = new c(this, key);
                this.f28845k.put(key, cVar);
            }
            b bVar = new b(this, cVar);
            cVar.l(bVar);
            return bVar;
        }
        ka.d.j(this.f28854t, this.f28855u, 0L, 2, null);
        return null;
    }

    public final synchronized boolean R0(@NotNull String key) throws IOException {
        t.i(key, "key");
        K0();
        J();
        V0(key);
        c cVar = this.f28845k.get(key);
        if (cVar == null) {
            return false;
        }
        boolean zS0 = S0(cVar);
        if (zS0 && this.f28843i <= this.f28839e) {
            this.f28851q = false;
        }
        return zS0;
    }

    public final boolean S0(@NotNull c entry) throws IOException {
        ua.d dVar;
        t.i(entry, "entry");
        if (!this.f28848n) {
            if (entry.f() > 0 && (dVar = this.f28844j) != null) {
                dVar.E(E);
                dVar.writeByte(32);
                dVar.E(entry.d());
                dVar.writeByte(10);
                dVar.flush();
            }
            if (entry.f() > 0 || entry.b() != null) {
                entry.q(true);
                return true;
            }
        }
        b bVarB = entry.b();
        if (bVarB != null) {
            bVarB.c();
        }
        int i10 = this.f28838d;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f28835a.h(entry.a().get(i11));
            this.f28843i -= entry.e()[i11];
            entry.e()[i11] = 0;
        }
        this.f28846l++;
        ua.d dVar2 = this.f28844j;
        if (dVar2 != null) {
            dVar2.E(F);
            dVar2.writeByte(32);
            dVar2.E(entry.d());
            dVar2.writeByte(10);
        }
        this.f28845k.remove(entry.d());
        if (L0()) {
            ka.d.j(this.f28854t, this.f28855u, 0L, 2, null);
        }
        return true;
    }

    public final void U0() throws IOException {
        while (this.f28843i > this.f28839e) {
            if (!T0()) {
                return;
            }
        }
        this.f28851q = false;
    }

    @Nullable
    public final synchronized C0599d W(@NotNull String key) throws IOException {
        t.i(key, "key");
        K0();
        J();
        V0(key);
        c cVar = this.f28845k.get(key);
        if (cVar == null) {
            return null;
        }
        C0599d c0599dR = cVar.r();
        if (c0599dR == null) {
            return null;
        }
        this.f28846l++;
        ua.d dVar = this.f28844j;
        t.f(dVar);
        dVar.E(G).writeByte(32).E(key).writeByte(10);
        if (L0()) {
            ka.d.j(this.f28854t, this.f28855u, 0L, 2, null);
        }
        return c0599dR;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        b bVarB;
        if (this.f28849o && !this.f28850p) {
            Collection<c> collectionValues = this.f28845k.values();
            t.h(collectionValues, "lruEntries.values");
            int i10 = 0;
            Object[] array = collectionValues.toArray(new c[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            c[] cVarArr = (c[]) array;
            int length = cVarArr.length;
            while (i10 < length) {
                c cVar = cVarArr[i10];
                i10++;
                if (cVar.b() != null && (bVarB = cVar.b()) != null) {
                    bVarB.c();
                }
            }
            U0();
            ua.d dVar = this.f28844j;
            t.f(dVar);
            dVar.close();
            this.f28844j = null;
            this.f28850p = true;
            return;
        }
        this.f28850p = true;
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.f28849o) {
            J();
            U0();
            ua.d dVar = this.f28844j;
            t.f(dVar);
            dVar.flush();
        }
    }

    public final boolean h0() {
        return this.f28850p;
    }

    @NotNull
    public final File i0() {
        return this.f28836b;
    }
}
