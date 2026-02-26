package androidx.compose.material;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class Strings {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int NavigationMenu = m1132constructorimpl(0);
    private static final int CloseDrawer = m1132constructorimpl(1);
    private static final int CloseSheet = m1132constructorimpl(2);
    private static final int DefaultErrorMessage = m1132constructorimpl(3);
    private static final int ExposedDropdownMenu = m1132constructorimpl(4);
    private static final int SliderRangeStart = m1132constructorimpl(5);
    private static final int SliderRangeEnd = m1132constructorimpl(6);

    /* JADX INFO: compiled from: Strings.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getCloseDrawer-UdPEhr4, reason: not valid java name */
        public final int m1138getCloseDrawerUdPEhr4() {
            return Strings.CloseDrawer;
        }

        /* JADX INFO: renamed from: getCloseSheet-UdPEhr4, reason: not valid java name */
        public final int m1139getCloseSheetUdPEhr4() {
            return Strings.CloseSheet;
        }

        /* JADX INFO: renamed from: getDefaultErrorMessage-UdPEhr4, reason: not valid java name */
        public final int m1140getDefaultErrorMessageUdPEhr4() {
            return Strings.DefaultErrorMessage;
        }

        /* JADX INFO: renamed from: getExposedDropdownMenu-UdPEhr4, reason: not valid java name */
        public final int m1141getExposedDropdownMenuUdPEhr4() {
            return Strings.ExposedDropdownMenu;
        }

        /* JADX INFO: renamed from: getNavigationMenu-UdPEhr4, reason: not valid java name */
        public final int m1142getNavigationMenuUdPEhr4() {
            return Strings.NavigationMenu;
        }

        /* JADX INFO: renamed from: getSliderRangeEnd-UdPEhr4, reason: not valid java name */
        public final int m1143getSliderRangeEndUdPEhr4() {
            return Strings.SliderRangeEnd;
        }

        /* JADX INFO: renamed from: getSliderRangeStart-UdPEhr4, reason: not valid java name */
        public final int m1144getSliderRangeStartUdPEhr4() {
            return Strings.SliderRangeStart;
        }
    }

    private /* synthetic */ Strings(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Strings m1131boximpl(int i10) {
        return new Strings(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1133equalsimpl(int i10, Object obj) {
        return (obj instanceof Strings) && i10 == ((Strings) obj).m1137unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1134equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1136toStringimpl(int i10) {
        return "Strings(value=" + i10 + ')';
    }

    public boolean equals(Object obj) {
        return m1133equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1135hashCodeimpl(this.value);
    }

    public String toString() {
        return m1136toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1137unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m1132constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1135hashCodeimpl(int i10) {
        return i10;
    }
}
