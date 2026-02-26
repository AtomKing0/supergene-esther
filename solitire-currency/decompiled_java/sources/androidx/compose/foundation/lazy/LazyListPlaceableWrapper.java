package androidx.compose.foundation.lazy;

import androidx.compose.ui.layout.Placeable;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LazyMeasuredItem.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListPlaceableWrapper {
    private final long offset;

    @Nullable
    private final Object parentData;

    @NotNull
    private final Placeable placeable;

    public /* synthetic */ LazyListPlaceableWrapper(long j10, Placeable placeable, Object obj, k kVar) {
        this(j10, placeable, obj);
    }

    /* JADX INFO: renamed from: getOffset-nOcc-ac, reason: not valid java name */
    public final long m516getOffsetnOccac() {
        return this.offset;
    }

    @Nullable
    public final Object getParentData() {
        return this.parentData;
    }

    @NotNull
    public final Placeable getPlaceable() {
        return this.placeable;
    }

    private LazyListPlaceableWrapper(long j10, Placeable placeable, Object obj) {
        this.offset = j10;
        this.placeable = placeable;
        this.parentData = obj;
    }
}
