package androidx.compose.foundation;

import android.os.Build;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SystemGestureExclusion.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SystemGestureExclusionKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.SystemGestureExclusionKt$excludeFromSystemGestureR$1, reason: invalid class name */
    /* JADX INFO: compiled from: SystemGestureExclusion.kt */
    public static final class AnonymousClass1 extends v implements h9.l<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ ExcludeFromSystemGestureModifier $modifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ExcludeFromSystemGestureModifier excludeFromSystemGestureModifier) {
            super(1);
            this.$modifier = excludeFromSystemGestureModifier;
        }

        @Override // h9.l
        @NotNull
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
            t.i(DisposableEffect, "$this$DisposableEffect");
            final ExcludeFromSystemGestureModifier excludeFromSystemGestureModifier = this.$modifier;
            return new DisposableEffectResult() { // from class: androidx.compose.foundation.SystemGestureExclusionKt$excludeFromSystemGestureR$1$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    excludeFromSystemGestureModifier.removeRect();
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.SystemGestureExclusionKt$systemGestureExclusion$2, reason: invalid class name */
    /* JADX INFO: compiled from: SystemGestureExclusion.kt */
    static final class AnonymousClass2 extends v implements h9.q<Modifier, Composer, Integer, Modifier> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
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
            composer.startReplaceableGroup(1120057036);
            composer.startReplaceableGroup(202618556);
            View view = (View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
            composer.startReplaceableGroup(511388516);
            boolean zChanged = composer.changed(view) | composer.changed((Object) null);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new ExcludeFromSystemGestureModifier(view, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            ExcludeFromSystemGestureModifier excludeFromSystemGestureModifier = (ExcludeFromSystemGestureModifier) objRememberedValue;
            EffectsKt.DisposableEffect(excludeFromSystemGestureModifier, new AnonymousClass1(excludeFromSystemGestureModifier), composer, 0);
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            return excludeFromSystemGestureModifier;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.SystemGestureExclusionKt$systemGestureExclusion$4, reason: invalid class name */
    /* JADX INFO: compiled from: SystemGestureExclusion.kt */
    static final class AnonymousClass4 extends v implements h9.q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ h9.l<LayoutCoordinates, Rect> $exclusion;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass4(h9.l<? super LayoutCoordinates, Rect> lVar) {
            super(3);
            this.$exclusion = lVar;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(108999);
            h9.l<LayoutCoordinates, Rect> lVar = this.$exclusion;
            composer.startReplaceableGroup(202618556);
            View view = (View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
            composer.startReplaceableGroup(511388516);
            boolean zChanged = composer.changed(view) | composer.changed(lVar);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new ExcludeFromSystemGestureModifier(view, lVar);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            ExcludeFromSystemGestureModifier excludeFromSystemGestureModifier = (ExcludeFromSystemGestureModifier) objRememberedValue;
            EffectsKt.DisposableEffect(excludeFromSystemGestureModifier, new AnonymousClass1(excludeFromSystemGestureModifier), composer, 0);
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            return excludeFromSystemGestureModifier;
        }
    }

    @Composable
    @RequiresApi(30)
    private static final Modifier excludeFromSystemGestureR(h9.l<? super LayoutCoordinates, Rect> lVar, Composer composer, int i10) {
        composer.startReplaceableGroup(202618556);
        View view = (View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        composer.startReplaceableGroup(511388516);
        boolean zChanged = composer.changed(view) | composer.changed(lVar);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new ExcludeFromSystemGestureModifier(view, lVar);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        ExcludeFromSystemGestureModifier excludeFromSystemGestureModifier = (ExcludeFromSystemGestureModifier) objRememberedValue;
        EffectsKt.DisposableEffect(excludeFromSystemGestureModifier, new AnonymousClass1(excludeFromSystemGestureModifier), composer, 0);
        composer.endReplaceableGroup();
        return excludeFromSystemGestureModifier;
    }

    @NotNull
    public static final Modifier systemGestureExclusion(@NotNull Modifier modifier) {
        t.i(modifier, "<this>");
        if (Build.VERSION.SDK_INT < 30) {
            return modifier;
        }
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SystemGestureExclusionKt$systemGestureExclusion$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), AnonymousClass2.INSTANCE);
    }

    @NotNull
    public static final Modifier systemGestureExclusion(@NotNull Modifier modifier, @NotNull h9.l<? super LayoutCoordinates, Rect> exclusion) {
        t.i(modifier, "<this>");
        t.i(exclusion, "exclusion");
        if (Build.VERSION.SDK_INT < 30) {
            return modifier;
        }
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SystemGestureExclusionKt$systemGestureExclusion$$inlined$debugInspectorInfo$2(exclusion) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass4(exclusion));
    }
}
