package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import androidx.compose.runtime.Composer;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ComposableLambdaN.jvm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ComposableLambdaN_jvmKt {
    private static final int SLOTS_PER_INT = 10;

    @ComposeCompilerApi
    @NotNull
    public static final ComposableLambdaN composableLambdaN(@NotNull Composer composer, int i10, boolean z10, int i11, @NotNull Object block) {
        ComposableLambdaNImpl composableLambdaNImpl;
        t.i(composer, "composer");
        t.i(block, "block");
        composer.startReplaceableGroup(i10);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            composableLambdaNImpl = new ComposableLambdaNImpl(i10, z10, i11);
            composer.updateRememberedValue(composableLambdaNImpl);
        } else {
            if (objRememberedValue == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.internal.ComposableLambdaNImpl");
            }
            composableLambdaNImpl = (ComposableLambdaNImpl) objRememberedValue;
        }
        composableLambdaNImpl.update(block);
        composer.endReplaceableGroup();
        return composableLambdaNImpl;
    }

    @ComposeCompilerApi
    @NotNull
    public static final ComposableLambdaN composableLambdaNInstance(int i10, boolean z10, int i11, @NotNull Object block) {
        t.i(block, "block");
        ComposableLambdaNImpl composableLambdaNImpl = new ComposableLambdaNImpl(i10, z10, i11);
        composableLambdaNImpl.update(block);
        return composableLambdaNImpl;
    }
}
