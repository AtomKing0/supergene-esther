package kotlinx.serialization.json;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: JsonConfiguration.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f30055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f30056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f30057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f30058d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f30059e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f30060f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final String f30061g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f30062h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f30063i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private final String f30064j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f30065k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f30066l;

    public e(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, @NotNull String prettyPrintIndent, boolean z16, boolean z17, @NotNull String classDiscriminator, boolean z18, boolean z19) {
        kotlin.jvm.internal.t.i(prettyPrintIndent, "prettyPrintIndent");
        kotlin.jvm.internal.t.i(classDiscriminator, "classDiscriminator");
        this.f30055a = z10;
        this.f30056b = z11;
        this.f30057c = z12;
        this.f30058d = z13;
        this.f30059e = z14;
        this.f30060f = z15;
        this.f30061g = prettyPrintIndent;
        this.f30062h = z16;
        this.f30063i = z17;
        this.f30064j = classDiscriminator;
        this.f30065k = z18;
        this.f30066l = z19;
    }

    public final boolean a() {
        return this.f30065k;
    }

    public final boolean b() {
        return this.f30058d;
    }

    @NotNull
    public final String c() {
        return this.f30064j;
    }

    public final boolean d() {
        return this.f30062h;
    }

    public final boolean e() {
        return this.f30055a;
    }

    public final boolean f() {
        return this.f30060f;
    }

    public final boolean g() {
        return this.f30056b;
    }

    public final boolean h() {
        return this.f30059e;
    }

    @NotNull
    public final String i() {
        return this.f30061g;
    }

    public final boolean j() {
        return this.f30066l;
    }

    public final boolean k() {
        return this.f30063i;
    }

    public final boolean l() {
        return this.f30057c;
    }

    @NotNull
    public String toString() {
        return "JsonConfiguration(encodeDefaults=" + this.f30055a + ", ignoreUnknownKeys=" + this.f30056b + ", isLenient=" + this.f30057c + ", allowStructuredMapKeys=" + this.f30058d + ", prettyPrint=" + this.f30059e + ", explicitNulls=" + this.f30060f + ", prettyPrintIndent='" + this.f30061g + "', coerceInputValues=" + this.f30062h + ", useArrayPolymorphism=" + this.f30063i + ", classDiscriminator='" + this.f30064j + "', allowSpecialFloatingPointValues=" + this.f30065k + ')';
    }

    public /* synthetic */ e(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, String str, boolean z16, boolean z17, String str2, boolean z18, boolean z19, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? false : z11, (i10 & 4) != 0 ? false : z12, (i10 & 8) != 0 ? false : z13, (i10 & 16) != 0 ? false : z14, (i10 & 32) != 0 ? true : z15, (i10 & 64) != 0 ? "    " : str, (i10 & 128) != 0 ? false : z16, (i10 & 256) != 0 ? false : z17, (i10 & 512) != 0 ? "type" : str2, (i10 & 1024) == 0 ? z18 : false, (i10 & 2048) == 0 ? z19 : true);
    }
}
