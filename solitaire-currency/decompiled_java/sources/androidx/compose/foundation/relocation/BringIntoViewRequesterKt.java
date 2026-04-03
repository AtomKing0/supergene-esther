package androidx.compose.foundation.relocation;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import h9.l;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BringIntoViewRequester.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BringIntoViewRequesterKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.relocation.BringIntoViewRequesterKt$bringIntoViewRequester$2, reason: invalid class name */
    /* JADX INFO: compiled from: BringIntoViewRequester.kt */
    static final class AnonymousClass2 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;

        /* JADX INFO: renamed from: androidx.compose.foundation.relocation.BringIntoViewRequesterKt$bringIntoViewRequester$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: BringIntoViewRequester.kt */
        static final class AnonymousClass1 extends v implements l<DisposableEffectScope, DisposableEffectResult> {
            final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
            final /* synthetic */ BringIntoViewRequesterModifier $modifier;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(BringIntoViewRequester bringIntoViewRequester, BringIntoViewRequesterModifier bringIntoViewRequesterModifier) {
                super(1);
                this.$bringIntoViewRequester = bringIntoViewRequester;
                this.$modifier = bringIntoViewRequesterModifier;
            }

            @Override // h9.l
            @NotNull
            public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
                t.i(DisposableEffect, "$this$DisposableEffect");
                ((BringIntoViewRequesterImpl) this.$bringIntoViewRequester).getModifiers().add(this.$modifier);
                final BringIntoViewRequester bringIntoViewRequester = this.$bringIntoViewRequester;
                final BringIntoViewRequesterModifier bringIntoViewRequesterModifier = this.$modifier;
                return new DisposableEffectResult() { // from class: androidx.compose.foundation.relocation.BringIntoViewRequesterKt$bringIntoViewRequester$2$1$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        ((BringIntoViewRequesterImpl) bringIntoViewRequester).getModifiers().remove(bringIntoViewRequesterModifier);
                    }
                };
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(BringIntoViewRequester bringIntoViewRequester) {
            super(3);
            this.$bringIntoViewRequester = bringIntoViewRequester;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(-992853993);
            BringIntoViewParent bringIntoViewParentRememberDefaultBringIntoViewParent = BringIntoViewResponder_androidKt.rememberDefaultBringIntoViewParent(composer, 0);
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(bringIntoViewParentRememberDefaultBringIntoViewParent);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new BringIntoViewRequesterModifier(bringIntoViewParentRememberDefaultBringIntoViewParent);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            BringIntoViewRequesterModifier bringIntoViewRequesterModifier = (BringIntoViewRequesterModifier) objRememberedValue;
            BringIntoViewRequester bringIntoViewRequester = this.$bringIntoViewRequester;
            if (bringIntoViewRequester instanceof BringIntoViewRequesterImpl) {
                EffectsKt.DisposableEffect(bringIntoViewRequester, new AnonymousClass1(bringIntoViewRequester, bringIntoViewRequesterModifier), composer, 0);
            }
            composer.endReplaceableGroup();
            return bringIntoViewRequesterModifier;
        }
    }

    @ExperimentalFoundationApi
    @NotNull
    public static final BringIntoViewRequester BringIntoViewRequester() {
        return new BringIntoViewRequesterImpl();
    }

    @ExperimentalFoundationApi
    @NotNull
    public static final Modifier bringIntoViewRequester(@NotNull Modifier modifier, @NotNull BringIntoViewRequester bringIntoViewRequester) {
        t.i(modifier, "<this>");
        t.i(bringIntoViewRequester, "bringIntoViewRequester");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new BringIntoViewRequesterKt$bringIntoViewRequester$$inlined$debugInspectorInfo$1(bringIntoViewRequester) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(bringIntoViewRequester));
    }
}
