package com.applovin.impl;

import androidx.media3.extractor.text.ttml.TtmlNode;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class rf {
    public static /* synthetic */ String a(CharSequence charSequence, CharSequence[] charSequenceArr) {
        if (charSequence == null) {
            throw new NullPointerException(TtmlNode.RUBY_DELIMITER);
        }
        StringBuilder sb = new StringBuilder();
        if (charSequenceArr.length > 0) {
            sb.append(charSequenceArr[0]);
            for (int i10 = 1; i10 < charSequenceArr.length; i10++) {
                sb.append(charSequence);
                sb.append(charSequenceArr[i10]);
            }
        }
        return sb.toString();
    }
}
