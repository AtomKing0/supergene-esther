package x7;

import java.net.SocketTimeoutException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TimeoutExceptions.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends SocketTimeoutException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final Throwable f36216a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull String message, @Nullable Throwable th) {
        super(message);
        t.i(message, "message");
        this.f36216a = th;
    }

    @Override // java.lang.Throwable
    @Nullable
    public Throwable getCause() {
        return this.f36216a;
    }
}
