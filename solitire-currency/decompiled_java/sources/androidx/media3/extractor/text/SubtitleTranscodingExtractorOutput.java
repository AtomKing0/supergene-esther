package androidx.media3.extractor.text;

import android.util.SparseArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.text.SubtitleParser;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public final class SubtitleTranscodingExtractorOutput implements ExtractorOutput {
    private final ExtractorOutput delegate;
    private final SubtitleParser.Factory subtitleParserFactory;
    private final SparseArray<SubtitleTranscodingTrackOutput> textTrackOutputs = new SparseArray<>();

    public SubtitleTranscodingExtractorOutput(ExtractorOutput extractorOutput, SubtitleParser.Factory factory) {
        this.delegate = extractorOutput;
        this.subtitleParserFactory = factory;
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public void endTracks() {
        this.delegate.endTracks();
    }

    public void resetSubtitleParsers() {
        for (int i10 = 0; i10 < this.textTrackOutputs.size(); i10++) {
            this.textTrackOutputs.valueAt(i10).resetSubtitleParser();
        }
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public void seekMap(SeekMap seekMap) {
        this.delegate.seekMap(seekMap);
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public TrackOutput track(int i10, int i11) {
        if (i11 != 3) {
            return this.delegate.track(i10, i11);
        }
        SubtitleTranscodingTrackOutput subtitleTranscodingTrackOutput = this.textTrackOutputs.get(i10);
        if (subtitleTranscodingTrackOutput != null) {
            return subtitleTranscodingTrackOutput;
        }
        SubtitleTranscodingTrackOutput subtitleTranscodingTrackOutput2 = new SubtitleTranscodingTrackOutput(this.delegate.track(i10, i11), this.subtitleParserFactory);
        this.textTrackOutputs.put(i10, subtitleTranscodingTrackOutput2);
        return subtitleTranscodingTrackOutput2;
    }
}
