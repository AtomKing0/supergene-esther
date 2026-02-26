package androidx.compose.material;

import androidx.compose.runtime.saveable.SaverScope;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Swipeable.kt */
/* JADX INFO: loaded from: classes.dex */
final class SwipeableState$Companion$Saver$1<T> extends v implements p<SaverScope, SwipeableState<T>, T> {
    public static final SwipeableState$Companion$Saver$1 INSTANCE = new SwipeableState$Companion$Saver$1();

    SwipeableState$Companion$Saver$1() {
        super(2);
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final T mo4invoke(@NotNull SaverScope Saver, @NotNull SwipeableState<T> it) {
        t.i(Saver, "$this$Saver");
        t.i(it, "it");
        return it.getCurrentValue();
    }
}
