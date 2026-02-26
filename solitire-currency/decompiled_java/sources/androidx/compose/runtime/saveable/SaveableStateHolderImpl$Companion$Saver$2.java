package androidx.compose.runtime.saveable;

import h9.l;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SaveableStateHolder.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaveableStateHolderImpl$Companion$Saver$2 extends v implements l<Map<Object, Map<String, ? extends List<? extends Object>>>, SaveableStateHolderImpl> {
    public static final SaveableStateHolderImpl$Companion$Saver$2 INSTANCE = new SaveableStateHolderImpl$Companion$Saver$2();

    SaveableStateHolderImpl$Companion$Saver$2() {
        super(1);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ SaveableStateHolderImpl invoke(Map<Object, Map<String, ? extends List<? extends Object>>> map) {
        return invoke2((Map<Object, Map<String, List<Object>>>) map);
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final SaveableStateHolderImpl invoke2(@NotNull Map<Object, Map<String, List<Object>>> it) {
        t.i(it, "it");
        return new SaveableStateHolderImpl(it);
    }
}
