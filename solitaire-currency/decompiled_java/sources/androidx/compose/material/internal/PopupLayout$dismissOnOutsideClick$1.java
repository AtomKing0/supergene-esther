package androidx.compose.material.internal;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.IntRect;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ExposedDropdownMenuPopup.kt */
/* JADX INFO: loaded from: classes.dex */
final class PopupLayout$dismissOnOutsideClick$1 extends v implements p<Offset, IntRect, Boolean> {
    public static final PopupLayout$dismissOnOutsideClick$1 INSTANCE = new PopupLayout$dismissOnOutsideClick$1();

    PopupLayout$dismissOnOutsideClick$1() {
        super(2);
    }

    @Override // h9.p
    @NotNull
    /* JADX INFO: renamed from: invoke-KMgbckE, reason: not valid java name and merged with bridge method [inline-methods] */
    public final Boolean mo4invoke(@Nullable Offset offset, @NotNull IntRect bounds) {
        t.i(bounds, "bounds");
        boolean z10 = false;
        if (offset != null && (Offset.m1367getXimpl(offset.m1377unboximpl()) < bounds.getLeft() || Offset.m1367getXimpl(offset.m1377unboximpl()) > bounds.getRight() || Offset.m1368getYimpl(offset.m1377unboximpl()) < bounds.getTop() || Offset.m1368getYimpl(offset.m1377unboximpl()) > bounds.getBottom())) {
            z10 = true;
        }
        return Boolean.valueOf(z10);
    }
}
