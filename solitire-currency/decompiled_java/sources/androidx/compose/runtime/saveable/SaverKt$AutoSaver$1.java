package androidx.compose.runtime.saveable;

import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Saver.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaverKt$AutoSaver$1 extends v implements p<SaverScope, Object, Object> {
    public static final SaverKt$AutoSaver$1 INSTANCE = new SaverKt$AutoSaver$1();

    SaverKt$AutoSaver$1() {
        super(2);
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull SaverScope Saver, @Nullable Object obj) {
        t.i(Saver, "$this$Saver");
        return obj;
    }
}
