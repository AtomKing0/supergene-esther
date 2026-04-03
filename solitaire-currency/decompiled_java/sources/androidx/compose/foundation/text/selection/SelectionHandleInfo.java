package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.ui.geometry.Offset;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SelectionHandles.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SelectionHandleInfo {

    @NotNull
    private final Handle handle;
    private final long position;

    public /* synthetic */ SelectionHandleInfo(Handle handle, long j10, k kVar) {
        this(handle, j10);
    }

    /* JADX INFO: renamed from: copy-Uv8p0NA$default, reason: not valid java name */
    public static /* synthetic */ SelectionHandleInfo m776copyUv8p0NA$default(SelectionHandleInfo selectionHandleInfo, Handle handle, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            handle = selectionHandleInfo.handle;
        }
        if ((i10 & 2) != 0) {
            j10 = selectionHandleInfo.position;
        }
        return selectionHandleInfo.m778copyUv8p0NA(handle, j10);
    }

    @NotNull
    public final Handle component1() {
        return this.handle;
    }

    /* JADX INFO: renamed from: component2-F1C5BW0, reason: not valid java name */
    public final long m777component2F1C5BW0() {
        return this.position;
    }

    @NotNull
    /* JADX INFO: renamed from: copy-Uv8p0NA, reason: not valid java name */
    public final SelectionHandleInfo m778copyUv8p0NA(@NotNull Handle handle, long j10) {
        t.i(handle, "handle");
        return new SelectionHandleInfo(handle, j10, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelectionHandleInfo)) {
            return false;
        }
        SelectionHandleInfo selectionHandleInfo = (SelectionHandleInfo) obj;
        return this.handle == selectionHandleInfo.handle && Offset.m1364equalsimpl0(this.position, selectionHandleInfo.position);
    }

    @NotNull
    public final Handle getHandle() {
        return this.handle;
    }

    /* JADX INFO: renamed from: getPosition-F1C5BW0, reason: not valid java name */
    public final long m779getPositionF1C5BW0() {
        return this.position;
    }

    public int hashCode() {
        return (this.handle.hashCode() * 31) + Offset.m1369hashCodeimpl(this.position);
    }

    @NotNull
    public String toString() {
        return "SelectionHandleInfo(handle=" + this.handle + ", position=" + ((Object) Offset.m1375toStringimpl(this.position)) + ')';
    }

    private SelectionHandleInfo(Handle handle, long j10) {
        this.handle = handle;
        this.position = j10;
    }
}
