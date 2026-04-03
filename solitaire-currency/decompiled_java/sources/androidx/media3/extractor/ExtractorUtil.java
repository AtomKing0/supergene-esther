package androidx.media3.extractor;

import androidx.annotation.Nullable;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.UnstableApi;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public final class ExtractorUtil {
    private ExtractorUtil() {
    }

    public static void checkContainerInput(boolean z10, @Nullable String str) throws ParserException {
        if (!z10) {
            throw ParserException.createForMalformedContainer(str, null);
        }
    }

    public static boolean peekFullyQuietly(ExtractorInput extractorInput, byte[] bArr, int i10, int i11, boolean z10) throws IOException {
        try {
            return extractorInput.peekFully(bArr, i10, i11, z10);
        } catch (EOFException e10) {
            if (z10) {
                return false;
            }
            throw e10;
        }
    }

    public static int peekToLength(ExtractorInput extractorInput, byte[] bArr, int i10, int i11) throws IOException {
        int i12 = 0;
        while (i12 < i11) {
            int iPeek = extractorInput.peek(bArr, i10 + i12, i11 - i12);
            if (iPeek == -1) {
                break;
            }
            i12 += iPeek;
        }
        return i12;
    }

    public static boolean readFullyQuietly(ExtractorInput extractorInput, byte[] bArr, int i10, int i11) throws IOException {
        try {
            extractorInput.readFully(bArr, i10, i11);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean skipFullyQuietly(ExtractorInput extractorInput, int i10) throws IOException {
        try {
            extractorInput.skipFully(i10);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
