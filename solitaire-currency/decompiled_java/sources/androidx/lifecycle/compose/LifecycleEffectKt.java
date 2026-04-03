package androidx.lifecycle.compose;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LifecycleEffectKt;
import h9.l;
import h9.p;
import java.util.Arrays;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.r0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: LifecycleEffect.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LifecycleEffectKt {

    /* JADX INFO: renamed from: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleEventEffect$1, reason: invalid class name */
    /* JADX INFO: compiled from: LifecycleEffect.kt */
    static final class AnonymousClass1 extends v implements l<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ State<h9.a<k0>> $currentOnEvent$delegate;
        final /* synthetic */ Lifecycle.Event $event;
        final /* synthetic */ LifecycleOwner $lifecycleOwner;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(LifecycleOwner lifecycleOwner, Lifecycle.Event event, State<? extends h9.a<k0>> state) {
            super(1);
            this.$lifecycleOwner = lifecycleOwner;
            this.$event = event;
            this.$currentOnEvent$delegate = state;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(Lifecycle.Event event, State state, LifecycleOwner lifecycleOwner, Lifecycle.Event event2) {
            if (event2 == event) {
                LifecycleEffectKt.LifecycleEventEffect$lambda$0(state).invoke();
            }
        }

        @Override // h9.l
        @NotNull
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
            final Lifecycle.Event event = this.$event;
            final State<h9.a<k0>> state = this.$currentOnEvent$delegate;
            final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.lifecycle.compose.a
                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event2) {
                    LifecycleEffectKt.AnonymousClass1.invoke$lambda$0(event, state, lifecycleOwner, event2);
                }
            };
            this.$lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
            final LifecycleOwner lifecycleOwner = this.$lifecycleOwner;
            return new DisposableEffectResult() { // from class: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleEventEffect$1$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    lifecycleOwner.getLifecycle().removeObserver(lifecycleEventObserver);
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleEventEffect$2, reason: invalid class name */
    /* JADX INFO: compiled from: LifecycleEffect.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ Lifecycle.Event $event;
        final /* synthetic */ LifecycleOwner $lifecycleOwner;
        final /* synthetic */ h9.a<k0> $onEvent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Lifecycle.Event event, LifecycleOwner lifecycleOwner, h9.a<k0> aVar, int i10, int i11) {
            super(2);
            this.$event = event;
            this.$lifecycleOwner = lifecycleOwner;
            this.$onEvent = aVar;
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
            LifecycleEffectKt.LifecycleEventEffect(this.$event, this.$lifecycleOwner, this.$onEvent, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleResumeEffect$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LifecycleEffect.kt */
    static final class C10491 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ l<LifecycleResumePauseEffectScope, LifecyclePauseOrDisposeEffectResult> $effects;
        final /* synthetic */ Object $key1;
        final /* synthetic */ LifecycleOwner $lifecycleOwner;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C10491(Object obj, LifecycleOwner lifecycleOwner, l<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> lVar, int i10, int i11) {
            super(2);
            this.$key1 = obj;
            this.$lifecycleOwner = lifecycleOwner;
            this.$effects = lVar;
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
            LifecycleEffectKt.LifecycleResumeEffect(this.$key1, this.$lifecycleOwner, this.$effects, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleResumeEffect$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LifecycleEffect.kt */
    static final class C10502 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ l<LifecycleResumePauseEffectScope, LifecyclePauseOrDisposeEffectResult> $effects;
        final /* synthetic */ Object $key1;
        final /* synthetic */ Object $key2;
        final /* synthetic */ LifecycleOwner $lifecycleOwner;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C10502(Object obj, Object obj2, LifecycleOwner lifecycleOwner, l<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> lVar, int i10, int i11) {
            super(2);
            this.$key1 = obj;
            this.$key2 = obj2;
            this.$lifecycleOwner = lifecycleOwner;
            this.$effects = lVar;
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
            LifecycleEffectKt.LifecycleResumeEffect(this.$key1, this.$key2, this.$lifecycleOwner, this.$effects, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleResumeEffect$3, reason: invalid class name */
    /* JADX INFO: compiled from: LifecycleEffect.kt */
    static final class AnonymousClass3 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ l<LifecycleResumePauseEffectScope, LifecyclePauseOrDisposeEffectResult> $effects;
        final /* synthetic */ Object $key1;
        final /* synthetic */ Object $key2;
        final /* synthetic */ Object $key3;
        final /* synthetic */ LifecycleOwner $lifecycleOwner;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(Object obj, Object obj2, Object obj3, LifecycleOwner lifecycleOwner, l<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> lVar, int i10, int i11) {
            super(2);
            this.$key1 = obj;
            this.$key2 = obj2;
            this.$key3 = obj3;
            this.$lifecycleOwner = lifecycleOwner;
            this.$effects = lVar;
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
            LifecycleEffectKt.LifecycleResumeEffect(this.$key1, this.$key2, this.$key3, this.$lifecycleOwner, this.$effects, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleResumeEffect$4, reason: invalid class name */
    /* JADX INFO: compiled from: LifecycleEffect.kt */
    static final class AnonymousClass4 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ l<LifecycleResumePauseEffectScope, LifecyclePauseOrDisposeEffectResult> $effects;
        final /* synthetic */ Object[] $keys;
        final /* synthetic */ LifecycleOwner $lifecycleOwner;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass4(Object[] objArr, LifecycleOwner lifecycleOwner, l<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> lVar, int i10, int i11) {
            super(2);
            this.$keys = objArr;
            this.$lifecycleOwner = lifecycleOwner;
            this.$effects = lVar;
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
            Object[] objArr = this.$keys;
            LifecycleEffectKt.LifecycleResumeEffect(Arrays.copyOf(objArr, objArr.length), this.$lifecycleOwner, (l<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult>) this.$effects, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleResumeEffectImpl$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LifecycleEffect.kt */
    static final class C10511 extends v implements l<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ l<LifecycleResumePauseEffectScope, LifecyclePauseOrDisposeEffectResult> $effects;
        final /* synthetic */ LifecycleOwner $lifecycleOwner;
        final /* synthetic */ LifecycleResumePauseEffectScope $scope;

        /* JADX INFO: renamed from: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleResumeEffectImpl$1$WhenMappings */
        /* JADX INFO: compiled from: LifecycleEffect.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Lifecycle.Event.values().length];
                try {
                    iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C10511(LifecycleOwner lifecycleOwner, LifecycleResumePauseEffectScope lifecycleResumePauseEffectScope, l<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> lVar) {
            super(1);
            this.$lifecycleOwner = lifecycleOwner;
            this.$scope = lifecycleResumePauseEffectScope;
            this.$effects = lVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
        public static final void invoke$lambda$1(LifecycleResumePauseEffectScope lifecycleResumePauseEffectScope, n0 n0Var, l lVar, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            LifecyclePauseOrDisposeEffectResult lifecyclePauseOrDisposeEffectResult;
            int i10 = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
            if (i10 == 1) {
                n0Var.f29834a = lVar.invoke(lifecycleResumePauseEffectScope);
            } else if (i10 == 2 && (lifecyclePauseOrDisposeEffectResult = (LifecyclePauseOrDisposeEffectResult) n0Var.f29834a) != null) {
                lifecyclePauseOrDisposeEffectResult.runPauseOrOnDisposeEffect();
            }
        }

        @Override // h9.l
        @NotNull
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
            final n0 n0Var = new n0();
            final LifecycleResumePauseEffectScope lifecycleResumePauseEffectScope = this.$scope;
            final l<LifecycleResumePauseEffectScope, LifecyclePauseOrDisposeEffectResult> lVar = this.$effects;
            final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.lifecycle.compose.b
                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    LifecycleEffectKt.C10511.invoke$lambda$1(lifecycleResumePauseEffectScope, n0Var, lVar, lifecycleOwner, event);
                }
            };
            this.$lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
            final LifecycleOwner lifecycleOwner = this.$lifecycleOwner;
            return new DisposableEffectResult() { // from class: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleResumeEffectImpl$1$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    lifecycleOwner.getLifecycle().removeObserver(lifecycleEventObserver);
                    LifecyclePauseOrDisposeEffectResult lifecyclePauseOrDisposeEffectResult = (LifecyclePauseOrDisposeEffectResult) n0Var.f29834a;
                    if (lifecyclePauseOrDisposeEffectResult != null) {
                        lifecyclePauseOrDisposeEffectResult.runPauseOrOnDisposeEffect();
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleResumeEffectImpl$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LifecycleEffect.kt */
    static final class C10522 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ l<LifecycleResumePauseEffectScope, LifecyclePauseOrDisposeEffectResult> $effects;
        final /* synthetic */ LifecycleOwner $lifecycleOwner;
        final /* synthetic */ LifecycleResumePauseEffectScope $scope;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C10522(LifecycleOwner lifecycleOwner, LifecycleResumePauseEffectScope lifecycleResumePauseEffectScope, l<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> lVar, int i10) {
            super(2);
            this.$lifecycleOwner = lifecycleOwner;
            this.$scope = lifecycleResumePauseEffectScope;
            this.$effects = lVar;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            LifecycleEffectKt.LifecycleResumeEffectImpl(this.$lifecycleOwner, this.$scope, this.$effects, composer, this.$$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleStartEffect$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LifecycleEffect.kt */
    static final class C10531 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ l<LifecycleStartStopEffectScope, LifecycleStopOrDisposeEffectResult> $effects;
        final /* synthetic */ Object $key1;
        final /* synthetic */ LifecycleOwner $lifecycleOwner;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C10531(Object obj, LifecycleOwner lifecycleOwner, l<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> lVar, int i10, int i11) {
            super(2);
            this.$key1 = obj;
            this.$lifecycleOwner = lifecycleOwner;
            this.$effects = lVar;
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
            LifecycleEffectKt.LifecycleStartEffect(this.$key1, this.$lifecycleOwner, this.$effects, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleStartEffect$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LifecycleEffect.kt */
    static final class C10542 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ l<LifecycleStartStopEffectScope, LifecycleStopOrDisposeEffectResult> $effects;
        final /* synthetic */ Object $key1;
        final /* synthetic */ Object $key2;
        final /* synthetic */ LifecycleOwner $lifecycleOwner;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C10542(Object obj, Object obj2, LifecycleOwner lifecycleOwner, l<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> lVar, int i10, int i11) {
            super(2);
            this.$key1 = obj;
            this.$key2 = obj2;
            this.$lifecycleOwner = lifecycleOwner;
            this.$effects = lVar;
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
            LifecycleEffectKt.LifecycleStartEffect(this.$key1, this.$key2, this.$lifecycleOwner, this.$effects, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleStartEffect$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LifecycleEffect.kt */
    static final class C10553 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ l<LifecycleStartStopEffectScope, LifecycleStopOrDisposeEffectResult> $effects;
        final /* synthetic */ Object $key1;
        final /* synthetic */ Object $key2;
        final /* synthetic */ Object $key3;
        final /* synthetic */ LifecycleOwner $lifecycleOwner;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C10553(Object obj, Object obj2, Object obj3, LifecycleOwner lifecycleOwner, l<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> lVar, int i10, int i11) {
            super(2);
            this.$key1 = obj;
            this.$key2 = obj2;
            this.$key3 = obj3;
            this.$lifecycleOwner = lifecycleOwner;
            this.$effects = lVar;
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
            LifecycleEffectKt.LifecycleStartEffect(this.$key1, this.$key2, this.$key3, this.$lifecycleOwner, this.$effects, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleStartEffect$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LifecycleEffect.kt */
    static final class C10564 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ l<LifecycleStartStopEffectScope, LifecycleStopOrDisposeEffectResult> $effects;
        final /* synthetic */ Object[] $keys;
        final /* synthetic */ LifecycleOwner $lifecycleOwner;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C10564(Object[] objArr, LifecycleOwner lifecycleOwner, l<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> lVar, int i10, int i11) {
            super(2);
            this.$keys = objArr;
            this.$lifecycleOwner = lifecycleOwner;
            this.$effects = lVar;
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
            Object[] objArr = this.$keys;
            LifecycleEffectKt.LifecycleStartEffect(Arrays.copyOf(objArr, objArr.length), this.$lifecycleOwner, (l<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult>) this.$effects, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleStartEffectImpl$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LifecycleEffect.kt */
    static final class C10571 extends v implements l<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ l<LifecycleStartStopEffectScope, LifecycleStopOrDisposeEffectResult> $effects;
        final /* synthetic */ LifecycleOwner $lifecycleOwner;
        final /* synthetic */ LifecycleStartStopEffectScope $scope;

        /* JADX INFO: renamed from: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleStartEffectImpl$1$WhenMappings */
        /* JADX INFO: compiled from: LifecycleEffect.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Lifecycle.Event.values().length];
                try {
                    iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Lifecycle.Event.ON_STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C10571(LifecycleOwner lifecycleOwner, LifecycleStartStopEffectScope lifecycleStartStopEffectScope, l<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> lVar) {
            super(1);
            this.$lifecycleOwner = lifecycleOwner;
            this.$scope = lifecycleStartStopEffectScope;
            this.$effects = lVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
        public static final void invoke$lambda$1(LifecycleStartStopEffectScope lifecycleStartStopEffectScope, n0 n0Var, l lVar, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            LifecycleStopOrDisposeEffectResult lifecycleStopOrDisposeEffectResult;
            int i10 = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
            if (i10 == 1) {
                n0Var.f29834a = lVar.invoke(lifecycleStartStopEffectScope);
            } else if (i10 == 2 && (lifecycleStopOrDisposeEffectResult = (LifecycleStopOrDisposeEffectResult) n0Var.f29834a) != null) {
                lifecycleStopOrDisposeEffectResult.runStopOrDisposeEffect();
            }
        }

        @Override // h9.l
        @NotNull
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
            final n0 n0Var = new n0();
            final LifecycleStartStopEffectScope lifecycleStartStopEffectScope = this.$scope;
            final l<LifecycleStartStopEffectScope, LifecycleStopOrDisposeEffectResult> lVar = this.$effects;
            final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.lifecycle.compose.c
                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    LifecycleEffectKt.C10571.invoke$lambda$1(lifecycleStartStopEffectScope, n0Var, lVar, lifecycleOwner, event);
                }
            };
            this.$lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
            final LifecycleOwner lifecycleOwner = this.$lifecycleOwner;
            return new DisposableEffectResult() { // from class: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleStartEffectImpl$1$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    lifecycleOwner.getLifecycle().removeObserver(lifecycleEventObserver);
                    LifecycleStopOrDisposeEffectResult lifecycleStopOrDisposeEffectResult = (LifecycleStopOrDisposeEffectResult) n0Var.f29834a;
                    if (lifecycleStopOrDisposeEffectResult != null) {
                        lifecycleStopOrDisposeEffectResult.runStopOrDisposeEffect();
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.compose.LifecycleEffectKt$LifecycleStartEffectImpl$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LifecycleEffect.kt */
    static final class C10582 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ l<LifecycleStartStopEffectScope, LifecycleStopOrDisposeEffectResult> $effects;
        final /* synthetic */ LifecycleOwner $lifecycleOwner;
        final /* synthetic */ LifecycleStartStopEffectScope $scope;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C10582(LifecycleOwner lifecycleOwner, LifecycleStartStopEffectScope lifecycleStartStopEffectScope, l<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> lVar, int i10) {
            super(2);
            this.$lifecycleOwner = lifecycleOwner;
            this.$scope = lifecycleStartStopEffectScope;
            this.$effects = lVar;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            LifecycleEffectKt.LifecycleStartEffectImpl(this.$lifecycleOwner, this.$scope, this.$effects, composer, this.$$changed | 1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a0  */
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LifecycleEventEffect(@org.jetbrains.annotations.NotNull androidx.lifecycle.Lifecycle.Event r8, @org.jetbrains.annotations.Nullable androidx.lifecycle.LifecycleOwner r9, @org.jetbrains.annotations.NotNull h9.a<v8.k0> r10, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r11, int r12, int r13) {
        /*
            r0 = -709389590(0xffffffffd5b792ea, float:-2.5230202E13)
            androidx.compose.runtime.Composer r11 = r11.startRestartGroup(r0)
            r0 = r13 & 1
            r1 = 2
            if (r0 == 0) goto Lf
            r0 = r12 | 6
            goto L1f
        Lf:
            r0 = r12 & 14
            if (r0 != 0) goto L1e
            boolean r0 = r11.changed(r8)
            if (r0 == 0) goto L1b
            r0 = 4
            goto L1c
        L1b:
            r0 = r1
        L1c:
            r0 = r0 | r12
            goto L1f
        L1e:
            r0 = r12
        L1f:
            r2 = r13 & 2
            if (r2 == 0) goto L25
            r0 = r0 | 16
        L25:
            r3 = r13 & 4
            if (r3 == 0) goto L2c
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L3c
        L2c:
            r3 = r12 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L3c
            boolean r3 = r11.changed(r10)
            if (r3 == 0) goto L39
            r3 = 256(0x100, float:3.59E-43)
            goto L3b
        L39:
            r3 = 128(0x80, float:1.8E-43)
        L3b:
            r0 = r0 | r3
        L3c:
            if (r2 != r1) goto L50
            r1 = r0 & 731(0x2db, float:1.024E-42)
            r3 = 146(0x92, float:2.05E-43)
            if (r1 != r3) goto L50
            boolean r1 = r11.getSkipping()
            if (r1 != 0) goto L4b
            goto L50
        L4b:
            r11.skipToGroupEnd()
        L4e:
            r4 = r9
            goto L8c
        L50:
            r11.startDefaults()
            r1 = r12 & 1
            if (r1 == 0) goto L64
            boolean r1 = r11.getDefaultsInvalid()
            if (r1 == 0) goto L5e
            goto L64
        L5e:
            r11.skipToGroupEnd()
            if (r2 == 0) goto L72
            goto L70
        L64:
            if (r2 == 0) goto L72
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalLifecycleOwner()
            java.lang.Object r9 = r11.consume(r9)
            androidx.lifecycle.LifecycleOwner r9 = (androidx.lifecycle.LifecycleOwner) r9
        L70:
            r0 = r0 & (-113(0xffffffffffffff8f, float:NaN))
        L72:
            r11.endDefaults()
            androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_DESTROY
            if (r8 == r1) goto La0
            int r0 = r0 >> 6
            r0 = r0 & 14
            androidx.compose.runtime.State r0 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r10, r11, r0)
            androidx.lifecycle.compose.LifecycleEffectKt$LifecycleEventEffect$1 r1 = new androidx.lifecycle.compose.LifecycleEffectKt$LifecycleEventEffect$1
            r1.<init>(r9, r8, r0)
            r0 = 8
            androidx.compose.runtime.EffectsKt.DisposableEffect(r9, r1, r11, r0)
            goto L4e
        L8c:
            androidx.compose.runtime.ScopeUpdateScope r9 = r11.endRestartGroup()
            if (r9 == 0) goto L9f
            androidx.lifecycle.compose.LifecycleEffectKt$LifecycleEventEffect$2 r11 = new androidx.lifecycle.compose.LifecycleEffectKt$LifecycleEventEffect$2
            r2 = r11
            r3 = r8
            r5 = r10
            r6 = r12
            r7 = r13
            r2.<init>(r3, r4, r5, r6, r7)
            r9.updateScope(r11)
        L9f:
            return
        La0:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "LifecycleEventEffect cannot be used to listen for Lifecycle.Event.ON_DESTROY, since Compose disposes of the composition before ON_DESTROY observers are invoked."
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleEventEffect(androidx.lifecycle.Lifecycle$Event, androidx.lifecycle.LifecycleOwner, h9.a, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h9.a<k0> LifecycleEventEffect$lambda$0(State<? extends h9.a<k0>> state) {
        return state.getValue();
    }

    @Composable
    public static final void LifecycleResumeEffect(@Nullable Object obj, @Nullable LifecycleOwner lifecycleOwner, @NotNull l<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> lVar, @Nullable Composer composer, int i10, int i11) {
        LifecycleOwner lifecycleOwner2;
        int i12;
        Composer composerStartRestartGroup = composer.startRestartGroup(1220373486);
        if ((i11 & 2) != 0) {
            i12 = i10 & (-113);
            lifecycleOwner2 = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
        } else {
            lifecycleOwner2 = lifecycleOwner;
            i12 = i10;
        }
        composerStartRestartGroup.startReplaceableGroup(-3686552);
        boolean zChanged = composerStartRestartGroup.changed(obj) | composerStartRestartGroup.changed(lifecycleOwner2);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new LifecycleResumePauseEffectScope(lifecycleOwner2.getLifecycle());
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        LifecycleResumeEffectImpl(lifecycleOwner2, (LifecycleResumePauseEffectScope) objRememberedValue, lVar, composerStartRestartGroup, (i12 & 896) | 72);
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C10491(obj, lifecycleOwner2, lVar, i10, i11));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final void LifecycleResumeEffectImpl(LifecycleOwner lifecycleOwner, LifecycleResumePauseEffectScope lifecycleResumePauseEffectScope, l<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> lVar, Composer composer, int i10) {
        Composer composerStartRestartGroup = composer.startRestartGroup(912823238);
        EffectsKt.DisposableEffect(lifecycleOwner, lifecycleResumePauseEffectScope, new C10511(lifecycleOwner, lifecycleResumePauseEffectScope, lVar), composerStartRestartGroup, 72);
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C10522(lifecycleOwner, lifecycleResumePauseEffectScope, lVar, i10));
        }
    }

    @Composable
    public static final void LifecycleStartEffect(@Nullable Object obj, @Nullable LifecycleOwner lifecycleOwner, @NotNull l<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> lVar, @Nullable Composer composer, int i10, int i11) {
        LifecycleOwner lifecycleOwner2;
        int i12;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1408314671);
        if ((i11 & 2) != 0) {
            i12 = i10 & (-113);
            lifecycleOwner2 = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
        } else {
            lifecycleOwner2 = lifecycleOwner;
            i12 = i10;
        }
        composerStartRestartGroup.startReplaceableGroup(-3686552);
        boolean zChanged = composerStartRestartGroup.changed(obj) | composerStartRestartGroup.changed(lifecycleOwner2);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new LifecycleStartStopEffectScope(lifecycleOwner2.getLifecycle());
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        LifecycleStartEffectImpl(lifecycleOwner2, (LifecycleStartStopEffectScope) objRememberedValue, lVar, composerStartRestartGroup, (i12 & 896) | 72);
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C10531(obj, lifecycleOwner2, lVar, i10, i11));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final void LifecycleStartEffectImpl(LifecycleOwner lifecycleOwner, LifecycleStartStopEffectScope lifecycleStartStopEffectScope, l<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> lVar, Composer composer, int i10) {
        Composer composerStartRestartGroup = composer.startRestartGroup(228371534);
        EffectsKt.DisposableEffect(lifecycleOwner, lifecycleStartStopEffectScope, new C10571(lifecycleOwner, lifecycleStartStopEffectScope, lVar), composerStartRestartGroup, 72);
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C10582(lifecycleOwner, lifecycleStartStopEffectScope, lVar, i10));
        }
    }

    @Composable
    public static final void LifecycleResumeEffect(@Nullable Object obj, @Nullable Object obj2, @Nullable LifecycleOwner lifecycleOwner, @NotNull l<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> lVar, @Nullable Composer composer, int i10, int i11) {
        LifecycleOwner lifecycleOwner2;
        int i12;
        Composer composerStartRestartGroup = composer.startRestartGroup(752680142);
        if ((i11 & 4) != 0) {
            i12 = i10 & (-897);
            lifecycleOwner2 = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
        } else {
            lifecycleOwner2 = lifecycleOwner;
            i12 = i10;
        }
        composerStartRestartGroup.startReplaceableGroup(-3686095);
        boolean zChanged = composerStartRestartGroup.changed(obj) | composerStartRestartGroup.changed(obj2) | composerStartRestartGroup.changed(lifecycleOwner2);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new LifecycleResumePauseEffectScope(lifecycleOwner2.getLifecycle());
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        LifecycleResumeEffectImpl(lifecycleOwner2, (LifecycleResumePauseEffectScope) objRememberedValue, lVar, composerStartRestartGroup, ((i12 >> 3) & 896) | 72);
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C10502(obj, obj2, lifecycleOwner2, lVar, i10, i11));
        }
    }

    @Composable
    public static final void LifecycleStartEffect(@Nullable Object obj, @Nullable Object obj2, @Nullable LifecycleOwner lifecycleOwner, @NotNull l<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> lVar, @Nullable Composer composer, int i10, int i11) {
        LifecycleOwner lifecycleOwner2;
        int i12;
        Composer composerStartRestartGroup = composer.startRestartGroup(696924721);
        if ((i11 & 4) != 0) {
            i12 = i10 & (-897);
            lifecycleOwner2 = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
        } else {
            lifecycleOwner2 = lifecycleOwner;
            i12 = i10;
        }
        composerStartRestartGroup.startReplaceableGroup(-3686095);
        boolean zChanged = composerStartRestartGroup.changed(obj) | composerStartRestartGroup.changed(obj2) | composerStartRestartGroup.changed(lifecycleOwner2);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new LifecycleStartStopEffectScope(lifecycleOwner2.getLifecycle());
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        LifecycleStartEffectImpl(lifecycleOwner2, (LifecycleStartStopEffectScope) objRememberedValue, lVar, composerStartRestartGroup, ((i12 >> 3) & 896) | 72);
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C10542(obj, obj2, lifecycleOwner2, lVar, i10, i11));
        }
    }

    @Composable
    public static final void LifecycleResumeEffect(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable LifecycleOwner lifecycleOwner, @NotNull l<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> lVar, @Nullable Composer composer, int i10, int i11) {
        LifecycleOwner lifecycleOwner2;
        int i12;
        Composer composerStartRestartGroup = composer.startRestartGroup(-485941842);
        if ((i11 & 8) != 0) {
            i12 = i10 & (-7169);
            lifecycleOwner2 = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
        } else {
            lifecycleOwner2 = lifecycleOwner;
            i12 = i10;
        }
        int i13 = 0;
        Object[] objArr = {obj, obj2, obj3, lifecycleOwner2};
        composerStartRestartGroup.startReplaceableGroup(-3685570);
        boolean zChanged = false;
        while (i13 < 4) {
            Object obj4 = objArr[i13];
            i13++;
            zChanged |= composerStartRestartGroup.changed(obj4);
        }
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new LifecycleResumePauseEffectScope(lifecycleOwner2.getLifecycle());
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        LifecycleResumeEffectImpl(lifecycleOwner2, (LifecycleResumePauseEffectScope) objRememberedValue, lVar, composerStartRestartGroup, ((i12 >> 6) & 896) | 72);
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(obj, obj2, obj3, lifecycleOwner2, lVar, i10, i11));
        }
    }

    @Composable
    public static final void LifecycleStartEffect(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable LifecycleOwner lifecycleOwner, @NotNull l<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> lVar, @Nullable Composer composer, int i10, int i11) {
        LifecycleOwner lifecycleOwner2;
        int i12;
        Composer composerStartRestartGroup = composer.startRestartGroup(574812561);
        if ((i11 & 8) != 0) {
            i12 = i10 & (-7169);
            lifecycleOwner2 = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
        } else {
            lifecycleOwner2 = lifecycleOwner;
            i12 = i10;
        }
        int i13 = 0;
        Object[] objArr = {obj, obj2, obj3, lifecycleOwner2};
        composerStartRestartGroup.startReplaceableGroup(-3685570);
        boolean zChanged = false;
        while (i13 < 4) {
            Object obj4 = objArr[i13];
            i13++;
            zChanged |= composerStartRestartGroup.changed(obj4);
        }
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new LifecycleStartStopEffectScope(lifecycleOwner2.getLifecycle());
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        LifecycleStartEffectImpl(lifecycleOwner2, (LifecycleStartStopEffectScope) objRememberedValue, lVar, composerStartRestartGroup, ((i12 >> 6) & 896) | 72);
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C10553(obj, obj2, obj3, lifecycleOwner2, lVar, i10, i11));
        }
    }

    @Composable
    public static final void LifecycleResumeEffect(@NotNull Object[] objArr, @Nullable LifecycleOwner lifecycleOwner, @NotNull l<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> lVar, @Nullable Composer composer, int i10, int i11) {
        LifecycleOwner lifecycleOwner2;
        int i12;
        Composer composerStartRestartGroup = composer.startRestartGroup(-781756895);
        if ((i11 & 2) != 0) {
            i12 = i10 & (-113);
            lifecycleOwner2 = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
        } else {
            lifecycleOwner2 = lifecycleOwner;
            i12 = i10;
        }
        r0 r0Var = new r0(2);
        r0Var.b(objArr);
        r0Var.a(lifecycleOwner2);
        Object[] objArrD = r0Var.d(new Object[r0Var.c()]);
        composerStartRestartGroup.startReplaceableGroup(-3685570);
        int length = objArrD.length;
        int i13 = 0;
        boolean zChanged = false;
        while (i13 < length) {
            Object obj = objArrD[i13];
            i13++;
            zChanged |= composerStartRestartGroup.changed(obj);
        }
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new LifecycleResumePauseEffectScope(lifecycleOwner2.getLifecycle());
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        LifecycleResumeEffectImpl(lifecycleOwner2, (LifecycleResumePauseEffectScope) objRememberedValue, lVar, composerStartRestartGroup, (i12 & 896) | 72);
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(objArr, lifecycleOwner2, lVar, i10, i11));
        }
    }

    @Composable
    public static final void LifecycleStartEffect(@NotNull Object[] objArr, @Nullable LifecycleOwner lifecycleOwner, @NotNull l<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> lVar, @Nullable Composer composer, int i10, int i11) {
        LifecycleOwner lifecycleOwner2;
        int i12;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1510305724);
        if ((i11 & 2) != 0) {
            i12 = i10 & (-113);
            lifecycleOwner2 = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
        } else {
            lifecycleOwner2 = lifecycleOwner;
            i12 = i10;
        }
        r0 r0Var = new r0(2);
        r0Var.b(objArr);
        r0Var.a(lifecycleOwner2);
        Object[] objArrD = r0Var.d(new Object[r0Var.c()]);
        composerStartRestartGroup.startReplaceableGroup(-3685570);
        int length = objArrD.length;
        int i13 = 0;
        boolean zChanged = false;
        while (i13 < length) {
            Object obj = objArrD[i13];
            i13++;
            zChanged |= composerStartRestartGroup.changed(obj);
        }
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new LifecycleStartStopEffectScope(lifecycleOwner2.getLifecycle());
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        LifecycleStartEffectImpl(lifecycleOwner2, (LifecycleStartStopEffectScope) objRememberedValue, lVar, composerStartRestartGroup, (i12 & 896) | 72);
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C10564(objArr, lifecycleOwner2, lVar, i10, i11));
        }
    }
}
