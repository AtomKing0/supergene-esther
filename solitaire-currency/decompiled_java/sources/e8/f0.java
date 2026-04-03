package e8;

import com.ironsource.v8;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: URLBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    public static final a f25235k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private static final p0 f25236l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private l0 f25237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private String f25238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f25239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f25240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private String f25241e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private String f25242f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private String f25243g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private List<String> f25244h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private a0 f25245i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private a0 f25246j;

    /* JADX INFO: compiled from: URLBuilder.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    static {
        a aVar = new a(null);
        f25235k = aVar;
        f25236l = n0.c(g0.a(aVar));
    }

    public f0(@NotNull l0 protocol, @NotNull String host, int i10, @Nullable String str, @Nullable String str2, @NotNull List<String> pathSegments, @NotNull z parameters, @NotNull String fragment, boolean z10) {
        kotlin.jvm.internal.t.i(protocol, "protocol");
        kotlin.jvm.internal.t.i(host, "host");
        kotlin.jvm.internal.t.i(pathSegments, "pathSegments");
        kotlin.jvm.internal.t.i(parameters, "parameters");
        kotlin.jvm.internal.t.i(fragment, "fragment");
        this.f25237a = protocol;
        this.f25238b = host;
        this.f25239c = i10;
        this.f25240d = z10;
        this.f25241e = str != null ? b.m(str, false, 1, null) : null;
        this.f25242f = str2 != null ? b.m(str2, false, 1, null) : null;
        this.f25243g = b.r(fragment, false, false, null, 7, null);
        List<String> list = pathSegments;
        ArrayList arrayList = new ArrayList(kotlin.collections.w.v(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(b.p((String) it.next()));
        }
        this.f25244h = arrayList;
        a0 a0VarE = r0.e(parameters);
        this.f25245i = a0VarE;
        this.f25246j = new q0(a0VarE);
    }

    private final void a() {
        if ((this.f25238b.length() > 0) || kotlin.jvm.internal.t.d(this.f25237a.d(), v8.h.f15781b)) {
            return;
        }
        p0 p0Var = f25236l;
        this.f25238b = p0Var.g();
        if (kotlin.jvm.internal.t.d(this.f25237a, l0.f25262c.c())) {
            this.f25237a = p0Var.k();
        }
        if (this.f25239c == 0) {
            this.f25239c = p0Var.l();
        }
    }

    public final void A(@Nullable String str) {
        this.f25241e = str != null ? b.m(str, false, 1, null) : null;
    }

    @NotNull
    public final p0 b() {
        a();
        return new p0(this.f25237a, this.f25238b, this.f25239c, m(), this.f25246j.build(), i(), q(), l(), this.f25240d, c());
    }

    @NotNull
    public final String c() {
        a();
        String string = ((StringBuilder) h0.d(this, new StringBuilder(256))).toString();
        kotlin.jvm.internal.t.h(string, "appendTo(StringBuilder(256)).toString()");
        return string;
    }

    @NotNull
    public final String d() {
        return this.f25243g;
    }

    @NotNull
    public final a0 e() {
        return this.f25245i;
    }

    @Nullable
    public final String f() {
        return this.f25242f;
    }

    @NotNull
    public final List<String> g() {
        return this.f25244h;
    }

    @Nullable
    public final String h() {
        return this.f25241e;
    }

    @NotNull
    public final String i() {
        return b.k(this.f25243g, 0, 0, false, null, 15, null);
    }

    @NotNull
    public final String j() {
        return this.f25238b;
    }

    @NotNull
    public final a0 k() {
        return this.f25246j;
    }

    @Nullable
    public final String l() {
        String str = this.f25242f;
        if (str != null) {
            return b.i(str, 0, 0, null, 7, null);
        }
        return null;
    }

    @NotNull
    public final List<String> m() {
        List<String> list = this.f25244h;
        ArrayList arrayList = new ArrayList(kotlin.collections.w.v(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(b.i((String) it.next(), 0, 0, null, 7, null));
        }
        return arrayList;
    }

    public final int n() {
        return this.f25239c;
    }

    @NotNull
    public final l0 o() {
        return this.f25237a;
    }

    public final boolean p() {
        return this.f25240d;
    }

    @Nullable
    public final String q() {
        String str = this.f25241e;
        if (str != null) {
            return b.i(str, 0, 0, null, 7, null);
        }
        return null;
    }

    public final void r(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<set-?>");
        this.f25243g = str;
    }

    public final void s(@NotNull a0 value) {
        kotlin.jvm.internal.t.i(value, "value");
        this.f25245i = value;
        this.f25246j = new q0(value);
    }

    public final void t(@Nullable String str) {
        this.f25242f = str;
    }

    @NotNull
    public String toString() {
        String string = ((StringBuilder) h0.d(this, new StringBuilder(256))).toString();
        kotlin.jvm.internal.t.h(string, "appendTo(StringBuilder(256)).toString()");
        return string;
    }

    public final void u(@NotNull List<String> list) {
        kotlin.jvm.internal.t.i(list, "<set-?>");
        this.f25244h = list;
    }

    public final void v(@Nullable String str) {
        this.f25241e = str;
    }

    public final void w(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<set-?>");
        this.f25238b = str;
    }

    public final void x(int i10) {
        this.f25239c = i10;
    }

    public final void y(@NotNull l0 l0Var) {
        kotlin.jvm.internal.t.i(l0Var, "<set-?>");
        this.f25237a = l0Var;
    }

    public final void z(boolean z10) {
        this.f25240d = z10;
    }

    public /* synthetic */ f0(l0 l0Var, String str, int i10, String str2, String str3, List list, z zVar, String str4, boolean z10, int i11, kotlin.jvm.internal.k kVar) {
        this((i11 & 1) != 0 ? l0.f25262c.c() : l0Var, (i11 & 2) != 0 ? "" : str, (i11 & 4) != 0 ? 0 : i10, (i11 & 8) != 0 ? null : str2, (i11 & 16) == 0 ? str3 : null, (i11 & 32) != 0 ? kotlin.collections.v.l() : list, (i11 & 64) != 0 ? z.f25406b.a() : zVar, (i11 & 128) == 0 ? str4 : "", (i11 & 256) == 0 ? z10 : false);
    }
}
