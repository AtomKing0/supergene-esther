package c8;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ClientEvents.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final b8.c f4632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Throwable f4633b;

    public f(@NotNull b8.c response, @NotNull Throwable cause) {
        t.i(response, "response");
        t.i(cause, "cause");
        this.f4632a = response;
        this.f4633b = cause;
    }
}
