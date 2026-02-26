package androidx.media3.extractor.text;

import androidx.media3.common.util.Consumer;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.common.collect.y;
import java.util.Objects;

/* JADX INFO: compiled from: SubtitleParser.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e {
    public static void a(SubtitleParser subtitleParser, byte[] bArr, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        subtitleParser.parse(bArr, 0, bArr.length, outputOptions, consumer);
    }

    public static Subtitle b(SubtitleParser subtitleParser, byte[] bArr, int i10, int i11) {
        final y.a aVarK = y.k();
        SubtitleParser.OutputOptions outputOptions = SubtitleParser.OutputOptions.ALL;
        Objects.requireNonNull(aVarK);
        subtitleParser.parse(bArr, i10, i11, outputOptions, new Consumer() { // from class: androidx.media3.extractor.text.d
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                aVarK.a((CuesWithTiming) obj);
            }
        });
        return new CuesWithTimingSubtitle(aVarK.k());
    }

    public static void c(SubtitleParser subtitleParser) {
    }
}
