package s0;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import java.io.IOException;

/* JADX INFO: compiled from: FileDescriptorAssetPathFetcher.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends b<ParcelFileDescriptor> {
    public h(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // s0.d
    @NonNull
    public Class<ParcelFileDescriptor> a() {
        return ParcelFileDescriptor.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // s0.b
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void c(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // s0.b
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public ParcelFileDescriptor f(AssetManager assetManager, String str) throws IOException {
        return assetManager.openFd(str).getParcelFileDescriptor();
    }
}
