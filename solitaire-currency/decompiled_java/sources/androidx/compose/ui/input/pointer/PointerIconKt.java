package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import h9.p;
import h9.q;
import kotlin.coroutines.jvm.internal.k;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: PointerIcon.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PointerIconKt {

    /* JADX INFO: renamed from: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2, reason: invalid class name */
    /* JADX INFO: compiled from: PointerIcon.kt */
    static final class AnonymousClass2 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ PointerIcon $icon;
        final /* synthetic */ boolean $overrideDescendants;

        /* JADX INFO: renamed from: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: PointerIcon.kt */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$1", f = "PointerIcon.kt", l = {74}, m = "invokeSuspend")
        static final class AnonymousClass1 extends l implements p<PointerInputScope, z8.d<? super k0>, Object> {
            final /* synthetic */ PointerIcon $icon;
            final /* synthetic */ boolean $overrideDescendants;
            final /* synthetic */ PointerIconService $pointerIconService;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: PointerIcon.kt */
            @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$1$1", f = "PointerIcon.kt", l = {80}, m = "invokeSuspend")
            static final class C01211 extends k implements p<AwaitPointerEventScope, z8.d<? super k0>, Object> {
                final /* synthetic */ PointerIcon $icon;
                final /* synthetic */ boolean $overrideDescendants;
                final /* synthetic */ PointerIconService $pointerIconService;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01211(boolean z10, PointerIconService pointerIconService, PointerIcon pointerIcon, z8.d<? super C01211> dVar) {
                    super(2, dVar);
                    this.$overrideDescendants = z10;
                    this.$pointerIconService = pointerIconService;
                    this.$icon = pointerIcon;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                    C01211 c01211 = new C01211(this.$overrideDescendants, this.$pointerIconService, this.$icon, dVar);
                    c01211.L$0 = obj;
                    return c01211;
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public final Object mo4invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable z8.d<? super k0> dVar) {
                    return ((C01211) create(awaitPointerEventScope, dVar)).invokeSuspend(k0.f35197a);
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
                /* JADX WARN: Removed duplicated region for block: B:15:0x003a A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x003b -> B:17:0x0040). Please report as a decompilation issue!!! */
                @Override // kotlin.coroutines.jvm.internal.a
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
                    /*
                        r12 = this;
                        java.lang.Object r0 = a9.b.e()
                        int r1 = r12.label
                        r2 = 1
                        if (r1 == 0) goto L1e
                        if (r1 != r2) goto L16
                        java.lang.Object r1 = r12.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                        v8.u.b(r13)
                        r3 = r1
                        r1 = r0
                        r0 = r12
                        goto L40
                    L16:
                        java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r13.<init>(r0)
                        throw r13
                    L1e:
                        v8.u.b(r13)
                        java.lang.Object r13 = r12.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
                        r1 = r13
                        r13 = r12
                    L27:
                        boolean r3 = r13.$overrideDescendants
                        if (r3 == 0) goto L2e
                        androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.ui.input.pointer.PointerEventPass.Main
                        goto L30
                    L2e:
                        androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                    L30:
                        r13.L$0 = r1
                        r13.label = r2
                        java.lang.Object r3 = r1.awaitPointerEvent(r3, r13)
                        if (r3 != r0) goto L3b
                        return r0
                    L3b:
                        r11 = r0
                        r0 = r13
                        r13 = r3
                        r3 = r1
                        r1 = r11
                    L40:
                        androidx.compose.ui.input.pointer.PointerEvent r13 = (androidx.compose.ui.input.pointer.PointerEvent) r13
                        int r4 = r13.m2820getType7fucELk()
                        androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.Companion
                        int r6 = r5.m2835getRelease7fucELk()
                        boolean r4 = androidx.compose.ui.input.pointer.PointerEventType.m2827equalsimpl0(r4, r6)
                        r6 = 0
                        if (r4 == 0) goto L6e
                        java.util.List r4 = r13.getChanges()
                        java.lang.Object r4 = r4.get(r6)
                        androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
                        long r7 = r3.mo2791getSizeYbymL2g()
                        androidx.compose.ui.geometry.Size$Companion r9 = androidx.compose.ui.geometry.Size.Companion
                        long r9 = r9.m1445getZeroNHjbRc()
                        boolean r4 = androidx.compose.ui.input.pointer.PointerEventKt.m2823isOutOfBoundsjwHxaWs(r4, r7, r9)
                        if (r4 == 0) goto L6e
                        r6 = r2
                    L6e:
                        int r13 = r13.m2820getType7fucELk()
                        int r4 = r5.m2832getExit7fucELk()
                        boolean r13 = androidx.compose.ui.input.pointer.PointerEventType.m2827equalsimpl0(r13, r4)
                        if (r13 != 0) goto L85
                        if (r6 != 0) goto L85
                        androidx.compose.ui.input.pointer.PointerIconService r13 = r0.$pointerIconService
                        androidx.compose.ui.input.pointer.PointerIcon r4 = r0.$icon
                        r13.setCurrent(r4)
                    L85:
                        r13 = r0
                        r0 = r1
                        r1 = r3
                        goto L27
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.PointerIconKt.AnonymousClass2.AnonymousClass1.C01211.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(boolean z10, PointerIconService pointerIconService, PointerIcon pointerIcon, z8.d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.$overrideDescendants = z10;
                this.$pointerIconService = pointerIconService;
                this.$icon = pointerIcon;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$overrideDescendants, this.$pointerIconService, this.$icon, dVar);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable z8.d<? super k0> dVar) {
                return ((AnonymousClass1) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                    C01211 c01211 = new C01211(this.$overrideDescendants, this.$pointerIconService, this.$icon, null);
                    this.label = 1;
                    if (pointerInputScope.awaitPointerEventScope(c01211, this) == objE) {
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
        AnonymousClass2(PointerIcon pointerIcon, boolean z10) {
            super(3);
            this.$icon = pointerIcon;
            this.$overrideDescendants = z10;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(811087536);
            PointerIconService pointerIconService = (PointerIconService) composer.consume(CompositionLocalsKt.getLocalPointerIconService());
            Modifier modifierPointerInput = pointerIconService == null ? Modifier.Companion : SuspendingPointerInputFilterKt.pointerInput(composed, this.$icon, Boolean.valueOf(this.$overrideDescendants), new AnonymousClass1(this.$overrideDescendants, pointerIconService, this.$icon, null));
            composer.endReplaceableGroup();
            return modifierPointerInput;
        }
    }

    @Stable
    @NotNull
    public static final Modifier pointerHoverIcon(@NotNull Modifier modifier, @NotNull PointerIcon icon, boolean z10) {
        t.i(modifier, "<this>");
        t.i(icon, "icon");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new PointerIconKt$pointerHoverIcon$$inlined$debugInspectorInfo$1(icon, z10) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(icon, z10));
    }

    public static /* synthetic */ Modifier pointerHoverIcon$default(Modifier modifier, PointerIcon pointerIcon, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return pointerHoverIcon(modifier, pointerIcon, z10);
    }
}
