package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.Path;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DrawTransform.kt */
/* JADX INFO: loaded from: classes.dex */
@DrawScopeMarker
public interface DrawTransform {

    /* JADX INFO: compiled from: DrawTransform.kt */
    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
        public static long m2076getCenterF1C5BW0(@NotNull DrawTransform drawTransform) {
            return c.a(drawTransform);
        }
    }

    /* JADX INFO: renamed from: clipPath-mtrdD-E */
    void mo2004clipPathmtrdDE(@NotNull Path path, int i10);

    /* JADX INFO: renamed from: clipRect-N_I0leg */
    void mo2005clipRectN_I0leg(float f10, float f11, float f12, float f13, int i10);

    /* JADX INFO: renamed from: getCenter-F1C5BW0 */
    long mo2006getCenterF1C5BW0();

    /* JADX INFO: renamed from: getSize-NH-jbRc */
    long mo2007getSizeNHjbRc();

    void inset(float f10, float f11, float f12, float f13);

    /* JADX INFO: renamed from: rotate-Uv8p0NA */
    void mo2008rotateUv8p0NA(float f10, long j10);

    /* JADX INFO: renamed from: scale-0AR0LA0 */
    void mo2009scale0AR0LA0(float f10, float f11, long j10);

    /* JADX INFO: renamed from: transform-58bKbWc */
    void mo2010transform58bKbWc(@NotNull float[] fArr);

    void translate(float f10, float f11);
}
