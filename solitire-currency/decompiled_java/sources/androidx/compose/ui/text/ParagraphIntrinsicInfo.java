package androidx.compose.ui.text;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MultiParagraphIntrinsics.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ParagraphIntrinsicInfo {
    private final int endIndex;

    @NotNull
    private final ParagraphIntrinsics intrinsics;
    private final int startIndex;

    public ParagraphIntrinsicInfo(@NotNull ParagraphIntrinsics intrinsics, int i10, int i11) {
        t.i(intrinsics, "intrinsics");
        this.intrinsics = intrinsics;
        this.startIndex = i10;
        this.endIndex = i11;
    }

    public static /* synthetic */ ParagraphIntrinsicInfo copy$default(ParagraphIntrinsicInfo paragraphIntrinsicInfo, ParagraphIntrinsics paragraphIntrinsics, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            paragraphIntrinsics = paragraphIntrinsicInfo.intrinsics;
        }
        if ((i12 & 2) != 0) {
            i10 = paragraphIntrinsicInfo.startIndex;
        }
        if ((i12 & 4) != 0) {
            i11 = paragraphIntrinsicInfo.endIndex;
        }
        return paragraphIntrinsicInfo.copy(paragraphIntrinsics, i10, i11);
    }

    @NotNull
    public final ParagraphIntrinsics component1() {
        return this.intrinsics;
    }

    public final int component2() {
        return this.startIndex;
    }

    public final int component3() {
        return this.endIndex;
    }

    @NotNull
    public final ParagraphIntrinsicInfo copy(@NotNull ParagraphIntrinsics intrinsics, int i10, int i11) {
        t.i(intrinsics, "intrinsics");
        return new ParagraphIntrinsicInfo(intrinsics, i10, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParagraphIntrinsicInfo)) {
            return false;
        }
        ParagraphIntrinsicInfo paragraphIntrinsicInfo = (ParagraphIntrinsicInfo) obj;
        return t.d(this.intrinsics, paragraphIntrinsicInfo.intrinsics) && this.startIndex == paragraphIntrinsicInfo.startIndex && this.endIndex == paragraphIntrinsicInfo.endIndex;
    }

    public final int getEndIndex() {
        return this.endIndex;
    }

    @NotNull
    public final ParagraphIntrinsics getIntrinsics() {
        return this.intrinsics;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public int hashCode() {
        return (((this.intrinsics.hashCode() * 31) + this.startIndex) * 31) + this.endIndex;
    }

    @NotNull
    public String toString() {
        return "ParagraphIntrinsicInfo(intrinsics=" + this.intrinsics + ", startIndex=" + this.startIndex + ", endIndex=" + this.endIndex + ')';
    }
}
