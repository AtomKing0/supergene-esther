package n;

import h9.p;
import java.io.Closeable;
import java.io.EOFException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.y2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;
import p9.r;
import ua.j;
import ua.q0;
import ua.x0;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: DiskLruCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements Closeable, Flushable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NotNull
    public static final a f31509s = new a(null);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NotNull
    private static final p9.f f31510t = new p9.f("[a-z0-9_-]{1,120}");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final q0 f31511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f31512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f31513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f31514d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final q0 f31515e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final q0 f31516f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final q0 f31517g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final LinkedHashMap<String, c> f31518h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private final o0 f31519i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f31520j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f31521k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private ua.d f31522l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f31523m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f31524n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f31525o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f31526p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f31527q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NotNull
    private final e f31528r;

    /* JADX INFO: compiled from: DiskLruCache.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: n.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DiskLruCache.kt */
    public final class C0630b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final c f31529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f31530b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final boolean[] f31531c;

        public C0630b(@NotNull c cVar) {
            this.f31529a = cVar;
            this.f31531c = new boolean[b.this.f31514d];
        }

        private final void d(boolean z10) {
            b bVar = b.this;
            synchronized (bVar) {
                if (!(!this.f31530b)) {
                    throw new IllegalStateException("editor is closed".toString());
                }
                if (t.d(this.f31529a.b(), this)) {
                    bVar.i0(this, z10);
                }
                this.f31530b = true;
                k0 k0Var = k0.f35197a;
            }
        }

        public final void a() {
            d(false);
        }

        public final void b() {
            d(true);
        }

        @Nullable
        public final d c() {
            d dVarJ0;
            b bVar = b.this;
            synchronized (bVar) {
                b();
                dVarJ0 = bVar.J0(this.f31529a.d());
            }
            return dVarJ0;
        }

        public final void e() {
            if (t.d(this.f31529a.b(), this)) {
                this.f31529a.m(true);
            }
        }

        @NotNull
        public final q0 f(int i10) {
            q0 q0Var;
            b bVar = b.this;
            synchronized (bVar) {
                if (!(!this.f31530b)) {
                    throw new IllegalStateException("editor is closed".toString());
                }
                this.f31531c[i10] = true;
                q0 q0Var2 = this.f31529a.c().get(i10);
                a0.e.a(bVar.f31528r, q0Var2);
                q0Var = q0Var2;
            }
            return q0Var;
        }

        @NotNull
        public final c g() {
            return this.f31529a;
        }

        @NotNull
        public final boolean[] h() {
            return this.f31531c;
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.kt */
    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f31533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final long[] f31534b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final ArrayList<q0> f31535c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        private final ArrayList<q0> f31536d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f31537e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f31538f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        private C0630b f31539g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f31540h;

        public c(@NotNull String str) {
            this.f31533a = str;
            this.f31534b = new long[b.this.f31514d];
            this.f31535c = new ArrayList<>(b.this.f31514d);
            this.f31536d = new ArrayList<>(b.this.f31514d);
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            int i10 = b.this.f31514d;
            for (int i11 = 0; i11 < i10; i11++) {
                sb.append(i11);
                this.f31535c.add(b.this.f31511a.j(sb.toString()));
                sb.append(".tmp");
                this.f31536d.add(b.this.f31511a.j(sb.toString()));
                sb.setLength(length);
            }
        }

        @NotNull
        public final ArrayList<q0> a() {
            return this.f31535c;
        }

        @Nullable
        public final C0630b b() {
            return this.f31539g;
        }

        @NotNull
        public final ArrayList<q0> c() {
            return this.f31536d;
        }

        @NotNull
        public final String d() {
            return this.f31533a;
        }

        @NotNull
        public final long[] e() {
            return this.f31534b;
        }

        public final int f() {
            return this.f31540h;
        }

        public final boolean g() {
            return this.f31537e;
        }

        public final boolean h() {
            return this.f31538f;
        }

        public final void i(@Nullable C0630b c0630b) {
            this.f31539g = c0630b;
        }

        public final void j(@NotNull List<String> list) throws IOException {
            if (list.size() != b.this.f31514d) {
                throw new IOException("unexpected journal line: " + list);
            }
            try {
                int size = list.size();
                for (int i10 = 0; i10 < size; i10++) {
                    this.f31534b[i10] = Long.parseLong(list.get(i10));
                }
            } catch (NumberFormatException unused) {
                throw new IOException("unexpected journal line: " + list);
            }
        }

        public final void k(int i10) {
            this.f31540h = i10;
        }

        public final void l(boolean z10) {
            this.f31537e = z10;
        }

        public final void m(boolean z10) {
            this.f31538f = z10;
        }

        @Nullable
        public final d n() {
            if (!this.f31537e || this.f31539g != null || this.f31538f) {
                return null;
            }
            ArrayList<q0> arrayList = this.f31535c;
            b bVar = b.this;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (!bVar.f31528r.j(arrayList.get(i10))) {
                    try {
                        bVar.R0(this);
                    } catch (IOException unused) {
                    }
                    return null;
                }
            }
            this.f31540h++;
            return b.this.new d(this);
        }

        public final void o(@NotNull ua.d dVar) throws IOException {
            for (long j10 : this.f31534b) {
                dVar.writeByte(32).b0(j10);
            }
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.kt */
    public final class d implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final c f31542a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f31543b;

        public d(@NotNull c cVar) {
            this.f31542a = cVar;
        }

        @Nullable
        public final C0630b a() {
            C0630b c0630bI0;
            b bVar = b.this;
            synchronized (bVar) {
                close();
                c0630bI0 = bVar.I0(this.f31542a.d());
            }
            return c0630bI0;
        }

        @NotNull
        public final q0 c(int i10) {
            if (!this.f31543b) {
                return this.f31542a.a().get(i10);
            }
            throw new IllegalStateException("snapshot is closed".toString());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f31543b) {
                return;
            }
            this.f31543b = true;
            b bVar = b.this;
            synchronized (bVar) {
                this.f31542a.k(r1.f() - 1);
                if (this.f31542a.f() == 0 && this.f31542a.h()) {
                    bVar.R0(this.f31542a);
                }
                k0 k0Var = k0.f35197a;
            }
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.kt */
    public static final class e extends ua.k {
        e(j jVar) {
            super(jVar);
        }

        @Override // ua.k, ua.j
        @NotNull
        public x0 p(@NotNull q0 q0Var, boolean z10) throws IOException {
            q0 q0VarH = q0Var.h();
            if (q0VarH != null) {
                d(q0VarH);
            }
            return super.p(q0Var, z10);
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.kt */
    @kotlin.coroutines.jvm.internal.f(c = "coil.disk.DiskLruCache$launchCleanup$1", f = "DiskLruCache.kt", l = {}, m = "invokeSuspend")
    static final class f extends l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f31545j;

        f(z8.d<? super f> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return b.this.new f(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f31545j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            b bVar = b.this;
            synchronized (bVar) {
                if (!bVar.f31524n || bVar.f31525o) {
                    return k0.f35197a;
                }
                try {
                    bVar.T0();
                } catch (IOException unused) {
                    bVar.f31526p = true;
                }
                try {
                    if (bVar.L0()) {
                        bVar.V0();
                    }
                } catch (IOException unused2) {
                    bVar.f31527q = true;
                    bVar.f31522l = ua.k0.c(ua.k0.b());
                }
                return k0.f35197a;
            }
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((f) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.kt */
    static final class g extends v implements h9.l<IOException, k0> {
        g() {
            super(1);
        }

        public final void a(@NotNull IOException iOException) {
            b.this.f31523m = true;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(IOException iOException) {
            a(iOException);
            return k0.f35197a;
        }
    }

    public b(@NotNull j jVar, @NotNull q0 q0Var, @NotNull kotlinx.coroutines.k0 k0Var, long j10, int i10, int i11) {
        this.f31511a = q0Var;
        this.f31512b = j10;
        this.f31513c = i10;
        this.f31514d = i11;
        if (!(j10 > 0)) {
            throw new IllegalArgumentException("maxSize <= 0".toString());
        }
        if (!(i11 > 0)) {
            throw new IllegalArgumentException("valueCount <= 0".toString());
        }
        this.f31515e = q0Var.j("journal");
        this.f31516f = q0Var.j("journal.tmp");
        this.f31517g = q0Var.j("journal.bkp");
        this.f31518h = new LinkedHashMap<>(0, 0.75f, true);
        this.f31519i = p0.a(y2.b(null, 1, null).plus(k0Var.limitedParallelism(1)));
        this.f31528r = new e(jVar);
    }

    private final void G0() throws IOException {
        close();
        a0.e.b(this.f31528r, this.f31511a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean L0() {
        return this.f31521k >= 2000;
    }

    private final void M0() {
        kotlinx.coroutines.k.d(this.f31519i, null, null, new f(null), 3, null);
    }

    private final ua.d N0() {
        return ua.k0.c(new n.c(this.f31528r.a(this.f31515e), new g()));
    }

    private final void O0() throws IOException {
        Iterator<c> it = this.f31518h.values().iterator();
        long j10 = 0;
        while (it.hasNext()) {
            c next = it.next();
            int i10 = 0;
            if (next.b() == null) {
                int i11 = this.f31514d;
                while (i10 < i11) {
                    j10 += next.e()[i10];
                    i10++;
                }
            } else {
                next.i(null);
                int i12 = this.f31514d;
                while (i10 < i12) {
                    this.f31528r.h(next.a().get(i10));
                    this.f31528r.h(next.c().get(i10));
                    i10++;
                }
                it.remove();
            }
        }
        this.f31520j = j10;
    }

    private final void P0() throws Throwable {
        k0 k0Var;
        ua.e eVarD = ua.k0.d(this.f31528r.q(this.f31515e));
        Throwable th = null;
        try {
            String strN = eVarD.N();
            String strN2 = eVarD.N();
            String strN3 = eVarD.N();
            String strN4 = eVarD.N();
            String strN5 = eVarD.N();
            if (t.d("libcore.io.DiskLruCache", strN) && t.d("1", strN2) && t.d(String.valueOf(this.f31513c), strN3) && t.d(String.valueOf(this.f31514d), strN4)) {
                int i10 = 0;
                if (!(strN5.length() > 0)) {
                    while (true) {
                        try {
                            Q0(eVarD.N());
                            i10++;
                        } catch (EOFException unused) {
                            this.f31521k = i10 - this.f31518h.size();
                            if (eVarD.m0()) {
                                this.f31522l = N0();
                            } else {
                                V0();
                            }
                            k0Var = k0.f35197a;
                            if (eVarD != null) {
                                try {
                                    eVarD.close();
                                } catch (Throwable th2) {
                                    if (th == null) {
                                        th = th2;
                                    } else {
                                        v8.f.a(th, th2);
                                    }
                                }
                            }
                            if (th != null) {
                                throw th;
                            }
                            t.f(k0Var);
                            return;
                        }
                    }
                }
            }
            throw new IOException("unexpected journal header: [" + strN + ", " + strN2 + ", " + strN3 + ", " + strN4 + ", " + strN5 + ']');
        } catch (Throwable th3) {
            th = th3;
            k0Var = null;
        }
    }

    private final void Q0(String str) throws IOException {
        String strSubstring;
        int iD0 = r.d0(str, ' ', 0, false, 6, null);
        if (iD0 == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i10 = iD0 + 1;
        int iD02 = r.d0(str, ' ', i10, false, 4, null);
        if (iD02 == -1) {
            strSubstring = str.substring(i10);
            t.h(strSubstring, "this as java.lang.String).substring(startIndex)");
            if (iD0 == 6 && q.K(str, "REMOVE", false, 2, null)) {
                this.f31518h.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i10, iD02);
            t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        LinkedHashMap<String, c> linkedHashMap = this.f31518h;
        c cVar = linkedHashMap.get(strSubstring);
        if (cVar == null) {
            cVar = new c(strSubstring);
            linkedHashMap.put(strSubstring, cVar);
        }
        c cVar2 = cVar;
        if (iD02 != -1 && iD0 == 5 && q.K(str, "CLEAN", false, 2, null)) {
            String strSubstring2 = str.substring(iD02 + 1);
            t.h(strSubstring2, "this as java.lang.String).substring(startIndex)");
            List<String> listB0 = r.B0(strSubstring2, new char[]{' '}, false, 0, 6, null);
            cVar2.l(true);
            cVar2.i(null);
            cVar2.j(listB0);
            return;
        }
        if (iD02 == -1 && iD0 == 5 && q.K(str, "DIRTY", false, 2, null)) {
            cVar2.i(new C0630b(cVar2));
            return;
        }
        if (iD02 == -1 && iD0 == 4 && q.K(str, "READ", false, 2, null)) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean R0(c cVar) throws IOException {
        ua.d dVar;
        if (cVar.f() > 0 && (dVar = this.f31522l) != null) {
            dVar.E("DIRTY");
            dVar.writeByte(32);
            dVar.E(cVar.d());
            dVar.writeByte(10);
            dVar.flush();
        }
        if (cVar.f() > 0 || cVar.b() != null) {
            cVar.m(true);
            return true;
        }
        int i10 = this.f31514d;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f31528r.h(cVar.a().get(i11));
            this.f31520j -= cVar.e()[i11];
            cVar.e()[i11] = 0;
        }
        this.f31521k++;
        ua.d dVar2 = this.f31522l;
        if (dVar2 != null) {
            dVar2.E("REMOVE");
            dVar2.writeByte(32);
            dVar2.E(cVar.d());
            dVar2.writeByte(10);
        }
        this.f31518h.remove(cVar.d());
        if (L0()) {
            M0();
        }
        return true;
    }

    private final boolean S0() throws IOException {
        for (c cVar : this.f31518h.values()) {
            if (!cVar.h()) {
                R0(cVar);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T0() {
        while (this.f31520j > this.f31512b) {
            if (!S0()) {
                return;
            }
        }
        this.f31526p = false;
    }

    private final void U0(String str) {
        if (f31510t.a(str)) {
            return;
        }
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + '\"').toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void V0() {
        k0 k0Var;
        ua.d dVar = this.f31522l;
        if (dVar != null) {
            dVar.close();
        }
        ua.d dVarC = ua.k0.c(this.f31528r.p(this.f31516f, false));
        Throwable th = null;
        try {
            dVarC.E("libcore.io.DiskLruCache").writeByte(10);
            dVarC.E("1").writeByte(10);
            dVarC.b0(this.f31513c).writeByte(10);
            dVarC.b0(this.f31514d).writeByte(10);
            dVarC.writeByte(10);
            for (c cVar : this.f31518h.values()) {
                if (cVar.b() != null) {
                    dVarC.E("DIRTY");
                    dVarC.writeByte(32);
                    dVarC.E(cVar.d());
                    dVarC.writeByte(10);
                } else {
                    dVarC.E("CLEAN");
                    dVarC.writeByte(32);
                    dVarC.E(cVar.d());
                    cVar.o(dVarC);
                    dVarC.writeByte(10);
                }
            }
            k0Var = k0.f35197a;
        } catch (Throwable th2) {
            k0Var = null;
            th = th2;
        }
        if (dVarC != null) {
            try {
                dVarC.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                } else {
                    v8.f.a(th, th3);
                }
            }
        }
        if (th != null) {
            throw th;
        }
        t.f(k0Var);
        if (this.f31528r.j(this.f31515e)) {
            this.f31528r.c(this.f31515e, this.f31517g);
            this.f31528r.c(this.f31516f, this.f31515e);
            this.f31528r.h(this.f31517g);
        } else {
            this.f31528r.c(this.f31516f, this.f31515e);
        }
        this.f31522l = N0();
        this.f31521k = 0;
        this.f31523m = false;
        this.f31527q = false;
    }

    private final void h0() {
        if (!(!this.f31525o)) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void i0(C0630b c0630b, boolean z10) {
        c cVarG = c0630b.g();
        if (!t.d(cVarG.b(), c0630b)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        int i10 = 0;
        if (!z10 || cVarG.h()) {
            int i11 = this.f31514d;
            while (i10 < i11) {
                this.f31528r.h(cVarG.c().get(i10));
                i10++;
            }
        } else {
            int i12 = this.f31514d;
            for (int i13 = 0; i13 < i12; i13++) {
                if (c0630b.h()[i13] && !this.f31528r.j(cVarG.c().get(i13))) {
                    c0630b.a();
                    return;
                }
            }
            int i14 = this.f31514d;
            while (i10 < i14) {
                q0 q0Var = cVarG.c().get(i10);
                q0 q0Var2 = cVarG.a().get(i10);
                if (this.f31528r.j(q0Var)) {
                    this.f31528r.c(q0Var, q0Var2);
                } else {
                    a0.e.a(this.f31528r, cVarG.a().get(i10));
                }
                long j10 = cVarG.e()[i10];
                Long lD = this.f31528r.l(q0Var2).d();
                long jLongValue = lD != null ? lD.longValue() : 0L;
                cVarG.e()[i10] = jLongValue;
                this.f31520j = (this.f31520j - j10) + jLongValue;
                i10++;
            }
        }
        cVarG.i(null);
        if (cVarG.h()) {
            R0(cVarG);
            return;
        }
        this.f31521k++;
        ua.d dVar = this.f31522l;
        t.f(dVar);
        if (z10 || cVarG.g()) {
            cVarG.l(true);
            dVar.E("CLEAN");
            dVar.writeByte(32);
            dVar.E(cVarG.d());
            cVarG.o(dVar);
            dVar.writeByte(10);
        } else {
            this.f31518h.remove(cVarG.d());
            dVar.E("REMOVE");
            dVar.writeByte(32);
            dVar.E(cVarG.d());
            dVar.writeByte(10);
        }
        dVar.flush();
        if (this.f31520j > this.f31512b || L0()) {
            M0();
        }
    }

    @Nullable
    public final synchronized C0630b I0(@NotNull String str) {
        h0();
        U0(str);
        K0();
        c cVar = this.f31518h.get(str);
        if ((cVar != null ? cVar.b() : null) != null) {
            return null;
        }
        if (cVar != null && cVar.f() != 0) {
            return null;
        }
        if (!this.f31526p && !this.f31527q) {
            ua.d dVar = this.f31522l;
            t.f(dVar);
            dVar.E("DIRTY");
            dVar.writeByte(32);
            dVar.E(str);
            dVar.writeByte(10);
            dVar.flush();
            if (this.f31523m) {
                return null;
            }
            if (cVar == null) {
                cVar = new c(str);
                this.f31518h.put(str, cVar);
            }
            C0630b c0630b = new C0630b(cVar);
            cVar.i(c0630b);
            return c0630b;
        }
        M0();
        return null;
    }

    @Nullable
    public final synchronized d J0(@NotNull String str) {
        d dVarN;
        h0();
        U0(str);
        K0();
        c cVar = this.f31518h.get(str);
        if (cVar != null && (dVarN = cVar.n()) != null) {
            this.f31521k++;
            ua.d dVar = this.f31522l;
            t.f(dVar);
            dVar.E("READ");
            dVar.writeByte(32);
            dVar.E(str);
            dVar.writeByte(10);
            if (L0()) {
                M0();
            }
            return dVarN;
        }
        return null;
    }

    public final synchronized void K0() {
        if (this.f31524n) {
            return;
        }
        this.f31528r.h(this.f31516f);
        if (this.f31528r.j(this.f31517g)) {
            if (this.f31528r.j(this.f31515e)) {
                this.f31528r.h(this.f31517g);
            } else {
                this.f31528r.c(this.f31517g, this.f31515e);
            }
        }
        if (this.f31528r.j(this.f31515e)) {
            try {
                P0();
                O0();
                this.f31524n = true;
                return;
            } catch (IOException unused) {
                try {
                    G0();
                    this.f31525o = false;
                    V0();
                    this.f31524n = true;
                } catch (Throwable th) {
                    this.f31525o = false;
                    throw th;
                }
            }
        }
        V0();
        this.f31524n = true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.f31524n && !this.f31525o) {
            Object[] array = this.f31518h.values().toArray(new c[0]);
            t.g(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            for (c cVar : (c[]) array) {
                C0630b c0630bB = cVar.b();
                if (c0630bB != null) {
                    c0630bB.e();
                }
            }
            T0();
            p0.e(this.f31519i, null, 1, null);
            ua.d dVar = this.f31522l;
            t.f(dVar);
            dVar.close();
            this.f31522l = null;
            this.f31525o = true;
            return;
        }
        this.f31525o = true;
    }

    @Override // java.io.Flushable
    public synchronized void flush() {
        if (this.f31524n) {
            h0();
            T0();
            ua.d dVar = this.f31522l;
            t.f(dVar);
            dVar.flush();
        }
    }
}
