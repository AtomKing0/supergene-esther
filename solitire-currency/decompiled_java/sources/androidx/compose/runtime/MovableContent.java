package androidx.compose.runtime;

import androidx.compose.runtime.internal.StabilityInferred;
import h9.q;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Composer.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@InternalComposeApi
public final class MovableContent<P> {
    public static final int $stable = 0;

    @NotNull
    private final q<P, Composer, Integer, k0> content;

    /* JADX WARN: Multi-variable type inference failed */
    public MovableContent(@NotNull q<? super P, ? super Composer, ? super Integer, k0> content) {
        t.i(content, "content");
        this.content = content;
    }

    @NotNull
    public final q<P, Composer, Integer, k0> getContent() {
        return this.content;
    }
}
