package androidx.media3.extractor;

import android.net.Uri;
import androidx.media3.extractor.text.SubtitleParser;
import java.util.Map;

/* JADX INFO: compiled from: ExtractorsFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f {
    static {
        ExtractorsFactory extractorsFactory = ExtractorsFactory.EMPTY;
    }

    public static Extractor[] a(ExtractorsFactory extractorsFactory, Uri uri, Map map) {
        return extractorsFactory.createExtractors();
    }

    public static /* synthetic */ Extractor[] d() {
        return new Extractor[0];
    }

    public static ExtractorsFactory b(ExtractorsFactory extractorsFactory, boolean z10) {
        return extractorsFactory;
    }

    public static ExtractorsFactory c(ExtractorsFactory extractorsFactory, SubtitleParser.Factory factory) {
        return extractorsFactory;
    }
}
