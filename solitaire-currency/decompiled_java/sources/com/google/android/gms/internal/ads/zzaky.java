package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaky {

    @Nullable
    public final String zza;

    @Nullable
    public final String zzb;
    public final boolean zzc;
    public final long zzd;
    public final long zze;

    @Nullable
    public final zzale zzf;
    public final String zzg;

    @Nullable
    public final String zzh;

    @Nullable
    public final zzaky zzi;

    @Nullable
    private final String[] zzj;
    private final HashMap zzk;
    private final HashMap zzl;
    private List zzm;

    private zzaky(@Nullable String str, @Nullable String str2, long j10, long j11, @Nullable zzale zzaleVar, @Nullable String[] strArr, String str3, @Nullable String str4, @Nullable zzaky zzakyVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzh = str4;
        this.zzf = zzaleVar;
        this.zzj = strArr;
        this.zzc = str2 != null;
        this.zzd = j10;
        this.zze = j11;
        str3.getClass();
        this.zzg = str3;
        this.zzi = zzakyVar;
        this.zzk = new HashMap();
        this.zzl = new HashMap();
    }

    public static zzaky zzb(@Nullable String str, long j10, long j11, @Nullable zzale zzaleVar, @Nullable String[] strArr, String str2, @Nullable String str3, @Nullable zzaky zzakyVar) {
        return new zzaky(str, null, j10, j11, zzaleVar, strArr, str2, str3, zzakyVar);
    }

    public static zzaky zzc(String str) {
        return new zzaky(null, str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " "), C.TIME_UNSET, C.TIME_UNSET, null, null, "", null, null);
    }

    private static SpannableStringBuilder zzi(String str, Map map) {
        if (!map.containsKey(str)) {
            zzcz zzczVar = new zzcz();
            zzczVar.zzl(new SpannableStringBuilder());
            map.put(str, zzczVar);
        }
        CharSequence charSequenceZzq = ((zzcz) map.get(str)).zzq();
        charSequenceZzq.getClass();
        return (SpannableStringBuilder) charSequenceZzq;
    }

    private final void zzj(TreeSet treeSet, boolean z10) {
        String str = this.zza;
        boolean zEquals = TtmlNode.TAG_P.equals(str);
        boolean zEquals2 = TtmlNode.TAG_DIV.equals(str);
        if (z10 || zEquals || (zEquals2 && this.zzh != null)) {
            long j10 = this.zzd;
            if (j10 != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j10));
            }
            long j11 = this.zze;
            if (j11 != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j11));
            }
        }
        if (this.zzm != null) {
            for (int i10 = 0; i10 < this.zzm.size(); i10++) {
                zzaky zzakyVar = (zzaky) this.zzm.get(i10);
                boolean z11 = true;
                if (!z10 && !zEquals) {
                    z11 = false;
                }
                zzakyVar.zzj(treeSet, z11);
            }
        }
    }

    private final void zzk(long j10, String str, List list) {
        String str2;
        if (!"".equals(this.zzg)) {
            str = this.zzg;
        }
        if (zzg(j10) && TtmlNode.TAG_DIV.equals(this.zza) && (str2 = this.zzh) != null) {
            list.add(new Pair(str, str2));
            return;
        }
        for (int i10 = 0; i10 < zza(); i10++) {
            zzd(i10).zzk(j10, str, list);
        }
    }

    private final void zzl(long j10, Map map, Map map2, String str, Map map3) {
        zzaky zzakyVar;
        int i10;
        int iZzf;
        zzale zzaleVarZza;
        int i11;
        if (zzg(j10)) {
            String str2 = !"".equals(this.zzg) ? this.zzg : str;
            for (Map.Entry entry : this.zzl.entrySet()) {
                String str3 = (String) entry.getKey();
                int iIntValue = this.zzk.containsKey(str3) ? ((Integer) this.zzk.get(str3)).intValue() : 0;
                int iIntValue2 = ((Integer) entry.getValue()).intValue();
                if (iIntValue != iIntValue2) {
                    zzcz zzczVar = (zzcz) map3.get(str3);
                    zzczVar.getClass();
                    zzalc zzalcVar = (zzalc) map2.get(str2);
                    zzalcVar.getClass();
                    zzale zzaleVarZza2 = zzald.zza(this.zzf, this.zzj, map);
                    SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) zzczVar.zzq();
                    if (spannableStringBuilder == null) {
                        spannableStringBuilder = new SpannableStringBuilder();
                        zzczVar.zzl(spannableStringBuilder);
                    }
                    if (zzaleVarZza2 != null) {
                        zzaky zzakyVar2 = this.zzi;
                        if (zzaleVarZza2.zzh() != -1) {
                            spannableStringBuilder.setSpan(new StyleSpan(zzaleVarZza2.zzh()), iIntValue, iIntValue2, 33);
                        }
                        if (zzaleVarZza2.zzI()) {
                            spannableStringBuilder.setSpan(new StrikethroughSpan(), iIntValue, iIntValue2, 33);
                        }
                        if (zzaleVarZza2.zzJ()) {
                            spannableStringBuilder.setSpan(new UnderlineSpan(), iIntValue, iIntValue2, 33);
                        }
                        if (zzaleVarZza2.zzH()) {
                            zzdg.zza(spannableStringBuilder, new ForegroundColorSpan(zzaleVarZza2.zzd()), iIntValue, iIntValue2, 33);
                        }
                        if (zzaleVarZza2.zzG()) {
                            zzdg.zza(spannableStringBuilder, new BackgroundColorSpan(zzaleVarZza2.zzc()), iIntValue, iIntValue2, 33);
                        }
                        if (zzaleVarZza2.zzD() != null) {
                            zzdg.zza(spannableStringBuilder, new TypefaceSpan(zzaleVarZza2.zzD()), iIntValue, iIntValue2, 33);
                        }
                        if (zzaleVarZza2.zzk() != null) {
                            zzakx zzakxVarZzk = zzaleVarZza2.zzk();
                            zzakxVarZzk.getClass();
                            int i12 = zzakxVarZzk.zza;
                            if (i12 == -1) {
                                int i13 = zzalcVar.zzj;
                                i12 = (i13 == 2 || i13 == 1) ? 3 : 1;
                                i11 = 1;
                            } else {
                                i11 = zzakxVarZzk.zzb;
                            }
                            int i14 = zzakxVarZzk.zzc;
                            if (i14 == -2) {
                                i14 = 1;
                            }
                            zzdg.zza(spannableStringBuilder, new zzdh(i12, i11, i14), iIntValue, iIntValue2, 33);
                        }
                        int iZzg = zzaleVarZza2.zzg();
                        if (iZzg == 2) {
                            while (true) {
                                if (zzakyVar2 == null) {
                                    zzakyVar2 = null;
                                    break;
                                }
                                zzale zzaleVarZza3 = zzald.zza(zzakyVar2.zzf, zzakyVar2.zzj, map);
                                if (zzaleVarZza3 != null && zzaleVarZza3.zzg() == 1) {
                                    break;
                                } else {
                                    zzakyVar2 = zzakyVar2.zzi;
                                }
                            }
                            if (zzakyVar2 != null) {
                                ArrayDeque arrayDeque = new ArrayDeque();
                                arrayDeque.push(zzakyVar2);
                                while (true) {
                                    if (arrayDeque.isEmpty()) {
                                        zzakyVar = null;
                                        break;
                                    }
                                    zzaky zzakyVar3 = (zzaky) arrayDeque.pop();
                                    zzale zzaleVarZza4 = zzald.zza(zzakyVar3.zzf, zzakyVar3.zzj, map);
                                    if (zzaleVarZza4 != null && zzaleVarZza4.zzg() == 3) {
                                        zzakyVar = zzakyVar3;
                                        break;
                                    }
                                    for (int iZza = zzakyVar3.zza() - 1; iZza >= 0; iZza--) {
                                        arrayDeque.push(zzakyVar3.zzd(iZza));
                                    }
                                }
                                if (zzakyVar != null) {
                                    if (zzakyVar.zza() != 1 || zzakyVar.zzd(0).zzb == null) {
                                        zzea.zze("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                                    } else {
                                        String str4 = zzakyVar.zzd(0).zzb;
                                        int i15 = zzet.zza;
                                        zzale zzaleVarZza5 = zzald.zza(zzakyVar.zzf, zzakyVar.zzj, map);
                                        if (zzaleVarZza5 != null) {
                                            iZzf = zzaleVarZza5.zzf();
                                            i10 = -1;
                                        } else {
                                            i10 = -1;
                                            iZzf = -1;
                                        }
                                        if (iZzf == i10 && (zzaleVarZza = zzald.zza(zzakyVar2.zzf, zzakyVar2.zzj, map)) != null) {
                                            iZzf = zzaleVarZza.zzf();
                                        }
                                        spannableStringBuilder.setSpan(new zzdf(str4, iZzf), iIntValue, iIntValue2, 33);
                                    }
                                }
                            }
                        } else if (iZzg == 3 || iZzg == 4) {
                            spannableStringBuilder.setSpan(new zzakw(), iIntValue, iIntValue2, 33);
                        }
                        if (zzaleVarZza2.zzF()) {
                            zzdg.zza(spannableStringBuilder, new zzde(), iIntValue, iIntValue2, 33);
                        }
                        int iZze = zzaleVarZza2.zze();
                        if (iZze == 1) {
                            zzdg.zza(spannableStringBuilder, new AbsoluteSizeSpan((int) zzaleVarZza2.zza(), true), iIntValue, iIntValue2, 33);
                        } else if (iZze == 2) {
                            zzdg.zza(spannableStringBuilder, new RelativeSizeSpan(zzaleVarZza2.zza()), iIntValue, iIntValue2, 33);
                        } else if (iZze == 3) {
                            zzdg.zza(spannableStringBuilder, new RelativeSizeSpan(zzaleVarZza2.zza() / 100.0f), iIntValue, iIntValue2, 33);
                        }
                        if (TtmlNode.TAG_P.equals(this.zza)) {
                            if (zzaleVarZza2.zzb() != Float.MAX_VALUE) {
                                zzczVar.zzj((zzaleVarZza2.zzb() * (-90.0f)) / 100.0f);
                            }
                            if (zzaleVarZza2.zzj() != null) {
                                zzczVar.zzm(zzaleVarZza2.zzj());
                            }
                            if (zzaleVarZza2.zzi() != null) {
                                zzczVar.zzg(zzaleVarZza2.zzi());
                            }
                        }
                    }
                }
            }
            for (int i16 = 0; i16 < zza(); i16++) {
                zzd(i16).zzl(j10, map, map2, str2, map3);
            }
        }
    }

    private final void zzm(long j10, boolean z10, String str, Map map) {
        this.zzk.clear();
        this.zzl.clear();
        if (TtmlNode.TAG_METADATA.equals(this.zza)) {
            return;
        }
        if (!"".equals(this.zzg)) {
            str = this.zzg;
        }
        if (this.zzc && z10) {
            SpannableStringBuilder spannableStringBuilderZzi = zzi(str, map);
            String str2 = this.zzb;
            str2.getClass();
            spannableStringBuilderZzi.append((CharSequence) str2);
            return;
        }
        if ("br".equals(this.zza) && z10) {
            zzi(str, map).append('\n');
            return;
        }
        if (zzg(j10)) {
            for (Map.Entry entry : map.entrySet()) {
                HashMap map2 = this.zzk;
                String str3 = (String) entry.getKey();
                CharSequence charSequenceZzq = ((zzcz) entry.getValue()).zzq();
                charSequenceZzq.getClass();
                map2.put(str3, Integer.valueOf(charSequenceZzq.length()));
            }
            boolean zEquals = TtmlNode.TAG_P.equals(this.zza);
            for (int i10 = 0; i10 < zza(); i10++) {
                zzd(i10).zzm(j10, z10 || zEquals, str, map);
            }
            if (zEquals) {
                SpannableStringBuilder spannableStringBuilderZzi2 = zzi(str, map);
                int length = spannableStringBuilderZzi2.length();
                do {
                    length--;
                    if (length < 0) {
                        break;
                    }
                } while (spannableStringBuilderZzi2.charAt(length) == ' ');
                if (length >= 0 && spannableStringBuilderZzi2.charAt(length) != '\n') {
                    spannableStringBuilderZzi2.append('\n');
                }
            }
            for (Map.Entry entry2 : map.entrySet()) {
                HashMap map3 = this.zzl;
                String str4 = (String) entry2.getKey();
                CharSequence charSequenceZzq2 = ((zzcz) entry2.getValue()).zzq();
                charSequenceZzq2.getClass();
                map3.put(str4, Integer.valueOf(charSequenceZzq2.length()));
            }
        }
    }

    public final int zza() {
        List list = this.zzm;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final zzaky zzd(int i10) {
        List list = this.zzm;
        if (list != null) {
            return (zzaky) list.get(i10);
        }
        throw new IndexOutOfBoundsException();
    }

    public final List zze(long j10, Map map, Map map2, Map map3) {
        List arrayList = new ArrayList();
        zzk(j10, this.zzg, arrayList);
        TreeMap treeMap = new TreeMap();
        zzm(j10, false, this.zzg, treeMap);
        zzl(j10, map, map2, this.zzg, treeMap);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            Pair pair = (Pair) arrayList.get(i10);
            String str = (String) map3.get(pair.second);
            if (str != null) {
                byte[] bArrDecode = Base64.decode(str, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                zzalc zzalcVar = (zzalc) map2.get(pair.first);
                zzalcVar.getClass();
                zzcz zzczVar = new zzcz();
                zzczVar.zzc(bitmapDecodeByteArray);
                zzczVar.zzh(zzalcVar.zzb);
                zzczVar.zzi(0);
                zzczVar.zze(zzalcVar.zzc, 0);
                zzczVar.zzf(zzalcVar.zze);
                zzczVar.zzk(zzalcVar.zzf);
                zzczVar.zzd(zzalcVar.zzg);
                zzczVar.zzo(zzalcVar.zzj);
                arrayList2.add(zzczVar.zzp());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            zzalc zzalcVar2 = (zzalc) map2.get(entry.getKey());
            zzalcVar2.getClass();
            zzcz zzczVar2 = (zzcz) entry.getValue();
            CharSequence charSequenceZzq = zzczVar2.zzq();
            charSequenceZzq.getClass();
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) charSequenceZzq;
            for (zzakw zzakwVar : (zzakw[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), zzakw.class)) {
                spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(zzakwVar), spannableStringBuilder.getSpanEnd(zzakwVar), (CharSequence) "");
            }
            int i11 = 0;
            while (i11 < spannableStringBuilder.length()) {
                int i12 = i11 + 1;
                if (spannableStringBuilder.charAt(i11) == ' ') {
                    int i13 = i12;
                    while (i13 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i13) == ' ') {
                        i13++;
                    }
                    int i14 = i13 - i12;
                    if (i14 > 0) {
                        spannableStringBuilder.delete(i11, i14 + i11);
                    }
                }
                i11 = i12;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
                spannableStringBuilder.delete(0, 1);
            }
            int i15 = 0;
            while (i15 < spannableStringBuilder.length() - 1) {
                int i16 = i15 + 1;
                if (spannableStringBuilder.charAt(i15) == '\n' && spannableStringBuilder.charAt(i16) == ' ') {
                    spannableStringBuilder.delete(i16, i15 + 2);
                }
                i15 = i16;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            int i17 = 0;
            while (i17 < spannableStringBuilder.length() - 1) {
                int i18 = i17 + 1;
                if (spannableStringBuilder.charAt(i17) == ' ' && spannableStringBuilder.charAt(i18) == '\n') {
                    spannableStringBuilder.delete(i17, i18);
                }
                i17 = i18;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == '\n') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            zzczVar2.zze(zzalcVar2.zzc, zzalcVar2.zzd);
            zzczVar2.zzf(zzalcVar2.zze);
            zzczVar2.zzh(zzalcVar2.zzb);
            zzczVar2.zzk(zzalcVar2.zzf);
            zzczVar2.zzn(zzalcVar2.zzi, zzalcVar2.zzh);
            zzczVar2.zzo(zzalcVar2.zzj);
            arrayList2.add(zzczVar2.zzp());
        }
        return arrayList2;
    }

    public final void zzf(zzaky zzakyVar) {
        if (this.zzm == null) {
            this.zzm = new ArrayList();
        }
        this.zzm.add(zzakyVar);
    }

    public final boolean zzg(long j10) {
        long j11 = this.zzd;
        if (j11 == C.TIME_UNSET) {
            if (this.zze == C.TIME_UNSET) {
                return true;
            }
            j11 = -9223372036854775807L;
        }
        if (j11 <= j10 && this.zze == C.TIME_UNSET) {
            return true;
        }
        if (j11 != C.TIME_UNSET || j10 >= this.zze) {
            return j11 <= j10 && j10 < this.zze;
        }
        return true;
    }

    public final long[] zzh() {
        TreeSet treeSet = new TreeSet();
        int i10 = 0;
        zzj(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i10] = ((Long) it.next()).longValue();
            i10++;
        }
        return jArr;
    }
}
