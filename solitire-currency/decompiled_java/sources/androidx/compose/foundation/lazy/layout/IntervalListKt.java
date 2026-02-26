package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.runtime.collection.MutableVector;

/* JADX INFO: compiled from: IntervalList.kt */
/* JADX INFO: loaded from: classes.dex */
public final class IntervalListKt {
    /* JADX INFO: Access modifiers changed from: private */
    @ExperimentalFoundationApi
    public static final <T> int binarySearch(MutableVector<IntervalList.Interval<T>> mutableVector, int i10) {
        int size = mutableVector.getSize() - 1;
        int i11 = 0;
        while (i11 < size) {
            int i12 = ((size - i11) / 2) + i11;
            int startIndex = mutableVector.getContent()[i12].getStartIndex();
            if (startIndex == i10) {
                return i12;
            }
            if (startIndex < i10) {
                i11 = i12 + 1;
                if (i10 < mutableVector.getContent()[i11].getStartIndex()) {
                    return i12;
                }
            } else {
                size = i12 - 1;
            }
        }
        return i11;
    }
}
