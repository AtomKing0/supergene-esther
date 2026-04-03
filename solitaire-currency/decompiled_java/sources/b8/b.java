package b8;

import kotlin.jvm.internal.k;
import l8.h;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: HttpResponsePipeline.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends l8.d<c, k0> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f2241h = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private static final h f2242i = new h("Before");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private static final h f2243j = new h("State");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private static final h f2244k = new h("After");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f2245g;

    /* JADX INFO: compiled from: HttpResponsePipeline.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }

        @NotNull
        public final h a() {
            return b.f2244k;
        }
    }

    public b(boolean z10) {
        super(f2242i, f2243j, f2244k);
        this.f2245g = z10;
    }

    @Override // l8.d
    public boolean g() {
        return this.f2245g;
    }
}
