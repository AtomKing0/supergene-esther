package androidx.compose.ui.modifier;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ModifierLocalConsumer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModifierLocalConsumerKt {
    @Stable
    @ExperimentalComposeUiApi
    @NotNull
    public static final Modifier modifierLocalConsumer(@NotNull Modifier modifier, @NotNull l<? super ModifierLocalReadScope, k0> consumer) {
        t.i(modifier, "<this>");
        t.i(consumer, "consumer");
        return modifier.then(new ModifierLocalConsumerImpl(consumer, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ModifierLocalConsumerKt$modifierLocalConsumer$$inlined$debugInspectorInfo$1(consumer) : InspectableValueKt.getNoInspectorInfo()));
    }
}
