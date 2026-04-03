package t7;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HttpClientCall.kt */
/* JADX INFO: loaded from: classes4.dex */
public class b implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final s7.a f34081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected a8.b f34082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected b8.c f34083c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f34084d;

    @NotNull
    private volatile /* synthetic */ int received;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f34078e = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private static final g8.a<Object> f34080g = new g8.a<>("CustomResponse");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f34079f = AtomicIntegerFieldUpdater.newUpdater(b.class, "received");

    /* JADX INFO: compiled from: HttpClientCall.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: t7.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HttpClientCall.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.call.HttpClientCall", f = "HttpClientCall.kt", l = {86, 89}, m = "bodyNullable")
    static final class C0692b extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f34085j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f34086k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f34087l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f34089n;

        C0692b(z8.d<? super C0692b> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f34087l = obj;
            this.f34089n |= Integer.MIN_VALUE;
            return b.this.b(null, this);
        }
    }

    public b(@NotNull s7.a client) {
        t.i(client, "client");
        this.f34081a = client;
        this.received = 0;
    }

    static /* synthetic */ Object h(b bVar, z8.d<? super io.ktor.utils.io.g> dVar) {
        return bVar.f().c();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(@org.jetbrains.annotations.NotNull m8.a r7, @org.jetbrains.annotations.NotNull z8.d<java.lang.Object> r8) {
        /*
            Method dump skipped, instruction units count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t7.b.b(m8.a, z8.d):java.lang.Object");
    }

    protected boolean c() {
        return this.f34084d;
    }

    @NotNull
    public final s7.a d() {
        return this.f34081a;
    }

    @NotNull
    public final a8.b e() {
        a8.b bVar = this.f34082b;
        if (bVar != null) {
            return bVar;
        }
        t.A(com.vungle.ads.internal.ui.a.REQUEST_KEY_EXTRA);
        return null;
    }

    @NotNull
    public final b8.c f() {
        b8.c cVar = this.f34083c;
        if (cVar != null) {
            return cVar;
        }
        t.A("response");
        return null;
    }

    @Nullable
    protected Object g(@NotNull z8.d<? super io.ktor.utils.io.g> dVar) {
        return h(this, dVar);
    }

    @NotNull
    public final g8.b getAttributes() {
        return e().getAttributes();
    }

    @Override // kotlinx.coroutines.o0
    @NotNull
    public z8.g getCoroutineContext() {
        return f().getCoroutineContext();
    }

    protected final void i(@NotNull a8.b bVar) {
        t.i(bVar, "<set-?>");
        this.f34082b = bVar;
    }

    protected final void j(@NotNull b8.c cVar) {
        t.i(cVar, "<set-?>");
        this.f34083c = cVar;
    }

    public final void k(@NotNull b8.c response) {
        t.i(response, "response");
        j(response);
    }

    @NotNull
    public String toString() {
        return "HttpClientCall[" + e().getUrl() + ", " + f().f() + ']';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(@NotNull s7.a client, @NotNull a8.d requestData, @NotNull a8.g responseData) {
        this(client);
        t.i(client, "client");
        t.i(requestData, "requestData");
        t.i(responseData, "responseData");
        i(new a8.a(this, requestData));
        j(new b8.a(this, responseData));
        if (responseData.a() instanceof io.ktor.utils.io.g) {
            return;
        }
        getAttributes().c(f34080g, responseData.a());
    }
}
