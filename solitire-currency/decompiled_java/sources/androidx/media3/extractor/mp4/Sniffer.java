package androidx.media3.extractor.mp4;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorInput;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
final class Sniffer {
    public static final int BRAND_HEIC = 1751476579;
    public static final int BRAND_QUICKTIME = 1903435808;
    private static final int[] COMPATIBLE_BRANDS = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, Atom.TYPE_avc1, Atom.TYPE_hvc1, Atom.TYPE_hev1, Atom.TYPE_av01, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, BRAND_QUICKTIME, 1297305174, 1684175153, 1769172332, 1885955686};
    private static final int SEARCH_LENGTH = 4096;

    private Sniffer() {
    }

    private static boolean isCompatibleBrand(int i10, boolean z10) {
        if ((i10 >>> 8) == 3368816) {
            return true;
        }
        if (i10 == 1751476579 && z10) {
            return true;
        }
        for (int i11 : COMPATIBLE_BRANDS) {
            if (i11 == i10) {
                return true;
            }
        }
        return false;
    }

    public static boolean sniffFragmented(ExtractorInput extractorInput) throws IOException {
        return sniffInternal(extractorInput, true, false);
    }

    private static boolean sniffInternal(ExtractorInput extractorInput, boolean z10, boolean z11) throws IOException {
        boolean z12;
        boolean z13;
        boolean z14;
        int i10;
        int i11;
        boolean z15;
        boolean z16;
        long length = extractorInput.getLength();
        long j10 = -1;
        int i12 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        long j11 = 4096;
        if (i12 != 0 && length <= 4096) {
            j11 = length;
        }
        int i13 = (int) j11;
        ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        boolean z17 = false;
        int i14 = 0;
        boolean z18 = false;
        while (i14 < i13) {
            parsableByteArray.reset(8);
            if (!extractorInput.peekFully(parsableByteArray.getData(), z17 ? 1 : 0, 8, true)) {
                break;
            }
            long unsignedInt = parsableByteArray.readUnsignedInt();
            int i15 = parsableByteArray.readInt();
            if (unsignedInt == 1) {
                extractorInput.peekFully(parsableByteArray.getData(), 8, 8);
                parsableByteArray.setLimit(16);
                i10 = 16;
                unsignedInt = parsableByteArray.readLong();
            } else {
                if (unsignedInt == 0) {
                    long length2 = extractorInput.getLength();
                    if (length2 != j10) {
                        unsignedInt = (length2 - extractorInput.getPeekPosition()) + ((long) 8);
                    }
                }
                i10 = 8;
            }
            long j12 = i10;
            if (unsignedInt < j12) {
                return z17;
            }
            i14 += i10;
            if (i15 == 1836019574) {
                i13 += (int) unsignedInt;
                if (i12 != 0 && i13 > length) {
                    i13 = (int) length;
                }
            } else {
                if (i15 == 1836019558 || i15 == 1836475768) {
                    z12 = z17 ? 1 : 0;
                    z13 = true;
                    z14 = true;
                    break;
                }
                if (i15 == 1835295092) {
                    i11 = i12;
                    z18 = true;
                } else {
                    i11 = i12;
                }
                if ((((long) i14) + unsignedInt) - j12 >= i13) {
                    z14 = false;
                    z12 = false;
                    z13 = true;
                    break;
                }
                int i16 = (int) (unsignedInt - j12);
                i14 += i16;
                if (i15 != 1718909296) {
                    z15 = false;
                    if (i16 != 0) {
                        extractorInput.advancePeekPosition(i16);
                    }
                } else {
                    if (i16 < 8) {
                        return false;
                    }
                    parsableByteArray.reset(i16);
                    extractorInput.peekFully(parsableByteArray.getData(), 0, i16);
                    int i17 = i16 / 4;
                    int i18 = 0;
                    while (true) {
                        if (i18 >= i17) {
                            z16 = z18;
                            break;
                        }
                        if (i18 == 1) {
                            parsableByteArray.skipBytes(4);
                        } else if (isCompatibleBrand(parsableByteArray.readInt(), z11)) {
                            z16 = true;
                            break;
                        }
                        i18++;
                    }
                    if (!z16) {
                        return false;
                    }
                    z15 = false;
                    z18 = z16;
                }
                z17 = z15;
                i12 = i11;
            }
            j10 = -1;
        }
        z12 = z17 ? 1 : 0;
        z13 = true;
        z14 = z12 ? 1 : 0;
        return (z18 && z10 == z14) ? z13 : z12;
    }

    public static boolean sniffUnfragmented(ExtractorInput extractorInput) throws IOException {
        return sniffInternal(extractorInput, false, false);
    }

    public static boolean sniffUnfragmented(ExtractorInput extractorInput, boolean z10) throws IOException {
        return sniffInternal(extractorInput, false, z10);
    }
}
