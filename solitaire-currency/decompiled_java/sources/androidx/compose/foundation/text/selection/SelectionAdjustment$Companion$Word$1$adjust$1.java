package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import h9.l;
import kotlin.jvm.internal.q;

/* JADX INFO: compiled from: SelectionAdjustment.kt */
/* JADX INFO: loaded from: classes.dex */
/* synthetic */ class SelectionAdjustment$Companion$Word$1$adjust$1 extends q implements l<Integer, TextRange> {
    SelectionAdjustment$Companion$Word$1$adjust$1(Object obj) {
        super(1, obj, TextLayoutResult.class, "getWordBoundary", "getWordBoundary--jx7JFs(I)J", 0);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ TextRange invoke(Integer num) {
        return TextRange.m3323boximpl(m772invokejx7JFs(num.intValue()));
    }

    /* JADX INFO: renamed from: invoke--jx7JFs, reason: not valid java name */
    public final long m772invokejx7JFs(int i10) {
        return ((TextLayoutResult) this.receiver).m3322getWordBoundaryjx7JFs(i10);
    }
}
