package p2;

import java.io.IOException;

/* JADX INFO: compiled from: ForwardingExtractorInput.java */
/* JADX INFO: loaded from: classes2.dex */
public class w implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f32546a;

    public w(m mVar) {
        this.f32546a = mVar;
    }

    @Override // p2.m
    public boolean advancePeekPosition(int i10, boolean z10) throws IOException {
        return this.f32546a.advancePeekPosition(i10, z10);
    }

    @Override // p2.m
    public long getLength() {
        return this.f32546a.getLength();
    }

    @Override // p2.m
    public long getPeekPosition() {
        return this.f32546a.getPeekPosition();
    }

    @Override // p2.m
    public long getPosition() {
        return this.f32546a.getPosition();
    }

    @Override // p2.m
    public int peek(byte[] bArr, int i10, int i11) throws IOException {
        return this.f32546a.peek(bArr, i10, i11);
    }

    @Override // p2.m
    public boolean peekFully(byte[] bArr, int i10, int i11, boolean z10) throws IOException {
        return this.f32546a.peekFully(bArr, i10, i11, z10);
    }

    @Override // p2.m, z3.h
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        return this.f32546a.read(bArr, i10, i11);
    }

    @Override // p2.m
    public boolean readFully(byte[] bArr, int i10, int i11, boolean z10) throws IOException {
        return this.f32546a.readFully(bArr, i10, i11, z10);
    }

    @Override // p2.m
    public void resetPeekPosition() {
        this.f32546a.resetPeekPosition();
    }

    @Override // p2.m
    public int skip(int i10) throws IOException {
        return this.f32546a.skip(i10);
    }

    @Override // p2.m
    public void skipFully(int i10) throws IOException {
        this.f32546a.skipFully(i10);
    }

    @Override // p2.m
    public void advancePeekPosition(int i10) throws IOException {
        this.f32546a.advancePeekPosition(i10);
    }

    @Override // p2.m
    public void peekFully(byte[] bArr, int i10, int i11) throws IOException {
        this.f32546a.peekFully(bArr, i10, i11);
    }

    @Override // p2.m
    public void readFully(byte[] bArr, int i10, int i11) throws IOException {
        this.f32546a.readFully(bArr, i10, i11);
    }
}
