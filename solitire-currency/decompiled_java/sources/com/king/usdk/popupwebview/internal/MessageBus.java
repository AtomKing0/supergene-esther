package com.king.usdk.popupwebview.internal;

import android.annotation.SuppressLint;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.king.usdk.popupwebview.ILoadingListener;
import com.king.usdk.popupwebview.IMessageListener;
import com.king.usdk.popupwebview.IResponder;
import com.king.usdk.popupwebview.IResponseCallback;
import com.king.usdk.popupwebview.Result;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
@Keep
final class MessageBus {
    private static final String ERROR_WEBPAGE_UNLOADED = "web page has been unloaded before sending responses to all messages";
    private static final String JAVASCRIPT_ON_MESSAGE_RECEIVED_FORMAT = "window._messageBus.onMessageReceived(%s, %s, %d);";
    private static final String JAVASCRIPT_ON_MESSAGE_RESPONSE_FORMAT = "window._messageBus.onMessageResponse(%d, %s, %d, %s);";
    private static final String MESSAGEBUS_JAVASCRIPT_NAME = "_messageBus";
    private final Popup popup;
    private final List<c> responders = new ArrayList();
    private volatile ILoadingListener loadingListener = null;
    private volatile IMessageListener messageListener = null;
    private final b javascriptInterface = new b(this, null);

    class a implements ValueCallback<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f17243a;

        a(int i10) {
            this.f17243a = i10;
        }

