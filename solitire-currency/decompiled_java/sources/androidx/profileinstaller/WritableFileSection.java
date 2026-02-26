package androidx.profileinstaller;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
class WritableFileSection {
    final byte[] mContents;
    final int mExpectedInflateSize;
    final boolean mNeedsCompression;
    final FileSectionType mType;

    WritableFileSection(@NonNull FileSectionType fileSectionType, int i10, @NonNull byte[] bArr, boolean z10) {
        this.mType = fileSectionType;
        this.mExpectedInflateSize = i10;
        this.mContents = bArr;
        this.mNeedsCompression = z10;
    }
}
