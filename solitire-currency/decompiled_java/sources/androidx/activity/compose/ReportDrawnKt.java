package androidx.activity.compose;

import androidx.activity.FullyDrawnReporter;
import androidx.activity.FullyDrawnReporterOwner;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: ReportDrawn.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ReportDrawnKt {

    /* JADX INFO: renamed from: androidx.activity.compose.ReportDrawnKt$ReportDrawn$1, reason: invalid class name */
    /* JADX INFO: compiled from: ReportDrawn.kt */
    static final class AnonymousClass1 extends v implements h9.a<Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final Boolean invoke() {
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: androidx.activity.compose.ReportDrawnKt$ReportDrawn$2, reason: invalid class name */
    /* JADX INFO: compiled from: ReportDrawn.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(int i10) {
            super(2);
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            ReportDrawnKt.ReportDrawn(composer, this.$$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.activity.compose.ReportDrawnKt$ReportDrawnAfter$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReportDrawn.kt */
    @f(c = "androidx.activity.compose.ReportDrawnKt$ReportDrawnAfter$1", f = "ReportDrawn.kt", l = {182}, m = "invokeSuspend")
    static final class C07701 extends l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ h9.l<d<? super k0>, Object> $block;
        final /* synthetic */ FullyDrawnReporter $fullyDrawnReporter;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C07701(FullyDrawnReporter fullyDrawnReporter, h9.l<? super d<? super k0>, ? extends Object> lVar, d<? super C07701> dVar) {
            super(2, dVar);
            this.$fullyDrawnReporter = fullyDrawnReporter;
            this.$block = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new C07701(this.$fullyDrawnReporter, this.$block, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            FullyDrawnReporter fullyDrawnReporter;
            Throwable th;
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                FullyDrawnReporter fullyDrawnReporter2 = this.$fullyDrawnReporter;
                h9.l<d<? super k0>, Object> lVar = this.$block;
                fullyDrawnReporter2.addReporter();
                if (!fullyDrawnReporter2.isFullyDrawnReported()) {
                    try {
                        this.L$0 = fullyDrawnReporter2;
                        this.label = 1;
                        if (lVar.invoke(this) == objE) {
                            return objE;
                        }
                        fullyDrawnReporter = fullyDrawnReporter2;
                        fullyDrawnReporter.removeReporter();
                    } catch (Throwable th2) {
                        fullyDrawnReporter = fullyDrawnReporter2;
                        th = th2;
                        fullyDrawnReporter.removeReporter();
                        throw th;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                fullyDrawnReporter = (FullyDrawnReporter) this.L$0;
                try {
                    u.b(obj);
                    fullyDrawnReporter.removeReporter();
                } catch (Throwable th3) {
                    th = th3;
                    fullyDrawnReporter.removeReporter();
                    throw th;
                }
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((C07701) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.activity.compose.ReportDrawnKt$ReportDrawnAfter$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReportDrawn.kt */
    static final class C07712 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ h9.l<d<? super k0>, Object> $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C07712(h9.l<? super d<? super k0>, ? extends Object> lVar, int i10) {
            super(2);
            this.$block = lVar;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            ReportDrawnKt.ReportDrawnAfter(this.$block, composer, this.$$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.activity.compose.ReportDrawnKt$ReportDrawnWhen$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReportDrawn.kt */
    static final class C07721 extends v implements h9.l<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ FullyDrawnReporter $fullyDrawnReporter;
        final /* synthetic */ h9.a<Boolean> $predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07721(FullyDrawnReporter fullyDrawnReporter, h9.a<Boolean> aVar) {
            super(1);
            this.$fullyDrawnReporter = fullyDrawnReporter;
            this.$predicate = aVar;
        }

        @Override // h9.l
        @NotNull
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
            if (this.$fullyDrawnReporter.isFullyDrawnReported()) {
                return new DisposableEffectResult() { // from class: androidx.activity.compose.ReportDrawnKt$ReportDrawnWhen$1$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                    }
                };
            }
            final ReportDrawnComposition reportDrawnComposition = new ReportDrawnComposition(this.$fullyDrawnReporter, this.$predicate);
            return new DisposableEffectResult() { // from class: androidx.activity.compose.ReportDrawnKt$ReportDrawnWhen$1$invoke$$inlined$onDispose$2
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    reportDrawnComposition.removeReporter();
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.activity.compose.ReportDrawnKt$ReportDrawnWhen$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReportDrawn.kt */
    static final class C07732 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ h9.a<Boolean> $predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07732(h9.a<Boolean> aVar, int i10) {
            super(2);
            this.$predicate = aVar;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            ReportDrawnKt.ReportDrawnWhen(this.$predicate, composer, this.$$changed | 1);
        }
    }

    @Composable
    public static final void ReportDrawn(@Nullable Composer composer, int i10) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1357012904);
        if (i10 == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            ReportDrawnWhen(AnonymousClass1.INSTANCE, composerStartRestartGroup, 6);
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(i10));
    }

    @Composable
    public static final void ReportDrawnAfter(@NotNull h9.l<? super d<? super k0>, ? extends Object> lVar, @Nullable Composer composer, int i10) {
        FullyDrawnReporter fullyDrawnReporter;
        Composer composerStartRestartGroup = composer.startRestartGroup(945311272);
        FullyDrawnReporterOwner current = LocalFullyDrawnReporterOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
        if (current == null || (fullyDrawnReporter = current.getFullyDrawnReporter()) == null) {
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ReportDrawnKt$ReportDrawnAfter$fullyDrawnReporter$1(lVar, i10));
            return;
        }
        EffectsKt.LaunchedEffect(lVar, fullyDrawnReporter, new C07701(fullyDrawnReporter, lVar, null), composerStartRestartGroup, 584);
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup2.updateScope(new C07712(lVar, i10));
    }

    @Composable
    public static final void ReportDrawnWhen(@NotNull h9.a<Boolean> aVar, @Nullable Composer composer, int i10) {
        int i11;
        FullyDrawnReporter fullyDrawnReporter;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2047119994);
        if ((i10 & 14) == 0) {
            i11 = (composerStartRestartGroup.changed(aVar) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i11 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            FullyDrawnReporterOwner current = LocalFullyDrawnReporterOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
            if (current == null || (fullyDrawnReporter = current.getFullyDrawnReporter()) == null) {
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ReportDrawnKt$ReportDrawnWhen$fullyDrawnReporter$1(aVar, i10));
                return;
            }
            EffectsKt.DisposableEffect(fullyDrawnReporter, aVar, new C07721(fullyDrawnReporter, aVar), composerStartRestartGroup, ((i11 << 3) & 112) | 8);
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup2.updateScope(new C07732(aVar, i10));
    }
}
