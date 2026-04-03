package androidx.compose.material.ripple;

import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RippleTheme.kt */
/* JADX INFO: loaded from: classes.dex */
final class RippleThemeKt$LocalRippleTheme$1 extends v implements h9.a<RippleTheme> {
    public static final RippleThemeKt$LocalRippleTheme$1 INSTANCE = new RippleThemeKt$LocalRippleTheme$1();

    RippleThemeKt$LocalRippleTheme$1() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final RippleTheme invoke() {
        return DebugRippleTheme.INSTANCE;
    }
}
