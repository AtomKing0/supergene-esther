package androidx.compose.ui.layout;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RelocationRequesterModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RelocationRequesterModifierKt {
    @ExperimentalComposeUiApi
    @NotNull
    public static final Modifier relocationRequester(@NotNull Modifier modifier, @NotNull Object relocationRequester) {
        t.i(modifier, "<this>");
        t.i(relocationRequester, "relocationRequester");
        return modifier;
    }
}
