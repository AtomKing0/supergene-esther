package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbsn;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public final class AdActivity extends Activity {

    @NonNull
    @KeepForSdk
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";

    @Nullable
    private zzbsn zza;

    private final void zza() {
        zzbsn zzbsnVar = this.zza;
        if (zzbsnVar != null) {
            try {
                zzbsnVar.zzx();
            } catch (RemoteException e10) {
                zzm.zzl("#007 Could not call remote method.", e10);
            }
        }
    }

    @Override // android.app.Activity
    protected final void onActivityResult(int i10, int i11, @NonNull Intent intent) {
        try {
            zzbsn zzbsnVar = this.zza;
            if (zzbsnVar != null) {
                zzbsnVar.zzh(i10, i11, intent);
            }
        } catch (Exception e10) {
            zzm.zzl("#007 Could not call remote method.", e10);
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        try {
            zzbsn zzbsnVar = this.zza;
            if (zzbsnVar != null) {
                if (!zzbsnVar.zzH()) {
                    return;
                }
            }
        } catch (RemoteException e10) {
            zzm.zzl("#007 Could not call remote method.", e10);
        }
        super.onBackPressed();
        try {
            zzbsn zzbsnVar2 = this.zza;
            if (zzbsnVar2 != null) {
                zzbsnVar2.zzi();
            }
        } catch (RemoteException e11) {
            zzm.zzl("#007 Could not call remote method.", e11);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            zzbsn zzbsnVar = this.zza;
            if (zzbsnVar != null) {
                zzbsnVar.zzk(ObjectWrapper.wrap(configuration));
            }
        } catch (RemoteException e10) {
            zzm.zzl("#007 Could not call remote method.", e10);
        }
    }

    @Override // android.app.Activity
    protected final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        zzbsn zzbsnVarZzo = zzay.zza().zzo(this);
        this.zza = zzbsnVarZzo;
        if (zzbsnVarZzo == null) {
            zzm.zzl("#007 Could not call remote method.", null);
            finish();
            return;
        }
        try {
            zzbsnVarZzo.zzl(bundle);
        } catch (RemoteException e10) {
            zzm.zzl("#007 Could not call remote method.", e10);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onDestroy() {
        try {
            zzbsn zzbsnVar = this.zza;
            if (zzbsnVar != null) {
                zzbsnVar.zzm();
            }
        } catch (RemoteException e10) {
            zzm.zzl("#007 Could not call remote method.", e10);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected final void onPause() {
        try {
            zzbsn zzbsnVar = this.zza;
            if (zzbsnVar != null) {
                zzbsnVar.zzo();
            }
        } catch (RemoteException e10) {
            zzm.zzl("#007 Could not call remote method.", e10);
            finish();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr) {
        try {
            zzbsn zzbsnVar = this.zza;
            if (zzbsnVar != null) {
                zzbsnVar.zzp(i10, strArr, iArr);
            }
        } catch (RemoteException e10) {
            zzm.zzl("#007 Could not call remote method.", e10);
        }
    }

    @Override // android.app.Activity
    protected final void onRestart() {
        super.onRestart();
        try {
            zzbsn zzbsnVar = this.zza;
            if (zzbsnVar != null) {
                zzbsnVar.zzq();
            }
        } catch (RemoteException e10) {
            zzm.zzl("#007 Could not call remote method.", e10);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onResume() {
        super.onResume();
        try {
            zzbsn zzbsnVar = this.zza;
            if (zzbsnVar != null) {
                zzbsnVar.zzr();
            }
        } catch (RemoteException e10) {
            zzm.zzl("#007 Could not call remote method.", e10);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onSaveInstanceState(@NonNull Bundle bundle) {
        try {
            zzbsn zzbsnVar = this.zza;
            if (zzbsnVar != null) {
                zzbsnVar.zzs(bundle);
            }
        } catch (RemoteException e10) {
            zzm.zzl("#007 Could not call remote method.", e10);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected final void onStart() {
        super.onStart();
        try {
            zzbsn zzbsnVar = this.zza;
            if (zzbsnVar != null) {
                zzbsnVar.zzt();
            }
        } catch (RemoteException e10) {
            zzm.zzl("#007 Could not call remote method.", e10);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onStop() {
        try {
            zzbsn zzbsnVar = this.zza;
            if (zzbsnVar != null) {
                zzbsnVar.zzu();
            }
        } catch (RemoteException e10) {
            zzm.zzl("#007 Could not call remote method.", e10);
            finish();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    protected final void onUserLeaveHint() {
        super.onUserLeaveHint();
        try {
            zzbsn zzbsnVar = this.zza;
            if (zzbsnVar != null) {
                zzbsnVar.zzv();
            }
        } catch (RemoteException e10) {
            zzm.zzl("#007 Could not call remote method.", e10);
        }
    }

    @Override // android.app.Activity
    public final void setContentView(int i10) {
        super.setContentView(i10);
        zza();
    }

    @Override // android.app.Activity
    public final void setContentView(@NonNull View view) {
        super.setContentView(view);
        zza();
    }

    @Override // android.app.Activity
    public final void setContentView(@NonNull View view, @NonNull ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zza();
    }
}
