package androidx.compose.runtime;

import h9.l;
import h9.p;
import java.util.Arrays;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.f2;
import kotlinx.coroutines.h2;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.g;
import z8.h;

/* JADX INFO: compiled from: Effects.kt */
/* JADX INFO: loaded from: classes.dex */
public final class EffectsKt {

    @NotNull
    private static final String DisposableEffectNoParamError = "DisposableEffect must provide one or more 'key' parameters that define the identity of the DisposableEffect and determine when its previous effect should be disposed and a new effect started for the new key.";

    @NotNull
    private static final DisposableEffectScope InternalDisposableEffectScope = new DisposableEffectScope();

    @NotNull
    private static final String LaunchedEffectNoParamError = "LaunchedEffect must provide one or more 'key' parameters that define the identity of the LaunchedEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.";

    /* JADX INFO: renamed from: androidx.compose.runtime.EffectsKt$LaunchedEffect$1, reason: invalid class name */
    /* JADX INFO: compiled from: Effects.kt */
    static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ p<o0, z8.d<? super k0>, Object> $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(p<? super o0, ? super z8.d<? super k0>, ? extends Object> pVar, int i10) {
            super(2);
            this.$block = pVar;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            EffectsKt.LaunchedEffect(this.$block, composer, this.$$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.EffectsKt$rememberCoroutineScope$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Effects.kt */
    public static final class C09771 extends v implements h9.a<h> {
        public static final C09771 INSTANCE = new C09771();

        public C09771() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final h invoke() {
            return h.f37608a;
        }
    }

    @Composable
    public static final void DisposableEffect(@NotNull l<? super DisposableEffectScope, ? extends DisposableEffectResult> effect, @Nullable Composer composer, int i10) {
        t.i(effect, "effect");
        composer.startReplaceableGroup(-904483903);
        throw new IllegalStateException(DisposableEffectNoParamError.toString());
    }

    @Composable
    public static final void LaunchedEffect(@NotNull p<? super o0, ? super z8.d<? super k0>, ? extends Object> block, @Nullable Composer composer, int i10) {
        t.i(block, "block");
        Composer composerStartRestartGroup = composer.startRestartGroup(-805415771);
        if ((i10 & 1) != 0 || !composerStartRestartGroup.getSkipping()) {
            throw new IllegalStateException(LaunchedEffectNoParamError.toString());
        }
        composerStartRestartGroup.skipToGroupEnd();
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(block, i10));
    }

    @Composable
    public static final void SideEffect(@NotNull h9.a<k0> effect, @Nullable Composer composer, int i10) {
        t.i(effect, "effect");
        composer.startReplaceableGroup(-1288466761);
        composer.recordSideEffect(effect);
        composer.endReplaceableGroup();
    }

    @NotNull
    public static final o0 createCompositionCoroutineScope(@NotNull g coroutineContext, @NotNull Composer composer) {
        t.i(coroutineContext, "coroutineContext");
        t.i(composer, "composer");
        b2.b bVar = b2.O7;
        if (coroutineContext.get(bVar) == null) {
            g applyCoroutineContext = composer.getApplyCoroutineContext();
            return p0.a(applyCoroutineContext.plus(f2.a((b2) applyCoroutineContext.get(bVar))).plus(coroutineContext));
        }
        a0 a0VarB = h2.b(null, 1, null);
        a0VarB.c(new IllegalArgumentException("CoroutineContext supplied to rememberCoroutineScope may not include a parent job"));
        return p0.a(a0VarB);
    }

    @Composable
    @NotNull
    public static final o0 rememberCoroutineScope(@Nullable h9.a<? extends g> aVar, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(773894976);
        if ((i11 & 1) != 0) {
            aVar = C09771.INSTANCE;
        }
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new CompositionScopedCoroutineScopeCanceller(createCompositionCoroutineScope(aVar.invoke(), composer));
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        o0 coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
        composer.endReplaceableGroup();
        return coroutineScope;
    }

    @Composable
    public static final void DisposableEffect(@Nullable Object obj, @NotNull l<? super DisposableEffectScope, ? extends DisposableEffectResult> effect, @Nullable Composer composer, int i10) {
        t.i(effect, "effect");
        composer.startReplaceableGroup(-1371986847);
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(obj);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            composer.updateRememberedValue(new DisposableEffectImpl(effect));
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    @Composable
    public static final void LaunchedEffect(@Nullable Object obj, @NotNull p<? super o0, ? super z8.d<? super k0>, ? extends Object> block, @Nullable Composer composer, int i10) {
        t.i(block, "block");
        composer.startReplaceableGroup(1179185413);
        g applyCoroutineContext = composer.getApplyCoroutineContext();
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(obj);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            composer.updateRememberedValue(new LaunchedEffectImpl(applyCoroutineContext, block));
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    @Composable
    public static final void DisposableEffect(@Nullable Object obj, @Nullable Object obj2, @NotNull l<? super DisposableEffectScope, ? extends DisposableEffectResult> effect, @Nullable Composer composer, int i10) {
        t.i(effect, "effect");
        composer.startReplaceableGroup(1429097729);
        composer.startReplaceableGroup(511388516);
        boolean zChanged = composer.changed(obj) | composer.changed(obj2);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            composer.updateRememberedValue(new DisposableEffectImpl(effect));
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    @Composable
    public static final void LaunchedEffect(@Nullable Object obj, @Nullable Object obj2, @NotNull p<? super o0, ? super z8.d<? super k0>, ? extends Object> block, @Nullable Composer composer, int i10) {
        t.i(block, "block");
        composer.startReplaceableGroup(590241125);
        g applyCoroutineContext = composer.getApplyCoroutineContext();
        composer.startReplaceableGroup(511388516);
        boolean zChanged = composer.changed(obj) | composer.changed(obj2);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            composer.updateRememberedValue(new LaunchedEffectImpl(applyCoroutineContext, block));
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    @Composable
    public static final void DisposableEffect(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @NotNull l<? super DisposableEffectScope, ? extends DisposableEffectResult> effect, @Nullable Composer composer, int i10) {
        t.i(effect, "effect");
        composer.startReplaceableGroup(-1239538271);
        composer.startReplaceableGroup(1618982084);
        boolean zChanged = composer.changed(obj) | composer.changed(obj2) | composer.changed(obj3);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            composer.updateRememberedValue(new DisposableEffectImpl(effect));
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    @Composable
    public static final void LaunchedEffect(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @NotNull p<? super o0, ? super z8.d<? super k0>, ? extends Object> block, @Nullable Composer composer, int i10) {
        t.i(block, "block");
        composer.startReplaceableGroup(-54093371);
        g applyCoroutineContext = composer.getApplyCoroutineContext();
        composer.startReplaceableGroup(1618982084);
        boolean zChanged = composer.changed(obj) | composer.changed(obj2) | composer.changed(obj3);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            composer.updateRememberedValue(new LaunchedEffectImpl(applyCoroutineContext, block));
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    @Composable
    public static final void DisposableEffect(@NotNull Object[] keys, @NotNull l<? super DisposableEffectScope, ? extends DisposableEffectResult> effect, @Nullable Composer composer, int i10) {
        t.i(keys, "keys");
        t.i(effect, "effect");
        composer.startReplaceableGroup(-1307627122);
        Object[] objArrCopyOf = Arrays.copyOf(keys, keys.length);
        composer.startReplaceableGroup(-568225417);
        boolean zChanged = false;
        for (Object obj : objArrCopyOf) {
            zChanged |= composer.changed(obj);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            composer.updateRememberedValue(new DisposableEffectImpl(effect));
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    @Composable
    public static final void LaunchedEffect(@NotNull Object[] keys, @NotNull p<? super o0, ? super z8.d<? super k0>, ? extends Object> block, @Nullable Composer composer, int i10) {
        t.i(keys, "keys");
        t.i(block, "block");
        composer.startReplaceableGroup(-139560008);
        g applyCoroutineContext = composer.getApplyCoroutineContext();
        Object[] objArrCopyOf = Arrays.copyOf(keys, keys.length);
        composer.startReplaceableGroup(-568225417);
        boolean zChanged = false;
        for (Object obj : objArrCopyOf) {
            zChanged |= composer.changed(obj);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            composer.updateRememberedValue(new LaunchedEffectImpl(applyCoroutineContext, block));
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }
}
