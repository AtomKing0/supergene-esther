package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import com.vungle.ads.internal.protos.Sdk$SDKError;
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

/* JADX INFO: compiled from: LazyGridScrolling.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyGridScrollingKt {
    private static final boolean DEBUG = false;
    private static final float TargetDistance = Dp.m3673constructorimpl(2500);
    private static final float BoundDistance = Dp.m3673constructorimpl(1500);

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridScrollingKt$doSmoothScrollToItem$3, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridScrolling.kt */
    @f(c = "androidx.compose.foundation.lazy.grid.LazyGridScrollingKt$doSmoothScrollToItem$3", f = "LazyGridScrolling.kt", l = {128, Sdk$SDKError.b.STALE_CACHED_RESPONSE_VALUE}, m = "invokeSuspend")
    static final class AnonymousClass3 extends l implements p<ScrollScope, d<? super k0>, Object> {
        final /* synthetic */ int $index;
        final /* synthetic */ int $scrollOffset;
        final /* synthetic */ int $slotsPerLine;
        final /* synthetic */ LazyGridState $this_doSmoothScrollToItem;
        float F$0;
        float F$1;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridScrollingKt$doSmoothScrollToItem$3$2, reason: invalid class name */
        /* JADX INFO: compiled from: LazyGridScrolling.kt */
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
            final /* synthetic */ LazyGridState $this_doSmoothScrollToItem;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(float f10, kotlin.jvm.internal.k0 k0Var, ScrollScope scrollScope, i0 i0Var, boolean z10, float f11, l0 l0Var, int i10, LazyGridState lazyGridState, int i11, n0<AnimationState<Float, AnimationVector1D>> n0Var) {
                super(1);
                this.$target = f10;
                this.$prevValue = k0Var;
                this.$$this$scroll = scrollScope;
                this.$loop = i0Var;
                this.$forward = z10;
                this.$boundDistancePx = f11;
                this.$loops = l0Var;
                this.$index = i10;
                this.$this_doSmoothScrollToItem = lazyGridState;
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
                LazyGridItemInfo lazyGridItemInfoDoSmoothScrollToItem$getTargetItem = LazyGridScrollingKt.doSmoothScrollToItem$getTargetItem(this.$this_doSmoothScrollToItem, this.$index);
                if (lazyGridItemInfoDoSmoothScrollToItem$getTargetItem == null) {
                    float fI = (this.$target > 0.0f ? o.i(animateTo.getValue().floatValue(), this.$target) : o.d(animateTo.getValue().floatValue(), this.$target)) - this.$prevValue.f29829a;
                    float fScrollBy = this.$$this$scroll.scrollBy(fI);
                    LazyGridItemInfo lazyGridItemInfoDoSmoothScrollToItem$getTargetItem2 = LazyGridScrollingKt.doSmoothScrollToItem$getTargetItem(this.$this_doSmoothScrollToItem, this.$index);
                    if (lazyGridItemInfoDoSmoothScrollToItem$getTargetItem2 == null && !AnonymousClass3.invokeSuspend$isOvershot(this.$forward, this.$this_doSmoothScrollToItem, this.$index, this.$scrollOffset)) {
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
                            if (this.$loops.f29831a >= 2 && this.$index - ((LazyGridItemInfo) d0.t0(this.$this_doSmoothScrollToItem.getLayoutInfo().getVisibleItemsInfo())).getIndex() > 200) {
                                this.$this_doSmoothScrollToItem.snapToItemIndexInternal$foundation_release(this.$index - 200, 0);
                            }
                        } else if (this.$loops.f29831a >= 2) {
                            int index = ((LazyGridItemInfo) d0.i0(this.$this_doSmoothScrollToItem.getLayoutInfo().getVisibleItemsInfo())).getIndex();
                            int i10 = this.$index;
                            if (index - i10 > 100) {
                                this.$this_doSmoothScrollToItem.snapToItemIndexInternal$foundation_release(i10 + 200, 0);
                            }
                        }
                    }
                    lazyGridItemInfoDoSmoothScrollToItem$getTargetItem = lazyGridItemInfoDoSmoothScrollToItem$getTargetItem2;
                }
                if (!AnonymousClass3.invokeSuspend$isOvershot(this.$forward, this.$this_doSmoothScrollToItem, this.$index, this.$scrollOffset)) {
                    if (lazyGridItemInfoDoSmoothScrollToItem$getTargetItem != null) {
                        throw new ItemFoundInScroll(lazyGridItemInfoDoSmoothScrollToItem$getTargetItem, this.$anim.f29834a);
                    }
                } else {
                    this.$this_doSmoothScrollToItem.snapToItemIndexInternal$foundation_release(this.$index, this.$scrollOffset);
                    this.$loop.f29826a = false;
                    animateTo.cancelAnimation();
                }
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridScrollingKt$doSmoothScrollToItem$3$4, reason: invalid class name */
        /* JADX INFO: compiled from: LazyGridScrolling.kt */
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
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridScrollingKt.AnonymousClass3.AnonymousClass4.invoke2(androidx.compose.animation.core.AnimationScope):void");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(LazyGridState lazyGridState, int i10, int i11, int i12, d<? super AnonymousClass3> dVar) {
            super(2, dVar);
            this.$this_doSmoothScrollToItem = lazyGridState;
            this.$index = i10;
            this.$slotsPerLine = i11;
            this.$scrollOffset = i12;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$isOvershot(boolean z10, LazyGridState lazyGridState, int i10, int i11) {
            if (z10) {
                if (lazyGridState.getFirstVisibleItemIndex() <= i10 && (lazyGridState.getFirstVisibleItemIndex() != i10 || lazyGridState.getFirstVisibleItemScrollOffset() <= i11)) {
                    return false;
                }
            } else if (lazyGridState.getFirstVisibleItemIndex() >= i10 && (lazyGridState.getFirstVisibleItemIndex() != i10 || lazyGridState.getFirstVisibleItemScrollOffset() >= i11)) {
                return false;
            }
            return true;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$this_doSmoothScrollToItem, this.$index, this.$slotsPerLine, this.$scrollOffset, dVar);
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
        /* JADX WARN: Path cross not found for [B:38:0x0107, B:37:0x0105], limit reached: 95 */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00b1 A[Catch: ItemFoundInScroll -> 0x01de, TryCatch #1 {ItemFoundInScroll -> 0x01de, blocks: (B:23:0x00ad, B:25:0x00b1, B:27:0x00bd, B:31:0x00d8, B:35:0x00ea, B:41:0x010d, B:48:0x0152, B:52:0x015b), top: B:87:0x00ad }] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00d7  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00e7  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00e9  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0107  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0148  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x014a  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x014d  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0150  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0156  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0159  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x01b7 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x01b8  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x022e  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x0231  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x0254 A[RETURN] */
        /* JADX WARN: Type inference failed for: r10v0, types: [T, androidx.compose.animation.core.AnimationState] */
        /* JADX WARN: Type inference failed for: r4v15, types: [T, androidx.compose.animation.core.AnimationState] */
        /* JADX WARN: Type inference failed for: r5v20 */
        /* JADX WARN: Type inference failed for: r5v7 */
        /* JADX WARN: Type inference failed for: r5v8, types: [int] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x01b8 -> B:95:0x01c3). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r37) {
            /*
                Method dump skipped, instruction units count: 609
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridScrollingKt.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int calculateLineAverageMainAxisSize(List<? extends LazyGridItemInfo> list, boolean z10) {
        LazyGridScrollingKt$calculateLineAverageMainAxisSize$lineOf$1 lazyGridScrollingKt$calculateLineAverageMainAxisSize$lineOf$1 = new LazyGridScrollingKt$calculateLineAverageMainAxisSize$lineOf$1(z10, list);
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < list.size()) {
            int iIntValue = lazyGridScrollingKt$calculateLineAverageMainAxisSize$lineOf$1.invoke(Integer.valueOf(i10)).intValue();
            if (iIntValue == -1) {
                i10++;
            } else {
                int iMax = 0;
                while (i10 < list.size() && lazyGridScrollingKt$calculateLineAverageMainAxisSize$lineOf$1.invoke(Integer.valueOf(i10)).intValue() == iIntValue) {
                    iMax = Math.max(iMax, z10 ? IntSize.m3832getHeightimpl(list.get(i10).mo561getSizeYbymL2g()) : IntSize.m3833getWidthimpl(list.get(i10).mo561getSizeYbymL2g()));
                    i10++;
                }
                i11 += iMax;
                i12++;
            }
        }
        return i11 / i12;
    }

    @Nullable
    public static final Object doSmoothScrollToItem(@NotNull LazyGridState lazyGridState, int i10, int i11, int i12, @NotNull d<? super k0> dVar) {
        if (((float) i10) >= 0.0f) {
            Object objA = androidx.compose.foundation.gestures.d.a(lazyGridState, null, new AnonymousClass3(lazyGridState, i10, i12, i11, null), dVar, 1, null);
            return objA == a9.d.e() ? objA : k0.f35197a;
        }
        throw new IllegalArgumentException(("Index should be non-negative (" + i10 + ')').toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LazyGridItemInfo doSmoothScrollToItem$getTargetItem(LazyGridState lazyGridState, int i10) {
        LazyGridItemInfo lazyGridItemInfo;
        List<LazyGridItemInfo> visibleItemsInfo = lazyGridState.getLayoutInfo().getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                lazyGridItemInfo = null;
                break;
            }
            lazyGridItemInfo = visibleItemsInfo.get(i11);
            if (lazyGridItemInfo.getIndex() == i10) {
                break;
            }
            i11++;
        }
        return lazyGridItemInfo;
    }

    private static final void debugLog(h9.a<String> aVar) {
    }
}
