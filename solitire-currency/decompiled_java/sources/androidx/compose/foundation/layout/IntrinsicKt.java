package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.q;

/* JADX INFO: compiled from: Intrinsic.kt */
/* JADX INFO: loaded from: classes.dex */
public final class IntrinsicKt {

    /* JADX INFO: compiled from: Intrinsic.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IntrinsicSize.values().length];
            iArr[IntrinsicSize.Min.ordinal()] = 1;
            iArr[IntrinsicSize.Max.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Stable
    @NotNull
    public static final Modifier height(@NotNull Modifier modifier, @NotNull IntrinsicSize intrinsicSize) {
        t.i(modifier, "<this>");
        t.i(intrinsicSize, "intrinsicSize");
        int i10 = WhenMappings.$EnumSwitchMapping$0[intrinsicSize.ordinal()];
        if (i10 == 1) {
            return modifier.then(MinIntrinsicHeightModifier.INSTANCE);
        }
        if (i10 == 2) {
            return modifier.then(MaxIntrinsicHeightModifier.INSTANCE);
        }
        throw new q();
    }

    @Stable
    @NotNull
    public static final Modifier requiredHeight(@NotNull Modifier modifier, @NotNull IntrinsicSize intrinsicSize) {
        t.i(modifier, "<this>");
        t.i(intrinsicSize, "intrinsicSize");
        int i10 = WhenMappings.$EnumSwitchMapping$0[intrinsicSize.ordinal()];
        if (i10 == 1) {
            return modifier.then(RequiredMinIntrinsicHeightModifier.INSTANCE);
        }
        if (i10 == 2) {
            return modifier.then(RequiredMaxIntrinsicHeightModifier.INSTANCE);
        }
        throw new q();
    }

    @Stable
    @NotNull
    public static final Modifier requiredWidth(@NotNull Modifier modifier, @NotNull IntrinsicSize intrinsicSize) {
        t.i(modifier, "<this>");
        t.i(intrinsicSize, "intrinsicSize");
        int i10 = WhenMappings.$EnumSwitchMapping$0[intrinsicSize.ordinal()];
        if (i10 == 1) {
            return modifier.then(RequiredMinIntrinsicWidthModifier.INSTANCE);
        }
        if (i10 == 2) {
            return modifier.then(RequiredMaxIntrinsicWidthModifier.INSTANCE);
        }
        throw new q();
    }

    @Stable
    @NotNull
    public static final Modifier width(@NotNull Modifier modifier, @NotNull IntrinsicSize intrinsicSize) {
        t.i(modifier, "<this>");
        t.i(intrinsicSize, "intrinsicSize");
        int i10 = WhenMappings.$EnumSwitchMapping$0[intrinsicSize.ordinal()];
        if (i10 == 1) {
            return modifier.then(MinIntrinsicWidthModifier.INSTANCE);
        }
        if (i10 == 2) {
            return modifier.then(MaxIntrinsicWidthModifier.INSTANCE);
        }
        throw new q();
    }
}
