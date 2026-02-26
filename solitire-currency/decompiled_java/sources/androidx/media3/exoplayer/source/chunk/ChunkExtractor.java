package androidx.media3.exoplayer.source.chunk;

import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.text.SubtitleParser;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public interface ChunkExtractor {

    public interface Factory {
        @Nullable
        ChunkExtractor createProgressiveMediaExtractor(int i10, Format format, boolean z10, List<Format> list, @Nullable TrackOutput trackOutput, PlayerId playerId);

        Factory experimentalParseSubtitlesDuringExtraction(boolean z10);

        Format getOutputTextFormat(Format format);

        Factory setSubtitleParserFactory(SubtitleParser.Factory factory);
    }

    public interface TrackOutputProvider {
        TrackOutput track(int i10, int i11);
    }

    @Nullable
    ChunkIndex getChunkIndex();

    @Nullable
    Format[] getSampleFormats();

    void init(@Nullable TrackOutputProvider trackOutputProvider, long j10, long j11);

    boolean read(ExtractorInput extractorInput) throws IOException;

    void release();
}
