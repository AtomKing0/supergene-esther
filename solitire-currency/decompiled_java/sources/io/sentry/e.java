package io.sentry;

import java.util.List;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BaggageHeader.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Experimental
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f27769a;

    public e(@NotNull String str) {
        this.f27769a = str;
    }

    @Nullable
    public static e a(@NotNull d dVar, @Nullable List<String> list) {
        String strQ = dVar.Q(d.h(list, true, dVar.f27750h).q());
        if (strQ.isEmpty()) {
            return null;
        }
        return new e(strQ);
    }
}
