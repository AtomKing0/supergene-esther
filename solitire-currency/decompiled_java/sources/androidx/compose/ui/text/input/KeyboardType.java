package androidx.compose.ui.text.input;

import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: KeyboardType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class KeyboardType {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Text = m3490constructorimpl(1);
    private static final int Ascii = m3490constructorimpl(2);
    private static final int Number = m3490constructorimpl(3);
    private static final int Phone = m3490constructorimpl(4);
    private static final int Uri = m3490constructorimpl(5);
    private static final int Email = m3490constructorimpl(6);
    private static final int Password = m3490constructorimpl(7);
    private static final int NumberPassword = m3490constructorimpl(8);
    private static final int Decimal = m3490constructorimpl(9);

    /* JADX INFO: compiled from: KeyboardType.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getAscii-PjHm6EE, reason: not valid java name */
        public final int m3496getAsciiPjHm6EE() {
            return KeyboardType.Ascii;
        }

        /* JADX INFO: renamed from: getDecimal-PjHm6EE, reason: not valid java name */
        public final int m3497getDecimalPjHm6EE() {
            return KeyboardType.Decimal;
        }

        /* JADX INFO: renamed from: getEmail-PjHm6EE, reason: not valid java name */
        public final int m3498getEmailPjHm6EE() {
            return KeyboardType.Email;
        }

        /* JADX INFO: renamed from: getNumber-PjHm6EE, reason: not valid java name */
        public final int m3499getNumberPjHm6EE() {
            return KeyboardType.Number;
        }

        /* JADX INFO: renamed from: getNumberPassword-PjHm6EE, reason: not valid java name */
        public final int m3500getNumberPasswordPjHm6EE() {
            return KeyboardType.NumberPassword;
        }

        /* JADX INFO: renamed from: getPassword-PjHm6EE, reason: not valid java name */
        public final int m3501getPasswordPjHm6EE() {
            return KeyboardType.Password;
        }

        /* JADX INFO: renamed from: getPhone-PjHm6EE, reason: not valid java name */
        public final int m3502getPhonePjHm6EE() {
            return KeyboardType.Phone;
        }

        /* JADX INFO: renamed from: getText-PjHm6EE, reason: not valid java name */
        public final int m3503getTextPjHm6EE() {
            return KeyboardType.Text;
        }

        /* JADX INFO: renamed from: getUri-PjHm6EE, reason: not valid java name */
        public final int m3504getUriPjHm6EE() {
            return KeyboardType.Uri;
        }
    }

    private /* synthetic */ KeyboardType(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ KeyboardType m3489boximpl(int i10) {
        return new KeyboardType(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3491equalsimpl(int i10, Object obj) {
        return (obj instanceof KeyboardType) && i10 == ((KeyboardType) obj).m3495unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3492equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3494toStringimpl(int i10) {
        return m3492equalsimpl0(i10, Text) ? "Text" : m3492equalsimpl0(i10, Ascii) ? "Ascii" : m3492equalsimpl0(i10, Number) ? "Number" : m3492equalsimpl0(i10, Phone) ? "Phone" : m3492equalsimpl0(i10, Uri) ? "Uri" : m3492equalsimpl0(i10, Email) ? "Email" : m3492equalsimpl0(i10, Password) ? "Password" : m3492equalsimpl0(i10, NumberPassword) ? "NumberPassword" : m3492equalsimpl0(i10, Decimal) ? "Decimal" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m3491equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3493hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m3494toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3495unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m3490constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3493hashCodeimpl(int i10) {
        return i10;
    }
}
