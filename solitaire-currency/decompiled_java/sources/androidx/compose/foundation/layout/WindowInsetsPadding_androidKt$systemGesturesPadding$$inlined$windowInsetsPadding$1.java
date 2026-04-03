package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WindowInsetsPadding.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsPadding_androidKt$systemGesturesPadding$$inlined$windowInsetsPadding$1 extends v implements q<Modifier, Composer, Integer, Modifier> {
    public WindowInsetsPadding_androidKt$systemGesturesPadding$$inlined$windowInsetsPadding$1() {
        super(3);
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
        return invoke(modifier, composer, num.intValue());
    }

    @Composable
    @NotNull
    public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
        t.i(composed, "$this$composed");
        composer.startReplaceableGroup(359872873);
        WindowInsetsHolder windowInsetsHolderCurrent = WindowInsetsHolder.Companion.current(composer, 8);
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(windowInsetsHolderCurrent);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new InsetsPaddingModifier(windowInsetsHolderCurrent.getSystemGestures(), null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        InsetsPaddingModifier insetsPaddingModifier = (InsetsPaddingModifier) objRememberedValue;
        composer.endReplaceableGroup();
        return insetsPaddingModifier;
    }
}
