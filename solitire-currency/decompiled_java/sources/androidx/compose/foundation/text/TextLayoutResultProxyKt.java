package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;

/* JADX INFO: compiled from: TextLayoutResultProxy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextLayoutResultProxyKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: coerceIn-3MmeM6k, reason: not valid java name */
    public static final long m748coerceIn3MmeM6k(long j10, Rect rect) {
        return OffsetKt.Offset(Offset.m1367getXimpl(j10) < rect.getLeft() ? rect.getLeft() : Offset.m1367getXimpl(j10) > rect.getRight() ? rect.getRight() : Offset.m1367getXimpl(j10), Offset.m1368getYimpl(j10) < rect.getTop() ? rect.getTop() : Offset.m1368getYimpl(j10) > rect.getBottom() ? rect.getBottom() : Offset.m1368getYimpl(j10));
    }
}
