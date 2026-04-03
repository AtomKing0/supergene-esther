package androidx.activity.compose;

import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import com.ironsource.mediationsdk.logger.IronSourceError;
import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ActivityResultRegistry.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultRegistryKt {

    /* JADX INFO: renamed from: androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$1, reason: invalid class name */
    /* JADX INFO: compiled from: ActivityResultRegistry.kt */
    static final class AnonymousClass1 extends v implements l<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ ActivityResultRegistry $activityResultRegistry;
        final /* synthetic */ ActivityResultContract<I, O> $contract;
        final /* synthetic */ State<l<O, k0>> $currentOnResult;
        final /* synthetic */ String $key;
        final /* synthetic */ ActivityResultLauncherHolder<I> $realLauncher;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(ActivityResultLauncherHolder<I> activityResultLauncherHolder, ActivityResultRegistry activityResultRegistry, String str, ActivityResultContract<I, O> activityResultContract, State<? extends l<? super O, k0>> state) {
            super(1);
            this.$realLauncher = activityResultLauncherHolder;
            this.$activityResultRegistry = activityResultRegistry;
            this.$key = str;
            this.$contract = activityResultContract;
            this.$currentOnResult = state;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(State state, Object obj) {
            ((l) state.getValue()).invoke(obj);
        }

        @Override // h9.l
        @NotNull
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
            ActivityResultLauncherHolder<I> activityResultLauncherHolder = this.$realLauncher;
            ActivityResultRegistry activityResultRegistry = this.$activityResultRegistry;
            String str = this.$key;
            Object obj = this.$contract;
            final State<l<O, k0>> state = this.$currentOnResult;
            activityResultLauncherHolder.setLauncher(activityResultRegistry.register(str, obj, new ActivityResultCallback() { // from class: androidx.activity.compose.a
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(Object obj2) {
                    ActivityResultRegistryKt.AnonymousClass1.invoke$lambda$0(state, obj2);
                }
            }));
            final ActivityResultLauncherHolder<I> activityResultLauncherHolder2 = this.$realLauncher;
            return new DisposableEffectResult() { // from class: androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$1$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    activityResultLauncherHolder2.unregister();
                }
            };
        }
    }

    @Composable
    @NotNull
    public static final <I, O> ManagedActivityResultLauncher<I, O> rememberLauncherForActivityResult(@NotNull ActivityResultContract<I, O> activityResultContract, @NotNull l<? super O, k0> lVar, @Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(-1408504823);
        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(activityResultContract, composer, 8);
        State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(lVar, composer, (i10 >> 3) & 14);
        String str = (String) RememberSaveableKt.m1271rememberSaveable(new Object[0], (Saver) null, (String) null, (h9.a) ActivityResultRegistryKt$rememberLauncherForActivityResult$key$1.INSTANCE, composer, 3080, 6);
        ActivityResultRegistryOwner current = LocalActivityResultRegistryOwner.INSTANCE.getCurrent(composer, 6);
        if (current == null) {
            throw new IllegalStateException("No ActivityResultRegistryOwner was provided via LocalActivityResultRegistryOwner".toString());
        }
        ActivityResultRegistry activityResultRegistry = current.getActivityResultRegistry();
        composer.startReplaceableGroup(-3687241);
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = new ActivityResultLauncherHolder();
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        ActivityResultLauncherHolder activityResultLauncherHolder = (ActivityResultLauncherHolder) objRememberedValue;
        composer.startReplaceableGroup(-3687241);
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new ManagedActivityResultLauncher(activityResultLauncherHolder, stateRememberUpdatedState);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        ManagedActivityResultLauncher<I, O> managedActivityResultLauncher = (ManagedActivityResultLauncher) objRememberedValue2;
        EffectsKt.DisposableEffect(activityResultRegistry, str, activityResultContract, new AnonymousClass1(activityResultLauncherHolder, activityResultRegistry, str, activityResultContract, stateRememberUpdatedState2), composer, IronSourceError.ERROR_NO_INTERNET_CONNECTION);
        composer.endReplaceableGroup();
        return managedActivityResultLauncher;
    }
}
