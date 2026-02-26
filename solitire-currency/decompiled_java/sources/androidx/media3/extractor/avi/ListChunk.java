package androidx.media3.extractor.avi;

import androidx.annotation.Nullable;
import androidx.media3.common.util.ParsableByteArray;
import com.google.common.collect.i1;
import com.google.common.collect.y;

/* JADX INFO: loaded from: classes2.dex */
final class ListChunk implements AviChunk {
    public final y<AviChunk> children;
    private final int type;

    private ListChunk(int i10, y<AviChunk> yVar) {
        this.type = i10;
        this.children = yVar;
    }

    @Nullable
    private static AviChunk createBox(int i10, int i11, ParsableByteArray parsableByteArray) {
        switch (i10) {
            case AviExtractor.FOURCC_strf /* 1718776947 */:
                return StreamFormatChunk.parseFrom(i11, parsableByteArray);
            case AviExtractor.FOURCC_avih /* 1751742049 */:
                return AviMainHeaderChunk.parseFrom(parsableByteArray);
            case AviExtractor.FOURCC_strh /* 1752331379 */:
                return AviStreamHeaderChunk.parseFrom(parsableByteArray);
            case AviExtractor.FOURCC_strn /* 1852994675 */:
                return StreamNameChunk.parseFrom(parsableByteArray);
            default:
                return null;
        }
    }

    public static ListChunk parseFrom(int i10, ParsableByteArray parsableByteArray) {
        y.a aVar = new y.a();
        int iLimit = parsableByteArray.limit();
        int trackType = -2;
        while (parsableByteArray.bytesLeft() > 8) {
            int littleEndianInt = parsableByteArray.readLittleEndianInt();
            int position = parsableByteArray.getPosition() + parsableByteArray.readLittleEndianInt();
            parsableByteArray.setLimit(position);
            AviChunk from = littleEndianInt == 1414744396 ? parseFrom(parsableByteArray.readLittleEndianInt(), parsableByteArray) : createBox(littleEndianInt, trackType, parsableByteArray);
            if (from != null) {
                if (from.getType() == 1752331379) {
                    trackType = ((AviStreamHeaderChunk) from).getTrackType();
                }
                aVar.a(from);
            }
            parsableByteArray.setPosition(position);
            parsableByteArray.setLimit(iLimit);
        }
        return new ListChunk(i10, aVar.k());
    }

    @Nullable
    public <T extends AviChunk> T getChild(Class<T> cls) {
        i1<AviChunk> it = this.children.iterator();
        while (it.hasNext()) {
            T t10 = (T) it.next();
            if (t10.getClass() == cls) {
                return t10;
            }
        }
        return null;
    }

    @Override // androidx.media3.extractor.avi.AviChunk
    public int getType() {
        return this.type;
    }
}
