package com.onetrust.otpublishers.headless.Internal.Network;

import ab.y;
import ab.z;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.onetrust.otpublishers.headless.Internal.Helper.v;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import ga.z;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class ConsentUploadWorker extends Worker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21837a;

    public ConsentUploadWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f21837a = context;
        OTLogger.g();
    }

    @Override // androidx.work.Worker
    @NonNull
    public final ListenableWorker.Result doWork() {
        boolean z10;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        y<String> yVarExecute;
        int i10;
        String str;
        OTLogger.a("CPWorker", 4, "do work");
        Data inputData = getInputData();
        String string = inputData.getString("ott_consent_log_base_url");
        String string2 = inputData.getString("ott_consent_log_end_point");
        String string3 = getInputData().getString("ott_payload_id");
        Context context = this.f21837a;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (com.onetrust.otpublishers.headless.Internal.Helper.l.a(context)) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            z10 = false;
            hVar = null;
        }
        String string4 = (z10 ? hVar : sharedPreferences).getString(string3, "");
        OTLogger.a("CPWorker", 3, ",data present in pref with payloadKeyId :" + string3 + " data: " + string4);
        if (com.onetrust.otpublishers.headless.Internal.c.q(string) || com.onetrust.otpublishers.headless.Internal.c.q(string2)) {
            return ListenableWorker.Result.failure();
        }
        Context context2 = this.f21837a;
        SharedPreferences sharedPreferences2 = context2.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (com.onetrust.otpublishers.headless.Internal.Helper.l.a(context2)) {
            new com.onetrust.otpublishers.headless.Internal.Preferences.h(context2, sharedPreferences2, sharedPreferences2.getString("OT_ACTIVE_PROFILE_ID", ""));
        }
        try {
            yVarExecute = ((a) new z.b().c(string).a(bb.k.f()).f(new z.a().b()).d().b(a.class)).a(string2, string4).execute();
        } catch (IOException e10) {
            e = e10;
            yVarExecute = null;
        }
        try {
            OTLogger.a("NetworkRequestHandler", 4, "response = " + yVarExecute.a());
            OTLogger.a("NetworkRequestHandler", 4, "response code = " + yVarExecute.b());
            i10 = 4;
        } catch (IOException e11) {
            e = e11;
            i10 = 4;
            OTLogger.a("NetworkRequestHandler", 4, " network call response error out = " + e.getMessage());
        }
        OTLogger.a("CPWorker", i10, "consentLoggingStatus = " + yVarExecute);
        if (yVarExecute == null) {
            OTLogger.a("CPWorker", i10, " empty response");
            return ListenableWorker.Result.retry();
        }
        int iB = yVarExecute.b();
        if (iB >= 200 && iB < 300) {
            (z10 ? hVar : sharedPreferences).edit().remove(string3).apply();
            StringBuilder sb = new StringBuilder("payloadKeyId: ");
            sb.append(string3);
            sb.append(",data present in pref:");
            sb.append((z10 ? hVar : sharedPreferences).contains(string3));
            OTLogger.a("CPWorker", 3, sb.toString());
            String strA = yVarExecute.a();
            if (com.onetrust.otpublishers.headless.Internal.c.q(strA)) {
                str = null;
            } else {
                try {
                    str = (String) new JSONObject(strA).get("receipt");
                } catch (JSONException e12) {
                    com.onetrust.otpublishers.headless.Internal.Helper.p.a(e12, new StringBuilder("consent receipt json error. error msg = "), "CPWorker", 6);
                    str = null;
                }
            }
            OTLogger.a("CPWorker", 4, "consentReceiptValue = " + str);
            if (!com.onetrust.otpublishers.headless.Internal.c.q(str)) {
                if (z10) {
                    sharedPreferences = hVar;
                }
                v.a(sharedPreferences, "OTT_PROFILE_CONSENT_RECEIPT", str);
            }
            return ListenableWorker.Result.success();
        }
        boolean z11 = false;
        if (inputData.getBoolean("ott_consent_isProxy", false)) {
            OTLogger.a("CPWorker", 4, "Proxy consent log? = " + yVarExecute.a());
            return ListenableWorker.Result.failure();
        }
        if (iB >= 500 && iB < 600) {
            OTLogger.a("CPWorker", 4, " consent log? = " + yVarExecute.a());
            return ListenableWorker.Result.retry();
        }
        if (iB >= 400 && iB < 500) {
            z11 = true;
        }
        if (!z11) {
            OTLogger.a("CPWorker", 4, " consent log call returned unknown error " + yVarExecute.a());
            return ListenableWorker.Result.retry();
        }
        OTLogger.a("CPWorker", 4, " consent log? = " + yVarExecute.a());
        (z10 ? hVar : sharedPreferences).edit().remove(string3).apply();
        StringBuilder sb2 = new StringBuilder("payloadKeyId: ");
        sb2.append(string3);
        sb2.append(",data present in pref:");
        if (z10) {
            sharedPreferences = hVar;
        }
        sb2.append(sharedPreferences.contains(string3));
        OTLogger.a("CPWorker", 3, sb2.toString());
        return ListenableWorker.Result.failure();
    }
}
