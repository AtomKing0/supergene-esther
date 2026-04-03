package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.play_billing.zzga;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
final class zzn extends BroadcastReceiver {
    final /* synthetic */ zzo zza;
    private boolean zzb;
    private final boolean zzc;

    zzn(zzo zzoVar, boolean z10) {
        this.zza = zzoVar;
        this.zzc = z10;
    }

    private final void zzd(Bundle bundle, BillingResult billingResult, int i10) {
        if (bundle.getByteArray("FAILURE_LOGGING_PAYLOAD") == null) {
            this.zza.zze.zza(zzcb.zza(23, i10, billingResult));
            return;
        }
        try {
            this.zza.zze.zza(zzga.zzA(bundle.getByteArray("FAILURE_LOGGING_PAYLOAD"), com.google.android.gms.internal.play_billing.zzcd.zza()));
        } catch (Throwable unused) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingBroadcastManager", "Failed parsing Api failure.");
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingBroadcastManager", "Bundle is null.");
            zzcc zzccVar = this.zza.zze;
            BillingResult billingResult = zzce.zzj;
            zzccVar.zza(zzcb.zza(11, 1, billingResult));
            zzo zzoVar = this.zza;
            if (zzoVar.zzb != null) {
                zzoVar.zzb.onPurchasesUpdated(billingResult, null);
                return;
            }
            return;
        }
        BillingResult billingResultZze = com.google.android.gms.internal.play_billing.zzb.zze(intent, "BillingBroadcastManager");
        String action = intent.getAction();
        int i10 = true != Objects.equals(extras.getString("INTENT_SOURCE"), "LAUNCH_BILLING_FLOW") ? 1 : 2;
        if (action.equals("com.android.vending.billing.PURCHASES_UPDATED") || action.equals("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED")) {
            List<Purchase> listZzi = com.google.android.gms.internal.play_billing.zzb.zzi(extras);
            if (billingResultZze.getResponseCode() == 0) {
                this.zza.zze.zzc(zzcb.zzc(i10));
            } else {
                zzd(extras, billingResultZze, i10);
            }
            this.zza.zzb.onPurchasesUpdated(billingResultZze, listZzi);
            return;
        }
        if (action.equals("com.android.vending.billing.ALTERNATIVE_BILLING")) {
            if (billingResultZze.getResponseCode() != 0) {
                zzd(extras, billingResultZze, i10);
                this.zza.zzb.onPurchasesUpdated(billingResultZze, com.google.android.gms.internal.play_billing.zzai.zzk());
                return;
            }
            zzo zzoVar2 = this.zza;
            if (zzoVar2.zzc == null && zzoVar2.zzd == null) {
                com.google.android.gms.internal.play_billing.zzb.zzk("BillingBroadcastManager", "AlternativeBillingListener and UserChoiceBillingListener is null.");
                zzcc zzccVar2 = this.zza.zze;
                BillingResult billingResult2 = zzce.zzj;
                zzccVar2.zza(zzcb.zza(77, i10, billingResult2));
                this.zza.zzb.onPurchasesUpdated(billingResult2, com.google.android.gms.internal.play_billing.zzai.zzk());
                return;
            }
            String string = extras.getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
            if (string == null) {
                com.google.android.gms.internal.play_billing.zzb.zzk("BillingBroadcastManager", "Couldn't find alternative billing user choice data in bundle.");
                zzcc zzccVar3 = this.zza.zze;
                BillingResult billingResult3 = zzce.zzj;
                zzccVar3.zza(zzcb.zza(16, i10, billingResult3));
                this.zza.zzb.onPurchasesUpdated(billingResult3, com.google.android.gms.internal.play_billing.zzai.zzk());
                return;
            }
            try {
                if (this.zza.zzd != null) {
                    this.zza.zzd.userSelectedAlternativeBilling(new UserChoiceDetails(string));
                } else {
                    JSONArray jSONArrayOptJSONArray = new JSONObject(string).optJSONArray("products");
                    ArrayList arrayList = new ArrayList();
                    if (jSONArrayOptJSONArray != null) {
                        for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i11);
                            if (jSONObjectOptJSONObject != null) {
                                arrayList.add(new zze(jSONObjectOptJSONObject, null));
                            }
                        }
                    }
                    this.zza.zzc.zza();
                }
                this.zza.zze.zzc(zzcb.zzc(i10));
            } catch (JSONException unused) {
                com.google.android.gms.internal.play_billing.zzb.zzk("BillingBroadcastManager", String.format("Error when parsing invalid user choice data: [%s]", string));
                zzcc zzccVar4 = this.zza.zze;
                BillingResult billingResult4 = zzce.zzj;
                zzccVar4.zza(zzcb.zza(17, i10, billingResult4));
                this.zza.zzb.onPurchasesUpdated(billingResult4, com.google.android.gms.internal.play_billing.zzai.zzk());
            }
        }
    }

    public final synchronized void zza(Context context, IntentFilter intentFilter) {
        if (this.zzb) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(this, intentFilter, true != this.zzc ? 4 : 2);
        } else {
            context.registerReceiver(this, intentFilter);
        }
        this.zzb = true;
    }

    public final synchronized void zzb(Context context, IntentFilter intentFilter, String str) {
        if (this.zzb) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(this, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null, true != this.zzc ? 4 : 2);
        } else {
            context.registerReceiver(this, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null);
        }
        this.zzb = true;
    }

    public final synchronized void zzc(Context context) {
        if (!this.zzb) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingBroadcastManager", "Receiver is not registered.");
        } else {
            context.unregisterReceiver(this);
            this.zzb = false;
        }
    }
}
