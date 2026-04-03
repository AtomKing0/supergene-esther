package androidx.compose.ui.draw;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.InspectableValueKt;
import h9.l;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: DrawModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DrawModifierKt {

    /* JADX INFO: renamed from: androidx.compose.ui.draw.DrawModifierKt$drawWithCache$2, reason: invalid class name */
    /* JADX INFO: compiled from: DrawModifier.kt */
    static final class AnonymousClass2 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ l<CacheDrawScope, DrawResult> $onBuildDrawCache;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(l<? super CacheDrawScope, DrawResult> lVar) {
            super(3);
            this.$onBuildDrawCache = lVar;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(-1689569019);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new CacheDrawScope();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            Modifier modifierThen = composed.then(new DrawContentCacheModifier((CacheDrawScope) objRememberedValue, this.$onBuildDrawCache));
            composer.endReplaceableGroup();
            return modifierThen;
        }
    }

    @NotNull
    public static final Modifier drawBehind(@NotNull Modifier modifier, @NotNull l<? super DrawScope, k0> onDraw) {
        t.i(modifier, "<this>");
        t.i(onDraw, "onDraw");
        return modifier.then(new DrawBackgroundModifier(onDraw, InspectableValueKt.isDebugInspectorInfoEnabled() ? new DrawModifierKt$drawBehind$$inlined$debugInspectorInfo$1(onDraw) : InspectableValueKt.getNoInspectorInfo()));
    }

    @NotNull
    public static final Modifier drawWithCache(@NotNull Modifier modifier, @NotNull l<? super CacheDrawScope, DrawResult> onBuildDrawCache) {
        t.i(modifier, "<this>");
        t.i(onBuildDrawCache, "onBuildDrawCache");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new DrawModifierKt$drawWithCache$$inlined$debugInspectorInfo$1(onBuildDrawCache) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(onBuildDrawCache));
    }

    @NotNull
    public static final Modifier drawWithContent(@NotNull Modifier modifier, @NotNull l<? super ContentDrawScope, k0> onDraw) {
        t.i(modifier, "<this>");
        t.i(onDraw, "onDraw");
        return modifier.then(new DrawWithContentModifier(onDraw, InspectableValueKt.isDebugInspectorInfoEnabled() ? new DrawModifierKt$drawWithContent$$inlined$debugInspectorInfo$1(onDraw) : InspectableValueKt.getNoInspectorInfo()));
    }
}
