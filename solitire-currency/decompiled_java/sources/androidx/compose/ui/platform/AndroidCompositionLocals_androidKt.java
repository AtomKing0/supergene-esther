package androidx.compose.ui.platform;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.res.ImageVectorCache;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidCompositionLocals.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidCompositionLocals_androidKt {

    @NotNull
    private static final ProvidableCompositionLocal<Configuration> LocalConfiguration = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.neverEqualPolicy(), AndroidCompositionLocals_androidKt$LocalConfiguration$1.INSTANCE);

    @NotNull
    private static final ProvidableCompositionLocal<Context> LocalContext = CompositionLocalKt.staticCompositionLocalOf(AndroidCompositionLocals_androidKt$LocalContext$1.INSTANCE);

    @NotNull
    private static final ProvidableCompositionLocal<ImageVectorCache> LocalImageVectorCache = CompositionLocalKt.staticCompositionLocalOf(AndroidCompositionLocals_androidKt$LocalImageVectorCache$1.INSTANCE);

    @NotNull
    private static final ProvidableCompositionLocal<LifecycleOwner> LocalLifecycleOwner = CompositionLocalKt.staticCompositionLocalOf(AndroidCompositionLocals_androidKt$LocalLifecycleOwner$1.INSTANCE);

    @NotNull
    private static final ProvidableCompositionLocal<SavedStateRegistryOwner> LocalSavedStateRegistryOwner = CompositionLocalKt.staticCompositionLocalOf(AndroidCompositionLocals_androidKt$LocalSavedStateRegistryOwner$1.INSTANCE);

    @NotNull
    private static final ProvidableCompositionLocal<View> LocalView = CompositionLocalKt.staticCompositionLocalOf(AndroidCompositionLocals_androidKt$LocalView$1.INSTANCE);

    /* JADX INFO: renamed from: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$2, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidCompositionLocals.android.kt */
    static final class AnonymousClass2 extends kotlin.jvm.internal.v implements h9.l<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ DisposableSaveableStateRegistry $saveableStateRegistry;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DisposableSaveableStateRegistry disposableSaveableStateRegistry) {
            super(1);
            this.$saveableStateRegistry = disposableSaveableStateRegistry;
        }

        @Override // h9.l
        @NotNull
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
            kotlin.jvm.internal.t.i(DisposableEffect, "$this$DisposableEffect");
            final DisposableSaveableStateRegistry disposableSaveableStateRegistry = this.$saveableStateRegistry;
            return new DisposableEffectResult() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$2$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    disposableSaveableStateRegistry.dispose();
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$3, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidCompositionLocals.android.kt */
    static final class AnonymousClass3 extends kotlin.jvm.internal.v implements h9.p<Composer, Integer, v8.k0> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ h9.p<Composer, Integer, v8.k0> $content;
        final /* synthetic */ AndroidComposeView $owner;
        final /* synthetic */ AndroidUriHandler $uriHandler;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(AndroidComposeView androidComposeView, AndroidUriHandler androidUriHandler, h9.p<? super Composer, ? super Integer, v8.k0> pVar, int i10) {
            super(2);
            this.$owner = androidComposeView;
            this.$uriHandler = androidUriHandler;
            this.$content = pVar;
            this.$$dirty = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ v8.k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return v8.k0.f35197a;
        }

        @Composable
        public final void invoke(@Nullable Composer composer, int i10) {
            if ((i10 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                CompositionLocalsKt.ProvideCommonCompositionLocals(this.$owner, this.$uriHandler, this.$content, composer, ((this.$$dirty << 3) & 896) | 72);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$4, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidCompositionLocals.android.kt */
    static final class AnonymousClass4 extends kotlin.jvm.internal.v implements h9.p<Composer, Integer, v8.k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ h9.p<Composer, Integer, v8.k0> $content;
        final /* synthetic */ AndroidComposeView $owner;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass4(AndroidComposeView androidComposeView, h9.p<? super Composer, ? super Integer, v8.k0> pVar, int i10) {
            super(2);
            this.$owner = androidComposeView;
            this.$content = pVar;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ v8.k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return v8.k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            AndroidCompositionLocals_androidKt.ProvideAndroidCompositionLocals(this.$owner, this.$content, composer, this.$$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$obtainImageVectorCache$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidCompositionLocals.android.kt */
    static final class AnonymousClass1 extends kotlin.jvm.internal.v implements h9.l<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1 $callbacks;
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1 androidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1) {
            super(1);
            this.$context = context;
            this.$callbacks = androidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1;
        }

        @Override // h9.l
        @NotNull
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
            kotlin.jvm.internal.t.i(DisposableEffect, "$this$DisposableEffect");
            this.$context.getApplicationContext().registerComponentCallbacks(this.$callbacks);
            final Context context = this.$context;
            final AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1 androidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1 = this.$callbacks;
            return new DisposableEffectResult() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$obtainImageVectorCache$1$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    context.getApplicationContext().unregisterComponentCallbacks(androidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1);
                }
            };
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void ProvideAndroidCompositionLocals(@NotNull AndroidComposeView owner, @NotNull h9.p<? super Composer, ? super Integer, v8.k0> content, @Nullable Composer composer, int i10) {
        kotlin.jvm.internal.t.i(owner, "owner");
        kotlin.jvm.internal.t.i(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1396852028);
        Context context = owner.getContext();
        composerStartRestartGroup.startReplaceableGroup(-492369756);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt.mutableStateOf(context.getResources().getConfiguration(), SnapshotStateKt.neverEqualPolicy());
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        MutableState mutableState = (MutableState) objRememberedValue;
        composerStartRestartGroup.startReplaceableGroup(1157296644);
        boolean zChanged = composerStartRestartGroup.changed(mutableState);
        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$1$1(mutableState);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
        }
        composerStartRestartGroup.endReplaceableGroup();
        owner.setConfigurationChangeObserver((h9.l) objRememberedValue2);
        composerStartRestartGroup.startReplaceableGroup(-492369756);
        Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
        if (objRememberedValue3 == companion.getEmpty()) {
            kotlin.jvm.internal.t.h(context, "context");
            objRememberedValue3 = new AndroidUriHandler(context);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
        }
        composerStartRestartGroup.endReplaceableGroup();
        AndroidUriHandler androidUriHandler = (AndroidUriHandler) objRememberedValue3;
        AndroidComposeView.ViewTreeOwners viewTreeOwners = owner.getViewTreeOwners();
        if (viewTreeOwners == null) {
            throw new IllegalStateException("Called when the ViewTreeOwnersAvailability is not yet in Available state");
        }
        composerStartRestartGroup.startReplaceableGroup(-492369756);
        Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
        if (objRememberedValue4 == companion.getEmpty()) {
            objRememberedValue4 = DisposableSaveableStateRegistry_androidKt.DisposableSaveableStateRegistry(owner, viewTreeOwners.getSavedStateRegistryOwner());
            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
        }
        composerStartRestartGroup.endReplaceableGroup();
        DisposableSaveableStateRegistry disposableSaveableStateRegistry = (DisposableSaveableStateRegistry) objRememberedValue4;
        EffectsKt.DisposableEffect(v8.k0.f35197a, new AnonymousClass2(disposableSaveableStateRegistry), composerStartRestartGroup, 0);
        kotlin.jvm.internal.t.h(context, "context");
        ImageVectorCache imageVectorCacheObtainImageVectorCache = obtainImageVectorCache(context, m3167ProvideAndroidCompositionLocals$lambda1(mutableState), composerStartRestartGroup, 72);
        ProvidableCompositionLocal<Configuration> providableCompositionLocal = LocalConfiguration;
        Configuration configuration = m3167ProvideAndroidCompositionLocals$lambda1(mutableState);
        kotlin.jvm.internal.t.h(configuration, "configuration");
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{providableCompositionLocal.provides(configuration), LocalContext.provides(context), LocalLifecycleOwner.provides(viewTreeOwners.getLifecycleOwner()), LocalSavedStateRegistryOwner.provides(viewTreeOwners.getSavedStateRegistryOwner()), SaveableStateRegistryKt.getLocalSaveableStateRegistry().provides(disposableSaveableStateRegistry), LocalView.provides(owner.getView()), LocalImageVectorCache.provides(imageVectorCacheObtainImageVectorCache)}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1471621628, true, new AnonymousClass3(owner, androidUriHandler, content, i10)), composerStartRestartGroup, 56);
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(owner, content, i10));
    }

    /* JADX INFO: renamed from: ProvideAndroidCompositionLocals$lambda-1, reason: not valid java name */
    private static final Configuration m3167ProvideAndroidCompositionLocals$lambda1(MutableState<Configuration> mutableState) {
        return mutableState.getValue();
    }

    @NotNull
    public static final ProvidableCompositionLocal<Configuration> getLocalConfiguration() {
        return LocalConfiguration;
    }

    @NotNull
    public static final ProvidableCompositionLocal<Context> getLocalContext() {
        return LocalContext;
    }

    @NotNull
    public static final ProvidableCompositionLocal<ImageVectorCache> getLocalImageVectorCache() {
        return LocalImageVectorCache;
    }

    @NotNull
    public static final ProvidableCompositionLocal<LifecycleOwner> getLocalLifecycleOwner() {
        return LocalLifecycleOwner;
    }

    @NotNull
    public static final ProvidableCompositionLocal<SavedStateRegistryOwner> getLocalSavedStateRegistryOwner() {
        return LocalSavedStateRegistryOwner;
    }

    @NotNull
    public static final ProvidableCompositionLocal<View> getLocalView() {
        return LocalView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void noLocalProvidedFor(String str) {
        throw new IllegalStateException(("CompositionLocal " + str + " not present").toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Stable
    @Composable
    private static final ImageVectorCache obtainImageVectorCache(Context context, Configuration configuration, Composer composer, int i10) {
        T t10;
        composer.startReplaceableGroup(-485908294);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = new ImageVectorCache();
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        final ImageVectorCache imageVectorCache = (ImageVectorCache) objRememberedValue;
        final kotlin.jvm.internal.n0 n0Var = new kotlin.jvm.internal.n0();
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == companion.getEmpty()) {
            composer.updateRememberedValue(configuration);
            t10 = configuration;
        } else {
            t10 = objRememberedValue2;
        }
        composer.endReplaceableGroup();
        n0Var.f29834a = t10;
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue3 = composer.rememberedValue();
        if (objRememberedValue3 == companion.getEmpty()) {
            objRememberedValue3 = new ComponentCallbacks2() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.content.ComponentCallbacks
                public void onConfigurationChanged(@NotNull Configuration configuration2) {
                    kotlin.jvm.internal.t.i(configuration2, "configuration");
                    Configuration configuration3 = n0Var.f29834a;
                    imageVectorCache.prune(configuration3 != null ? configuration3.updateFrom(configuration2) : -1);
                    n0Var.f29834a = configuration2;
                }

                @Override // android.content.ComponentCallbacks
                public void onLowMemory() {
                    imageVectorCache.clear();
                }

                @Override // android.content.ComponentCallbacks2
                public void onTrimMemory(int i11) {
                    imageVectorCache.clear();
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        composer.endReplaceableGroup();
        EffectsKt.DisposableEffect(imageVectorCache, new AnonymousClass1(context, (AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1) objRememberedValue3), composer, 8);
        composer.endReplaceableGroup();
        return imageVectorCache;
    }
}
