package androidx.compose.ui.semantics;

import androidx.compose.ui.ExperimentalComposeUiApi;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SemanticsProperties.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SemanticsProperties_androidKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {o0.e(new a0(SemanticsProperties_androidKt.class, "testTagsAsResourceId", "getTestTagsAsResourceId(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1))};

    @NotNull
    private static final SemanticsPropertyKey testTagsAsResourceId$delegate = SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId();

    @ExperimentalComposeUiApi
    public static final boolean getTestTagsAsResourceId(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        t.i(semanticsPropertyReceiver, "<this>");
        return ((Boolean) testTagsAsResourceId$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[0])).booleanValue();
    }

    @ExperimentalComposeUiApi
    public static final void setTestTagsAsResourceId(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z10) {
        t.i(semanticsPropertyReceiver, "<this>");
        testTagsAsResourceId$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[0], Boolean.valueOf(z10));
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getTestTagsAsResourceId$annotations(SemanticsPropertyReceiver semanticsPropertyReceiver) {
    }
}
