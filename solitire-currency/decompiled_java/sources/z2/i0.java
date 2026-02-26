package z2;

import a4.l0;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.unity3d.services.UnityAdsConstants;
import java.util.Collections;
import java.util.List;
import k2.j2;

/* JADX INFO: compiled from: TsPayloadReader.java */
/* JADX INFO: loaded from: classes2.dex */
public interface i0 {

    /* JADX INFO: compiled from: TsPayloadReader.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f37136a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f37137b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f37138c;

        public a(String str, int i10, byte[] bArr) {
            this.f37136a = str;
            this.f37137b = i10;
            this.f37138c = bArr;
        }
    }

    /* JADX INFO: compiled from: TsPayloadReader.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f37139a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final String f37140b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<a> f37141c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f37142d;

        public b(int i10, @Nullable String str, @Nullable List<a> list, byte[] bArr) {
            this.f37139a = i10;
            this.f37140b = str;
            this.f37141c = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.f37142d = bArr;
        }
    }

    /* JADX INFO: compiled from: TsPayloadReader.java */
    public interface c {
        @Nullable
        i0 a(int i10, b bVar);

        SparseArray<i0> createInitialPayloadReaders();
    }

    /* JADX INFO: compiled from: TsPayloadReader.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f37143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f37144b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f37145c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f37146d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f37147e;

        public d(int i10, int i11) {
            this(Integer.MIN_VALUE, i10, i11);
        }

        private void d() {
            if (this.f37146d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public void a() {
            int i10 = this.f37146d;
            this.f37146d = i10 == Integer.MIN_VALUE ? this.f37144b : i10 + this.f37145c;
            this.f37147e = this.f37143a + this.f37146d;
        }

        public String b() {
            d();
            return this.f37147e;
        }

        public int c() {
            d();
            return this.f37146d;
        }

        public d(int i10, int i11, int i12) {
            String str;
            if (i10 != Integer.MIN_VALUE) {
                str = i10 + UnityAdsConstants.DefaultUrls.AD_ASSET_PATH;
            } else {
                str = "";
            }
            this.f37143a = str;
            this.f37144b = i11;
            this.f37145c = i12;
            this.f37146d = Integer.MIN_VALUE;
            this.f37147e = "";
        }
    }

    void a(a4.c0 c0Var, int i10) throws j2;

    void b(l0 l0Var, p2.n nVar, d dVar);

    void seek();
}
