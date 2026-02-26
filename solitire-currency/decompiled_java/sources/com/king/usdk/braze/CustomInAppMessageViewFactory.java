package com.king.usdk.braze;

import android.app.Activity;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.Keep;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.InAppMessageHtml;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.IInAppMessageViewFactory;
import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class CustomInAppMessageViewFactory implements IInAppMessageViewFactory {
    private Activity mActivity;

    public class BrazeAndroidJsBridge {
        public BrazeAndroidJsBridge() {
        }

        @JavascriptInterface
        public String getNativeSharingOfflineDeeplink(String str, String str2, String str3, String str4, String str5) {
            try {
                byte[] bArrDecode = Base64.decode(str2, 0);
                File file = new File(CustomInAppMessageViewFactory.this.mActivity.getCacheDir(), str);
                FileOutputStream fileOutputStream = new FileOutputStream(file, false);
                try {
                    fileOutputStream.write(bArrDecode);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return Base64.encodeToString(("{\"lp\":[{\"k\":\"dpid\",\"v\":\"999\"}],\"ces\":[{\"hn\":\"nativesharing\",\"esp\":[{\"n\":\"filePath\",\"pt\":0,\"v\":\"" + file.getAbsolutePath() + "\"}, {\"n\":\"text\",\"pt\":0,\"v\":\"" + str3 + "\"}, {\"n\":\"title\",\"pt\":0,\"v\":\"" + str4 + "\"}, {\"n\":\"subject\",\"pt\":0,\"v\":\"" + str5 + "\"}],\"t\":10}]}").getBytes(), 0);
                } finally {
                }
            } catch (Exception unused) {
                return "";
            }
        }
    }

    public CustomInAppMessageViewFactory(Activity activity) {
        this.mActivity = activity;
    }

    private WebView findWebView(ViewGroup viewGroup) {
        WebView webViewFindWebView;
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt instanceof WebView) {
                return (WebView) childAt;
            }
            if ((childAt instanceof ViewGroup) && (webViewFindWebView = findWebView((ViewGroup) childAt)) != null) {
                return webViewFindWebView;
            }
        }
        return null;
    }

    @Override // com.braze.ui.inappmessage.IInAppMessageViewFactory
    public View createInAppMessageView(Activity activity, IInAppMessage iInAppMessage) {
        WebView webViewFindWebView;
        View viewCreateInAppMessageView = BrazeInAppMessageManager.getInstance().getDefaultInAppMessageViewFactory(iInAppMessage).createInAppMessageView(activity, iInAppMessage);
        if ((iInAppMessage instanceof InAppMessageHtml) && (viewCreateInAppMessageView instanceof ViewGroup) && (webViewFindWebView = findWebView((ViewGroup) viewCreateInAppMessageView)) != null) {
            webViewFindWebView.addJavascriptInterface(new BrazeAndroidJsBridge(), "king");
        }
        return viewCreateInAppMessageView;
    }
}
