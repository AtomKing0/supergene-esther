package androidx.compose.runtime;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CompositionLocal.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DynamicProvidableCompositionLocal<T> extends ProvidableCompositionLocal<T> {

    @NotNull
    private final SnapshotMutationPolicy<T> policy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicProvidableCompositionLocal(@NotNull SnapshotMutationPolicy<T> policy, @NotNull h9.a<? extends T> defaultFactory) {
        super(defaultFactory);
        t.i(policy, "policy");
        t.i(defaultFactory, "defaultFactory");
        this.policy = policy;
    }

    @Override // androidx.compose.runtime.CompositionLocal
    @Composable
    @NotNull
    public State<T> provided$runtime_release(T t10, @Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(-84026900);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt.mutableStateOf(t10, this.policy);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) objRememberedValue;
        mutableState.setValue(t10);
        composer.endReplaceableGroup();
        return mutableState;
    }
}
