package la;

import java.io.IOException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RouteException.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class i extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final IOException f31067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private IOException f31068b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull IOException firstConnectException) {
        super(firstConnectException);
        t.i(firstConnectException, "firstConnectException");
        this.f31067a = firstConnectException;
        this.f31068b = firstConnectException;
    }

    public final void a(@NotNull IOException e10) {
        t.i(e10, "e");
        v8.f.a(this.f31067a, e10);
        this.f31068b = e10;
    }

    @NotNull
    public final IOException b() {
        return this.f31067a;
    }

    @NotNull
    public final IOException c() {
        return this.f31068b;
    }
}
