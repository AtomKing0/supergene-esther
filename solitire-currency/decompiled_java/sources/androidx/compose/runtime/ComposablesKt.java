package androidx.compose.runtime;

import androidx.exifinterface.media.ExifInterface;
import h9.l;
import h9.p;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.r;

/* JADX INFO: compiled from: Composables.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ComposablesKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.runtime.ComposablesKt$ComposeNode$1, reason: invalid class name */
    /* JADX INFO: compiled from: Composables.kt */
    public static final class AnonymousClass1<T> extends v implements h9.a<T> {
        final /* synthetic */ h9.a<T> $factory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(h9.a<? extends T> aVar) {
            super(0);
            this.$factory = aVar;
        }

        @Override // h9.a
        @NotNull
        public final T invoke() {
            return this.$factory.invoke();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.runtime.ComposablesKt$ReusableComposeNode$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Composables.kt */
    public static final class C09621<T> extends v implements h9.a<T> {
        final /* synthetic */ h9.a<T> $factory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C09621(h9.a<? extends T> aVar) {
            super(0);
            this.$factory = aVar;
        }

        @Override // h9.a
        @NotNull
        public final T invoke() {
            return this.$factory.invoke();
        }
    }

    @Composable
    public static final /* synthetic */ <T, E extends Applier<?>> void ComposeNode(h9.a<? extends T> factory, l<? super Updater<T>, k0> update, Composer composer, int i10) {
        t.i(factory, "factory");
        t.i(update, "update");
        composer.startReplaceableGroup(1886828752);
        Applier<?> applier = composer.getApplier();
        t.o(3, ExifInterface.LONGITUDE_EAST);
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startNode();
        if (composer.getInserting()) {
            composer.createNode(new AnonymousClass1(factory));
        } else {
            composer.useNode();
        }
        update.invoke(Updater.m1257boximpl(Updater.m1258constructorimpl(composer)));
        composer.endNode();
        composer.endReplaceableGroup();
    }

    @Composable
    public static final /* synthetic */ <T, E extends Applier<?>> void ReusableComposeNode(h9.a<? extends T> factory, l<? super Updater<T>, k0> update, Composer composer, int i10) {
        t.i(factory, "factory");
        t.i(update, "update");
        composer.startReplaceableGroup(1405779621);
        Applier<?> applier = composer.getApplier();
        t.o(3, ExifInterface.LONGITUDE_EAST);
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(new C09621(factory));
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        update.invoke(Updater.m1257boximpl(Updater.m1258constructorimpl(composer)));
        composer.enableReusing();
        composer.endNode();
        composer.endReplaceableGroup();
    }

    @Composable
    public static final void ReusableContent(@Nullable Object obj, @NotNull p<? super Composer, ? super Integer, k0> content, @Nullable Composer composer, int i10) {
        t.i(content, "content");
        composer.startReplaceableGroup(444418301);
        composer.startReusableGroup(207, obj);
        content.mo4invoke(composer, Integer.valueOf((i10 >> 3) & 14));
        composer.endReusableGroup();
        composer.endReplaceableGroup();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void ReusableContentHost(boolean z10, @NotNull p<? super Composer, ? super Integer, k0> content, @Nullable Composer composer, int i10) {
        t.i(content, "content");
        composer.startReusableGroup(207, Boolean.valueOf(z10));
        boolean zChanged = composer.changed(z10);
        if (z10) {
            content.mo4invoke(composer, Integer.valueOf((i10 >> 3) & 14));
        } else {
            composer.deactivateToEndGroup(zChanged);
        }
        composer.endReusableGroup();
    }

    @Composable
    @ReadOnlyComposable
    @NotNull
    public static final Composer getCurrentComposer(@Nullable Composer composer, int i10) {
        throw new r("Implemented as an intrinsic");
    }

    @Composable
    public static final int getCurrentCompositeKeyHash(@Nullable Composer composer, int i10) {
        return composer.getCompoundKeyHash();
    }

    @Composable
    @NotNull
    public static final CompositionLocalContext getCurrentCompositionLocalContext(@Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(-43352356);
        CompositionLocalContext compositionLocalContext = new CompositionLocalContext(composer.buildContext().getCompositionLocalScope$runtime_release());
        composer.endReplaceableGroup();
        return compositionLocalContext;
    }

    @Composable
    @ReadOnlyComposable
    @NotNull
    public static final RecomposeScope getCurrentRecomposeScope(@Nullable Composer composer, int i10) {
        RecomposeScope recomposeScope = composer.getRecomposeScope();
        if (recomposeScope == null) {
            throw new IllegalStateException("no recompose scope found".toString());
        }
        composer.recordUsed(recomposeScope);
        return recomposeScope;
    }

    public static final void invalidApplier() {
        throw new IllegalStateException("Invalid applier".toString());
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> T key(@NotNull Object[] keys, @NotNull p<? super Composer, ? super Integer, ? extends T> block, @Nullable Composer composer, int i10) {
        t.i(keys, "keys");
        t.i(block, "block");
        composer.startReplaceableGroup(-11941951);
        T tMo4invoke = block.mo4invoke(composer, Integer.valueOf((i10 >> 3) & 14));
        composer.endReplaceableGroup();
        return tMo4invoke;
    }

    @Composable
    public static final <T> T remember(@Nullable Object obj, @NotNull h9.a<? extends T> calculation, @Nullable Composer composer, int i10) {
        t.i(calculation, "calculation");
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(obj);
        T tInvoke = (T) composer.rememberedValue();
        if (zChanged || tInvoke == Composer.Companion.getEmpty()) {
            tInvoke = calculation.invoke();
            composer.updateRememberedValue(tInvoke);
        }
        composer.endReplaceableGroup();
        return tInvoke;
    }

    @Composable
    @NotNull
    public static final CompositionContext rememberCompositionContext(@Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(-1165786124);
        CompositionContext compositionContextBuildContext = composer.buildContext();
        composer.endReplaceableGroup();
        return compositionContextBuildContext;
    }

    @Composable
    public static final <T> T remember(@Nullable Object obj, @Nullable Object obj2, @NotNull h9.a<? extends T> calculation, @Nullable Composer composer, int i10) {
        t.i(calculation, "calculation");
        composer.startReplaceableGroup(511388516);
        boolean zChanged = composer.changed(obj) | composer.changed(obj2);
        T tInvoke = (T) composer.rememberedValue();
        if (zChanged || tInvoke == Composer.Companion.getEmpty()) {
            tInvoke = calculation.invoke();
            composer.updateRememberedValue(tInvoke);
        }
        composer.endReplaceableGroup();
        return tInvoke;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final /* synthetic */ <T, E extends Applier<?>> void ComposeNode(h9.a<? extends T> factory, l<? super Updater<T>, k0> update, p<? super Composer, ? super Integer, k0> content, Composer composer, int i10) {
        t.i(factory, "factory");
        t.i(update, "update");
        t.i(content, "content");
        composer.startReplaceableGroup(-548224868);
        Applier<?> applier = composer.getApplier();
        t.o(3, ExifInterface.LONGITUDE_EAST);
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startNode();
        if (composer.getInserting()) {
            composer.createNode(factory);
        } else {
            composer.useNode();
        }
        update.invoke(Updater.m1257boximpl(Updater.m1258constructorimpl(composer)));
        content.mo4invoke(composer, Integer.valueOf((i10 >> 6) & 14));
        composer.endNode();
        composer.endReplaceableGroup();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final /* synthetic */ <T, E extends Applier<?>> void ReusableComposeNode(h9.a<? extends T> factory, l<? super Updater<T>, k0> update, p<? super Composer, ? super Integer, k0> content, Composer composer, int i10) {
        t.i(factory, "factory");
        t.i(update, "update");
        t.i(content, "content");
        composer.startReplaceableGroup(-692256719);
        Applier<?> applier = composer.getApplier();
        t.o(3, ExifInterface.LONGITUDE_EAST);
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(factory);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        update.invoke(Updater.m1257boximpl(Updater.m1258constructorimpl(composer)));
        composer.enableReusing();
        content.mo4invoke(composer, Integer.valueOf((i10 >> 6) & 14));
        composer.endNode();
        composer.endReplaceableGroup();
    }

    @Composable
    public static final <T> T remember(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @NotNull h9.a<? extends T> calculation, @Nullable Composer composer, int i10) {
        t.i(calculation, "calculation");
        composer.startReplaceableGroup(1618982084);
        boolean zChanged = composer.changed(obj) | composer.changed(obj2) | composer.changed(obj3);
        T tInvoke = (T) composer.rememberedValue();
        if (zChanged || tInvoke == Composer.Companion.getEmpty()) {
            tInvoke = calculation.invoke();
            composer.updateRememberedValue(tInvoke);
        }
        composer.endReplaceableGroup();
        return tInvoke;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    public static final /* synthetic */ <T, E extends Applier<?>> void ComposeNode(h9.a<? extends T> factory, l<? super Updater<T>, k0> update, q<? super SkippableUpdater<T>, ? super Composer, ? super Integer, k0> skippableUpdate, p<? super Composer, ? super Integer, k0> content, Composer composer, int i10) {
        t.i(factory, "factory");
        t.i(update, "update");
        t.i(skippableUpdate, "skippableUpdate");
        t.i(content, "content");
        Applier<?> applier = composer.getApplier();
        t.o(3, ExifInterface.LONGITUDE_EAST);
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startNode();
        if (composer.getInserting()) {
            composer.createNode(factory);
        } else {
            composer.useNode();
        }
        update.invoke(Updater.m1257boximpl(Updater.m1258constructorimpl(composer)));
        skippableUpdate.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composer)), composer, Integer.valueOf((i10 >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        content.mo4invoke(composer, Integer.valueOf((i10 >> 9) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
    }

    public static /* synthetic */ void getCurrentCompositionLocalContext$annotations() {
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    public static final /* synthetic */ <T, E extends Applier<?>> void ReusableComposeNode(h9.a<? extends T> factory, l<? super Updater<T>, k0> update, q<? super SkippableUpdater<T>, ? super Composer, ? super Integer, k0> skippableUpdate, p<? super Composer, ? super Integer, k0> content, Composer composer, int i10) {
        t.i(factory, "factory");
        t.i(update, "update");
        t.i(skippableUpdate, "skippableUpdate");
        t.i(content, "content");
        Applier<?> applier = composer.getApplier();
        t.o(3, ExifInterface.LONGITUDE_EAST);
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(factory);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        update.invoke(Updater.m1257boximpl(Updater.m1258constructorimpl(composer)));
        composer.enableReusing();
        skippableUpdate.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composer)), composer, Integer.valueOf((i10 >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        content.mo4invoke(composer, Integer.valueOf((i10 >> 9) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
    }

    @Composable
    public static final <T> T remember(@NotNull Object[] keys, @NotNull h9.a<? extends T> calculation, @Nullable Composer composer, int i10) {
        t.i(keys, "keys");
        t.i(calculation, "calculation");
        composer.startReplaceableGroup(-568225417);
        boolean zChanged = false;
        for (Object obj : keys) {
            zChanged |= composer.changed(obj);
        }
        T tInvoke = (T) composer.rememberedValue();
        if (zChanged || tInvoke == Composer.Companion.getEmpty()) {
            tInvoke = calculation.invoke();
            composer.updateRememberedValue(tInvoke);
        }
        composer.endReplaceableGroup();
        return tInvoke;
    }

    @Composable
    public static final <T> T remember(@NotNull h9.a<? extends T> calculation, @Nullable Composer composer, int i10) {
        t.i(calculation, "calculation");
        composer.startReplaceableGroup(-492369756);
        T tInvoke = (T) composer.rememberedValue();
        if (tInvoke == Composer.Companion.getEmpty()) {
            tInvoke = calculation.invoke();
            composer.updateRememberedValue(tInvoke);
        }
        composer.endReplaceableGroup();
        return tInvoke;
    }
}
