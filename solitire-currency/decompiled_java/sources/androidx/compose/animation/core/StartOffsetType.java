package androidx.compose.animation.core;

import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AnimationSpec.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StartOffsetType {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Delay = m133constructorimpl(-1);
    private static final int FastForward = m133constructorimpl(1);
    private final int value;

    /* JADX INFO: compiled from: AnimationSpec.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getDelay-Eo1U57Q, reason: not valid java name */
        public final int m139getDelayEo1U57Q() {
            return StartOffsetType.Delay;
        }

        /* JADX INFO: renamed from: getFastForward-Eo1U57Q, reason: not valid java name */
        public final int m140getFastForwardEo1U57Q() {
            return StartOffsetType.FastForward;
        }
    }

    private /* synthetic */ StartOffsetType(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ StartOffsetType m132boximpl(int i10) {
        return new StartOffsetType(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m134equalsimpl(int i10, Object obj) {
        return (obj instanceof StartOffsetType) && i10 == ((StartOffsetType) obj).m138unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m135equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m137toStringimpl(int i10) {
        return "StartOffsetType(value=" + i10 + ')';
    }

    public boolean equals(Object obj) {
        return m134equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m136hashCodeimpl(this.value);
    }

    public String toString() {
        return m137toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m138unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m133constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m136hashCodeimpl(int i10) {
        return i10;
    }
}
