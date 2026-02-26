package y0;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.InputStream;
import y0.n;

/* JADX INFO: compiled from: ResourceLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public class s<Data> implements n<Integer, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n<Uri, Data> f36328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Resources f36329b;

    /* JADX INFO: compiled from: ResourceLoader.java */
    public static final class a implements o<Integer, AssetFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Resources f36330a;

        public a(Resources resources) {
            this.f36330a = resources;
        }

        @Override // y0.o
        public n<Integer, AssetFileDescriptor> b(r rVar) {
            return new s(this.f36330a, rVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* JADX INFO: compiled from: ResourceLoader.java */
    public static class b implements o<Integer, ParcelFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Resources f36331a;

        public b(Resources resources) {
            this.f36331a = resources;
        }

        @Override // y0.o
        @NonNull
        public n<Integer, ParcelFileDescriptor> b(r rVar) {
            return new s(this.f36331a, rVar.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* JADX INFO: compiled from: ResourceLoader.java */
    public static class c implements o<Integer, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Resources f36332a;

        public c(Resources resources) {
            this.f36332a = resources;
        }

        @Override // y0.o
        @NonNull
        public n<Integer, InputStream> b(r rVar) {
            return new s(this.f36332a, rVar.d(Uri.class, InputStream.class));
        }
    }

    /* JADX INFO: compiled from: ResourceLoader.java */
    public static class d implements o<Integer, Uri> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Resources f36333a;

        public d(Resources resources) {
            this.f36333a = resources;
        }

        @Override // y0.o
        @NonNull
        public n<Integer, Uri> b(r rVar) {
            return new s(this.f36333a, v.c());
        }
    }

    public s(Resources resources, n<Uri, Data> nVar) {
        this.f36329b = resources;
        this.f36328a = nVar;
    }

    @Nullable
    private Uri d(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f36329b.getResourcePackageName(num.intValue()) + '/' + this.f36329b.getResourceTypeName(num.intValue()) + '/' + this.f36329b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e10) {
            if (!Log.isLoggable("ResourceLoader", 5)) {
                return null;
            }
            Log.w("ResourceLoader", "Received invalid resource id: " + num, e10);
            return null;
        }
    }

    @Override // y0.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> b(@NonNull Integer num, int i10, int i11, @NonNull r0.h hVar) {
        Uri uriD = d(num);
        if (uriD == null) {
            return null;
        }
        return this.f36328a.b(uriD, i10, i11, hVar);
    }

    @Override // y0.n
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Integer num) {
        return true;
    }
}
