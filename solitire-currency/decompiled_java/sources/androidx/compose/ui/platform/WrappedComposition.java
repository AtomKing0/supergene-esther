package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import androidx.compose.ui.R;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Wrapper.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class WrappedComposition implements Composition, LifecycleEventObserver {

    @Nullable
    private Lifecycle addedToLifecycle;
    private boolean disposed;

    @NotNull
    private h9.p<? super Composer, ? super Integer, v8.k0> lastContent;

    @NotNull
    private final Composition original;

    @NotNull
    private final AndroidComposeView owner;

    /* JADX INFO: renamed from: androidx.compose.ui.platform.WrappedComposition$setContent$1, reason: invalid class name */
    /* JADX INFO: compiled from: Wrapper.android.kt */
    static final class AnonymousClass1 extends kotlin.jvm.internal.v implements h9.l<AndroidComposeView.ViewTreeOwners, v8.k0> {
        final /* synthetic */ h9.p<Composer, Integer, v8.k0> $content;

        /* JADX INFO: renamed from: androidx.compose.ui.platform.WrappedComposition$setContent$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Wrapper.android.kt */
        static final class C01231 extends kotlin.jvm.internal.v implements h9.p<Composer, Integer, v8.k0> {
            final /* synthetic */ h9.p<Composer, Integer, v8.k0> $content;
            final /* synthetic */ WrappedComposition this$0;

            /* JADX INFO: renamed from: androidx.compose.ui.platform.WrappedComposition$setContent$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Wrapper.android.kt */
            @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.ui.platform.WrappedComposition$setContent$1$1$1", f = "Wrapper.android.kt", l = {153}, m = "invokeSuspend")
            static final class C01241 extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {
                int label;
                final /* synthetic */ WrappedComposition this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01241(WrappedComposition wrappedComposition, z8.d<? super C01241> dVar) {
                    super(2, dVar);
                    this.this$0 = wrappedComposition;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                    return new C01241(this.this$0, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object objE = a9.d.e();
                    int i10 = this.label;
                    if (i10 == 0) {
                        v8.u.b(obj);
                        AndroidComposeView owner = this.this$0.getOwner();
                        this.label = 1;
                        if (owner.keyboardVisibilityEventLoop(this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v8.u.b(obj);
                    }
                    return v8.k0.f35197a;
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
                    return ((C01241) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
                }
            }

            /* JADX INFO: renamed from: androidx.compose.ui.platform.WrappedComposition$setContent$1$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Wrapper.android.kt */
            @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.ui.platform.WrappedComposition$setContent$1$1$2", f = "Wrapper.android.kt", l = {154}, m = "invokeSuspend")
            static final class AnonymousClass2 extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {
                int label;
                final /* synthetic */ WrappedComposition this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(WrappedComposition wrappedComposition, z8.d<? super AnonymousClass2> dVar) {
                    super(2, dVar);
                    this.this$0 = wrappedComposition;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                    return new AnonymousClass2(this.this$0, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object objE = a9.d.e();
                    int i10 = this.label;
                    if (i10 == 0) {
                        v8.u.b(obj);
                        AndroidComposeView owner = this.this$0.getOwner();
                        this.label = 1;
                        if (owner.boundsUpdatesEventLoop(this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v8.u.b(obj);
                    }
                    return v8.k0.f35197a;
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
                    return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
                }
            }

            /* JADX INFO: renamed from: androidx.compose.ui.platform.WrappedComposition$setContent$1$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: Wrapper.android.kt */
            static final class AnonymousClass3 extends kotlin.jvm.internal.v implements h9.p<Composer, Integer, v8.k0> {
                final /* synthetic */ h9.p<Composer, Integer, v8.k0> $content;
                final /* synthetic */ WrappedComposition this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass3(WrappedComposition wrappedComposition, h9.p<? super Composer, ? super Integer, v8.k0> pVar) {
                    super(2);
                    this.this$0 = wrappedComposition;
                    this.$content = pVar;
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
                        AndroidCompositionLocals_androidKt.ProvideAndroidCompositionLocals(this.this$0.getOwner(), this.$content, composer, 8);
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C01231(WrappedComposition wrappedComposition, h9.p<? super Composer, ? super Integer, v8.k0> pVar) {
                super(2);
                this.this$0 = wrappedComposition;
                this.$content = pVar;
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
                    return;
                }
                AndroidComposeView owner = this.this$0.getOwner();
                int i11 = R.id.inspection_slot_table_set;
                Object tag = owner.getTag(i11);
                Set<CompositionData> set = kotlin.jvm.internal.t0.p(tag) ? (Set) tag : null;
                if (set == null) {
                    Object parent = this.this$0.getOwner().getParent();
                    View view = parent instanceof View ? (View) parent : null;
                    Object tag2 = view != null ? view.getTag(i11) : null;
                    set = kotlin.jvm.internal.t0.p(tag2) ? (Set) tag2 : null;
                }
                if (set != null) {
                    set.add(composer.getCompositionData());
                    composer.collectParameterInformation();
                }
                EffectsKt.LaunchedEffect(this.this$0.getOwner(), new C01241(this.this$0, null), composer, 8);
                EffectsKt.LaunchedEffect(this.this$0.getOwner(), new AnonymousClass2(this.this$0, null), composer, 8);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{InspectionTablesKt.getLocalInspectionTables().provides(set)}, ComposableLambdaKt.composableLambda(composer, -1193460702, true, new AnonymousClass3(this.this$0, this.$content)), composer, 56);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(h9.p<? super Composer, ? super Integer, v8.k0> pVar) {
            super(1);
            this.$content = pVar;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ v8.k0 invoke(AndroidComposeView.ViewTreeOwners viewTreeOwners) {
            invoke2(viewTreeOwners);
            return v8.k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull AndroidComposeView.ViewTreeOwners it) {
            kotlin.jvm.internal.t.i(it, "it");
            if (WrappedComposition.this.disposed) {
                return;
            }
            Lifecycle lifecycle = it.getLifecycleOwner().getLifecycle();
            kotlin.jvm.internal.t.h(lifecycle, "it.lifecycleOwner.lifecycle");
            WrappedComposition.this.lastContent = this.$content;
            if (WrappedComposition.this.addedToLifecycle == null) {
                WrappedComposition.this.addedToLifecycle = lifecycle;
                lifecycle.addObserver(WrappedComposition.this);
            } else if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                WrappedComposition.this.getOriginal().setContent(ComposableLambdaKt.composableLambdaInstance(-2000640158, true, new C01231(WrappedComposition.this, this.$content)));
            }
        }
    }

    public WrappedComposition(@NotNull AndroidComposeView owner, @NotNull Composition original) {
        kotlin.jvm.internal.t.i(owner, "owner");
        kotlin.jvm.internal.t.i(original, "original");
        this.owner = owner;
        this.original = original;
        this.lastContent = ComposableSingletons$Wrapper_androidKt.INSTANCE.m3174getLambda1$ui_release();
    }

    @Override // androidx.compose.runtime.Composition
    public void dispose() {
        if (!this.disposed) {
            this.disposed = true;
            this.owner.getView().setTag(R.id.wrapped_composition_tag, null);
            Lifecycle lifecycle = this.addedToLifecycle;
            if (lifecycle != null) {
                lifecycle.removeObserver(this);
            }
        }
        this.original.dispose();
    }

    @Override // androidx.compose.runtime.Composition
    public boolean getHasInvalidations() {
        return this.original.getHasInvalidations();
    }

    @NotNull
    public final Composition getOriginal() {
        return this.original;
    }

    @NotNull
    public final AndroidComposeView getOwner() {
        return this.owner;
    }

    @Override // androidx.compose.runtime.Composition
    public boolean isDisposed() {
        return this.original.isDisposed();
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        kotlin.jvm.internal.t.i(source, "source");
        kotlin.jvm.internal.t.i(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            dispose();
        } else {
            if (event != Lifecycle.Event.ON_CREATE || this.disposed) {
                return;
            }
            setContent(this.lastContent);
        }
    }

    @Override // androidx.compose.runtime.Composition
    @ComposableInferredTarget(scheme = "[0[0]]")
    public void setContent(@NotNull h9.p<? super Composer, ? super Integer, v8.k0> content) {
        kotlin.jvm.internal.t.i(content, "content");
        this.owner.setOnViewTreeOwnersAvailable(new AnonymousClass1(content));
    }
}
