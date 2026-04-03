package androidx.compose.ui.semantics;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import h9.l;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SemanticsModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SemanticsModifierKt {

    /* JADX INFO: renamed from: androidx.compose.ui.semantics.SemanticsModifierKt$clearAndSetSemantics$2, reason: invalid class name */
    /* JADX INFO: compiled from: SemanticsModifier.kt */
    static final class AnonymousClass2 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ l<SemanticsPropertyReceiver, k0> $properties;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(l<? super SemanticsPropertyReceiver, k0> lVar) {
            super(3);
            this.$properties = lVar;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(1495908050);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = Integer.valueOf(SemanticsModifierCore.Companion.generateSemanticsId());
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            SemanticsModifierCore semanticsModifierCore = new SemanticsModifierCore(((Number) objRememberedValue).intValue(), false, true, this.$properties);
            composer.endReplaceableGroup();
            return semanticsModifierCore;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.semantics.SemanticsModifierKt$semantics$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SemanticsModifier.kt */
    static final class C10042 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ boolean $mergeDescendants;
        final /* synthetic */ l<SemanticsPropertyReceiver, k0> $properties;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C10042(boolean z10, l<? super SemanticsPropertyReceiver, k0> lVar) {
            super(3);
            this.$mergeDescendants = z10;
            this.$properties = lVar;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(-140499264);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = Integer.valueOf(SemanticsModifierCore.Companion.generateSemanticsId());
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            SemanticsModifierCore semanticsModifierCore = new SemanticsModifierCore(((Number) objRememberedValue).intValue(), this.$mergeDescendants, false, this.$properties);
            composer.endReplaceableGroup();
            return semanticsModifierCore;
        }
    }

    @NotNull
    public static final Modifier clearAndSetSemantics(@NotNull Modifier modifier, @NotNull l<? super SemanticsPropertyReceiver, k0> properties) {
        t.i(modifier, "<this>");
        t.i(properties, "properties");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SemanticsModifierKt$clearAndSetSemantics$$inlined$debugInspectorInfo$1(properties) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(properties));
    }

    @NotNull
    public static final Modifier semantics(@NotNull Modifier modifier, boolean z10, @NotNull l<? super SemanticsPropertyReceiver, k0> properties) {
        t.i(modifier, "<this>");
        t.i(properties, "properties");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SemanticsModifierKt$semantics$$inlined$debugInspectorInfo$1(z10, properties) : InspectableValueKt.getNoInspectorInfo(), new C10042(z10, properties));
    }

    public static /* synthetic */ Modifier semantics$default(Modifier modifier, boolean z10, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return semantics(modifier, z10, lVar);
    }
}
