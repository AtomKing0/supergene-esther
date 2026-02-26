package p2;

import android.net.Uri;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ExtractorsFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public interface r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f32527a = new r() { // from class: p2.p
        @Override // p2.r
        public final l[] createExtractors() {
            return q.b();
        }

        @Override // p2.r
        public /* synthetic */ l[] createExtractors(Uri uri, Map map) {
            return q.a(this, uri, map);
        }
    };

    l[] createExtractors();

    l[] createExtractors(Uri uri, Map<String, List<String>> map);
}
