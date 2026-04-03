package androidx.compose.ui.text;

import java.util.List;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MultiParagraphIntrinsics.kt */
/* JADX INFO: loaded from: classes.dex */
final class MultiParagraphIntrinsics$maxIntrinsicWidth$2 extends v implements h9.a<Float> {
    final /* synthetic */ MultiParagraphIntrinsics this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MultiParagraphIntrinsics$maxIntrinsicWidth$2(MultiParagraphIntrinsics multiParagraphIntrinsics) {
        super(0);
        this.this$0 = multiParagraphIntrinsics;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final Float invoke() {
        ParagraphIntrinsicInfo paragraphIntrinsicInfo;
        ParagraphIntrinsics intrinsics;
        List<ParagraphIntrinsicInfo> infoList$ui_text_release = this.this$0.getInfoList$ui_text_release();
        if (infoList$ui_text_release.isEmpty()) {
            paragraphIntrinsicInfo = null;
        } else {
            ParagraphIntrinsicInfo paragraphIntrinsicInfo2 = infoList$ui_text_release.get(0);
            float maxIntrinsicWidth = paragraphIntrinsicInfo2.getIntrinsics().getMaxIntrinsicWidth();
            int iM = kotlin.collections.v.m(infoList$ui_text_release);
            int i10 = 1;
            if (1 <= iM) {
                while (true) {
                    ParagraphIntrinsicInfo paragraphIntrinsicInfo3 = infoList$ui_text_release.get(i10);
                    float maxIntrinsicWidth2 = paragraphIntrinsicInfo3.getIntrinsics().getMaxIntrinsicWidth();
                    if (Float.compare(maxIntrinsicWidth, maxIntrinsicWidth2) < 0) {
                        paragraphIntrinsicInfo2 = paragraphIntrinsicInfo3;
                        maxIntrinsicWidth = maxIntrinsicWidth2;
                    }
                    if (i10 == iM) {
                        break;
                    }
                    i10++;
                }
            }
            paragraphIntrinsicInfo = paragraphIntrinsicInfo2;
        }
        ParagraphIntrinsicInfo paragraphIntrinsicInfo4 = paragraphIntrinsicInfo;
        return Float.valueOf((paragraphIntrinsicInfo4 == null || (intrinsics = paragraphIntrinsicInfo4.getIntrinsics()) == null) ? 0.0f : intrinsics.getMaxIntrinsicWidth());
    }
}
