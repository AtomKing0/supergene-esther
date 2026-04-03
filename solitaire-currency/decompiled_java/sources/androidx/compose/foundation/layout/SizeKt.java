package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Size.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SizeKt {

    @NotNull
    private static final WrapContentModifier WrapContentHeightCenter;

    @NotNull
    private static final WrapContentModifier WrapContentHeightTop;

    @NotNull
    private static final WrapContentModifier WrapContentSizeCenter;

    @NotNull
    private static final WrapContentModifier WrapContentSizeTopStart;

    @NotNull
    private static final WrapContentModifier WrapContentWidthCenter;

    @NotNull
    private static final WrapContentModifier WrapContentWidthStart;

    @NotNull
    private static final FillModifier FillWholeMaxWidth = createFillWidthModifier(1.0f);

    @NotNull
    private static final FillModifier FillWholeMaxHeight = createFillHeightModifier(1.0f);

    @NotNull
    private static final FillModifier FillWholeMaxSize = createFillSizeModifier(1.0f);

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.SizeKt$createFillHeightModifier$1, reason: invalid class name */
    /* JADX INFO: compiled from: Size.kt */
    static final class AnonymousClass1 extends v implements h9.l<InspectorInfo, k0> {
        final /* synthetic */ float $fraction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(float f10) {
            super(1);
            this.$fraction = f10;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(InspectorInfo inspectorInfo) {
            invoke2(inspectorInfo);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull InspectorInfo $receiver) {
            t.i($receiver, "$this$$receiver");
            $receiver.setName("fillMaxHeight");
            $receiver.getProperties().set("fraction", Float.valueOf(this.$fraction));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.SizeKt$createFillSizeModifier$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Size.kt */
    static final class C08591 extends v implements h9.l<InspectorInfo, k0> {
        final /* synthetic */ float $fraction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08591(float f10) {
            super(1);
            this.$fraction = f10;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(InspectorInfo inspectorInfo) {
            invoke2(inspectorInfo);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull InspectorInfo $receiver) {
            t.i($receiver, "$this$$receiver");
            $receiver.setName("fillMaxSize");
            $receiver.getProperties().set("fraction", Float.valueOf(this.$fraction));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.SizeKt$createFillWidthModifier$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Size.kt */
    static final class C08601 extends v implements h9.l<InspectorInfo, k0> {
        final /* synthetic */ float $fraction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08601(float f10) {
            super(1);
            this.$fraction = f10;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(InspectorInfo inspectorInfo) {
            invoke2(inspectorInfo);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull InspectorInfo $receiver) {
            t.i($receiver, "$this$$receiver");
            $receiver.setName("fillMaxWidth");
            $receiver.getProperties().set("fraction", Float.valueOf(this.$fraction));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.SizeKt$createWrapContentHeightModifier$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Size.kt */
    static final class C08611 extends v implements p<IntSize, LayoutDirection, IntOffset> {
        final /* synthetic */ Alignment.Vertical $align;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08611(Alignment.Vertical vertical) {
            super(2);
            this.$align = vertical;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ IntOffset mo4invoke(IntSize intSize, LayoutDirection layoutDirection) {
            return IntOffset.m3782boximpl(m448invoke5SAbXVA(intSize.m3837unboximpl(), layoutDirection));
        }

        /* JADX INFO: renamed from: invoke-5SAbXVA, reason: not valid java name */
        public final long m448invoke5SAbXVA(long j10, @NotNull LayoutDirection layoutDirection) {
            t.i(layoutDirection, "<anonymous parameter 1>");
            return IntOffsetKt.IntOffset(0, this.$align.align(0, IntSize.m3832getHeightimpl(j10)));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.SizeKt$createWrapContentHeightModifier$2, reason: invalid class name */
    /* JADX INFO: compiled from: Size.kt */
    static final class AnonymousClass2 extends v implements h9.l<InspectorInfo, k0> {
        final /* synthetic */ Alignment.Vertical $align;
        final /* synthetic */ boolean $unbounded;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Alignment.Vertical vertical, boolean z10) {
            super(1);
            this.$align = vertical;
            this.$unbounded = z10;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(InspectorInfo inspectorInfo) {
            invoke2(inspectorInfo);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull InspectorInfo $receiver) {
            t.i($receiver, "$this$$receiver");
            $receiver.setName("wrapContentHeight");
            $receiver.getProperties().set("align", this.$align);
            $receiver.getProperties().set("unbounded", Boolean.valueOf(this.$unbounded));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.SizeKt$createWrapContentSizeModifier$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Size.kt */
    static final class C08621 extends v implements p<IntSize, LayoutDirection, IntOffset> {
        final /* synthetic */ Alignment $align;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08621(Alignment alignment) {
            super(2);
            this.$align = alignment;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ IntOffset mo4invoke(IntSize intSize, LayoutDirection layoutDirection) {
            return IntOffset.m3782boximpl(m449invoke5SAbXVA(intSize.m3837unboximpl(), layoutDirection));
        }

        /* JADX INFO: renamed from: invoke-5SAbXVA, reason: not valid java name */
        public final long m449invoke5SAbXVA(long j10, @NotNull LayoutDirection layoutDirection) {
            t.i(layoutDirection, "layoutDirection");
            return this.$align.mo1275alignKFBX0sM(IntSize.Companion.m3838getZeroYbymL2g(), j10, layoutDirection);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.SizeKt$createWrapContentSizeModifier$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Size.kt */
    static final class C08632 extends v implements h9.l<InspectorInfo, k0> {
        final /* synthetic */ Alignment $align;
        final /* synthetic */ boolean $unbounded;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08632(Alignment alignment, boolean z10) {
            super(1);
            this.$align = alignment;
            this.$unbounded = z10;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(InspectorInfo inspectorInfo) {
            invoke2(inspectorInfo);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull InspectorInfo $receiver) {
            t.i($receiver, "$this$$receiver");
            $receiver.setName("wrapContentSize");
            $receiver.getProperties().set("align", this.$align);
            $receiver.getProperties().set("unbounded", Boolean.valueOf(this.$unbounded));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.SizeKt$createWrapContentWidthModifier$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Size.kt */
    static final class C08641 extends v implements p<IntSize, LayoutDirection, IntOffset> {
        final /* synthetic */ Alignment.Horizontal $align;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08641(Alignment.Horizontal horizontal) {
            super(2);
            this.$align = horizontal;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ IntOffset mo4invoke(IntSize intSize, LayoutDirection layoutDirection) {
            return IntOffset.m3782boximpl(m450invoke5SAbXVA(intSize.m3837unboximpl(), layoutDirection));
        }

        /* JADX INFO: renamed from: invoke-5SAbXVA, reason: not valid java name */
        public final long m450invoke5SAbXVA(long j10, @NotNull LayoutDirection layoutDirection) {
            t.i(layoutDirection, "layoutDirection");
            return IntOffsetKt.IntOffset(this.$align.align(0, IntSize.m3833getWidthimpl(j10), layoutDirection), 0);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.SizeKt$createWrapContentWidthModifier$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Size.kt */
    static final class C08652 extends v implements h9.l<InspectorInfo, k0> {
        final /* synthetic */ Alignment.Horizontal $align;
        final /* synthetic */ boolean $unbounded;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08652(Alignment.Horizontal horizontal, boolean z10) {
            super(1);
            this.$align = horizontal;
            this.$unbounded = z10;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(InspectorInfo inspectorInfo) {
            invoke2(inspectorInfo);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull InspectorInfo $receiver) {
            t.i($receiver, "$this$$receiver");
            $receiver.setName("wrapContentWidth");
            $receiver.getProperties().set("align", this.$align);
            $receiver.getProperties().set("unbounded", Boolean.valueOf(this.$unbounded));
        }
    }

    static {
        Alignment.Companion companion = Alignment.Companion;
        WrapContentWidthCenter = createWrapContentWidthModifier(companion.getCenterHorizontally(), false);
        WrapContentWidthStart = createWrapContentWidthModifier(companion.getStart(), false);
        WrapContentHeightCenter = createWrapContentHeightModifier(companion.getCenterVertically(), false);
        WrapContentHeightTop = createWrapContentHeightModifier(companion.getTop(), false);
        WrapContentSizeCenter = createWrapContentSizeModifier(companion.getCenter(), false);
        WrapContentSizeTopStart = createWrapContentSizeModifier(companion.getTopStart(), false);
    }

    private static final FillModifier createFillHeightModifier(float f10) {
        return new FillModifier(Direction.Vertical, f10, new AnonymousClass1(f10));
    }

    private static final FillModifier createFillSizeModifier(float f10) {
        return new FillModifier(Direction.Both, f10, new C08591(f10));
    }

    private static final FillModifier createFillWidthModifier(float f10) {
        return new FillModifier(Direction.Horizontal, f10, new C08601(f10));
    }

    private static final WrapContentModifier createWrapContentHeightModifier(Alignment.Vertical vertical, boolean z10) {
        return new WrapContentModifier(Direction.Vertical, z10, new C08611(vertical), vertical, new AnonymousClass2(vertical, z10));
    }

    private static final WrapContentModifier createWrapContentSizeModifier(Alignment alignment, boolean z10) {
        return new WrapContentModifier(Direction.Both, z10, new C08621(alignment), alignment, new C08632(alignment, z10));
    }

    private static final WrapContentModifier createWrapContentWidthModifier(Alignment.Horizontal horizontal, boolean z10) {
        return new WrapContentModifier(Direction.Horizontal, z10, new C08641(horizontal), horizontal, new C08652(horizontal, z10));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: defaultMinSize-VpY3zN4, reason: not valid java name */
    public static final Modifier m424defaultMinSizeVpY3zN4(@NotNull Modifier defaultMinSize, float f10, float f11) {
        t.i(defaultMinSize, "$this$defaultMinSize");
        return defaultMinSize.then(new UnspecifiedConstraintsModifier(f10, f11, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$defaultMinSizeVpY3zN4$$inlined$debugInspectorInfo$1(f10, f11) : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: defaultMinSize-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m425defaultMinSizeVpY3zN4$default(Modifier modifier, float f10, float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = Dp.Companion.m3693getUnspecifiedD9Ej5fM();
        }
        if ((i10 & 2) != 0) {
            f11 = Dp.Companion.m3693getUnspecifiedD9Ej5fM();
        }
        return m424defaultMinSizeVpY3zN4(modifier, f10, f11);
    }

    @Stable
    @NotNull
    public static final Modifier fillMaxHeight(@NotNull Modifier modifier, float f10) {
        t.i(modifier, "<this>");
        return modifier.then((f10 > 1.0f ? 1 : (f10 == 1.0f ? 0 : -1)) == 0 ? FillWholeMaxHeight : createFillHeightModifier(f10));
    }

    public static /* synthetic */ Modifier fillMaxHeight$default(Modifier modifier, float f10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 1.0f;
        }
        return fillMaxHeight(modifier, f10);
    }

    @Stable
    @NotNull
    public static final Modifier fillMaxSize(@NotNull Modifier modifier, float f10) {
        t.i(modifier, "<this>");
        return modifier.then((f10 > 1.0f ? 1 : (f10 == 1.0f ? 0 : -1)) == 0 ? FillWholeMaxSize : createFillSizeModifier(f10));
    }

    public static /* synthetic */ Modifier fillMaxSize$default(Modifier modifier, float f10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 1.0f;
        }
        return fillMaxSize(modifier, f10);
    }

    @Stable
    @NotNull
    public static final Modifier fillMaxWidth(@NotNull Modifier modifier, float f10) {
        t.i(modifier, "<this>");
        return modifier.then((f10 > 1.0f ? 1 : (f10 == 1.0f ? 0 : -1)) == 0 ? FillWholeMaxWidth : createFillWidthModifier(f10));
    }

    public static /* synthetic */ Modifier fillMaxWidth$default(Modifier modifier, float f10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 1.0f;
        }
        return fillMaxWidth(modifier, f10);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: height-3ABfNKs, reason: not valid java name */
    public static final Modifier m426height3ABfNKs(@NotNull Modifier height, float f10) {
        t.i(height, "$this$height");
        return height.then(new SizeModifier(0.0f, f10, 0.0f, f10, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$height3ABfNKs$$inlined$debugInspectorInfo$1(f10) : InspectableValueKt.getNoInspectorInfo(), 5, null));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: heightIn-VpY3zN4, reason: not valid java name */
    public static final Modifier m427heightInVpY3zN4(@NotNull Modifier heightIn, float f10, float f11) {
        t.i(heightIn, "$this$heightIn");
        return heightIn.then(new SizeModifier(0.0f, f10, 0.0f, f11, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$heightInVpY3zN4$$inlined$debugInspectorInfo$1(f10, f11) : InspectableValueKt.getNoInspectorInfo(), 5, null));
    }

    /* JADX INFO: renamed from: heightIn-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m428heightInVpY3zN4$default(Modifier modifier, float f10, float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = Dp.Companion.m3693getUnspecifiedD9Ej5fM();
        }
        if ((i10 & 2) != 0) {
            f11 = Dp.Companion.m3693getUnspecifiedD9Ej5fM();
        }
        return m427heightInVpY3zN4(modifier, f10, f11);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: requiredHeight-3ABfNKs, reason: not valid java name */
    public static final Modifier m429requiredHeight3ABfNKs(@NotNull Modifier requiredHeight, float f10) {
        t.i(requiredHeight, "$this$requiredHeight");
        return requiredHeight.then(new SizeModifier(0.0f, f10, 0.0f, f10, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredHeight3ABfNKs$$inlined$debugInspectorInfo$1(f10) : InspectableValueKt.getNoInspectorInfo(), 5, null));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: requiredHeightIn-VpY3zN4, reason: not valid java name */
    public static final Modifier m430requiredHeightInVpY3zN4(@NotNull Modifier requiredHeightIn, float f10, float f11) {
        t.i(requiredHeightIn, "$this$requiredHeightIn");
        return requiredHeightIn.then(new SizeModifier(0.0f, f10, 0.0f, f11, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredHeightInVpY3zN4$$inlined$debugInspectorInfo$1(f10, f11) : InspectableValueKt.getNoInspectorInfo(), 5, null));
    }

    /* JADX INFO: renamed from: requiredHeightIn-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m431requiredHeightInVpY3zN4$default(Modifier modifier, float f10, float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = Dp.Companion.m3693getUnspecifiedD9Ej5fM();
        }
        if ((i10 & 2) != 0) {
            f11 = Dp.Companion.m3693getUnspecifiedD9Ej5fM();
        }
        return m430requiredHeightInVpY3zN4(modifier, f10, f11);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: requiredSize-3ABfNKs, reason: not valid java name */
    public static final Modifier m432requiredSize3ABfNKs(@NotNull Modifier requiredSize, float f10) {
        t.i(requiredSize, "$this$requiredSize");
        return requiredSize.then(new SizeModifier(f10, f10, f10, f10, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredSize3ABfNKs$$inlined$debugInspectorInfo$1(f10) : InspectableValueKt.getNoInspectorInfo(), null));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: requiredSize-6HolHcs, reason: not valid java name */
    public static final Modifier m433requiredSize6HolHcs(@NotNull Modifier requiredSize, long j10) {
        t.i(requiredSize, "$this$requiredSize");
        return m434requiredSizeVpY3zN4(requiredSize, DpSize.m3771getWidthD9Ej5fM(j10), DpSize.m3769getHeightD9Ej5fM(j10));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: requiredSize-VpY3zN4, reason: not valid java name */
    public static final Modifier m434requiredSizeVpY3zN4(@NotNull Modifier requiredSize, float f10, float f11) {
        t.i(requiredSize, "$this$requiredSize");
        return requiredSize.then(new SizeModifier(f10, f11, f10, f11, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredSizeVpY3zN4$$inlined$debugInspectorInfo$1(f10, f11) : InspectableValueKt.getNoInspectorInfo(), null));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: requiredSizeIn-qDBjuR0, reason: not valid java name */
    public static final Modifier m435requiredSizeInqDBjuR0(@NotNull Modifier requiredSizeIn, float f10, float f11, float f12, float f13) {
        t.i(requiredSizeIn, "$this$requiredSizeIn");
        return requiredSizeIn.then(new SizeModifier(f10, f11, f12, f13, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredSizeInqDBjuR0$$inlined$debugInspectorInfo$1(f10, f11, f12, f13) : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: requiredSizeIn-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m436requiredSizeInqDBjuR0$default(Modifier modifier, float f10, float f11, float f12, float f13, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = Dp.Companion.m3693getUnspecifiedD9Ej5fM();
        }
        if ((i10 & 2) != 0) {
            f11 = Dp.Companion.m3693getUnspecifiedD9Ej5fM();
        }
        if ((i10 & 4) != 0) {
            f12 = Dp.Companion.m3693getUnspecifiedD9Ej5fM();
        }
        if ((i10 & 8) != 0) {
            f13 = Dp.Companion.m3693getUnspecifiedD9Ej5fM();
        }
        return m435requiredSizeInqDBjuR0(modifier, f10, f11, f12, f13);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: requiredWidth-3ABfNKs, reason: not valid java name */
    public static final Modifier m437requiredWidth3ABfNKs(@NotNull Modifier requiredWidth, float f10) {
        t.i(requiredWidth, "$this$requiredWidth");
        return requiredWidth.then(new SizeModifier(f10, 0.0f, f10, 0.0f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredWidth3ABfNKs$$inlined$debugInspectorInfo$1(f10) : InspectableValueKt.getNoInspectorInfo(), 10, null));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: requiredWidthIn-VpY3zN4, reason: not valid java name */
    public static final Modifier m438requiredWidthInVpY3zN4(@NotNull Modifier requiredWidthIn, float f10, float f11) {
        t.i(requiredWidthIn, "$this$requiredWidthIn");
        return requiredWidthIn.then(new SizeModifier(f10, 0.0f, f11, 0.0f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredWidthInVpY3zN4$$inlined$debugInspectorInfo$1(f10, f11) : InspectableValueKt.getNoInspectorInfo(), 10, null));
    }

    /* JADX INFO: renamed from: requiredWidthIn-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m439requiredWidthInVpY3zN4$default(Modifier modifier, float f10, float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = Dp.Companion.m3693getUnspecifiedD9Ej5fM();
        }
        if ((i10 & 2) != 0) {
            f11 = Dp.Companion.m3693getUnspecifiedD9Ej5fM();
        }
        return m438requiredWidthInVpY3zN4(modifier, f10, f11);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: size-3ABfNKs, reason: not valid java name */
    public static final Modifier m440size3ABfNKs(@NotNull Modifier size, float f10) {
        t.i(size, "$this$size");
        return size.then(new SizeModifier(f10, f10, f10, f10, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$size3ABfNKs$$inlined$debugInspectorInfo$1(f10) : InspectableValueKt.getNoInspectorInfo(), null));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: size-6HolHcs, reason: not valid java name */
    public static final Modifier m441size6HolHcs(@NotNull Modifier size, long j10) {
        t.i(size, "$this$size");
        return m442sizeVpY3zN4(size, DpSize.m3771getWidthD9Ej5fM(j10), DpSize.m3769getHeightD9Ej5fM(j10));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: size-VpY3zN4, reason: not valid java name */
    public static final Modifier m442sizeVpY3zN4(@NotNull Modifier size, float f10, float f11) {
        t.i(size, "$this$size");
        return size.then(new SizeModifier(f10, f11, f10, f11, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$sizeVpY3zN4$$inlined$debugInspectorInfo$1(f10, f11) : InspectableValueKt.getNoInspectorInfo(), null));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: sizeIn-qDBjuR0, reason: not valid java name */
    public static final Modifier m443sizeInqDBjuR0(@NotNull Modifier sizeIn, float f10, float f11, float f12, float f13) {
        t.i(sizeIn, "$this$sizeIn");
        return sizeIn.then(new SizeModifier(f10, f11, f12, f13, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$sizeInqDBjuR0$$inlined$debugInspectorInfo$1(f10, f11, f12, f13) : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: sizeIn-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m444sizeInqDBjuR0$default(Modifier modifier, float f10, float f11, float f12, float f13, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = Dp.Companion.m3693getUnspecifiedD9Ej5fM();
        }
        if ((i10 & 2) != 0) {
            f11 = Dp.Companion.m3693getUnspecifiedD9Ej5fM();
        }
        if ((i10 & 4) != 0) {
            f12 = Dp.Companion.m3693getUnspecifiedD9Ej5fM();
        }
        if ((i10 & 8) != 0) {
            f13 = Dp.Companion.m3693getUnspecifiedD9Ej5fM();
        }
        return m443sizeInqDBjuR0(modifier, f10, f11, f12, f13);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: width-3ABfNKs, reason: not valid java name */
    public static final Modifier m445width3ABfNKs(@NotNull Modifier width, float f10) {
        t.i(width, "$this$width");
        return width.then(new SizeModifier(f10, 0.0f, f10, 0.0f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$width3ABfNKs$$inlined$debugInspectorInfo$1(f10) : InspectableValueKt.getNoInspectorInfo(), 10, null));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: widthIn-VpY3zN4, reason: not valid java name */
    public static final Modifier m446widthInVpY3zN4(@NotNull Modifier widthIn, float f10, float f11) {
        t.i(widthIn, "$this$widthIn");
        return widthIn.then(new SizeModifier(f10, 0.0f, f11, 0.0f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$widthInVpY3zN4$$inlined$debugInspectorInfo$1(f10, f11) : InspectableValueKt.getNoInspectorInfo(), 10, null));
    }

    /* JADX INFO: renamed from: widthIn-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m447widthInVpY3zN4$default(Modifier modifier, float f10, float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = Dp.Companion.m3693getUnspecifiedD9Ej5fM();
        }
        if ((i10 & 2) != 0) {
            f11 = Dp.Companion.m3693getUnspecifiedD9Ej5fM();
        }
        return m446widthInVpY3zN4(modifier, f10, f11);
    }

    @Stable
    @NotNull
    public static final Modifier wrapContentHeight(@NotNull Modifier modifier, @NotNull Alignment.Vertical align, boolean z10) {
        t.i(modifier, "<this>");
        t.i(align, "align");
        Alignment.Companion companion = Alignment.Companion;
        return modifier.then((!t.d(align, companion.getCenterVertically()) || z10) ? (!t.d(align, companion.getTop()) || z10) ? createWrapContentHeightModifier(align, z10) : WrapContentHeightTop : WrapContentHeightCenter);
    }

    public static /* synthetic */ Modifier wrapContentHeight$default(Modifier modifier, Alignment.Vertical vertical, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            vertical = Alignment.Companion.getCenterVertically();
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return wrapContentHeight(modifier, vertical, z10);
    }

    @Stable
    @NotNull
    public static final Modifier wrapContentSize(@NotNull Modifier modifier, @NotNull Alignment align, boolean z10) {
        t.i(modifier, "<this>");
        t.i(align, "align");
        Alignment.Companion companion = Alignment.Companion;
        return modifier.then((!t.d(align, companion.getCenter()) || z10) ? (!t.d(align, companion.getTopStart()) || z10) ? createWrapContentSizeModifier(align, z10) : WrapContentSizeTopStart : WrapContentSizeCenter);
    }

    public static /* synthetic */ Modifier wrapContentSize$default(Modifier modifier, Alignment alignment, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            alignment = Alignment.Companion.getCenter();
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return wrapContentSize(modifier, alignment, z10);
    }

    @Stable
    @NotNull
    public static final Modifier wrapContentWidth(@NotNull Modifier modifier, @NotNull Alignment.Horizontal align, boolean z10) {
        t.i(modifier, "<this>");
        t.i(align, "align");
        Alignment.Companion companion = Alignment.Companion;
        return modifier.then((!t.d(align, companion.getCenterHorizontally()) || z10) ? (!t.d(align, companion.getStart()) || z10) ? createWrapContentWidthModifier(align, z10) : WrapContentWidthStart : WrapContentWidthCenter);
    }

    public static /* synthetic */ Modifier wrapContentWidth$default(Modifier modifier, Alignment.Horizontal horizontal, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            horizontal = Alignment.Companion.getCenterHorizontally();
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return wrapContentWidth(modifier, horizontal, z10);
    }
}
