package t;

import a0.j;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.r0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MemoryCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface c {

    /* JADX INFO: compiled from: MemoryCache.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final Context f33983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private double f33984b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f33985c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f33986d = true;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f33987e = true;

        public a(@NotNull Context context) {
            this.f33983a = context;
            this.f33984b = j.e(context);
        }

        @NotNull
        public final c a() {
            h aVar;
            i gVar = this.f33987e ? new g() : new t.b();
            if (this.f33986d) {
                double d10 = this.f33984b;
                int iC = d10 > 0.0d ? j.c(this.f33983a, d10) : this.f33985c;
                aVar = iC > 0 ? new f(iC, gVar) : new t.a(gVar);
            } else {
                aVar = new t.a(gVar);
            }
            return new e(aVar, gVar);
        }
    }

    /* JADX INFO: renamed from: t.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MemoryCache.kt */
    public static final class C0690c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final Bitmap f33991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final Map<String, Object> f33992b;

        public C0690c(@NotNull Bitmap bitmap, @NotNull Map<String, ? extends Object> map) {
            this.f33991a = bitmap;
            this.f33992b = map;
        }

        @NotNull
        public final Bitmap a() {
            return this.f33991a;
        }

        @NotNull
        public final Map<String, Object> b() {
            return this.f33992b;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof C0690c) {
                C0690c c0690c = (C0690c) obj;
                if (t.d(this.f33991a, c0690c.f33991a) && t.d(this.f33992b, c0690c.f33992b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.f33991a.hashCode() * 31) + this.f33992b.hashCode();
        }

        @NotNull
        public String toString() {
            return "Value(bitmap=" + this.f33991a + ", extras=" + this.f33992b + ')';
        }
    }

    void a(int i10);

    @Nullable
    C0690c b(@NotNull b bVar);

    void c(@NotNull b bVar, @NotNull C0690c c0690c);

    /* JADX INFO: compiled from: MemoryCache.kt */
    public static final class b implements Parcelable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f33989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final Map<String, String> f33990b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private static final C0689b f33988c = new C0689b(null);

        @Deprecated
        @NotNull
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* JADX INFO: compiled from: MemoryCache.kt */
        public static final class a implements Parcelable.Creator<b> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(@NotNull Parcel parcel) {
                String string = parcel.readString();
                t.f(string);
                int i10 = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(i10);
                for (int i11 = 0; i11 < i10; i11++) {
                    String string2 = parcel.readString();
                    t.f(string2);
                    String string3 = parcel.readString();
                    t.f(string3);
                    linkedHashMap.put(string2, string3);
                }
                return new b(string, linkedHashMap);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i10) {
                return new b[i10];
            }
        }

        /* JADX INFO: renamed from: t.c$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MemoryCache.kt */
        private static final class C0689b {
            private C0689b() {
            }

            public /* synthetic */ C0689b(k kVar) {
                this();
            }
        }

        public b(@NotNull String str, @NotNull Map<String, String> map) {
            this.f33989a = str;
            this.f33990b = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ b b(b bVar, String str, Map map, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = bVar.f33989a;
            }
            if ((i10 & 2) != 0) {
                map = bVar.f33990b;
            }
            return bVar.a(str, map);
        }

        @NotNull
        public final b a(@NotNull String str, @NotNull Map<String, String> map) {
            return new b(str, map);
        }

        @NotNull
        public final Map<String, String> c() {
            return this.f33990b;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (t.d(this.f33989a, bVar.f33989a) && t.d(this.f33990b, bVar.f33990b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.f33989a.hashCode() * 31) + this.f33990b.hashCode();
        }

        @NotNull
        public String toString() {
            return "Key(key=" + this.f33989a + ", extras=" + this.f33990b + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i10) {
            parcel.writeString(this.f33989a);
            parcel.writeInt(this.f33990b.size());
            for (Map.Entry<String, String> entry : this.f33990b.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                parcel.writeString(key);
                parcel.writeString(value);
            }
        }

        public /* synthetic */ b(String str, Map map, int i10, k kVar) {
            this(str, (i10 & 2) != 0 ? r0.g() : map);
        }
    }
}
