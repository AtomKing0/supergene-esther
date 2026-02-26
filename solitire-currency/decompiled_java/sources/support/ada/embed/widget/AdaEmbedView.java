package support.ada.embed.widget;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.webkit.ProxyConfig;
import androidx.webkit.internal.AssetHelper;
import com.vungle.ads.internal.presenter.o;
import h9.l;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.r0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import p9.q;
import v8.k0;
import v8.z;

/* JADX INFO: compiled from: AdaEmbedView.kt */
/* JADX INFO: loaded from: classes5.dex */
@SuppressLint({"SetJavaScriptEnabled"})
public final class AdaEmbedView extends WebView {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final c f33933r = new c(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f33934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f33935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f33936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f33937d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f33938e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, ? extends Object> f33939f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<String, ? extends Object> f33940g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Handler f33941h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final LinkedHashMap<String, eb.a> f33942i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final b f33943j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f33944k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f33945l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final HashMap<String, HashSet<l<hb.d, k0>>> f33946m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f33947n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private l<? super d, Boolean> f33948o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private h9.a<String> f33949p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private h9.a<k0> f33950q;

    /* JADX INFO: compiled from: AdaEmbedView.kt */
    public static final class a implements DownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f33951a;

        a(Context context) {
            this.f33951a = context;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, long j10) {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.addRequestHeader("Cookie", CookieManager.getInstance().getCookie(str));
            request.addRequestHeader("User-Agent", str2);
            request.setDescription("Downloading requested file....");
            request.setMimeType(str4);
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(str, str3, str4));
            request.setTitle(URLUtil.guessFileName(str, str3, str4));
            request.setAllowedOverMetered(true);
            request.setAllowedOverRoaming(false);
            if (Build.VERSION.SDK_INT >= 24) {
                request.setRequiresCharging(false);
                request.setRequiresDeviceIdle(false);
            }
            request.setVisibleInDownloadsUi(true);
            Object systemService = this.f33951a.getSystemService(o.DOWNLOAD);
            if (systemService == null) {
                throw new z("null cannot be cast to non-null type android.app.DownloadManager");
            }
            ((DownloadManager) systemService).enqueue(request);
        }
    }

    /* JADX INFO: compiled from: AdaEmbedView.kt */
    private final class b {

        /* JADX INFO: compiled from: AdaEmbedView.kt */
        static final class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                AdaEmbedView.this.d();
            }
        }

        /* JADX INFO: renamed from: support.ada.embed.widget.AdaEmbedView$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AdaEmbedView.kt */
        static final class RunnableC0688b implements Runnable {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f33955b;

            RunnableC0688b(String str) {
                this.f33955b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                hb.d dVarA = hb.d.f26518d.a(this.f33955b);
                if (t.d(dVarA.a(), "adaDownloadTranscript")) {
                    JSONObject jSONObject = new JSONObject(this.f33955b);
                    AdaEmbedView adaEmbedView = AdaEmbedView.this;
                    String strOptString = jSONObject.optString("name");
                    t.e(strOptString, "eventObject.optString(\"name\")");
                    String strOptString2 = jSONObject.optString("url");
                    t.e(strOptString2, "eventObject.optString(\"url\")");
                    adaEmbedView.e(strOptString, strOptString2);
                    return;
                }
                HashSet hashSet = (HashSet) AdaEmbedView.this.f33946m.get(dVarA.a());
                if (hashSet != null) {
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        ((l) it.next()).invoke(dVarA);
                    }
                }
                HashSet hashSet2 = (HashSet) AdaEmbedView.this.f33946m.get(ProxyConfig.MATCH_ALL_SCHEMES);
                if (hashSet2 != null) {
                    Iterator it2 = hashSet2.iterator();
                    while (it2.hasNext()) {
                        ((l) it2.next()).invoke(dVarA);
                    }
                }
            }
        }

        /* JADX INFO: compiled from: AdaEmbedView.kt */
        static final class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                AdaEmbedView.this.g();
            }
        }

        /* JADX INFO: compiled from: AdaEmbedView.kt */
        static final class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                AdaEmbedView.this.i();
            }
        }

        public b() {
        }

        @JavascriptInterface
        public final void chatFrameTimeoutCallback() {
            AdaEmbedView.this.f33941h.post(new a());
        }

        @JavascriptInterface
        public final void eventCallback(@NotNull String eventStr) {
            t.j(eventStr, "eventStr");
            AdaEmbedView.this.f33941h.post(new RunnableC0688b(eventStr));
        }

        @JavascriptInterface
        public final void onInitializeCallback() {
            AdaEmbedView.this.f33941h.post(new c());
        }

        @JavascriptInterface
        public final void onLoadCallback() {
            AdaEmbedView.this.f33941h.post(new d());
        }

        @JavascriptInterface
        @Nullable
        public final String requestToken() {
            h9.a<String> zdChatterAuthCallback = AdaEmbedView.this.getZdChatterAuthCallback();
            if (zdChatterAuthCallback != null) {
                return zdChatterAuthCallback.invoke();
            }
            Log.w(b.class.getSimpleName(), new IllegalArgumentException("Auth token callback is not provided!"));
            return null;
        }
    }

    /* JADX INFO: compiled from: AdaEmbedView.kt */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: AdaEmbedView.kt */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ValueCallback<Uri[]> f33958a;

        public d(@NotNull ValueCallback<Uri[]> valueCallback) {
            t.j(valueCallback, "valueCallback");
            this.f33958a = valueCallback;
        }

        public final void a(@Nullable Uri uri) {
            this.f33958a.onReceiveValue(uri != null ? new Uri[]{uri} : null);
        }
    }

    /* JADX INFO: compiled from: AdaEmbedView.kt */
    public static final class e implements Parcelable {
        public static final Parcelable.Creator CREATOR = new b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f33959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final String f33960b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final String f33961c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        private final String f33962d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        private final String f33963e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NotNull
        private final Map<String, Object> f33964f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @NotNull
        private final Map<String, Object> f33965g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f33966h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int f33967i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @NotNull
        private final String f33968j;

        /* JADX INFO: compiled from: AdaEmbedView.kt */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private String f33969a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private String f33970b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private String f33971c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private String f33972d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private int f33973e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private Map<String, ? extends Object> f33974f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private Map<String, ? extends Object> f33975g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private boolean f33976h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private String f33977i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private final String f33978j;

            public a(@NotNull String handle) {
                t.j(handle, "handle");
                this.f33978j = handle;
                this.f33969a = "";
                this.f33970b = "";
                this.f33971c = "";
                this.f33972d = "";
                this.f33973e = 30000;
                this.f33974f = r0.g();
                this.f33975g = r0.g();
                this.f33977i = "";
            }

            @NotNull
            public final e a() {
                return new e(this.f33978j, this.f33969a, this.f33970b, this.f33971c, this.f33972d, this.f33974f, this.f33975g, this.f33976h, this.f33973e, this.f33977i);
            }

            @NotNull
            public final a b(@NotNull hb.c metaFieldsBuilder) {
                t.j(metaFieldsBuilder, "metaFieldsBuilder");
                this.f33974f = metaFieldsBuilder.a();
                return this;
            }
        }

        public static class b implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Object createFromParcel(@NotNull Parcel in) {
                t.j(in, "in");
                String string = in.readString();
                String string2 = in.readString();
                String string3 = in.readString();
                String string4 = in.readString();
                String string5 = in.readString();
                int i10 = in.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(i10);
                while (i10 != 0) {
                    linkedHashMap.put(in.readString(), in.readValue(Object.class.getClassLoader()));
                    i10--;
                }
                int i11 = in.readInt();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(i11);
                while (i11 != 0) {
                    linkedHashMap2.put(in.readString(), in.readValue(Object.class.getClassLoader()));
                    i11--;
                }
                return new e(string, string2, string3, string4, string5, linkedHashMap, linkedHashMap2, in.readInt() != 0, in.readInt(), in.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Object[] newArray(int i10) {
                return new e[i10];
            }
        }

        public e(@NotNull String handle, @NotNull String cluster, @NotNull String greetings, @NotNull String styles, @NotNull String language, @NotNull Map<String, ? extends Object> metaFields, @NotNull Map<String, ? extends Object> sensitiveMetaFields, boolean z10, int i10, @NotNull String deviceToken) {
            t.j(handle, "handle");
            t.j(cluster, "cluster");
            t.j(greetings, "greetings");
            t.j(styles, "styles");
            t.j(language, "language");
            t.j(metaFields, "metaFields");
            t.j(sensitiveMetaFields, "sensitiveMetaFields");
            t.j(deviceToken, "deviceToken");
            this.f33959a = handle;
            this.f33960b = cluster;
            this.f33961c = greetings;
            this.f33962d = styles;
            this.f33963e = language;
            this.f33964f = metaFields;
            this.f33965g = sensitiveMetaFields;
            this.f33966h = z10;
            this.f33967i = i10;
            this.f33968j = deviceToken;
        }

        public final boolean a() {
            return this.f33966h;
        }

        @NotNull
        public final String b() {
            return this.f33960b;
        }

        @NotNull
        public final String c() {
            return this.f33968j;
        }

        @NotNull
        public final String d() {
            return this.f33961c;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String e() {
            return this.f33959a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof e) {
                    e eVar = (e) obj;
                    if (t.d(this.f33959a, eVar.f33959a) && t.d(this.f33960b, eVar.f33960b) && t.d(this.f33961c, eVar.f33961c) && t.d(this.f33962d, eVar.f33962d) && t.d(this.f33963e, eVar.f33963e) && t.d(this.f33964f, eVar.f33964f) && t.d(this.f33965g, eVar.f33965g)) {
                        if (this.f33966h == eVar.f33966h) {
                            if (!(this.f33967i == eVar.f33967i) || !t.d(this.f33968j, eVar.f33968j)) {
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }

        @NotNull
        public final String f() {
            return this.f33963e;
        }

        public final int g() {
            return this.f33967i;
        }

        @NotNull
        public final Map<String, Object> h() {
            return this.f33964f;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v19, types: [int] */
        /* JADX WARN: Type inference failed for: r2v22 */
        /* JADX WARN: Type inference failed for: r2v29 */
        public int hashCode() {
            String str = this.f33959a;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f33960b;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f33961c;
            int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.f33962d;
            int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.f33963e;
            int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            Map<String, Object> map = this.f33964f;
            int iHashCode6 = (iHashCode5 + (map != null ? map.hashCode() : 0)) * 31;
            Map<String, Object> map2 = this.f33965g;
            int iHashCode7 = (iHashCode6 + (map2 != null ? map2.hashCode() : 0)) * 31;
            boolean z10 = this.f33966h;
            ?? r22 = z10;
            if (z10) {
                r22 = 1;
            }
            int i10 = (((iHashCode7 + r22) * 31) + this.f33967i) * 31;
            String str6 = this.f33968j;
            return i10 + (str6 != null ? str6.hashCode() : 0);
        }

        @NotNull
        public final Map<String, Object> j() {
            return this.f33965g;
        }

        @NotNull
        public final String k() {
            return this.f33962d;
        }

        @NotNull
        public String toString() {
            return "Settings(handle=" + this.f33959a + ", cluster=" + this.f33960b + ", greetings=" + this.f33961c + ", styles=" + this.f33962d + ", language=" + this.f33963e + ", metaFields=" + this.f33964f + ", sensitiveMetaFields=" + this.f33965g + ", acceptThirdPartyCookies=" + this.f33966h + ", loadTimeoutMillis=" + this.f33967i + ", deviceToken=" + this.f33968j + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i10) {
            t.j(parcel, "parcel");
            parcel.writeString(this.f33959a);
            parcel.writeString(this.f33960b);
            parcel.writeString(this.f33961c);
            parcel.writeString(this.f33962d);
            parcel.writeString(this.f33963e);
            Map<String, Object> map = this.f33964f;
            parcel.writeInt(map.size());
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                parcel.writeString(entry.getKey());
                parcel.writeValue(entry.getValue());
            }
            Map<String, Object> map2 = this.f33965g;
            parcel.writeInt(map2.size());
            for (Map.Entry<String, Object> entry2 : map2.entrySet()) {
                parcel.writeString(entry2.getKey());
                parcel.writeValue(entry2.getValue());
            }
            parcel.writeInt(this.f33966h ? 1 : 0);
            parcel.writeInt(this.f33967i);
            parcel.writeString(this.f33968j);
        }
    }

    /* JADX INFO: compiled from: AdaEmbedView.kt */
    public static final class f extends WebChromeClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private View f33979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f33980b;

        f() {
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            AdaEmbedView.this.removeView(this.f33979a);
            AdaEmbedView.this.setSystemUiVisibility(this.f33980b);
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(@Nullable View view, @Nullable WebChromeClient.CustomViewCallback customViewCallback) {
            this.f33979a = view;
            this.f33980b = AdaEmbedView.this.getSystemUiVisibility();
            AdaEmbedView.this.addView(this.f33979a, new FrameLayout.LayoutParams(-1, -1));
            View view2 = this.f33979a;
            if (view2 != null) {
                if (view2 == null) {
                    t.u();
                }
                view2.setSystemUiVisibility(256);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(@Nullable WebView webView, @NotNull ValueCallback<Uri[]> filePathCallback, @NotNull WebChromeClient.FileChooserParams fileChooserParams) {
            Boolean boolInvoke;
            t.j(filePathCallback, "filePathCallback");
            t.j(fileChooserParams, "fileChooserParams");
            l<d, Boolean> filePickerCallback = AdaEmbedView.this.getFilePickerCallback();
            if (filePickerCallback == null || (boolInvoke = filePickerCallback.invoke(new d(filePathCallback))) == null) {
                return false;
            }
            return boolInvoke.booleanValue();
        }
    }

    public /* synthetic */ AdaEmbedView(Context context, AttributeSet attributeSet, int i10, k kVar) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    private final void f(eb.a aVar) {
        if (this.f33945l) {
            aVar.execute();
        } else {
            this.f33942i.remove(aVar.key());
            this.f33942i.put(aVar.key(), aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        this.f33945l = true;
        Iterator<Map.Entry<String, eb.a>> it = this.f33942i.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().execute();
            it.remove();
        }
    }

    private final void j() {
        h9.a<k0> aVarA = this.f33950q;
        if (aVarA == null) {
            aVarA = defpackage.a.f23e.a();
        }
        setWebViewClient(new defpackage.a(aVarA, this.f33947n));
        setWebChromeClient(new f());
    }

    private final boolean k() {
        return true;
    }

    private final void setAcceptThirdPartyCookies(boolean z10) {
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, z10);
    }

    public final void d() {
        h9.a<k0> aVarA = this.f33950q;
        if (aVarA == null) {
            aVarA = defpackage.a.f23e.a();
        }
        aVarA.invoke();
    }

    public final void e(@NotNull String fileName, @NotNull String data) {
        t.j(fileName, "fileName");
        t.j(data, "data");
        try {
            System.out.println((Object) fileName);
            System.out.println((Object) data);
            byte[] bArrDecode = Base64.decode(q.G(data, "data:text/plain; charset=utf-8;base64,", "", false, 4, null), 0);
            t.e(bArrDecode, "Base64.decode(it, Base64.DEFAULT)");
            t.e(bArrDecode, "data.replace(\"data:text/…64.DEFAULT)\n            }");
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileName);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArrDecode);
                k0 k0Var = k0.f35197a;
                f9.c.a(fileOutputStream, null);
                Object systemService = getContext().getSystemService(o.DOWNLOAD);
                if (systemService == null) {
                    throw new z("null cannot be cast to non-null type android.app.DownloadManager");
                }
                ((DownloadManager) systemService).addCompletedDownload(fileName, fileName, true, AssetHelper.DEFAULT_MIME_TYPE, file.getAbsolutePath(), file.length(), true);
                Toast.makeText(getContext(), "Downloading File", 1).show();
            } finally {
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Nullable
    public final l<d, Boolean> getFilePickerCallback() {
        return this.f33948o;
    }

    @Nullable
    public final h9.a<k0> getWebViewLoadingErrorCallback() {
        return this.f33950q;
    }

    @Nullable
    public final h9.a<String> getZdChatterAuthCallback() {
        return this.f33949p;
    }

    public final void h(@NotNull e settings) {
        t.j(settings, "settings");
        this.f33934a = settings.e();
        this.f33935b = settings.b();
        this.f33936c = settings.d();
        this.f33937d = settings.k();
        this.f33938e = settings.f();
        this.f33947n = settings.g();
        this.f33939f = settings.h();
        this.f33940g = settings.j();
        setDeviceToken(settings.c());
        setAcceptThirdPartyCookies(settings.a());
        j();
        if (isAttachedToWindow()) {
            loadUrl("file:///android_asset/embed.html");
        } else {
            this.f33944k = true;
            this.f33945l = false;
        }
    }

    public final void i() {
        Object[] objArr = new Object[7];
        String str = this.f33934a;
        if (str == null) {
            t.A("handle");
        }
        objArr[0] = str;
        String str2 = this.f33935b;
        if (str2 == null) {
            t.A("cluster");
        }
        objArr[1] = str2;
        String str3 = this.f33936c;
        if (str3 == null) {
            t.A("greetings");
        }
        objArr[2] = str3;
        String str4 = this.f33937d;
        if (str4 == null) {
            t.A("styles");
        }
        objArr[3] = str4;
        String str5 = this.f33938e;
        if (str5 == null) {
            t.A("language");
        }
        objArr[4] = str5;
        Map<String, ? extends Object> map = this.f33939f;
        if (map == null) {
            t.A("metaFields");
        }
        objArr[5] = fb.c.c(map);
        Map<String, ? extends Object> map2 = this.f33940g;
        if (map2 == null) {
            t.A("sensitiveMetaFields");
        }
        objArr[6] = fb.c.c(map2);
        String str6 = String.format("initializeEmbed('%s', '%s', '%s', '%s', '%s', %s, %s)", Arrays.copyOf(objArr, 7));
        t.e(str6, "java.lang.String.format(this, *args)");
        evaluateJavascript(str6, null);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.f33944k || this.f33945l) {
            return;
        }
        loadUrl("file:///android_asset/embed.html");
    }

    public final void setDeviceToken(@NotNull String token) {
        t.j(token, "token");
        f(new eb.b(this, token));
    }

    public final void setFilePickerCallback(@Nullable l<? super d, Boolean> lVar) {
        this.f33948o = lVar;
    }

    public final void setLanguage(@NotNull String language) {
        t.j(language, "language");
        if (this.f33945l) {
            f(new eb.c(this, language));
        } else {
            Log.w("AdaWebView", "setLanguage failed, webView needs to be initialized.");
        }
    }

    public final void setMetaFields(@NotNull Map<String, String> metaFields) {
        t.j(metaFields, "metaFields");
        f(new eb.d(this, metaFields));
    }

    public final void setSensitiveMetaFields(@NotNull Map<String, String> sensitiveMetaFields) {
        t.j(sensitiveMetaFields, "sensitiveMetaFields");
        f(new eb.e(this, sensitiveMetaFields));
    }

    public final void setWebViewLoadingErrorCallback(@Nullable h9.a<k0> aVar) {
        this.f33950q = aVar;
    }

    public final void setZdChatterAuthCallback(@Nullable h9.a<String> aVar) {
        this.f33949p = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdaEmbedView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        Map<String, ? extends Object> mapG;
        Map<String, ? extends Object> mapG2;
        super(context, attributeSet);
        t.j(context, "context");
        this.f33941h = new Handler(Looper.getMainLooper());
        this.f33942i = new LinkedHashMap<>();
        b bVar = new b();
        this.f33943j = bVar;
        this.f33946m = new HashMap<>();
        this.f33947n = 30000;
        if (attributeSet != null) {
            TypedArray typedArray = context.getTheme().obtainStyledAttributes(attributeSet, db.a.f24686g, 0, 0);
            try {
                t.e(typedArray, "typedArray");
                this.f33934a = fb.c.b(typedArray, db.a.f24691l);
                this.f33935b = fb.c.b(typedArray, db.a.f24688i);
                this.f33936c = fb.c.b(typedArray, db.a.f24690k);
                this.f33937d = fb.c.b(typedArray, db.a.f24696q);
                this.f33938e = fb.c.b(typedArray, db.a.f24692m);
                this.f33947n = typedArray.getInteger(db.a.f24693n, 30000);
                int resourceId = typedArray.getResourceId(db.a.f24694o, -1);
                if (resourceId != -1) {
                    InputStream inputStreamOpenRawResource = context.getResources().openRawResource(resourceId);
                    t.e(inputStreamOpenRawResource, "context.resources.openRawResource(metaFieldsResId)");
                    mapG = fb.c.a(inputStreamOpenRawResource);
                } else {
                    mapG = r0.g();
                }
                this.f33939f = mapG;
                int resourceId2 = typedArray.getResourceId(db.a.f24695p, -1);
                if (resourceId2 != -1) {
                    InputStream inputStreamOpenRawResource2 = context.getResources().openRawResource(resourceId2);
                    t.e(inputStreamOpenRawResource2, "context.resources.openRa…sensitiveMetaFieldsResId)");
                    mapG2 = fb.c.a(inputStreamOpenRawResource2);
                } else {
                    mapG2 = r0.g();
                }
                this.f33940g = mapG2;
                setAcceptThirdPartyCookies(typedArray.getBoolean(db.a.f24687h, false));
                String string = typedArray.getString(db.a.f24689j);
                if (string != null) {
                    t.e(string, "this");
                    setDeviceToken(string);
                }
                typedArray.recycle();
                String str = this.f33934a;
                if (str == null) {
                    t.A("handle");
                }
                this.f33944k = str.length() > 0;
            } catch (Throwable th) {
                typedArray.recycle();
                throw th;
            }
        }
        boolean zK = k();
        if (zK) {
            WebSettings settings = getSettings();
            t.e(settings, "settings");
            settings.setAllowUniversalAccessFromFileURLs(true);
        } else if (!zK) {
            WebSettings settings2 = getSettings();
            t.e(settings2, "settings");
            settings2.setAllowFileAccessFromFileURLs(false);
            WebSettings settings3 = getSettings();
            t.e(settings3, "settings");
            settings3.setAllowUniversalAccessFromFileURLs(false);
        }
        WebSettings settings4 = getSettings();
        t.e(settings4, "settings");
        settings4.setJavaScriptEnabled(true);
        WebSettings settings5 = getSettings();
        t.e(settings5, "settings");
        settings5.setDomStorageEnabled(true);
        setDownloadListener(new a(context));
        addJavascriptInterface(bVar, "AdaAndroid");
        j();
    }

    public final void setMetaFields(@NotNull hb.c metaFieldsBuilder) {
        t.j(metaFieldsBuilder, "metaFieldsBuilder");
        f(new eb.d(this, metaFieldsBuilder.a()));
    }

    public final void setSensitiveMetaFields(@NotNull hb.c metaFieldsBuilder) {
        t.j(metaFieldsBuilder, "metaFieldsBuilder");
        f(new eb.e(this, metaFieldsBuilder.a()));
    }
}
