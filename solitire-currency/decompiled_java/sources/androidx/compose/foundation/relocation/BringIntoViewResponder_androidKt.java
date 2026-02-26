package androidx.compose.foundation.relocation;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BringIntoViewResponder.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BringIntoViewResponder_androidKt {
    @Composable
    @NotNull
    public static final BringIntoViewParent rememberDefaultBringIntoViewParent(@Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(-1031410916);
        View view = (View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(view);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new AndroidBringIntoViewParent(view);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        AndroidBringIntoViewParent androidBringIntoViewParent = (AndroidBringIntoViewParent) objRememberedValue;
        composer.endReplaceableGroup();
        return androidBringIntoViewParent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect toRect(androidx.compose.ui.geometry.Rect rect) {
        return new Rect((int) rect.getLeft(), (int) rect.getTop(), (int) rect.getRight(), (int) rect.getBottom());
    }
}
