package k2;

import android.os.Bundle;

/* JADX INFO: compiled from: Bundleable.java */
/* JADX INFO: loaded from: classes2.dex */
public interface h {

    /* JADX INFO: compiled from: Bundleable.java */
    public interface a<T extends h> {
        T fromBundle(Bundle bundle);
    }

    Bundle toBundle();
}
