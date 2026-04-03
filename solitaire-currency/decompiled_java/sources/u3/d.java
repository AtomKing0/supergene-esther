package u3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import n3.b;

/* JADX INFO: compiled from: TtmlNode.java */
/* JADX INFO: loaded from: classes2.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f34544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f34545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f34546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f34547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f34548e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final g f34549f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private final String[] f34550g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f34551h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final String f34552i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final d f34553j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final HashMap<String, Integer> f34554k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final HashMap<String, Integer> f34555l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private List<d> f34556m;

    private d(@Nullable String str, @Nullable String str2, long j10, long j11, @Nullable g gVar, @Nullable String[] strArr, String str3, @Nullable String str4, @Nullable d dVar) {
        this.f34544a = str;
        this.f34545b = str2;
        this.f34552i = str4;
        this.f34549f = gVar;
        this.f34550g = strArr;
        this.f34546c = str2 != null;
        this.f34547d = j10;
        this.f34548e = j11;
        this.f34551h = (String) a4.a.e(str3);
        this.f34553j = dVar;
        this.f34554k = new HashMap<>();
        this.f34555l = new HashMap<>();
    }

    private void b(Map<String, g> map, b.C0631b c0631b, int i10, int i11, int i12) {
        g gVarF = f.f(this.f34549f, this.f34550g, map);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) c0631b.e();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            c0631b.o(spannableStringBuilder);
        }
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        if (gVarF != null) {
            f.a(spannableStringBuilder2, i10, i11, gVarF, this.f34553j, map, i12);
            if (TtmlNode.TAG_P.equals(this.f34544a)) {
                if (gVarF.k() != Float.MAX_VALUE) {
                    c0631b.m((gVarF.k() * (-90.0f)) / 100.0f);
                }
                if (gVarF.m() != null) {
                    c0631b.p(gVarF.m());
                }
                if (gVarF.h() != null) {
                    c0631b.j(gVarF.h());
                }
            }
        }
    }

    public static d c(@Nullable String str, long j10, long j11, @Nullable g gVar, @Nullable String[] strArr, String str2, @Nullable String str3, @Nullable d dVar) {
        return new d(str, null, j10, j11, gVar, strArr, str2, str3, dVar);
    }

    public static d d(String str) {
        return new d(null, f.b(str), C.TIME_UNSET, C.TIME_UNSET, null, null, "", null, null);
    }

    private static void e(SpannableStringBuilder spannableStringBuilder) {
        for (a aVar : (a[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), a.class)) {
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(aVar), spannableStringBuilder.getSpanEnd(aVar), "");
        }
        for (int i10 = 0; i10 < spannableStringBuilder.length(); i10++) {
            if (spannableStringBuilder.charAt(i10) == ' ') {
                int i11 = i10 + 1;
                int i12 = i11;
                while (i12 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i12) == ' ') {
                    i12++;
                }
                int i13 = i12 - i11;
                if (i13 > 0) {
                    spannableStringBuilder.delete(i10, i13 + i10);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
        }
        for (int i14 = 0; i14 < spannableStringBuilder.length() - 1; i14++) {
            if (spannableStringBuilder.charAt(i14) == '\n') {
                int i15 = i14 + 1;
                if (spannableStringBuilder.charAt(i15) == ' ') {
                    spannableStringBuilder.delete(i15, i14 + 2);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
        for (int i16 = 0; i16 < spannableStringBuilder.length() - 1; i16++) {
            if (spannableStringBuilder.charAt(i16) == ' ') {
                int i17 = i16 + 1;
                if (spannableStringBuilder.charAt(i17) == '\n') {
                    spannableStringBuilder.delete(i16, i17);
                }
            }
        }
        if (spannableStringBuilder.length() <= 0 || spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) != '\n') {
            return;
        }
        spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
    }

    private void i(TreeSet<Long> treeSet, boolean z10) {
        boolean zEquals = TtmlNode.TAG_P.equals(this.f34544a);
        boolean zEquals2 = TtmlNode.TAG_DIV.equals(this.f34544a);
        if (z10 || zEquals || (zEquals2 && this.f34552i != null)) {
            long j10 = this.f34547d;
            if (j10 != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j10));
            }
            long j11 = this.f34548e;
            if (j11 != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j11));
            }
        }
        if (this.f34556m == null) {
            return;
        }
        for (int i10 = 0; i10 < this.f34556m.size(); i10++) {
            this.f34556m.get(i10).i(treeSet, z10 || zEquals);
        }
    }

    private static SpannableStringBuilder k(String str, Map<String, b.C0631b> map) {
        if (!map.containsKey(str)) {
            b.C0631b c0631b = new b.C0631b();
            c0631b.o(new SpannableStringBuilder());
            map.put(str, c0631b);
        }
        return (SpannableStringBuilder) a4.a.e(map.get(str).e());
    }

    private void n(long j10, String str, List<Pair<String, String>> list) {
        if (!"".equals(this.f34551h)) {
            str = this.f34551h;
        }
        if (m(j10) && TtmlNode.TAG_DIV.equals(this.f34544a) && this.f34552i != null) {
            list.add(new Pair<>(str, this.f34552i));
            return;
        }
        for (int i10 = 0; i10 < g(); i10++) {
            f(i10).n(j10, str, list);
        }
    }

    private void o(long j10, Map<String, g> map, Map<String, e> map2, String str, Map<String, b.C0631b> map3) {
        int i10;
        if (m(j10)) {
            String str2 = "".equals(this.f34551h) ? str : this.f34551h;
            Iterator<Map.Entry<String, Integer>> it = this.f34555l.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, Integer> next = it.next();
                String key = next.getKey();
                int iIntValue = this.f34554k.containsKey(key) ? this.f34554k.get(key).intValue() : 0;
                int iIntValue2 = next.getValue().intValue();
                if (iIntValue != iIntValue2) {
                    b(map, (b.C0631b) a4.a.e(map3.get(key)), iIntValue, iIntValue2, ((e) a4.a.e(map2.get(str2))).f34566j);
                }
            }
            while (i10 < g()) {
                f(i10).o(j10, map, map2, str2, map3);
                i10++;
            }
        }
    }

    private void p(long j10, boolean z10, String str, Map<String, b.C0631b> map) {
        this.f34554k.clear();
        this.f34555l.clear();
        if (TtmlNode.TAG_METADATA.equals(this.f34544a)) {
            return;
        }
        if (!"".equals(this.f34551h)) {
            str = this.f34551h;
        }
        if (this.f34546c && z10) {
            k(str, map).append((CharSequence) a4.a.e(this.f34545b));
            return;
        }
        if ("br".equals(this.f34544a) && z10) {
            k(str, map).append('\n');
            return;
        }
        if (m(j10)) {
            for (Map.Entry<String, b.C0631b> entry : map.entrySet()) {
                this.f34554k.put(entry.getKey(), Integer.valueOf(((CharSequence) a4.a.e(entry.getValue().e())).length()));
            }
            boolean zEquals = TtmlNode.TAG_P.equals(this.f34544a);
            for (int i10 = 0; i10 < g(); i10++) {
                f(i10).p(j10, z10 || zEquals, str, map);
            }
            if (zEquals) {
                f.c(k(str, map));
            }
            for (Map.Entry<String, b.C0631b> entry2 : map.entrySet()) {
                this.f34555l.put(entry2.getKey(), Integer.valueOf(((CharSequence) a4.a.e(entry2.getValue().e())).length()));
            }
        }
    }

    public void a(d dVar) {
        if (this.f34556m == null) {
            this.f34556m = new ArrayList();
        }
        this.f34556m.add(dVar);
    }

    public d f(int i10) {
        List<d> list = this.f34556m;
        if (list != null) {
            return list.get(i10);
        }
        throw new IndexOutOfBoundsException();
    }

    public int g() {
        List<d> list = this.f34556m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<n3.b> h(long j10, Map<String, g> map, Map<String, e> map2, Map<String, String> map3) {
        List<Pair<String, String>> arrayList = new ArrayList<>();
        n(j10, this.f34551h, arrayList);
        TreeMap treeMap = new TreeMap();
        p(j10, false, this.f34551h, treeMap);
        o(j10, map, map2, this.f34551h, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair<String, String> pair : arrayList) {
            String str = map3.get(pair.second);
            if (str != null) {
                byte[] bArrDecode = Base64.decode(str, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                e eVar = (e) a4.a.e(map2.get(pair.first));
                arrayList2.add(new b.C0631b().f(bitmapDecodeByteArray).k(eVar.f34558b).l(0).h(eVar.f34559c, 0).i(eVar.f34561e).n(eVar.f34562f).g(eVar.f34563g).r(eVar.f34566j).a());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            e eVar2 = (e) a4.a.e(map2.get(entry.getKey()));
            b.C0631b c0631b = (b.C0631b) entry.getValue();
            e((SpannableStringBuilder) a4.a.e(c0631b.e()));
            c0631b.h(eVar2.f34559c, eVar2.f34560d);
            c0631b.i(eVar2.f34561e);
            c0631b.k(eVar2.f34558b);
            c0631b.n(eVar2.f34562f);
            c0631b.q(eVar2.f34565i, eVar2.f34564h);
            c0631b.r(eVar2.f34566j);
            arrayList2.add(c0631b.a());
        }
        return arrayList2;
    }

    public long[] j() {
        TreeSet<Long> treeSet = new TreeSet<>();
        int i10 = 0;
        i(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator<Long> it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i10] = it.next().longValue();
            i10++;
        }
        return jArr;
    }

    @Nullable
    public String[] l() {
        return this.f34550g;
    }

    public boolean m(long j10) {
        long j11 = this.f34547d;
        return (j11 == C.TIME_UNSET && this.f34548e == C.TIME_UNSET) || (j11 <= j10 && this.f34548e == C.TIME_UNSET) || ((j11 == C.TIME_UNSET && j10 < this.f34548e) || (j11 <= j10 && j10 < this.f34548e));
    }
}
