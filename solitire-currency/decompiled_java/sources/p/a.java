package p;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.unity3d.services.UnityAdsConstants;
import kotlin.collections.d0;
import m.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p.i;
import ua.k0;
import v.n;

/* JADX INFO: compiled from: AssetUriFetcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Uri f32335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final n f32336b;

    /* JADX INFO: renamed from: p.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AssetUriFetcher.kt */
    public static final class C0646a implements i.a<Uri> {
        @Override // p.i.a
        @Nullable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public i a(@NotNull Uri uri, @NotNull n nVar, @NotNull j.e eVar) {
            if (a0.j.q(uri)) {
                return new a(uri, nVar);
            }
            return null;
        }
    }

    public a(@NotNull Uri uri, @NotNull n nVar) {
        this.f32335a = uri;
        this.f32336b = nVar;
    }

    @Override // p.i
    @Nullable
    public Object a(@NotNull z8.d<? super h> dVar) {
        String strR0 = d0.r0(d0.d0(this.f32335a.getPathSegments(), 1), UnityAdsConstants.DefaultUrls.AD_ASSET_PATH, null, null, 0, null, null, 62, null);
        return new m(q.b(k0.d(k0.l(this.f32336b.g().getAssets().open(strR0))), this.f32336b.g(), new m.a(strR0)), a0.j.j(MimeTypeMap.getSingleton(), strR0), m.f.DISK);
    }
}
