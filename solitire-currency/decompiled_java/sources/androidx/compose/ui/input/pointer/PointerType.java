package androidx.compose.ui.input.pointer;

import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PointerEvent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PointerType {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Unknown = m2929constructorimpl(0);
    private static final int Touch = m2929constructorimpl(1);
    private static final int Mouse = m2929constructorimpl(2);
    private static final int Stylus = m2929constructorimpl(3);
    private static final int Eraser = m2929constructorimpl(4);

    /* JADX INFO: compiled from: PointerEvent.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getEraser-T8wyACA, reason: not valid java name */
        public final int m2935getEraserT8wyACA() {
            return PointerType.Eraser;
        }

        /* JADX INFO: renamed from: getMouse-T8wyACA, reason: not valid java name */
        public final int m2936getMouseT8wyACA() {
            return PointerType.Mouse;
        }

        /* JADX INFO: renamed from: getStylus-T8wyACA, reason: not valid java name */
        public final int m2937getStylusT8wyACA() {
            return PointerType.Stylus;
        }

        /* JADX INFO: renamed from: getTouch-T8wyACA, reason: not valid java name */
        public final int m2938getTouchT8wyACA() {
            return PointerType.Touch;
        }

        /* JADX INFO: renamed from: getUnknown-T8wyACA, reason: not valid java name */
        public final int m2939getUnknownT8wyACA() {
            return PointerType.Unknown;
        }
    }

    private /* synthetic */ PointerType(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PointerType m2928boximpl(int i10) {
        return new PointerType(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2930equalsimpl(int i10, Object obj) {
        return (obj instanceof PointerType) && i10 == ((PointerType) obj).m2934unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2931equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2933toStringimpl(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? "Unknown" : "Eraser" : "Stylus" : "Mouse" : "Touch";
    }

    public boolean equals(Object obj) {
        return m2930equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2932hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m2933toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2934unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m2929constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2932hashCodeimpl(int i10) {
        return i10;
    }
}
