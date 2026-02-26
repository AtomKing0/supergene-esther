package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import h9.p;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WindowInsetsSize.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsSizeKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.WindowInsetsSizeKt$windowInsetsBottomHeight$2, reason: invalid class name */
    /* JADX INFO: compiled from: WindowInsetsSize.kt */
    static final class AnonymousClass2 extends v implements p<WindowInsets, Density, Integer> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(2);
        }

        @Override // h9.p
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Integer mo4invoke(@NotNull WindowInsets $receiver, @NotNull Density it) {
            t.i($receiver, "$this$$receiver");
            t.i(it, "it");
            return Integer.valueOf($receiver.getBottom(it));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.WindowInsetsSizeKt$windowInsetsEndWidth$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WindowInsetsSize.kt */
    static final class C08682 extends v implements q<WindowInsets, LayoutDirection, Density, Integer> {
        public static final C08682 INSTANCE = new C08682();

        C08682() {
            super(3);
        }

        @Override // h9.q
        @NotNull
        public final Integer invoke(@NotNull WindowInsets $receiver, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
            t.i($receiver, "$this$$receiver");
            t.i(layoutDirection, "layoutDirection");
            t.i(density, "density");
            return Integer.valueOf(layoutDirection == LayoutDirection.Rtl ? $receiver.getLeft(density, layoutDirection) : $receiver.getRight(density, layoutDirection));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.WindowInsetsSizeKt$windowInsetsStartWidth$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WindowInsetsSize.kt */
    static final class C08692 extends v implements q<WindowInsets, LayoutDirection, Density, Integer> {
        public static final C08692 INSTANCE = new C08692();

        C08692() {
            super(3);
        }

        @Override // h9.q
        @NotNull
        public final Integer invoke(@NotNull WindowInsets $receiver, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
            t.i($receiver, "$this$$receiver");
            t.i(layoutDirection, "layoutDirection");
            t.i(density, "density");
            return Integer.valueOf(layoutDirection == LayoutDirection.Ltr ? $receiver.getLeft(density, layoutDirection) : $receiver.getRight(density, layoutDirection));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.WindowInsetsSizeKt$windowInsetsTopHeight$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WindowInsetsSize.kt */
    static final class C08702 extends v implements p<WindowInsets, Density, Integer> {
        public static final C08702 INSTANCE = new C08702();

        C08702() {
            super(2);
        }

        @Override // h9.p
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Integer mo4invoke(@NotNull WindowInsets $receiver, @NotNull Density it) {
            t.i($receiver, "$this$$receiver");
            t.i(it, "it");
            return Integer.valueOf($receiver.getTop(it));
        }
    }

    @Stable
    @NotNull
    public static final Modifier windowInsetsBottomHeight(@NotNull Modifier modifier, @NotNull WindowInsets insets) {
        t.i(modifier, "<this>");
        t.i(insets, "insets");
        return modifier.then(new DerivedHeightModifier(insets, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsSizeKt$windowInsetsBottomHeight$$inlined$debugInspectorInfo$1(insets) : InspectableValueKt.getNoInspectorInfo(), AnonymousClass2.INSTANCE));
    }

    @Stable
    @NotNull
    public static final Modifier windowInsetsEndWidth(@NotNull Modifier modifier, @NotNull WindowInsets insets) {
        t.i(modifier, "<this>");
        t.i(insets, "insets");
        return modifier.then(new DerivedWidthModifier(insets, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsSizeKt$windowInsetsEndWidth$$inlined$debugInspectorInfo$1(insets) : InspectableValueKt.getNoInspectorInfo(), C08682.INSTANCE));
    }

    @Stable
    @NotNull
    public static final Modifier windowInsetsStartWidth(@NotNull Modifier modifier, @NotNull WindowInsets insets) {
        t.i(modifier, "<this>");
        t.i(insets, "insets");
        return modifier.then(new DerivedWidthModifier(insets, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsSizeKt$windowInsetsStartWidth$$inlined$debugInspectorInfo$1(insets) : InspectableValueKt.getNoInspectorInfo(), C08692.INSTANCE));
    }

    @Stable
    @NotNull
    public static final Modifier windowInsetsTopHeight(@NotNull Modifier modifier, @NotNull WindowInsets insets) {
        t.i(modifier, "<this>");
        t.i(insets, "insets");
        return modifier.then(new DerivedHeightModifier(insets, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsSizeKt$windowInsetsTopHeight$$inlined$debugInspectorInfo$1(insets) : InspectableValueKt.getNoInspectorInfo(), C08702.INSTANCE));
    }
}
