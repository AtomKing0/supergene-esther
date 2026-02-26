package androidx.media3.common.util;

import androidx.annotation.Nullable;
import com.google.common.collect.c0;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class ParsableByteArray {
    private static final char[] CR_AND_LF = {'\r', '\n'};
    private static final char[] LF = {'\n'};
    private static final c0<Charset> SUPPORTED_CHARSETS_FOR_READLINE = c0.u(e5.e.f25138a, e5.e.f25140c, e5.e.f25143f, e5.e.f25141d, e5.e.f25142e);
    private byte[] data;
    private int limit;
    private int position;

    public ParsableByteArray() {
        this.data = Util.EMPTY_BYTE_ARRAY;
    }

    private int findNextLineTerminator(Charset charset) {
        int i10;
        if (charset.equals(e5.e.f25140c) || charset.equals(e5.e.f25138a)) {
            i10 = 1;
        } else {
            if (!charset.equals(e5.e.f25143f) && !charset.equals(e5.e.f25142e) && !charset.equals(e5.e.f25141d)) {
                throw new IllegalArgumentException("Unsupported charset: " + charset);
            }
            i10 = 2;
        }
        int i11 = this.position;
        while (true) {
            int i12 = this.limit;
            if (i11 >= i12 - (i10 - 1)) {
                return i12;
            }
            if ((charset.equals(e5.e.f25140c) || charset.equals(e5.e.f25138a)) && Util.isLinebreak(this.data[i11])) {
                return i11;
            }
            if (charset.equals(e5.e.f25143f) || charset.equals(e5.e.f25141d)) {
                byte[] bArr = this.data;
                if (bArr[i11] == 0 && Util.isLinebreak(bArr[i11 + 1])) {
                    return i11;
                }
            }
            if (charset.equals(e5.e.f25142e)) {
                byte[] bArr2 = this.data;
                if (bArr2[i11 + 1] == 0 && Util.isLinebreak(bArr2[i11])) {
                    return i11;
                }
            }
            i11 += i10;
        }
    }

    private int peekCharacterAndSize(Charset charset) {
        byte bA;
        char c10;
        int i10 = 1;
        if ((charset.equals(e5.e.f25140c) || charset.equals(e5.e.f25138a)) && bytesLeft() >= 1) {
            bA = (byte) g5.b.a(g5.h.b(this.data[this.position]));
        } else {
            if ((charset.equals(e5.e.f25143f) || charset.equals(e5.e.f25141d)) && bytesLeft() >= 2) {
                byte[] bArr = this.data;
                int i11 = this.position;
                c10 = g5.b.c(bArr[i11], bArr[i11 + 1]);
            } else {
                if (!charset.equals(e5.e.f25142e) || bytesLeft() < 2) {
                    return 0;
                }
                byte[] bArr2 = this.data;
                int i12 = this.position;
                c10 = g5.b.c(bArr2[i12 + 1], bArr2[i12]);
            }
            bA = (byte) c10;
            i10 = 2;
        }
        return (g5.b.a(bA) << 16) + i10;
    }

    private char readCharacterIfInList(Charset charset, char[] cArr) {
        int iPeekCharacterAndSize = peekCharacterAndSize(charset);
        if (iPeekCharacterAndSize == 0) {
            return (char) 0;
        }
        char c10 = (char) (iPeekCharacterAndSize >> 16);
        if (!g5.b.b(cArr, c10)) {
            return (char) 0;
        }
        this.position += iPeekCharacterAndSize & 65535;
        return c10;
    }

    private void skipLineTerminator(Charset charset) {
        if (readCharacterIfInList(charset, CR_AND_LF) == '\r') {
            readCharacterIfInList(charset, LF);
        }
    }

    public int bytesLeft() {
        return this.limit - this.position;
    }

    public int capacity() {
        return this.data.length;
    }

    public void ensureCapacity(int i10) {
        if (i10 > capacity()) {
            this.data = Arrays.copyOf(this.data, i10);
        }
    }

    public byte[] getData() {
        return this.data;
    }

    public int getPosition() {
        return this.position;
    }

    public int limit() {
        return this.limit;
    }

    public char peekChar() {
        byte[] bArr = this.data;
        int i10 = this.position;
        return (char) ((bArr[i10 + 1] & 255) | ((bArr[i10] & 255) << 8));
    }

    public int peekUnsignedByte() {
        return this.data[this.position] & 255;
    }

    public void readBytes(ParsableBitArray parsableBitArray, int i10) {
        readBytes(parsableBitArray.data, 0, i10);
        parsableBitArray.setPosition(0);
    }

    @Nullable
    public String readDelimiterTerminatedString(char c10) {
        if (bytesLeft() == 0) {
            return null;
        }
        int i10 = this.position;
        while (i10 < this.limit && this.data[i10] != c10) {
            i10++;
        }
        byte[] bArr = this.data;
        int i11 = this.position;
        String strFromUtf8Bytes = Util.fromUtf8Bytes(bArr, i11, i10 - i11);
        this.position = i10;
        if (i10 < this.limit) {
            this.position = i10 + 1;
        }
        return strFromUtf8Bytes;
    }

    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    public int readInt() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        int i13 = ((bArr[i10] & 255) << 24) | ((bArr[i11] & 255) << 16);
        int i14 = i12 + 1;
        int i15 = i13 | ((bArr[i12] & 255) << 8);
        this.position = i14 + 1;
        return (bArr[i14] & 255) | i15;
    }

    public int readInt24() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        int i13 = (((bArr[i10] & 255) << 24) >> 8) | ((bArr[i11] & 255) << 8);
        this.position = i12 + 1;
        return (bArr[i12] & 255) | i13;
    }

    @Nullable
    public String readLine() {
        return readLine(e5.e.f25140c);
    }

    public int readLittleEndianInt() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        int i13 = (bArr[i10] & 255) | ((bArr[i11] & 255) << 8);
        int i14 = i12 + 1;
        int i15 = i13 | ((bArr[i12] & 255) << 16);
        this.position = i14 + 1;
        return ((bArr[i14] & 255) << 24) | i15;
    }

    public int readLittleEndianInt24() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        int i13 = (bArr[i10] & 255) | ((bArr[i11] & 255) << 8);
        this.position = i12 + 1;
        return ((bArr[i12] & 255) << 16) | i13;
    }

    public long readLittleEndianLong() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        long j10 = ((long) bArr[i10]) & 255;
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        long j11 = j10 | ((((long) bArr[i11]) & 255) << 8) | ((((long) bArr[i12]) & 255) << 16);
        int i14 = i13 + 1;
        long j12 = j11 | ((((long) bArr[i13]) & 255) << 24);
        int i15 = i14 + 1;
        long j13 = j12 | ((((long) bArr[i14]) & 255) << 32);
        int i16 = i15 + 1;
        long j14 = j13 | ((((long) bArr[i15]) & 255) << 40);
        int i17 = i16 + 1;
        long j15 = j14 | ((((long) bArr[i16]) & 255) << 48);
        this.position = i17 + 1;
        return j15 | ((((long) bArr[i17]) & 255) << 56);
    }

    public short readLittleEndianShort() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        int i12 = bArr[i10] & 255;
        this.position = i11 + 1;
        return (short) (((bArr[i11] & 255) << 8) | i12);
    }

    public long readLittleEndianUnsignedInt() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        long j10 = ((long) bArr[i10]) & 255;
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        long j11 = j10 | ((((long) bArr[i11]) & 255) << 8) | ((((long) bArr[i12]) & 255) << 16);
        this.position = i13 + 1;
        return j11 | ((((long) bArr[i13]) & 255) << 24);
    }

    public int readLittleEndianUnsignedInt24() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        int i13 = (bArr[i10] & 255) | ((bArr[i11] & 255) << 8);
        this.position = i12 + 1;
        return ((bArr[i12] & 255) << 16) | i13;
    }

    public int readLittleEndianUnsignedIntToInt() {
        int littleEndianInt = readLittleEndianInt();
        if (littleEndianInt >= 0) {
            return littleEndianInt;
        }
        throw new IllegalStateException("Top bit not zero: " + littleEndianInt);
    }

    public int readLittleEndianUnsignedShort() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        int i12 = bArr[i10] & 255;
        this.position = i11 + 1;
        return ((bArr[i11] & 255) << 8) | i12;
    }

    public long readLong() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        long j10 = (((long) bArr[i10]) & 255) << 56;
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        long j11 = j10 | ((((long) bArr[i11]) & 255) << 48) | ((((long) bArr[i12]) & 255) << 40);
        int i14 = i13 + 1;
        long j12 = j11 | ((((long) bArr[i13]) & 255) << 32);
        int i15 = i14 + 1;
        long j13 = j12 | ((((long) bArr[i14]) & 255) << 24);
        int i16 = i15 + 1;
        long j14 = j13 | ((((long) bArr[i15]) & 255) << 16);
        int i17 = i16 + 1;
        long j15 = j14 | ((((long) bArr[i16]) & 255) << 8);
        this.position = i17 + 1;
        return j15 | (((long) bArr[i17]) & 255);
    }

    public String readNullTerminatedString(int i10) {
        if (i10 == 0) {
            return "";
        }
        int i11 = this.position;
        int i12 = (i11 + i10) - 1;
        String strFromUtf8Bytes = Util.fromUtf8Bytes(this.data, i11, (i12 >= this.limit || this.data[i12] != 0) ? i10 : i10 - 1);
        this.position += i10;
        return strFromUtf8Bytes;
    }

    public short readShort() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        int i12 = (bArr[i10] & 255) << 8;
        this.position = i11 + 1;
        return (short) ((bArr[i11] & 255) | i12);
    }

    public String readString(int i10) {
        return readString(i10, e5.e.f25140c);
    }

    public int readSynchSafeInt() {
        return (readUnsignedByte() << 21) | (readUnsignedByte() << 14) | (readUnsignedByte() << 7) | readUnsignedByte();
    }

    public int readUnsignedByte() {
        byte[] bArr = this.data;
        int i10 = this.position;
        this.position = i10 + 1;
        return bArr[i10] & 255;
    }

    public int readUnsignedFixedPoint1616() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        int i12 = (bArr[i11] & 255) | ((bArr[i10] & 255) << 8);
        this.position = i11 + 1 + 2;
        return i12;
    }

    public long readUnsignedInt() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        long j10 = (((long) bArr[i10]) & 255) << 24;
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        long j11 = j10 | ((((long) bArr[i11]) & 255) << 16) | ((((long) bArr[i12]) & 255) << 8);
        this.position = i13 + 1;
        return j11 | (((long) bArr[i13]) & 255);
    }

    public int readUnsignedInt24() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        int i13 = ((bArr[i10] & 255) << 16) | ((bArr[i11] & 255) << 8);
        this.position = i12 + 1;
        return (bArr[i12] & 255) | i13;
    }

    public int readUnsignedIntToInt() {
        int i10 = readInt();
        if (i10 >= 0) {
            return i10;
        }
        throw new IllegalStateException("Top bit not zero: " + i10);
    }

    public long readUnsignedLongToLong() {
        long j10 = readLong();
        if (j10 >= 0) {
            return j10;
        }
        throw new IllegalStateException("Top bit not zero: " + j10);
    }

    public int readUnsignedShort() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        int i12 = (bArr[i10] & 255) << 8;
        this.position = i11 + 1;
        return (bArr[i11] & 255) | i12;
    }

    public long readUtf8EncodedLong() {
        int i10;
        int i11;
        long j10 = this.data[this.position];
        int i12 = 7;
        while (true) {
            if (i12 < 0) {
                break;
            }
            int i13 = 1 << i12;
            if ((((long) i13) & j10) != 0) {
                i12--;
            } else if (i12 < 6) {
                j10 &= (long) (i13 - 1);
                i11 = 7 - i12;
            } else if (i12 == 7) {
                i11 = 1;
            }
        }
        i11 = 0;
        if (i11 == 0) {
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j10);
        }
        for (i10 = 1; i10 < i11; i10++) {
            byte b10 = this.data[this.position + i10];
            if ((b10 & 192) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j10);
            }
            j10 = (j10 << 6) | ((long) (b10 & 63));
        }
        this.position += i11;
        return j10;
    }

    @Nullable
    public Charset readUtfCharsetFromBom() {
        if (bytesLeft() >= 3) {
            byte[] bArr = this.data;
            int i10 = this.position;
            if (bArr[i10] == -17 && bArr[i10 + 1] == -69 && bArr[i10 + 2] == -65) {
                this.position = i10 + 3;
                return e5.e.f25140c;
            }
        }
        if (bytesLeft() < 2) {
            return null;
        }
        byte[] bArr2 = this.data;
        int i11 = this.position;
        byte b10 = bArr2[i11];
        if (b10 == -2 && bArr2[i11 + 1] == -1) {
            this.position = i11 + 2;
            return e5.e.f25141d;
        }
        if (b10 != -1 || bArr2[i11 + 1] != -2) {
            return null;
        }
        this.position = i11 + 2;
        return e5.e.f25142e;
    }

    public void reset(int i10) {
        reset(capacity() < i10 ? new byte[i10] : this.data, i10);
    }

    public void setLimit(int i10) {
        Assertions.checkArgument(i10 >= 0 && i10 <= this.data.length);
        this.limit = i10;
    }

    public void setPosition(int i10) {
        Assertions.checkArgument(i10 >= 0 && i10 <= this.limit);
        this.position = i10;
    }

    public void skipBytes(int i10) {
        setPosition(this.position + i10);
    }

    public char peekChar(Charset charset) {
        Assertions.checkArgument(SUPPORTED_CHARSETS_FOR_READLINE.contains(charset), "Unsupported charset: " + charset);
        return (char) (peekCharacterAndSize(charset) >> 16);
    }

    @Nullable
    public String readLine(Charset charset) {
        Assertions.checkArgument(SUPPORTED_CHARSETS_FOR_READLINE.contains(charset), "Unsupported charset: " + charset);
        if (bytesLeft() == 0) {
            return null;
        }
        if (!charset.equals(e5.e.f25138a)) {
            readUtfCharsetFromBom();
        }
        String string = readString(findNextLineTerminator(charset) - this.position, charset);
        if (this.position == this.limit) {
            return string;
        }
        skipLineTerminator(charset);
        return string;
    }

    public String readString(int i10, Charset charset) {
        String str = new String(this.data, this.position, i10, charset);
        this.position += i10;
        return str;
    }

    public void reset(byte[] bArr) {
        reset(bArr, bArr.length);
    }

    public ParsableByteArray(int i10) {
        this.data = new byte[i10];
        this.limit = i10;
    }

    public void readBytes(byte[] bArr, int i10, int i11) {
        System.arraycopy(this.data, this.position, bArr, i10, i11);
        this.position += i11;
    }

    public void reset(byte[] bArr, int i10) {
        this.data = bArr;
        this.limit = i10;
        this.position = 0;
    }

    public void readBytes(ByteBuffer byteBuffer, int i10) {
        byteBuffer.put(this.data, this.position, i10);
        this.position += i10;
    }

    @Nullable
    public String readNullTerminatedString() {
        return readDelimiterTerminatedString((char) 0);
    }

    public ParsableByteArray(byte[] bArr) {
        this.data = bArr;
        this.limit = bArr.length;
    }

    public ParsableByteArray(byte[] bArr, int i10) {
        this.data = bArr;
        this.limit = i10;
    }
}
