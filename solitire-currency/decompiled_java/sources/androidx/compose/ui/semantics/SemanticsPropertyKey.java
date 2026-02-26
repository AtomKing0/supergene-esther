package androidx.compose.ui.semantics;

import androidx.compose.runtime.internal.StabilityInferred;
import h9.p;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SemanticsProperties.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class SemanticsPropertyKey<T> {
    public static final int $stable = 0;

    @NotNull
    private final p<T, T, T> mergePolicy;

    @NotNull
    private final String name;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: androidx.compose.ui.semantics.SemanticsPropertyKey$1, reason: invalid class name */
    /* JADX INFO: compiled from: SemanticsProperties.kt */
    public static final class AnonymousClass1 extends v implements p<T, T, T> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(2);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke */
        public final T mo4invoke(@Nullable T t10, T t11) {
            return t10 == null ? t11 : t10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SemanticsPropertyKey(@NotNull String name, @NotNull p<? super T, ? super T, ? extends T> mergePolicy) {
        t.i(name, "name");
        t.i(mergePolicy, "mergePolicy");
        this.name = name;
        this.mergePolicy = mergePolicy;
    }

    @NotNull
    public final p<T, T, T> getMergePolicy$ui_release() {
        return this.mergePolicy;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final T getValue(@NotNull SemanticsPropertyReceiver thisRef, @NotNull KProperty<?> property) {
        t.i(thisRef, "thisRef");
        t.i(property, "property");
        return (T) SemanticsPropertiesKt.throwSemanticsGetNotSupported();
    }

    @Nullable
    public final T merge(@Nullable T t10, T t11) {
        return this.mergePolicy.mo4invoke(t10, t11);
    }

    public final void setValue(@NotNull SemanticsPropertyReceiver thisRef, @NotNull KProperty<?> property, T t10) {
        t.i(thisRef, "thisRef");
        t.i(property, "property");
        thisRef.set(this, t10);
    }

    @NotNull
    public String toString() {
        return "SemanticsPropertyKey: " + this.name;
    }

    public /* synthetic */ SemanticsPropertyKey(String str, p pVar, int i10, k kVar) {
        this(str, (i10 & 2) != 0 ? AnonymousClass1.INSTANCE : pVar);
    }
}
