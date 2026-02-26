package z3;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: HttpDataSource.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b0 extends z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f37365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final String f37366e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, List<String>> f37367f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f37368g;

    public b0(int i10, @Nullable String str, @Nullable IOException iOException, Map<String, List<String>> map, o oVar, byte[] bArr) {
        super("Response code: " + i10, iOException, oVar, 2004, 1);
        this.f37365d = i10;
        this.f37366e = str;
        this.f37367f = map;
        this.f37368g = bArr;
    }
}
