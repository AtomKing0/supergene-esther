package t7;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HttpClientCall.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f34077a;

    public a(@NotNull b call) {
        t.i(call, "call");
        this.f34077a = "Response already received: " + call;
    }

    @Override // java.lang.Throwable
    @NotNull
    public String getMessage() {
        return this.f34077a;
    }
}
