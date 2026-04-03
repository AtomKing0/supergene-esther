package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextUnit.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextUnitKt {
    private static final long UNIT_MASK = 1095216660480L;
    private static final long UNIT_TYPE_EM = 8589934592L;
    private static final long UNIT_TYPE_SP = 4294967296L;
    private static final long UNIT_TYPE_UNSPECIFIED = 0;

    @ExperimentalUnitApi
    /* JADX INFO: renamed from: TextUnit-anM5pPY, reason: not valid java name */
    public static final long m3866TextUnitanM5pPY(float f10, long j10) {
        return pack(j10, f10);
    }

    /* JADX INFO: renamed from: checkArithmetic--R2X_6o, reason: not valid java name */
    public static final void m3867checkArithmeticR2X_6o(long j10) {
        if (!(!m3872isUnspecifiedR2X_6o(j10))) {
            throw new IllegalArgumentException("Cannot perform operation for Unspecified type.".toString());
        }
    }

    /* JADX INFO: renamed from: checkArithmetic-NB67dxo, reason: not valid java name */
    public static final void m3868checkArithmeticNB67dxo(long j10, long j11) {
        if (!((m3872isUnspecifiedR2X_6o(j10) || m3872isUnspecifiedR2X_6o(j11)) ? false : true)) {
            throw new IllegalArgumentException("Cannot perform operation for Unspecified type.".toString());
        }
        if (TextUnitType.m3882equalsimpl0(TextUnit.m3853getTypeUIouoOA(j10), TextUnit.m3853getTypeUIouoOA(j11))) {
            return;
        }
        throw new IllegalArgumentException(("Cannot perform operation for " + ((Object) TextUnitType.m3884toStringimpl(TextUnit.m3853getTypeUIouoOA(j10))) + " and " + ((Object) TextUnitType.m3884toStringimpl(TextUnit.m3853getTypeUIouoOA(j11)))).toString());
    }

    /* JADX INFO: renamed from: checkArithmetic-vU-0ePk, reason: not valid java name */
    public static final void m3869checkArithmeticvU0ePk(long j10, long j11, long j12) {
        if (!((m3872isUnspecifiedR2X_6o(j10) || m3872isUnspecifiedR2X_6o(j11) || m3872isUnspecifiedR2X_6o(j12)) ? false : true)) {
            throw new IllegalArgumentException("Cannot perform operation for Unspecified type.".toString());
        }
        if (TextUnitType.m3882equalsimpl0(TextUnit.m3853getTypeUIouoOA(j10), TextUnit.m3853getTypeUIouoOA(j11)) && TextUnitType.m3882equalsimpl0(TextUnit.m3853getTypeUIouoOA(j11), TextUnit.m3853getTypeUIouoOA(j12))) {
            return;
        }
        throw new IllegalArgumentException(("Cannot perform operation for " + ((Object) TextUnitType.m3884toStringimpl(TextUnit.m3853getTypeUIouoOA(j10))) + " and " + ((Object) TextUnitType.m3884toStringimpl(TextUnit.m3853getTypeUIouoOA(j11)))).toString());
    }

    public static final long getEm(float f10) {
        return pack(UNIT_TYPE_EM, f10);
    }

    @Stable
    public static /* synthetic */ void getEm$annotations(double d10) {
    }

    public static final long getSp(float f10) {
        return pack(UNIT_TYPE_SP, f10);
    }

    @Stable
    public static /* synthetic */ void getSp$annotations(double d10) {
    }

    /* JADX INFO: renamed from: isSpecified--R2X_6o, reason: not valid java name */
    public static final boolean m3870isSpecifiedR2X_6o(long j10) {
        return !m3872isUnspecifiedR2X_6o(j10);
    }

    /* JADX INFO: renamed from: isUnspecified--R2X_6o, reason: not valid java name */
    public static final boolean m3872isUnspecifiedR2X_6o(long j10) {
        return TextUnit.m3852getRawTypeimpl(j10) == 0;
    }

    @Stable
    /* JADX INFO: renamed from: lerp-C3pnCVY, reason: not valid java name */
    public static final long m3874lerpC3pnCVY(long j10, long j11, float f10) {
        m3868checkArithmeticNB67dxo(j10, j11);
        return pack(TextUnit.m3852getRawTypeimpl(j10), MathHelpersKt.lerp(TextUnit.m3854getValueimpl(j10), TextUnit.m3854getValueimpl(j11), f10));
    }

    public static final long pack(long j10, float f10) {
        return TextUnit.m3846constructorimpl(j10 | (((long) Float.floatToIntBits(f10)) & 4294967295L));
    }

    /* JADX INFO: renamed from: takeOrElse-eAf_CNQ, reason: not valid java name */
    public static final long m3875takeOrElseeAf_CNQ(long j10, @NotNull h9.a<TextUnit> block) {
        t.i(block, "block");
        return m3872isUnspecifiedR2X_6o(j10) ^ true ? j10 : block.invoke().m3863unboximpl();
    }

    @Stable
    /* JADX INFO: renamed from: times-mpE4wyQ, reason: not valid java name */
    public static final long m3877timesmpE4wyQ(float f10, long j10) {
        m3867checkArithmeticR2X_6o(j10);
        return pack(TextUnit.m3852getRawTypeimpl(j10), f10 * TextUnit.m3854getValueimpl(j10));
    }

    public static final long getEm(double d10) {
        return pack(UNIT_TYPE_EM, (float) d10);
    }

    @Stable
    public static /* synthetic */ void getEm$annotations(float f10) {
    }

    public static final long getSp(double d10) {
        return pack(UNIT_TYPE_SP, (float) d10);
    }

    @Stable
    public static /* synthetic */ void getSp$annotations(float f10) {
    }

    public static final long getEm(int i10) {
        return pack(UNIT_TYPE_EM, i10);
    }

    @Stable
    public static /* synthetic */ void getEm$annotations(int i10) {
    }

    public static final long getSp(int i10) {
        return pack(UNIT_TYPE_SP, i10);
    }

    @Stable
    public static /* synthetic */ void getSp$annotations(int i10) {
    }

    @Stable
    /* JADX INFO: renamed from: times-mpE4wyQ, reason: not valid java name */
    public static final long m3876timesmpE4wyQ(double d10, long j10) {
        m3867checkArithmeticR2X_6o(j10);
        return pack(TextUnit.m3852getRawTypeimpl(j10), ((float) d10) * TextUnit.m3854getValueimpl(j10));
    }

    @Stable
    /* JADX INFO: renamed from: times-mpE4wyQ, reason: not valid java name */
    public static final long m3878timesmpE4wyQ(int i10, long j10) {
        m3867checkArithmeticR2X_6o(j10);
        return pack(TextUnit.m3852getRawTypeimpl(j10), i10 * TextUnit.m3854getValueimpl(j10));
    }

    @Stable
    /* JADX INFO: renamed from: isSpecified--R2X_6o$annotations, reason: not valid java name */
    public static /* synthetic */ void m3871isSpecifiedR2X_6o$annotations(long j10) {
    }

    @Stable
    /* JADX INFO: renamed from: isUnspecified--R2X_6o$annotations, reason: not valid java name */
    public static /* synthetic */ void m3873isUnspecifiedR2X_6o$annotations(long j10) {
    }
}
