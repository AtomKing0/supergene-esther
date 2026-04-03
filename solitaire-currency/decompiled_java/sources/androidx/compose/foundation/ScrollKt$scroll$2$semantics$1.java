package androidx.compose.foundation;

import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: Scroll.kt */
/* JADX INFO: loaded from: classes.dex */
final class ScrollKt$scroll$2$semantics$1 extends v implements h9.l<SemanticsPropertyReceiver, k0> {
    final /* synthetic */ o0 $coroutineScope;
    final /* synthetic */ boolean $isScrollable;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ boolean $reverseScrolling;
    final /* synthetic */ ScrollState $state;

    /* JADX INFO: renamed from: androidx.compose.foundation.ScrollKt$scroll$2$semantics$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: Scroll.kt */
    static final class AnonymousClass1 extends v implements h9.p<Float, Float, Boolean> {
        final /* synthetic */ o0 $coroutineScope;
        final /* synthetic */ boolean $isVertical;
        final /* synthetic */ ScrollState $state;

        /* JADX INFO: renamed from: androidx.compose.foundation.ScrollKt$scroll$2$semantics$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Scroll.kt */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.ScrollKt$scroll$2$semantics$1$1$1", f = "Scroll.kt", l = {276, 278}, m = "invokeSuspend")
        static final class C00361 extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {
            final /* synthetic */ boolean $isVertical;
            final /* synthetic */ ScrollState $state;
            final /* synthetic */ float $x;
            final /* synthetic */ float $y;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00361(boolean z10, ScrollState scrollState, float f10, float f11, z8.d<? super C00361> dVar) {
                super(2, dVar);
                this.$isVertical = z10;
                this.$state = scrollState;
                this.$y = f10;
                this.$x = f11;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new C00361(this.$isVertical, this.$state, this.$y, this.$x, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    if (this.$isVertical) {
                        ScrollState scrollState = this.$state;
                        float f10 = this.$y;
                        this.label = 1;
                        if (ScrollExtensionsKt.animateScrollBy$default(scrollState, f10, null, this, 2, null) == objE) {
                            return objE;
                        }
                    } else {
                        ScrollState scrollState2 = this.$state;
                        float f11 = this.$x;
                        this.label = 2;
                        if (ScrollExtensionsKt.animateScrollBy$default(scrollState2, f11, null, this, 2, null) == objE) {
                            return objE;
                        }
                    }
                } else {
                    if (i10 != 1 && i10 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                }
                return k0.f35197a;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                return ((C00361) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(o0 o0Var, boolean z10, ScrollState scrollState) {
            super(2);
            this.$coroutineScope = o0Var;
            this.$isVertical = z10;
            this.$state = scrollState;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Boolean mo4invoke(Float f10, Float f11) {
            return invoke(f10.floatValue(), f11.floatValue());
        }

        @NotNull
        public final Boolean invoke(float f10, float f11) {
            kotlinx.coroutines.k.d(this.$coroutineScope, null, null, new C00361(this.$isVertical, this.$state, f11, f10, null), 3, null);
            return Boolean.TRUE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScrollKt$scroll$2$semantics$1(boolean z10, boolean z11, boolean z12, ScrollState scrollState, o0 o0Var) {
        super(1);
        this.$reverseScrolling = z10;
        this.$isVertical = z11;
        this.$isScrollable = z12;
        this.$state = scrollState;
        this.$coroutineScope = o0Var;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        invoke2(semanticsPropertyReceiver);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
        t.i(semantics, "$this$semantics");
        ScrollAxisRange scrollAxisRange = new ScrollAxisRange(new ScrollKt$scroll$2$semantics$1$accessibilityScrollState$1(this.$state), new ScrollKt$scroll$2$semantics$1$accessibilityScrollState$2(this.$state), this.$reverseScrolling);
        if (this.$isVertical) {
            SemanticsPropertiesKt.setVerticalScrollAxisRange(semantics, scrollAxisRange);
        } else {
            SemanticsPropertiesKt.setHorizontalScrollAxisRange(semantics, scrollAxisRange);
        }
        if (this.$isScrollable) {
            SemanticsPropertiesKt.scrollBy$default(semantics, null, new AnonymousClass1(this.$coroutineScope, this.$isVertical, this.$state), 1, null);
        }
    }
}
