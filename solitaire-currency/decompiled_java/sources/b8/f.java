package b8;

import kotlin.jvm.internal.k;
import l8.h;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HttpResponsePipeline.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f extends l8.d<d, t7.b> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f2253h = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private static final h f2254i = new h("Receive");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private static final h f2255j = new h("Parse");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private static final h f2256k = new h("Transform");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private static final h f2257l = new h("State");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    private static final h f2258m = new h("After");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f2259g;

    /* JADX INFO: compiled from: HttpResponsePipeline.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }

        @NotNull
        public final h a() {
            return f.f2255j;
        }

        @NotNull
        public final h b() {
            return f.f2254i;
        }

        @NotNull
        public final h c() {
            return f.f2256k;
        }
    }

    public f(boolean z10) {
        super(f2254i, f2255j, f2256k, f2257l, f2258m);
        this.f2259g = z10;
    }

    @Override // l8.d
    public boolean g() {
        return this.f2259g;
    }
}
