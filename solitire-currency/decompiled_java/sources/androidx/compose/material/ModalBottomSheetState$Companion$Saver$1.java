package androidx.compose.material;

import androidx.compose.runtime.saveable.SaverScope;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ModalBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
final class ModalBottomSheetState$Companion$Saver$1 extends v implements p<SaverScope, ModalBottomSheetState, ModalBottomSheetValue> {
    public static final ModalBottomSheetState$Companion$Saver$1 INSTANCE = new ModalBottomSheetState$Companion$Saver$1();

    ModalBottomSheetState$Companion$Saver$1() {
        super(2);
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final ModalBottomSheetValue mo4invoke(@NotNull SaverScope Saver, @NotNull ModalBottomSheetState it) {
        t.i(Saver, "$this$Saver");
        t.i(it, "it");
        return it.getCurrentValue();
    }
}
