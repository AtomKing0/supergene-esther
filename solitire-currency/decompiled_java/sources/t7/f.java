package t7;

import e8.k;
import e8.p0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SavedCall.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f implements a8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final e f34096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ a8.b f34097b;

    public f(@NotNull e call, @NotNull a8.b origin) {
        t.i(call, "call");
        t.i(origin, "origin");
        this.f34096a = call;
        this.f34097b = origin;
    }

    @Override // e8.q
    @NotNull
    public k b() {
        return this.f34097b.b();
    }

    @Override // a8.b
    @NotNull
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public e R() {
        return this.f34096a;
    }

    @Override // a8.b
    @NotNull
    public g8.b getAttributes() {
        return this.f34097b.getAttributes();
    }

    @Override // a8.b, kotlinx.coroutines.o0
    @NotNull
    public z8.g getCoroutineContext() {
        return this.f34097b.getCoroutineContext();
    }

    @Override // a8.b
    @NotNull
    public e8.t getMethod() {
        return this.f34097b.getMethod();
    }

    @Override // a8.b
    @NotNull
    public p0 getUrl() {
        return this.f34097b.getUrl();
    }
}
