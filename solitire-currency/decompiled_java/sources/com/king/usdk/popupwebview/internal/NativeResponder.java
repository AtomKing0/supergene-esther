package com.king.usdk.popupwebview.internal;

import androidx.annotation.Keep;
import com.king.usdk.popupwebview.IResponder;
import com.king.usdk.popupwebview.Result;

/* JADX INFO: loaded from: classes4.dex */
@Keep
final class NativeResponder {
    private final IResponder responder;

    NativeResponder(IResponder iResponder) {
        this.responder = iResponder;
    }

    public void sendMessageResponse(int i10, String str) {
        if (this.responder != null) {
            Result result = Result.FAILURE;
            Result result2 = Result.SUCCESS;
            if (i10 == result2.ordinal()) {
                result = result2;
            }
            this.responder.sendMessageResponse(result, str);
        }
    }
}
