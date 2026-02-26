package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Ref;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AndroidView.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidView_androidKt {

    @NotNull
    private static final l<View, k0> NoOpUpdate = AndroidView_androidKt$NoOpUpdate$1.INSTANCE;

    /* JADX INFO: renamed from: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidView.android.kt */
    static final class AnonymousClass1 extends v implements h9.a<LayoutNode> {
        final /* synthetic */ Context $context;
        final /* synthetic */ NestedScrollDispatcher $dispatcher;
        final /* synthetic */ l<Context, T> $factory;
        final /* synthetic */ CompositionContext $parentReference;
        final /* synthetic */ String $stateKey;
        final /* synthetic */ SaveableStateRegistry $stateRegistry;
        final /* synthetic */ Ref<ViewFactoryHolder<T>> $viewFactoryHolderRef;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Context context, CompositionContext compositionContext, NestedScrollDispatcher nestedScrollDispatcher, l<? super Context, ? extends T> lVar, SaveableStateRegistry saveableStateRegistry, String str, Ref<ViewFactoryHolder<T>> ref) {
            super(0);
            this.$context = context;
            this.$parentReference = compositionContext;
            this.$dispatcher = nestedScrollDispatcher;
            this.$factory = lVar;
            this.$stateRegistry = saveableStateRegistry;
            this.$stateKey = str;
            this.$viewFactoryHolderRef = ref;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final LayoutNode invoke() {
            View typedView$ui_release;
            ViewFactoryHolder viewFactoryHolder = new ViewFactoryHolder(this.$context, this.$parentReference, this.$dispatcher);
            viewFactoryHolder.setFactory(this.$factory);
            SaveableStateRegistry saveableStateRegistry = this.$stateRegistry;
            Object objConsumeRestored = saveableStateRegistry != null ? saveableStateRegistry.consumeRestored(this.$stateKey) : null;
            SparseArray<Parcelable> sparseArray = objConsumeRestored instanceof SparseArray ? (SparseArray) objConsumeRestored : null;
            if (sparseArray != null && (typedView$ui_release = viewFactoryHolder.getTypedView$ui_release()) != null) {
                typedView$ui_release.restoreHierarchyState(sparseArray);
            }
            this.$viewFactoryHolderRef.setValue(viewFactoryHolder);
            return viewFactoryHolder.getLayoutNode();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidView.android.kt */
    static final class AnonymousClass3 extends v implements l<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ String $stateKey;
        final /* synthetic */ SaveableStateRegistry $stateRegistry;
        final /* synthetic */ Ref<ViewFactoryHolder<T>> $viewFactoryHolderRef;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(SaveableStateRegistry saveableStateRegistry, String str, Ref<ViewFactoryHolder<T>> ref) {
            super(1);
            this.$stateRegistry = saveableStateRegistry;
            this.$stateKey = str;
            this.$viewFactoryHolderRef = ref;
        }

        @Override // h9.l
        @NotNull
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
            t.i(DisposableEffect, "$this$DisposableEffect");
            final SaveableStateRegistry.Entry entryRegisterProvider = this.$stateRegistry.registerProvider(this.$stateKey, new AndroidView_androidKt$AndroidView$3$valueProvider$1(this.$viewFactoryHolderRef));
            return new DisposableEffectResult() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    entryRegisterProvider.unregister();
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$4, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidView.android.kt */
    static final class AnonymousClass4 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ l<Context, T> $factory;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ l<T, k0> $update;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass4(l<? super Context, ? extends T> lVar, Modifier modifier, l<? super T, k0> lVar2, int i10, int i11) {
            super(2);
            this.$factory = lVar;
            this.$modifier = modifier;
            this.$update = lVar2;
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
            AndroidView_androidKt.AndroidView(this.$factory, this.$modifier, this.$update, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.UiComposable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T extends android.view.View> void AndroidView(@org.jetbrains.annotations.NotNull h9.l<? super android.content.Context, ? extends T> r17, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r18, @org.jetbrains.annotations.Nullable h9.l<? super T, v8.k0> r19, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r20, int r21, int r22) {
        /*
            Method dump skipped, instruction units count: 477
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView(h9.l, androidx.compose.ui.Modifier, h9.l, androidx.compose.runtime.Composer, int, int):void");
    }

    @NotNull
    public static final l<View, k0> getNoOpUpdate() {
        return NoOpUpdate;
    }
}