        @Override // android.webkit.ValueCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            int i10;
            c cVar;
            if (str == null || str.isEmpty() || (i10 = this.f17243a) < 0 || i10 >= MessageBus.this.responders.size() || (cVar = (c) MessageBus.this.responders.get(this.f17243a)) == null) {
                return;
            }
            MessageBus.this.responders.set(this.f17243a, null);
            cVar.sendMessageResponse(Result.FAILURE, str);
        }
    }

    private final class b {

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f17246a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f17247b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f17248c;

            /* JADX INFO: renamed from: com.king.usdk.popupwebview.internal.MessageBus$b$a$a, reason: collision with other inner class name */
            class C0285a implements IResponder {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final Object f17250a = new Object();

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private volatile boolean f17251b = false;

                C0285a() {
                }

                @Override // com.king.usdk.popupwebview.IResponder
                public void sendMessageResponse(Result result, String str) {
                    if (this.f17251b) {
                        return;
                    }
                    synchronized (this.f17250a) {
                        if (this.f17251b) {
                            return;
                        }
                        this.f17251b = true;
                        MessageBus.this.popup.executeJavascriptOnUIThread(String.format(Locale.ROOT, MessageBus.JAVASCRIPT_ON_MESSAGE_RESPONSE_FORMAT, Integer.valueOf(a.this.f17246a), MessageBus.escapeJavascriptString(a.this.f17247b), Integer.valueOf(result.ordinal()), MessageBus.escapeJavascriptString(str)), null);
                    }
                }
            }

            a(int i10, String str, String str2) {
                this.f17246a = i10;
                this.f17247b = str;
                this.f17248c = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                IMessageListener iMessageListener = MessageBus.this.messageListener;
                if (iMessageListener == null) {
                    if (this.f17246a >= 0) {
                        MessageBus.this.popup.executeJavascript(String.format(Locale.ROOT, MessageBus.JAVASCRIPT_ON_MESSAGE_RESPONSE_FORMAT, Integer.valueOf(this.f17246a), MessageBus.escapeJavascriptString(this.f17247b), Integer.valueOf(Result.FAILURE.ordinal()), MessageBus.escapeJavascriptString("unknown message")), null);
                        return;
                    }
                    return;
                }
                try {
                    iMessageListener.onMessageReceived(this.f17247b, this.f17248c, this.f17246a >= 0 ? new C0285a() : null);
                } catch (Throwable th) {
                    th.printStackTrace();
                    if (this.f17246a >= 0) {
                        MessageBus.this.popup.executeJavascript(String.format(Locale.ROOT, MessageBus.JAVASCRIPT_ON_MESSAGE_RESPONSE_FORMAT, Integer.valueOf(this.f17246a), MessageBus.escapeJavascriptString(this.f17247b), Integer.valueOf(Result.FAILURE.ordinal()), MessageBus.escapeJavascriptString(th.getMessage())), null);
                    }
                }
            }
        }

        /* JADX INFO: renamed from: com.king.usdk.popupwebview.internal.MessageBus$b$b, reason: collision with other inner class name */
        class RunnableC0286b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f17253a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f17254b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f17255c;

            RunnableC0286b(int i10, int i11, String str) {
                this.f17253a = i10;
                this.f17254b = i11;
                this.f17255c = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar;
                int i10 = this.f17253a;
                if (i10 < 0 || i10 >= MessageBus.this.responders.size() || (cVar = (c) MessageBus.this.responders.get(this.f17253a)) == null) {
                    return;
                }
                MessageBus.this.responders.set(this.f17253a, null);
                Result result = Result.FAILURE;
                int i11 = this.f17254b;
                Result result2 = Result.SUCCESS;
                if (i11 == result2.ordinal()) {
                    result = result2;
                }
                cVar.sendMessageResponse(result, this.f17255c);
            }
        }

        private b() {
        }

        @JavascriptInterface
        public void postMessage(String str, String str2, int i10) {
            MessageBus.this.popup.getActivityWrapper().runOnUIThread(new a(i10, str, str2));
        }

        @JavascriptInterface
        public void sendMessageResponse(int i10, int i11, String str) {
            MessageBus.this.popup.getActivityWrapper().runOnUIThread(new RunnableC0286b(i10, i11, str));
        }

        /* synthetic */ b(MessageBus messageBus, a aVar) {
            this();
        }
    }

    @UiThread
    private static final class c implements IResponder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f17257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final IResponseCallback f17258b;

        public c(String str, IResponseCallback iResponseCallback) {
            this.f17257a = str;
            this.f17258b = iResponseCallback;
        }

        public void a() {
            try {
                this.f17258b.onMessageResponse(this.f17257a, Result.FAILURE, MessageBus.ERROR_WEBPAGE_UNLOADED);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.king.usdk.popupwebview.IResponder
        public void sendMessageResponse(Result result, String str) {
            try {
                this.f17258b.onMessageResponse(this.f17257a, result, str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    MessageBus(Popup popup) {
        this.popup = popup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static String escapeJavascriptString(String str) {
        if (str == null) {
            return "null";
        }
        if (str.isEmpty()) {
            return "''";
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length + 2);
        sb.append('\'');
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '\'' || cCharAt == '\\') {
                sb.append('\\');
                sb.append(cCharAt);
            } else {
                sb.append(cCharAt);
            }
        }
        sb.append('\'');
        return sb.toString();
    }

    @UiThread
    public void backButtonPressed() {
        ILoadingListener iLoadingListener = this.loadingListener;
        if (iLoadingListener != null) {
            try {
                iLoadingListener.onBackButtonPressed();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @UiThread
    public void cancelAllResponses() {
        int size = this.responders.size();
        for (int i10 = 0; i10 < size; i10++) {
            c cVar = this.responders.get(i10);
            if (cVar != null) {
                cVar.a();
            }
        }
        this.responders.clear();
    }

    @UiThread
    public void firePageError(String str) {
        ILoadingListener iLoadingListener = this.loadingListener;
        if (iLoadingListener != null) {
            try {
                iLoadingListener.onPageError(str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @UiThread
    public void firePageLoaded(String str) {
        ILoadingListener iLoadingListener = this.loadingListener;
        if (iLoadingListener != null) {
            try {
                iLoadingListener.onPageLoaded(str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @UiThread
    public void postMessage(String str, String str2, IResponseCallback iResponseCallback) {
        int i10 = -1;
        if (iResponseCallback != null) {
            int size = this.responders.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    break;
                }
                if (this.responders.get(i11) == null) {
                    this.responders.set(i11, new c(str, iResponseCallback));
                    i10 = i11;
                    break;
                }
                i11++;
            }
            if (i10 < 0) {
                this.responders.add(new c(str, iResponseCallback));
                i10 = size;
            }
        }
        this.popup.executeJavascript(String.format(Locale.ROOT, JAVASCRIPT_ON_MESSAGE_RECEIVED_FORMAT, escapeJavascriptString(str), escapeJavascriptString(str2), Integer.valueOf(i10)), new a(i10));
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    @UiThread
    public void registerJavascriptInterface(WebView webView) {
        if (webView != null) {
            webView.getSettings().setJavaScriptEnabled(true);
            webView.addJavascriptInterface(this.javascriptInterface, MESSAGEBUS_JAVASCRIPT_NAME);
        }
    }

    public void setLoadingListener(ILoadingListener iLoadingListener) {
        this.loadingListener = iLoadingListener;
    }

    public void setMessageListener(IMessageListener iMessageListener) {
        this.messageListener = iMessageListener;
    }
}
