package androidx.compose.runtime.saveable;

import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Saver.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaverKt$AutoSaver$2 extends v implements l<Object, Object> {
    public static final SaverKt$AutoSaver$2 INSTANCE = new SaverKt$AutoSaver$2();

    SaverKt$AutoSaver$2() {
        super(1);
    }

    @Override // h9.l
    @Nullable
    public final Object invoke(@NotNull Object it) {
        t.i(it, "it");
        return it;
    }
}
