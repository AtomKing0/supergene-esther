package androidx.compose.material;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.IntSize;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import h9.a;
import h9.l;
import h9.p;
import h9.q;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: ExposedDropdownMenu.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ExposedDropdownMenuKt {

    /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$1, reason: invalid class name */
    /* JADX INFO: compiled from: ExposedDropdownMenu.kt */
    static final class AnonymousClass1 extends v implements l<LayoutCoordinates, k0> {
        final /* synthetic */ Ref<LayoutCoordinates> $coordinates;
        final /* synthetic */ MutableState<Integer> $menuHeight$delegate;
        final /* synthetic */ int $verticalMarginInPx;
        final /* synthetic */ View $view;
        final /* synthetic */ MutableState<Integer> $width$delegate;

        /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: ExposedDropdownMenu.kt */
        static final class C00941 extends v implements l<Integer, k0> {
            final /* synthetic */ MutableState<Integer> $menuHeight$delegate;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00941(MutableState<Integer> mutableState) {
                super(1);
                this.$menuHeight$delegate = mutableState;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(Integer num) {
                invoke(num.intValue());
                return k0.f35197a;
            }

            public final void invoke(int i10) {
                ExposedDropdownMenuKt.m1026ExposedDropdownMenuBox$lambda5(this.$menuHeight$delegate, i10);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref<LayoutCoordinates> ref, View view, int i10, MutableState<Integer> mutableState, MutableState<Integer> mutableState2) {
            super(1);
            this.$coordinates = ref;
            this.$view = view;
            this.$verticalMarginInPx = i10;
            this.$width$delegate = mutableState;
            this.$menuHeight$delegate = mutableState2;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(LayoutCoordinates layoutCoordinates) {
            invoke2(layoutCoordinates);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull LayoutCoordinates it) {
            t.i(it, "it");
            ExposedDropdownMenuKt.m1024ExposedDropdownMenuBox$lambda2(this.$width$delegate, IntSize.m3833getWidthimpl(it.mo2989getSizeYbymL2g()));
            this.$coordinates.setValue(it);
            View rootView = this.$view.getRootView();
            t.h(rootView, "view.rootView");
            ExposedDropdownMenuKt.updateHeight(rootView, this.$coordinates.getValue(), this.$verticalMarginInPx, new C00941(this.$menuHeight$delegate));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$4, reason: invalid class name */
    /* JADX INFO: compiled from: ExposedDropdownMenu.kt */
    static final class AnonymousClass4 extends v implements a<k0> {
        final /* synthetic */ boolean $expanded;
        final /* synthetic */ FocusRequester $focusRequester;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(boolean z10, FocusRequester focusRequester) {
            super(0);
            this.$expanded = z10;
            this.$focusRequester = focusRequester;
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            invoke2();
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (this.$expanded) {
                this.$focusRequester.requestFocus();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5, reason: invalid class name */
    /* JADX INFO: compiled from: ExposedDropdownMenu.kt */
    static final class AnonymousClass5 extends v implements l<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ Ref<LayoutCoordinates> $coordinates;
        final /* synthetic */ MutableState<Integer> $menuHeight$delegate;
        final /* synthetic */ int $verticalMarginInPx;
        final /* synthetic */ View $view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(View view, Ref<LayoutCoordinates> ref, int i10, MutableState<Integer> mutableState) {
            super(1);
            this.$view = view;
            this.$coordinates = ref;
            this.$verticalMarginInPx = i10;
            this.$menuHeight$delegate = mutableState;
        }

        @Override // h9.l
        @NotNull
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
            t.i(DisposableEffect, "$this$DisposableEffect");
            View view = this.$view;
            final OnGlobalLayoutListener onGlobalLayoutListener = new OnGlobalLayoutListener(view, new ExposedDropdownMenuKt$ExposedDropdownMenuBox$5$listener$1(view, this.$coordinates, this.$verticalMarginInPx, this.$menuHeight$delegate));
            return new DisposableEffectResult() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    onGlobalLayoutListener.dispose();
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$6, reason: invalid class name */
    /* JADX INFO: compiled from: ExposedDropdownMenu.kt */
    static final class AnonymousClass6 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ q<ExposedDropdownMenuBoxScope, Composer, Integer, k0> $content;
        final /* synthetic */ boolean $expanded;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ l<Boolean, k0> $onExpandedChange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass6(boolean z10, l<? super Boolean, k0> lVar, Modifier modifier, q<? super ExposedDropdownMenuBoxScope, ? super Composer, ? super Integer, k0> qVar, int i10, int i11) {
            super(2);
            this.$expanded = z10;
            this.$onExpandedChange = lVar;
            this.$modifier = modifier;
            this.$content = qVar;
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
            ExposedDropdownMenuKt.ExposedDropdownMenuBox(this.$expanded, this.$onExpandedChange, this.$modifier, this.$content, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenuKt$expandable$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ExposedDropdownMenu.kt */
    @f(c = "androidx.compose.material.ExposedDropdownMenuKt$expandable$1", f = "ExposedDropdownMenu.kt", l = {IronSourceConstants.SDK_INIT_SUCCESS}, m = "invokeSuspend")
    static final class C09221 extends kotlin.coroutines.jvm.internal.l implements p<PointerInputScope, d<? super k0>, Object> {
        final /* synthetic */ a<k0> $onExpandedChange;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenuKt$expandable$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: ExposedDropdownMenu.kt */
        @f(c = "androidx.compose.material.ExposedDropdownMenuKt$expandable$1$1", f = "ExposedDropdownMenu.kt", l = {IronSourceConstants.INIT_DEFERRED_DATA}, m = "invokeSuspend")
        static final class C00951 extends kotlin.coroutines.jvm.internal.l implements p<PointerInputScope, d<? super k0>, Object> {
            final /* synthetic */ a<k0> $onExpandedChange;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenuKt$expandable$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: ExposedDropdownMenu.kt */
            @f(c = "androidx.compose.material.ExposedDropdownMenuKt$expandable$1$1$1", f = "ExposedDropdownMenu.kt", l = {518}, m = "invokeSuspend")
            static final class C00961 extends kotlin.coroutines.jvm.internal.l implements p<o0, d<? super k0>, Object> {
                final /* synthetic */ PointerInputScope $$this$forEachGesture;
                final /* synthetic */ a<k0> $onExpandedChange;
                int label;

                /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenuKt$expandable$1$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: ExposedDropdownMenu.kt */
                @f(c = "androidx.compose.material.ExposedDropdownMenuKt$expandable$1$1$1$1", f = "ExposedDropdownMenu.kt", l = {521}, m = "invokeSuspend")
                static final class C00971 extends k implements p<AwaitPointerEventScope, d<? super k0>, Object> {
                    final /* synthetic */ a<k0> $onExpandedChange;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00971(a<k0> aVar, d<? super C00971> dVar) {
                        super(2, dVar);
                        this.$onExpandedChange = aVar;
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @NotNull
                    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                        C00971 c00971 = new C00971(this.$onExpandedChange, dVar);
                        c00971.L$0 = obj;
                        return c00971;
                    }

                    @Override // h9.p
                    @Nullable
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                    public final Object mo4invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable d<? super k0> dVar) {
                        return ((C00971) create(awaitPointerEventScope, dVar)).invokeSuspend(k0.f35197a);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:11:0x0033 A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
                    /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
                    /* JADX WARN: Removed duplicated region for block: B:21:0x005a  */
                    /* JADX WARN: Removed duplicated region for block: B:23:0x0062  */
                    /* JADX WARN: Removed duplicated region for block: B:25:0x0057 A[SYNTHETIC] */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0034 -> B:13:0x0039). Please report as a decompilation issue!!! */
                    @Override // kotlin.coroutines.jvm.internal.a
                    @org.jetbrains.annotations.Nullable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
                        /*
                            r9 = this;
                            java.lang.Object r0 = a9.b.e()
                            int r1 = r9.label
                            r2 = 1
                            if (r1 == 0) goto L1e
                            if (r1 != r2) goto L16
                            java.lang.Object r1 = r9.L$0
                            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                            v8.u.b(r10)
                            r3 = r1
                            r1 = r0
                            r0 = r9
                            goto L39
                        L16:
                            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                            r10.<init>(r0)
                            throw r10
                        L1e:
                            v8.u.b(r10)
                            java.lang.Object r10 = r9.L$0
                            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
                            r1 = r10
                            r10 = r9
                        L27:
                            androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                            r10.L$0 = r1
                            r10.label = r2
                            java.lang.Object r3 = r1.awaitPointerEvent(r3, r10)
                            if (r3 != r0) goto L34
                            return r0
                        L34:
                            r8 = r0
                            r0 = r10
                            r10 = r3
                            r3 = r1
                            r1 = r8
                        L39:
                            androidx.compose.ui.input.pointer.PointerEvent r10 = (androidx.compose.ui.input.pointer.PointerEvent) r10
                            java.util.List r10 = r10.getChanges()
                            int r4 = r10.size()
                            r5 = 0
                            r6 = r5
                        L45:
                            if (r6 >= r4) goto L57
                            java.lang.Object r7 = r10.get(r6)
                            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
                            boolean r7 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r7)
                            if (r7 != 0) goto L54
                            goto L58
                        L54:
                            int r6 = r6 + 1
                            goto L45
                        L57:
                            r5 = r2
                        L58:
                            if (r5 == 0) goto L62
                            h9.a<v8.k0> r10 = r0.$onExpandedChange
                            r10.invoke()
                            v8.k0 r10 = v8.k0.f35197a
                            return r10
                        L62:
                            r10 = r0
                            r0 = r1
                            r1 = r3
                            goto L27
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ExposedDropdownMenuKt.C09221.C00951.C00961.C00971.invokeSuspend(java.lang.Object):java.lang.Object");
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00961(PointerInputScope pointerInputScope, a<k0> aVar, d<? super C00961> dVar) {
                    super(2, dVar);
                    this.$$this$forEachGesture = pointerInputScope;
                    this.$onExpandedChange = aVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                    return new C00961(this.$$this$forEachGesture, this.$onExpandedChange, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object objE = a9.d.e();
                    int i10 = this.label;
                    if (i10 == 0) {
                        u.b(obj);
                        PointerInputScope pointerInputScope = this.$$this$forEachGesture;
                        C00971 c00971 = new C00971(this.$onExpandedChange, null);
                        this.label = 1;
                        if (pointerInputScope.awaitPointerEventScope(c00971, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        u.b(obj);
                    }
                    return k0.f35197a;
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
                    return ((C00961) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00951(a<k0> aVar, d<? super C00951> dVar) {
                super(2, dVar);
                this.$onExpandedChange = aVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                C00951 c00951 = new C00951(this.$onExpandedChange, dVar);
                c00951.L$0 = obj;
                return c00951;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable d<? super k0> dVar) {
                return ((C00951) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    C00961 c00961 = new C00961((PointerInputScope) this.L$0, this.$onExpandedChange, null);
                    this.label = 1;
                    if (p0.f(c00961, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                }
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09221(a<k0> aVar, d<? super C09221> dVar) {
            super(2, dVar);
            this.$onExpandedChange = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            C09221 c09221 = new C09221(this.$onExpandedChange, dVar);
            c09221.L$0 = obj;
            return c09221;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable d<? super k0> dVar) {
            return ((C09221) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                C00951 c00951 = new C00951(this.$onExpandedChange, null);
                this.label = 1;
                if (ForEachGestureKt.forEachGesture(pointerInputScope, c00951, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenuKt$expandable$2, reason: invalid class name */
    /* JADX INFO: compiled from: ExposedDropdownMenu.kt */
    static final class AnonymousClass2 extends v implements l<SemanticsPropertyReceiver, k0> {
        final /* synthetic */ String $menuLabel;
        final /* synthetic */ a<k0> $onExpandedChange;

        /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenuKt$expandable$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: ExposedDropdownMenu.kt */
        static final class AnonymousClass1 extends v implements a<Boolean> {
            final /* synthetic */ a<k0> $onExpandedChange;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(a<k0> aVar) {
                super(0);
                this.$onExpandedChange = aVar;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h9.a
            @NotNull
            public final Boolean invoke() {
                this.$onExpandedChange.invoke();
                return Boolean.TRUE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, a<k0> aVar) {
            super(1);
            this.$menuLabel = str;
            this.$onExpandedChange = aVar;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            invoke2(semanticsPropertyReceiver);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
            t.i(semantics, "$this$semantics");
            SemanticsPropertiesKt.setContentDescription(semantics, this.$menuLabel);
            SemanticsPropertiesKt.onClick$default(semantics, null, new AnonymousClass1(this.$onExpandedChange), 1, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void ExposedDropdownMenuBox(boolean r19, @org.jetbrains.annotations.NotNull h9.l<? super java.lang.Boolean, v8.k0> r20, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r21, @org.jetbrains.annotations.NotNull h9.q<? super androidx.compose.material.ExposedDropdownMenuBoxScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r22, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r23, int r24, int r25) {
        /*
            Method dump skipped, instruction units count: 696
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ExposedDropdownMenuKt.ExposedDropdownMenuBox(boolean, h9.l, androidx.compose.ui.Modifier, h9.q, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ExposedDropdownMenuBox$lambda-1, reason: not valid java name */
    public static final int m1023ExposedDropdownMenuBox$lambda1(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ExposedDropdownMenuBox$lambda-2, reason: not valid java name */
    public static final void m1024ExposedDropdownMenuBox$lambda2(MutableState<Integer> mutableState, int i10) {
        mutableState.setValue(Integer.valueOf(i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ExposedDropdownMenuBox$lambda-4, reason: not valid java name */
    public static final int m1025ExposedDropdownMenuBox$lambda4(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ExposedDropdownMenuBox$lambda-5, reason: not valid java name */
    public static final void m1026ExposedDropdownMenuBox$lambda5(MutableState<Integer> mutableState, int i10) {
        mutableState.setValue(Integer.valueOf(i10));
    }

    private static final Modifier expandable(Modifier modifier, a<k0> aVar, String str) {
        return SemanticsModifierKt.semantics$default(SuspendingPointerInputFilterKt.pointerInput(modifier, k0.f35197a, new C09221(aVar, null)), false, new AnonymousClass2(str, aVar), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateHeight(View view, LayoutCoordinates layoutCoordinates, int i10, l<? super Integer, k0> lVar) {
        if (layoutCoordinates == null) {
            return;
        }
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        lVar.invoke(Integer.valueOf(((int) Math.max(LayoutCoordinatesKt.boundsInWindow(layoutCoordinates).getTop() - rect.top, (rect.bottom - r1) - LayoutCoordinatesKt.boundsInWindow(layoutCoordinates).getBottom())) - i10));
    }
}
