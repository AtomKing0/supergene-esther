package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Composer.kt */
/* JADX INFO: loaded from: classes.dex */
final class Invalidation {

    @Nullable
    private IdentityArraySet<Object> instances;
    private final int location;

    @NotNull
    private final RecomposeScopeImpl scope;

    public Invalidation(@NotNull RecomposeScopeImpl scope, int i10, @Nullable IdentityArraySet<Object> identityArraySet) {
        t.i(scope, "scope");
        this.scope = scope;
        this.location = i10;
        this.instances = identityArraySet;
    }

    @Nullable
    public final IdentityArraySet<Object> getInstances() {
        return this.instances;
    }

    public final int getLocation() {
        return this.location;
    }

    @NotNull
    public final RecomposeScopeImpl getScope() {
        return this.scope;
    }

    public final boolean isInvalid() {
        return this.scope.isInvalidFor(this.instances);
    }

    public final void setInstances(@Nullable IdentityArraySet<Object> identityArraySet) {
        this.instances = identityArraySet;
    }
}
