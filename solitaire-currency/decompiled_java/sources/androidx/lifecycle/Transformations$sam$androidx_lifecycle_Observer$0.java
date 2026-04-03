package androidx.lifecycle;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Transformations.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Transformations$sam$androidx_lifecycle_Observer$0 implements Observer, kotlin.jvm.internal.n {
    private final /* synthetic */ h9.l function;

    Transformations$sam$androidx_lifecycle_Observer$0(h9.l function) {
        t.i(function, "function");
        this.function = function;
    }

    public final boolean equals(@Nullable Object obj) {
        if ((obj instanceof Observer) && (obj instanceof kotlin.jvm.internal.n)) {
            return t.d(getFunctionDelegate(), ((kotlin.jvm.internal.n) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.n
    @NotNull
    public final v8.g<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // androidx.lifecycle.Observer
    public final /* synthetic */ void onChanged(Object obj) {
        this.function.invoke(obj);
    }
}
