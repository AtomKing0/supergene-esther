package u;

import ga.d0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HttpException.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final d0 f34219a;

    public d(@NotNull d0 d0Var) {
        super("HTTP " + d0Var.q() + ": " + d0Var.R());
        this.f34219a = d0Var;
    }
}
