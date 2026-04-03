package a8;

import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HttpRequestPipeline.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class h extends l8.d<Object, c> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f368h = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private static final l8.h f369i = new l8.h("Before");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private static final l8.h f370j = new l8.h("State");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private static final l8.h f371k = new l8.h("Monitoring");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private static final l8.h f372l = new l8.h("Engine");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    private static final l8.h f373m = new l8.h("Receive");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f374g;

    /* JADX INFO: compiled from: HttpRequestPipeline.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }

        @NotNull
        public final l8.h a() {
            return h.f372l;
        }

        @NotNull
        public final l8.h b() {
            return h.f373m;
        }
    }

    public h(boolean z10) {
        super(f369i, f370j, f371k, f372l, f373m);
        this.f374g = z10;
    }

    @Override // l8.d
    public boolean g() {
        return this.f374g;
    }
}
