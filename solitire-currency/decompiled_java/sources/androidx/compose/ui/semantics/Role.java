package androidx.compose.ui.semantics;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SemanticsProperties.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class Role {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Button = m3228constructorimpl(0);
    private static final int Checkbox = m3228constructorimpl(1);
    private static final int Switch = m3228constructorimpl(2);
    private static final int RadioButton = m3228constructorimpl(3);
    private static final int Tab = m3228constructorimpl(4);
    private static final int Image = m3228constructorimpl(5);

    /* JADX INFO: compiled from: SemanticsProperties.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getButton-o7Vup1c, reason: not valid java name */
        public final int m3234getButtono7Vup1c() {
            return Role.Button;
        }

        /* JADX INFO: renamed from: getCheckbox-o7Vup1c, reason: not valid java name */
        public final int m3235getCheckboxo7Vup1c() {
            return Role.Checkbox;
        }

        /* JADX INFO: renamed from: getImage-o7Vup1c, reason: not valid java name */
        public final int m3236getImageo7Vup1c() {
            return Role.Image;
        }

        /* JADX INFO: renamed from: getRadioButton-o7Vup1c, reason: not valid java name */
        public final int m3237getRadioButtono7Vup1c() {
            return Role.RadioButton;
        }

        /* JADX INFO: renamed from: getSwitch-o7Vup1c, reason: not valid java name */
        public final int m3238getSwitcho7Vup1c() {
            return Role.Switch;
        }

        /* JADX INFO: renamed from: getTab-o7Vup1c, reason: not valid java name */
        public final int m3239getTabo7Vup1c() {
            return Role.Tab;
        }
    }

    private /* synthetic */ Role(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Role m3227boximpl(int i10) {
        return new Role(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3229equalsimpl(int i10, Object obj) {
        return (obj instanceof Role) && i10 == ((Role) obj).m3233unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3230equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3232toStringimpl(int i10) {
        return m3230equalsimpl0(i10, Button) ? "Button" : m3230equalsimpl0(i10, Checkbox) ? "Checkbox" : m3230equalsimpl0(i10, Switch) ? "Switch" : m3230equalsimpl0(i10, RadioButton) ? "RadioButton" : m3230equalsimpl0(i10, Tab) ? "Tab" : m3230equalsimpl0(i10, Image) ? "Image" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m3229equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3231hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m3232toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3233unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m3228constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3231hashCodeimpl(int i10) {
        return i10;
    }
}
