package com.braze.ui.inappmessage.views;

import android.content.Context;
import android.util.AttributeSet;
import com.braze.ui.R$id;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: InAppMessageHtmlView.kt */
/* JADX INFO: loaded from: classes2.dex */
public class InAppMessageHtmlView extends InAppMessageHtmlBaseView {
    public InAppMessageHtmlView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.braze.ui.inappmessage.views.InAppMessageHtmlBaseView
    public int getWebViewViewId() {
        return R$id.com_braze_inappmessage_html_webview;
    }
}
