package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.Canvas;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DrawContext.kt */
/* JADX INFO: loaded from: classes.dex */
public interface DrawContext {
    @NotNull
    Canvas getCanvas();

    /* JADX INFO: renamed from: getSize-NH-jbRc */
    long mo2002getSizeNHjbRc();

    @NotNull
    DrawTransform getTransform();

    /* JADX INFO: renamed from: setSize-uvyYCjk */
    void mo2003setSizeuvyYCjk(long j10);
}
