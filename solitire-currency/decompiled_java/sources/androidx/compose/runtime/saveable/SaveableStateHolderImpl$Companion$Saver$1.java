package androidx.compose.runtime.saveable;

import h9.p;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SaveableStateHolder.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaveableStateHolderImpl$Companion$Saver$1 extends v implements p<SaverScope, SaveableStateHolderImpl, Map<Object, Map<String, ? extends List<? extends Object>>>> {
    public static final SaveableStateHolderImpl$Companion$Saver$1 INSTANCE = new SaveableStateHolderImpl$Companion$Saver$1();

    SaveableStateHolderImpl$Companion$Saver$1() {
        super(2);
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Map<Object, Map<String, List<Object>>> mo4invoke(@NotNull SaverScope Saver, @NotNull SaveableStateHolderImpl it) {
        t.i(Saver, "$this$Saver");
        t.i(it, "it");
        return it.saveAll();
    }
}
