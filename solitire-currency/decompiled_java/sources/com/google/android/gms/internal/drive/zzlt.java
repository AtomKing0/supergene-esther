package com.google.android.gms.internal.drive;

import com.ironsource.v8;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzlt {
    static String zza(zzlq zzlqVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zza(zzlqVar, sb, 0);
        return sb.toString();
    }

    private static final String zzo(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (Character.isUpperCase(cCharAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(cCharAt));
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void zza(com.google.android.gms.internal.drive.zzlq r18, java.lang.StringBuilder r19, int r20) {
        /*
            Method dump skipped, instruction units count: 662
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zzlt.zza(com.google.android.gms.internal.drive.zzlq, java.lang.StringBuilder, int):void");
    }

    static final void zza(StringBuilder sb, int i10, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zza(sb, i10, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zza(sb, i10, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(zzmt.zzc(zzjc.zzk((String) obj)));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzjc) {
            sb.append(": \"");
            sb.append(zzmt.zzc((zzjc) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzkk) {
            sb.append(" {");
            zza((zzkk) obj, sb, i10 + 2);
            sb.append("\n");
            while (i11 < i10) {
                sb.append(' ');
                i11++;
            }
            sb.append("}");
            return;
        }
        if (obj instanceof Map.Entry) {
            sb.append(" {");
            Map.Entry entry = (Map.Entry) obj;
            int i13 = i10 + 2;
            zza(sb, i13, v8.h.W, entry.getKey());
            zza(sb, i13, "value", entry.getValue());
            sb.append("\n");
            while (i11 < i10) {
                sb.append(' ');
                i11++;
            }
            sb.append("}");
            return;
        }
        sb.append(": ");
        sb.append(obj.toString());
    }
}
