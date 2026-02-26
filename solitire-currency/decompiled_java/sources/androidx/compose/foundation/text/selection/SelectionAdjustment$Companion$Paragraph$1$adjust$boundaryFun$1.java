package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpersKt;
import androidx.compose.ui.text.TextRange;
import h9.l;
import kotlin.jvm.internal.q;

/* JADX INFO: compiled from: SelectionAdjustment.kt */
/* JADX INFO: loaded from: classes.dex */
/* synthetic */ class SelectionAdjustment$Companion$Paragraph$1$adjust$boundaryFun$1 extends q implements l<Integer, TextRange> {
    SelectionAdjustment$Companion$Paragraph$1$adjust$boundaryFun$1(Object obj) {
        super(1, obj, StringHelpersKt.class, "getParagraphBoundary", "getParagraphBoundary(Ljava/lang/CharSequence;I)J", 1);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ TextRange invoke(Integer num) {
        return TextRange.m3323boximpl(m771invokejx7JFs(num.intValue()));
    }

    /* JADX INFO: renamed from: invoke--jx7JFs, reason: not valid java name */
    public final long m771invokejx7JFs(int i10) {
        return StringHelpersKt.getParagraphBoundary((CharSequence) this.receiver, i10);
    }
}
