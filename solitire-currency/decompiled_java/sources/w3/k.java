package w3;

import a4.o0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: WebvttSubtitle.java */
/* JADX INFO: loaded from: classes2.dex */
final class k implements n3.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<e> f35420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f35421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long[] f35422c;

    public k(List<e> list) {
        this.f35420a = Collections.unmodifiableList(new ArrayList(list));
        this.f35421b = new long[list.size() * 2];
        for (int i10 = 0; i10 < list.size(); i10++) {
            e eVar = list.get(i10);
            int i11 = i10 * 2;
            long[] jArr = this.f35421b;
            jArr[i11] = eVar.f35391b;
            jArr[i11 + 1] = eVar.f35392c;
        }
        long[] jArr2 = this.f35421b;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f35422c = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int b(e eVar, e eVar2) {
        return Long.compare(eVar.f35391b, eVar2.f35391b);
    }

    @Override // n3.i
    public List<n3.b> getCues(long j10) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i10 = 0; i10 < this.f35420a.size(); i10++) {
            long[] jArr = this.f35421b;
            int i11 = i10 * 2;
            if (jArr[i11] <= j10 && j10 < jArr[i11 + 1]) {
                e eVar = this.f35420a.get(i10);
                n3.b bVar = eVar.f35390a;
                if (bVar.f31627e == -3.4028235E38f) {
                    arrayList2.add(eVar);
                } else {
                    arrayList.add(bVar);
                }
            }
        }
        Collections.sort(arrayList2, new Comparator() { // from class: w3.j
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return k.b((e) obj, (e) obj2);
            }
        });
        for (int i12 = 0; i12 < arrayList2.size(); i12++) {
            arrayList.add(((e) arrayList2.get(i12)).f35390a.b().h((-1) - i12, 1).a());
        }
        return arrayList;
    }

    @Override // n3.i
    public long getEventTime(int i10) {
        a4.a.a(i10 >= 0);
        a4.a.a(i10 < this.f35422c.length);
        return this.f35422c[i10];
    }

    @Override // n3.i
    public int getEventTimeCount() {
        return this.f35422c.length;
    }

    @Override // n3.i
    public int getNextEventTimeIndex(long j10) {
        int iE = o0.e(this.f35422c, j10, false, false);
        if (iE < this.f35422c.length) {
            return iE;
        }
        return -1;
    }
}
