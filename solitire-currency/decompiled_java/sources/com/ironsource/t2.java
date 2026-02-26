package com.ironsource;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class t2 implements Parcelable {
    public static final Parcelable.Creator<t2> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f15365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f15366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f15367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<String> f15368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayList<String> f15369g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ArrayList<String> f15370h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayList<String> f15371i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f15372j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f15373k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Map<String, String> f15374l;

    class a implements Parcelable.Creator<t2> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public t2 createFromParcel(Parcel parcel) {
            return new t2(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public t2[] newArray(int i10) {
            return new t2[i10];
        }
    }

    public t2() {
        i();
    }

    private Map<String, String> a(String str) {
        IronLog ironLog;
        String string;
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.getString(next));
            }
        } catch (JSONException e10) {
            i9.d().a(e10);
            ironLog = IronLog.INTERNAL;
            string = e10.toString();
            ironLog.error(string);
        } catch (Throwable th) {
            i9.d().a(th);
            ironLog = IronLog.INTERNAL;
            string = th.toString();
            ironLog.error(string);
        }
        return map;
    }

    private void i() {
        this.f15366d = false;
        this.f15367e = -1;
        this.f15368f = new ArrayList<>();
        this.f15369g = new ArrayList<>();
        this.f15370h = new ArrayList<>();
        this.f15371i = new ArrayList<>();
        this.f15373k = "";
        this.f15372j = "";
        this.f15374l = new HashMap();
    }

    public String b() {
        return this.f15365c;
    }

    public int c() {
        return this.f15367e;
    }

    public String d() {
        return this.f15372j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Map<String, String> e() {
        return this.f15374l;
    }

    public String f() {
        return this.f15373k;
    }

    public String g() {
        return this.f15363a;
    }

    public String h() {
        return this.f15364b;
    }

    public void j(String str) {
        this.f15364b = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("shouldRestore:");
            sb.append(this.f15366d);
            sb.append(", ");
            sb.append("displayedProduct:");
            sb.append(this.f15367e);
            sb.append(", ");
            sb.append("ISReportInit:");
            sb.append(this.f15368f);
            sb.append(", ");
            sb.append("ISInitSuccess:");
            sb.append(this.f15369g);
            sb.append(", ");
            sb.append("ISAppKey");
            sb.append(this.f15372j);
            sb.append(", ");
            sb.append("ISUserId");
            sb.append(this.f15373k);
            sb.append(", ");
            sb.append("ISExtraParams");
            sb.append(this.f15374l);
            sb.append(", ");
        } catch (Throwable th) {
            i9.d().a(th);
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        try {
            parcel.writeByte(this.f15366d ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f15367e);
            parcel.writeString(this.f15363a);
            parcel.writeString(this.f15364b);
            parcel.writeString(this.f15365c);
            parcel.writeString(this.f15372j);
            parcel.writeString(this.f15373k);
            parcel.writeString(new JSONObject(this.f15374l).toString());
        } catch (Throwable th) {
            i9.d().a(th);
        }
    }

    private t2(Parcel parcel) {
        i();
        try {
            this.f15366d = parcel.readByte() != 0;
            this.f15367e = parcel.readInt();
            this.f15363a = parcel.readString();
            this.f15364b = parcel.readString();
            this.f15365c = parcel.readString();
            this.f15372j = parcel.readString();
            this.f15373k = parcel.readString();
            this.f15374l = a(parcel.readString());
        } catch (Throwable th) {
            i9.d().a(th);
            i();
        }
    }

    public void a() {
        this.f15367e = -1;
    }

    public void b(String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!z10) {
            this.f15371i.remove(str);
        } else if (this.f15371i.indexOf(str) == -1) {
            this.f15371i.add(str);
        }
    }

    public void c(String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!z10) {
            this.f15368f.remove(str);
        } else if (this.f15368f.indexOf(str) == -1) {
            this.f15368f.add(str);
        }
    }

    public void d(String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!z10) {
            this.f15370h.remove(str);
        } else if (this.f15370h.indexOf(str) == -1) {
            this.f15370h.add(str);
        }
    }

    public boolean e(String str) {
        return !TextUtils.isEmpty(str) && this.f15370h.indexOf(str) > -1;
    }

    public void f(String str) {
        this.f15365c = str;
    }

    public void g(String str) {
        this.f15372j = str;
    }

    public void h(String str) {
        this.f15373k = str;
    }

    public void i(String str) {
        this.f15363a = str;
    }

    public boolean j() {
        return this.f15366d;
    }

    /* synthetic */ t2(Parcel parcel, a aVar) {
        this(parcel);
    }

    public void a(int i10) {
        this.f15367e = i10;
    }

    public boolean b(String str) {
        return !TextUtils.isEmpty(str) && this.f15369g.indexOf(str) > -1;
    }

    public boolean c(String str) {
        return !TextUtils.isEmpty(str) && this.f15371i.indexOf(str) > -1;
    }

    public boolean d(String str) {
        return !TextUtils.isEmpty(str) && this.f15368f.indexOf(str) > -1;
    }

    public void a(String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!z10) {
            this.f15369g.remove(str);
        } else if (this.f15369g.indexOf(str) == -1) {
            this.f15369g.add(str);
        }
    }

    public void a(Map<String, String> map) {
        this.f15374l = map;
    }

    public void a(boolean z10) {
        this.f15366d = z10;
    }
}
