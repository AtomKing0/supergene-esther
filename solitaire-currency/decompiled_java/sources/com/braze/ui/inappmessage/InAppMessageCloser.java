package com.braze.ui.inappmessage;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class InAppMessageCloser {
    private final IInAppMessageViewWrapper mInAppMessageViewWrapper;

    public InAppMessageCloser(IInAppMessageViewWrapper iInAppMessageViewWrapper) {
        this.mInAppMessageViewWrapper = iInAppMessageViewWrapper;
    }

    public void close(boolean z10) {
        this.mInAppMessageViewWrapper.getInAppMessage().setAnimateOut(z10);
        this.mInAppMessageViewWrapper.close();
    }
}
