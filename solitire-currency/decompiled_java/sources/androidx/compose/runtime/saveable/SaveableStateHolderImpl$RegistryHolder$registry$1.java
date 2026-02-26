package androidx.compose.runtime.saveable;

import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SaveableStateHolder.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaveableStateHolderImpl$RegistryHolder$registry$1 extends v implements l<Object, Boolean> {
    final /* synthetic */ SaveableStateHolderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SaveableStateHolderImpl$RegistryHolder$registry$1(SaveableStateHolderImpl saveableStateHolderImpl) {
        super(1);
        this.this$0 = saveableStateHolderImpl;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.l
    @NotNull
    public final Boolean invoke(@NotNull Object it) {
        t.i(it, "it");
        SaveableStateRegistry parentSaveableStateRegistry = this.this$0.getParentSaveableStateRegistry();
        return Boolean.valueOf(parentSaveableStateRegistry != null ? parentSaveableStateRegistry.canBeSaved(it) : true);
    }
}
