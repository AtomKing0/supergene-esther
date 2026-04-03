package kotlinx.serialization.json;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Json.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f30042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f30043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f30044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f30045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f30046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f30047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private String f30048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f30049h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f30050i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private String f30051j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f30052k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f30053l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    private fa.c f30054m;

    public c(@NotNull a json) {
        kotlin.jvm.internal.t.i(json, "json");
        this.f30042a = json.e().e();
        this.f30043b = json.e().f();
        this.f30044c = json.e().g();
        this.f30045d = json.e().l();
        this.f30046e = json.e().b();
        this.f30047f = json.e().h();
        this.f30048g = json.e().i();
        this.f30049h = json.e().d();
        this.f30050i = json.e().k();
        this.f30051j = json.e().c();
        this.f30052k = json.e().a();
        this.f30053l = json.e().j();
        this.f30054m = json.a();
    }

    @NotNull
    public final e a() {
        if (this.f30050i && !kotlin.jvm.internal.t.d(this.f30051j, "type")) {
            throw new IllegalArgumentException("Class discriminator should not be specified when array polymorphism is specified".toString());
        }
        if (this.f30047f) {
            if (!kotlin.jvm.internal.t.d(this.f30048g, "    ")) {
                String str = this.f30048g;
                boolean z10 = false;
                int i10 = 0;
                while (true) {
                    boolean z11 = true;
                    if (i10 >= str.length()) {
                        z10 = true;
                        break;
                    }
                    char cCharAt = str.charAt(i10);
                    if (cCharAt != ' ' && cCharAt != '\t' && cCharAt != '\r' && cCharAt != '\n') {
                        z11 = false;
                    }
                    if (!z11) {
                        break;
                    }
                    i10++;
                }
                if (!z10) {
                    throw new IllegalArgumentException(("Only whitespace, tab, newline and carriage return are allowed as pretty print symbols. Had " + this.f30048g).toString());
                }
            }
        } else if (!kotlin.jvm.internal.t.d(this.f30048g, "    ")) {
            throw new IllegalArgumentException("Indent should not be specified when default printing mode is used".toString());
        }
        return new e(this.f30042a, this.f30044c, this.f30045d, this.f30046e, this.f30047f, this.f30043b, this.f30048g, this.f30049h, this.f30050i, this.f30051j, this.f30052k, this.f30053l);
    }

    @NotNull
    public final fa.c b() {
        return this.f30054m;
    }

    public final void c(boolean z10) {
        this.f30046e = z10;
    }

    public final void d(boolean z10) {
        this.f30042a = z10;
    }

    public final void e(boolean z10) {
        this.f30043b = z10;
    }

    public final void f(boolean z10) {
        this.f30044c = z10;
    }

    public final void g(boolean z10) {
        this.f30045d = z10;
    }
}
