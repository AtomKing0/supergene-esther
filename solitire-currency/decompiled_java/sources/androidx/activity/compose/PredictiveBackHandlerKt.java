package androidx.activity.compose;

import androidx.activity.BackEventCompat;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.LifecycleOwner;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.h;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: PredictiveBackHandler.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PredictiveBackHandlerKt {

    /* JADX INFO: renamed from: androidx.activity.compose.PredictiveBackHandlerKt$PredictiveBackHandler$1, reason: invalid class name */
    /* JADX INFO: compiled from: PredictiveBackHandler.kt */
    @f(c = "androidx.activity.compose.PredictiveBackHandlerKt$PredictiveBackHandler$1", f = "PredictiveBackHandler.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1 $backCallBack;
        final /* synthetic */ boolean $enabled;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1 predictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1, boolean z10, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$backCallBack = predictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1;
            this.$enabled = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new AnonymousClass1(this.$backCallBack, this.$enabled, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            setEnabled(this.$enabled);
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.activity.compose.PredictiveBackHandlerKt$PredictiveBackHandler$2, reason: invalid class name */
    /* JADX INFO: compiled from: PredictiveBackHandler.kt */
    static final class AnonymousClass2 extends v implements h9.l<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1 $backCallBack;
        final /* synthetic */ OnBackPressedDispatcher $backDispatcher;
        final /* synthetic */ LifecycleOwner $lifecycleOwner;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(OnBackPressedDispatcher onBackPressedDispatcher, LifecycleOwner lifecycleOwner, PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1 predictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1) {
            super(1);
            this.$backDispatcher = onBackPressedDispatcher;
            this.$lifecycleOwner = lifecycleOwner;
            this.$backCallBack = predictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1;
        }

        @Override // h9.l
        @NotNull
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
            this.$backDispatcher.addCallback(this.$lifecycleOwner, this.$backCallBack);
            final PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1 predictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1 = this.$backCallBack;
            return new DisposableEffectResult() { // from class: androidx.activity.compose.PredictiveBackHandlerKt$PredictiveBackHandler$2$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    remove();
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.activity.compose.PredictiveBackHandlerKt$PredictiveBackHandler$3, reason: invalid class name */
    /* JADX INFO: compiled from: PredictiveBackHandler.kt */
    static final class AnonymousClass3 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ p<h<BackEventCompat>, d<k0>, Object> $onBack;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(boolean z10, p<h<BackEventCompat>, ? super d<k0>, ? extends Object> pVar, int i10, int i11) {
            super(2);
            this.$enabled = z10;
            this.$onBack = pVar;
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
            PredictiveBackHandlerKt.PredictiveBackHandler(this.$enabled, this.$onBack, composer, this.$$changed | 1, this.$$default);
        }
    }

    @Composable
    public static final void PredictiveBackHandler(final boolean z10, @NotNull p<h<BackEventCompat>, ? super d<k0>, ? extends Object> pVar, @Nullable Composer composer, int i10, int i11) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-642000585);
        if ((i11 & 1) != 0) {
            z10 = true;
        }
        final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(pVar, composerStartRestartGroup, 8);
        composerStartRestartGroup.startReplaceableGroup(-723524056);
        composerStartRestartGroup.startReplaceableGroup(-3687241);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (objRememberedValue == companion.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(z8.h.f37608a, composerStartRestartGroup));
            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            objRememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        composerStartRestartGroup.endReplaceableGroup();
        final o0 coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.startReplaceableGroup(-3687241);
        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
        if (objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new OnBackPressedCallback(z10) { // from class: androidx.activity.compose.PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1

                @Nullable
                private OnBackInstance onBackInstance;

                @Nullable
                public final OnBackInstance getOnBackInstance() {
                    return this.onBackInstance;
                }

                @Override // androidx.activity.OnBackPressedCallback
                public void handleOnBackCancelled() {
                    super.handleOnBackCancelled();
                    OnBackInstance onBackInstance = this.onBackInstance;
                    if (onBackInstance != null) {
                        onBackInstance.cancel();
                    }
                }

                @Override // androidx.activity.OnBackPressedCallback
                public void handleOnBackPressed() {
                    OnBackInstance onBackInstance = this.onBackInstance;
                    if (onBackInstance != null && !onBackInstance.isPredictiveBack()) {
                        onBackInstance.cancel();
                        this.onBackInstance = null;
                    }
                    if (this.onBackInstance == null) {
                        this.onBackInstance = new OnBackInstance(coroutineScope, false, PredictiveBackHandlerKt.PredictiveBackHandler$lambda$0(stateRememberUpdatedState));
                    }
                    OnBackInstance onBackInstance2 = this.onBackInstance;
                    if (onBackInstance2 != null) {
                        onBackInstance2.close();
                    }
                }

                @Override // androidx.activity.OnBackPressedCallback
                public void handleOnBackProgressed(@NotNull BackEventCompat backEventCompat) {
                    super.handleOnBackProgressed(backEventCompat);
                    OnBackInstance onBackInstance = this.onBackInstance;
                    if (onBackInstance != null) {
                        r9.h.b(onBackInstance.m2sendJP2dKIU(backEventCompat));
                    }
                }

                @Override // androidx.activity.OnBackPressedCallback
                public void handleOnBackStarted(@NotNull BackEventCompat backEventCompat) {
                    super.handleOnBackStarted(backEventCompat);
                    OnBackInstance onBackInstance = this.onBackInstance;
                    if (onBackInstance != null) {
                        onBackInstance.cancel();
                    }
                    this.onBackInstance = new OnBackInstance(coroutineScope, true, PredictiveBackHandlerKt.PredictiveBackHandler$lambda$0(stateRememberUpdatedState));
                }

                public final void setOnBackInstance(@Nullable OnBackInstance onBackInstance) {
                    this.onBackInstance = onBackInstance;
                }
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
        }
        composerStartRestartGroup.endReplaceableGroup();
        PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1 predictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1 = (PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1) objRememberedValue2;
        EffectsKt.LaunchedEffect(Boolean.valueOf(z10), new AnonymousClass1(predictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1, z10, null), composerStartRestartGroup, (i10 & 14) | 64);
        OnBackPressedDispatcherOwner current = LocalOnBackPressedDispatcherOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
        if (current == null) {
            throw new IllegalStateException("No OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner".toString());
        }
        OnBackPressedDispatcher onBackPressedDispatcher = current.getOnBackPressedDispatcher();
        LifecycleOwner lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
        EffectsKt.DisposableEffect(lifecycleOwner, onBackPressedDispatcher, new AnonymousClass2(onBackPressedDispatcher, lifecycleOwner, predictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1), composerStartRestartGroup, 72);
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(z10, pVar, i10, i11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final p<h<BackEventCompat>, d<k0>, Object> PredictiveBackHandler$lambda$0(State<? extends p<h<BackEventCompat>, ? super d<k0>, ? extends Object>> state) {
        return (p) state.getValue();
    }
}
