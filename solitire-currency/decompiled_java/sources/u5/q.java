package u5;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: HeartBeatInfoStorage.java */
/* JADX INFO: loaded from: classes3.dex */
class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f34636a;

    public q(Context context, String str) {
        this.f34636a = context.getSharedPreferences("FirebaseHeartBeat" + str, 0);
    }

    private synchronized void a() {
        long j10 = this.f34636a.getLong("fire-count", 0L);
        String key = "";
        String str = null;
        for (Map.Entry<String, ?> entry : this.f34636a.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                for (String str2 : (Set) entry.getValue()) {
                    if (str == null || str.compareTo(str2) > 0) {
                        key = entry.getKey();
                        str = str2;
                    }
                }
            }
        }
        HashSet hashSet = new HashSet(this.f34636a.getStringSet(key, new HashSet()));
        hashSet.remove(str);
        this.f34636a.edit().putStringSet(key, hashSet).putLong("fire-count", j10 - 1).commit();
    }

    private synchronized String d(long j10) {
        if (Build.VERSION.SDK_INT >= 26) {
            return new Date(j10).toInstant().atOffset(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return new SimpleDateFormat("yyyy-MM-dd", Locale.UK).format(new Date(j10));
    }

    private synchronized String e(String str) {
        for (Map.Entry<String, ?> entry : this.f34636a.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (str.equals((String) it.next())) {
                        return entry.getKey();
                    }
                }
            }
        }
        return null;
    }

    private synchronized void h(String str) {
        String strE = e(str);
        if (strE == null) {
            return;
        }
        HashSet hashSet = new HashSet(this.f34636a.getStringSet(strE, new HashSet()));
        hashSet.remove(str);
        if (hashSet.isEmpty()) {
            this.f34636a.edit().remove(strE).commit();
        } else {
            this.f34636a.edit().putStringSet(strE, hashSet).commit();
        }
    }

    private synchronized void m(String str, String str2) {
        h(str2);
        HashSet hashSet = new HashSet(this.f34636a.getStringSet(str, new HashSet()));
        hashSet.add(str2);
        this.f34636a.edit().putStringSet(str, hashSet).commit();
    }

    synchronized void b() {
        SharedPreferences.Editor editorEdit = this.f34636a.edit();
        int i10 = 0;
        for (Map.Entry<String, ?> entry : this.f34636a.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                Set set = (Set) entry.getValue();
                String strD = d(System.currentTimeMillis());
                String key = entry.getKey();
                if (set.contains(strD)) {
                    HashSet hashSet = new HashSet();
                    hashSet.add(strD);
                    i10++;
                    editorEdit.putStringSet(key, hashSet);
                } else {
                    editorEdit.remove(key);
                }
            }
        }
        if (i10 == 0) {
            editorEdit.remove("fire-count");
        } else {
            editorEdit.putLong("fire-count", i10);
        }
        editorEdit.commit();
    }

    synchronized List<r> c() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Map.Entry<String, ?> entry : this.f34636a.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                HashSet hashSet = new HashSet((Set) entry.getValue());
                hashSet.remove(d(System.currentTimeMillis()));
                if (!hashSet.isEmpty()) {
                    arrayList.add(r.a(entry.getKey(), new ArrayList(hashSet)));
                }
            }
        }
        l(System.currentTimeMillis());
        return arrayList;
    }

    synchronized boolean f(long j10, long j11) {
        return d(j10).equals(d(j11));
    }

    synchronized void g() {
        String strD = d(System.currentTimeMillis());
        this.f34636a.edit().putString("last-used-date", strD).commit();
        h(strD);
    }

    synchronized boolean i(long j10) {
        return j("fire-global", j10);
    }

    synchronized boolean j(String str, long j10) {
        if (!this.f34636a.contains(str)) {
            this.f34636a.edit().putLong(str, j10).commit();
            return true;
        }
        if (f(this.f34636a.getLong(str, -1L), j10)) {
            return false;
        }
        this.f34636a.edit().putLong(str, j10).commit();
        return true;
    }

    synchronized void k(long j10, String str) {
        String strD = d(j10);
        if (this.f34636a.getString("last-used-date", "").equals(strD)) {
            String strE = e(strD);
            if (strE == null) {
                return;
            }
            if (strE.equals(str)) {
                return;
            }
            m(str, strD);
            return;
        }
        long j11 = this.f34636a.getLong("fire-count", 0L);
        if (j11 + 1 == 30) {
            a();
            j11 = this.f34636a.getLong("fire-count", 0L);
        }
        HashSet hashSet = new HashSet(this.f34636a.getStringSet(str, new HashSet()));
        hashSet.add(strD);
        this.f34636a.edit().putStringSet(str, hashSet).putLong("fire-count", j11 + 1).putString("last-used-date", strD).commit();
    }

    synchronized void l(long j10) {
        this.f34636a.edit().putLong("fire-global", j10).commit();
    }
}
