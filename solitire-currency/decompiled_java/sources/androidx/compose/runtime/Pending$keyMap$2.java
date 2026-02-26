package androidx.compose.runtime;

import java.util.HashMap;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Composer.kt */
/* JADX INFO: loaded from: classes.dex */
final class Pending$keyMap$2 extends v implements h9.a<HashMap<Object, LinkedHashSet<KeyInfo>>> {
    final /* synthetic */ Pending this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Pending$keyMap$2(Pending pending) {
        super(0);
        this.this$0 = pending;
    }

    @Override // h9.a
    @NotNull
    public final HashMap<Object, LinkedHashSet<KeyInfo>> invoke() {
        HashMap<Object, LinkedHashSet<KeyInfo>> mapMultiMap = ComposerKt.multiMap();
        Pending pending = this.this$0;
        int size = pending.getKeyInfos().size();
        for (int i10 = 0; i10 < size; i10++) {
            KeyInfo keyInfo = pending.getKeyInfos().get(i10);
            ComposerKt.put(mapMultiMap, ComposerKt.getJoinedKey(keyInfo), keyInfo);
        }
        return mapMultiMap;
    }
}
