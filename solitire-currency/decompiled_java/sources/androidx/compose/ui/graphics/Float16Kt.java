package androidx.compose.ui.graphics;

/* JADX INFO: compiled from: Float16.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Float16Kt {
    /* JADX INFO: renamed from: max-AoSsdG0, reason: not valid java name */
    public static final short m1730maxAoSsdG0(short s10, short s11) {
        return (Float16.m1703isNaNimpl(s10) || Float16.m1703isNaNimpl(s11)) ? Float16.Companion.m1725getNaNslo4al4() : Float16.m1690compareTo41bOqos(s10, s11) >= 0 ? s10 : s11;
    }

    /* JADX INFO: renamed from: min-AoSsdG0, reason: not valid java name */
    public static final short m1731minAoSsdG0(short s10, short s11) {
        return (Float16.m1703isNaNimpl(s10) || Float16.m1703isNaNimpl(s11)) ? Float16.Companion.m1725getNaNslo4al4() : Float16.m1690compareTo41bOqos(s10, s11) <= 0 ? s10 : s11;
    }
}
