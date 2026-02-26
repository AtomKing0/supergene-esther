package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c2 extends CancellationException implements i0<c2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final transient b2 f29866a;

    public c2(@NotNull String str, @Nullable Throwable th, @NotNull b2 b2Var) {
        super(str);
        this.f29866a = b2Var;
        if (th != null) {
            initCause(th);
        }
    }

    @Override // kotlinx.coroutines.i0
    @Nullable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c2 a() {
        return null;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj != this) {
            if (obj instanceof c2) {
                c2 c2Var = (c2) obj;
                if (!kotlin.jvm.internal.t.d(c2Var.getMessage(), getMessage()) || !kotlin.jvm.internal.t.d(c2Var.f29866a, this.f29866a) || !kotlin.jvm.internal.t.d(c2Var.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    @NotNull
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        kotlin.jvm.internal.t.f(message);
        int iHashCode = ((message.hashCode() * 31) + this.f29866a.hashCode()) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    @NotNull
    public String toString() {
        return super.toString() + "; job=" + this.f29866a;
    }
}
