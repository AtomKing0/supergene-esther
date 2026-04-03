package k2;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import com.google.common.collect.y;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import k2.h;
import k2.w1;

/* JADX INFO: compiled from: MediaItem.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w1 implements k2.h {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final w1 f29514i = new c().a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final h.a<w1> f29515j = new h.a() { // from class: k2.v1
        @Override // k2.h.a
        public final h fromBundle(Bundle bundle) {
            return w1.c(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f29516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final h f29517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    @Deprecated
    public final i f29518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f29519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b2 f29520e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f29521f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Deprecated
    public final e f29522g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j f29523h;

    /* JADX INFO: compiled from: MediaItem.java */
    public static final class b {
    }

    /* JADX INFO: compiled from: MediaItem.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private String f29524a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private Uri f29525b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private String f29526c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private d.a f29527d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private f.a f29528e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private List<Object> f29529f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        private String f29530g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private com.google.common.collect.y<l> f29531h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        private Object f29532i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Nullable
        private b2 f29533j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private g.a f29534k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private j f29535l;

        public w1 a() {
            i iVar;
            a4.a.g(this.f29528e.f29561b == null || this.f29528e.f29560a != null);
            Uri uri = this.f29525b;
            if (uri != null) {
                iVar = new i(uri, this.f29526c, this.f29528e.f29560a != null ? this.f29528e.i() : null, null, this.f29529f, this.f29530g, this.f29531h, this.f29532i);
            } else {
                iVar = null;
            }
            String str = this.f29524a;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            e eVarG = this.f29527d.g();
            g gVarF = this.f29534k.f();
            b2 b2Var = this.f29533j;
            if (b2Var == null) {
                b2Var = b2.G;
            }
            return new w1(str2, eVarG, iVar, gVarF, b2Var, this.f29535l);
        }

        public c b(@Nullable String str) {
            this.f29530g = str;
            return this;
        }

        public c c(g gVar) {
            this.f29534k = gVar.b();
            return this;
        }

        public c d(String str) {
            this.f29524a = (String) a4.a.e(str);
            return this;
        }

        public c e(List<l> list) {
            this.f29531h = com.google.common.collect.y.m(list);
            return this;
        }

        public c f(@Nullable Object obj) {
            this.f29532i = obj;
            return this;
        }

        public c g(@Nullable Uri uri) {
            this.f29525b = uri;
            return this;
        }

        public c h(@Nullable String str) {
            return g(str == null ? null : Uri.parse(str));
        }

        public c() {
            this.f29527d = new d.a();
            this.f29528e = new f.a();
            this.f29529f = Collections.emptyList();
            this.f29531h = com.google.common.collect.y.q();
            this.f29534k = new g.a();
            this.f29535l = j.f29588d;
        }

        private c(w1 w1Var) {
            f.a aVar;
            this();
            this.f29527d = w1Var.f29521f.b();
            this.f29524a = w1Var.f29516a;
            this.f29533j = w1Var.f29520e;
            this.f29534k = w1Var.f29519d.b();
            this.f29535l = w1Var.f29523h;
            h hVar = w1Var.f29517b;
            if (hVar != null) {
                this.f29530g = hVar.f29584e;
                this.f29526c = hVar.f29581b;
                this.f29525b = hVar.f29580a;
                this.f29529f = hVar.f29583d;
                this.f29531h = hVar.f29585f;
                this.f29532i = hVar.f29587h;
                f fVar = hVar.f29582c;
                if (fVar != null) {
                    aVar = fVar.b();
                } else {
                    aVar = new f.a();
                }
                this.f29528e = aVar;
            }
        }
    }

    /* JADX INFO: compiled from: MediaItem.java */
    public static class d implements k2.h {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final d f29536f = new a().f();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final h.a<e> f29537g = new h.a() { // from class: k2.x1
            @Override // k2.h.a
            public final h fromBundle(Bundle bundle) {
                return w1.d.d(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @IntRange(from = 0)
        public final long f29538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f29539b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f29540c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f29541d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f29542e;

        /* JADX INFO: compiled from: MediaItem.java */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private long f29543a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private long f29544b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private boolean f29545c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private boolean f29546d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private boolean f29547e;

            public d f() {
                return g();
            }

            @Deprecated
            public e g() {
                return new e(this);
            }

            public a h(long j10) {
                a4.a.a(j10 == Long.MIN_VALUE || j10 >= 0);
                this.f29544b = j10;
                return this;
            }

            public a i(boolean z10) {
                this.f29546d = z10;
                return this;
            }

            public a j(boolean z10) {
                this.f29545c = z10;
                return this;
            }

            public a k(@IntRange(from = 0) long j10) {
                a4.a.a(j10 >= 0);
                this.f29543a = j10;
                return this;
            }

            public a l(boolean z10) {
                this.f29547e = z10;
                return this;
            }

            public a() {
                this.f29544b = Long.MIN_VALUE;
            }

            private a(d dVar) {
                this.f29543a = dVar.f29538a;
                this.f29544b = dVar.f29539b;
                this.f29545c = dVar.f29540c;
                this.f29546d = dVar.f29541d;
                this.f29547e = dVar.f29542e;
            }
        }

        private static String c(int i10) {
            return Integer.toString(i10, 36);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ e d(Bundle bundle) {
            return new a().k(bundle.getLong(c(0), 0L)).h(bundle.getLong(c(1), Long.MIN_VALUE)).j(bundle.getBoolean(c(2), false)).i(bundle.getBoolean(c(3), false)).l(bundle.getBoolean(c(4), false)).g();
        }

        public a b() {
            return new a();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f29538a == dVar.f29538a && this.f29539b == dVar.f29539b && this.f29540c == dVar.f29540c && this.f29541d == dVar.f29541d && this.f29542e == dVar.f29542e;
        }

        public int hashCode() {
            long j10 = this.f29538a;
            int i10 = ((int) (j10 ^ (j10 >>> 32))) * 31;
            long j11 = this.f29539b;
            return ((((((i10 + ((int) ((j11 >>> 32) ^ j11))) * 31) + (this.f29540c ? 1 : 0)) * 31) + (this.f29541d ? 1 : 0)) * 31) + (this.f29542e ? 1 : 0);
        }

        @Override // k2.h
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong(c(0), this.f29538a);
            bundle.putLong(c(1), this.f29539b);
            bundle.putBoolean(c(2), this.f29540c);
            bundle.putBoolean(c(3), this.f29541d);
            bundle.putBoolean(c(4), this.f29542e);
            return bundle;
        }

        private d(a aVar) {
            this.f29538a = aVar.f29543a;
            this.f29539b = aVar.f29544b;
            this.f29540c = aVar.f29545c;
            this.f29541d = aVar.f29546d;
            this.f29542e = aVar.f29547e;
        }
    }

    /* JADX INFO: compiled from: MediaItem.java */
    @Deprecated
    public static final class e extends d {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final e f29548h = new d.a().g();

        private e(d.a aVar) {
            super(aVar);
        }
    }

    /* JADX INFO: compiled from: MediaItem.java */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UUID f29549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Deprecated
        public final UUID f29550b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final Uri f29551c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Deprecated
        public final com.google.common.collect.a0<String, String> f29552d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final com.google.common.collect.a0<String, String> f29553e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f29554f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f29555g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f29556h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Deprecated
        public final com.google.common.collect.y<Integer> f29557i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final com.google.common.collect.y<Integer> f29558j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        private final byte[] f29559k;

        public a b() {
            return new a();
        }

        @Nullable
        public byte[] c() {
            byte[] bArr = this.f29559k;
            if (bArr != null) {
                return Arrays.copyOf(bArr, bArr.length);
            }
            return null;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.f29549a.equals(fVar.f29549a) && a4.o0.c(this.f29551c, fVar.f29551c) && a4.o0.c(this.f29553e, fVar.f29553e) && this.f29554f == fVar.f29554f && this.f29556h == fVar.f29556h && this.f29555g == fVar.f29555g && this.f29558j.equals(fVar.f29558j) && Arrays.equals(this.f29559k, fVar.f29559k);
        }

        public int hashCode() {
            int iHashCode = this.f29549a.hashCode() * 31;
            Uri uri = this.f29551c;
            return ((((((((((((iHashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.f29553e.hashCode()) * 31) + (this.f29554f ? 1 : 0)) * 31) + (this.f29556h ? 1 : 0)) * 31) + (this.f29555g ? 1 : 0)) * 31) + this.f29558j.hashCode()) * 31) + Arrays.hashCode(this.f29559k);
        }

        /* JADX INFO: compiled from: MediaItem.java */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @Nullable
            private UUID f29560a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @Nullable
            private Uri f29561b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private com.google.common.collect.a0<String, String> f29562c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private boolean f29563d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private boolean f29564e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private boolean f29565f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private com.google.common.collect.y<Integer> f29566g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            @Nullable
            private byte[] f29567h;

            public f i() {
                return new f(this);
            }

            @Deprecated
            private a() {
                this.f29562c = com.google.common.collect.a0.k();
                this.f29566g = com.google.common.collect.y.q();
            }

            private a(f fVar) {
                this.f29560a = fVar.f29549a;
                this.f29561b = fVar.f29551c;
                this.f29562c = fVar.f29553e;
                this.f29563d = fVar.f29554f;
                this.f29564e = fVar.f29555g;
                this.f29565f = fVar.f29556h;
                this.f29566g = fVar.f29558j;
                this.f29567h = fVar.f29559k;
            }
        }

        private f(a aVar) {
            a4.a.g((aVar.f29565f && aVar.f29561b == null) ? false : true);
            UUID uuid = (UUID) a4.a.e(aVar.f29560a);
            this.f29549a = uuid;
            this.f29550b = uuid;
            this.f29551c = aVar.f29561b;
            this.f29552d = aVar.f29562c;
            this.f29553e = aVar.f29562c;
            this.f29554f = aVar.f29563d;
            this.f29556h = aVar.f29565f;
            this.f29555g = aVar.f29564e;
            this.f29557i = aVar.f29566g;
            this.f29558j = aVar.f29566g;
            this.f29559k = aVar.f29567h != null ? Arrays.copyOf(aVar.f29567h, aVar.f29567h.length) : null;
        }
    }

    /* JADX INFO: compiled from: MediaItem.java */
    public static final class g implements k2.h {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final g f29568f = new a().f();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final h.a<g> f29569g = new h.a() { // from class: k2.y1
            @Override // k2.h.a
            public final h fromBundle(Bundle bundle) {
                return w1.g.d(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f29570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f29571b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f29572c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f29573d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f29574e;

        /* JADX INFO: compiled from: MediaItem.java */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private long f29575a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private long f29576b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private long f29577c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private float f29578d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private float f29579e;

            public g f() {
                return new g(this);
            }

            public a g(long j10) {
                this.f29577c = j10;
                return this;
            }

            public a h(float f10) {
                this.f29579e = f10;
                return this;
            }

            public a i(long j10) {
                this.f29576b = j10;
                return this;
            }

            public a j(float f10) {
                this.f29578d = f10;
                return this;
            }

            public a k(long j10) {
                this.f29575a = j10;
                return this;
            }

            public a() {
                this.f29575a = C.TIME_UNSET;
                this.f29576b = C.TIME_UNSET;
                this.f29577c = C.TIME_UNSET;
                this.f29578d = -3.4028235E38f;
                this.f29579e = -3.4028235E38f;
            }

            private a(g gVar) {
                this.f29575a = gVar.f29570a;
                this.f29576b = gVar.f29571b;
                this.f29577c = gVar.f29572c;
                this.f29578d = gVar.f29573d;
                this.f29579e = gVar.f29574e;
            }
        }

        private static String c(int i10) {
            return Integer.toString(i10, 36);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ g d(Bundle bundle) {
            return new g(bundle.getLong(c(0), C.TIME_UNSET), bundle.getLong(c(1), C.TIME_UNSET), bundle.getLong(c(2), C.TIME_UNSET), bundle.getFloat(c(3), -3.4028235E38f), bundle.getFloat(c(4), -3.4028235E38f));
        }

        public a b() {
            return new a();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.f29570a == gVar.f29570a && this.f29571b == gVar.f29571b && this.f29572c == gVar.f29572c && this.f29573d == gVar.f29573d && this.f29574e == gVar.f29574e;
        }

        public int hashCode() {
            long j10 = this.f29570a;
            long j11 = this.f29571b;
            int i10 = ((((int) (j10 ^ (j10 >>> 32))) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31;
            long j12 = this.f29572c;
            int i11 = (i10 + ((int) ((j12 >>> 32) ^ j12))) * 31;
            float f10 = this.f29573d;
            int iFloatToIntBits = (i11 + (f10 != 0.0f ? Float.floatToIntBits(f10) : 0)) * 31;
            float f11 = this.f29574e;
            return iFloatToIntBits + (f11 != 0.0f ? Float.floatToIntBits(f11) : 0);
        }

        @Override // k2.h
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong(c(0), this.f29570a);
            bundle.putLong(c(1), this.f29571b);
            bundle.putLong(c(2), this.f29572c);
            bundle.putFloat(c(3), this.f29573d);
            bundle.putFloat(c(4), this.f29574e);
            return bundle;
        }

        private g(a aVar) {
            this(aVar.f29575a, aVar.f29576b, aVar.f29577c, aVar.f29578d, aVar.f29579e);
        }

        @Deprecated
        public g(long j10, long j11, long j12, float f10, float f11) {
            this.f29570a = j10;
            this.f29571b = j11;
            this.f29572c = j12;
            this.f29573d = f10;
            this.f29574e = f11;
        }
    }

    /* JADX INFO: compiled from: MediaItem.java */
    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f29580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final String f29581b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final f f29582c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<Object> f29583d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public final String f29584e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final com.google.common.collect.y<l> f29585f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Deprecated
        public final List<k> f29586g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public final Object f29587h;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return this.f29580a.equals(hVar.f29580a) && a4.o0.c(this.f29581b, hVar.f29581b) && a4.o0.c(this.f29582c, hVar.f29582c) && a4.o0.c(null, null) && this.f29583d.equals(hVar.f29583d) && a4.o0.c(this.f29584e, hVar.f29584e) && this.f29585f.equals(hVar.f29585f) && a4.o0.c(this.f29587h, hVar.f29587h);
        }

        public int hashCode() {
            int iHashCode = this.f29580a.hashCode() * 31;
            String str = this.f29581b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            f fVar = this.f29582c;
            int iHashCode3 = (((((iHashCode2 + (fVar == null ? 0 : fVar.hashCode())) * 31) + 0) * 31) + this.f29583d.hashCode()) * 31;
            String str2 = this.f29584e;
            int iHashCode4 = (((iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f29585f.hashCode()) * 31;
            Object obj = this.f29587h;
            return iHashCode4 + (obj != null ? obj.hashCode() : 0);
        }

        private h(Uri uri, @Nullable String str, @Nullable f fVar, @Nullable b bVar, List<Object> list, @Nullable String str2, com.google.common.collect.y<l> yVar, @Nullable Object obj) {
            this.f29580a = uri;
            this.f29581b = str;
            this.f29582c = fVar;
            this.f29583d = list;
            this.f29584e = str2;
            this.f29585f = yVar;
            y.a aVarK = com.google.common.collect.y.k();
            for (int i10 = 0; i10 < yVar.size(); i10++) {
                aVarK.a(yVar.get(i10).a().i());
            }
            this.f29586g = aVarK.k();
            this.f29587h = obj;
        }
    }

    /* JADX INFO: compiled from: MediaItem.java */
    @Deprecated
    public static final class i extends h {
        private i(Uri uri, @Nullable String str, @Nullable f fVar, @Nullable b bVar, List<Object> list, @Nullable String str2, com.google.common.collect.y<l> yVar, @Nullable Object obj) {
            super(uri, str, fVar, bVar, list, str2, yVar, obj);
        }
    }

    /* JADX INFO: compiled from: MediaItem.java */
    public static final class j implements k2.h {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final j f29588d = new a().d();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final h.a<j> f29589e = new h.a() { // from class: k2.z1
            @Override // k2.h.a
            public final h fromBundle(Bundle bundle) {
                return w1.j.c(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Uri f29590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final String f29591b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final Bundle f29592c;

        /* JADX INFO: compiled from: MediaItem.java */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @Nullable
            private Uri f29593a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @Nullable
            private String f29594b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @Nullable
            private Bundle f29595c;

            public j d() {
                return new j(this);
            }

            public a e(@Nullable Bundle bundle) {
                this.f29595c = bundle;
                return this;
            }

            public a f(@Nullable Uri uri) {
                this.f29593a = uri;
                return this;
            }

            public a g(@Nullable String str) {
                this.f29594b = str;
                return this;
            }
        }

        private static String b(int i10) {
            return Integer.toString(i10, 36);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ j c(Bundle bundle) {
            return new a().f((Uri) bundle.getParcelable(b(0))).g(bundle.getString(b(1))).e(bundle.getBundle(b(2))).d();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return a4.o0.c(this.f29590a, jVar.f29590a) && a4.o0.c(this.f29591b, jVar.f29591b);
        }

        public int hashCode() {
            Uri uri = this.f29590a;
            int iHashCode = (uri == null ? 0 : uri.hashCode()) * 31;
            String str = this.f29591b;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        @Override // k2.h
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            if (this.f29590a != null) {
                bundle.putParcelable(b(0), this.f29590a);
            }
            if (this.f29591b != null) {
                bundle.putString(b(1), this.f29591b);
            }
            if (this.f29592c != null) {
                bundle.putBundle(b(2), this.f29592c);
            }
            return bundle;
        }

        private j(a aVar) {
            this.f29590a = aVar.f29593a;
            this.f29591b = aVar.f29594b;
            this.f29592c = aVar.f29595c;
        }
    }

    /* JADX INFO: compiled from: MediaItem.java */
    @Deprecated
    public static final class k extends l {
        private k(l.a aVar) {
            super(aVar);
        }
    }

    /* JADX INFO: compiled from: MediaItem.java */
    public static class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f29596a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final String f29597b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final String f29598c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f29599d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f29600e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public final String f29601f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public final String f29602g;

        /* JADX INFO: compiled from: MediaItem.java */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private Uri f29603a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @Nullable
            private String f29604b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @Nullable
            private String f29605c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f29606d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private int f29607e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            @Nullable
            private String f29608f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            @Nullable
            private String f29609g;

            /* JADX INFO: Access modifiers changed from: private */
            public k i() {
                return new k(this);
            }

            private a(l lVar) {
                this.f29603a = lVar.f29596a;
                this.f29604b = lVar.f29597b;
                this.f29605c = lVar.f29598c;
                this.f29606d = lVar.f29599d;
                this.f29607e = lVar.f29600e;
                this.f29608f = lVar.f29601f;
                this.f29609g = lVar.f29602g;
            }
        }

        public a a() {
            return new a();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return this.f29596a.equals(lVar.f29596a) && a4.o0.c(this.f29597b, lVar.f29597b) && a4.o0.c(this.f29598c, lVar.f29598c) && this.f29599d == lVar.f29599d && this.f29600e == lVar.f29600e && a4.o0.c(this.f29601f, lVar.f29601f) && a4.o0.c(this.f29602g, lVar.f29602g);
        }

        public int hashCode() {
            int iHashCode = this.f29596a.hashCode() * 31;
            String str = this.f29597b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f29598c;
            int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f29599d) * 31) + this.f29600e) * 31;
            String str3 = this.f29601f;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f29602g;
            return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
        }

        private l(a aVar) {
            this.f29596a = aVar.f29603a;
            this.f29597b = aVar.f29604b;
            this.f29598c = aVar.f29605c;
            this.f29599d = aVar.f29606d;
            this.f29600e = aVar.f29607e;
            this.f29601f = aVar.f29608f;
            this.f29602g = aVar.f29609g;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static w1 c(Bundle bundle) {
        String str = (String) a4.a.e(bundle.getString(e(0), ""));
        Bundle bundle2 = bundle.getBundle(e(1));
        g gVar = bundle2 == null ? g.f29568f : (g) g.f29569g.fromBundle(bundle2);
        Bundle bundle3 = bundle.getBundle(e(2));
        b2 b2Var = bundle3 == null ? b2.G : (b2) b2.H.fromBundle(bundle3);
        Bundle bundle4 = bundle.getBundle(e(3));
        e eVar = bundle4 == null ? e.f29548h : (e) d.f29537g.fromBundle(bundle4);
        Bundle bundle5 = bundle.getBundle(e(4));
        return new w1(str, eVar, null, gVar, b2Var, bundle5 == null ? j.f29588d : (j) j.f29589e.fromBundle(bundle5));
    }

    public static w1 d(String str) {
        return new c().h(str).a();
    }

    private static String e(int i10) {
        return Integer.toString(i10, 36);
    }

    public c b() {
        return new c();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w1)) {
            return false;
        }
        w1 w1Var = (w1) obj;
        return a4.o0.c(this.f29516a, w1Var.f29516a) && this.f29521f.equals(w1Var.f29521f) && a4.o0.c(this.f29517b, w1Var.f29517b) && a4.o0.c(this.f29519d, w1Var.f29519d) && a4.o0.c(this.f29520e, w1Var.f29520e) && a4.o0.c(this.f29523h, w1Var.f29523h);
    }

    public int hashCode() {
        int iHashCode = this.f29516a.hashCode() * 31;
        h hVar = this.f29517b;
        return ((((((((iHashCode + (hVar != null ? hVar.hashCode() : 0)) * 31) + this.f29519d.hashCode()) * 31) + this.f29521f.hashCode()) * 31) + this.f29520e.hashCode()) * 31) + this.f29523h.hashCode();
    }

    @Override // k2.h
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(e(0), this.f29516a);
        bundle.putBundle(e(1), this.f29519d.toBundle());
        bundle.putBundle(e(2), this.f29520e.toBundle());
        bundle.putBundle(e(3), this.f29521f.toBundle());
        bundle.putBundle(e(4), this.f29523h.toBundle());
        return bundle;
    }

    private w1(String str, e eVar, @Nullable i iVar, g gVar, b2 b2Var, j jVar) {
        this.f29516a = str;
        this.f29517b = iVar;
        this.f29518c = iVar;
        this.f29519d = gVar;
        this.f29520e = b2Var;
        this.f29521f = eVar;
        this.f29522g = eVar;
        this.f29523h = jVar;
    }
}
