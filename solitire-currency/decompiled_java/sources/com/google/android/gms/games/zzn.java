package com.google.android.gms.games;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzn implements Api.ApiOptions.Optional, GoogleSignInOptionsExtension, Api.ApiOptions.HasGoogleSignInAccountOptions {
    public final int zze;
    public final ArrayList zzg;
    public final GoogleSignInAccount zzk;

    @Nullable
    public final String zzn;
    public final com.google.android.gms.games.internal.zzl zzo;
    public final boolean zza = false;
    public final boolean zzb = true;
    public final int zzc = 17;
    public final boolean zzd = false;
    public final String zzf = null;
    public final boolean zzh = false;
    public final boolean zzi = false;
    public final boolean zzj = false;
    public final String zzl = null;
    private final int zzp = 0;
    public final int zzm = 9;

    /* synthetic */ zzn(boolean z10, boolean z11, int i10, boolean z12, int i11, String str, ArrayList arrayList, boolean z13, boolean z14, boolean z15, GoogleSignInAccount googleSignInAccount, String str2, int i12, int i13, String str3, com.google.android.gms.games.internal.zzl zzlVar, zzm zzmVar) {
        this.zze = i11;
        this.zzg = arrayList;
        this.zzk = googleSignInAccount;
        this.zzn = str3;
        this.zzo = zzlVar;
    }

    public static zzl zzb() {
        return new zzl(null);
    }

    public final boolean equals(@Nullable Object obj) {
        GoogleSignInAccount googleSignInAccount;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzn)) {
            return false;
        }
        zzn zznVar = (zzn) obj;
        boolean z10 = zznVar.zza;
        return this.zze == zznVar.zze && this.zzg.equals(zznVar.zzg) && ((googleSignInAccount = this.zzk) != null ? googleSignInAccount.equals(zznVar.zzk) : zznVar.zzk == null) && TextUtils.equals(null, null) && Objects.equal(this.zzn, zznVar.zzn);
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension
    public final int getExtensionType() {
        return 1;
    }

    @Override // com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions
    public final GoogleSignInAccount getGoogleSignInAccount() {
        return this.zzk;
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension
    public final List getImpliedScopes() {
        return Collections.singletonList(Games.zzc);
    }

    public final int hashCode() {
        int iHashCode = (((this.zze + 486741695) * 961) + this.zzg.hashCode()) * 923521;
        GoogleSignInAccount googleSignInAccount = this.zzk;
        int iHashCode2 = (((iHashCode + (googleSignInAccount == null ? 0 : googleSignInAccount.hashCode())) * 29791) + 9) * 31;
        String str = this.zzn;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension
    public final Bundle toBundle() {
        return zza();
    }

    public final Bundle zza() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.games.key.isHeadless", false);
        bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", true);
        bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", 17);
        bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", false);
        bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.zze);
        bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", null);
        bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.zzg);
        bundle.putBoolean("com.google.android.gms.games.key.unauthenticated", false);
        bundle.putBoolean("com.google.android.gms.games.key.skipPgaCheck", false);
        bundle.putBoolean("com.google.android.gms.games.key.skipWelcomePopup", false);
        bundle.putParcelable("com.google.android.gms.games.key.googleSignInAccount", this.zzk);
        bundle.putString("com.google.android.gms.games.key.realClientPackageName", null);
        bundle.putInt("com.google.android.gms.games.key.API_VERSION", 9);
        bundle.putString("com.google.android.gms.games.key.gameRunToken", this.zzn);
        return bundle;
    }
}
