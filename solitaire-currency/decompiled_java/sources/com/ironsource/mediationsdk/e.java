package com.ironsource.mediationsdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.f5;
import com.ironsource.h5;
import com.ironsource.i9;
import com.ironsource.l4;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.d;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.nb;
import com.ironsource.xa;
import io.sentry.protocol.Request;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f13552a = "1";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f13553b = "102";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f13554c = "102";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f13555d = "GenericNotifications";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private f f13556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private IronSource.AD_UNIT f13557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private h5 f13558g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private l4 f13559h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ISBannerSize f13560i;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected WeakReference<l4> f13561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected d.a f13562b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected int f13563c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected String f13564d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        protected long f13565e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        protected int f13566f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f13568h;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final URL f13571k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final JSONObject f13572l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final boolean f13573m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final int f13574n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final long f13575o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final boolean f13576p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final boolean f13577q;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        protected String f13567g = Request.JsonKeys.OTHER;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        protected String f13569i = "";

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        protected int f13570j = 0;

        public a(l4 l4Var, URL url, JSONObject jSONObject, boolean z10, int i10, long j10, boolean z11, boolean z12, int i11) {
            this.f13561a = new WeakReference<>(l4Var);
            this.f13571k = url;
            this.f13572l = jSONObject;
            this.f13573m = z10;
            this.f13574n = i10;
            this.f13575o = j10;
            this.f13576p = z11;
            this.f13577q = z12;
            this.f13568h = i11;
        }

        private String a() {
            return this.f13568h == 2 ? xa.b().d() : xa.b().c();
        }

        private JSONObject b(String str, String str2) throws JSONException {
            IronLog.INTERNAL.verbose("decrypting and decompressing auction response");
            String strDecryptAndDecompress = IronSourceAES.decryptAndDecompress(str, str2);
            if (strDecryptAndDecompress != null) {
                return new JSONObject(strDecryptAndDecompress);
            }
            throw new JSONException("decompression error");
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zB = b();
            l4 l4Var = this.f13561a.get();
            if (l4Var == null) {
                return;
            }
            a(zB, l4Var, new Date().getTime() - this.f13565e);
        }

        private String a(HttpURLConnection httpURLConnection) throws IOException {
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    inputStreamReader.close();
                    return sb.toString();
                }
                sb.append(line);
            }
        }

        protected boolean b() {
            long time;
            int responseCode;
            String str;
            this.f13565e = new Date().getTime();
            try {
                this.f13568h = this.f13570j == 1015 ? 1 : this.f13568h;
                this.f13566f = 0;
                HttpURLConnection httpURLConnectionA = null;
                while (true) {
                    int i10 = this.f13566f;
                    int i11 = this.f13574n;
                    if (i10 >= i11) {
                        this.f13566f = i11 - 1;
                        this.f13567g = "trials_fail";
                        return false;
                    }
                    try {
                        time = new Date().getTime();
                        String str2 = "Auction Handler: auction trial " + (this.f13566f + 1) + " out of " + this.f13574n + " max trials";
                        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, str2, 0);
                        IronSourceUtils.sendAutomationLog(str2);
                        httpURLConnectionA = a(this.f13571k, this.f13575o);
                        a(httpURLConnectionA, this.f13572l, this.f13576p);
                        responseCode = httpURLConnectionA.getResponseCode();
                    } catch (SocketTimeoutException e10) {
                        i9.d().a(e10);
                        if (httpURLConnectionA != null) {
                            httpURLConnectionA.disconnect();
                        }
                        this.f13563c = 1006;
                        this.f13564d = "Connection timed out";
                        IronLog.INTERNAL.error("Auction socket timeout exception " + e10.getMessage());
                    } catch (Throwable th) {
                        i9.d().a(th);
                        IronLog.INTERNAL.error("getting exception " + th);
                        if (httpURLConnectionA != null) {
                            httpURLConnectionA.disconnect();
                        }
                        this.f13563c = 1000;
                        this.f13564d = th.getMessage();
                        this.f13567g = Request.JsonKeys.OTHER;
                        return false;
                    }
                    if (responseCode == 200 || responseCode == 204) {
                        try {
                            a(a(httpURLConnectionA), this.f13573m, this.f13577q);
                            httpURLConnectionA.disconnect();
                            return true;
                        } catch (JSONException e11) {
                            i9.d().a(e11);
                            if (e11.getMessage() != null && e11.getMessage().equalsIgnoreCase("decryption error")) {
                                this.f13563c = 1003;
                                str = "Auction decryption error";
                            } else if (e11.getMessage() == null || !e11.getMessage().equalsIgnoreCase("decompression error")) {
                                this.f13563c = 1002;
                                str = "Auction parsing error";
                            } else {
                                this.f13563c = 1008;
                                str = "Auction decompression error";
                            }
                            this.f13564d = str;
                            this.f13567g = "parsing";
                            IronLog.INTERNAL.error("Auction handle response exception " + e11.getMessage());
                            httpURLConnectionA.disconnect();
                            return false;
                        }
                    }
                    this.f13563c = 1001;
                    String str3 = "Auction response code not valid, error code response from server - " + responseCode;
                    this.f13564d = str3;
                    IronLog.INTERNAL.error(str3);
                    httpURLConnectionA.disconnect();
                    if (this.f13566f < this.f13574n - 1) {
                        a(this.f13575o, time);
                    }
                    this.f13566f++;
                }
            } catch (Exception e12) {
                i9.d().a(e12);
                this.f13563c = 1007;
                this.f13564d = e12.getMessage();
                this.f13566f = 0;
                this.f13567g = Request.JsonKeys.OTHER;
                IronLog.INTERNAL.error("Auction request exception " + e12.getMessage());
                return false;
            }
        }

        private HttpURLConnection a(URL url, long j10) throws IOException {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty(nb.K, "application/json; charset=utf-8");
            httpURLConnection.setReadTimeout((int) j10);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            return httpURLConnection;
        }

        private JSONObject a(String str, String str2) throws JSONException {
            String strDecode = IronSourceAES.decode(str, str2);
            if (TextUtils.isEmpty(strDecode)) {
                throw new JSONException("decryption error");
            }
            return new JSONObject(strDecode);
        }

        protected JSONObject a(JSONObject jSONObject, boolean z10) throws JSONException {
            String strA = a();
            String string = jSONObject.getString(this.f13568h == 2 ? "ct" : "response");
            return z10 ? b(strA, string) : a(strA, string);
        }

        private void a(long j10, long j11) {
            long time = j10 - (new Date().getTime() - j11);
            if (time > 0) {
                SystemClock.sleep(time);
            }
        }

        protected void a(String str, boolean z10, boolean z11) throws JSONException {
            if (TextUtils.isEmpty(str)) {
                throw new JSONException("empty response");
            }
            JSONObject jSONObject = new JSONObject(str);
            if (z10) {
                jSONObject = a(jSONObject, z11);
            }
            d.a aVarA = d.b().a(jSONObject);
            this.f13562b = aVarA;
            this.f13563c = aVarA.c();
            this.f13564d = this.f13562b.d();
        }

        private void a(HttpURLConnection httpURLConnection, JSONObject jSONObject, boolean z10) throws Exception {
            String strA;
            String strEncode;
            OutputStream outputStream = httpURLConnection.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            if (this.f13568h == 2) {
                try {
                    strA = xa.b().a();
                } catch (JSONException e10) {
                    i9.d().a(e10);
                    this.f13569i = e10.getLocalizedMessage();
                    this.f13570j = 1015;
                    this.f13568h = 1;
                    IronLog.INTERNAL.error("get encrypted session key exception " + e10.getMessage());
                    strA = "";
                }
            } else {
                strA = "";
            }
            String string = jSONObject.toString();
            String strA2 = a();
            if (z10) {
                IronLog.INTERNAL.verbose("compressing and encrypting auction request");
                strEncode = IronSourceAES.compressAndEncrypt(strA2, string);
            } else {
                strEncode = IronSourceAES.encode(strA2, string);
            }
            bufferedWriter.write(this.f13568h == 2 ? String.format("{\"sk\" : \"%1$s\", \"ct\" : \"%2$s\"}", strA, strEncode) : String.format("{\"request\" : \"%1$s\"}", strEncode));
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStreamWriter.close();
            outputStream.close();
        }

        protected void a(boolean z10, l4 l4Var, long j10) {
            if (z10) {
                l4Var.a(this.f13562b.h(), this.f13562b.a(), this.f13562b.e(), this.f13562b.f(), this.f13562b.b(), this.f13566f + 1, j10, this.f13570j, this.f13569i);
            } else {
                l4Var.a(this.f13563c, this.f13564d, this.f13566f + 1, this.f13567g, j10);
            }
        }
    }

    @Deprecated
    public e(IronSource.AD_UNIT ad_unit, h5 h5Var, l4 l4Var) {
        this.f13557f = ad_unit;
        this.f13558g = h5Var;
        this.f13559h = l4Var;
    }

    private JSONObject a(Map<String, Object> map, List<String> list, h hVar, int i10, boolean z10, IronSourceSegment ironSourceSegment) throws JSONException {
        i iVar = new i(this.f13557f);
        iVar.a(map);
        iVar.a(list);
        iVar.a(hVar);
        iVar.a(i10);
        iVar.a(this.f13560i);
        iVar.a(ironSourceSegment);
        iVar.b(z10);
        return d.b().a(iVar);
    }

    public e(f fVar) {
        this.f13556e = fVar;
    }

    public void a(Context context, i iVar, l4 l4Var) {
        try {
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(this.f13556e.a(context, iVar, l4Var));
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error("execute auction exception " + e10.getMessage());
            if (l4Var != null) {
                l4Var.a(1000, e10.getMessage(), 0, Request.JsonKeys.OTHER, 0L);
            }
        }
    }

    @Deprecated
    public void a(Context context, Map<String, Object> map, List<String> list, h hVar, int i10, IronSourceSegment ironSourceSegment) {
        try {
            boolean zIsEncryptedResponse = IronSourceUtils.isEncryptedResponse();
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new a(this.f13559h, new URL(this.f13558g.a(false)), a(map, list, hVar, i10, zIsEncryptedResponse, ironSourceSegment), zIsEncryptedResponse, this.f13558g.g(), this.f13558g.m(), this.f13558g.n(), this.f13558g.o(), this.f13558g.d()));
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error("execute auction exception " + e10.getMessage());
            this.f13559h.a(1000, e10.getMessage(), 0, Request.JsonKeys.OTHER, 0L);
        }
    }

    @Deprecated
    public void a(Context context, Map<String, Object> map, List<String> list, h hVar, int i10, IronSourceSegment ironSourceSegment, ISBannerSize iSBannerSize) {
        this.f13560i = iSBannerSize;
        a(context, map, list, hVar, i10, ironSourceSegment);
    }

    public void a(f5 f5Var, int i10, f5 f5Var2) {
        Iterator<String> it = f5Var.g().iterator();
        while (it.hasNext()) {
            d.b().a("reportLoadSuccess", f5Var.c(), d.b().a(it.next(), i10, f5Var, "", "", ""));
        }
        if (f5Var2 != null) {
            Iterator<String> it2 = f5Var2.g().iterator();
            while (it2.hasNext()) {
                d.b().a("reportLoadSuccess", "GenericNotifications", d.b().a(it2.next(), i10, f5Var, "", "102", ""));
            }
        }
    }

    public void a(f5 f5Var, int i10, f5 f5Var2, String str) {
        Iterator<String> it = f5Var.b().iterator();
        while (it.hasNext()) {
            d.b().a("reportImpression", f5Var.c(), d.b().a(it.next(), i10, f5Var, "", "", str));
        }
        if (f5Var2 != null) {
            Iterator<String> it2 = f5Var2.b().iterator();
            while (it2.hasNext()) {
                d.b().a("reportImpression", "GenericNotifications", d.b().a(it2.next(), i10, f5Var, "", "102", str));
            }
        }
    }

    public void a(ArrayList<String> arrayList, ConcurrentHashMap<String, f5> concurrentHashMap, int i10, f5 f5Var, f5 f5Var2) {
        int i11 = f5Var2.i();
        for (String str : arrayList) {
            if (!str.equals(f5Var2.c())) {
                f5 f5Var3 = concurrentHashMap.get(str);
                int i12 = f5Var3.i();
                String strH = f5Var3.h();
                String str2 = i12 < i11 ? "1" : "102";
                IronLog.INTERNAL.verbose("instance=" + f5Var3.c() + ", instancePriceOrder= " + i12 + ", loseReasonCode=" + str2 + ", winnerInstance=" + f5Var2.c() + ", winnerInstancePriceOrder=" + i11);
                Iterator<String> it = f5Var3.f().iterator();
                while (it.hasNext()) {
                    d.b().a("reportAuctionLose", f5Var3.c(), d.b().a(it.next(), i10, f5Var2, strH, str2, ""));
                }
            }
        }
        if (f5Var != null) {
            Iterator<String> it2 = f5Var.f().iterator();
            while (it2.hasNext()) {
                d.b().a("reportAuctionLose", "GenericNotifications", d.b().a(it2.next(), i10, f5Var2, "", "102", ""));
            }
        }
    }

    public void a(CopyOnWriteArrayList<y> copyOnWriteArrayList, ConcurrentHashMap<String, f5> concurrentHashMap, int i10, f5 f5Var, f5 f5Var2) {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<y> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().c());
        }
        a(arrayList, concurrentHashMap, i10, f5Var, f5Var2);
    }

    public boolean a() {
        return this.f13556e.a();
    }
}
