package a8;

import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HttpRequestPipeline.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f extends l8.d<Object, c> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f354h = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private static final l8.h f355i = new l8.h("Before");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private static final l8.h f356j = new l8.h("State");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private static final l8.h f357k = new l8.h("Transform");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private static final l8.h f358l = new l8.h("Render");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    private static final l8.h f359m = new l8.h("Send");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f360g;

    /* JADX INFO: compiled from: HttpRequestPipeline.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }

        @NotNull
        public final l8.h a() {
            return f.f355i;
        }

        @NotNull
        public final l8.h b() {
            return f.f358l;
        }

        @NotNull
        public final l8.h c() {
            return f.f359m;
        }

        @NotNull
        public final l8.h d() {
            return f.f356j;
        }
    }

    public f(boolean z10) {
        super(f355i, f356j, f357k, f358l, f359m);
        this.f360g = z10;
    }

    @Override // l8.d
    public boolean g() {
        return this.f360g;
    }
}
