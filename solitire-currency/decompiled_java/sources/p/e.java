package p;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import com.ironsource.v8;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import kotlin.jvm.internal.t;
import m.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p.i;
import ua.k0;
import v.n;
import w.c;

/* JADX INFO: compiled from: ContentUriFetcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Uri f32341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final n f32342b;

    /* JADX INFO: compiled from: ContentUriFetcher.kt */
    public static final class a implements i.a<Uri> {
        private final boolean c(Uri uri) {
            return t.d(uri.getScheme(), "content");
        }

        @Override // p.i.a
        @Nullable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public i a(@NotNull Uri uri, @NotNull n nVar, @NotNull j.e eVar) {
            if (c(uri)) {
                return new e(uri, nVar);
            }
            return null;
        }
    }

    public e(@NotNull Uri uri, @NotNull n nVar) {
        this.f32341a = uri;
        this.f32342b = nVar;
    }

    private final Bundle d() {
        w.c cVarB = this.f32342b.n().b();
        c.a aVar = cVarB instanceof c.a ? (c.a) cVarB : null;
        if (aVar == null) {
            return null;
        }
        int i10 = aVar.f35260a;
        w.c cVarA = this.f32342b.n().a();
        c.a aVar2 = cVarA instanceof c.a ? (c.a) cVarA : null;
        if (aVar2 == null) {
            return null;
        }
        int i11 = aVar2.f35260a;
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("android.content.extra.SIZE", new Point(i10, i11));
        return bundle;
    }

    @Override // p.i
    @Nullable
    public Object a(@NotNull z8.d<? super h> dVar) throws FileNotFoundException {
        InputStream inputStreamOpenInputStream;
        ContentResolver contentResolver = this.f32342b.g().getContentResolver();
        if (b(this.f32341a)) {
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(this.f32341a, AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ);
            inputStreamOpenInputStream = assetFileDescriptorOpenAssetFileDescriptor != null ? assetFileDescriptorOpenAssetFileDescriptor.createInputStream() : null;
            if (inputStreamOpenInputStream == null) {
                throw new IllegalStateException(("Unable to find a contact photo associated with '" + this.f32341a + "'.").toString());
            }
        } else if (Build.VERSION.SDK_INT < 29 || !c(this.f32341a)) {
            inputStreamOpenInputStream = contentResolver.openInputStream(this.f32341a);
            if (inputStreamOpenInputStream == null) {
                throw new IllegalStateException(("Unable to open '" + this.f32341a + "'.").toString());
            }
        } else {
            AssetFileDescriptor assetFileDescriptorOpenTypedAssetFile = contentResolver.openTypedAssetFile(this.f32341a, "image/*", d(), null);
            inputStreamOpenInputStream = assetFileDescriptorOpenTypedAssetFile != null ? assetFileDescriptorOpenTypedAssetFile.createInputStream() : null;
            if (inputStreamOpenInputStream == null) {
                throw new IllegalStateException(("Unable to find a music thumbnail associated with '" + this.f32341a + "'.").toString());
            }
        }
        return new m(q.b(k0.d(k0.l(inputStreamOpenInputStream)), this.f32342b.g(), new m.e(this.f32341a)), contentResolver.getType(this.f32341a), m.f.DISK);
    }

    @VisibleForTesting
    public final boolean b(@NotNull Uri uri) {
        return t.d(uri.getAuthority(), "com.android.contacts") && t.d(uri.getLastPathSegment(), "display_photo");
    }

    @VisibleForTesting
    public final boolean c(@NotNull Uri uri) {
        List<String> pathSegments;
        int size;
        return t.d(uri.getAuthority(), v8.h.I0) && (size = (pathSegments = uri.getPathSegments()).size()) >= 3 && t.d(pathSegments.get(size + (-3)), "audio") && t.d(pathSegments.get(size + (-2)), "albums");
    }
}
