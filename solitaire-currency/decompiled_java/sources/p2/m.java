package p2;

import java.io.IOException;

/* JADX INFO: compiled from: ExtractorInput.java */
/* JADX INFO: loaded from: classes2.dex */
public interface m extends z3.h {
    void advancePeekPosition(int i10) throws IOException;

    boolean advancePeekPosition(int i10, boolean z10) throws IOException;

    long getLength();

    long getPeekPosition();

    long getPosition();

    int peek(byte[] bArr, int i10, int i11) throws IOException;

    void peekFully(byte[] bArr, int i10, int i11) throws IOException;

    boolean peekFully(byte[] bArr, int i10, int i11, boolean z10) throws IOException;

    @Override // z3.h
    int read(byte[] bArr, int i10, int i11) throws IOException;

    void readFully(byte[] bArr, int i10, int i11) throws IOException;

    boolean readFully(byte[] bArr, int i10, int i11, boolean z10) throws IOException;

    void resetPeekPosition();

    int skip(int i10) throws IOException;

    void skipFully(int i10) throws IOException;
}
