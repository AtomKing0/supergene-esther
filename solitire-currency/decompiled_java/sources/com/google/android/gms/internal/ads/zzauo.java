package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import com.ironsource.v8;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzauo {
    private static final String[] zza = {"/aclk", "/pcs/click", "/dbm/clk"};
    private final String zzb = "ad.doubleclick.net";
    private final String[] zzc = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private final zzauk zzd;

    @Deprecated
    public zzauo(zzauk zzaukVar) {
        this.zzd = zzaukVar;
    }

    private final Uri zzg(Uri uri, String str) throws zzaup {
        uri.getClass();
        try {
            try {
                if (uri.getHost().equals(this.zzb)) {
                    if (uri.getPath().contains(";")) {
                        if (uri.toString().contains("dc_ms=")) {
                            throw new zzaup("Parameter already exists: dc_ms");
                        }
                        String string = uri.toString();
                        int iIndexOf = string.indexOf(";adurl");
                        if (iIndexOf != -1) {
                            int i10 = iIndexOf + 1;
                            return Uri.parse(string.substring(0, i10) + "dc_ms" + v8.i.f15833b + str + ";" + string.substring(i10));
                        }
                        String encodedPath = uri.getEncodedPath();
                        int iIndexOf2 = string.indexOf(encodedPath);
                        return Uri.parse(string.substring(0, encodedPath.length() + iIndexOf2) + ";dc_ms" + v8.i.f15833b + str + ";" + string.substring(iIndexOf2 + encodedPath.length()));
                    }
                }
            } catch (NullPointerException unused) {
            }
            if (uri.getQueryParameter("ms") != null) {
                throw new zzaup("Query parameter already exists: ms");
            }
            String string2 = uri.toString();
            int iIndexOf3 = string2.indexOf("&adurl");
            if (iIndexOf3 == -1) {
                iIndexOf3 = string2.indexOf("?adurl");
            }
            if (iIndexOf3 == -1) {
                return uri.buildUpon().appendQueryParameter("ms", str).build();
            }
            int i11 = iIndexOf3 + 1;
            return Uri.parse(string2.substring(0, i11) + "ms" + v8.i.f15833b + str + v8.i.f15835c + string2.substring(i11));
        } catch (UnsupportedOperationException unused2) {
            throw new zzaup("Provided Uri is not in a valid state");
        }
    }

    @Deprecated
    public final Uri zza(Uri uri, Context context, View view, Activity activity) throws zzaup {
        try {
            return zzg(uri, this.zzd.zzf(context, uri.getQueryParameter("ai"), view, activity));
        } catch (UnsupportedOperationException unused) {
            throw new zzaup("Provided Uri is not in a valid state");
        }
    }

    @Deprecated
    public final Uri zzb(Uri uri, Context context) throws zzaup {
        return zzg(uri, this.zzd.zzg(context));
    }

    @Deprecated
    public final zzauk zzc() {
        return this.zzd;
    }

    @Deprecated
    public final void zzd(MotionEvent motionEvent) {
        this.zzd.zzk(motionEvent);
    }

    public final boolean zze(Uri uri) {
        if (zzf(uri)) {
            String[] strArr = zza;
            for (int i10 = 0; i10 < 3; i10++) {
                if (uri.getPath().endsWith(strArr[i10])) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean zzf(Uri uri) {
        uri.getClass();
        try {
            String host = uri.getHost();
            String[] strArr = this.zzc;
            for (int i10 = 0; i10 < 3; i10++) {
                if (host.endsWith(strArr[i10])) {
                    return true;
                }
            }
        } catch (NullPointerException unused) {
        }
        return false;
    }
}
