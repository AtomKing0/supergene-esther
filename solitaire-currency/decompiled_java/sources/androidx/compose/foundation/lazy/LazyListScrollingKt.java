package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.ui.unit.Dp;
import h9.p;
import java.util.List;
import kotlin.collections.d0;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: LazyListScrolling.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListScrollingKt {
    private static final boolean DEBUG = false;
    private static final float TargetDistance = Dp.m3673constructorimpl(2500);
    private static final float BoundDistance = Dp.m3673constructorimpl(1500);

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListScrollingKt$doSmoothScrollToItem$3, reason: invalid class name */
    /* JADX INFO: compiled from: LazyListScrolling.kt */
    @f(c = "androidx.compose.foundation.lazy.LazyListScrollingKt$doSmoothScrollToItem$3", f = "LazyListScrolling.kt", l = {114, 205}, m = "invokeSuspend")
    static final class AnonymousClass3 extends l implements p<ScrollScope, d<? super k0>, Object> {
        final /* synthetic */ int $index;
        final /* synthetic */ int $scrollOffset;
        final /* synthetic */ LazyListState $this_doSmoothScrollToItem;
        float F$0;
        float F$1;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListScrollingKt$doSmoothScrollToItem$3$2, reason: invalid class name */
        /* JADX INFO: compiled from: LazyListScrolling.kt */
        static final class AnonymousClass2 extends v implements h9.l<AnimationScope<Float, AnimationVector1D>, k0> {
            final /* synthetic */ ScrollScope $$this$scroll;
            final /* synthetic */ n0<AnimationState<Float, AnimationVector1D>> $anim;
            final /* synthetic */ float $boundDistancePx;
            final /* synthetic */ boolean $forward;
            final /* synthetic */ int $index;
            final /* synthetic */ i0 $loop;
            final /* synthetic */ l0 $loops;
            final /* synthetic */ kotlin.jvm.internal.k0 $prevValue;
            final /* synthetic */ int $scrollOffset;
            final /* synthetic */ float $target;
            final /* synthetic */ LazyListState $this_doSmoothScrollToItem;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(float f10, kotlin.jvm.internal.k0 k0Var, ScrollScope scrollScope, i0 i0Var, boolean z10, float f11, l0 l0Var, int i10, LazyListState lazyListState, int i11, n0<AnimationState<Float, AnimationVector1D>> n0Var) {
                super(1);
                this.$target = f10;
                this.$prevValue = k0Var;
                this.$$this$scroll = scrollScope;
                this.$loop = i0Var;
                this.$forward = z10;
                this.$boundDistancePx = f11;
                this.$loops = l0Var;
                this.$index = i10;
                this.$this_doSmoothScrollToItem = lazyListState;
                this.$scrollOffset = i11;
                this.$anim = n0Var;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                invoke2(animationScope);
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull AnimationScope<Float, AnimationVector1D> animateTo) {
                t.i(animateTo, "$this$animateTo");
                LazyListItemInfo lazyListItemInfoDoSmoothScrollToItem$getTargetItem = LazyListScrollingKt.doSmoothScrollToItem$getTargetItem(this.$this_doSmoothScrollToItem, this.$index);
                if (lazyListItemInfoDoSmoothScrollToItem$getTargetItem == null) {
                    float fI = (this.$target > 0.0f ? o.i(animateTo.getValue().floatValue(), this.$target) : o.d(animateTo.getValue().floatValue(), this.$target)) - this.$prevValue.f29829a;
                    float fScrollBy = this.$$this$scroll.scrollBy(fI);
                    LazyListItemInfo lazyListItemInfoDoSmoothScrollToItem$getTargetItem2 = LazyListScrollingKt.doSmoothScrollToItem$getTargetItem(this.$this_doSmoothScrollToItem, this.$index);
                    if (lazyListItemInfoDoSmoothScrollToItem$getTargetItem2 == null && !AnonymousClass3.invokeSuspend$isOvershot(this.$forward, this.$this_doSmoothScrollToItem, this.$index, this.$scrollOffset)) {
                        if (!(fI == fScrollBy)) {
                            animateTo.cancelAnimation();
                            this.$loop.f29826a = false;
                            return;
                        }
                        this.$prevValue.f29829a += fI;
                        if (this.$forward) {
                            if (animateTo.getValue().floatValue() > this.$boundDistancePx) {
                                animateTo.cancelAnimation();
                            }
                        } else if (animateTo.getValue().floatValue() < (-this.$boundDistancePx)) {
                            animateTo.cancelAnimation();
                        }
                        if (this.$forward) {
                            if (this.$loops.f29831a >= 2 && this.$index - ((LazyListItemInfo) d0.t0(this.$this_doSmoothScrollToItem.getLayoutInfo().getVisibleItemsInfo())).getIndex() > 100) {
                                this.$this_doSmoothScrollToItem.snapToItemIndexInternal$foundation_release(this.$index - 100, 0);
                            }
                        } else if (this.$loops.f29831a >= 2) {
                            int index = ((LazyListItemInfo) d0.i0(this.$this_doSmoothScrollToItem.getLayoutInfo().getVisibleItemsInfo())).getIndex();
                            int i10 = this.$index;
                            if (index - i10 > 100) {
                                this.$this_doSmoothScrollToItem.snapToItemIndexInternal$foundation_release(i10 + 100, 0);
                            }
                        }
                    }
                    lazyListItemInfoDoSmoothScrollToItem$getTargetItem = lazyListItemInfoDoSmoothScrollToItem$getTargetItem2;
                }
                if (!AnonymousClass3.invokeSuspend$isOvershot(this.$forward, this.$this_doSmoothScrollToItem, this.$index, this.$scrollOffset)) {
                    if (lazyListItemInfoDoSmoothScrollToItem$getTargetItem != null) {
                        throw new ItemFoundInScroll(lazyListItemInfoDoSmoothScrollToItem$getTargetItem, this.$anim.f29834a);
                    }
                } else {
                    this.$this_doSmoothScrollToItem.snapToItemIndexInternal$foundation_release(this.$index, this.$scrollOffset);
                    this.$loop.f29826a = false;
                    animateTo.cancelAnimation();
                }
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListScrollingKt$doSmoothScrollToItem$3$4, reason: invalid class name */
        /* JADX INFO: compiled from: LazyListScrolling.kt */
        static final class AnonymousClass4 extends v implements h9.l<AnimationScope<Float, AnimationVector1D>, k0> {
            final /* synthetic */ ScrollScope $$this$scroll;
            final /* synthetic */ kotlin.jvm.internal.k0 $prevValue;
            final /* synthetic */ float $target;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(float f10, kotlin.jvm.internal.k0 k0Var, ScrollScope scrollScope) {
                super(1);
                this.$target = f10;
                this.$prevValue = k0Var;
                this.$$this$scroll = scrollScope;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                invoke2(animationScope);
                return k0.f35197a;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x005a  */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void invoke2(@org.jetbrains.annotations.NotNull androidx.compose.animation.core.AnimationScope<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r6) {
                /*
                    r5 = this;
                    java.lang.String r0 = "$this$animateTo"
                    kotlin.jvm.internal.t.i(r6, r0)
                    float r0 = r5.$target
                    r1 = 0
                    int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                    if (r2 <= 0) goto L1d
                    java.lang.Object r0 = r6.getValue()
                    java.lang.Number r0 = (java.lang.Number) r0
                    float r0 = r0.floatValue()
                    float r1 = r5.$target
                    float r1 = n9.m.i(r0, r1)
                    goto L31
                L1d:
                    int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                    if (r0 >= 0) goto L31
                    java.lang.Object r0 = r6.getValue()
                    java.lang.Number r0 = (java.lang.Number) r0
                    float r0 = r0.floatValue()
                    float r1 = r5.$target
                    float r1 = n9.m.d(r0, r1)
                L31:
                    kotlin.jvm.internal.k0 r0 = r5.$prevValue
                    float r0 = r0.f29829a
                    float r0 = r1 - r0
                    androidx.compose.foundation.gestures.ScrollScope r2 = r5.$$this$scroll
                    float r2 = r2.scrollBy(r0)
                    int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    r3 = 1
                    r4 = 0
                    if (r2 != 0) goto L45
                    r2 = r3
                    goto L46
                L45:
                    r2 = r4
                L46:
                    if (r2 == 0) goto L5a
                    java.lang.Object r2 = r6.getValue()
                    java.lang.Number r2 = (java.lang.Number) r2
                    float r2 = r2.floatValue()
                    int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
                    if (r1 != 0) goto L57
                    goto L58
                L57:
                    r3 = r4
                L58:
                    if (r3 != 0) goto L5d
                L5a:
                    r6.cancelAnimation()
                L5d:
                    kotlin.jvm.internal.k0 r6 = r5.$prevValue
                    float r1 = r6.f29829a
                    float r1 = r1 + r0
                    r6.f29829a = r1
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListScrollingKt.AnonymousClass3.AnonymousClass4.invoke2(androidx.compose.animation.core.AnimationScope):void");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(LazyListState lazyListState, int i10, int i11, d<? super AnonymousClass3> dVar) {
            super(2, dVar);
            this.$this_doSmoothScrollToItem = lazyListState;
            this.$index = i10;
            this.$scrollOffset = i11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$isOvershot(boolean z10, LazyListState lazyListState, int i10, int i11) {
            if (z10) {
                if (lazyListState.getFirstVisibleItemIndex() <= i10 && (lazyListState.getFirstVisibleItemIndex() != i10 || lazyListState.getFirstVisibleItemScrollOffset() <= i11)) {
                    return false;
                }
            } else if (lazyListState.getFirstVisibleItemIndex() >= i10 && (lazyListState.getFirstVisibleItemIndex() != i10 || lazyListState.getFirstVisibleItemScrollOffset() >= i11)) {
                return false;
            }
            return true;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$this_doSmoothScrollToItem, this.$index, this.$scrollOffset, dVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull ScrollScope scrollScope, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass3) create(scrollScope, dVar)).invokeSuspend(k0.f35197a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Path cross not found for [B:35:0x0107, B:34:0x0105], limit reached: 92 */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00b1 A[Catch: ItemFoundInScroll -> 0x01d8, TryCatch #1 {ItemFoundInScroll -> 0x01d8, blocks: (B:23:0x00ad, B:25:0x00b1, B:27:0x00bd, B:32:0x00df, B:38:0x010d, B:45:0x0154, B:49:0x015d), top: B:84:0x00ad }] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00d0 A[Catch: ItemFoundInScroll -> 0x01ce, TRY_ENTER, TRY_LEAVE, TryCatch #0 {ItemFoundInScroll -> 0x01ce, blocks: (B:57:0x01c1, B:30:0x00d0), top: B:82:0x01c1 }] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0107  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x014a  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x014c  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x014f  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0152  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0158  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x015b  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x01b6 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:56:0x01b7  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0223  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0226  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x0249 A[RETURN] */
        /* JADX WARN: Type inference failed for: r10v0, types: [T, androidx.compose.animation.core.AnimationState] */
        /* JADX WARN: Type inference failed for: r5v15, types: [T, androidx.compose.animation.core.AnimationState] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x01b7 -> B:82:0x01c1). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r37) {
            /*
                Method dump skipped, instruction units count: 598
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListScrollingKt.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Nullable
    public static final Object doSmoothScrollToItem(@NotNull LazyListState lazyListState, int i10, int i11, @NotNull d<? super k0> dVar) {
        if (((float) i10) >= 0.0f) {
            Object objA = androidx.compose.foundation.gestures.d.a(lazyListState, null, new AnonymousClass3(lazyListState, i10, i11, null), dVar, 1, null);
            return objA == a9.d.e() ? objA : k0.f35197a;
        }
        throw new IllegalArgumentException(("Index should be non-negative (" + i10 + ')').toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LazyListItemInfo doSmoothScrollToItem$getTargetItem(LazyListState lazyListState, int i10) {
        LazyListItemInfo lazyListItemInfo;
        List<LazyListItemInfo> visibleItemsInfo = lazyListState.getLayoutInfo().getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                lazyListItemInfo = null;
                break;
            }
            lazyListItemInfo = visibleItemsInfo.get(i11);
            if (lazyListItemInfo.getIndex() == i10) {
                break;
            }
            i11++;
        }
        return lazyListItemInfo;
    }

    private static final void debugLog(h9.a<String> aVar) {
    }
}
