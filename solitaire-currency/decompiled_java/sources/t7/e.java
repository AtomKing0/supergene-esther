package t7;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SavedCall.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e extends b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final byte[] f34094h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f34095i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull s7.a client, @NotNull a8.b request, @NotNull b8.c response, @NotNull byte[] responseBody) {
        super(client);
        t.i(client, "client");
        t.i(request, "request");
        t.i(response, "response");
        t.i(responseBody, "responseBody");
        this.f34094h = responseBody;
        i(new f(this, request));
        j(new g(this, responseBody, response));
        this.f34095i = true;
    }

    @Override // t7.b
    protected boolean c() {
        return this.f34095i;
    }

    @Override // t7.b
    @Nullable
    protected Object g(@NotNull z8.d<? super io.ktor.utils.io.g> dVar) {
        return io.ktor.utils.io.d.a(this.f34094h);
    }
}
