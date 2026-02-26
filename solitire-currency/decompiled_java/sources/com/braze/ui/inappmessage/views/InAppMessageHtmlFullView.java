package com.braze.ui.inappmessage.views;

import android.content.Context;
import android.util.AttributeSet;
import com.braze.ui.R$id;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: InAppMessageHtmlFullView.kt */
/* JADX INFO: loaded from: classes2.dex */
public class InAppMessageHtmlFullView extends InAppMessageHtmlBaseView {
    public InAppMessageHtmlFullView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.braze.ui.inappmessage.views.InAppMessageHtmlBaseView
    public int getWebViewViewId() {
        return R$id.com_braze_inappmessage_html_full_webview;
    }
}
