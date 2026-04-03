package androidx.compose.ui.unit;

import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextUnit.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextUnitType {
    private final long type;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long Unspecified = m3880constructorimpl(0);
    private static final long Sp = m3880constructorimpl(4294967296L);
    private static final long Em = m3880constructorimpl(8589934592L);

    /* JADX INFO: compiled from: TextUnit.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getEm-UIouoOA, reason: not valid java name */
        public final long m3886getEmUIouoOA() {
            return TextUnitType.Em;
        }

        /* JADX INFO: renamed from: getSp-UIouoOA, reason: not valid java name */
        public final long m3887getSpUIouoOA() {
            return TextUnitType.Sp;
        }

        /* JADX INFO: renamed from: getUnspecified-UIouoOA, reason: not valid java name */
        public final long m3888getUnspecifiedUIouoOA() {
            return TextUnitType.Unspecified;
        }
    }

    private /* synthetic */ TextUnitType(long j10) {
        this.type = j10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextUnitType m3879boximpl(long j10) {
        return new TextUnitType(j10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3881equalsimpl(long j10, Object obj) {
        return (obj instanceof TextUnitType) && j10 == ((TextUnitType) obj).m3885unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3882equalsimpl0(long j10, long j11) {
        return j10 == j11;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3883hashCodeimpl(long j10) {
        return androidx.compose.animation.a.a(j10);
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3884toStringimpl(long j10) {
        return m3882equalsimpl0(j10, Unspecified) ? "Unspecified" : m3882equalsimpl0(j10, Sp) ? "Sp" : m3882equalsimpl0(j10, Em) ? "Em" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m3881equalsimpl(this.type, obj);
    }

    public int hashCode() {
        return m3883hashCodeimpl(this.type);
    }

    @NotNull
    public String toString() {
        return m3884toStringimpl(this.type);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m3885unboximpl() {
        return this.type;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m3880constructorimpl(long j10) {
        return j10;
    }
}
