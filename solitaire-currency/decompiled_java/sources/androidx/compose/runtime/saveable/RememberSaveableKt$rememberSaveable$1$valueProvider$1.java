package androidx.compose.runtime.saveable;

import androidx.compose.runtime.State;
import h9.a;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RememberSaveable.kt */
/* JADX INFO: loaded from: classes.dex */
final class RememberSaveableKt$rememberSaveable$1$valueProvider$1 extends v implements a<Object> {
    final /* synthetic */ SaveableStateRegistry $registry;
    final /* synthetic */ State<Saver<T, Object>> $saverState;
    final /* synthetic */ State<T> $valueState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    RememberSaveableKt$rememberSaveable$1$valueProvider$1(State<? extends Saver<T, Object>> state, State<? extends T> state2, SaveableStateRegistry saveableStateRegistry) {
        super(0);
        this.$saverState = state;
        this.$valueState = state2;
        this.$registry = saveableStateRegistry;
    }

    @Override // h9.a
    @Nullable
    public final Object invoke() {
        Object value = this.$saverState.getValue();
        State<T> state = this.$valueState;
        final SaveableStateRegistry saveableStateRegistry = this.$registry;
        return ((Saver) value).save(new SaverScope() { // from class: androidx.compose.runtime.saveable.RememberSaveableKt$rememberSaveable$1$valueProvider$1$1$1
            @Override // androidx.compose.runtime.saveable.SaverScope
            public final boolean canBeSaved(@NotNull Object it) {
                t.i(it, "it");
                return saveableStateRegistry.canBeSaved(it);
            }
        }, state.getValue());
    }
}
