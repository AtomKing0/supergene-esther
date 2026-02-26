package com.google.android.gms.internal.consent_sdk;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zze {
    private final Executor zza;

    zze(Executor executor) {
        this.zza = executor;
    }

    @AnyThread
    public final Executor zza() {
        return this.zza;
    }

    @AnyThread
    public final void zzb(@Nullable final String str, @Nullable final String str2, final zzd... zzdVarArr) {
        this.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.consent_sdk.zzc
            @Override // java.lang.Runnable
            public final void run() {
                final JSONObject jSONObject;
                String str3 = str;
                if (TextUtils.isEmpty(str3)) {
                    Log.d("UserMessagingPlatform", "Error on action: empty action name");
                    return;
                }
                String str4 = str2;
                final String lowerCase = str3.toLowerCase();
                if (TextUtils.isEmpty(str4)) {
                    jSONObject = new JSONObject();
                } else {
                    try {
                        jSONObject = new JSONObject(str4);
                    } catch (JSONException unused) {
                        Log.d("UserMessagingPlatform", "Action[" + lowerCase + "]: failed to parse args: " + str4);
                        return;
                    }
                }
                zzd[] zzdVarArr2 = zzdVarArr;
                Log.d("UserMessagingPlatform", "Action[" + lowerCase + "]: " + jSONObject.toString());
                for (final zzd zzdVar : zzdVarArr2) {
                    FutureTask futureTask = new FutureTask(new Callable() { // from class: com.google.android.gms.internal.consent_sdk.zzb
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return Boolean.valueOf(zzdVar.zzb(lowerCase, jSONObject));
                        }
                    });
                    zzdVar.zza().execute(futureTask);
                    try {
                    } catch (InterruptedException e10) {
                        Log.d("UserMessagingPlatform", "Thread interrupted for Action[" + lowerCase + "]: ", e10);
                    } catch (ExecutionException e11) {
                        Log.d("UserMessagingPlatform", "Failed to run Action[" + lowerCase + "]: ", e11.getCause());
                    }
                    if (((Boolean) futureTask.get()).booleanValue()) {
                        return;
                    }
                }
            }
        });
    }
}
