package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.collection.SimpleArrayMap;
import e5.l;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhd {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
    public static class zza {
        private static volatile l<zzhe> zza;

        private zza() {
        }

        public static l<zzhe> zza(Context context) {
            l<zzhe> lVarZza;
            l<zzhe> lVar = zza;
            if (lVar == null) {
                synchronized (zza.class) {
                    lVar = zza;
                    if (lVar == null) {
                        new zzhd();
                        if (zzhh.zza(Build.TYPE, Build.TAGS)) {
                            if (zzgp.zza() && !context.isDeviceProtectedStorage()) {
                                context = context.createDeviceProtectedStorageContext();
                            }
                            lVarZza = zzhd.zza(context);
                        } else {
                            lVarZza = l.a();
                        }
                        zza = lVarZza;
                        lVar = lVarZza;
                    }
                }
            }
            return lVar;
        }
    }

    private static zzhe zza(Context context, File file) {
        BufferedReader bufferedReader;
        SimpleArrayMap simpleArrayMap;
        HashMap map;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            try {
                simpleArrayMap = new SimpleArrayMap();
                map = new HashMap();
            } finally {
            }
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                Log.w("HermeticFileOverrides", "Parsed " + String.valueOf(file) + " for Android package " + context.getPackageName());
                zzgv zzgvVar = new zzgv(simpleArrayMap);
                bufferedReader.close();
                return zzgvVar;
            }
            String[] strArrSplit = line.split(" ", 3);
            if (strArrSplit.length != 3) {
                Log.e("HermeticFileOverrides", "Invalid: " + line);
            } else {
                String strZza = zza(strArrSplit[0]);
                String strDecode = Uri.decode(zza(strArrSplit[1]));
                String strDecode2 = (String) map.get(strArrSplit[2]);
                if (strDecode2 == null) {
                    String strZza2 = zza(strArrSplit[2]);
                    strDecode2 = Uri.decode(strZza2);
                    if (strDecode2.length() < 1024 || strDecode2 == strZza2) {
                        map.put(strZza2, strDecode2);
                    }
                }
                SimpleArrayMap simpleArrayMap2 = (SimpleArrayMap) simpleArrayMap.get(strZza);
                if (simpleArrayMap2 == null) {
                    simpleArrayMap2 = new SimpleArrayMap();
                    simpleArrayMap.put(strZza, simpleArrayMap2);
                }
                simpleArrayMap2.put(strDecode, strDecode2);
            }
            throw new RuntimeException(e10);
        }
    }

    private static l<File> zzb(Context context) {
        try {
            File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
            return file.exists() ? l.d(file) : l.a();
        } catch (RuntimeException e10) {
            Log.e("HermeticFileOverrides", "no data dir", e10);
            return l.a();
        }
    }

    @VisibleForTesting
    static l<zzhe> zza(Context context) {
        l<zzhe> lVarA;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            l<File> lVarZzb = zzb(context);
            if (lVarZzb.c()) {
                lVarA = l.d(zza(context, lVarZzb.b()));
            } else {
                lVarA = l.a();
            }
            return lVarA;
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    private static final String zza(String str) {
        return new String(str);
    }
}
