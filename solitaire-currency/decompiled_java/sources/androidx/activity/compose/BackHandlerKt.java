package androidx.activity.compose;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.LifecycleOwner;
import h9.l;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: BackHandler.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BackHandlerKt {

    /* JADX INFO: renamed from: androidx.activity.compose.BackHandlerKt$BackHandler$2, reason: invalid class name */
    /* JADX INFO: compiled from: BackHandler.kt */
    static final class AnonymousClass2 extends v implements l<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ BackHandlerKt$BackHandler$backCallback$1$1 $backCallback;
        final /* synthetic */ OnBackPressedDispatcher $backDispatcher;
        final /* synthetic */ LifecycleOwner $lifecycleOwner;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(OnBackPressedDispatcher onBackPressedDispatcher, LifecycleOwner lifecycleOwner, BackHandlerKt$BackHandler$backCallback$1$1 backHandlerKt$BackHandler$backCallback$1$1) {
            super(1);
            this.$backDispatcher = onBackPressedDispatcher;
            this.$lifecycleOwner = lifecycleOwner;
            this.$backCallback = backHandlerKt$BackHandler$backCallback$1$1;
        }

        @Override // h9.l
        @NotNull
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
            this.$backDispatcher.addCallback(this.$lifecycleOwner, this.$backCallback);
            final BackHandlerKt$BackHandler$backCallback$1$1 backHandlerKt$BackHandler$backCallback$1$1 = this.$backCallback;
            return new DisposableEffectResult() { // from class: androidx.activity.compose.BackHandlerKt$BackHandler$2$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    remove();
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.activity.compose.BackHandlerKt$BackHandler$3, reason: invalid class name */
    /* JADX INFO: compiled from: BackHandler.kt */
    static final class AnonymousClass3 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ h9.a<k0> $onBack;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(boolean z10, h9.a<k0> aVar, int i10, int i11) {
            super(2);
            this.$enabled = z10;
            this.$onBack = aVar;
            this.$$changed = i10;
            this.$$default = i11;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            BackHandlerKt.BackHandler(this.$enabled, this.$onBack, composer, this.$$changed | 1, this.$$default);
        }
    }

    @Composable
    public static final void BackHandler(final boolean z10, @NotNull h9.a<k0> aVar, @Nullable Composer composer, int i10, int i11) {
        int i12;
        Composer composerStartRestartGroup = composer.startRestartGroup(-361453782);
        int i13 = i11 & 1;
        if (i13 != 0) {
            i12 = i10 | 6;
        } else if ((i10 & 14) == 0) {
            i12 = (composerStartRestartGroup.changed(z10) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i11 & 2) != 0) {
            i12 |= 48;
        } else if ((i10 & 112) == 0) {
            i12 |= composerStartRestartGroup.changed(aVar) ? 32 : 16;
        }
        if ((i12 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i13 != 0) {
                z10 = true;
            }
            final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(aVar, composerStartRestartGroup, (i12 >> 3) & 14);
            composerStartRestartGroup.startReplaceableGroup(-3687241);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = new OnBackPressedCallback(z10) { // from class: androidx.activity.compose.BackHandlerKt$BackHandler$backCallback$1$1
                    @Override // androidx.activity.OnBackPressedCallback
                    public void handleOnBackPressed() {
                        BackHandlerKt.BackHandler$lambda$0(stateRememberUpdatedState).invoke();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            BackHandlerKt$BackHandler$backCallback$1$1 backHandlerKt$BackHandler$backCallback$1$1 = (BackHandlerKt$BackHandler$backCallback$1$1) objRememberedValue;
            Boolean boolValueOf = Boolean.valueOf(z10);
            composerStartRestartGroup.startReplaceableGroup(-3686552);
            boolean zChanged = composerStartRestartGroup.changed(boolValueOf) | composerStartRestartGroup.changed(backHandlerKt$BackHandler$backCallback$1$1);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new BackHandlerKt$BackHandler$1$1(backHandlerKt$BackHandler$backCallback$1$1, z10);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.SideEffect((h9.a) objRememberedValue2, composerStartRestartGroup, 0);
            OnBackPressedDispatcherOwner current = LocalOnBackPressedDispatcherOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
            if (current == null) {
                throw new IllegalStateException("No OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner".toString());
            }
            OnBackPressedDispatcher onBackPressedDispatcher = current.getOnBackPressedDispatcher();
            LifecycleOwner lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
            EffectsKt.DisposableEffect(lifecycleOwner, onBackPressedDispatcher, new AnonymousClass2(onBackPressedDispatcher, lifecycleOwner, backHandlerKt$BackHandler$backCallback$1$1), composerStartRestartGroup, 72);
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(z10, aVar, i10, i11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h9.a<k0> BackHandler$lambda$0(State<? extends h9.a<k0>> state) {
        return state.getValue();
    }
}
