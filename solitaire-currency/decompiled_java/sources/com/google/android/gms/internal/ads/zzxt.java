package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import io.sentry.protocol.SentryStackFrame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzxt extends zzxy implements zzlg {
    private static final zzfzc zzb = zzfzc.zzb(new Comparator() { // from class: com.google.android.gms.internal.ads.zzws
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            Integer num = (Integer) obj;
            Integer num2 = (Integer) obj2;
            if (num.intValue() == -1) {
                return num2.intValue() == -1 ? 0 : -1;
            }
            if (num2.intValue() == -1) {
                return 1;
            }
            return num.intValue() - num2.intValue();
        }
    });

    @Nullable
    public final Context zza;
    private final Object zzc;
    private final boolean zzd;

    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private zzxi zze;

    @Nullable
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private zzxm zzf;

    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private zzh zzg;
    private final zzwo zzh;

    public zzxt(Context context) {
        zzwo zzwoVar = new zzwo();
        zzxi zzxiVarZzd = zzxi.zzd(context);
        this.zzc = new Object();
        this.zza = context != null ? context.getApplicationContext() : null;
        this.zzh = zzwoVar;
        this.zze = zzxiVarZzd;
        this.zzg = zzh.zza;
        boolean z10 = false;
        if (context != null && zzet.zzN(context)) {
            z10 = true;
        }
        this.zzd = z10;
        if (!z10 && context != null && zzet.zza >= 32) {
            this.zzf = zzxm.zza(context);
        }
        if (this.zze.zzM && context == null) {
            zzea.zzf("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    static /* bridge */ /* synthetic */ int zzb(int i10, int i11) {
        if (i10 == 0 || i10 != i11) {
            return Integer.bitCount(i10 & i11);
        }
        return Integer.MAX_VALUE;
    }

    protected static int zzc(zzaf zzafVar, @Nullable String str, boolean z10) {
        if (!TextUtils.isEmpty(str) && str.equals(zzafVar.zzd)) {
            return 4;
        }
        String strZzh = zzh(str);
        String strZzh2 = zzh(zzafVar.zzd);
        if (strZzh2 == null || strZzh == null) {
            return (z10 && strZzh2 == null) ? 1 : 0;
        }
        if (strZzh2.startsWith(strZzh) || strZzh.startsWith(strZzh2)) {
            return 3;
        }
        int i10 = zzet.zza;
        return strZzh2.split("-", 2)[0].equals(strZzh.split("-", 2)[0]) ? 2 : 0;
    }

    @Nullable
    protected static String zzh(@Nullable String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, C.LANGUAGE_UNDETERMINED)) {
            return null;
        }
        return str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ boolean zzm(com.google.android.gms.internal.ads.zzxt r8, com.google.android.gms.internal.ads.zzaf r9) {
        /*
            java.lang.Object r0 = r8.zzc
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzxi r1 = r8.zze     // Catch: java.lang.Throwable -> L8f
            boolean r1 = r1.zzM     // Catch: java.lang.Throwable -> L8f
            r2 = 1
            if (r1 == 0) goto L8d
            boolean r1 = r8.zzd     // Catch: java.lang.Throwable -> L8f
            if (r1 != 0) goto L8d
            int r1 = r9.zzz     // Catch: java.lang.Throwable -> L8f
            r3 = 2
            if (r1 <= r3) goto L8d
            java.lang.String r1 = r9.zzm     // Catch: java.lang.Throwable -> L8f
            r4 = 32
            r5 = 0
            if (r1 != 0) goto L1b
            goto L65
        L1b:
            int r6 = r1.hashCode()     // Catch: java.lang.Throwable -> L8f
            r7 = 3
            switch(r6) {
                case -2123537834: goto L42;
                case 187078296: goto L38;
                case 187078297: goto L2e;
                case 1504578661: goto L24;
                default: goto L23;
            }
        L23:
            goto L4c
        L24:
            java.lang.String r6 = "audio/eac3"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L4c
            r1 = r2
            goto L4d
        L2e:
            java.lang.String r6 = "audio/ac4"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L4c
            r1 = r7
            goto L4d
        L38:
            java.lang.String r6 = "audio/ac3"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L4c
            r1 = r5
            goto L4d
        L42:
            java.lang.String r6 = "audio/eac3-joc"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L4c
            r1 = r3
            goto L4d
        L4c:
            r1 = -1
        L4d:
            if (r1 == 0) goto L56
            if (r1 == r2) goto L56
            if (r1 == r3) goto L56
            if (r1 == r7) goto L56
            goto L65
        L56:
            int r1 = com.google.android.gms.internal.ads.zzet.zza     // Catch: java.lang.Throwable -> L8f
            if (r1 < r4) goto L8d
            com.google.android.gms.internal.ads.zzxm r1 = r8.zzf     // Catch: java.lang.Throwable -> L8f
            if (r1 == 0) goto L8d
            boolean r1 = r1.zzg()     // Catch: java.lang.Throwable -> L8f
            if (r1 != 0) goto L65
            goto L8d
        L65:
            int r1 = com.google.android.gms.internal.ads.zzet.zza     // Catch: java.lang.Throwable -> L8f
            if (r1 < r4) goto L8c
            com.google.android.gms.internal.ads.zzxm r1 = r8.zzf     // Catch: java.lang.Throwable -> L8f
            if (r1 == 0) goto L8c
            boolean r3 = r1.zzg()     // Catch: java.lang.Throwable -> L8f
            if (r3 == 0) goto L8c
            boolean r1 = r1.zze()     // Catch: java.lang.Throwable -> L8f
            if (r1 == 0) goto L8c
            com.google.android.gms.internal.ads.zzxm r1 = r8.zzf     // Catch: java.lang.Throwable -> L8f
            boolean r1 = r1.zzf()     // Catch: java.lang.Throwable -> L8f
            if (r1 == 0) goto L8c
            com.google.android.gms.internal.ads.zzxm r1 = r8.zzf     // Catch: java.lang.Throwable -> L8f
            com.google.android.gms.internal.ads.zzh r8 = r8.zzg     // Catch: java.lang.Throwable -> L8f
            boolean r8 = r1.zzd(r8, r9)     // Catch: java.lang.Throwable -> L8f
            if (r8 == 0) goto L8c
            goto L8d
        L8c:
            r2 = r5
        L8d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8f
            return r2
        L8f:
            r8 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8f
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxt.zzm(com.google.android.gms.internal.ads.zzxt, com.google.android.gms.internal.ads.zzaf):boolean");
    }

    private static void zzt(zzwi zzwiVar, zzci zzciVar, Map map) {
        for (int i10 = 0; i10 < zzwiVar.zzb; i10++) {
            if (((zzce) zzciVar.zzA.get(zzwiVar.zzb(i10))) != null) {
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzu() {
        boolean z10;
        zzxm zzxmVar;
        synchronized (this.zzc) {
            z10 = false;
            if (this.zze.zzM && !this.zzd && zzet.zza >= 32 && (zzxmVar = this.zzf) != null && zzxmVar.zzg()) {
                z10 = true;
            }
        }
        if (z10) {
            zzs();
        }
    }

    @Nullable
    private static final Pair zzv(int i10, zzxx zzxxVar, int[][][] iArr, zzxo zzxoVar, Comparator comparator) {
        RandomAccess randomAccessZzn;
        zzxx zzxxVar2 = zzxxVar;
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (i11 < 2) {
            if (i10 == zzxxVar2.zzc(i11)) {
                zzwi zzwiVarZzd = zzxxVar2.zzd(i11);
                for (int i12 = 0; i12 < zzwiVarZzd.zzb; i12++) {
                    zzcd zzcdVarZzb = zzwiVarZzd.zzb(i12);
                    List listZza = zzxoVar.zza(i11, zzcdVarZzb, iArr[i11][i12]);
                    boolean[] zArr = new boolean[zzcdVarZzb.zza];
                    int i13 = 0;
                    while (i13 < zzcdVarZzb.zza) {
                        int i14 = i13 + 1;
                        zzxp zzxpVar = (zzxp) listZza.get(i13);
                        int iZzb = zzxpVar.zzb();
                        if (!zArr[i13] && iZzb != 0) {
                            if (iZzb == 1) {
                                randomAccessZzn = zzfxr.zzn(zzxpVar);
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(zzxpVar);
                                for (int i15 = i14; i15 < zzcdVarZzb.zza; i15++) {
                                    zzxp zzxpVar2 = (zzxp) listZza.get(i15);
                                    if (zzxpVar2.zzb() == 2 && zzxpVar.zzc(zzxpVar2)) {
                                        arrayList2.add(zzxpVar2);
                                        zArr[i15] = true;
                                    }
                                }
                                randomAccessZzn = arrayList2;
                            }
                            arrayList.add(randomAccessZzn);
                        }
                        i13 = i14;
                    }
                }
            }
            i11++;
            zzxxVar2 = zzxxVar;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i16 = 0; i16 < list.size(); i16++) {
            iArr2[i16] = ((zzxp) list.get(i16)).zzc;
        }
        zzxp zzxpVar3 = (zzxp) list.get(0);
        return Pair.create(new zzxu(zzxpVar3.zzb, iArr2, 0), Integer.valueOf(zzxpVar3.zza));
    }

    @Override // com.google.android.gms.internal.ads.zzlg
    public final void zza(zzle zzleVar) {
        synchronized (this.zzc) {
            boolean z10 = this.zze.zzQ;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzxy
    protected final Pair zzd(zzxx zzxxVar, int[][][] iArr, final int[] iArr2, zzui zzuiVar, zzcc zzccVar) throws zzhw {
        final zzxi zzxiVar;
        int i10;
        final boolean z10;
        final String str;
        int[] iArr3;
        int length;
        zzxm zzxmVar;
        synchronized (this.zzc) {
            zzxiVar = this.zze;
            if (zzxiVar.zzM && zzet.zza >= 32 && (zzxmVar = this.zzf) != null) {
                Looper looperMyLooper = Looper.myLooper();
                zzdi.zzb(looperMyLooper);
                zzxmVar.zzb(this, looperMyLooper);
            }
        }
        int i11 = 2;
        zzxu[] zzxuVarArr = new zzxu[2];
        Pair pairZzv = zzv(2, zzxxVar, iArr, new zzxo() { // from class: com.google.android.gms.internal.ads.zzwy
            /* JADX WARN: Removed duplicated region for block: B:22:0x003c  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x0044  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
            @Override // com.google.android.gms.internal.ads.zzxo
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.util.List zza(int r20, com.google.android.gms.internal.ads.zzcd r21, int[] r22) {
                /*
                    r19 = this;
                    r0 = r19
                    r9 = r21
                    com.google.android.gms.internal.ads.zzxi r10 = r1
                    int[] r1 = r2
                    r11 = r1[r20]
                    int r1 = r10.zzi
                    int r2 = r10.zzj
                    boolean r3 = r10.zzk
                    r15 = 2147483647(0x7fffffff, float:NaN)
                    if (r1 == r15) goto L82
                    if (r2 != r15) goto L19
                    goto L85
                L19:
                    r5 = r15
                    r4 = 0
                L1b:
                    int r6 = r9.zza
                    if (r4 >= r6) goto L80
                    com.google.android.gms.internal.ads.zzaf r6 = r9.zzb(r4)
                    int r7 = r6.zzr
                    if (r7 <= 0) goto L7a
                    int r8 = r6.zzs
                    if (r8 <= 0) goto L7a
                    if (r3 == 0) goto L3c
                    if (r7 > r8) goto L31
                    r13 = 0
                    goto L32
                L31:
                    r13 = 1
                L32:
                    if (r1 > r2) goto L36
                    r14 = 0
                    goto L37
                L36:
                    r14 = 1
                L37:
                    if (r13 == r14) goto L3c
                    r13 = r1
                    r14 = r2
                    goto L3e
                L3c:
                    r14 = r1
                    r13 = r2
                L3e:
                    int r15 = r7 * r13
                    int r12 = r8 * r14
                    if (r15 < r12) goto L52
                    android.graphics.Point r8 = new android.graphics.Point
                    int r13 = com.google.android.gms.internal.ads.zzet.zza
                    int r12 = r12 + r7
                    r17 = -1
                    int r12 = r12 + (-1)
                    int r12 = r12 / r7
                    r8.<init>(r14, r12)
                    goto L60
                L52:
                    r17 = -1
                    android.graphics.Point r7 = new android.graphics.Point
                    int r12 = com.google.android.gms.internal.ads.zzet.zza
                    int r15 = r15 + r8
                    int r15 = r15 + (-1)
                    int r15 = r15 / r8
                    r7.<init>(r15, r13)
                    r8 = r7
                L60:
                    int r7 = r6.zzr
                    int r6 = r6.zzs
                    int r12 = r7 * r6
                    int r13 = r8.x
                    float r13 = (float) r13
                    r14 = 1065017672(0x3f7ae148, float:0.98)
                    float r13 = r13 * r14
                    int r13 = (int) r13
                    if (r7 < r13) goto L7a
                    int r7 = r8.y
                    float r7 = (float) r7
                    float r7 = r7 * r14
                    int r7 = (int) r7
                    if (r6 < r7) goto L7a
                    if (r12 >= r5) goto L7a
                    r5 = r12
                L7a:
                    int r4 = r4 + 1
                    r15 = 2147483647(0x7fffffff, float:NaN)
                    goto L1b
                L80:
                    r15 = r5
                    goto L85
                L82:
                    r15 = 2147483647(0x7fffffff, float:NaN)
                L85:
                    com.google.android.gms.internal.ads.zzfxo r12 = new com.google.android.gms.internal.ads.zzfxo
                    r12.<init>()
                    r13 = 0
                L8b:
                    int r1 = r9.zza
                    if (r13 >= r1) goto Lc2
                    com.google.android.gms.internal.ads.zzaf r1 = r9.zzb(r13)
                    int r1 = r1.zza()
                    r14 = 2147483647(0x7fffffff, float:NaN)
                    if (r15 == r14) goto La5
                    r8 = -1
                    if (r1 == r8) goto La2
                    if (r1 > r15) goto La2
                    goto La6
                La2:
                    r16 = 0
                    goto La8
                La5:
                    r8 = -1
                La6:
                    r16 = 1
                La8:
                    com.google.android.gms.internal.ads.zzxs r7 = new com.google.android.gms.internal.ads.zzxs
                    r6 = r22[r13]
                    r1 = r7
                    r2 = r20
                    r3 = r21
                    r4 = r13
                    r5 = r10
                    r14 = r7
                    r7 = r11
                    r18 = r8
                    r8 = r16
                    r1.<init>(r2, r3, r4, r5, r6, r7, r8)
                    r12.zzf(r14)
                    int r13 = r13 + 1
                    goto L8b
                Lc2:
                    com.google.android.gms.internal.ads.zzfxr r1 = r12.zzi()
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwy.zza(int, com.google.android.gms.internal.ads.zzcd, int[]):java.util.List");
            }
        }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzwz
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                List list = (List) obj;
                List list2 = (List) obj2;
                return zzfxg.zzj().zzc((zzxs) Collections.max(list, new Comparator() { // from class: com.google.android.gms.internal.ads.zzxq
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzxs.zzd((zzxs) obj3, (zzxs) obj4);
                    }
                }), (zzxs) Collections.max(list2, new Comparator() { // from class: com.google.android.gms.internal.ads.zzxq
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzxs.zzd((zzxs) obj3, (zzxs) obj4);
                    }
                }), new Comparator() { // from class: com.google.android.gms.internal.ads.zzxq
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzxs.zzd((zzxs) obj3, (zzxs) obj4);
                    }
                }).zzb(list.size(), list2.size()).zzc((zzxs) Collections.max(list, new Comparator() { // from class: com.google.android.gms.internal.ads.zzxr
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzxs.zza((zzxs) obj3, (zzxs) obj4);
                    }
                }), (zzxs) Collections.max(list2, new Comparator() { // from class: com.google.android.gms.internal.ads.zzxr
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzxs.zza((zzxs) obj3, (zzxs) obj4);
                    }
                }), new Comparator() { // from class: com.google.android.gms.internal.ads.zzxr
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzxs.zza((zzxs) obj3, (zzxs) obj4);
                    }
                }).zza();
            }
        });
        int i12 = 4;
        Pair pairZzv2 = pairZzv == null ? zzv(4, zzxxVar, iArr, new zzxo() { // from class: com.google.android.gms.internal.ads.zzwu
            @Override // com.google.android.gms.internal.ads.zzxo
            public final List zza(int i13, zzcd zzcdVar, int[] iArr4) {
                zzfxo zzfxoVar = new zzfxo();
                for (int i14 = 0; i14 < zzcdVar.zza; i14++) {
                    zzfxoVar.zzf(new zzxd(i13, zzcdVar, i14, zzxiVar, iArr4[i14]));
                }
                return zzfxoVar.zzi();
            }
        }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzwv
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((zzxd) ((List) obj).get(0)).compareTo((zzxd) ((List) obj2).get(0));
            }
        }) : null;
        int i13 = 0;
        if (pairZzv2 != null) {
            zzxuVarArr[((Integer) pairZzv2.second).intValue()] = (zzxu) pairZzv2.first;
        } else if (pairZzv != null) {
            zzxuVarArr[((Integer) pairZzv.second).intValue()] = (zzxu) pairZzv.first;
        }
        int i14 = 0;
        while (true) {
            i10 = 1;
            if (i14 >= 2) {
                z10 = false;
                break;
            }
            if (zzxxVar.zzc(i14) == 2 && zzxxVar.zzd(i14).zzb > 0) {
                z10 = true;
                break;
            }
            i14++;
        }
        Pair pairZzv3 = zzv(1, zzxxVar, iArr, new zzxo() { // from class: com.google.android.gms.internal.ads.zzww
            @Override // com.google.android.gms.internal.ads.zzxo
            public final List zza(int i15, zzcd zzcdVar, int[] iArr4) {
                final zzxt zzxtVar = this.zza;
                zzfuv zzfuvVar = new zzfuv() { // from class: com.google.android.gms.internal.ads.zzwt
                    @Override // com.google.android.gms.internal.ads.zzfuv
                    public final boolean zza(Object obj) {
                        return zzxt.zzm(zzxtVar, (zzaf) obj);
                    }
                };
                int i16 = iArr2[i15];
                zzfxo zzfxoVar = new zzfxo();
                for (int i17 = 0; i17 < zzcdVar.zza; i17++) {
                    zzfxoVar.zzf(new zzxc(i15, zzcdVar, i17, zzxiVar, iArr4[i17], z10, zzfuvVar, i16));
                }
                return zzfxoVar.zzi();
            }
        }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzwx
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((zzxc) Collections.max((List) obj)).zza((zzxc) Collections.max((List) obj2));
            }
        });
        if (pairZzv3 != null) {
            zzxuVarArr[((Integer) pairZzv3.second).intValue()] = (zzxu) pairZzv3.first;
        }
        if (pairZzv3 == null) {
            str = null;
        } else {
            Object obj = pairZzv3.first;
            str = ((zzxu) obj).zza.zzb(((zzxu) obj).zzb[0]).zzd;
        }
        int i15 = 3;
        Pair pairZzv4 = zzv(3, zzxxVar, iArr, new zzxo() { // from class: com.google.android.gms.internal.ads.zzxa
            @Override // com.google.android.gms.internal.ads.zzxo
            public final List zza(int i16, zzcd zzcdVar, int[] iArr4) {
                zzfxo zzfxoVar = new zzfxo();
                for (int i17 = 0; i17 < zzcdVar.zza; i17++) {
                    int i18 = i17;
                    zzfxoVar.zzf(new zzxn(i16, zzcdVar, i18, zzxiVar, iArr4[i17], str));
                }
                return zzfxoVar.zzi();
            }
        }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzxb
            @Override // java.util.Comparator
            public final int compare(Object obj2, Object obj3) {
                return ((zzxn) ((List) obj2).get(0)).zza((zzxn) ((List) obj3).get(0));
            }
        });
        if (pairZzv4 != null) {
            zzxuVarArr[((Integer) pairZzv4.second).intValue()] = (zzxu) pairZzv4.first;
        }
        int i16 = 0;
        while (i16 < i11) {
            int iZzc = zzxxVar.zzc(i16);
            if (iZzc != i11 && iZzc != i10 && iZzc != i15 && iZzc != i12) {
                zzwi zzwiVarZzd = zzxxVar.zzd(i16);
                int[][] iArr4 = iArr[i16];
                int i17 = i13;
                int i18 = i17;
                zzcd zzcdVar = null;
                zzxe zzxeVar = null;
                while (i17 < zzwiVarZzd.zzb) {
                    zzcd zzcdVarZzb = zzwiVarZzd.zzb(i17);
                    int[] iArr5 = iArr4[i17];
                    zzxe zzxeVar2 = zzxeVar;
                    for (int i19 = i13; i19 < zzcdVarZzb.zza; i19++) {
                        if (zzlf.zza(iArr5[i19], zzxiVar.zzN)) {
                            zzxe zzxeVar3 = new zzxe(zzcdVarZzb.zzb(i19), iArr5[i19]);
                            if (zzxeVar2 == null || zzxeVar3.compareTo(zzxeVar2) > 0) {
                                zzcdVar = zzcdVarZzb;
                                i18 = i19;
                                zzxeVar2 = zzxeVar3;
                            }
                        }
                    }
                    i17++;
                    zzxeVar = zzxeVar2;
                    i13 = 0;
                }
                zzxuVarArr[i16] = zzcdVar == null ? null : new zzxu(zzcdVar, new int[]{i18}, 0);
            }
            i16++;
            i11 = 2;
            i12 = 4;
            i10 = 1;
            i13 = 0;
            i15 = 3;
        }
        HashMap map = new HashMap();
        int i20 = 2;
        for (int i21 = 0; i21 < 2; i21++) {
            zzt(zzxxVar.zzd(i21), zzxiVar, map);
        }
        zzt(zzxxVar.zze(), zzxiVar, map);
        for (int i22 = 0; i22 < 2; i22++) {
            if (((zzce) map.get(Integer.valueOf(zzxxVar.zzc(i22)))) != null) {
                throw null;
            }
        }
        int i23 = 0;
        while (i23 < i20) {
            zzwi zzwiVarZzd2 = zzxxVar.zzd(i23);
            if (zzxiVar.zzg(i23, zzwiVarZzd2)) {
                if (zzxiVar.zze(i23, zzwiVarZzd2) != null) {
                    throw null;
                }
                zzxuVarArr[i23] = null;
            }
            i23++;
            i20 = 2;
        }
        int i24 = 0;
        for (int i25 = i20; i24 < i25; i25 = 2) {
            int iZzc2 = zzxxVar.zzc(i24);
            if (zzxiVar.zzf(i24) || zzxiVar.zzB.contains(Integer.valueOf(iZzc2))) {
                zzxuVarArr[i24] = null;
            }
            i24++;
        }
        zzwo zzwoVar = this.zzh;
        zzyj zzyjVarZzq = zzq();
        zzfxr zzfxrVarZzf = zzwp.zzf(zzxuVarArr);
        int i26 = 2;
        zzxv[] zzxvVarArr = new zzxv[2];
        int i27 = 0;
        while (i27 < i26) {
            zzxu zzxuVar = zzxuVarArr[i27];
            if (zzxuVar != null && (length = (iArr3 = zzxuVar.zzb).length) != 0) {
                zzxvVarArr[i27] = length == 1 ? new zzxw(zzxuVar.zza, iArr3[0], 0, 0, null) : zzwoVar.zza(zzxuVar.zza, iArr3, 0, zzyjVarZzq, (zzfxr) zzfxrVarZzf.get(i27));
            }
            i27++;
            i26 = 2;
        }
        zzli[] zzliVarArr = new zzli[i26];
        for (int i28 = 0; i28 < i26; i28++) {
            zzliVarArr[i28] = (zzxiVar.zzf(i28) || zzxiVar.zzB.contains(Integer.valueOf(zzxxVar.zzc(i28))) || (zzxxVar.zzc(i28) != -2 && zzxvVarArr[i28] == null)) ? null : zzli.zza;
        }
        return Pair.create(zzliVarArr, zzxvVarArr);
    }

    public final zzxi zzf() {
        zzxi zzxiVar;
        synchronized (this.zzc) {
            zzxiVar = this.zze;
        }
        return zzxiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzyb
    public final void zzj() {
        zzxm zzxmVar;
        synchronized (this.zzc) {
            if (zzet.zza >= 32 && (zzxmVar = this.zzf) != null) {
                zzxmVar.zzc();
            }
        }
        super.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzyb
    public final void zzk(zzh zzhVar) {
        boolean z10;
        synchronized (this.zzc) {
            z10 = !this.zzg.equals(zzhVar);
            this.zzg = zzhVar;
        }
        if (z10) {
            zzu();
        }
    }

    public final void zzl(zzxg zzxgVar) {
        boolean z10;
        zzxi zzxiVar = new zzxi(zzxgVar);
        synchronized (this.zzc) {
            z10 = !this.zze.equals(zzxiVar);
            this.zze = zzxiVar;
        }
        if (z10) {
            if (zzxiVar.zzM && this.zza == null) {
                zzea.zzf("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
            }
            zzs();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyb
    public final boolean zzn() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzyb
    @Nullable
    public final zzlg zze() {
        return this;
    }
}
