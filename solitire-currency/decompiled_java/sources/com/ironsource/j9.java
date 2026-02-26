package com.ironsource;

import android.util.Log;
import com.ironsource.mediationsdk.logger.IronLog;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class j9 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final JSONObject f12716a;

    public j9(@NotNull JSONObject stringToSend) {
        kotlin.jvm.internal.t.i(stringToSend, "stringToSend");
        this.f12716a = stringToSend;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("preparing to send crashes report");
            URLConnection uRLConnectionOpenConnection = new URL(i9.d().f12576h).openConnection();
            kotlin.jvm.internal.t.g(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty(nb.K, "application/json;charset=UTF-8");
            httpURLConnection.setRequestProperty("Accept", nb.L);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.writeBytes(this.f12716a.toString());
            dataOutputStream.flush();
            dataOutputStream.close();
            Log.i("STATUS", String.valueOf(httpURLConnection.getResponseCode()));
            Log.i("MSG", httpURLConnection.getResponseMessage());
            httpURLConnection.disconnect();
            ironLog.verbose("sent crash report for type " + this.f12716a.get("crashType") + " and date " + this.f12716a.get("crashDate"));
        } catch (Exception e10) {
            IronLog.INTERNAL.error(e10.toString());
        }
    }
}
