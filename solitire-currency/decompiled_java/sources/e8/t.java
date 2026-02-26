package e8;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HttpMethod.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f25351b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final t f25352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private static final t f25353d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final t f25354e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final t f25355f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private static final t f25356g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private static final t f25357h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private static final t f25358i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private static final List<t> f25359j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f25360a;

    /* JADX INFO: compiled from: HttpMethod.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final t a() {
            return t.f25352c;
        }

        @NotNull
        public final t b() {
            return t.f25357h;
        }

        @NotNull
        public final t c() {
            return t.f25353d;
        }
    }

    static {
        t tVar = new t("GET");
        f25352c = tVar;
        t tVar2 = new t("POST");
        f25353d = tVar2;
        t tVar3 = new t("PUT");
        f25354e = tVar3;
        t tVar4 = new t("PATCH");
        f25355f = tVar4;
        t tVar5 = new t("DELETE");
        f25356g = tVar5;
        t tVar6 = new t("HEAD");
        f25357h = tVar6;
        t tVar7 = new t("OPTIONS");
        f25358i = tVar7;
        f25359j = kotlin.collections.v.n(tVar, tVar2, tVar3, tVar4, tVar5, tVar6, tVar7);
    }

    public t(@NotNull String value) {
        kotlin.jvm.internal.t.i(value, "value");
        this.f25360a = value;
    }

    @NotNull
    public final String d() {
        return this.f25360a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof t) && kotlin.jvm.internal.t.d(this.f25360a, ((t) obj).f25360a);
    }

    public int hashCode() {
        return this.f25360a.hashCode();
    }

    @NotNull
    public String toString() {
        return "HttpMethod(value=" + this.f25360a + ')';
    }
}
