package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Rect;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LayoutCoordinates.kt */
/* JADX INFO: loaded from: classes.dex */
public interface LayoutCoordinates {

    /* JADX INFO: compiled from: LayoutCoordinates.kt */
    public static final class DefaultImpls {
    }

    int get(@NotNull AlignmentLine alignmentLine);

    @Nullable
    LayoutCoordinates getParentCoordinates();

    @Nullable
    LayoutCoordinates getParentLayoutCoordinates();

    @NotNull
    Set<AlignmentLine> getProvidedAlignmentLines();

    /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name */
    long mo2989getSizeYbymL2g();

    boolean isAttached();

    @NotNull
    Rect localBoundingBoxOf(@NotNull LayoutCoordinates layoutCoordinates, boolean z10);

    /* JADX INFO: renamed from: localPositionOf-R5De75A, reason: not valid java name */
    long mo2990localPositionOfR5De75A(@NotNull LayoutCoordinates layoutCoordinates, long j10);

    /* JADX INFO: renamed from: localToRoot-MK-Hz9U, reason: not valid java name */
    long mo2991localToRootMKHz9U(long j10);

    /* JADX INFO: renamed from: localToWindow-MK-Hz9U, reason: not valid java name */
    long mo2992localToWindowMKHz9U(long j10);

    /* JADX INFO: renamed from: windowToLocal-MK-Hz9U, reason: not valid java name */
    long mo2993windowToLocalMKHz9U(long j10);
}
