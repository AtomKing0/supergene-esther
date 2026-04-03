package androidx.media3.extractor.mp3;

import androidx.annotation.Nullable;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.MpegAudioUtil;

/* JADX INFO: loaded from: classes2.dex */
final class XingFrame {
    private static final String TAG = "XingHeader";
    public final long dataSize;
    public final int encoderDelay;
    public final int encoderPadding;
    public final long frameCount;
    public final MpegAudioUtil.Header header;

    @Nullable
    public final long[] tableOfContents;

    private XingFrame(MpegAudioUtil.Header header, long j10, long j11, @Nullable long[] jArr, int i10, int i11) {
        this.header = header;
        this.frameCount = j10;
        this.dataSize = j11;
        this.tableOfContents = jArr;
        this.encoderDelay = i10;
        this.encoderPadding = i11;
    }

    public static XingFrame parse(MpegAudioUtil.Header header, ParsableByteArray parsableByteArray) {
        long[] jArr;
        int i10;
        int i11;
        int i12 = header.samplesPerFrame;
        int i13 = parsableByteArray.readInt();
        int unsignedIntToInt = (i13 & 1) != 0 ? parsableByteArray.readUnsignedIntToInt() : -1;
        long unsignedInt = (i13 & 2) != 0 ? parsableByteArray.readUnsignedInt() : -1L;
        if ((i13 & 4) == 4) {
            long[] jArr2 = new long[100];
            for (int i14 = 0; i14 < 100; i14++) {
                jArr2[i14] = parsableByteArray.readUnsignedByte();
            }
            jArr = jArr2;
        } else {
            jArr = null;
        }
        if ((i13 & 8) != 0) {
            parsableByteArray.skipBytes(4);
        }
        if (parsableByteArray.bytesLeft() >= 24) {
            parsableByteArray.skipBytes(21);
            int unsignedInt24 = parsableByteArray.readUnsignedInt24();
            i11 = unsignedInt24 & 4095;
            i10 = (16773120 & unsignedInt24) >> 12;
        } else {
            i10 = -1;
            i11 = -1;
        }
        return new XingFrame(header, unsignedIntToInt, unsignedInt, jArr, i10, i11);
    }
}
