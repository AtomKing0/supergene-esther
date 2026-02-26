package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.geometry.Offset;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PointerEvent.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@ExperimentalComposeUiApi
public final class HistoricalChange {
    private final long position;
    private final long uptimeMillis;

    public /* synthetic */ HistoricalChange(long j10, long j11, k kVar) {
        this(j10, j11);
    }

    /* JADX INFO: renamed from: getPosition-F1C5BW0, reason: not valid java name */
    public final long m2805getPositionF1C5BW0() {
        return this.position;
    }

    public final long getUptimeMillis() {
        return this.uptimeMillis;
    }

    @NotNull
    public String toString() {
        return "HistoricalChange(uptimeMillis=" + this.uptimeMillis + ", position=" + ((Object) Offset.m1375toStringimpl(this.position)) + ')';
    }

    private HistoricalChange(long j10, long j11) {
        this.uptimeMillis = j10;
        this.position = j11;
    }
}
